package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the file path:");
        String filePath = input.nextLine();

        File file = new File(filePath);

        if (!file.exists() || file.isDirectory()) {
            System.out.println("File not found!");
            return;
        }

        List<String> lines = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                lines.add(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }

        // Find the max line length
        int maxLength = 0;
        for (String line : lines) {
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }

        for (String line : lines) {
            String padded = String.format("%-" + maxLength + "s", line);
            String mirrored = mirrorReverse(padded);
            System.out.println(padded + " | " + mirrored);
        }
    }

    private static String mirrorReverse(String line) {
        Map<Character, Character> mirrorMap = new HashMap<>();
        mirrorMap.put('<', '>');
        mirrorMap.put('>', '<');
        mirrorMap.put('[', ']');
        mirrorMap.put(']', '[');
        mirrorMap.put('{', '}');
        mirrorMap.put('}', '{');
        mirrorMap.put('(', ')');
        mirrorMap.put(')', '(');
        mirrorMap.put('/', '\\');
        mirrorMap.put('\\', '/');

        StringBuilder reversed = new StringBuilder();
        for (int i = line.length() - 1; i >= 0; i--) {
            char c = line.charAt(i);
            reversed.append(mirrorMap.getOrDefault(c, c));
        }

        return reversed.toString();
    }
}