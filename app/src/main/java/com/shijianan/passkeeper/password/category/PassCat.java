package com.shijianan.passkeeper.password.category;

/**
 * Created by shijianan on 2017/3/23.
 */

public class PassCat {

    private int imageResId;

    private int name;

    private int descriptionResId;

    private int type;

    public PassCat(int imageResId, int name, int descriptionResId, int type) {
        this.imageResId = imageResId;
        this.name = name;
        this.descriptionResId = descriptionResId;
        this.type = type;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getDescriptionResId() {
        return descriptionResId;
    }

    public void setDescriptionResId(int descriptionResId) {
        this.descriptionResId = descriptionResId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PassCat{" +
                "imageResId=" + imageResId +
                ", name='" + name + '\'' +
                ", descriptionResId=" + descriptionResId +
                ", type=" + type +
                '}';
    }
}
