package m3.model.checker;

public class GreaterChecker extends Checker<Integer>{
	
	public boolean check(Integer o1, Integer o2) {
		return o1>o2;
	}
}
