/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import com.google.gson.annotations.Expose;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author pwc
 */
@Entity
public class Company extends InfoEntity {

    @Expose String name;
    @Expose String description;
    @Expose String cvr;
    @Expose int NumEmployees;
    @Expose double marketValue;

    public Company() {
    }

    public Company(String name, String description, String cvr, int NumEmployees, double marketValue, String email, List<Phone> phones, Address address) {
        super(email, phones, address);
        this.name = name;
        this.description = description;
        this.cvr = cvr;
        this.NumEmployees = NumEmployees;
        this.marketValue = marketValue;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }

    public int getNumEmployees() {
        return NumEmployees;
    }

    public void setNumEmployees(int NumEmployees) {
        this.NumEmployees = NumEmployees;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }
    
}
