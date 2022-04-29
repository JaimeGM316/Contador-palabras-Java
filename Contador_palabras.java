package Contador_palabras;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Contador_palabras {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("File path: ");
        String path = sc.nextLine();
        String contenido = "";

        try {
            FileReader fr = new FileReader(path);
            sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                contenido = contenido + data;
            }

            contenido = contenido.replaceAll("[\\.\\,\\(\\)]", "");
            String[] palabras = contenido.split(" ");
            HashMap<String, Integer> map = new HashMap<>();
            for (String palabra : palabras) {
                if (map.containsKey(palabra)) {
                    map.put(palabra, map.get(palabra) + 1);
                } else {
                    map.put(palabra, 1);
                }
            }

            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort(Map.Entry.comparingByValue());
            Collections.reverse(list);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
