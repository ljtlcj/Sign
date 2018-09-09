package com.example.jie.sign.Bean;

/**
 * Created by YX on 2018/9/9.
 */

public class MessageBean {

    private String Title;//消息标题
    private String Content;//消息内容

    public MessageBean(String title, String content) {
        Title = title;
        Content = content;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
