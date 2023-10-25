@FunctionalInterface
public interface FunctionalInterfaceDemo {
    // duy nhất 1 method trừu tượng, trừ các method của class object
    void doSomeThing();
    int hashCode(); // dựa trên thuật toán, 1 object -> trả ra 1 mã băm duy nhất
    String toString(); // in ra object
    boolean equals(Object obj); // so sanh tham tri
    default void defaultMethod(){

    };
    static void staticMethod(){

    };




}
