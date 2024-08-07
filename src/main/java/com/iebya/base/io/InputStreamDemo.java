package com.iebya.base.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;

public class InputStreamDemo {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("src\\main\\java\\com\\iebya\\javabase\\io\\data.txt")) {
            System.out.println("Number of remaining bytes:" + fis.available());
            int content;
            long skip = fis.skip(2);
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.println("The content read from file:");
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n=====================================");

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src\\main\\java\\com\\iebya\\javabase\\io\\data.txt"))) {
            System.out.println("Number of remaining bytes:" + bis.available());
            int content;
            long skip = bis.skip(2);
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.println("The content read from file:");
            while ((content = bis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n=====================================");

        try (FileReader fileReader = new FileReader("src\\main\\java\\com\\iebya\\javabase\\io\\data.txt")) {
            int content;
            System.out.println("The content read from file:");
            while ((content = fileReader.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("\n=====================================");

        try (FileWriter fileWriter = new FileWriter("src\\main\\java\\com\\iebya\\javabase\\io\\data.txt",true)) {
            fileWriter.write("Hello, Java IO!\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        PrintStream printStream = new PrintStream(System.out);
        printStream.println("Hello, world!");
    }
}
