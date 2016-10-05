/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entity.Address;
import Entity.CityInfo;
import Entity.Hobby;
import Entity.Person;
import Entity.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pwc
 */
public class Populate {

    public static void main(String[] args) {
//        cityTest();
        personTest();
    }
    static CityInfo ci = new CityInfo("2830", "Virum");

    public static void cityTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca2_pu");
        EntityManager em = emf.createEntityManager();

        //Laver en ny by
        em.getTransaction().begin();
        ci = new CityInfo("2830", "Virum");
        em.persist(ci);
        em.getTransaction().commit();
        em.close();
    }

    public static void personTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca2_pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        List<Phone> phones = new ArrayList();
        List<Hobby> hobbies = new ArrayList();
        Phone ph = new Phone(12345678, "test");
        Hobby hb = new Hobby("test1", "test2");
        Address a = new Address("Cedervænget", "Det er et noice sted", ci);

        phones.add(ph);
        hobbies.add(hb);

        Person p = new Person("Casper", "Lindinger", hobbies, "hey", phones, a);
        em.persist(p);
        em.getTransaction().commit();

        em.close();
    }

}
