package m3.model.checker;


public class EqualChecker<T> extends Checker<T> {

    @Override
    public boolean check(T o1, T o2) {
        return o1.equals(o2);
    }

    @Override
    public String ToString() {
        // TODO Auto-generated method stub
        return "=";
    }
}
