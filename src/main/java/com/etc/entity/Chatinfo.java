package com.etc.entity;

import java.util.Arrays;
import java.util.Date;

public class Chatinfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_chatinfo.chatid
     *
     * @mbg.generated Mon Sep 17 14:15:18 CST 2018
     */
    private Integer chatid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_chatinfo.sendid
     *
     * @mbg.generated Mon Sep 17 14:15:18 CST 2018
     */
    private Integer sendid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_chatinfo.receiveid
     *
     * @mbg.generated Mon Sep 17 14:15:18 CST 2018
     */
    private Integer receiveid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_chatinfo.date
     *
     * @mbg.generated Mon Sep 17 14:15:18 CST 2018
     */
    private Date date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_chatinfo.context
     *
     * @mbg.generated Mon Sep 17 14:15:18 CST 2018
     */
    private String context;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_chatinfo.images
     *
     * @mbg.generated Mon Sep 17 14:15:18 CST 2018
     */
    private byte[] images;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_chatinfo.chatid
     *
     * @return the value of t_chatinfo.chatid
     *
     * @mbg.generated Mon Sep 17 14:15:18 CST 2018
     */
    public Integer getChatid() {
        return chatid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_chatinfo.chatid
     *
     * @param chatid the value for t_chatinfo.chatid
     *
     * @mbg.generated Mon Sep 17 14:15:18 CST 2018
     */
    public void setChatid(Integer chatid) {
        this.chatid = chatid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_chatinfo.sendid
     *
     * @return the value of t_chatinfo.sendid
     *
     * @mbg.generated Mon Sep 17 14:15:18 CST 2018
     */
    public Integer getSendid() {
        return sendid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_chatinfo.sendid
     *
     * @param sendid the value for t_chatinfo.sendid
     *
     * @mbg.generated Mon Sep 17 14:15:18 CST 2018
     */
    public void setSendid(Integer sendid) {
        this.sendid = sendid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_chatinfo.receiveid
     *
     * @return the value of t_chatinfo.receiveid
     *
     * @mbg.generated Mon Sep 17 14:15:18 CST 2018
     */
    public Integer getReceiveid() {
        return receiveid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_chatinfo.receiveid
     *
     * @param receiveid the value for t_chatinfo.receiveid
     *
     * @mbg.generated Mon Sep 17 14:15:18 CST 2018
     */
    public void setReceiveid(Integer receiveid) {
        this.receiveid = receiveid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_chatinfo.date
     *
     * @return the value of t_chatinfo.date
     *
     * @mbg.generated Mon Sep 17 14:15:18 CST 2018
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_chatinfo.date
     *
     * @param date the value for t_chatinfo.date
     *
     * @mbg.generated Mon Sep 17 14:15:18 CST 2018
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_chatinfo.context
     *
     * @return the value of t_chatinfo.context
     *
     * @mbg.generated Mon Sep 17 14:15:18 CST 2018
     */
    public String getContext() {
        return context;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_chatinfo.context
     *
     * @param context the value for t_chatinfo.context
     *
     * @mbg.generated Mon Sep 17 14:15:18 CST 2018
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_chatinfo.images
     *
     * @return the value of t_chatinfo.images
     *
     * @mbg.generated Mon Sep 17 14:15:18 CST 2018
     */
    public byte[] getImages() {
        return images;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_chatinfo.images
     *
     * @param images the value for t_chatinfo.images
     *
     * @mbg.generated Mon Sep 17 14:15:18 CST 2018
     */
    public void setImages(byte[] images) {
        this.images = images;
    }

    public Chatinfo() {
    }

    public Chatinfo(Integer sendid, Integer receiveid, Date date, String context) {
        this.sendid = sendid;
        this.receiveid = receiveid;
        this.date = date;
        this.context = context;
    }

    @Override
    public String toString() {
        return "Chatinfo{" +
                "chatid=" + chatid +
                ", sendid=" + sendid +
                ", receiveid=" + receiveid +
                ", date=" + date +
                ", context='" + context + '\'' +
                ", images=" + Arrays.toString(images) +
                '}';
    }
}