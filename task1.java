// 1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class task1 {
    static StringBuilder app(String name, String country, String city, String age) {
        StringBuilder request = new StringBuilder();
        request.append("select * from students where ");
        if (!name.equals("null") & (!country.equals("null") | !city.equals("null") | (!age.equals("null")))) {
            request.append("name = '" + name + "'");
            request.append(" and ");
        } else if (!name.equals("null")) {
            request.append("name = '" + name + "'");
        }
        if (!country.equals("null") & (!city.equals("null") | !age.equals("null"))) {
            request.append("country = '" + country + "'");
            request.append(" and ");
        } else if (!country.equals("null")) {
            request.append("country = '" + country + "'");
        }
        if (!city.equals("null") & !age.equals("null")) {
            request.append("city = '" + city + "'");
            request.append(" and ");
        } else if (!city.equals("null")) {
            request.append("city = '" + city + "'");
        }
        if (!age.equals("null")) {
            request.append("age = '" + age + "'");
        }
        return request;
    }

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("task1.json")) {
            // Чтение JSON файла
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            // Получение значений из JSON объекта
            String name = (String) jsonObject.get("name");
            String country = (String) jsonObject.get("country");
            String city = (String) jsonObject.get("city");
            String age = (String) jsonObject.get("age");
            System.out.println(app(name, country, city, age));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
