package com.example.srikant.layoutdesign;

public class PostModel {
    private String imageUrl;
    private String personName;
    private String personAddress;
    private String askedAnwered;
    private String question;
    private String ansImage;
    private String profileUrl;

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    private String postUrl;


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public String getAskedAnwered() {
        return askedAnwered;
    }

    public void setAskedAnwered(String askedAnwered) {
        this.askedAnwered = askedAnwered;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnsImage() {
        return ansImage;
    }

    public void setAnsImage(String ansImage) {
        this.ansImage = ansImage;
    }

    public String getAnsHeading() {
        return ansHeading;
    }

    public void setAnsHeading(String ansHeading) {
        this.ansHeading = ansHeading;
    }

    public String getAnsContent() {
        return ansContent;
    }

    public void setAnsContent(String ansContent) {
        this.ansContent = ansContent;
    }

    private String ansHeading;
    private String ansContent;
}

