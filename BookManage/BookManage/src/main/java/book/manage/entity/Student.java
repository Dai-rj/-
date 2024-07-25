package book.manage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student{
    int sid;
    String name;
    String sex;
    int grade;

    public Student(String name, String sex, int g) {
    }
}
