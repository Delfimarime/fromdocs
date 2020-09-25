package com.raitonbl.fromdocs.demo;

import com.raitonbl.fromdocs.FromDocs;
import com.raitonbl.fromdocs.docs.ID;
import org.junit.Test;

import java.io.File;

public class FromDocsJUnitTest {

    @Test
    public void init() {
        System.out.println(FromDocs.getInstance().from(new File("/Users/delfimarime/Documents/DX-2500N_20200529_160456.pdf"), ID.class));
        System.out.println(FromDocs.getInstance().from(new File("/Users/delfimarime/Documents/DX-2500N_20200529_160456.pdf"), ID.class).getName());
    }

}
