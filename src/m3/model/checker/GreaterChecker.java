package m3.model.checker;


public class GreaterChecker extends Checker<Object> {

    @Override
    public boolean check(Object o1, Object o2) {
        return Double.valueOf(o1.toString()) > Double.valueOf(o2.toString());
    }

    @Override
    public String ToString() {
        // TODO Auto-generated method stub
        return ">";
    }
}
