package com.example.practice;

public class postdisplay {
    String Notice;
    String Title;
    public postdisplay()
    {

    }
    public postdisplay(String notice, String title) {
        this.Notice = notice;
        this.Title = title;
    }

    public String getNotice() {
        return Notice;
    }

    public void setNotice(String notice) {
        this.Notice = notice;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }


}
