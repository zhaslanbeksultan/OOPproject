package education;

import enums.WeekDays;
import users.Teacher;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Mark implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int percentageOfMark;
    private Vector<Integer> lessonMarks;
    private HashMap<Lesson, Integer> attestationResults;
    private HashMap<Lesson, Map.Entry<WeekDays, Integer>> lessonAndMarks;
    private Vector<String> downloadedFiles;
    private HashMap<Lesson, WeekDays> lessonSchedule;
    private HashMap<Teacher, WeekDays> officeHourSchedule;
    private HashMap<String, Vector<Mark>> marks;
    private String report;

    public Mark() {
        this.setPercentageOfMark(0);
        this.lessonMarks = new Vector<>();
        this.setAttestationResults(new HashMap<>());
        this.lessonAndMarks = new HashMap<>();
        this.setDownloadedFiles(new Vector<>());
        this.setLessonSchedule(new HashMap<>());
        this.setOfficeHourSchedule(new HashMap<>());
        this.setMarks(new HashMap<>());
        this.setReport("");
    }

    public void addLessonMark(Lesson lesson, int mark, WeekDays lessonTime) {
        lessonMarks.add(mark);
        lessonAndMarks.put(lesson, Map.entry(lessonTime, mark));
    }

    public String calculateFinalGrade() {
        int totalMarks = lessonMarks.stream().mapToInt(Integer::intValue).sum();
        int averageMark = totalMarks / lessonMarks.size();

        if (averageMark >= 90) {
            return "A";
        } else if (averageMark >= 80) {
            return "B";
        } else if (averageMark >= 70) {
            return "C";
        } else if (averageMark >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

	public int getPercentageOfMark() {
		return percentageOfMark;
	}

	public void setPercentageOfMark(int percentageOfMark) {
		this.percentageOfMark = percentageOfMark;
	}

	public HashMap<Lesson, Integer> getAttestationResults() {
		return attestationResults;
	}

	public void setAttestationResults(HashMap<Lesson, Integer> attestationResults) {
		this.attestationResults = attestationResults;
	}

	public Vector<String> getDownloadedFiles() {
		return downloadedFiles;
	}

	public void setDownloadedFiles(Vector<String> downloadedFiles) {
		this.downloadedFiles = downloadedFiles;
	}

	public HashMap<Lesson, WeekDays> getLessonSchedule() {
		return lessonSchedule;
	}

	public void setLessonSchedule(HashMap<Lesson, WeekDays> lessonSchedule) {
		this.lessonSchedule = lessonSchedule;
	}

	public HashMap<Teacher, WeekDays> getOfficeHourSchedule() {
		return officeHourSchedule;
	}

	public void setOfficeHourSchedule(HashMap<Teacher, WeekDays> officeHourSchedule) {
		this.officeHourSchedule = officeHourSchedule;
	}

	public HashMap<String, Vector<Mark>> getMarks() {
		return marks;
	}

	public void setMarks(HashMap<String, Vector<Mark>> marks) {
		this.marks = marks;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}
}