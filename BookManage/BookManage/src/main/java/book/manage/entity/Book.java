package book.manage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    int bid;
    String title;
    String desc;
    double price;

    public Book(String title, String desc, double p) {
    }
}
