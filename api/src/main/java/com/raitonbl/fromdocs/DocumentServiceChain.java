package com.raitonbl.fromdocs;

public interface DocumentServiceChain {

    <Y extends Document> Y map(String src, Class<Y> returnType);

}
