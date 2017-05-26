

/**
 * Created by cs.ucu.edu.ua on 04.05.2017.
 */

import java.sql.*;
import java.lang.String;
import java.util.ArrayList;

public class InfToDB {

    public void infToDB(Job job) throws Exception
    /** connect to db
     * insert information from first xml to db
     *
     */
    {
        //Class.forName("InfToDB");

        String server = "localhost\\SOLEXPRESS";
        int port = 1433;
        String database = "Parallel_Processing";
        String Url = "jdbc:sqlserver://"+server+":"+port+";databaseName="+database+";integratedSecurity=true";

        Connection con = DriverManager.getConnection(Url);

        int clientID=job.getClientID();
        //System.out.print(clientID);
        int projectID=job.getProjectID();

        //check whether client and project in table->names?id not null?
        //String s = "insert into Client (ID, Name) values (1, 'Ola'), (2 ,'Natalia')";
        //String s = "insert into Project (ID, Name, Client_ID) values (1, 'Twitter', 1), (2 ,'Facebook', 1),  (3, 'VK', 2)";


        String sql = "insert into Task (Project_ID, Data, Status) values ("+projectID+",? ,"+" 0 )";
        PreparedStatement stmt = con.prepareStatement(sql);

        ArrayList<JobItem>items=job.getItems();
        for(int i=0;i<items.size();i++){
            stmt.setString(1, items.get(i).getData());
            stmt.executeUpdate();
        }

       stmt.close();
       con.close();

    }
}
