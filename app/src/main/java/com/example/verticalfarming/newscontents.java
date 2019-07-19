package com.example.verticalfarming;
//for setting and getting values
public class newscontents {
    public String image;
    public String title,desc;

    public newscontents(String image, String title, String desc) {
        this.image = image;
        this.title = title;
        this.desc = desc;
    }
    public newscontents(){

    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
