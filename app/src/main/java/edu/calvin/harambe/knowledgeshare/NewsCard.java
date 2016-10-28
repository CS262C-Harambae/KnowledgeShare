package edu.calvin.harambe.knowledgeshare;

/**
 * News Card (NewsCard.java)
 * This class defines a News Card object
 *
 * @author: Corey Noble (cjn8)
 * @version: 1.0 (Fall, 2016)
 */

// Class
public class NewsCard {
    
    // Instance variables
    private String headline;
    private String story;
    private int color;
    private int category;

    // Constructor
    public NewsCard() {
        this.headline = "Sample Headline";
        this.story = "Sample Story";
        this.color = 1;
        this.category = 1;
    }

    // Explicit constructor
    public NewsCard(String headline, String story, int color, int category) {
        this.headline = headline;
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
    public void setColor(int color){
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
