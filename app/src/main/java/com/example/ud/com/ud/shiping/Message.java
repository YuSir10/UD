package com.example.ud.com.ud.shiping;

public class Message {
    private int mId;
    private int mImageid;
    private String mTitle;
    private String mContent;

    public Message(){

    }
    public Message(int mId, int mImageid, String mTitle, String mContent) {
        this.mId = mId;
        this.mImageid = mImageid;
        this.mTitle = mTitle;
        this.mContent = mContent;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }


    public void setmImageid(int mImageid) {
        this.mImageid = mImageid;
    }
    public int getmImageid(){
        return mImageid;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }
}
