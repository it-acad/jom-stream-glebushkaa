package jom.com.softserve.s6.task3;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MyUtils {

    static void writeFile(String filename, String text) {
        try (FileWriter outputStream = new FileWriter(filename)) {
            var builder = new StringBuilder();
            for (char ch : text.toCharArray()) {
                String binaryString = String.format("%7s", Integer.toBinaryString(ch)).replace(' ', '0');
                builder.append(binaryString);
            }
            outputStream.write(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
