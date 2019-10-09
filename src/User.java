import java.util.ArrayList;
import java.util.Collections;

public class User {
    public ArrayList<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void deleteBook(Book book) {
        bookList.remove(book);
    }
    public void sortBooksByTitle(User user){
        user.bookList.sort(AbstractBook.BookTitleComparator);
    }
    public void sortBooksByPages(User user)
    {
        user.bookList.sort(AbstractBook.BookPagesComparator);
    }

    public void sortBooksByAuthor(User user){
        user.bookList.sort(AbstractBook.BookAuthorComparator);
    }
}
