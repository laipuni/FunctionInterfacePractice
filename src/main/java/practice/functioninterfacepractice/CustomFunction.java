package practice.functioninterfacepractice;

@FunctionalInterface
public interface CustomFunction<T,R>{
    R apply(T t);
}
