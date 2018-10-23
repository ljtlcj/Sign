package com.example.jie.sign.Bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jie on 2018/10/23.
 */

public class AllMemberBean implements Parcelable {

    /**
     * phonelong : 333
     * phoneshort : 333
     * meeting_member : 姚喜
     */

    private String phonelong;
    private String phoneshort;
    private String meeting_member;

    public static AllMemberBean objectFromData(String str) {

        return new Gson().fromJson(str, AllMemberBean.class);
    }

    public static List<AllMemberBean> arrayAllMemberBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<AllMemberBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getPhonelong() {
        return phonelong;
    }

    public void setPhonelong(String phonelong) {
        this.phonelong = phonelong;
    }

    public String getPhoneshort() {
        return phoneshort;
    }

    public void setPhoneshort(String phoneshort) {
        this.phoneshort = phoneshort;
    }

    public String getMeeting_member() {
        return meeting_member;
    }

    public void setMeeting_member(String meeting_member) {
        this.meeting_member = meeting_member;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.phonelong);
        dest.writeString(this.phoneshort);
        dest.writeString(this.meeting_member);
    }

    public AllMemberBean() {
    }

    protected AllMemberBean(Parcel in) {
        this.phonelong = in.readString();
        this.phoneshort = in.readString();
        this.meeting_member = in.readString();
    }

    public static final Parcelable.Creator<AllMemberBean> CREATOR = new Parcelable.Creator<AllMemberBean>() {
        @Override
        public AllMemberBean createFromParcel(Parcel source) {
            return new AllMemberBean(source);
        }

        @Override
        public AllMemberBean[] newArray(int size) {
            return new AllMemberBean[size];
        }
    };
}
