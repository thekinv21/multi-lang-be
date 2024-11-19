package com.thekinv21.translationValue;

import com.thekinv21.common.BaseEntity;
import com.thekinv21.language.Language;
import com.thekinv21.translationKey.TranslationKey;
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
