package education;

import java.util.HashMap;
import java.util.Vector;
import enums.WeekDays;
import userCapabilities.Educationable;
import userCapabilities.Managable;
import users.Teacher;

public class Mark implements Managable, Educationable {

    private int percentageOfMark;
    private Vector<Integer> lessonMark;
    private HashMap<Lesson, Integer> attestationResults;
    private Vector<String> downloadedFiles;
    private HashMap<Lesson, WeekDays> lessonSchedule;
    private HashMap<Teacher, WeekDays> officeHourSchedule;
    private HashMap<String, Vector<Mark>> marks;
    private String report;

    public Mark() {
        this.percentageOfMark = 0;
        this.lessonMark = new Vector<>();
        this.attestationResults = new HashMap<>();
        this.downloadedFiles = new Vector<>();
        this.lessonSchedule = new HashMap<>();
        this.officeHourSchedule = new HashMap<>();
        this.marks = new HashMap<>();
        this.report = "";
    }


    @Override
    public void viewAcademicStatistics() {

    }

    @Override
    public void makeOfficeHoursSchedule() {
       
    }

    @Override
    public void obtainingProgressStatistics() {
      
    }

    @Override
    public void gettingPassingStatistics() {
      
    }

    @Override
    public void viewRegisteredSchedule() {
    
    }

    
    @Override
    public HashMap<Lesson, Integer> viewAttestation() {
        
        return attestationResults;
    }

    @Override
    public Vector<String> viewDownloadedFiles() {
        
        return downloadedFiles;
    }

    @Override
    public HashMap<Lesson, WeekDays> viewLessonSchedule() {
        
        return lessonSchedule;
    }

    @Override
    public HashMap<Teacher, WeekDays> viewOfficeHourSchedule() {
        
        return officeHourSchedule;
    }

    @Override
    public HashMap<String, Vector<Mark>> viewMarks() {
        
        return marks;
    }

    @Override
    public String getReport() {
       
        return report;
    }


    public void addMark(String studentName, Lesson lesson, int mark) {
        this.lessonMark.add(mark);
        if (attestationResults.containsKey(lesson)) {
            attestationResults.put(lesson, mark);
        }

        if (marks.containsKey(studentName)) {
            marks.get(studentName).add(this);
        } else {
            Vector<Mark> studentMarks = new Vector<>();
            studentMarks.add(this);
            marks.put(studentName, studentMarks);
        }
    }

}
