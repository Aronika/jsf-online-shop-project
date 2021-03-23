package com.aronika;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean
@ApplicationScoped
public class Shop {

    private List<Artikel> sortiment = new ArrayList<Artikel>();
    private static final Shop instance = new Shop();

    public Shop() {

        //Sortiment füllen.
        this.sortiment.add(new Artikel(1001, "Pantoffeln \"Rudolph\"",
                "Wunderschöne Filzpantoffeln", "img/filzschuhe.jpg",
                (new GregorianCalendar(2012, 11, 23).getTime())));
        this.sortiment.add(new Artikel(1002, "Handtasche \"Cosmopolita\"",
                "Modische Filz-Handtasche mit praktischer Cocktailglas-Halterung",
                "img/handtasche.jpg", (new GregorianCalendar(2010, 10, 3).getTime())));
        this.sortiment.add(new Artikel(1003, "Filz-Hasen \"Moe & Joe\"",
                "Zwei putzige Hasen aus Filz zur Dekoration",
                "img/hasen.png", (new GregorianCalendar(2013, 11, 31).getTime())));

    }

    public List<Artikel> getSortiment() {
        //        System.out.println("aaa ===>");
        //        System.out.println(getInstance().sortiment);
        //        System.out.println(getInstance().sortiment.hashCode());
        //        return getInstance().sortiment;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("onlineshop");
        EntityManager em = emf.createEntityManager();
        List result = em.createQuery("from Artikel", Artikel.class).getResultList();
        em.close();
        emf.close();
        return result;
    }

    public static Shop getInstance() {
        return instance;
    }

}