package common;

import java.util.Comparator;

import communication.News;

public class NewsSortComparator implements Comparator<News>{
	@Override
    public int compare(News post1, News post2) {
        return post1.compareTo(post2);
    }
}
