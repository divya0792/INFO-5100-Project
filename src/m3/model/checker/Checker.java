package m3.model.checker;

public abstract class Checker<T> {
    public abstract boolean check(T o1, T o2);
    public abstract String ToString();
}
