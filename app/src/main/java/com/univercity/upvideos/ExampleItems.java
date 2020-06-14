package com.univercity.upvideos;

public class ExampleItems {
    private String mImageUrl;
    private String mCreator;
    private int mlikes;
    //
    private String mYear;
    private String mSummery;
    //
    public ExampleItems(String imageUrl, String creator, int likes, String mYear, String mSummery) {
        mImageUrl = imageUrl;
        mCreator = creator;
        mlikes = likes;
        this.mYear = mYear;
        this.mSummery = mSummery;
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
    public String getmSummery() {
        return mSummery;
    }

    public String getYear() {
        return mYear;
    }
    //
}
