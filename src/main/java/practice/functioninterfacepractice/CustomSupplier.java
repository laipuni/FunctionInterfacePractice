package practice.functioninterfacepractice;

@FunctionalInterface
public interface CustomSupplier<T>{
    T get();
}