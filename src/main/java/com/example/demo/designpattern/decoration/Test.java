package com.example.demo.designpattern.decoration;

public class Test {
    public static void main(String[] args) {
        Play basket = new PlayBasketball();
        System.out.println(basket.getName());
        System.out.println(basket.getDescription());
        PlayDecoration decoration1 = new PlayDecorationImpl1(basket);
        System.out.println(decoration1.getName());
        System.out.println(decoration1.getDescription());
        PlayDecoration decoration2 = new PlayDecorationImpl2(basket);
        System.out.println(decoration2.getName());
        System.out.println(decoration2.getDescription());
        System.out.println("===这是分割线===");
        Play foot = new PlayFootball();
        System.out.println(foot.getName());
        System.out.println(foot.getDescription());
        PlayDecoration decoration3 = new PlayDecorationImpl1(foot);
        System.out.println(decoration3.getName());
        System.out.println(decoration3.getDescription());
        PlayDecoration decoration4 = new PlayDecorationImpl2(foot);
        System.out.println(decoration4.getName());
        System.out.println(decoration4.getDescription());

    }
}
