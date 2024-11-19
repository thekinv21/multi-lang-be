package com.thekinv21.domain.translationValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class TranslationValueDTO {

    private Long id;
    private String keyName;
    private Long keyId;
    private String languageCode;
    private Long languageId;
    private String translatedText;

}
