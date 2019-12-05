package m3.model.offer;

public abstract class Offer {
    private double value;

    public Offer(){}

    public Offer(double value) {
        this.value = value;
    }

    public double getValue() {

        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
