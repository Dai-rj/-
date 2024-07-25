package book.manage;

import book.manage.entity.Book;
import book.manage.entity.Student;
import book.manage.tool.SqlUtil;
import lombok.extern.log4j.Log4j2;

import java.util.Scanner;
@Log4j2
public class Main {
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("===================================================================");
            System.out.println("1.录入学生信息");
            System.out.println("2.录入书籍信息");
            System.out.println("3.添加借阅信息");
            System.out.println("4.查看借阅信息");
            System.out.println("5.查看学生信息");
            System.out.println("6.查看书籍信息");
            System.out.print("输入您想要执行的操作（执行其他任意数字将退出）:");

            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input){
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    addBook(scanner);
                    break;
                case 3:
                    addBorrow(scanner);
                    break;
                case 4:
                    showBorrow();
                    break;
                case 5:
                    showStudent();
                    break;
                case 6:
                    showBook();
                    break;
                default:
                    return;
            }
        }
    }

    public static void addStudent(Scanner scanner){
        System.out.print("请输入学生名字:");
        String name = scanner.nextLine();
        System.out.print("请输入学生性别(男/女):");
        String sex = scanner.nextLine();
        System.out.print("请输入学生年纪:");
        String grade = scanner.nextLine();
        int g = Integer.parseInt(grade);
        Student student = new Student(name,sex,g);
        SqlUtil.doSqlwork(mapper -> {
            int i = mapper.addStudent(student);
            if(i>0)System.out.println("学生信息录入成功！");
            else System.out.println("学生信息录入失败请重试!");
        });
    }

    public static void addBook(Scanner scanner){
        System.out.print("请输入书籍名称:");
        String title = scanner.nextLine();
        System.out.print("请输入书籍简介:");
        String desc = scanner.nextLine();
        System.out.print("请输入书籍价格:");
        String price = scanner.nextLine();
        double p = Double.parseDouble(price);
        Book book = new Book(title,desc,p);
        SqlUtil.doSqlwork(mapper -> {
            int i = mapper.addBook(book);
            if(i>0)System.out.println("书籍信息录入成功！");
            else System.out.println("书籍信息录入失败请重试!");
        });
    }

    public static void addBorrow(Scanner scanner){
        System.out.print("请输入学号:");
        String a = scanner.nextLine();
        int sid = Integer.parseInt(a);
        System.out.print("请输入书籍号:");
        String b = scanner.nextLine();
        int bid = Integer.parseInt(b);
        SqlUtil.doSqlwork(mapper -> {mapper.addBorrow(sid, bid);
        });
    }

    public static void showBorrow(){
       SqlUtil.doSqlwork(mapper -> {
           mapper.getBorrowList().forEach(borrow -> {
               System.out.println(borrow .getStudent().getName() + "->" +borrow.getBook().getTitle());});
       });
    }

    public static void showStudent(){
        SqlUtil.doSqlwork(mapper -> {
            mapper.getStudentList().forEach(student -> {
                System.out.println(student.getSid() + "," +student.getName()+""+student.getSex()+","+student.getGrade()+"级");});
        });
    }

    public static void showBook(){
        SqlUtil.doSqlwork(mapper -> {
            mapper.getBookList().forEach(book -> {
                System.out.println(book.getBid() + "," +book.getTitle()+","+book.getDesc()+","+book.getPrice());});
        });
    }
}
