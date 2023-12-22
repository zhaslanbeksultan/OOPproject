package education;

public class Courses {
    private String courseName;
    private static int numberOfCredits;

    public Courses(String courseName, int numberOfCredits) {
        this.courseName = courseName;
        Courses.numberOfCredits = numberOfCredits;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

   
    public static int getDisciplineCredits() {
        return numberOfCredits;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        Courses.numberOfCredits = numberOfCredits;
    }
}
