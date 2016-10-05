package Test;

import java.util.HashMap;
import javax.persistence.Persistence;

public class Tester {
    
    public static void main(String[] args) {
        HashMap<String, Object> puproperties = new HashMap<>();
        puproperties.put("javax.persistence.sql-load-script-source", "scripts/clearDB.sql");
        Persistence.generateSchema("ca2_pu", puproperties);
        Persistence.generateSchema("ca2_pu", null);
    }
}