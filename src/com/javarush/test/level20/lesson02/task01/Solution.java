//package com.javarush.test.level20.lesson02.task01;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///* Читаем и пишем в файл: Human
//Реализуйте логику записи в файл и чтения из файла для класса Human
//Поле name в классе Human не может быть пустым
//В файле your_file_name.tmp может быть несколько объектов Human
//Метод main реализован только для вас и не участвует в тестировании
//*/
//public class Solution {
//    public static void main(String[] args) {
//        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
//        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
//        try {
//
//            //File your_file_name = File.createTempFile("your_file_name", null);
//            File your_file_name = File.createTempFile("your_file_name", null,new File("D:/TEMP/"));
//            OutputStream outputStream = new FileOutputStream(your_file_name);
//            InputStream inputStream = new FileInputStream(your_file_name);
//
//            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
//            ivanov.save(outputStream);
//            outputStream.flush();
//
//            Human somePerson = new Human();
//            somePerson.load(inputStream);
//            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
//            inputStream.close();
//
//        } catch (IOException e) {
//            //e.printStackTrace();
//            System.out.println("Oops, something wrong with my file");
//        } catch (Exception e) {
//            //e.printStackTrace();
//            System.out.println("Oops, something wrong with save/load method");
//        }
//    }
//
//
//    public static class Human {
//        public String name;
//        public List<Asset> assets = new ArrayList<>();
//
//        public Human() {
//        }
//
//        public Human(String name, Asset... assets) {
//            this.name = name;
//            if (assets != null) {
//                this.assets.addAll(Arrays.asList(assets));
//            }
//        }
//
//        public void save(OutputStream outputStream) throws Exception {
//            //implement this method - реализуйте этот метод
//            PrintWriter printWriter=new PrintWriter(outputStream);
//
//            String isHuman=(this!=null?"yes":"no");
//            printWriter.println(isHuman);
//
//            if (isHuman.equals("yes")){
//                printWriter.println(this.name);
//                for (Asset obj:assets){
//                    if (!obj.getName().isEmpty()){
//                        printWriter.println(obj.getName());
//                        printWriter.println(obj.getPrice());
//                    }
//                }
//            }
//
//            printWriter.close();
//        }
//
//        public void load(InputStream inputStream) throws Exception {
//            //implement this method - реализуйте этот метод
//            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
//
//            String isHuman=bufferedReader.readLine();
//            ArrayList<String> listName=new ArrayList<String>();
//            ArrayList<Double> listPrice=new ArrayList<Double>();
//
//            if (isHuman.equals("yes")){
//                this.name=bufferedReader.readLine();
//                String tmp=new String();
//                double tmpD;
//                do {
//                    tmp=bufferedReader.readLine();
//                    try{
//                        listPrice.add(Double.parseDouble(tmp));
//                    }catch (Exception e){
//                        listName.add(tmp);
//                    }
//                }while (tmp.equals("no") || bufferedReader.ready());
//            }
//
//            for (int i = 0; i < listName.size(); i++) {
//                Asset asset=new Asset(listName.get(i));
//                asset.setPrice(listPrice.get(i));
//                assets.add(asset);
//            }
//        }
//    }
//}

package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        try {

            File fileName = File.createTempFile("D:/TEMP/111.txt", null);
            OutputStream outputStream = new FileOutputStream(fileName);
            InputStream inputStream = new FileInputStream(fileName);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);

            System.out.println(ivanov);
            System.out.println(somePerson);
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            String hasName = (this.name != null) ? "yes" : "no";
            printWriter.println(hasName);
            if ("yes".equals(hasName)) {
                printWriter.println(this.name);
                if (this.assets.size() > 0) {
                    for (Asset current : this.assets)
                        printWriter.println(current.getName());
                }
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String hasName = reader.readLine();
            if ("yes".equals(hasName)) {
                this.name = reader.readLine();
                String assetName;
                while ((assetName = reader.readLine()) != null)
                    this.assets.add(new Asset(assetName));
            }
            reader.close();
        }
    }
}
