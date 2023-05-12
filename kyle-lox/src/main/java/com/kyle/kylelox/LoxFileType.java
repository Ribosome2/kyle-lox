package com.kyle.kylelox;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
public class LoxFileType extends LanguageFileType {
    public static final LoxFileType INSTANCE = new LoxFileType();

    private LoxFileType() {
        super(LoxLanguage.INSTANCE);
    }

    @Override
    public String getName() {
        return "Lox File";
    }

    @Override
    public String getDescription() {
        return "Lox language file";
    }

    @Override
    public String getDefaultExtension() {
        return "lox";
    }

    @Override
    public Icon getIcon() {
        return LoxIcons.FILE;
    }


    @Override
    public boolean isReadOnly() {
        return false;
    }
}
