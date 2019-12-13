package dataproto;

import java.util.Collection;

public class Dealer extends DataObject {
  private String name;
  private String password;
  private String address;
  private String phone;
  private String emailId;
  private String iconURL;

  private String headInfoId;
  private String footInfoId;
  private String leftInfoId;
  private String rightInfoId;

  public Dealer() {
    
  }
  public Dealer(String id, String name, String password) {
    this.setId(id);
    this.name = name;
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public void setIconURL(String iconURL) {
    this.iconURL = iconURL;
  }

  public String getIconURL() {
    return iconURL;
  }

  public String getHeadInfoId() {
    return headInfoId;
  }

  public void setHeadInfoId(String headInfoId) {
    this.headInfoId = headInfoId;
  }

  public String getFootInfoId() {
    return footInfoId;
  }

  public void setFootInfoId(String footInfoId) {
    this.footInfoId = footInfoId;
  }

  public String getLeftInfoId() {
    return leftInfoId;
  }

  public void setLeftInfoId(String leftInfoId) {
    this.leftInfoId = leftInfoId;
  }

  public String getRightInfoId() {
    return rightInfoId;
  }

  public void setRightInfoId(String rightInfoId) {
    this.rightInfoId = rightInfoId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Dealer{" +
            "id='" + getId() + '\'' +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", address='" + address + '\'' +
            ", phone='" + phone + '\'' +
            ", emailId='" + emailId + '\'' +
            ", iconURL='" + iconURL + '\'' +
            ", headInfoId='" + headInfoId + '\'' +
            ", footInfoId='" + footInfoId + '\'' +
            ", leftInfoId='" + leftInfoId + '\'' +
            ", rightInfoId='" + rightInfoId + '\'' +
            '}';
  }
}
