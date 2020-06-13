package com.univercity.upvideos;

public class ExampleItems {
    private String mImageUrl;
    private String mCreator;
    private int mlikes;

    public ExampleItems(String imageUrl, String creator, int likes) {
        mImageUrl = imageUrl;
        mCreator = creator;
        mlikes = likes;
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

}
