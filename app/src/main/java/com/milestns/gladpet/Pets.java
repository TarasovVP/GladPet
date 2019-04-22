package com.milestns.gladpet;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;



public class Pets implements Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("name")
    private String name;
    @SerializedName("city_str")
    private String location;
    @SerializedName("age_str")
    private String age;
    @SerializedName("sex_str")
    private String sex;
    @SerializedName("size_str")
    private String size;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


    @Override
    public int describeContents() {
        return 0;
    }



    protected Pets(Parcel in) {
        id = in.readInt();
        avatar = in.readString();
        name = in.readString();
        location = in.readString();
        age = in.readString();
        sex = in.readString();
        size = in.readString();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(avatar);
        dest.writeString(name);
        dest.writeString(location);
        dest.writeString(age);
        dest.writeString(sex);
        dest.writeString(size);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Pets> CREATOR = new Parcelable.Creator<Pets>() {
        @Override
        public Pets createFromParcel(Parcel in) {
            return new Pets(in);
        }

        @Override
        public Pets[] newArray(int size) {
            return new Pets[size];
        }
    };
}
