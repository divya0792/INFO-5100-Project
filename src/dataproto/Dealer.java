package dataproto;

import java.util.Collection;

public class Dealer extends DataObject {
  private String name;
  private String password;
  private String address;
  private String phone;
  private Collection<Vehicle> vehicles;
  private String emailId;
  private Collection<Incentive> incentives;
  private Collection<Lead> leads;

  private String headInfoId;
  private String footInfoId;
  private String leftInfoId;
  private String rightInfoId;

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

  public Collection<Incentive> getIncentives() {
    return incentives;
  }

  public void setIncentives(Collection<Incentive> incentives) {
    this.incentives = incentives;
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
}
