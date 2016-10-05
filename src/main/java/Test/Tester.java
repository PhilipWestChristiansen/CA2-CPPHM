package Test;

import java.util.HashMap;
import javax.persistence.Persistence;

public class Tester {
    
    public static void main(String[] args) {
        HashMap<String, Object> puproperties = new HashMap<>();
        puproperties.put("javax.persistence.sql-load-script-source", "scripts/clearDB.sql");
        puproperties.put("javax.persistence.sql-load-script-source", "scripts/notsomanyzipcodes.sql");
//        Persistence.generateSchema("ca2_pu", null);
        Persistence.generateSchema("ca2_pu", puproperties);
    }
}