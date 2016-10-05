/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import Entity.Address;
import Entity.Phone;
import java.util.List;

/**
 *
 * @author hamzalaroussi
 */
public class PersonMapper
{
 int id; 
 String firstname;
 String lastname;
 String email;
 List <Phone> phones;
 String street;
 String additionalInfo;
 String zipcode;
 String city;
 public PersonMapper(Entity.Person p)
 {
     id = p.getId();
     firstname = p.getFirstName();
     lastname = p.getLastName();
     email = p.getEmail();
     phones = p.getPhones();
     street = p.getAddress().getStreet();
     additionalInfo = p.getAddress().getAdditionalInfo();
     city = p.getAddress().getCityInfo().getCity();
     zipcode = p.getAddress().getCityInfo().getZip();
     
 }
}
