package org.intellij.sdk.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.psi.FileViewProvider;
import com.intellij.openapi.fileTypes.FileType;
import org.intellij.sdk.language.*;
import org.jetbrains.annotations.NotNull;
public class LoxFile extends PsiFileBase {
    public LoxFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, LoxLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return LoxFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Lox File";
    }


}
