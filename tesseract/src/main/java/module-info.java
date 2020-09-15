module com.raitonbl.fromdocs.tesseract {

    requires com.raitonbl.fromdocs;

    requires org.apache.commons.lang3;

    exports com.raitonbl.fromdocs.tesseract to com.raitonbl.fromdocs;

    provides com.raitonbl.fromdocs.Provider with com.raitonbl.fromdocs.tesseract.ProviderImpl;

}