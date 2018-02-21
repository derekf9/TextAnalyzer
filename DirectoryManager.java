import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class DirectoryManager {


    public static File[] getTextDirectoryList()
    {
        String path = (new File(".")).getAbsolutePath();
        //String path =  "C:\\Users\\Derek\\Desktop\\MGGFolder";
        File folder = new File(path + "\\TextFolder");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            }
        }
        return listOfFiles;

    }

    public static File getOutputDirectory() {
        String path = (new File(".")).getAbsolutePath();
        //String path  = "C:\\Users\\Derek\\Desktop\\MGGFolder";
        File folder = new File( path + "\\ImportantTextFolder");

        return folder;
    }
}
