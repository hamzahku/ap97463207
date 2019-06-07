package assignment9;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {


        HashMap<String, ArrayList<String>> Cach = new HashMap<String, ArrayList<String>>();

        int c = 0;

        while (c == 0) {



            System.out.println(" =======================================================================");
            System.out.println(" == If you have already searched, the search will be done by HashMap  ==");
            System.out.println(" ======================================================================= \n");
            System.out.println(" Enter file name ");
            String file_name = reader.nextLine();


            searchfile fileSearch = new searchfile();

            if (Cach.get(file_name) != null) {
                System.out.println(Cach.get(file_name));
                System.out.println("\n>>>>>  in HashMap searched");
            } else {
                System.out.println(" Enter path address ");
                String path_name = reader.nextLine();
                fileSearch.searchDirectory(new File(path_name), file_name);

                int count = fileSearch.getResult().size();
                if (count == 0) {
                    System.out.println("\nNo result found!");
                } else {
                    System.out.println("\nFound " + count + " result!\n");
                    for (String matched : fileSearch.getResult()) {
                        System.out.println(file_name+"  Found in path >> : " + matched);
                        Cach.put(file_name, (ArrayList<String>) fileSearch.result);

                    }

                }
            }

            System.out.println(" \n \n                       Now you can search again  ");
        }
    }
}

