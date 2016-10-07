/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Address;
import Entity.CityInfo;
import Entity.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Philip
 */
public class personFacadeTest
{
    EntityManagerFactory emf;
    personFacade fp;
    
    public personFacadeTest()
    {
        fp = new personFacade();
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
        HashMap<String, Object> puproperties = new HashMap<>();
        Persistence.generateSchema("ca2_pu", puproperties);
        
        System.out.println("SetUp");
        emf = Persistence.createEntityManagerFactory("ca2_pu_test");
        fp.setEmf(emf);
        
        System.out.println("DB: " + fp.getPersons().size());
        
        List hobbies = new ArrayList<>();
        List phones = new ArrayList<>();
        CityInfo ci = new Entity.CityInfo("123456", "Putcity");
        Address a = new Entity.Address("Putinstreet", "Putins own street", ci);
        hobbies.add(new Entity.Hobby("President", "kfoe"));
        phones.add(new Entity.Phone(88888888, "Presidents number"));
        
        p = fp.addPerson(new Person("Vlad", "Putin", hobbies, "hey@hey.com", phones, a));
 
        System.out.println("DB: " + fp.getPersons().size());
    }
    
    Person p;
    Person p2;
    
    @After
    public void tearDown()
    {
        System.out.println("TearDown");
        emf.close();
        HashMap<String, Object> puproperties = new HashMap();
        puproperties.put("javax.persistence.schema-generation.database.action", "drop-and-create");
        Persistence.generateSchema("ca2_pu_test", puproperties);
        Persistence.generateSchema("ca2_pu_test", null);
    }

    /**
     * Test of main method, of class personFacade.
     */
//    @Test
//    public void testMain()
//    {
//        System.out.println("main");
//        String[] args = null;
//        personFacade.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPerson method, of class personFacade.
//     */
    @Test
    public void testGetPerson()
    {
        Person expResult = p;
        Person Result = fp.getPerson(1);
        assertEquals(expResult.getFirstName(), Result.getFirstName());
    }
//
//    @Test
//    public void testGetPersons()
//    {
//        System.out.println("getPersons");
//        personFacade instance = null;
//        List<Person> expResult = null;
//        List<Person> result = instance.getPersons();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    
    @Test
    public void testAddPerson()
    {
        List hobbies = new ArrayList<>();
        List phones = new ArrayList<>();
        CityInfo ci = new Entity.CityInfo("987", "ObamaCity");
        Address a = new Entity.Address("Obamastreet", "Obamas own street", ci);
        hobbies.add(new Entity.Hobby("PresidentOfUS", "kfoe"));
        phones.add(new Entity.Phone(12344321, "Presidents number"));
        
        p2 = fp.addPerson(new Person("Barrack", "Obama", hobbies, "heyyou@hey.com", phones, a));
        
        assertEquals(2, fp.getPersons().size());
    }
//
//    /**
//     * Test of deletePerson method, of class personFacade.
//     */
//    @Test
//    public void testDeletePerson()
//    {
//        System.out.println("deletePerson");
//        int id = 0;
//        personFacade instance = null;
//        Person expResult = null;
//        Person result = instance.deletePerson(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of editPerson method, of class personFacade.
//     */
//    @Test
//    public void testEditPerson()
//    {
//        System.out.println("editPerson");
//        Person pers = null;
//        personFacade instance = null;
//        Person expResult = null;
//        Person result = instance.editPerson(pers);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}