import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // ===============================
        // CREAZIONE LISTA STUDENTI
        // ===============================
        // Creo una lista di studenti con informazioni anagrafiche,
        // accademiche e temporali che verranno utilizzate
        // per esercizi sulle Stream API.
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

        // ===============================
        // RAGGRUPPAMENTO PER CORSO
        // ===============================
        // Raggruppo gli studenti per corso di laurea.
        // Per ogni corso stampo:
        // - numero di studenti
        // - media dei voti
        // - media dei CFU
        System.out.println("Studenti per corso");

        Map<String, List<Student>> studentiPerCorso =
                students.stream()
                        .collect(Collectors.groupingBy(Student::getCourse));

        studentiPerCorso.forEach((corso, listaStudenti) -> {
            System.out.println(
                corso + " -> " +
                listaStudenti.stream().count() + " studenti, " +
                "media voti: " +
                listaStudenti.stream()
                        .collect(Collectors.averagingDouble(Student::getAverageGrade)) + ", " +
                "media CFU: " +
                listaStudenti.stream()
                        .collect(Collectors.averagingLong(Student::getCredits))
            );
            System.out.println();
        });

        // ===============================
        // PARTIZIONAMENTO LAVORATORI / NON LAVORATORI
        // ===============================
        // Divido gli studenti in due gruppi in base al fatto
        // che siano lavoratori o meno.
        // Uso partitioningBy perché la condizione è booleana.
        Map<Boolean, List<String>> lavoratori =
                students.stream()
                        .collect(Collectors.partitioningBy(
                                Student::isWorkingStudent,
                                Collectors.mapping(Student::getName, Collectors.toList())
                        ));

        lavoratori.forEach((isWorker, nomi) -> {
            System.out.println(isWorker + " -> " + nomi);
            System.out.println();
        });

        // ===============================
        // STUDENTE CON PIÙ CFU
        // ===============================
        // Trovo lo studente che ha accumulato il maggior numero di CFU.
        Student maxCfu =
                students.stream()
                        .max(Comparator.comparingLong(Student::getCredits))
                        .orElseThrow();

        System.out.println(maxCfu.getName() + " -> " + maxCfu.getCredits());
        System.out.println();

        // ===============================
        // STUDENTE PIÙ RECENTE PER CORSO
        // ===============================
        // Per ogni corso individuo lo studente con la data
        // di iscrizione più recente.
        Map<String, Optional<Student>> studenteRecenteCorso =
                students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getCourse,
                                Collectors.maxBy(
                                        Comparator.comparing(Student::getEnrollmentDate)
                                )
                        ));

        studenteRecenteCorso.forEach((corso, optStudente) -> {
            optStudente.ifPresent(studente ->
                    System.out.println(corso + " -> " + studente.getName())
            );
        });
    }
}
