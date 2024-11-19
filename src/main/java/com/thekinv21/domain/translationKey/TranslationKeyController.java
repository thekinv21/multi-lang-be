package com.thekinv21.domain.translationKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/translation-keys")
public class TranslationKeyController {

    private final TranslationKeyService translationKeyService;

    @Autowired
    public TranslationKeyController(TranslationKeyService translationKeyService) {
        this.translationKeyService = translationKeyService;
    }

    @GetMapping
    public List<TranslationKeyDTO> getAllTranslationKeys() {
        return translationKeyService.getAllTranslationKeys();
    }

    @GetMapping("/{id}")
    public TranslationKeyDTO getTranslationKeyById(@PathVariable Long id) {
        return translationKeyService.getTranslationKeyById(id);
    }

    @PostMapping
    public TranslationKeyDTO createTranslationKey(@RequestBody TranslationKeyDTO translationKeyDTO) {
        return translationKeyService.createTranslationKey(translationKeyDTO);
    }

    @PutMapping("/{id}")
    public TranslationKeyDTO updateTranslationKey(@PathVariable Long id, @RequestBody TranslationKeyDTO translationKeyDTO) {
        return translationKeyService.updateTranslationKey(id, translationKeyDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTranslationKey(@PathVariable Long id) {
        translationKeyService.deleteTranslationKey(id);
    }
}
