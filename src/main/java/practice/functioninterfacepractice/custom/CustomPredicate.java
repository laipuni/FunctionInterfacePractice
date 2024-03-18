package practice.functioninterfacepractice;

@FunctionalInterface
public interface  CustomPredicate<T>{
    boolean test(T t);
}
