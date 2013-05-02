/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Pubudu Tennakoon
 */
import javax.mail.*;                                                                                                                
import javax.mail.internet.*;                                                                                                    
import java.util.*;                                                                                                                    
                                                                                                                                                            
public class SendMailUsingAuthentication                                                                               
{                                                                                                                                            
  public static final String SMTP_HOST_NAME = "smtp.gmail.com";  // for google                
  public static final String SMTP_AUTH_USER = "presbyterian.library@gmail.com";             // Username                        
  public static final String SMTP_AUTH_PWD  = "pgs123456";          // Password                     
                                                                                                                                             

  // Add List of Email address to who email needs to be sent to                                               
  public void postMail( String recipients[ ], String subject,                                                       
                            String message , String from) throws MessagingException                          
  {                                                                                                                                         
    boolean debug = false;                                                                                                       
     //Set the host smtp address                                                                                               
     Properties props = new Properties();                                                                                
      props.put("mail.smtp.starttls.enable","true");                                                                     
     props.put("mail.smtp.host", SMTP_HOST_NAME);                                                        
     props.put("mail.smtp.auth", "true");                                                                                    

    Authenticator auth = new SMTPAuthenticator();                                                                
    Session session = Session.getDefaultInstance(props, auth);                                                 

    session.setDebug(debug);                                                                                                  

    // create a message                                                                                                            
    Message msg = new MimeMessage(session);                                                                    

    // set the from and to address                                                                                            
    InternetAddress addressFrom = new InternetAddress(from);                                             
    msg.setFrom(addressFrom);                                                                                             

    InternetAddress[] addressTo = new InternetAddress[recipients.length];                             
    for (int i = 0; i < recipients.length; i++)                                                                               
    {                                                                                                                                      
        addressTo[i] = new InternetAddress(recipients[i]);                                                        
    }                                                                                                                                      
    msg.setRecipients(Message.RecipientType.TO, addressTo);                                             
    // Setting the Subject and Content Type                                                                            
    msg.setSubject(subject);                                                                                                  
    msg.setContent(message, "text/plain");                                                                              
    Transport.send(msg);                                                                                                       
 }                                                                                                                                        


/**                                                                                                                                      
* SimpleAuthenticator is used to do simple authentication                                                     
* when the SMTP server requires it.                                                                                    
*/                                                                                                                                        
private class SMTPAuthenticator extends javax.mail.Authenticator                                        
{                                                                                                                                          

        @Override                                                                                                                   
    public PasswordAuthentication getPasswordAuthentication()                                             
    {                                                                                                                                      
        String username = SMTP_AUTH_USER;                                                                    
        String password = SMTP_AUTH_PWD;                                                                     
        return new PasswordAuthentication(username, password);                                             
    }                                                                                                                                       
} 
}

