package com.nicoletti.store.utils;

import jakarta.annotation.PostConstruct;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageUtils {

    private static MessageSource staticMessageSource;

    private final MessageSource messageSource;

    public MessageUtils(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @PostConstruct
    public void init() {
        staticMessageSource = messageSource;
    }

    public static String t(String code) {
        return staticMessageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    public static String t(String code, Object... args) {
        return staticMessageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

}
