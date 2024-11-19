package com.thekinv21.infra.exception.helper;

import com.thekinv21.infra.config.MessageUtil;
import com.thekinv21.infra.exception.ExceptionMessage;
import com.thekinv21.infra.exception.model.CustomException;
import org.springframework.stereotype.Component;

@Component
public class ExceptionUtil {

    public ExceptionUtil() {
    }

    public static CustomException buildException() {
        return buildException(ExceptionMessage.DEFAULT_EXCEPTION);
    }

    public static CustomException buildException(String ex) {
        return new CustomException(ex, ExceptionMessage.DEFAULT_EXCEPTION.getStatus());
    }

    public static CustomException buildException(ExceptionMessage ex, Object... args) {
        String errorMessage =
                MessageUtil.getMessage(ex.getKey(), args);
        return new CustomException(errorMessage, ex.getStatus());
    }

    public static CustomException buildException(ExceptionMessage ex) {
        String errorMessage =
                MessageUtil.getMessage(ex.getKey());
        return new CustomException(errorMessage, ex.getStatus());
    }


}
