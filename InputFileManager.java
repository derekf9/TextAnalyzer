import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFileManager {

    private String getSingleString(File txtfile)
    {
        Scanner sc = null;
        try {
            sc = new Scanner(txtfile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String current = "";
        String updated = "";
        while (sc.hasNextLine()) {
            current = sc.nextLine() + "\n";
            updated = updated + current;

        }
       return updated;
    }

    public String[] getStrings(File[] directory)
    {
     String[] txtFiles = new String[directory.length];

     for(int i = 0; i < txtFiles.length;i++)
     {
         txtFiles[i] = getSingleString(directory[i]);
     }
     return txtFiles;
    }
}




