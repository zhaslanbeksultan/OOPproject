package userCapabilities;

import java.util.Date;

public interface CanBorrowBook {
    void borrowBook();

    boolean returnBook();

    Date getBorrowedDate();

    Date getMustReturnDate();
}
