package com.raitonbl.fromdocs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class DefaultDocumentServiceChain implements DocumentServiceChain {

    private final Set<DocumentService> seq;

    public DefaultDocumentServiceChain(){
        this(new DocumentService[0]);
    }

    public DefaultDocumentServiceChain(DocumentService[] seq) {
        this.seq = seq == null ? new CopyOnWriteArraySet<>() : new CopyOnWriteArraySet<>(Arrays.asList(seq));
    }

    @Override
    public <Y extends Document> Y map(String src, Class<Y> returnType) {

        if (src == null) {
            return null;
        }

        Iterator<DocumentService> seq = this.seq.iterator();

        if (!seq.hasNext()) {
            return null;
        }

        return newInstance(seq, returnType).map(src, returnType);
    }

    private <Y extends Document> DocumentServiceChain newInstance(Iterator<DocumentService> seq, Class<Y> returnType) {
        return new DocumentServiceChain() {
            @Override
            public <R extends Document> R map(String src, Class<R> returnType) {

                if (!seq.hasNext()) {
                    return null;
                }

                return seq.next().map(src, returnType, this);

            }
        };
    }

    public void addMapper(DocumentService mapper) {

        if (mapper == null) {
            return;
        }

        this.seq.add(mapper);
    }

}
