package education;

import enums.WeekDays;
import users.Teacher;
import enums.Language;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mark implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer percentageOfMark;
    private List<Integer> lessonMarks;
    private HashMap<Lesson, AttestationResult> attestationResults;
    private HashMap<Lesson, ScheduleEntry> lessonSchedule;
    private HashMap<Teacher, WeekDays> officeHourSchedule;

    public Mark() {
        this.percentageOfMark = 0;
        this.lessonMarks = new ArrayList<>();
        this.attestationResults = new HashMap<>();
        this.lessonSchedule = new HashMap<>();
        this.officeHourSchedule = new HashMap<>();
    }

    public void addLessonMark(Lesson lesson, int mark, WeekDays lessonTime) {
        lessonMarks.add(mark);

        AttestationResult result = attestationResults.getOrDefault(lesson, new AttestationResult(0, 0));
        result.setFirstHalf(mark);
        attestationResults.put(lesson, result);
    }

    public void setFirstHalf(Lesson lesson, int firstHalf) {
        AttestationResult result = attestationResults.getOrDefault(lesson, new AttestationResult(0, 0));
        result.setFirstHalf(firstHalf);
        attestationResults.put(lesson, result);
    }

    public void setSecondHalf(Lesson lesson, int secondHalf) {
        AttestationResult result = attestationResults.getOrDefault(lesson, new AttestationResult(0, 0));
        result.setSecondHalf(secondHalf);
        attestationResults.put(lesson, result);
    }

    public int calculateAutomaticFirstHalf() {
        if (attestationResults.isEmpty()) {
            return 0;
        }

        int totalFirstHalfMarks = attestationResults.values().stream()
                .mapToInt(AttestationResult::getFirstHalf)
                .sum();

        return totalFirstHalfMarks / attestationResults.size();
    }

    public int calculateAutomaticSecondHalf() {
        if (attestationResults.isEmpty()) {
            return 0;
        }

        int totalSecondHalfMarks = attestationResults.values().stream()
                .mapToInt(AttestationResult::getSecondHalf)
                .sum();

        return totalSecondHalfMarks / attestationResults.size();
    }
    public String calculateFinalGrade() {
        if (lessonMarks.isEmpty() && attestationResults.isEmpty()) {
            return "No grades available";
        }

        int totalLessonMarks = lessonMarks.stream().mapToInt(Integer::intValue).sum();
        int totalAttestationMarks = attestationResults.values().stream()
                .mapToInt(result -> result.getFirstHalf() + result.getSecondHalf())
                .sum();
        int totalMarks = totalLessonMarks + totalAttestationMarks;
        int averageMark = totalMarks / (lessonMarks.size() + attestationResults.size());

        if (averageMark >= 95) {
            return "A";
        } else if (averageMark >= 90) {
            return "A-";
        } else if (averageMark >= 85) {
            return "B+";
        } else if (averageMark >= 80) {
            return "B";
        } else if (averageMark >= 75) {
            return "B-";
        } else if (averageMark >= 70) {
            return "C+";
        } else if (averageMark >= 65) {
            return "C";
        } else if (averageMark >= 60) {
            return "C-";
        } else if (averageMark >= 55) {
            return "D";
        } else if (averageMark >= 50) {
            return "D-";
        } else {
            return "F";
        }
    }


    public void addScheduleEntry(Lesson lesson, WeekDays dayOfWeek, String classroom, String time) {
        ScheduleEntry scheduleEntry = new ScheduleEntry(lesson, dayOfWeek, classroom, time);
        lessonSchedule.put(lesson, scheduleEntry);
    }

    public HashMap<Lesson, ScheduleEntry> getLessonScheduleEntries() {
        return lessonSchedule;
    }

    public Integer getPercentageOfMark() {
        return percentageOfMark;
    }

    public void setPercentageOfMark(Integer percentageOfMark) {
        this.percentageOfMark = percentageOfMark;
    }

    public HashMap<Lesson, AttestationResult> getAttestationResults() {
        return attestationResults;
    }

    public void setAttestationResults(HashMap<Lesson, AttestationResult> attestationResults) {
        this.attestationResults = attestationResults;
    }

    public HashMap<Lesson, ScheduleEntry> getLessonSchedule() {
        return lessonSchedule;
    }

    public void setLessonSchedule(HashMap<Lesson, ScheduleEntry> lessonSchedule) {
        this.lessonSchedule = lessonSchedule;
    }

    public HashMap<Teacher, WeekDays> getOfficeHourSchedule() {
        return officeHourSchedule;
    }

    public void setOfficeHourSchedule(HashMap<Teacher, WeekDays> officeHourSchedule) {
        this.officeHourSchedule = officeHourSchedule;
    }

    public String getReport(Language language) {
        String averageMark = calculateFinalGrade();

        String excellent, good, satisfactory, unsatisfactory;

        switch (language) {
            case KAZAKH:
                excellent = "O`te jaqsy ";
                good = "Jaqsy ";
                satisfactory = "Qanag`attandylarlyq ";
                unsatisfactory = "Qanag`attandylaryq emes ";
                break;
            case RUSSIAN:
                excellent = "Отлично";
                good = "Хорошо";
                satisfactory = "Удовлетворительно";
                unsatisfactory = "Неудовлетворительно";
                break;
            case ENGLISH:
                excellent = "Excellent";
                good = "Good";
                satisfactory = "Satisfactory";
                unsatisfactory = "Unsatisfactory";
                break;
            default:
                return "Unsupported Language";
        }

        if (averageMark.equals("A") || averageMark.equals("A-")) {
            return excellent;
        } else if (averageMark.equals("B+") || averageMark.equals("B") || averageMark.equals("B-")) {
            return good;
        } else if (averageMark.equals("C+") || averageMark.equals("C") || averageMark.equals("C-")) {
            return satisfactory;
        } else {
            return unsatisfactory;
        }
    }

    public void setReport(String report) {
    }
}

