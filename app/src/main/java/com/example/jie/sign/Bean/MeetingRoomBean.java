package com.example.jie.sign.Bean;

/**
 * Created by YX on 2018/9/9.
 */

public class MeetingRoomBean {
    private String meetingName;//会议名字
    private String check;//查看详情

    public MeetingRoomBean(String meetingName, String check) {
        this.meetingName = meetingName;
        this.check = check;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }
}
