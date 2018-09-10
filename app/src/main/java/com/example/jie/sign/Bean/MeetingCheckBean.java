package com.example.jie.sign.Bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by YX on 2018/9/8.
 */

public class MeetingCheckBean implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.address);
        dest.writeString(this.time);
        dest.writeByte(this.sign ? (byte) 1 : (byte) 0);
    }

    protected MeetingCheckBean(Parcel in) {
        this.name = in.readString();
        this.address = in.readString();
        this.time = in.readString();
        this.sign = in.readByte() != 0;
    }

    public static final Parcelable.Creator<MeetingCheckBean> CREATOR = new Parcelable.Creator<MeetingCheckBean>() {
        @Override
        public MeetingCheckBean createFromParcel(Parcel source) {
            return new MeetingCheckBean(source);
        }

        @Override
        public MeetingCheckBean[] newArray(int size) {
            return new MeetingCheckBean[size];
        }
    };
}
