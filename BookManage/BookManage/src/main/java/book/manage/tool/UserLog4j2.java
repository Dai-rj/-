package book.manage.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserLog4j2 {
    private static  final Logger logger = LoggerFactory.getLogger(UserLog4j2.class);

    public static void main(String[] args){
        logger.trace("trace");
    }
}