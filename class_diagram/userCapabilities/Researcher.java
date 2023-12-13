package userCapabilities;
import communication.ResearchProject;

public interface Researcher {
    void writeNewResearch(ResearchProject research);
    double findGIndex(String researcherId);
    void conductResearch(String researchTopic);
}
