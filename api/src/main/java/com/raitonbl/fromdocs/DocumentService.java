package com.raitonbl.fromdocs;

public interface DocumentService {

    <Y extends Document> Y map(String src, Class<Y> returnType, DocumentServiceChain chain);

}
