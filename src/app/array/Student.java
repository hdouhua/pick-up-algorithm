package app.array;

/**
 * Student
 */
public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student (name: %s, score: %d)", this.name, this.score);
    }

    public static void main(String[] args) {
        Array<Student> students = new Array<>();
        students.addLast(new Student("yang", 99));
        // TODO: to fix find issue
        Student std = new Student("erin", 100);
        students.addLast(std);
        students.addLast(new Student("douhua", 88));
        System.out.println(students);
        System.out.println(students.find(std));
    }

}