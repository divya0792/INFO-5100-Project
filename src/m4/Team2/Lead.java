package m4.Team2;

public class Lead {

    private String leadId;
    private String vehicleId;
    private String dealerId;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
    private String message;
    private String comment;
    private String dealerComment;
    

    public String getVehicleId()
    {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId)
    {
        this.vehicleId = vehicleId;
    }
    
    public String getDealerId()
    {
        return dealerId;
    }

    public void setDealerId(String dealerId)
    {
        this.dealerId = dealerId;
    }
    
    public String getDealerComment()
    {
        return dealerComment;
    }

    public void setDealerComment(String dealerComment)
    {
        this.dealerComment = dealerComment;
    }
    
    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public String getLeadId() {
        return leadId;
    }
    public void setLeadId(String leadId) {
        this.leadId = leadId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContactNo() {
        return contactNo;
    }
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Lead{" +
            "leadId='" + leadId + '\'' +
            ", vehicleId='" + vehicleId + '\'' +
            ", dealerId='" + dealerId + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", contactNo='" + contactNo + '\'' +
            ", message='" + message + '\'' +
            ", comment='" + comment + '\'' +
            ", dealerComment='" + dealerComment + '\'' +
            '}';
    }
}
