package m3.model;

import m3.model.filter.Filter;
import m3.model.offer.Offer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Incentive {
    private String IncentiveID;
    private Date startDate;
    private Date endDate;
    private String title;
    private String disclaimer;

    private String dealerID;

    private Offer offer;

    private List<Filter> conditions;

    public Incentive() {
        this.conditions = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Incentive incentive = (Incentive) o;
        return
                Objects.equals(startDate, incentive.startDate) &&
                        Objects.equals(endDate, incentive.endDate) &&
                        Objects.equals(title, incentive.title) &&
                        Objects.equals(disclaimer, incentive.disclaimer) &&
                        Objects.equals(dealerID, incentive.dealerID) &&
                        Objects.equals(offer, incentive.offer) &&
                        Objects.equals(conditions, incentive.conditions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(startDate, endDate, title, disclaimer, dealerID, offer, conditions);
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

    public void addFilter(Filter filter) {
        this.conditions.add(filter);
    }

    public List<Filter> getConditions() {
        return conditions;
    }

    public void setIncentiveID(String ID) {
        this.IncentiveID = ID;
    }

    public String getIncentiveID() {
        return IncentiveID;
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
