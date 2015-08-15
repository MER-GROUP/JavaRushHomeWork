package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("your_file_name", null);
            File your_file_name = File.createTempFile("your_file_name", null,new File("D:\\TEMP"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
//            //test///////////////////////////////////////////////////////////////////////////////////////////
//            User user1=new User();///////////////////////////////////////////////////////////////////////////
//            user1.setFirstName("Max");///////////////////////////////////////////////////////////////////////
//            //user1.setLastName("Ramanenka");//////////////////////////////////////////////////////////////////
//            user1.setBirthDate(new Date(new SimpleDateFormat("dd-MM-yyyy").parse("25-05-1986").getTime()));//
//            user1.setMale(true);/////////////////////////////////////////////////////////////////////////////
//            user1.setCountry(User.Country.RUSSIA);///////////////////////////////////////////////////////////
//            javaRush.users.add(user1);///////////////////////////////////////////////////////////////////////

            User user1 = new User();
            user1.setBirthDate(new SimpleDateFormat("dd.MM.yyyy").parse("25.05.1986"));
            user1.setCountry(User.Country.RUSSIA);
            //user1.setFirstName("Kolea");
            user1.setLastName("Golubkov");
            user1.setMale(true);

            User user2 = new User();
            user2.setBirthDate(new SimpleDateFormat("dd.MM.yyyy").parse("12.06.1989"));
            user2.setCountry(User.Country.OTHER);
            user2.setFirstName("Masha");
            user2.setLastName(null);
            user2.setMale(false);

            javaRush.users.add(user1);
            javaRush.users.add(user2);
            //////////////////////////////////////////


            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            //test////////////////////////////////////////////////////////////////////////////////////////////////////////
            for (int i = 0; i < loadedObject.users.size(); i++) {/////////////////////////////////////////////////////////
                System.out.println(loadedObject.users.get(i).getFirstName());/////////////////////////////////////////////
                System.out.println(loadedObject.users.get(i).getLastName());//////////////////////////////////////////////
                System.out.println(new SimpleDateFormat("dd.MM.yyyy").format(loadedObject.users.get(i).getBirthDate()));//
                System.out.println(loadedObject.users.get(i).isMale());///////////////////////////////////////////////////
                System.out.println(loadedObject.users.get(i).getCountry().getDisplayedName());////////////////////////////
            }/////////////////////////////////////////////////////////////////////////////////////////////////////////////

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter=new PrintWriter(outputStream);
            String isObject=(this!=null?"yes":"no");
            printWriter.println(isObject);
            if ("yes".equals(isObject)){
                for (User i:users){
                    printWriter.println(i.getFirstName());
                    printWriter.println(i.getLastName());
                    printWriter.println(new SimpleDateFormat("dd.MM.yyyy").format(i.getBirthDate()));
                    printWriter.println(i.isMale());
                    //printWriter.println(i.getCountry().getDisplayedName());
                    printWriter.println(i.getCountry());
                }
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
            String isObject=reader.readLine();
            if ("yes".equals(isObject)){
                //User user=new User();
                while (reader.ready()){
                    User user=new User();
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    user.setBirthDate(new SimpleDateFormat("dd.MM.yyyy").parse(reader.readLine()));
                    user.setMale(Boolean.parseBoolean(reader.readLine()));
                    String str=reader.readLine();
//                    if ("Ukraine".equals(str)){
//                        user.setCountry(User.Country.UKRAINE);
//                    }else if ("Russia".equals(str)){
//                        user.setCountry(User.Country.RUSSIA);
//                    }else{
//                        user.setCountry(User.Country.OTHER);
//                    }
                    user.setCountry(User.Country.valueOf(str));
                    users.add(user);
                }
            }
            reader.close();
        }
    }
}
