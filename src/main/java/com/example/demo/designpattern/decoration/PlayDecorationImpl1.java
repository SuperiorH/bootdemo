package com.example.demo.designpattern.decoration;

public class PlayDecorationImpl1 implements PlayDecoration {

    private Play play;

    public PlayDecorationImpl1(Play play) {
        this.play = play;
    }

    private String getDecoration() {
        return "打";
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
