import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<Person> person = new ArrayList<Person>();
        List<Student> students = new ArrayList<Student>();
        person.add(new Person("Каргин Василий Сергеевич", 29, 1992));
        person.add(new Person("Семенов Семен Семенович", 25, 1997));
        person.add(new Person("Иванов Иван Иванович", 22, 2000));
        person.add(new Person("Иванов Семен Иванович", 50, 1972));
        person.add(new Person("Иванов Петр Иванович", 2, 2020));

        CheckAge personlist = a -> {
            List<Person> p= new ArrayList<>();
            for (int i=0;i< args.length;i++){
                if (a.getAge()>17 || a.getAge()<40){
                    p.add(a);
                }
                i++;
            }
            return p;
        };
        System.out.println(personlist.toString());
        GroupStudent checks = (a) -> {
            if (a.getAge() > 17 && a.getAge() < 40) {
                if (a.getBirthYear() < 1995) {
                    return "УбИН-01-22";
                } else
                    return "УбИН-02-22";
            }
            return null;
        };

        Function<Person, Student> converter = x -> new Student(x.getName(), x.getAge(), checks.group(x));
        //students.add(converter.apply(person));
        for (Person persons: person){
            students.add(converter.apply(persons));
        }
        System.out.println(students);
    }
}

interface GroupStudent {
    String group(Person a);
}
interface CheckAge {
    List<Person> checkAge(Person a);
}

