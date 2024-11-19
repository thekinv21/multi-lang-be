package com.thekinv21.domain.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public List<LanguageDTO> getAllLanguages() {
        return languageService.getAllLanguages();
    }

    @GetMapping("/{id}")
    public LanguageDTO getLanguageById(@PathVariable Long id) {
        return languageService.getLanguageById(id);
    }

    @PostMapping
    public LanguageDTO createLanguage(@RequestBody LanguageDTO languageDTO) {
        return languageService.createLanguage(languageDTO);
    }

    @PutMapping("/{id}")
    public LanguageDTO updateLanguage(@PathVariable Long id, @RequestBody LanguageDTO languageDTO) {
        return languageService.updateLanguage(id, languageDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteLanguage(@PathVariable Long id) {
        languageService.deleteLanguage(id);
    }
}
