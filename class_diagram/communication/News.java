package communication;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

/**
 * The News class represents a news post with recipients, title, wording, and comments.
 * It implements the Comparable and Serializable interfaces.
 */
public class News implements Comparable<News>, Serializable {

    private static final long serialVersionUID = 1L;

    // Static counter for generating unique news IDs
    private static int cnt = 1;

    // Instance variables
    private int newsId;
    private String recipients;
    private String newsTitle;
    private String newsWording;
    private Date postSentDate;
    private HashMap<String, String> newsComments;

    /**
     * Constructs a News object with specified recipients, title, and wording.
     *
     * @param recipients The recipients of the news post.
     * @param newsTitle   The title of the news post.
     * @param newsWording The wording of the news post.
     */
    public News(String recipients, String newsTitle, String newsWording) {
        this.recipients = recipients;
        this.newsTitle = newsTitle;
        this.newsWording = newsWording;
        this.newsId = cnt++;
        this.postSentDate = new Date();
        this.newsComments = new HashMap<>();
    }

    /**
     * Gets the recipients of the news post.
     *
     * @return A string representing the recipients of the news post.
     */
    public String getRecipients() {
        return recipients;
    }

    /**
     * Sets the recipients of the news post.
     *
     * @param recipients The recipients to be set.
     */
    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    /**
     * Gets the title of the news post.
     *
     * @return A string representing the title of the news post.
     */
    public String getNewsTitle() {
        return this.newsTitle;
    }

    /**
     * Sets the title of the news post.
     *
     * @param newsTitle The title to be set.
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    /**
     * Gets the wording of the news post.
     *
     * @return A string representing the wording of the news post.
     */
    public String getNewsWording() {
        return this.newsWording;
    }

    /**
     * Sets the wording of the news post.
     *
     * @param newsWording The wording to be set.
     */
    public void setNewsWording(String newsWording) {
        this.newsWording = newsWording;
    }

    /**
     * Gets the comments associated with the news post.
     *
     * @return A HashMap representing the comments with usernames as keys and comments as values.
     */
    public HashMap<String, String> getNewsComments() {
        return this.newsComments;
    }

    /**
     * Sets a comment for the news post.
     *
     * @param username The username of the user posting the comment.
     * @param comment  The comment to be set.
     */
    public void setNewsComments(String username, String comment) {
        this.newsComments.put(username, comment);
    }

    /**
     * Returns a string representation of the News object.
     *
     * @return A string containing the news post's ID, title, and sent date.
     */
    @Override
    public String toString() {
        return "Post Id=" + newsId + ", newsTitle=" + newsTitle + ", postSentDate=" + postSentDate;
    }

    /**
     * Compares this news post with another based on the title and sent date.
     *
     * @param other The News object to compare with.
     * @return A negative integer, zero, or a positive integer as this object is less than, equal to,
     *         or greater than the specified object.
     */
    @Override
    public int compareTo(News other) {
        if (this.newsTitle.equals("Research") && !other.newsTitle.equals("Research")) {
            return -1;
        } else if (!this.newsTitle.equals("Research") && other.newsTitle.equals("Research")) {
            return 1;
        } else {
            return this.postSentDate.compareTo(other.postSentDate);
        }
    }
}
