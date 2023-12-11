package enums;

import java.util.Comparator;
import Communication.ResearchPaper; 

public class PaperByDateComparator implements Comparator<ResearchPaper> {

    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return paper2.getPublishDate().compareTo(paper1.getPublishDate());
    }
}
