package application.utils;

/**
 * Created by mj on 10/6/16.
 */
public class TestClass implements JsonSerialisable {
    int a;

    TestClass() {

    }

    public TestClass(int b) {
        a = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
