package com.example.jie.sign.Bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jie on 2018/9/9.
 */

public class DialogMemberBean implements Parcelable {
    private String id;
    private String name;
    private String number;
    private boolean isSelector = false;

    public boolean isSelector() {
        return isSelector;
    }

    public void setSelector(boolean selector) {
        isSelector = selector;
    }

    public DialogMemberBean(String name, String number,String id) {
        this.name = name;
        this.number = number;
        this.id = id;
    }

    public DialogMemberBean() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.number);
        dest.writeString(this.id);
    }

    protected DialogMemberBean(Parcel in) {
        this.name = in.readString();
        this.number = in.readString();
        this.id=in.readString();
    }

    public static final Parcelable.Creator<DialogMemberBean> CREATOR = new Parcelable.Creator<DialogMemberBean>() {
        @Override
        public DialogMemberBean createFromParcel(Parcel source) {
            return new DialogMemberBean(source);
        }

        @Override
        public DialogMemberBean[] newArray(int size) {
            return new DialogMemberBean[size];
        }
    };
}
