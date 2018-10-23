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

public class Stuff implements Parcelable {

    /**
     * id : 35
     * card : 333
     * name : 姚喜
     * branch : 333
     * classroom : 333
     * duty : 333
     * phonelong : 333
     * phoneshort : 333
     * status : 1
     */

    private String id;
    private String card;
    private String name;
    private String branch;
    private String classroom;
    private String duty;
    private String phonelong;
    private String phoneshort;
    private String status;

    public static Stuff objectFromData(String str) {

        return new Gson().fromJson(str, Stuff.class);
    }

    public static List<Stuff> arrayStuffFromData(String str) {

        Type listType = new TypeToken<ArrayList<Stuff>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.card);
        dest.writeString(this.name);
        dest.writeString(this.branch);
        dest.writeString(this.classroom);
        dest.writeString(this.duty);
        dest.writeString(this.phonelong);
        dest.writeString(this.phoneshort);
        dest.writeString(this.status);
    }

    public Stuff() {
    }

    protected Stuff(Parcel in) {
        this.id = in.readString();
        this.card = in.readString();
        this.name = in.readString();
        this.branch = in.readString();
        this.classroom = in.readString();
        this.duty = in.readString();
        this.phonelong = in.readString();
        this.phoneshort = in.readString();
        this.status = in.readString();
    }

    public static final Parcelable.Creator<Stuff> CREATOR = new Parcelable.Creator<Stuff>() {
        @Override
        public Stuff createFromParcel(Parcel source) {
            return new Stuff(source);
        }

        @Override
        public Stuff[] newArray(int size) {
            return new Stuff[size];
        }
    };
}
