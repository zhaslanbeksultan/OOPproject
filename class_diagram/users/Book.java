package users;

import common.Data;
import userCapabilities.*;

public class Book {

    private String bookName;
    private String author;
    private int bookId;
    private int cnt = 1;
    private boolean isBorrowed;
    private User reader;
    
    public Book(String bookName, String author) {
		this.bookName = bookName;
		this.author = author;
		this.bookId = cnt++;
		this.isBorrowed = false;
	}

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookId() {
        return this.bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }


    public boolean isBorrowed() {
		return isBorrowed;
	}

	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}

	public static boolean isBookAvailable(String bookName) {
		for(Book book: Data.getInstance().getBooks())
			if(book.getBookName().equals(bookName) || !book.isBorrowed) return true;
		return false;
    }

	public User getReader() {
		return reader;
	}

	public void setReader(User reader) {
		this.reader = reader;
	}

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", author=" + author + ", bookId=" + bookId + ", cnt=" + cnt
				+ ", isBorrowed=" + isBorrowed + ", reader=" + reader + "]";
	}
    
    
}
