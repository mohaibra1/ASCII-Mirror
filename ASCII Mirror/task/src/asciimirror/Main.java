package asciimirror;

import java.io.File;
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

        boolean isFile = file.isDirectory();
        if (isFile) System.out.printf("%s\n%s", input, ascii);
        else System.out.printf("%s\n%s", input, ascii);
    }
}