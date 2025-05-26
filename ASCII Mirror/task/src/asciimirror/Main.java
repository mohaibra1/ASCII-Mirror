package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String ascii = """
                            ^__^
                    _______/(oo)
                /\\/(       /(__)
                   | w----||   \s
                   ||     ||   \s
                """;

        System.out.println("Input the file path:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        File file = new File(input);

        try (Scanner scanner1 = new Scanner(file)){
            while (scanner1.hasNext()){
                System.out.println(scanner1.nextLine());
            }
        }catch (FileNotFoundException fx){
            System.out.println("File not found");
        }

//        boolean isFile = file.isDirectory();
//        if (isFile) System.out.printf("%s\n%s", input, ascii);
//        else System.out.printf("%s\n%s", input, ascii);
    }
}