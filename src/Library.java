import java.util.ArrayList;

public class Library {
     public ArrayList<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void deleteBook(Book book) {
        bookList.remove(book);
    }

    public void sortBooksByTitle(Library library){
        library.bookList.sort(AbstractBook.BookTitleComparator);
    }
    public void sortBooksByPages(Library library)
    {
        library.bookList.sort(AbstractBook.BookPagesComparator);
    }

    public void sortBooksByAuthor(Library library){
        library.bookList.sort(AbstractBook.BookAuthorComparator);
    }
}

