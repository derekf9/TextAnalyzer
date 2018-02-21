import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TextAnaylzer {

    public static void main(String[]args)
    {
        DirectoryManager d1 = new DirectoryManager();
        InputFileManager i1 = new InputFileManager();
        File[] Filelist = d1.getTextDirectoryList();
        String[] txtfiles = i1.getStrings(Filelist);
        DocCreater DC1 = new DocCreater(txtfiles);

        Document[] docs = DC1.AnaylzeDocType();
        docs[0].AnalyzeText();
        System.out.println(docs[0].Anayledtxt);
        for(int i = 0; i < docs.length;i++)
        {
            docs[i].AnalyzeText();
        }



        List<List<String>> NestedList = new ArrayList<>(docs.length);
        for(int i = 0;i < docs.length;i++) {
            List<String> lines = Arrays.asList(docs[i].Anayledtxt);
            NestedList.add(lines);
        }

        for(int i = 1; i <= NestedList.size(); i ++) {
            Path file = Paths.get("C:\\Users\\Derek\\Desktop\\MGGFolder\\ImportantTextFolder\\filename" + i + ".txt");

            try {
                Files.write(file, NestedList.get(i-1), Charset.forName("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Path file = Paths.get("C:\\Users\\Derek\\Desktop\\MGGFolder\\ImportantTextFolder\\index.txt");
        List temp = new ArrayList();
        String temp1 = String.valueOf(docs.length);
        temp.add(temp1);
        try {
            Files.write(file,temp, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}

