package org.intellij.sdk.language.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import org.intellij.sdk.language.LoxFileType;

public class LoxElementFactory {
    public static LoxProperty createProperty(Project project, String name) {
        final LoxFile file = createFile(project, name);
        return (LoxProperty) file.getFirstChild();
    }

    public static LoxFile createFile(Project project, String text) {
        String name = "dummy.Lox";
        return (LoxFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, LoxFileType.INSTANCE, text);
    }
}