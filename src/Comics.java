public class Comics extends AbstractBook {
    private int series;

    public Comics(String title, String author, int pageCont) {
        super(title, author, pageCont);
    }

    public int getSeries(){
        return series;
    }
    public void setSeries(int series){
        this.series = series;
    }

    @Override
    public String toString() {
        return "Comics{" +
                "title='" + getTitle() + '\'' +
                ", author=" + getAuthor() + '\'' +
                ", pageCount='" + getPageCount() + '\'' +
                ", series='" + series + '\'' +
                '}';
    }
}
