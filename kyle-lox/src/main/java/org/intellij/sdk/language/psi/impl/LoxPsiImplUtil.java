package org.intellij.sdk.language.psi.impl;

import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.LoxProperty;
import org.intellij.sdk.language.psi.LoxTypes;

public class LoxPsiImplUtil {
    public static String getKey(LoxProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(LoxTypes.KEY);
        if (keyNode != null) {
            // IMPORTANT: Convert embedded escaped spaces to simple spaces
            return keyNode.getText().replaceAll("\\\\ ", " ");
        } else {
            return null;
        }
    }

    public static String getValue(LoxProperty element) {
        ASTNode valueNode = element.getNode().findChildByType(LoxTypes.VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }
}