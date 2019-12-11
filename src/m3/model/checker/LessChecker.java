package m3.model.checker;


public class LessChecker extends Checker<Float> {

    @Override
    public boolean check(Float o1, Float o2) {
        return o1 < o2;
    }

    @Override
    public String ToString() {
        // TODO Auto-generated method stub
        return "<";
    }
}
