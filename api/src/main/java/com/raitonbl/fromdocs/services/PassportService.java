package com.raitonbl.fromdocs.services;

import com.raitonbl.fromdocs.Document;
import com.raitonbl.fromdocs.DocumentService;
import com.raitonbl.fromdocs.DocumentServiceChain;
import com.raitonbl.fromdocs.docs.Passport;

public class PassportService implements DocumentService {

    @Override
    public <Y extends Document> Y map(String src, Class<Y> returnType, DocumentServiceChain chain) {

        if (src == null || returnType == null) {
            return null;
        }

        if (!returnType.equals(Passport.class)) {
            return chain.map(src, returnType);
        }

        throw new UnsupportedOperationException();
    }


}
