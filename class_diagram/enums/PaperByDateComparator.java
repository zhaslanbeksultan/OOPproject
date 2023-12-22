package enums;

import java.util.Comparator;
import communication.ResearchPaper; 

public class PaperByDateComparator implements Comparator<ResearchPaper> {

    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return paper1.getPublishedDate().compareTo(paper2.getPublishedDate());
    }
}
