package enums;

import java.util.Comparator;
import Communication.ResearchPaper;


public class PaperByArticleLengthComparator implements Comparator<ResearchPaper> {

    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getArticleLength(), paper2.getArticleLength());
    }
}
