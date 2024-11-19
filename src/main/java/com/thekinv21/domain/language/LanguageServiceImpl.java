package com.thekinv21.domain.language;

import com.thekinv21.infra.exception.ExceptionMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.thekinv21.domain.language.LanguageMapper.convertToDTO;
import static com.thekinv21.domain.language.LanguageMapper.convertToEntity;
import static com.thekinv21.infra.exception.helper.ExceptionUtil.buildException;

@RequiredArgsConstructor
@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;


    @Override
    public List<LanguageDTO> getAllLanguages() {
        return languageRepository.findAll()
                .stream()
                .map(LanguageMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LanguageDTO getLanguageById(Long id) {
        Language language = languageRepository.findById(id)
                .orElseThrow(() -> buildException(ExceptionMessage.NOT_FOUND_EXCEPTION, id));
        return convertToDTO(language);
    }

    @Override
    public LanguageDTO createLanguage(LanguageDTO languageDTO) {
        Language language = convertToEntity(languageDTO);
        Language savedLanguage = languageRepository.save(language);
        return convertToDTO(savedLanguage);
    }

    @Override
    public LanguageDTO updateLanguage(Long id, LanguageDTO languageDTO) {
        Language language = languageRepository.findById(id)
                .orElseThrow(() -> buildException(ExceptionMessage.NOT_FOUND_EXCEPTION, id));

        language.setCode(languageDTO.getCode());
        Language updatedLanguage = languageRepository.save(language);
        return convertToDTO(updatedLanguage);
    }

    @Override
    public void deleteLanguage(Long id) {
        Language language = languageRepository.findById(id)
                .orElseThrow(() -> buildException(ExceptionMessage.NOT_FOUND_EXCEPTION, id));
        languageRepository.delete(language);
    }

}
