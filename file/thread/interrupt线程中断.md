> java中一般不会强制去停止一个线程，所以stop方法会被Deprecated。通常会使用 interrupt去尝试中断线程，但也只是将中断标记为设置为true，并不会立即停止线程

## 3个方法

* interrupt，实例方法。设置中断标志为为 true；
* interrupted, 静态方法。返回当前线程的中断标记为，并清除线程标记
* isInterrupted, 实例方法，判断当前线程是否被中断。

## ⚠️注意

* 当一个线程的中断标记为true时，调用sleep方法会抛出 **InterruptedException**，并且会清空中断标记

* 当一个线程sleep时，调用interrupt，也会抛出**InterruptedException**,并且设置中断标记位失败。
* 所以当catch到InterruptedException，正确的做法是再次 interrupt 来确保中断。

```java
 public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            int count = 0;
            while (!Thread.currentThread().isInterrupted() && count < 30) {
                System.out.println(String.format("name: %s, interrupt: %s, %s", Thread.currentThread().getName(), Thread.currentThread().isInterrupted(), count++));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // 抛出异常的同时会清除中断标记位，即将 interrupt再设置为false
                    System.out.println("thread1 sleep期间 被尝试中断了");
                }
            }
        }, "thread1");
        System.out.println("准备开启子线程 thread1");

        thread1.start();

        System.out.println("thread1开始执行");

        while (!thread1.isInterrupted()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("休眠主线程异常");
            }finally {
                System.out.println("将thread1的interrupt设置为true");
                thread1.interrupt();
                System.out.println("thread1的 interrupt 状态为" + thread1.isInterrupted());
            }
        }
        
        System.out.println("thread1的 interrupt 状态为" + thread1.isInterrupted());

    }
```

最后的count大概率会是29，也就是在主线程设置中断标记为失败

```java
public static void main(String[] args) {
        Thread thread = new Thread(() -> {
        });
        thread.start();
        while (!thread.isInterrupted()){
            System.out.println("将线程标记为设置为true");
            thread.interrupt();
            System.out.println(thread.isInterrupted());
        }
    } 
```

这将产生一个死循环，因为 thread已经运行结束了，不处于运行状态了，interrupt后会立即被重置。

