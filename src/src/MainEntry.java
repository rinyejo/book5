import java.awt.print.Book;

public class MainEntry {
    public static void main(String[] args) throws InterruptedException {
        Book book = new Book();
        book.wait();
    }
}
