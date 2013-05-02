/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import GUI.Login_GUI;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author Pubudu Tennakoon
 */
public class LMS {
     public static void main(String[] args) {
    try {
            LookAndFeel look = new WindowsLookAndFeel();
            UIManager.setLookAndFeel(look);
            new Login_GUI().setVisible(true);
        
        // Child_Member_View Welcome_Screen()
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
}
    
}
