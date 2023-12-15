package education;

public class Courses {
    private String courseName;
    private int numberOfCredits;

    public Courses( String courseName, int numberOfCredits) {
        this.courseName = courseName;
        this.numberOfCredits = numberOfCredits;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }
}

