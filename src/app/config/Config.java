package app.config;

import java.nio.file.FileSystems;

public class Config {
    public static final String CSV_DELIMITER = ",";

    public static final String ABS_PRODUCTS_FILE_PATH = getDbFilePath();
    private static final String FOLDER_NAME = "db";
    private static final String FILE_NAME = "products.csv";

    public static final String CURRENCY = "USD";

    private static String getDbFilePath() {
        String userDir = System.getProperty("user.dir");
        String systemSeparator = FileSystems.getDefault().getSeparator();
        return userDir + systemSeparator + FOLDER_NAME + systemSeparator + FILE_NAME;
    }
}
