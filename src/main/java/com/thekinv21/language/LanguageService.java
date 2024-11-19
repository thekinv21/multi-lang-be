package com.thekinv21.language;

import java.util.List;

public interface LanguageService {
    List<LanguageDTO> getAllLanguages();
    LanguageDTO getLanguageById(Long id);
    LanguageDTO createLanguage(LanguageDTO languageDTO);
    LanguageDTO updateLanguage(Long id, LanguageDTO languageDTO);
    void deleteLanguage(Long id);
}
