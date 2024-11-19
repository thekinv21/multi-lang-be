package com.thekinv21.domain.translationKey;

import com.thekinv21.infra.exception.ExceptionMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.thekinv21.domain.translationKey.TranslationKeyMapper.convertToDTO;
import static com.thekinv21.domain.translationKey.TranslationKeyMapper.convertToEntity;
import static com.thekinv21.infra.exception.helper.ExceptionUtil.buildException;

@RequiredArgsConstructor
@Service
public class TranslationKeyServiceImpl implements TranslationKeyService {

    private final TranslationKeyRepository translationKeyRepository;

    @Override
    public List<TranslationKeyDTO> getAllTranslationKeys() {
        return translationKeyRepository.findAll()
                .stream()
                .map(TranslationKeyMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TranslationKeyDTO getTranslationKeyById(Long id) {
        TranslationKey translationKey = translationKeyRepository.findById(id)
                .orElseThrow(() -> buildException(ExceptionMessage.NOT_FOUND_EXCEPTION, id));
        return convertToDTO(translationKey);
    }

    @Override
    public TranslationKeyDTO createTranslationKey(TranslationKeyDTO translationKeyDTO) {
        TranslationKey translationKey = convertToEntity(translationKeyDTO);
        TranslationKey savedTranslationKey = translationKeyRepository.save(translationKey);
        return convertToDTO(savedTranslationKey);
    }

    @Override
    public TranslationKeyDTO updateTranslationKey(Long id, TranslationKeyDTO translationKeyDTO) {
        TranslationKey translationKey = translationKeyRepository.findById(id)
                .orElseThrow(() -> buildException(ExceptionMessage.NOT_FOUND_EXCEPTION, id));

        translationKey.setKeyName(translationKeyDTO.getKeyName());
        TranslationKey updatedTranslationKey = translationKeyRepository.save(translationKey);
        return convertToDTO(updatedTranslationKey);
    }

    @Override
    public void deleteTranslationKey(Long id) {
        TranslationKey translationKey = translationKeyRepository.findById(id)
                .orElseThrow(() -> buildException(ExceptionMessage.NOT_FOUND_EXCEPTION, id));
        translationKeyRepository.delete(translationKey);
    }
}
