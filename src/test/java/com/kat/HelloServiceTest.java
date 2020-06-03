package com.kat;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class HelloServiceTest {

    private final static String WELCOME = "Hello";
    private final static String FALLBACK_ID_WELCOME = "Hola";

    @Test
    public void testShouldReturnTrueWhenMethod_returnsGreeting_returnsWithFallbackWhenNameIsNull(){
        //given
        var mockRepository = alwaysReturningHelloRepository(WELCOME);
        var helloService = new HelloService(mockRepository);

        //when
        var result = helloService.prepareGreeting(null, "-1");

        //then
        assertEquals(WELCOME + " " + HelloService.FALLBACK_NAME + "!", result);
    }

    @Test
    public void testShouldReturnTrueWhenMethod_returnsGreeting_returnsNullLangWithFallbackIdLang(){
        //given
        var mockRepository = fallbackLangIdRepository();
        var helloService = new HelloService(mockRepository);

        //when
        var result = helloService.prepareGreeting(null, null);

        //then
        assertEquals(FALLBACK_ID_WELCOME + " " + HelloService.FALLBACK_NAME + "!", result);
    }

    @Test
    public void testShouldReturnTrueWhenMethod_returnsGreeting_returnsTextLangWithFallbackIdLang(){
        //given
        var mockRepository = fallbackLangIdRepository();
        var helloService = new HelloService(mockRepository);

        //when
        var result = helloService.prepareGreeting(null, "abc");

        //then
        assertEquals(FALLBACK_ID_WELCOME + " " + HelloService.FALLBACK_NAME + "!", result);
    }

    @Test
    public void test_prepareGreeting_nonExistingLang_returnsGreetingWithFallbackLang(){
        //given
        var mockRepository = new LangRepository(){
            @Override
            Optional<Lang> findById(Long id) {
                return Optional.empty();
            }
        };
        var helloService = new HelloService(mockRepository);

        //when
        var result = helloService.prepareGreeting(null, "-1");

        //then
        assertEquals(HelloService.FALLBACK_LANG.getWelcomeMsg() + " " + HelloService.FALLBACK_NAME + "!", result);

    }


    @Test
    public void testShouldReturnTrueWhenMethod_returnsGreeting_returnsWithName(){
        //given
        var helloService = new HelloService();
        String name = "test";


        //when
        var result = helloService.prepareGreeting(name, "-1");

        //then
        assertEquals(WELCOME + " " + name + "!", result);
    }


    private LangRepository alwaysReturningHelloRepository(String WELCOME) {
        return new LangRepository(){
            @Override
            Optional<Lang> findById(Long id) {
                return Optional.of(new Lang(null, WELCOME, null));
            }
        };
    }

    private LangRepository fallbackLangIdRepository() {
        return new LangRepository(){
            @Override
            Optional<Lang> findById(Long id) {
                if (id.equals(HelloService.FALLBACK_LANG.getId())){
                    return Optional.of(new Lang(null, FALLBACK_ID_WELCOME, null));
                }
                return Optional.empty();
            }
        };
    }
}