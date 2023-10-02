package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
   
    public static final int TERMID_FA23 = 1;
   
    public static String getResultSetAsJson(ResultSet resultset) {
       
        String result;

        
        JsonArray json = new JsonArray();

        try {

           
            ResultSetMetaData metadata = resultset.getMetaData();
            int columnCount = metadata.getColumnCount();

            while (resultset.next()) {
                JsonObject row = new JsonObject();

                for (int k = 1; k <= columnCount; ++k) {
                    String columnname = metadata.getColumnName(k);
                    row.put(columnname, resultset.getObject(k).toString());

                }
                json.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

       
        result = json.toString();
        return result;
       
    }
   
}