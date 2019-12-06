package m3.model.checker;

public class LessChecker extends Checker<Double> {

	@Override
	public boolean check(Double o1, Double o2) {
		return o1 < o2;
	}
}
