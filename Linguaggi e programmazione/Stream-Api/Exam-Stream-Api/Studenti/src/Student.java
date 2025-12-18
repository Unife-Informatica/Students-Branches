import java.time.LocalDate;

class Student {
    private String name;
    private String course;
    private int year;
    private double averageGrade;
    private int credits;
    private boolean workingStudent;
    private LocalDate enrollmentDate;
    private LocalDate lastExamDate;

    public Student(String name, String course, int year,
                   double averageGrade, int credits,
                   boolean workingStudent,
                   LocalDate enrollmentDate, LocalDate lastExamDate) {
        this.name = name;
        this.course = course;
        this.year = year;
        this.averageGrade = averageGrade;
        this.credits = credits;
        this.workingStudent = workingStudent;
        this.enrollmentDate = enrollmentDate;
        this.lastExamDate = lastExamDate;
    }

    public String getName() { return name; }
    public String getCourse() { return course; }
    public int getYear() { return year; }
    public double getAverageGrade() { return averageGrade; }
    public int getCredits() { return credits; }
    public boolean isWorkingStudent() { return workingStudent; }
    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public LocalDate getLastExamDate() { return lastExamDate; }

    @Override
    public String toString() {
        return name + " - " + course +
               " - anno " + year +
               " - media " + averageGrade +
               " - CFU " + credits +
               " - lavoratore " + workingStudent +
               " - iscrizione " + enrollmentDate +
               " - ultimo esame " + lastExamDate;
    }
}
