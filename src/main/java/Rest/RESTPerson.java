/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entity.Hobby;
import Entity.Person;
import Facade.personFacade;
import Mapper.PersonMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author hamzalaroussi
 */
@Path("person")
public class RESTPerson
{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca2_pu");
    personFacade pf = new personFacade(emf);

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public RESTPerson()
    {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("complete/{id}")
    public String getPerson(@PathParam("id") int id)
    {
        
        Person p = pf.getPerson(id);
        PersonMapper map = new PersonMapper(p);
        
        
        
        
        return new Gson().toJson(map);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("complete")
    public String getPersons()
    {
        
        List<Person> list = pf.getPersons();
        for (int i = 1; i < list.size()+1; i++)
        {
          Person p = pf.getPerson(i);
          PersonMapper map = new PersonMapper(p);
          return new Gson().toJson(map);
        }
        
        return  "mistake";

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("contract")
    public String getPersonContact()
    {

        List<Person> list = pf.getPersons();
        return new Gson().toJson(list);

    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content)
    {
    }
}
