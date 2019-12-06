package m3.model.checker;


public class GreaterChecker extends Checker<Double> {

    @Override
    public boolean check(Double o1, Double o2) {
        return o1 > o2;
    }

	@Override
	public String ToString() {
		// TODO Auto-generated method stub
		return ">";
	}
}
