package com.thekinv21.language;

import com.thekinv21.translationKey.TranslationKey;
import com.thekinv21.translationValue.TranslationValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
}


