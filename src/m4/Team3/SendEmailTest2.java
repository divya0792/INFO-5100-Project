
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailTest2 {
    public static void main(String[] args) {
        String recipient = "info5100finaltestr@gmail.com";
        String subject = "subject test";
        String content = "content test";

        gmailSender(recipient, subject, content);
    }

    /*
     * gmail SSL
     */
    private static void gmailssl(Properties props) {
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        props.put("mail.debug", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
    }

    /*
     * send email
     */
    public static void gmailSender(String email, String subject, String content) {

        // Get a Properties object
        Properties props = new Properties();
        // ssl
        gmailssl(props);

        final String username = "info5100finaltest@gmail.com";// gmail address
        final String password = "info5100";// password
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        // -- Create a new message --
        Message msg = new MimeMessage(session);

        // -- Set the FROM and TO fields --
        try {
            msg.setFrom(new InternetAddress(username));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            msg.setSubject(subject);
            msg.setText(content);
            msg.setSentDate(new Date());
            Transport.send(msg);
        } catch (AddressException e) {
            System.out.println("AddressException:");
            e.printStackTrace();
        } catch (MessagingException e) {
            System.out.println("MessagingException:");
            e.printStackTrace();
        }

        System.out.println("Message sent.");
    }

}
