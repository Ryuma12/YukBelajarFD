package com.yuk_belajarwiki.yukbelajarfd;

import android.content.Context;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Note implements Serializable {
    private long mDateTime;
    private String mTitle;
    private String mContent;

    protected Note(long Datetime, String Title, String Content) {
        mDateTime = Datetime;
        mTitle = Title;
        mContent = Content;
    }

    public long getDatetime() {
        return mDateTime;
    }

    public void setDatetime(long mDateTime) {
        this.mDateTime = mDateTime;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public String getDatetimeFormat (Context context) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"
                , context.getResources().getConfiguration().locale);
        formatter.setTimeZone(TimeZone.getDefault());
        return formatter.format(new Date(mDateTime));
    }

}
