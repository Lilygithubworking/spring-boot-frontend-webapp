package application;

import application.utils.JacksonUtils;
import application.utils.TestClass2;
import application.utils.TestClass3;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mj on 10/6/16.
 */
public class TestJacksonDeserialisation {

    @Autowired
    JacksonUtils jacksonUtils;

    public static void main(String[] args) throws IOException {
//        String testClass2Json = "{\"a\":2}";
//        TestClass2 testClass2 = new ObjectMapper().readValue(testClass2Json, TestClass2.class);
//        System.out.println(testClass2);

//        TestClass3 testClass3 = new TestClass3(new TestClass2(4));
//        String testClass3Json = JacksonUtils.toJson(testClass3);
//        System.out.println("testClass3Json = " + testClass3Json);
//        TestClass3 testClass31 = new ObjectMapper().readValue(testClass3Json, TestClass3.class);
//        System.out.println(testClass31);


        TestClass3 testClass3 = new TestClass3(new ArrayList<TestClass2>() {{
            this.add(new TestClass2(4));
        }});
        String testClass3Json = JacksonUtils.toJson(testClass3);
        System.out.println("testClass3Json = " + testClass3Json);
        TestClass3 testClass31 = new ObjectMapper().readValue(testClass3Json, TestClass3.class);
        System.out.println(testClass31);

    }

}
