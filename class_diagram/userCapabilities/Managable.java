package userCapabilities;

import enums.*;
import users.*;

import java.util.HashMap;

/**
 * The Managable interface declares methods related to management capabilities that a user can perform.
 * Implementing classes are expected to provide concrete implementations for these methods.
 */
public interface Managable {

    /**
     * View academic statistics.
     */
    void viewAcademicStatistics();
}
