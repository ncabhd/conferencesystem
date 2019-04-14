package com.noerrorsnowarning.conferencesystem.domain;

import java.sql.Time;

public class Commend {

//    private Time start;
//    private Time end;
    private String date;
    private String start;
    private String end;
    private int num;
    private String equip;

    public Commend(String date, String start, String end, int num, String equip) {
        this.date = date;
        this.start = start;
        this.end = end;
        this.num = num;
        this.equip = equip;
    }

//    public Commend(Time start, Time end, int num, String equip) {
//        this.start = start;
//        this.end = end;
//        this.num = num;
//        this.equip = equip;
//    }
//
//    public Time getStart() {
//        return start;
//    }
//
//    public void setStart(Time start) {
//        this.start = start;
//    }
//
//    public Time getEnd() {
//        return end;
//    }
//
//    public void setEnd(Time end) {
//        this.endDate = endDate;
//    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getEquip() {
        return equip;
    }

    public void setEquip(String equip) {
        this.equip = equip;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
