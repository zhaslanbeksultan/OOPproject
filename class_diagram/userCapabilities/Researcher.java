package userCapabilities;
import communication.ResearchProject;

public interface Researcher {
	void printPapers();
    void writeNewResearch(ResearchProject research);
    double findGIndex(String researcherId);
    void conductResearch(String researchTopic);
}
