package com.thekinv21.domain.translationValue;

import com.thekinv21.domain.common.BaseEntity;
import com.thekinv21.domain.language.Language;
import com.thekinv21.domain.translationKey.TranslationKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class TranslationValue extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "translation_key_id", nullable = false)
    private TranslationKey translationKey;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    private String translatedText;  // e.g., "kullanıcı", "user"

}
