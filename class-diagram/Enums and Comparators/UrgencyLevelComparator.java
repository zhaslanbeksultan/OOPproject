package enums;

import java.util.Comparator;
import Communication.Request;

public class UrgencyLevelComparator implements Comparator<Request> {

    @Override
    public int compare(Request request1, Request request2) {
        return request2.getUrgencyLevel().compareTo(request1.getUrgencyLevel());
    }
}