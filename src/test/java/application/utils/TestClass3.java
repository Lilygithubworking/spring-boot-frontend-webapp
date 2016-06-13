package application.utils;

import java.util.List;

/**
 * Created by mj on 10/6/16.
 */
public class TestClass3 {
    List<TestClass2> a;

    TestClass3() {

    }

    public TestClass3(List<TestClass2> a) {
        this.a = a;
    }

    public List<TestClass2> getA() {
        return a;
    }

    public void setA(List<TestClass2> a) {
        this.a = a;
    }
}
