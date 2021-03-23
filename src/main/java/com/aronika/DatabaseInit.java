package com.aronika;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DatabaseInit implements ServletContextListener {

//    public static final String JDBC_URL = "jdbc:h2:C:/programming/jsf-online-shop-project/db/h2-testdb;MODE=MYSQL";
//    public static final String JDBC_USER = "sa";
//    public static final String JDBC_PASSWORD = "";

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println();
        System.out.println("Hello! :)");

//        executeSqlQuery(
//        "CREATE TABLE cities ("
//                + "id INT auto_increment PRIMARY KEY,"
//                + "city VARCHAR(100), "
//                + "number INT );");
//
//        executeSqlQuery(
//                "INSERT INTO cities (city, number) VALUES "
//                + "('Berlin', 1000), "
//                + "('Hamburg', 5000), "
//                + "('Aachen', 2000), "
//                + "('Frankfurt', 3000);");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("onlineshop");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Artikel artikel1 = new Artikel(
                "Pantoffeln \"Rudolph\"",
                "Wunderschöne Filzpantoffeln",
                "img/filzschuhe.jpg",
                new GregorianCalendar(2012, 11, 23).getTime());
        em.persist(artikel1);

        Artikel artikel2 = new Artikel(
                "Handtasche \"Cosmopolita\"",
                "Modische Filz-Handtasche mit praktischer Cocktailglas-Halterung",
                "img/handtasche.jpg",
                new GregorianCalendar(2010, 10, 3).getTime());
        em.persist(artikel2);

        Artikel artikel3 = new Artikel(
                "Filz-Hasen \"Moe & Joe\"",
                "Zwei putzige Hasen aus Filz zur Dekoration",
                "img/hasen.png",
                new GregorianCalendar(2013, 11, 31).getTime());
        em.persist(artikel3);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println();
        System.out.println("Initialization is done!");
        System.out.println();
    }

//    private static void executeSqlQuery(String sqlQuery) {
//
//        try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
//
//            Statement st = con.createStatement();
//            st.execute(sqlQuery);
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("Good bye! :)");
    }
}