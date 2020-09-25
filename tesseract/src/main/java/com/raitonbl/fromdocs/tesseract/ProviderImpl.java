package com.raitonbl.fromdocs.tesseract;

import com.raitonbl.fromdocs.FromDocsException;
import com.raitonbl.fromdocs.Provider;
import net.sourceforge.tess4j.Tesseract;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;

public class ProviderImpl implements Provider {

    private final Tesseract runtime;

    public ProviderImpl() {
        this.runtime = new Tesseract();
        this.runtime.setLanguage("eng");
        this.runtime.setPageSegMode(1);
        this.runtime.setOcrEngineMode(1);
        this.runtime.setDatapath("src/main/resources/tessdata");
    }

    @Override
    public String from(File image) {
        try {

            if (image == null) {
                return null;
            }

            return runtime.doOCR(image);
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
        try {
            return from(ImageIO.read(inputStream));
        } catch (FromDocsException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new FromDocsException(ex);
        }
    }

    public String from(BufferedImage image) {
        try {

            if (image == null) {
                return null;
            }

            return runtime.doOCR(image);
        } catch (Exception ex) {
            throw new FromDocsException(ex);
        }
    }

    @Override
    public String from(FileInputStream inputStream) {
        return from((InputStream) inputStream);
    }

}
