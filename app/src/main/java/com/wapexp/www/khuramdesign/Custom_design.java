package com.wapexp.www.khuramdesign;

public class Custom_design {

    public int profile_image;
    public String profile_name;
    public String profile_email;

    public Custom_design(int profile_image, String profile_name, String profile_follower) {
       setProfile_image(profile_image);
      setProfile_name(profile_name);
       setProfile_follower(profile_follower);
    }

    public int getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(int profile_image) {
        this.profile_image = profile_image;
    }

    public String getProfile_name() {
        return profile_name;
    }

    public void setProfile_name(String profile_name) {
        this.profile_name = profile_name;
    }

    public String getProfile_follower() {
        return profile_email;
    }

    public void setProfile_follower(String profile_follower) {
        this.profile_email = profile_follower;
    }
}