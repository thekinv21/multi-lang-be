package com.thekinv21.translationKey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationKeyRepository extends JpaRepository<TranslationKey, Long> {
}
