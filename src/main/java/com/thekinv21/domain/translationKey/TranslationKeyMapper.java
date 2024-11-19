package com.thekinv21.domain.translationKey;

import org.springframework.stereotype.Component;

public class TranslationKeyMapper {

    public static TranslationKeyDTO convertToDTO(TranslationKey translationKey) {
        TranslationKeyDTO dto = new TranslationKeyDTO();
        dto.setId(translationKey.getId());
        dto.setKeyName(translationKey.getKeyName());
        return dto;
    }

    public static TranslationKey convertToEntity(TranslationKeyDTO dto) {
        TranslationKey translationKey = new TranslationKey();
        translationKey.setId(dto.getId());
        translationKey.setKeyName(dto.getKeyName());
        return translationKey;
    }
}
