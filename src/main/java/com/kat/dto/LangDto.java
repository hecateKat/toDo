package com.kat.dto;

import com.kat.lang.Lang;

public class LangDto {

    private Integer id;
    private String langCode;

    public LangDto(Lang lang) {
        this.id = lang.getId();
        this.langCode = lang.getLangCode();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }
}
