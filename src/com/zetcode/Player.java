package com.zetcode;

public class Player {
    Data data;

    Player(Data data){
        this.data = data;
    }

    protected void move() {
        for (data.setIndex(data.getDots()); data.getIndex() > 0; data.setIndex(data.getIndex() - 1)) {
            data.setTmpIndex(data.getIndex() - 1);
            data.setTmpX();
            data.setTmpY();
//            x[z] = x[(z - 1)];
//            y[z] = y[(z - 1)];
        }
        if (data.leftDirection) {
            data.setIndex(0);
            data.setValue(data.getX() - data.getSizeDot());
            data.setX();
//            x[0] -= data.getDots();
        }
        if (data.rightDirection) {
            data.setIndex(0);
            data.setValue(data.getX() + data.getSizeDot());
            data.setX();
//            x[0] += DOT_SIZE;
        }
        if (data.upDirection) {
            data.setIndex(0);
            data.setValue(data.getY() - data.getSizeDot());
            data.setY();
//            y[0] -= DOT_SIZE;
        }
        if (data.downDirection) {
            data.setIndex(0);
            data.setValue(data.getY() + data.getSizeDot());
            data.setY();
//            y[0] += DOT_SIZE;
        }
    }
}
