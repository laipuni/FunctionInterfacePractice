package practice.functioninterfacepractice;

@FunctionalInterface
public interface CustomConsumer<T>{
    void accept(T t);
}