package Entity;

import Entity.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-05T16:58:43")
@StaticMetamodel(Hobby.class)
public class Hobby_ { 

    public static volatile ListAttribute<Hobby, Person> persons;
    public static volatile SingularAttribute<Hobby, String> name;
    public static volatile SingularAttribute<Hobby, String> description;
    public static volatile SingularAttribute<Hobby, Integer> id;

}