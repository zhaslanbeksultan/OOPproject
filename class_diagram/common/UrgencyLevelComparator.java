package common;

import java.util.Comparator;
import communication.Message;

public class UrgencyLevelComparator implements Comparator<Message> {

    @Override
    public int compare(Message message1, Message message2) {
        return message1.getUrgencyLevel().compareTo(message2.getUrgencyLevel());
    }
}