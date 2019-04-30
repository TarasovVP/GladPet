package com.milestns.gladpet.model;

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
    @SerializedName("user_id")
    private int user_id;
    @SerializedName("organization_id")
    private int organization;
    @SerializedName("breed")
    private int breed;
    @SerializedName("callable")
    private boolean callable;
    @SerializedName("sterilized")
    private boolean sterilized;
    @SerializedName("vaccinated")
    private boolean vaccinated;
    @SerializedName("history")
    private String history;
    @SerializedName("nature")
    private String nature;
    @SerializedName("behavior")
    private String behavior;
    @SerializedName("wishes")
    private String wishes;

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
        return name.substring(0, 1).toUpperCase() + name.substring(1);
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOrganization() {
        return organization;
    }

    public void setOrganization(int organization) {
        this.organization = organization;
    }

    public int getBreed() {
        return breed;
    }

    public void setBreed(int breed) {
        this.breed = breed;
    }

    public boolean getCallable() {
        return callable;
    }

    public void setCallable(boolean callable) {
        this.callable = callable;
    }

    public boolean isSterilized() {
        return sterilized;
    }

    public void setSterilized(boolean sterilized) {
        this.sterilized = sterilized;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getWishes() {
        return wishes;
    }

    public void setWishes(String wishes) {
        this.wishes = wishes;
    }



    protected Pets(Parcel in) {
        id = in.readInt();
        avatar = in.readString();
        name = in.readString();
        location = in.readString();
        age = in.readString();
        sex = in.readString();
        size = in.readString();
        user_id = in.readInt();
        organization = in.readInt();
        callable = in.readByte() != 0x00;
        sterilized = in.readByte() != 0x00;
        vaccinated = in.readByte() != 0x00;
        history = in.readString();
        nature = in.readString();
        behavior = in.readString();
        wishes = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
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
        dest.writeInt(user_id);
        dest.writeInt(organization);
        dest.writeByte((byte) (callable ? 0x01 : 0x00));
        dest.writeByte((byte) (sterilized ? 0x01 : 0x00));
        dest.writeByte((byte) (vaccinated ? 0x01 : 0x00));
        dest.writeString(history);
        dest.writeString(nature);
        dest.writeString(behavior);
        dest.writeString(wishes);
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

    public String getAvatarUrl() {
        String url = "http://gladpet.org";
        String base_url = "https://gladpet.org";
        String path =  getAvatar(  );
        if (!url.equalsIgnoreCase( path.substring( 0, 18 ) )){
            return base_url + path;
        }else {
            return base_url + path.substring( 18 );
        }
    }
}