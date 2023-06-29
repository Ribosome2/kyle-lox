package org.intellij.sdk.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.intellij.sdk.language.psi.LoxElementFactory;
import org.intellij.sdk.language.psi.LoxProperty;
import org.intellij.sdk.language.psi.LoxTypes;

public class LoxPsiImplUtil {
    public static String getKey(LoxProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(LoxTypes.KEY);
        if (keyNode != null) {
            // IMPORTANT: Convert embedded escaped spaces to Lox spaces
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

    public static String getName(LoxProperty element) {
        return getKey(element);
    }

    public static PsiElement setName(LoxProperty element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(LoxTypes.KEY);
        if (keyNode != null) {

            LoxProperty property = LoxElementFactory.createProperty(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(LoxProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(LoxTypes.KEY);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }
}