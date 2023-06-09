package org.intellij.sdk.language;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;
public class LoxFileTypeFactory extends  FileTypeFactory{
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer consumer) {
        consumer.consume(LoxFileType.INSTANCE);
    }
}
