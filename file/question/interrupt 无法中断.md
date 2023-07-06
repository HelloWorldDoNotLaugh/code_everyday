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

出现死循环；

```java
public static void main(String[] args) {
        Thread thread = new Thread(() -> {
        });
        while (!thread.isInterrupted()){
            System.out.println("将线程标记为设置为true");
            thread.start();
            thread.interrupt();
            System.out.println(thread.isInterrupted());
        }
    }
```

start 在循环里面，这样又不会死循环。。。

## 解决

```java
 public static void main(String[] args) {
        Thread thread = new Thread(() -> {
        });
        thread.start();
        thread.interrupt();
        System.out.println(Thread.currentThread().getName() + " " + thread.isInterrupted());
        System.out.println(Thread.currentThread().getName() + " " + thread.isInterrupted());
    }
```

虽然我们在第一次输出中中断了线程并将其中断状态设置为`true`，但是在第二次输出中，由于线程已经被中断并且中断状态被重置为`false`，所以我们看到了不同的输出结果。

也就是说，当中断被响应后，中断标记就会被重置。

## 结论

如果线程已经执行完毕，准确说应该是线程不处于运行状态时，interrupt会出现假失效现象。
