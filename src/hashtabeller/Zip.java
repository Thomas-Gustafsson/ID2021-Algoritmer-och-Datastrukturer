package hashtabeller;

import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {
    Node[] data;
    int max;

    public class Node {
        String code;
        String name;
        int pop;

        public Node(String code, String name, int pop) {
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
    }

    public Zip(String file) {
        data = new Node[10000];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public int lookup() {



        return 0;
    }
}
