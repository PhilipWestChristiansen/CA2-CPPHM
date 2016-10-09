package Facade;

import Entity.CityInfo;
import Entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class CityInfoFacade {
EntityManagerFactory emf;

    public CityInfoFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public CityInfo getCity(String zip) {
        EntityManager em = emf.createEntityManager();

        CityInfo ci = null;

        try {
            em.getTransaction().begin();
            ci = em.find(CityInfo.class, zip);
            em.getTransaction().commit();
            return ci;
        } finally {
            em.close();
        }
    }
}
