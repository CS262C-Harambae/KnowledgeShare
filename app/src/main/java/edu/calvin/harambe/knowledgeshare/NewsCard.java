package edu.calvin.harambe.knowledgeshare;

import java.sql.Timestamp;

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
    private String date;

    // Default constructor
    public NewsCard() {
    }

    // Explicit constructor
    public NewsCard(String headline, String sender, String story, String date) {
        this.headline = headline;
        this.sender = sender;
        this.story = story;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
