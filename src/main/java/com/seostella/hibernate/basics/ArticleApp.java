package com.seostella.hibernate.basics;

import com.seostella.hibernate.basics.dao.ArticleDAO;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 03/02/2015
 * {@link http://www.seostella.com/ru/article/2012/03/17/osnovy-hibernate-3-na-primere-raboty-s-mysql.html}
 * ********************************************************************************************************
 * {@link http://www.sql.ru/forum/915534/mappedby-hibernate}
 * {@link http://www.spring-source.ru/docs_simple.php?type=manual&theme=docs_simple&docs_simple=chap04_p03}
 * {@link https://www.youtube.com/watch?v=jAi8bY-H_ek}
 * ********************************************************************************************************
 */
public class ArticleApp 
{
    private static Logger logger = Logger.getLogger(ArticleApp.class.getName());

    public static void main(String[] args) {
        try {
            ArticleDAO articleDAO = new ArticleDAO();
            articleDAO.createArticle( "oleg", "mycat", "test title", "test message");
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
}
