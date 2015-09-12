package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder result=new StringBuilder();

        for (Map.Entry<String,String> itr:params.entrySet()){
            String key = itr.getKey();
            String value = itr.getValue();
            if (value!=null){
                if (result.length()==0){
                    result.insert(0,key)
                            .insert(key.length(), " = '")
                            .insert(key.length() + " = '".length(),value)
                            .insert(key.length() + " = '".length()+value.length(),"'");
                }else {
                    result.append(" and ").append(key).append(" = '").append(value).append("'");
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //Map<String,String> map=new LinkedHashMap<String,String>();
        Map<String,String> map=new HashMap<String,String>();
        map.put("name","Ivanov");
        map.put("country","Ukraine");
        map.put("city","Kiev");
        map.put("age",null);
        System.out.println(getCondition(map));
    }
}
