import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
            new Student("Luca", "Informatica", 1, 27.5, 30, false,
                        LocalDate.of(2023, 9, 20), LocalDate.of(2024, 2, 10)),
            new Student("Anna", "Informatica", 2, 29.0, 90, false,
                        LocalDate.of(2022, 9, 20), LocalDate.of(2024, 1, 25)),
            new Student("Marco", "Ingegneria", 1, 25.0, 24, true,
                        LocalDate.of(2023, 9, 20), LocalDate.of(2024, 2, 5)),
            new Student("Giulia", "Ingegneria", 3, 30.0, 150, false,
                        LocalDate.of(2021, 9, 20), LocalDate.of(2024, 1, 30)),
            new Student("Paolo", "Matematica", 2, 26.0, 78, true,
                        LocalDate.of(2022, 9, 20), LocalDate.of(2024, 2, 1)),
            new Student("Sara", "Informatica", 3, 28.0, 120, false,
                        LocalDate.of(2021, 9, 20), LocalDate.of(2024, 2, 12)),
            new Student("Elena", "Matematica", 1, 24.5, 36, false,
                        LocalDate.of(2023, 9, 20), LocalDate.of(2024, 1, 20)),
            new Student("Davide", "Fisica", 2, 27.0, 84, true,
                        LocalDate.of(2022, 9, 20), LocalDate.of(2024, 2, 8)),
            new Student("Chiara", "Fisica", 3, 28.5, 138, false,
                        LocalDate.of(2021, 9, 20), LocalDate.of(2024, 1, 28)),
            new Student("Simone", "Economia", 1, 23.0, 18, false,
                        LocalDate.of(2023, 9, 20), LocalDate.of(2024, 2, 3)),
            new Student("Francesca", "Economia", 2, 25.5, 72, true,
                        LocalDate.of(2022, 9, 20), LocalDate.of(2024, 1, 18)),
            new Student("Alessio", "Informatica", 1, 26.0, 42, false,
                        LocalDate.of(2023, 9, 20), LocalDate.of(2024, 2, 6)),
            new Student("Martina", "Ingegneria", 2, 27.5, 96, false,
                        LocalDate.of(2022, 9, 20), LocalDate.of(2024, 2, 2)),
            new Student("Riccardo", "Matematica", 3, 29.0, 144, false,
                        LocalDate.of(2021, 9, 20), LocalDate.of(2024, 1, 27))
        );

        //Raggruppa gli studenti per corso e stampa
        System.out.println("Studenti per corso");
        Map<String,List<Student>> studentiPerCorso = students.stream()
        .collect(Collectors.groupingBy(Student::getCourse));
        studentiPerCorso.forEach((corso,libri)->{
            System.out.println(corso+"->"+libri.stream().count()+" "+libri.stream().collect(Collectors.averagingDouble(n->n.getAverageGrade()))+" "+libri.stream().collect(Collectors.averagingLong(n->n.getCredits()))+"\n");
        });

        //Separa i lavoratori (true) dai non lavoratori (false)
        Map<Boolean,List<String>> lavoratori = students.stream().collect(Collectors.partitioningBy(Student::isWorkingStudent,Collectors.mapping(Student::getName,Collectors.toList())));
        lavoratori.forEach((bol,nome)->{
            System.out.println(bol+"->"+nome+"\n");
        });

        //Trova lo studente con più CFU
        Student maxCfu = students.stream().max(Comparator.comparingLong(Student::getCredits)).orElseThrow();
        System.out.println(maxCfu.getName()+"->"+maxCfu.getCredits()+"\n");

        //Per ogni corso, trova lo studente più recente
        Map<String,Optional<Student>> studenteRecenteCorso = students.stream().collect(Collectors.groupingBy(Student::getCourse,Collectors.maxBy(Comparator.comparing(Student::getEnrollmentDate))));

        studenteRecenteCorso.forEach((corso,studente)->{
            studente.stream().forEach(n->System.out.println(corso+"->"+n.getName()));
        });

    }
}
