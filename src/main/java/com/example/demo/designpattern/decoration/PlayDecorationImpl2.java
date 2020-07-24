package com.example.demo.designpattern.decoration;

public class PlayDecorationImpl2 implements PlayDecoration {

    private Play play;

    public PlayDecorationImpl2(Play play) {
        this.play = play;
    }

    private String getDecoration() {
        return "吃";
    }

    @Override
    public String getName() {
        return getDecoration() + play.getName();
    }

    @Override
    public String getDescription() {
        return getDecoration() + play.getDescription();
    }


}
