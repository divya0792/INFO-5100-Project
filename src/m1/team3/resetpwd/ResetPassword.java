package m1.team3.resetpwd;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.util.Optional;

import dataproto.Dealer;
import m1.DAO.DealerDAOImpl;
import m1.team3.login.LoginServiceImpl;

public class ResetPassword {
  JFrame frame = new JFrame("Reset Password");
  Container c = frame.getContentPane();

  JLabel username = new JLabel("E-mail/Phone:           ");
  JLabel newPassword = new JLabel("New Password:     ");
  JLabel confirmPassword = new JLabel("Confirm Password:");

  JTextField field1 = new JTextField(14);
  JPasswordField field2 = new JPasswordField(14);
  JPasswordField field3 = new JPasswordField(14);

  JButton confirm = new JButton("save");
  JButton cancel = new JButton("cancel");

  JPanel jp1 = new JPanel();
  JPanel jp2 = new JPanel();
  JPanel jp3 = new JPanel();
  JPanel jp4 = new JPanel();
  LoginServiceImpl loginServiceImpl = new LoginServiceImpl();

  public ResetPassword() {
    frame.setVisible(true);
    frame.setSize(400, 500);
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    add();
    cancelHandle();
    confirmHandle();
  }

  public void add() {
    jp1.add(username);
    jp1.add(field1);

    jp2.add(newPassword);
    jp2.add(field2);

    jp3.add(confirmPassword);
    jp3.add(field3);

    jp4.add(confirm);
    jp4.add(cancel);

    GridLayout gl = new GridLayout(4, 1);
    c.setLayout(gl);

    c.add(jp1);
    c.add(jp2);
    c.add(jp3);
    c.add(jp4);
  }

  private void cancelHandle() {
    cancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
      }
    });
  }

  private void confirmHandle() {
    confirm.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        char[] password = field2.getPassword();
        String ps = String.valueOf(password);
        boolean checkSuccess = false;
        if (field1.getText().length() <= 0) {
          JOptionPane.showMessageDialog(null, "E-mail/Phone cannot be blank!");
        } else {
          checkSuccess = checkPassword(password, ps);
        }

        // update new password
        if (checkSuccess) {
          updateNewPassword(field1.getText(), ps);
        }
      }
    });
  }

  private boolean checkPassword(char[] password, String ps) {
    char[] comfirmPassword = field3.getPassword();
    String cps = String.valueOf(comfirmPassword);
    boolean ret = true;
    if (ps.length() <= 0 && cps.length() <= 0) {
      JOptionPane.showMessageDialog(null, "Please enter your password. ");
      ret = false;
    } else if (!ps.equals(cps)) {
      JOptionPane.showMessageDialog(null, "Your password do not MATCH! ");
      ret = false;
    } else if (!checkCharTypes(ps)) {
      JOptionPane.showMessageDialog(null, "Your password has to include at least 1 uppercase, 1 lowercase and 1 digit");
      ret = false;
    }
    return ret;

  }

  private boolean checkCharTypes(String password) {

    // at least including 1 uppercase, 1 lowercase, 1 digit.
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

  public void updateNewPassword(String username, String password) {
    Dealer dealer = loginServiceImpl.getDealer(username);
    if (dealer == null) {
      JOptionPane.showMessageDialog(null, "User does not exist! ");
    } else {
      dealer.setPassword(password);
      boolean isSuccessful = DealerDAOImpl.INSTANCE.updateDealer(dealer);
      if (isSuccessful) {
        JOptionPane.showMessageDialog(null, "Reset Successfully!");
      } else {
        JOptionPane.showMessageDialog(null, "Fail to reset password!");
      }
    }
  }

  public static void main(String[] args) {
    new SendEmail();
  }
}
