/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import com.google.gson.annotations.Expose;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author pwc
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class InfoEntity { 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    String email;
    
    @OneToMany(cascade = CascadeType.ALL)
    List <Phone> phones;
    
    @ManyToOne(cascade = 
        CascadeType.PERSIST)
    Address address;

    public InfoEntity(String email, List<Phone> phones, Address address) {
        this.email = email;
        this.phones = phones;
        this.address = address;
    }
    
    
    public InfoEntity() {
    }

    public InfoEntity(String email) {
        this.email = email;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress()
    {
        return address;
    }
    
    
}
