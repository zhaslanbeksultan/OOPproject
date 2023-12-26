package userCapabilities;

import users.User;

/**
 * The UserFactory interface declares a method for creating and initializing User objects.
 * Implementing classes should provide concrete implementations for the createUser method.
 */
public interface UserFactory {

    /**
     * Create and initialize a User object.
     *
     * @param user The User object to be created and initialized.
     */
    void createUser(User user);
}
