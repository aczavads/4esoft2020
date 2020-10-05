package aula20201005;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppRecursãoComArquivos {
    private Logger logger = LoggerFactory.getLogger(AppRecursãoComArquivos.class);
    private static final String DEFAULT_TARGET_PATH = "/tmp/unicesumar";
    private String targetPath = DEFAULT_TARGET_PATH;
    private static final String DEFAULT_SOURCE_PATH = "/home/arthur/unicesumar";
    private String sourcePath = DEFAULT_SOURCE_PATH;

    public static void main(String[] args) {
        AppRecursãoComArquivos app = new AppRecursãoComArquivos();
        app.copyTo("/home/arthur/unicesumar/teste/", null);
    }

    private void copyTo(String sourcePath, String targetPath) {
        if (sourcePath != null) {
            this.sourcePath = sourcePath;
        }
        if (targetPath != null) {
            this.targetPath = targetPath;
        }
        logger.info("Iniciando com source [{}] e target [{}]", this.sourcePath, this.targetPath);
        List<String> fileNames = new ArrayList<>();
        getFileNames(fileNames, this.sourcePath);
    }

    private void getFileNames(List<String> fileNames, String sourcePath) {
        File current = new File(sourcePath);
        if (current.isDirectory()) {
            File[] files = current.listFiles();
            for (File f : files) {
                getFileNames(fileNames, f.getAbsolutePath());
            }
        } else {
            fileNames.add(sourcePath);
            logger.info("Adicionando aquivo [{}]", sourcePath);
        }
    }
}
