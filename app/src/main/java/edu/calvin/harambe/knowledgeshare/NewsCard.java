package edu.calvin.harambe.knowledgeshare;

public class NewsCard {
    private String headline;
    private String story;
    private int color;
    private int category;

    public NewsCard() {
        this.headline = "Sample Headline";
        this.story = "Sample Story";
        this.color = 1;
        this.category = 1;
    }

    public NewsCard(String headline, String story, int color, int category) {
        this.headline = headline;
        this.story = story;
        this.color = color;
        this.category = category;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color){
        this.color = color;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}