package enums;

import java.util.Comparator;
import communication.ResearchPaper;


public class PaperByArticleLengthComporator implements Comparator<ResearchPaper> {

    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getArticleLength(), paper2.getArticleLength());
    }
}
