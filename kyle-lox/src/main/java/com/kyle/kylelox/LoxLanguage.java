package com.kyle.kylelox;

import com.intellij.lang.Language;

public class LoxLanguage  extends Language {

    public static final LoxLanguage INSTANCE = new LoxLanguage();

    private LoxLanguage() {
        super("Lox");
    }
}
