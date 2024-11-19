package com.thekinv21.domain.translationKey;

import java.util.List;

public interface TranslationKeyService {
    List<TranslationKeyDTO> getAllTranslationKeys();
    TranslationKeyDTO getTranslationKeyById(Long id);
    TranslationKeyDTO createTranslationKey(TranslationKeyDTO translationKeyDTO);
    TranslationKeyDTO updateTranslationKey(Long id, TranslationKeyDTO translationKeyDTO);
    void deleteTranslationKey(Long id);
}
