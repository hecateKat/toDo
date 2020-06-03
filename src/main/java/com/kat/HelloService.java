package com.kat;

import java.util.Optional;

public class HelloService {
    static final String FALLBACK_NAME = "world";
    static final Lang FALLBACK_LANG = new Lang(1L, "Hello", "EN");

    private LangRepository langRepository;

    public HelloService() {
        this(new LangRepository());
    }

    public HelloService(LangRepository langRepository) {
        this.langRepository = langRepository;
    }

    String prepareGreeting(String name, String lang){
        var langId = Optional.ofNullable(lang).map(Long::valueOf).orElse(FALLBACK_LANG.getId());
        var welcomeMsg = langRepository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMsg();
        String nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMsg + " " + nameToWelcome + "!";
    }
}