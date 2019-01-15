package com.example.demo.test;

import java.io.*;

public class Test1 implements Serializable {

    private transient String name;
    private int age;
    static String address = "江苏省";

    public Test1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "D:" + File.separator + "1.txt";
        Test1 t = new Test1("Joe", 18);
        System.out.println(t.address);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(t);
        System.out.println("=======这是分割线======");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Test1 tt = (Test1) ois.readObject();
        System.out.println(tt);
        System.out.println(tt.address);
    }

}
