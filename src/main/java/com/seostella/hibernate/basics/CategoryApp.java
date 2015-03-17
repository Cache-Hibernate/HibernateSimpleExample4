package com.seostella.hibernate.basics;

import com.seostella.hibernate.basics.dao.CategoryDAO;
import com.seostella.hibernate.basics.entity.Article;
import com.seostella.hibernate.basics.entity.Category;

import java.util.Iterator;
import java.util.List;
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
public class CategoryApp {
    private static Logger logger = Logger.getLogger(CategoryApp.class.getName());

    public static void main(String[] args) {
        try {
            List categories = new CategoryDAO().list();
            Iterator ci = categories.iterator();
            while (ci.hasNext()) {
                Category category = (Category) ci.next();
                System.out.println("Категория: " + category.getTitle());
                Iterator ai = category.getArticles().iterator();
                while (ai.hasNext()) {
                    Article advert = (Article) ai.next();
                    System.out.println(" Название: " + advert.getTitle());
                    System.out.println(" Сообщение: " + advert.getMessage());
                    System.out.println("  Автор: " + advert.getUser().getName());
                    System.out.println();
                }
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
}
