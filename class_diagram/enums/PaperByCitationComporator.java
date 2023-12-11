package enums;

import java.util.Comparator;
import Communication.ResearchPaper; 

public class PaperByCitationComparator implements Comparator<ResearchPaper> {

    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getCitationCount(), paper2.getCitationCount());
    }
}
