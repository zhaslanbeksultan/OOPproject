package userCapabilities;

import java.util.Date;

public interface CanBorrowBook {
    void borrowBook(String bookName);

    void returnBook(String bookName);
}
