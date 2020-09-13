module fromdocs.tesseract {

    requires fromdocs;

    exports com.raitonbl.fromdocs.tesseract to fromdocs;

    provides com.raitonbl.fromdocs.Provider with com.raitonbl.fromdocs.tesseract.ProviderImpl;

}