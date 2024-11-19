package com.thekinv21.domain.translationValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/translation-values")
public class TranslationValueController {

    private final TranslationValueService translationValueService;

    @Autowired
    public TranslationValueController(TranslationValueService translationValueService) {
        this.translationValueService = translationValueService;
    }

    @GetMapping
    public List<TranslationValueDTO> getAllTranslationValues() {
        return translationValueService.getAllTranslationValues();
    }

    @GetMapping("/language/{languageId}")
    public Map<String, String> getTranslationValuesByLanguageId(@PathVariable Long languageId) {
        return translationValueService.findKeyNameAndTranslatedTextByLanguageId(languageId);
    }

    @GetMapping("/{id}")
    public TranslationValueDTO getTranslationValueById(@PathVariable Long id) {
        return translationValueService.getTranslationValueById(id);
    }

    @PostMapping
    public TranslationValueDTO createTranslationValue(@RequestBody TranslationValueDTO translationValueDTO) {
        return translationValueService.createTranslationValue(translationValueDTO);
    }

    @PutMapping("/{id}")
    public TranslationValueDTO updateTranslationValue(@PathVariable Long id, @RequestBody TranslationValueDTO translationValueDTO) {
        return translationValueService.updateTranslationValue(id, translationValueDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTranslationValue(@PathVariable Long id) {
        translationValueService.deleteTranslationValue(id);
    }
}
