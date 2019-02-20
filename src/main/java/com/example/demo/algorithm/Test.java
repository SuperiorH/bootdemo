package com.example.demo.algorithm;

public class Test {
    private static final ThreadLocal<Integer> TL_INT = ThreadLocal.withInitial(() -> 6);
    private static final ThreadLocal<String> TL_STRING = ThreadLocal.withInitial(() -> "Hello, world");

    public static void main(String... args) {
//        // 6
//        System.out.println(TL_INT.get());
//        TL_INT.set(TL_INT.get() + 1);
//        // 7
//        System.out.println(TL_INT.get());
//        TL_INT.remove();
//        // 会重新初始化该value，6
//        System.out.println(TL_INT.get());
//        System.out.println("*************");
//        Runnable runnable = ()->System.out.println("当前的线程:"+Thread.currentThread().getName());
//        Thread t = new Thread(runnable,"Thread1");
//        System.out.println(t);
//        Calendar c = Calendar.getInstance();
//        c.setTime(new Date());
//        c.add(Calendar.DATE,5);
//        System.out.println(c.getTime());
        modify(b);
        System.out.println(b);
    }

    private static int b;

    public static void modify(int a) {
        a++;
    }

}
