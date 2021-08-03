package com.xk.sign.bean;

public class SignTime {
    private Integer id;
    private Float monday;
    private Float tuesday;
    private Float wednesday;
    private Float thursday;
    private Float friday;
    private Float saturday;
    private Float sunday;
    private Long indexTime;
    private String weekly;
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMonday() {
        return monday;
    }

    public void setMonday(Float monday) {
        this.monday = monday;
    }

    public Float getTuesday() {
        return tuesday;
    }

    public void setTuesday(Float tuesday) {
        this.tuesday = tuesday;
    }

    public Float getWednesday() {
        return wednesday;
    }

    public void setWednesday(Float wednesday) {
        this.wednesday = wednesday;
    }

    public Float getThursday() {
        return thursday;
    }

    public void setThursday(Float thursday) {
        this.thursday = thursday;
    }

    public Float getFriday() {
        return friday;
    }

    public void setFriday(Float friday) {
        this.friday = friday;
    }

    public Float getSaturday() {
        return saturday;
    }

    public void setSaturday(Float saturday) {
        this.saturday = saturday;
    }

    public Float getSunday() {
        return sunday;
    }

    public void setSunday(Float sunday) {
        this.sunday = sunday;
    }

    public Long getIndexTime() {
        return indexTime;
    }

    public void setIndexTime(Long indexTime) {
        this.indexTime = indexTime;
    }

    public String getWeekly() {
        return weekly;
    }

    public void setWeekly(String weekly) {
        this.weekly = weekly;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SignTime{" +
                "id=" + id +
                ", monday=" + monday +
                ", tuesday=" + tuesday +
                ", wednesday=" + wednesday +
                ", thursday=" + thursday +
                ", friday=" + friday +
                ", saturday=" + saturday +
                ", sunday=" + sunday +
                ", indexTime=" + indexTime +
                ", weekly='" + weekly + '\'' +
                ", user=" + user +
                '}';
    }
}
