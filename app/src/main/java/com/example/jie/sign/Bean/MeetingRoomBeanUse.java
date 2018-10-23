package com.example.jie.sign.Bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YX on 2018/9/9.
 */

public class MeetingRoomBeanUse implements Parcelable{

    /**
     * room_id : 123
     * use_location : 123
     * use_time : 时间
     * use_group : 222111
     */

    private String room_id;
    private String use_location;
    private String use_time;
    private String use_group;

    protected MeetingRoomBeanUse(Parcel in) {
        room_id = in.readString();
        use_location = in.readString();
        use_time = in.readString();
        use_group = in.readString();
    }

    public static final Creator<MeetingRoomBeanUse> CREATOR = new Creator<MeetingRoomBeanUse>() {
        @Override
        public MeetingRoomBeanUse createFromParcel(Parcel in) {
            return new MeetingRoomBeanUse(in);
        }

        @Override
        public MeetingRoomBeanUse[] newArray(int size) {
            return new MeetingRoomBeanUse[size];
        }
    };

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getUse_location() {
        return use_location;
    }

    public void setUse_location(String use_location) {
        this.use_location = use_location;
    }

    public String getUse_time() {
        return use_time;
    }

    public void setUse_time(String use_time) {
        this.use_time = use_time;
    }

    public String getUse_group() {
        return use_group;
    }

    public void setUse_group(String use_group) {
        this.use_group = use_group;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(room_id);
        parcel.writeString(use_location);
        parcel.writeString(use_time);
        parcel.writeString(use_group);
    }

    public static List<MeetingRoomBeanUse> arrayMeetingRoomBeanUseFromData(String str) {

        Type listType = new TypeToken<ArrayList<MeetingRoomBeanUse>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }
}
