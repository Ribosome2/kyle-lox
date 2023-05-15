package org.intellij.sdk.language;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.fileTypes.LanguageFileType;

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
        return AllIcons.FileTypes.Custom;
    }


    @Override
    public boolean isReadOnly() {
        return false;
    }
}
