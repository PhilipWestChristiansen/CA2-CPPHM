/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

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
    
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca2_pu");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        List<Phone> phones = new ArrayList();
        List<Hobby> hobbies = new ArrayList();
        
        Phone ph = new Phone(12345678, "test");
        Hobby hb = new Hobby("test1", "test2");
        
        phones.add(ph);
        hobbies.add(hb);
        
        Person p = new Person("Casper", "Lindinger", hobbies, "mikkel@gmail.com", phones);
        em.persist(p);
        
        em.getTransaction().commit();
        em.close();
    }
    
}
