package com.etc.entity;

import java.util.Date;

public class Msg {
    private String content;
    private String from;
    private String to;
    private Date time;
    private String type;



    public Msg() {
    }

    public Msg(String content, String from, String to, Date time) {
        this.content = content;
        this.from = from;
        this.to = to;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Msg(String content, String from, String to, Date time, String type) {
        this.content = content;
        this.from = from;
        this.to = to;
        this.time = time;
        this.type = type;
    }

    public Msg(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "content='" + content + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", time=" + time +
                ", type='" + type + '\'' +
                '}';
    }
}
