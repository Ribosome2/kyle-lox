
package org.intellij.sdk.language;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class LoxLexerAdapter extends FlexAdapter {
    public LoxLexerAdapter() {
        super(new LoxLexer((Reader) null));
    }
}
