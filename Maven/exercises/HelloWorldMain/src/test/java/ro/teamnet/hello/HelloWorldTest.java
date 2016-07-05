package ro.teamnet.hello;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 7/5/2016.
 */
public class HelloWorldTest {
    @Test
    public void testSayHello(){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
    }

    @Test
    public void testReturnHelloKey(){
        HelloWorld helloWorld = new HelloWorld();
        System.out.println("From Test: " + helloWorld.returnHelloWorldKey());
        Assert.assertEquals(helloWorld.returnHelloWorldKey(), "Hello Key");
        //assert helloWorld.returnHelloWorldKey().equals("Hello Key");
    }


}
