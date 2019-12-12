package dataproto;

import java.util.Date;

public class Lead extends DataObject {
    private String dealerId;
    private String vehicleId;
    private String userId;
    private Date dateOfExpressingInterest;
    private String consumerComment;
    private String dealerComment;

    public Lead(String id, String dealerId, String vehicleId, String userId, Date dateOfExpressingInterest,
            String consumerComment) {
        this.setId(id);
        this.dealerId = dealerId;
        this.vehicleId = vehicleId;
        this.userId = userId;
        this.dateOfExpressingInterest = dateOfExpressingInterest;
        this.consumerComment = consumerComment;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDateOfExpressingInterest(Date dateOfExpressingInterest) {
        this.dateOfExpressingInterest = dateOfExpressingInterest;
    }

    public void setConsumerComment(String consumerComment) {
        this.consumerComment = consumerComment;
    }

    public void setDealerComment(String dealerComment) {
        this.dealerComment = dealerComment;
    }

    public Object getVehicleId() {
        // TODO Auto-generated method stub
        return vehicleId;
    }

    public Object getDealerId() {
        // TODO Auto-generated method stub
        return dealerId;
    }

    public Object getUserId() {
        // TODO Auto-generated method stub
        return userId;
    }

    public String getQuery() {
        // TODO Auto-generated method stub
        return consumerComment;
    }
}
