# 为什么wait 必须在 synchronized保护的同步代码块中使用

```java
 private Queue<String> buffer = new LinkedList<>();

    public void give(String data) {
       synchronized (this) {
           buffer.add(data);
           notify();
       }
    }

    public String take() throws Exception{
        synchronized (this) {
            while (buffer.isEmpty()) {
                wait();
            }
        }
        String poll = buffer.poll();
        System.out.println(poll);
        return poll;
    }

    public static void main(String[] args) {
        WaitTest waitTest = new WaitTest();
        Thread consumer = new Thread(() -> {
            try {
                waitTest.take();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Thread producer = new Thread(() -> waitTest.give("1"));

        consumer.start();
        producer.start();
    }
```

## 如果不在 synchronized中

当消费者线程判断出 buffer is null 的同时，生产者线程也开始了执行，并且 notify在 wait前执行。就会导致消费者线程永远不会唤醒。

而采用synchronized可以保证消费者线程中的while判断和wait是一个原子操作，在while判断后与wait执行前，确保 notify不会被执行。