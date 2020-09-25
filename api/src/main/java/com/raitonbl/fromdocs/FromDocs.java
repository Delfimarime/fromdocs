package com.raitonbl.fromdocs;

import com.raitonbl.fromdocs.services.IDService;
import com.raitonbl.fromdocs.services.NuitService;
import com.raitonbl.fromdocs.services.PassportService;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.ServiceLoader;

public final class FromDocs {

    private static FromDocs INSTANCE;

    private Provider provider;
    private final DefaultDocumentServiceChain chain;

    private FromDocs() {
        this.chain = new DefaultDocumentServiceChain();
    }

    public static FromDocs getInstance() {

        if (INSTANCE == null) {
            synchronized (FromDocs.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FromDocs();
                    INSTANCE.chain.addMapper(new IDService());
                    INSTANCE.chain.addMapper(new NuitService());
                    INSTANCE.chain.addMapper(new PassportService());
                    INSTANCE.provider = ServiceLoader.load(Provider.class).findFirst().orElseThrow(() -> new NoSuchElementException(Provider.class.getName() + " couldn't be found"));
                }
            }
        }

        return INSTANCE;
    }

    public <Y extends Document> Y from(File file, Class<Y> returnType) {
        return from(provider.from(file), returnType);
    }

    public <Y extends Document> Y from(Path path, Class<Y> returnType) {
        return from(provider.from(path), returnType);
    }

    public <Y extends Document> Y from(String src, Class<Y> returnType) {

        if (src == null || returnType == null) {
            return null;
        }

        return chain.map(src, returnType);
    }

    public <Y extends Document> Y from(InputStream inputStream, Class<Y> returnType) {
        return from(provider.from(inputStream), returnType);
    }

    public <Y extends Document> Y from(FileInputStream inputStream, Class<Y> returnType) {
        return from(provider.from(inputStream), returnType);
    }

    public FromDocs addMapper(DocumentService mapper) {

        if (mapper == null) {
            return this;
        }

        chain.addMapper(mapper);

        return this;
    }

}
