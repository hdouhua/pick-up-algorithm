package app.set_and_map;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;
import java.io.File;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;

/**
 * FileOperation
 * 
 * based from
 * https://github.com/liuyubobobo/Play-with-Data-Structures/blob/master/07-Set-and-Map/01-Set-Basics-and-BSTSet/src/FileOperation.java
 */
public class FileOperation {

    // 读取文件名称为filename中的内容，并将其中包含的所有词语放进words中
    public static boolean readFile(String filename, ArrayList<String> words) {

        if (filename == null || words == null) {
            System.out.println("filename is null or words is null");
            return false;
        }

        // 文件读取
        Scanner scanner;

        try {
            File file = new File(FileSystems.getDefault().getPath("src/app/set_and_map").toString(), filename);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } else{
                System.out.println("Cannot find the file " + filename);
                return false;
            }
        } catch (IOException ioe) {
            System.out.println("Cannot open " + filename);
            return false;
        }

        // 简单分词
        // 这个分词方式相对简陋, 没有考虑很多文本处理中的特殊问题
        // 在这里只做demo展示用
        if (scanner.hasNextLine()) {

            String contents = scanner.useDelimiter("\\A").next();

            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length();)
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else
                    i++;
        }

        return true;
    }

    // 寻找字符串s中，从start的位置开始的第一个字母字符的位置
    private static int firstCharacterIndex(String s, int start) {

        for (int i = start; i < s.length(); i++)
            if (Character.isLetter(s.charAt(i)))
                return i;
        return s.length();
    }

}