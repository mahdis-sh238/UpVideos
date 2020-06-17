package com.univercity.upvideos;

public class ExampleItems {
    private String mImageUrl;
    private String mCreator;
    private String mlikes;

    private String mYear;
    private String mSummery;
    private String mLang;
    private String mBimg;


    public ExampleItems(String imageUrl, String creator, String likes, String summery, String Lang, String Bimg, String year) {
        mImageUrl = imageUrl;
        mCreator = creator;
        mlikes = likes;
      //  this.mYear = mYear;
        this.mSummery =summery;
        this.mLang = Lang;
        this.mBimg=Bimg;
        this.mYear=year;

    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getCreator() {
        return mCreator;
    }

  //


    //
    public String getSummery() {
        return mSummery;
    }

   // public String getYear() {
       // return mYear;
  //  }

    public String getLang() {
        return mLang;
    }

    public String getBimg() {
        return mBimg;
    }

    public String getLikes(){
        return mlikes;
    }

    public String getYear() {
        return null;
    }

    //
}
