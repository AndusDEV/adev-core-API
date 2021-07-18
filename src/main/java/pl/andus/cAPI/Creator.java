package pl.andus.cAPI;

import java.io.File;
import java.io.IOException;

public class Creator {
    public void CreateFolder(String folderName, String folderPath) {
        String path = folderPath + folderName;
        File file = new File(path);
        boolean bool = file.mkdir();
        if (bool) {
            Logging.info("Folder " + folderName + " created successfully.");
        } else {
            Logging.error("Something went wrong :( ");
        }
    }

    public void CreateFile(String fileName, String filePath) {
        String path = filePath + fileName;
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                Logging.info("File " + fileName + " created successfully.");
            } else {
                Logging.info("File already exists.");
            }
        } catch (Exception e) {
            Logging.error(e.toString());
        }
    }
}
