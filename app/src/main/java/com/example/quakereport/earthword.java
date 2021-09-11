package com.example.quakereport;

public class earthword {
    private double mmagtitude;
    private String mplace;
    private String mtime;
    private String murl;

    public earthword(double magtitude, String place, String time,String url){
        mmagtitude = magtitude;
        mplace = place;
        mtime= time;
        murl = url;
    }

    public double getMmagtitude() {
        return mmagtitude;
    }

    public String getMplace() {
        return mplace;
    }

    public String getMtime() {
        return mtime;
    }

    public String getMurl() { return murl;
    }

}
