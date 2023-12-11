package class-diagram;


/**
* @generated
*/
public class Book {
    
    /**
    * @generated
    */
    private String name;
    
    /**
    * @generated
    */
    private String author;
    
    /**
    * @generated
    */
    private int amount;
    
    /**
    * @generated
    */
    private String bookId;
    
    
    /**
    * @generated
    */
    private Library library;
    
    

    /**
    * @generated
    */
    private String getName() {
        return this.name;
    }
    
    /**
    * @generated
    */
    private String setName(String name) {
        this.name = name;
    }
    
    
    /**
    * @generated
    */
    private String getAuthor() {
        return this.author;
    }
    
    /**
    * @generated
    */
    private String setAuthor(String author) {
        this.author = author;
    }
    
    
    /**
    * @generated
    */
    private int getAmount() {
        return this.amount;
    }
    
    /**
    * @generated
    */
    private int setAmount(Integer amount) {
        this.amount = amount;
    }
    
    
    /**
    * @generated
    */
    private String getBookId() {
        return this.bookId;
    }
    
    /**
    * @generated
    */
    private String setBookId(String bookId) {
        this.bookId = bookId;
    }
    
    
    
    /**
    * @generated
    */
    public Library getLibrary() {
        return this.library;
    }
    
    /**
    * @generated
    */
    public Library setLibrary(Library library) {
        this.library = library;
    }
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public boolean isAvailable() {
        //TODO
        return false;
    }
    
    
}
