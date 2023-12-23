package common;

import java.util.Comparator;
import communication.ResearchPaper; 

public class PaperByCitationComparator implements Comparator<ResearchPaper> {

    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getCitations().size(), paper2.getCitations().size());
    }
}
