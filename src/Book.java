public class Book extends AbstractBook {
    private int tome;

    public Book(String title, String author, int pageCont, int tome) {
        super(title, author, pageCont);
        this.tome = tome;
    }

    public Book() {

    }

    public int getTome(){
        return tome;
    }
    public void setTome(int tome){
        this.tome = tome;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                ", author=" + getAuthor() + '\'' +
                ", pageCount='" + getPageCount() + '\'' +
                ", tome='" + tome + '\'' +
                '}';
    }
}
