package com.raitonbl.fromdocs.tesseract;

import com.raitonbl.fromdocs.FromDocsException;
import com.raitonbl.fromdocs.Provider;
import net.sourceforge.tess4j.Tesseract;

import javax.imageio.ImageIO;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;

public class ProviderImpl implements Provider {

    private Tesseract runtime;

    public ProviderImpl() {
        this.runtime = new Tesseract();
        this.runtime.setLanguage("eng");
        this.runtime.setPageSegMode(1);
        this.runtime.setOcrEngineMode(1);
        this.runtime.setDatapath("src/main/resources/tessdata");
    }

    @Override
    public String from(File file) {
        try {
            return from(new FileInputStream(file));
        } catch (FromDocsException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new FromDocsException(ex);
        }
    }

    @Override
    public String from(Path path) {
        return from(path.toFile());
    }

    @Override
    public String from(InputStream inputStream) {
        return from(new BufferedInputStream(inputStream));
    }

    public String from(BufferedInputStream inputStream) {
        try {
            if (inputStream == null) {
                return null;
            }
            return runtime.doOCR(ImageIO.read(inputStream));
        } catch (Exception ex) {
            throw new FromDocsException(ex);
        }
    }

    @Override
    public String from(FileInputStream inputStream) {
        return from((InputStream) inputStream);
    }

}
