package com.example.verticalfarming;

import android.util.Log;

public class GenericEducationContentModel {

    private String image;
    private String title;
    private String desc;

    public GenericEducationContentModel(String image, String title, String desc) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        Log.i("Model image",image);
        Log.i("Model title",title);
        Log.i("Model desc",desc);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
