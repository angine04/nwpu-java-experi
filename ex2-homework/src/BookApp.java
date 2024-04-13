import java.util.Calendar;

public class BookApp {
    public static void main(String[] args) throws Exception {
        Calendar publish_date = Calendar.getInstance();
        publish_date.set(2024, Calendar.APRIL, 12);
        Book some_book = new Book("Some Book", publish_date, 10000);
        some_book.printInfo();
    }
}
