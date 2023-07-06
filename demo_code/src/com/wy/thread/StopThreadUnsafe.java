package com.wy.thread;

/**
 * @author HelloWorld
 * @create 2022/11/12 09:21
 * @email helloworld.dng@gmail.com
 */
public class StopThreadUnsafe {
    public static User user = new User();

    public static class User {
        private int id;
        private String name;

        public User() {
        }

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class  ChangeObjectThread extends Thread {
        volatile boolean stopMeFlag = false;
        public void stopMe() {
            this.stopMeFlag = true;
        }
        @Override
        public void run(){
            for(;;) {
                if (stopMeFlag) {
                    System.out.println("exit by stop me");
                    break;
                }
                synchronized (user) {
                    int v = (int)(System.currentTimeMillis() / 1000);
                    user.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread {
        @Override
        public void run() {
            for (;;) {
                synchronized (user) {
                    if (user.getId() != Integer.parseInt(user.getName())) {
                        System.out.println("Error: " + user.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        int v = (int)(System.currentTimeMillis() / 1000);
        user.setId(v);
        user.setName(String.valueOf(v));
        new ReadObjectThread().start();

        while (true) {
            ChangeObjectThread changeObjectThread = new ChangeObjectThread();
            changeObjectThread.start();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 如果直接调用stop方法终止线程，会立即释放该线程所持有的锁，而这些锁是维持对象的一致性的关键；
            //changeObjectThread.stop();

            changeObjectThread.stopMe();
        }
    }
}
