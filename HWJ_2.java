

/* Дана строка sql-запроса "select * from students where ". 
Сформируйте часть WHERE этого запроса, используя StringBuilder. 
Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: 
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
*/

package Java_lessons.HWJ_2;
import java.io.FileReader;
import java.io.BufferedReader;

public class HWJ_2 {
    public static void main(String[] args) {
        BufferedReader bufR = null;
        try {
            bufR = new BufferedReader(new FileReader("HWJ_2_datafile.json"));
            StringBuilder sB = new StringBuilder(bufR.readLine());
            System.out.println(sB);
            System.out.println("WHERE:");
            sB.replace(0, 1, "");                       
            sB.replace(sB.length() - 1, sB.length(), "");
            String where = sB.toString();
            where = where.trim();
            where = where.replace('"', ' ');
            where = where.replace(" ", "");
            where = where.replace(":", " = ");
            String[] lst = where.split(",");
            int count = 0;
            for (String item : lst) {
                if (item.contains("null")) continue;
                count++;
            }
            String[] lst2 = new String[count];
            for (int i = 0, j = 0; i < lst.length; i++) {
                if (lst[i].contains("null")) continue;
                lst2[j] = lst[i];
                j++;
            }
            String result = String.join(" AND ", lst2);
            System.out.println(result);
           
        }
            catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                bufR.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }
}