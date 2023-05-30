// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.intellij.sdk.language.psi.LoxTypes;
import org.jetbrains.annotations.NotNull;

public class LoxCompletionContributor extends CompletionContributor {
    public LoxCompletionContributor() {
        extend( CompletionType.BASIC,
//                PlatformPatterns.psiElement(LoxTypes.VALUE).withLanguage(LoxLanguage.INSTANCE),
                PlatformPatterns.psiElement(LoxTypes.COMMENT).withLanguage(LoxLanguage.INSTANCE),//todo Lox 还没有区分Value,所以先在注释去试
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("Hello Lox!"));
                    }
                }
        );
    }
}
