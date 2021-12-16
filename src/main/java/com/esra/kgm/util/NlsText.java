package com.esra.kgm.util;

import java.text.MessageFormat;

import org.linkki.core.nls.NlsService;

public class NlsText {

    private NlsText() {
    }

    public static String getString(String key) {
        return NlsService.get().getString("com.esra.kgm.messages", key).orElseGet(() -> "!" + key + "!");
    }

    public static String format(String key, Object... arguments) {
        return MessageFormat.format(getString(key), arguments);
    }
}