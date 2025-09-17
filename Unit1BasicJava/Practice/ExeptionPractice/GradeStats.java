import java.nio.file.*;
import java.util.*;
import java.io.*;

public final class GradeStats {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get(args[0]); 
        List<String> lines = Files.readAllLines(path);
        double sum = 0;
        int count = 0;

        for (String line : lines) {
            if (line.startsWith("#")) continue;
            String[] parts = line.split(",");
            String name = parts[0].trim();
            int score = Integer.parseInt(parts[1].trim());
            sum += score;
            count++;
        }

        double avg = sum / count; 
        System.out.println("Average=" + avg);
    }
}
