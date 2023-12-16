package education;

public class Courses {
    private String courseName;
    private static int numberOfCredits;

    public Courses( String courseName, int numberOfCredits) {
        this.courseName = courseName;
        this.numberOfCredits = numberOfCredits;
    }

    public String getCourseName() {
        return courseName;
    }

    public static int getNumberOfCredits() {
        return numberOfCredits;
    }

	public static int getDisciplineCredits(Courses discipline) {
		return numberOfCredits;
	}

	}

