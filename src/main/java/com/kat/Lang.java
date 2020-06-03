package com.kat;

public class Lang {

    private Long id;
    private String welcomeMsg;
    private String langCode;

    public Lang(Long id, String welcomeMsg, String langCode) {
        this.id = id;
        this.welcomeMsg = welcomeMsg;
        this.langCode = langCode;
    }

    public Long getId() {
        return id;
    }

    public String getWelcomeMsg() {
        return welcomeMsg;
    }

    public void setWelcomeMsg(String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }
}
