package assignment9;

import java.io.File;
import java.util.*;

public class Main {
    static Scanner reader = new Scanner(System.in);


    public static void main(String[] args)  {

        Long startTime=System.currentTimeMillis();


        //هذه الهاش متاب تعمل على حفظ البحوثات السابقه من اجل اذا تكرر البحث يبحث من هذه الهاش ماب
        HashMap<String, ArrayList<String>> Cach = new HashMap<String, ArrayList<String>>();

        int c = 0;

        while (c == 0) {


            System.out.println(" =======================================================================");
            System.out.println(" == If you have already searched, the search will be done by HashMap  ==");
            System.out.println(" ======================================================================= \n");
            System.out.println(" Enter file name ");
            String file_name = reader.nextLine();

            //انشناء كائن من كلاس الفايل سرش من اجل استدعاء وتشغيل الدوال الذي تعمل على البحث عن الملف المطلوب
            searchfile fileSearch = new searchfile();

            //هذه الاف الشرطيه تعمل على فحص الهاش ماب اذا كان قى تم البحث عن الملف سابقا ام لا
            //اذا كان اسم الملف موجود في الهاش ماب على طول تطبع اسم المف ومسار الملف المخزن كمقدار لاسم الملف في الهاش ماب
            if (Cach.get(file_name) != null) {
                System.out.println(Cach.get(file_name));
                System.out.println("\n>>>>>  in HashMap searched");
            }

            //اذا لم يكن اسم الملف موجود في الهاش ماب فسوف يتم البحث عنه بالطريقه العاديه في المسار المحدد الذي سيتم ادخاله تحت
            else {
                System.out.println(" Enter path address ");
                String path_name = reader.nextLine();


                new File(path_name);
                fileSearch.searchDirectory(new File(path_name), file_name);

                int count = fileSearch.getResult().size();
                if (count == 0) {
                    System.out.println("\nNo result found!");
                } else {
                    System.out.println("\nFound " + count + " result!\n");
                    for (String matched : fileSearch.getResult()) {
                        System.out.println(file_name + "  Found in path >> : " + matched);
                        Cach.put(file_name, (ArrayList<String>) fileSearch.result);

                    }

                }
            }




            System.out.println("execution time is >>>>>>   "+(System.currentTimeMillis()-startTime)+" ms");

        }


    }


}


