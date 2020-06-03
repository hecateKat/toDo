package com.kat;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HelloServiceTest {

    private HelloService helloService = new HelloService();

    @Test
    public void testShouldReturnTrueWhenMethod_returnsGreeting_returnsWithFallback(){
        //given
        String name = null;

        //when
        var result = helloService.prepareGreeting(name);

        //then
        assertEquals("Hello " + HelloService.FALLBACK_NAME + "!", result);
    }

    @Test
    public void testShouldReturnTrueWhenMethod_returnsGreeting_returnsWithName(){
        //given
        String name = "test";

        //when
        var result = helloService.prepareGreeting(name);

        //then
        assertEquals("Hello " + name + "!", result);
    }

    @Test
    public void testShouldNotReturnTrueWhenMethod_returnsGreeting_returnsWithFallback(){
        //given
        String name = null;

        //when
        var result = helloService.prepareGreeting("hurr");

        //then
        assertNotEquals("Hello " + HelloService.FALLBACK_NAME + "!", result);
    }

    @Test
    public void testShouldNotReturnTrueWhenMethod_returnsGreeting_returnsWithName(){
        //given
        String name = "test";

        //when
        var result = helloService.prepareGreeting("hurr");

        //then
        assertNotEquals("Hello " + name + "!", result);
    }

}