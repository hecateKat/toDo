package com.kat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LangRepository {
    private List<Lang> languages;

    public LangRepository() {
        languages = new ArrayList<>();
        languages.add(new Lang(1L, "Hello", "EN"));
        languages.add(new Lang(2L, "Hejka", "PL"));
    }

    Optional<Lang> findById(Long id){
        return languages.stream()
                .filter(l->l.getId().equals(id))
                .findFirst();
    }
}
