package userCapabilities;
import communication.News;

public interface NewsPostable {
    void postNews(News news);
    void manageNewsWording(String newsTitle, String newWording);
    boolean accessRespondsFromNews();
    String answerToComplaints(String complaint);
}
