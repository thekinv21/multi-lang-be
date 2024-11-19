package com.thekinv21.domain.translationKey;

import com.thekinv21.domain.common.BaseEntity;
import com.thekinv21.domain.translationValue.TranslationValue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class TranslationKey extends BaseEntity {

    private String keyName;

    @OneToMany(mappedBy = "translationKey", cascade = CascadeType.ALL)
    private List<TranslationValue> translationValues;


}
