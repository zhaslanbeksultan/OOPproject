package userCapabilities;

import java.util.Date;

/**
 * The CanBorrowBook interface defines the capabilities for a user to borrow and return books.
 * Implementing classes should provide concrete implementations for borrowing and returning books.
 */
public interface CanBorrowBook {

    /**
     * Borrow a book with the specified name.
     *
     * @param bookName The name of the book to be borrowed.
     */
    void borrowBook(String bookName);

    /**
     * Return a borrowed book with the specified name.
     *
     * @param bookName The name of the book to be returned.
     */
    void returnBook(String bookName);
}
