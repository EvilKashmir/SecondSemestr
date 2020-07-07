package inf.lesson9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String PATH =
                "D:\\JavaProjects\\SecondSem\\src\\inf\\lesson9\\output.txt";
        List<Student> students = new ArrayList<>();
        students.add(new Student("Azat", 902, 19, true));
        students.add(new Student("Dima", 905, 19, true));
        students.add(new Student("Leonid", 902, 19, true));
        students.add(new Student("Anna", 901, 19, false));
        students.add(new Student("Alexandr", 902, 19, true));
        students.add(new Student("Rishat", 902, 27, true));
        students.add(new Student("Alexey", 902, 19, true));
        students.add(new Student("Danya", 902, 19, true));
        StudentIO.write(students);
        Collection<Student> t =  StudentIO.read(PATH);
        for(Student st : t) System.out.println(st);
    }
}
