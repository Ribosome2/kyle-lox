// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.codeInsight.daemon.*;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import org.intellij.sdk.language.psi.LoxProperty;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class LoxLineMarkerProvider extends RelatedItemLineMarkerProvider {
    @Override
    protected void collectNavigationMarkers(@NotNull PsiElement element,
                                            @NotNull Collection<? super RelatedItemLineMarkerInfo<?>> result ) {
        // This must be an element with a literal expression as a parent
        if ( !(element.getParent() instanceof PsiLiteralExpression) )
            return;

        //Todo:还没实现Lox的PsiLiteralExpression ,不知道怎么写才会有 PsiLiteralExpression
        // The literal expression must start with the Lox language literal expression
        PsiLiteralExpression literalExpression = (PsiLiteralExpression) element.getParent();
        String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;
        if ( ( value == null ) || !value.startsWith( LoxAnnotator.LOX_PREFIX_STR + LoxAnnotator.LOX_SEPARATOR_STR ) ) return;

        // Get the Lox language property usage
        Project project = element.getProject();
        String possibleProperties = value.substring( LoxAnnotator.LOX_PREFIX_STR.length()+ LoxAnnotator.LOX_SEPARATOR_STR.length() );
        final List<LoxProperty> properties = LoxUtil.findProperties( project, possibleProperties );
        if ( properties.size() > 0 ) {
            // Add the property to a collection of line marker info
            NavigationGutterIconBuilder< PsiElement > builder =
                    NavigationGutterIconBuilder.create( LoxIcons.FILE )
                            .setTargets( properties )
                            .setTooltipText( "Navigate to Lox language property" );
            result.add( builder.createLineMarkerInfo( element ) );
        }
    }

}