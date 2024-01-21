import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;


public class BOJ_5635_생일 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Person[] person = new Person[N];
        List<Person> list = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            person[n] = new Person(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(person[n]);
        }
        Collections.sort(list, new PersonCompare());

        System.out.println(list.get(0).name);
        System.out.println(list.get(list.size() - 1).name);
    }
}

class PersonCompare implements Comparator<Person> {
    int ret = 0;
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.year < o2.year) ret = 1;
        if (o1.year == o2.year) {
            if (o1.month < o2.month) ret = 1;
            if (o1.month == o2.month) {
                if (o1.day < o2.day) ret = 1;
                if (o1.day > o2.day) ret = -1;
            }
            if (o1.month > o2.month) ret = -1;
        }
        if (o1.year > o2.year) ret = -1;
        return ret;
    }
}

class Person {
    String name;
    int day;
    int month;
    int year;
    Person(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }
}