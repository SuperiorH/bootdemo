package com.example.demo.proxy.factory;


public class Test1 {
    //    static int ONE_MB = 1024*1024;
    public static void main(String[] args) {
//        List<ByteBuffer> list = new ArrayList<>();
//        for(int i=0; i<ONE_MB;++i){
//            ByteBuffer buffer = ByteBuffer.allocateDirect(ONE_MB*128);
//            list.add(buffer);
//            System.out.println("分派第"+(i+1)+" 个128MB");
//        }
        Double d1 = 1.1;
        Double d2 = 1.1;
        System.out.println(d1 == d2);
        System.out.println(d1.equals(d2));
    }


    private static void fun() {
        fun();
    }


}
