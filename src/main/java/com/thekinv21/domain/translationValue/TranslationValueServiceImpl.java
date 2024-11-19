package com.thekinv21.domain.translationValue;


import com.thekinv21.infra.exception.ExceptionMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.thekinv21.domain.translationValue.TranslationValueMapper.convertToDTO;
import static com.thekinv21.domain.translationValue.TranslationValueMapper.convertToEntity;
import static com.thekinv21.infra.exception.helper.ExceptionUtil.buildException;

@RequiredArgsConstructor
@Service
public class TranslationValueServiceImpl implements TranslationValueService {

    private final TranslationValueRepository translationValueRepository;

    @Override
    public List<TranslationValueDTO> getAllTranslationValues() {
        return translationValueRepository.findAll()
                .stream()
                .map(TranslationValueMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TranslationValueDTO getTranslationValueById(Long id) {
        TranslationValue translationValue = translationValueRepository.findById(id)
                .orElseThrow(() -> buildException(ExceptionMessage.NOT_FOUND_EXCEPTION, id));
        return convertToDTO(translationValue);
    }

    @Override
    public TranslationValueDTO createTranslationValue(TranslationValueDTO translationValueDTO) {
        TranslationValue translationValue = convertToEntity(translationValueDTO);
        TranslationValue savedTranslationValue = translationValueRepository.save(translationValue);
        return convertToDTO(savedTranslationValue);
    }

    @Override
    public TranslationValueDTO updateTranslationValue(Long id, TranslationValueDTO translationValueDTO) {
        TranslationValue translationValue = translationValueRepository.findById(id)
                .orElseThrow(() -> buildException(ExceptionMessage.NOT_FOUND_EXCEPTION, id));
        translationValue.setTranslatedText(translationValueDTO.getTranslatedText());
        TranslationValue updatedTranslationValue = translationValueRepository.save(translationValue);
        return convertToDTO(updatedTranslationValue);
    }

    @Override
    public void deleteTranslationValue(Long id) {
        TranslationValue translationValue = translationValueRepository.findById(id)
                .orElseThrow(() -> buildException(ExceptionMessage.NOT_FOUND_EXCEPTION, id));
        translationValueRepository.delete(translationValue);
    }

    @Override
    public Map<String, String> findKeyNameAndTranslatedTextByLanguageId(Long languageId) {
        List<Object[]> results = translationValueRepository.findKeyNameAndTranslatedTextByLanguageId(languageId);
        return results.stream()
                .collect(Collectors.toMap(
                        result -> (String) result[0],
                        result -> (String) result[1]
                ));
    }
}
