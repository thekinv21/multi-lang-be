package com.thekinv21.domain.translationValue;

import java.util.List;
import java.util.Map;

public interface TranslationValueService {
    List<TranslationValueDTO> getAllTranslationValues();
    TranslationValueDTO getTranslationValueById(Long id);
    TranslationValueDTO createTranslationValue(TranslationValueDTO translationValueDTO);
    TranslationValueDTO updateTranslationValue(Long id, TranslationValueDTO translationValueDTO);
    void deleteTranslationValue(Long id);
    Map<String, String> findKeyNameAndTranslatedTextByLanguageId(Long languageId);
}
