package com.example.uts_mcs_2540120345;

import java.io.Serializable;

public class News implements Serializable {
    private String title, desc;
    private int image;

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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public News(String title, String desc /*int image*/) {
        this.title = title;
        this.desc = desc;
        // this.image = image;
    }
}
