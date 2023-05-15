package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.LoxLanguage;

public class LoxElementType  extends IElementType {
    public LoxElementType(String debugName) {
        super(debugName, LoxLanguage.INSTANCE);
    }

}
