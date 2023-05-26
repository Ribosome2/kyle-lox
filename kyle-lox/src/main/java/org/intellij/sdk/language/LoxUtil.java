// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.*;
import com.intellij.psi.util.PsiTreeUtil;
import org.intellij.sdk.language.psi.LoxFile;
import org.intellij.sdk.language.psi.LoxProperty;

import java.util.*;

public class LoxUtil {

    // Searches the entire project for Lox language files with instances of the Lox property with the given key
    public static List<LoxProperty> findProperties(Project project, String key) {
        List<LoxProperty> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(LoxFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            LoxFile simpleFile = (LoxFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                LoxProperty[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, LoxProperty.class);
                if (properties != null) {
                    for (LoxProperty property : properties) {
                        if (key.equals(property.getKey())) {
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<LoxProperty> findProperties(Project project) {
        List<LoxProperty> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(LoxFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            LoxFile simpleFile = (LoxFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                LoxProperty[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, LoxProperty.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        return result;
    }
}