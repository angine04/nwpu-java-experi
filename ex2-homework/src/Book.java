import java.util.Calendar;

public class Book {
    private String title = "";
    private Calendar publish_date;
    private int word_count = 0;
    private float price = 0.0f;
    final float first_half_coeff = 1.2f;
    final float second_half_coeff = 1.18f;

    public Book(String title, Calendar publish_date, int word_count) {
        this.title = title;
        this.publish_date = publish_date;
        this.word_count = word_count;
        this.price = price();
    }

    private float price() {
        int month = publish_date.get(Calendar.MONTH);
        float coeff = 0.0f;

        if (month <= Calendar.JUNE) {
            coeff = first_half_coeff;
        } else {
            coeff = second_half_coeff;
        }

        float price_ = word_count / 1000 * 35 * coeff;

        return price_;
    }

    public void printInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Book Publish Date: " + publish_date.get(Calendar.YEAR) + "-" + (publish_date.get(Calendar.MONTH) + 1) + "-" + publish_date.get(Calendar.DATE));
        System.out.println("Book Word Count: " + word_count);
        System.out.printf("Book Price: %.2f\n", price);
    }

}
