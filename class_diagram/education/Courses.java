package education;

public class Courses {
    private String courseName;
    private int numberOfCredits;

    public Courses(String courseName, int numberOfCredits) {
        this.courseName = courseName;
        this.numberOfCredits = numberOfCredits;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

   
    public int getDisciplineCredits() {
        return numberOfCredits;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }}

