package com.text;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static book.manage.tool.SqlUtil.doSqlwork;
@Log4j2
public class MainText {
   @Test
    public void text1(){
        doSqlwork(mapper -> {
            mapper.getBorrowList().forEach(System.out::println);
                }
        );
    }

    @Test
    public void text2(){
        doSqlwork(mapper -> {
            mapper.getStudentList().forEach(System.out::println);
                }
        );
    }
    @Test
    public void text3(){
        doSqlwork(mapper -> {
                    mapper.getBookList().forEach(System.out::println);
                }
        );
    }
}
