package m4.Team4;


public class Lead extends DataObject {
    private  String leadId;
    private  String vehicleId;
    private  String dealerId;
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String contactNo;
    private  String comment;
    private  String dealerComment;

    public Lead(){

    }

    public String getComment() {
        return comment;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getDealerComment() {
        return dealerComment;
    }

    public String getDealerId() {
        return dealerId;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLeadId() {
        return leadId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setDealerComment(String dealerComment) {
        this.dealerComment = dealerComment;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLeadId(String leadId) {
        this.leadId = leadId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }		
}
