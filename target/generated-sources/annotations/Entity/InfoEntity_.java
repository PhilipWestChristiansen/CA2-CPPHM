package Entity;

import Entity.Phone;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-04T13:56:40")
@StaticMetamodel(InfoEntity.class)
public class InfoEntity_ { 

    public static volatile ListAttribute<InfoEntity, Phone> phones;
    public static volatile SingularAttribute<InfoEntity, Integer> id;
    public static volatile SingularAttribute<InfoEntity, String> email;

}