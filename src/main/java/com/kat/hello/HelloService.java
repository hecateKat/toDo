package com.kat.hello;

import com.kat.lang.Lang;
import com.kat.lang.LangRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class HelloService {
    static final String FALLBACK_NAME = "world";
    static final Lang FALLBACK_LANG = new Lang(1, "Hello", "EN");
    private final Logger logger = LoggerFactory.getLogger(HelloService.class);

    private LangRepository langRepository;

    public HelloService() {
        this(new LangRepository());
    }

    public HelloService(LangRepository langRepository) {
        this.langRepository = langRepository;
    }

    public String prepareGreeting(String name, Integer lang){
        Integer langId = Optional.ofNullable(lang).orElse(FALLBACK_LANG.getId());
              var welcomeMsg = langRepository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMsg();
        String nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMsg + " " + nameToWelcome + "!";
    }
}