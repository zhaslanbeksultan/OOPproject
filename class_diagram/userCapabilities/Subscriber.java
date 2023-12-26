package userCapabilities;

/**
 * The Subscriber interface declares a method for notifying subscribers about relevant events.
 * Implementing classes are expected to provide a concrete implementation for the notifySubscriber method.
 */
public interface Subscriber {

    /**
     * Notify the subscriber about a specific event.
     *
     * @param journalName The name of the journal being notified about.
     * @param projectTopic The topic of the research project being notified about.
     * @param paperTitle The title of the research paper being notified about.
     */
    void notifySubscriber(String journalName, String projectTopic, String paperTitle);
}
