package Entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-09T11:19:13")
@StaticMetamodel(Company.class)
public class Company_ extends InfoEntity_ {

    public static volatile SingularAttribute<Company, String> name;
    public static volatile SingularAttribute<Company, Integer> NumEmployees;
    public static volatile SingularAttribute<Company, String> description;
    public static volatile SingularAttribute<Company, Double> marketValue;
    public static volatile SingularAttribute<Company, String> cvr;

}