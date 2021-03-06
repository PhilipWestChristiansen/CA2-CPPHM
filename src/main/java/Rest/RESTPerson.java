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
import javax.ws.rs.POST;
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
    String jsonString = "[";
    List<Person> list = pf.getPersons();

    for (int i = 1; i < list.size() + 1; i++)
    {
      Person p = pf.getPerson(i);
      PersonMapper map = new PersonMapper(p);

      jsonString += new Gson().toJson(map);

      if (i != list.size())
      {
        jsonString += ",";
      }

      jsonString += "\n";

    }

    jsonString += "]";

    return jsonString;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("contract")
  public String getPersonContact()
  {

    List<Person> list = pf.getPersons();
    return new Gson().toJson(list);

  }

  @POST
  //@Produces(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String postJson(String content)
  {
    
    Person p = pf.addPerson(new Gson().fromJson(content, Person.class));
    
    return new Gson().toJson(p);
  }
}
