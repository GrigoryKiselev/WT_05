import java.util.Comparator;

public class AbstractBook implements java.io.Serializable {
    private String title;
    private String author;
    private int pageCount;

    public AbstractBook(String title, String author, int pageCont)
    {
        this.title = title;
        this.author = author;
        this.pageCount = pageCont;
    }

    public AbstractBook(){}

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public int getPageCount(){
        return pageCount;
    }
    public void setPageCount(int pageCount){
        this.pageCount = pageCount;
    }

    public static Comparator<AbstractBook> BookTitleComparator = new Comparator<AbstractBook>() {

        public int compare(AbstractBook s1, AbstractBook s2) {
            String StudentName1 = s1.getTitle().toUpperCase();
            String StudentName2 = s2.getTitle().toUpperCase();

            return StudentName1.compareTo(StudentName2);
        }};

    public static Comparator<AbstractBook> BookPagesComparator = new Comparator<AbstractBook>() {

        public int compare(AbstractBook s1, AbstractBook s2) {

            int pages1 = s1.getPageCount();
            int pages2 = s2.getPageCount();

            return pages1-pages2;
        }};

    public static Comparator<AbstractBook> BookAuthorComparator = new Comparator<AbstractBook>() {

        public int compare(AbstractBook s1, AbstractBook s2) {
            String author1 = s1.getAuthor().toUpperCase();
            String author2 = s2.getAuthor().toUpperCase();

            return author1.compareTo(author2);
        }};

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractBook that = (AbstractBook) o;

        return !(title != null ? !title.equals(that.title) : that.title != null);

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result;
        return result;
    }

    @Override
    public String toString() {
        return "AbstractBook{" +
                "title='" + title + '\'' +
                ", author=" + author + '\'' +
                ", pageCount='" + pageCount + '\'' +
                '}';
    }


    /*void displayInfo() {
        System.out.printf("Название: %s| \tАвтор: %s| \tКол-во страниц :%d|\n", name, author, pagecount);
    }*/
}
