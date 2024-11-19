package com.thekinv21.domain.translationValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranslationValueDTO {

    private Long id;
    private String keyName;
    private String languageCode;
    private String translatedText;

    public TranslationValueDTO(Long id, String keyName, String languageCode, String translatedText) {
        this.id = id;
        this.keyName = keyName;
        this.languageCode = languageCode;
        this.translatedText = translatedText;
    }

}
