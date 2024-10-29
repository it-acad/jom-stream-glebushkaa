package jom.com.softserve.s6.task4;

import java.io.FileInputStream;
import java.io.IOException;

public class MyUtils {

    static String readFile(String filename) {
        StringBuilder finalStringBuilder = new StringBuilder();
        try (FileInputStream stream = new FileInputStream(filename)) {
            StringBuilder binaryBuilder = new StringBuilder();
            for(byte element: stream.readAllBytes()) {
                binaryBuilder.append((char) element);
            }
            for (int i = 0; i < binaryBuilder.length(); i += 7) {
                String binaryChar = binaryBuilder.substring(i, i + 7);
                int charValue = Integer.parseInt(binaryChar, 2);
                finalStringBuilder.append((char) charValue);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return finalStringBuilder.toString();
    }
}
