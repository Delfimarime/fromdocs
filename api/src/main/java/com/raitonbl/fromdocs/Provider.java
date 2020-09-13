package com.raitonbl.fromdocs;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;

public interface Provider {

    String from(File file);

    String from(Path paths);

    String from(InputStream inputStream);

    String from(FileInputStream inputStream);

}
