/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Pubudu Tennakoon
 */
public class DB {
     public static Connection myCon() throws Exception { //Connecting DataBase

        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/lms1", "root", "pubudu91");
}
}
