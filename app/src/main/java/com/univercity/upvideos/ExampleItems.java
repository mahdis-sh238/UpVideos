package com.univercity.upvideos;

public class ExampleItems {
    private String mImageUrl;
    private String mCreator;
    private int mlikes;
    //
    private String mYear;
    private String mSummery;
    private String mLang;
    private String mBimg;

    //
    public ExampleItems(String imageUrl, String creator, int likes, String mYear, String mSummery, String mLang, String mBimg) {
        mImageUrl = imageUrl;
        mCreator = creator;
        mlikes = likes;
        this.mYear = mYear;
        this.mSummery = mSummery;
        this.mLang = mLang;
        this.mBimg = mBimg;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getCreator() {
        return mCreator;
    }

    public int getLikes()
    {
        return mlikes;
    }


    //
    public String getSummery() {
        return mSummery;
    }

    public String getYear() {
        return mYear;
    }

    public String getLang() {
        return mLang;
    }

    public String getBimg() {
        return mBimg;
    }

    //
}
