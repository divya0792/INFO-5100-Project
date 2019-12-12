package dataproto;

public class User extends DataObject {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    public User(String id, String firstname, String lastname, String email, String phone) {
        this.setId(id);
        System.out.println("user success construct");
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        // TODO Auto-generated method stub
        return lastname;
    }

    public String getPhoneNumber() {
        // TODO Auto-generated method stub
        return phone;
    }

    public String getEmail() {
        // TODO Auto-generated method stub
        return email;
    }
}
