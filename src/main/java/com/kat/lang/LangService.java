package com.kat.lang;

import com.kat.dto.LangDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LangService {
    private LangRepository langRepository;

    public LangService() {
        this(new LangRepository());
    }

    public LangService(LangRepository langRepository) {
        this.langRepository = langRepository;
    }

    List<LangDto> findAll() {
        return langRepository
                .findAll()
                .stream()
                .map(LangDto::new)
                .collect(toList());

    }
}
