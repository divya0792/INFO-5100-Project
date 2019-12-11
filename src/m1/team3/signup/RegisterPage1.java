package m1.team3.signup;

import dataproto.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import m1.DAO.DealerDAOImpl;

public class RegisterPage1 {

  private JFrame frame;
  private JFormattedTextField formattedTextField, formattedTextField_2, formattedTextField_3,
      formattedTextField_4, ImageUrl;
  private JPasswordField formattedTextField_5, formattedTextField_6;
  private JLabel lblname, lblEmailAddress, Address, lblContact, lblCreatePassword, lblRewritePassword, lbIMsg,
      Image;
  Dealer dealer = new Dealer();

  public static void main(String[] args) {
    new RegisterPage1();
  }

  public RegisterPage1() {
    initialize();
  }

  private void NameText(JPanel panel) {
    formattedTextField = new JFormattedTextField();
    formattedTextField.setBounds(260, 40, 282, 43);
    panel.add(formattedTextField);
  }

  private void EmailText(JPanel panel) {
    formattedTextField_2 = new JFormattedTextField();
    formattedTextField_2.setBounds(260, 120, 282, 43);
    panel.add(formattedTextField_2);
  }

  private void contactText(JPanel panel) {
    formattedTextField_3 = new JFormattedTextField();
    formattedTextField_3.setBounds(260, 200, 282, 43);
    panel.add(formattedTextField_3);
  }

  private void AddressText(JPanel panel) {
    formattedTextField_4 = new JFormattedTextField();
    formattedTextField_4.setBounds(260, 280, 282, 43);
    panel.add(formattedTextField_4);
  }

  private void ImageText(JPanel panel) {
    ImageUrl = new JFormattedTextField();
    ImageUrl.setBounds(260, 360, 282, 43);
    panel.add(ImageUrl);
  }

  private void createPasswordText(JPanel panel) {
    formattedTextField_5 = new JPasswordField();
    formattedTextField_5.setBounds(260, 440, 282, 43);
    panel.add(formattedTextField_5);
  }

  private void confirmPasswordText(JPanel panel) {
    formattedTextField_6 = new JPasswordField();
    formattedTextField_6.setBounds(260, 520, 282, 43);
    panel.add(formattedTextField_6);
  }

  private void addName(JPanel panel) {
    lblname = new JLabel("Name:");
    lblname.setBounds(53, 40, 97, 43);
    panel.add(lblname);
  }

  private void addEmailAddress(JPanel panel) {
    lblEmailAddress = new JLabel("Email Address:");
    lblEmailAddress.setBounds(53, 120, 151, 43);
    panel.add(lblEmailAddress);
  }

  private void addContact(JPanel panel) {
    lblContact = new JLabel("Phone:");
    lblContact.setBounds(53, 200, 97, 43);
    panel.add(lblContact);
  }

  private void addAddress(JPanel panel) {
    Address = new JLabel("Address:");
    Address.setBounds(53, 280, 97, 43);
    panel.add(Address);
  }

  private void addImage(JPanel panel) {
    Image = new JLabel("ImageUrl:");
    Image.setBounds(53, 360, 97, 43);
    panel.add(Image);
  }

  private void createPassword(JPanel panel) {
    lblCreatePassword = new JLabel("Create Password");
    lblCreatePassword.setBounds(53, 440, 151, 43);
    panel.add(lblCreatePassword);
  }

  private void rewritePassword(JPanel panel) {
    lblRewritePassword = new JLabel("Rewrite Password");
    lblRewritePassword.setBounds(53, 520, 151, 43);
    panel.add(lblRewritePassword);
  }

  private void addlbIMsg(JPanel panel) {
    lbIMsg = new JLabel("");
    lbIMsg.setBounds(53, 600, 600, 43);
    lbIMsg.setForeground(Color.RED);
    panel.add(lbIMsg);
  }

  private void button1(JPanel panel) {
    JButton btnSave = new JButton("Save");
    btnSave.setBounds(103, 700, 193, 62);
    panel.add(btnSave);
    btnSave.addActionListener(new ActionListener() {

      @SuppressWarnings("deprecation")
      @Override
      public void actionPerformed(ActionEvent e) {
        lbIMsg.setText("");
        String strName = lblname.getText();
        String email = formattedTextField_2.getText();
        if (!isEmail(email)) {
          lbIMsg.setText("Invalid Email");
        }
        String phone = formattedTextField_3.getText();
        if (!IsTelephone(phone))
          lbIMsg.setText("Invalid Phone Number");

        if (strName == null || strName.equals("")) {

          Address.setText("Name cannot be emp");
          return;
        }
        String strPwd = new String(formattedTextField_5.getPassword());
        if (strPwd == null || strPwd.equals("")) {

          lbIMsg.setText("PassWord cannot be empty");
          return;
        }
        String strRePwd = new String(formattedTextField_6.getPassword());
        if (!checkCharTypes(strRePwd)) {
          lbIMsg.setText("Your password has to include at least 1 uppercase, 1 lowercase and 1 digit");
          return;
        }
        if (strRePwd == null || strRePwd.equals("")) {

          lbIMsg.setText("confirm password cannot be empty");
          return;
        }

        if (!strRePwd.equals(strPwd)) {
          lbIMsg.setText("the confirm password different from origin password");
          return;
        }
        if (lbIMsg.getText() == "") {
          dealer.setName(formattedTextField.getText());
          dealer.setIconURL(ImageUrl.getText());
          dealer.setEmailId(formattedTextField_2.getText());
          dealer.setAddress(formattedTextField_4.getText());
          dealer.setPhone(formattedTextField_3.getText());
          dealer.setPassword(formattedTextField_5.getText());
          DealerDAOImpl.INSTANCE.insertDealer(dealer);
        }
      }
    });
  }

  private void button2(JPanel panel) {
    JButton btnCancel = new JButton("Cancel");
    btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
      }
    });
    btnCancel.setBounds(476, 700, 193, 62);
    panel.add(btnCancel);
  }

  private void add(JPanel panel) {
    NameText(panel);
    EmailText(panel);
    contactText(panel);
    AddressText(panel);
    createPasswordText(panel);
    confirmPasswordText(panel);
    addName(panel);
    addEmailAddress(panel);
    addContact(panel);
    createPassword(panel);
    rewritePassword(panel);
    button1(panel);
    button2(panel);
    addAddress(panel);
    addlbIMsg(panel);
    addImage(panel);
    ImageText(panel);
  }

  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 771, 876);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setTitle("Register Page");
    frame.setVisible(true);
    JPanel panel = new JPanel();
    frame.getContentPane().add(panel, BorderLayout.CENTER);
    panel.setLayout(null);
    add(panel);
    panel.setBackground(Color.LIGHT_GRAY); // background color
  }

  public static boolean isEmail(String email) {
    if (!email.contains("@"))
      return false;
    return true;
  }

  public static boolean IsTelephone(String str) {
    Pattern pattern = Pattern.compile("[0-9]{1,}");
    Matcher matcher = pattern.matcher((CharSequence) str);
    return matcher.matches();
  }

  public boolean checkCharTypes(String password) {
    int upperCase = 0, lowerCase = 0, digit = 0;
    for (Character ch : password.toCharArray()) {
      if (Character.isUpperCase(ch)) {
        upperCase += 1;
      } else if (Character.isLowerCase(ch)) {
        lowerCase += 1;
      } else if (Character.isDigit(ch)) {
        digit += 1;
      }
    }

    if (upperCase >= 1 && lowerCase >= 1 && digit >= 1) {
      return true;
    }
    return false;
  }
}
