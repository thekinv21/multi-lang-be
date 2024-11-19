package com.thekinv21.language;

import com.thekinv21.common.BaseEntity;
import com.thekinv21.translationValue.TranslationValue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Language extends BaseEntity {

    private String code;  // e.g., "TR", "EN", "IT"

    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
    private List<TranslationValue> translationValues;

}


