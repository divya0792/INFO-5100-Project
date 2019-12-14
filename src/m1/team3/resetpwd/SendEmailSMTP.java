package m1.team3.resetpwd;

import com.sun.mail.smtp.SMTPTransport;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendEmailSMTP {
	private static final String SMTP_SERVER = "smtp.gmail.com";
	private static final String USERNAME = "infojava5100@gmail.com";
	private static final String PASSWORD = "javaproject";
	private static final String EMAIL_FROM = "infojava5100@gmail.com";
	private static final String EMAIL_SUBJECT = "Your Password Recovery OTP";
	private static final String EMAIL_TEXT = "Use this OTP to reset your Password\n%s";

	public static boolean sendOTP(String custEmail, int otp) {
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", SMTP_SERVER); // optional, defined in SMTPTransport
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true"); //TLS
		Session session = Session.getInstance(prop, null);
		Message msg = new MimeMessage(session);

		try {
			msg.setFrom(new InternetAddress(EMAIL_FROM));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(custEmail, false));
			msg.setSubject(EMAIL_SUBJECT);
			msg.setText(String.format(EMAIL_TEXT, otp));
			msg.setSentDate(new Date());
			SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
			t.connect(SMTP_SERVER, USERNAME, PASSWORD);
			t.sendMessage(msg, msg.getAllRecipients());
			System.out.println("Response: " + t.getLastServerResponse());
			t.close();
			return true;

		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}

	}
}
