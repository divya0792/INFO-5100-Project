package m3.model;

import m3.model.filter.Filter;
import m3.model.offer.Offer;

import java.util.Date;
import java.util.List;

public class Incentive {
    private Date startDate;
    private Date endDate;
    private String title;
    private String disclaimer;

    private String dealerID;

    private Offer offer;

    private List<Filter> conditions;

    public Incentive() {
    }

    public Incentive(Date startDate, Date endDate, String title, String disclaimer, String dealerID, Offer offer, List<Filter> conditions) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.disclaimer = disclaimer;
        this.dealerID = dealerID;
        this.offer = offer;
        this.conditions = conditions;
    }

    public List<Filter> getConditions() {
        return conditions;
    }

    public void setConditions(List<Filter> conditions) {
        this.conditions = conditions;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getDealerID() {
        return dealerID;
    }

    public void setDealerID(String dealerID) {
        this.dealerID = dealerID;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
