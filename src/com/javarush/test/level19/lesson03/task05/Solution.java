package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();
    static{
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            StringBuilder builderCountry=new StringBuilder();
            Iterator<Map.Entry<String,String>> iterator=countries.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String,String> pair=iterator.next();
                if (pair.getValue().equals(customer.getCountryName())){
                    builderCountry.append(pair.getKey());
                    break;
                }
            }
            return builderCountry.toString();
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] stringRes=contact.getName().split(", ");
            return stringRes[1];
        }

        @Override
        public String getContactLastName() {
            String[] stringRes=contact.getName().split(", ");
            return stringRes[0];
        }

        @Override
        public String getDialString() {
            StringBuilder builderRes=new StringBuilder();
            String str=contact.getPhoneNumber();
            builderRes.append("callto://+");
            for (int i = 0; i < str.length(); i++) {
                if ('0'<=str.charAt(i) && '9'>=str.charAt(i)){
                    builderRes.append(str.charAt(i));
                }
            }

//            String phoneNumber = this.contact.getPhoneNumber();
//            String rowDigits = phoneNumber.replaceAll("[^+0-9]", "");
//            System.out.println(rowDigits);
//            return "callto://"+rowDigits;

            return builderRes.toString();
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}