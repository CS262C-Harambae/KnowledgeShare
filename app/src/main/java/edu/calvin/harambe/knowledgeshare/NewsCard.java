package edu.calvin.harambe.knowledgeshare;

/**
 * News Card (NewsCard.java)
 * This class defines a News Card object
 *
 * @version 0.4 Beta (Fall, 2016)
 */

// Class
public class NewsCard {

    // Instance variables
    private String headline;
    private String sender;
    private String story;
    private int color;
    private int category;

    // Default constructor
    public NewsCard() {
        this.headline = "Sample Headline";
        this.sender = "cjn8@students.calvin.edu";
        this.story = "Sample Story";
        this.color = 1;
        this.category = 1;
    }

    // Explicit constructor
    public NewsCard(String headline, String sender, String story, int color, int category) {
        this.headline = headline;
        this.sender = sender;
        this.story = story;
        this.color = color;
        this.category = category;
    }

    // Headline accessor
    public String getHeadline() {
        return headline;
    }

    // Headline mutator
    public void setHeadline(String headline) {
        this.headline = headline;
    }

    // Sender accessor
    public String getSender() {
        return sender;
    }

    // Sender mutator
    public void setSender() {
        this.sender = sender;
    }

    // Story accessor
    public String getStory() {
        return story;
    }

    // Story mutator
    public void setStory(String story) {
        this.story = story;
    }

    // Color accessor
    public int getColor() {
        return color;
    }

    // Color mutator
    public void setColor(int color) {
        this.color = color;
    }

    // Category accessor
    public int getCategory() {
        return category;
    }

    // Category mutator
    public void setCategory(int category) {
        this.category = category;
    }
}
