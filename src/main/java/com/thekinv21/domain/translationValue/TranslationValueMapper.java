package com.thekinv21.domain.translationValue;

import com.thekinv21.domain.language.Language;
import com.thekinv21.domain.translationKey.TranslationKey;
import org.springframework.stereotype.Component;

public class TranslationValueMapper {

    public static TranslationValueDTO convertToDTO(TranslationValue translationValue) {
        TranslationValueDTO dto = new TranslationValueDTO();
        dto.setId(translationValue.getId());
        dto.setKeyName(translationValue.getTranslationKey().getKeyName());
        dto.setKeyId(translationValue.getTranslationKey().getId());
        dto.setLanguageCode(translationValue.getLanguage().getCode());
        dto.setLanguageId(translationValue.getLanguage().getId());
        dto.setTranslatedText(translationValue.getTranslatedText());
        return dto;
    }

    public static TranslationValue convertToEntity(TranslationValueDTO dto) {
        TranslationValue translationValue = new TranslationValue();
        translationValue.setId(dto.getId());

        TranslationKey translationKey = new TranslationKey();
        translationKey.setId(dto.getKeyId());
        translationValue.setTranslationKey(translationKey);

        Language language = new Language();
        language.setId(dto.getLanguageId());
        translationValue.setLanguage(language);

        translationValue.setTranslatedText(dto.getTranslatedText());
        return translationValue;
    }
}
