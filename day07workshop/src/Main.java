import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        String fileName = args[0];

        FileReader fr = new FileReader(fileName);
        BufferedReader bfr = new BufferedReader(fr);

        Map<String, List<Float>> map = new HashMap<>();

        bfr.readLine(); // skip first line

        while(true) {
            String line = bfr.readLine();
            if (line == null)
                break;

            String[] lineDetails = line.split(",","\S");
            String category = lineDetails[1];
            Float rating = Float.parseFloat(lineDetails[2]);
            System.out.printf("%s : %f\n", category, rating);

            if (rating.isNaN())
                break;

            List<Float> ratings = new LinkedList<>();
            if (map.get(category) == null) {
                 ratings.add(rating);
                 map.put(category, ratings);
            } else {
                ratings = map.get(category);
                ratings.add(rating);
                map.put(category, ratings);
            }
        }

        System.out.println(map.entrySet());
    
    }
}

// currLine = Arrays.asList(line.split(","))
// .stream()
// .filter(null)
// .toList();