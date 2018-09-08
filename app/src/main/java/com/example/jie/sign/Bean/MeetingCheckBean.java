package com.example.jie.sign.Bean;

/**
 * Created by YX on 2018/9/8.
 */

public class MeetingCheckBean {
    private String name;
    private String address;
    private String time;
    private boolean sign;//是否会议已经开过

    public MeetingCheckBean(String name, String address, String time, boolean sign) {
        this.name = name;
        this.address = address;
        this.time = time;
        this.sign = sign;
    }

    public boolean isSign() {
        return sign;
    }

    public void setSign(boolean sign) {
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
