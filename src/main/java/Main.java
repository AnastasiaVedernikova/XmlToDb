import java.util.Arrays;

/**
 * Created by cs.ucu.edu.ua on 16.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        //delete-DBCC CHECKIDENT ('Task', RESEED, 0);
        //GO
        Validation validation = new Validation();
        GetInfFromXML getInfFromXML = new GetInfFromXML();
        InfToDB infToDB = new InfToDB();
        boolean flag = true;
        try{
            validation.validate("data.xml", "data.xsd");
            Job xml = getInfFromXML.getInformation("data.xml");
            infToDB.infToDB(xml);

        }catch (Exception e){
            flag = false;
            System.out.print("Exeption"+ e.getMessage());
        }
        System.out.print(flag);

    }
}
