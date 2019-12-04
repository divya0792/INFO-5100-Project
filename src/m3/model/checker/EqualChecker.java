package m3.model.checker;

public class EqualChecker extends Checker<Object> {

    @Override
    public boolean check(Object o1, Object o2) {
        return o1.equals(o2);
    }
}
