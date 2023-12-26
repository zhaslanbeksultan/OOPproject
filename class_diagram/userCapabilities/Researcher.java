package userCapabilities;

import java.util.Comparator;
import communication.ResearchPaper;

/**
 * The Researcher interface declares methods related to research capabilities that a user can perform.
 * Implementing classes are expected to provide concrete implementations for these methods.
 */
public interface Researcher {

    /**
     * Display a list of research papers authored by the researcher.
     */
    void showMyPapers();

    /**
     * Add a new research paper.
     */
    void addResearchPaper();

    /**
     * Create a new research project.
     */
    void createResearchProject();
}
