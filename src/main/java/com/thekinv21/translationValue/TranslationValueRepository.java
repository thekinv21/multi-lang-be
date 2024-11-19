package com.thekinv21.translationValue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslationValueRepository extends JpaRepository<TranslationValue, Long> {

    @Query("SELECT tv.translationKey.keyName, tv.translatedText " +
            "FROM TranslationValue tv WHERE tv.language.id = :languageId")
    List<Object[]> findKeyNameAndTranslatedTextByLanguageId(@Param("languageId") Long languageId);

}
