package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.LoxLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class LoxTokenType extends IElementType {
    public LoxTokenType(@NonNls @NotNull String debugName) {
        super(debugName, LoxLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "LoxTokenType."+  super.toString();
    }
}
