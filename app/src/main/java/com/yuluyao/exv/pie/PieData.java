package com.yuluyao.exv.pie;

public class PieData {

    private String name;
    private float value;
    private float angle;

    public PieData(String name, float value, float angle) {
        this.name = name;
        this.value = value;
        this.angle = angle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}
