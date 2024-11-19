package com.thekinv21.language;

import lombok.experimental.Delegate;
import org.springframework.stereotype.Component;

@Component
public class LanguageMapper {

     public static LanguageDTO convertToDTO(Language language) {
        LanguageDTO dto = new LanguageDTO();
        dto.setId(language.getId());
        dto.setCode(language.getCode());
        return dto;
    }

    public static Language convertToEntity(LanguageDTO dto) {
        Language language = new Language();
        language.setId(dto.getId());
        language.setCode(dto.getCode());
        return language;
    }

}
