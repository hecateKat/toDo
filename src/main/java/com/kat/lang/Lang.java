package com.kat.lang;

import javax.persistence.*;

@Entity
@Table(name = "LANGUAGES")
public class Lang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "WELCOME_MSG")
    private String welcomeMsg;
    @Column(name = "CODE")
    private String langCode;

    public Lang(Integer id, String welcomeMsg, String langCode) {
        this.id = id;
        this.welcomeMsg = welcomeMsg;
        this.langCode = langCode;
    }

    /**
     * Hibernate (JPA) needs it.
     */
    @SuppressWarnings("unused")
    public Lang() {
    }

    public Integer getId() {
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
