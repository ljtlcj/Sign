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

public class AllMeetingNewsBean implements Parcelable {

    /**
     * id : 76
     * meeting_name : 666
     * meeting_time : 2018-06-14 00:00:00
     * room_id : 666
     * meeting_content : 666
     * length2 : 2
     * length3 : 2
     * length4 : 0
     */

    private String id;
    private String meeting_name;
    private String meeting_time;
    private String room_id;
    private String meeting_content;
    private int length2;
    private int length3;
    private int length4;

    public static AllMeetingNewsBean objectFromData(String str) {

        return new Gson().fromJson(str, AllMeetingNewsBean.class);
    }

    public static List<AllMeetingNewsBean> arrayAllMeetingNewsBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<AllMeetingNewsBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMeeting_name() {
        return meeting_name;
    }

    public void setMeeting_name(String meeting_name) {
        this.meeting_name = meeting_name;
    }

    public String getMeeting_time() {
        return meeting_time;
    }

    public void setMeeting_time(String meeting_time) {
        this.meeting_time = meeting_time;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getMeeting_content() {
        return meeting_content;
    }

    public void setMeeting_content(String meeting_content) {
        this.meeting_content = meeting_content;
    }

    public int getLength2() {
        return length2;
    }

    public void setLength2(int length2) {
        this.length2 = length2;

    }

    public int getLength3() {
        return length3;
    }

    public void setLength3(int length3) {
        this.length3 = length3;
    }

    public int getLength4() {
        return length4;
    }

    public void setLength4(int length4) {
        this.length4 = length4;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.meeting_name);
        dest.writeString(this.meeting_time);
        dest.writeString(this.room_id);
        dest.writeString(this.meeting_content);
        dest.writeInt(this.length2);
        dest.writeInt(this.length3);
        dest.writeInt(this.length4);
    }

    public AllMeetingNewsBean() {
    }

    protected AllMeetingNewsBean(Parcel in) {
        this.id = in.readString();
        this.meeting_name = in.readString();
        this.meeting_time = in.readString();
        this.room_id = in.readString();
        this.meeting_content = in.readString();
        this.length2 = in.readInt();
        this.length3 = in.readInt();
        this.length4 = in.readInt();
    }

    public static final Parcelable.Creator<AllMeetingNewsBean> CREATOR = new Parcelable.Creator<AllMeetingNewsBean>() {
        @Override
        public AllMeetingNewsBean createFromParcel(Parcel source) {
            return new AllMeetingNewsBean(source);
        }

        @Override
        public AllMeetingNewsBean[] newArray(int size) {
            return new AllMeetingNewsBean[size];
        }
    };
}
