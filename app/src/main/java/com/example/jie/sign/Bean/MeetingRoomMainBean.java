package com.example.jie.sign.Bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YX on 2018/10/23.
 */

public class MeetingRoomMainBean {

    /**
     * id : 13
     * room_id : 666
     * room_name : 666
     * room_location : 666
     * seat_number : 16
     */

    private String id;
    private String room_id;
    private String room_name;
    private String room_location;
    private String seat_number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getRoom_location() {
        return room_location;
    }

    public void setRoom_location(String room_location) {
        this.room_location = room_location;
    }

    public String getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(String seat_number) {
        this.seat_number = seat_number;
    }

    public static List<MeetingRoomMainBean> arrayMeetingRoomMainBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<MeetingRoomMainBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }
}
