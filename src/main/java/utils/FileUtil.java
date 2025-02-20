package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class FileUtil{
    public static void deleteFiles(String filePath){
        File file = new File(filePath);
        System.out.println("Attempt to delete files in " + filePath);
        try  {
            if (Objects.requireNonNull(file.listFiles()).length != 0) {
                FileUtils.cleanDirectory(file);
                System.out.println("Files are deleted.");
            } else System.out.println("Folder is already empty");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
