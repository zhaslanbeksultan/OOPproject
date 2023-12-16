package education;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

import enums.DisciplineType;
import userCapabilities.Administrationable;
import enums.Faculty;
import users.Teacher;
import enums.Language;

public abstract class Course implements Administrationable {

	private HashSet<Courses> registeredDisciplines = new HashSet<>();
	ArrayList<Courses> courseList = new ArrayList<>();
    
    private String courseId;
    private String courseName;
    private int numberOfCredits;
    protected static DisciplineType disciplineType;
    private String specialtyId;
    private Set<Teacher> teachers;
    private Teacher lessonTaughtProfessor;
    private Lesson lesson;
    private Specialty specialty;

    //constructor 
    public Course(String courseId, String courseName, int numberOfCredits, DisciplineType disciplineType, String specialtyId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.numberOfCredits = numberOfCredits;
        Course.disciplineType = disciplineType;
        this.specialtyId = specialtyId;
        this.teachers = new HashSet<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public DisciplineType getDisciplineType() {
        return Course.disciplineType; 
    }

    public String getSpecialtyId() {
        return specialtyId;
    }

    public Teacher getLessonTaughtProfessor() {
        return lessonTaughtProfessor;
    }

    public void setLessonTaughtProfessor(Teacher lessonTaughtProfessor) {
        this.lessonTaughtProfessor = lessonTaughtProfessor;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public void viewAvailableCourses(Faculty faculty, int semester, int ects, Language language) {

        if (faculty == Faculty.SITE) {
           if(semester==1) {
        	courseList.add(new Courses( "Programming Principles I", 6));
            courseList.add(new Courses( "Calculus I", 5));
            courseList.add(new Courses("Discrete Structures", 5));
            courseList.add(new Courses("English", 10));
           }
           else if(semester == 2) {
        	   courseList.add(new Courses( "Programming Principles II", 6));
        	   courseList.add(new Courses( "Calculus II", 5));
        	   courseList.add(new Courses( "Physics I", 5));
        	   courseList.add(new Courses( "Statistics ", 5));
        	   courseList.add(new Courses( "Merging Personal and Global Evolution", 8));
        	   courseList.add(new Courses( "Linear Algebra", 5));
           }
           else if(semester == 3) {
        	   courseList.add(new Courses( "Databases", 5));
        	   courseList.add(new Courses( "Algorithms and Data Structure", 5));
        	   courseList.add(new Courses( "Computer Architecture", 5));
        	   courseList.add(new Courses( "Object-Oriented Programming and Design", 5));
        	   courseList.add(new Courses( "Physical Education I", 4));
        	   courseList.add(new Courses( "Kazakh/Russian Language", 5));
        }
           else if (semester == 4) {
        	   courseList.add(new Courses( "WEB Development ", 6));
        	   courseList.add(new Courses( "Computer NetWorks", 6));
        	   courseList.add(new Courses( "Introduction to Business Management", 5));
        	   courseList.add(new Courses( "Elective", 5));
        	   courseList.add(new Courses( "Physical Education II", 4));
        	   courseList.add(new Courses( "Kazakh Language", 5));
           }
           else if(semester == 5) {
        	   courseList.add(new Courses( "Software Engineering", 5));
        	   courseList.add(new Courses( "Fundamentals of Business for Information Systems", 5));
        	   courseList.add(new Courses( "Basics of Information Systems", 5));
        	   courseList.add(new Courses( "Elective", 5));
        	   courseList.add(new Courses( "Information and Communication Technology", 5));
        	   courseList.add(new Courses( "History of Kazakhstan", 5));
           }
           else if(semester == 6) {
        	   courseList.add(new Courses( "Fields Projects for Information Systems", 5));
        	   courseList.add(new Courses( "Cyber Security Fundamentals", 5));
        	   courseList.add(new Courses( "Elective", 5));
        	   courseList.add(new Courses( "Elective", 5));
        	   courseList.add(new Courses( "Elective", 5));
        	   courseList.add(new Courses( "Philosophy", 5));
           }
           else if(semester == 7) {
        	   courseList.add(new Courses( "IT Project Management ", 5));
        	   courseList.add(new Courses( "Elective", 5));
        	   courseList.add(new Courses( "Elective", 5));
        	   courseList.add(new Courses( "Elective", 5));
        	   courseList.add(new Courses( "Elective", 5));
        	   courseList.add(new Courses( "Elective", 5));	   
           }
           else if (semester == 8) {
        	   courseList.add(new Courses( "Research Tools and Methods", 4));
        	   courseList.add(new Courses( "Pre-diploma Internship", 5));
        	   courseList.add(new Courses( "Final attestation", 8));
        	   courseList.add(new Courses( "Elective", 5));
           }
        }
        else if (faculty == Faculty.SEOGI) {
        	 if(semester==1) {
             	courseList.add(new Courses( "Kazakh/Russian Language", 5));
                 courseList.add(new Courses( "English language", 10));
                 courseList.add(new Courses("Modern history of Kazakhstan", 5));
                 courseList.add(new Courses("Physical Education I", 4));
                 courseList.add(new Courses("Introducation to petroleum engineering", 5));
                }
                else if(semester == 2) {
             	   courseList.add(new Courses( "Kazakh/Russian Language", 5));
             	   courseList.add(new Courses( "Physics I", 5));
             	   courseList.add(new Courses( "Physical education II", 4));
             	   courseList.add(new Courses( "Merging Personal and Global Evolution", 8));
             	   courseList.add(new Courses( "Calculus I", 5));
                }
                else if(semester == 3) {
             	   courseList.add(new Courses( "Petroleum Chemistry", 5));
             	   courseList.add(new Courses( "Calculus II ", 6));
             	   courseList.add(new Courses( "Teoretical and Applied Mechanics", 5));
             	   courseList.add(new Courses( "Physics II ", 5));
             	   courseList.add(new Courses( "Information and Communication Technologies ", 4));
             	   courseList.add(new Courses( "Descriptive geometry and engineering graphics", 4));
             }
                else if (semester == 4) {
             	   courseList.add(new Courses( "Strength of materials", 5));
             	   courseList.add(new Courses( "Differential equations", 5));
             	   courseList.add(new Courses( "Physical Geology", 5));
             	   courseList.add(new Courses( "Philosophy", 5));
             	   courseList.add(new Courses( "Drilling oil ang gas wells ", 5));
             	   courseList.add(new Courses( "Introductory Internship", 4));
                }
                else if(semester == 5) {
             	   courseList.add(new Courses( "Production Technology(with practice) ", 5));
             	   courseList.add(new Courses( "Numerical methods. Matlab", 5));
             	   courseList.add(new Courses( "Fluid Mechanics", 5));
             	   courseList.add(new Courses( "Reservoir Engineering", 5));
             	   courseList.add(new Courses( "Petroleum Geology", 5));
             	   courseList.add(new Courses( "Specialization discipline ", 5));
                }
                else if(semester == 6) {
             	   courseList.add(new Courses( "Pipeline Engineering(with practice)", 5));
             	   courseList.add(new Courses( "Well logging", 5));
             	   courseList.add(new Courses( "Thermodynamics and heat engineering ", 5));
             	   courseList.add(new Courses( "Specialization discipline", 5));
             	   courseList.add(new Courses( "Elective", 5));
             	   courseList.add(new Courses( "Specialization discipline", 5));
                }
                else if(semester == 7) {
             	   courseList.add(new Courses( "Industrial safety", 5));
             	   courseList.add(new Courses( "Fundamentals of financial analysis", 5));
             	   courseList.add(new Courses( "Gathering and Preparation Well Production", 5));
             	   courseList.add(new Courses( "Workover", 5));
             	   courseList.add(new Courses( "Specialization discipline", 5));
             	   courseList.add(new Courses( "Elective", 5));	   
                }
                else if (semester == 8) {
             	   courseList.add(new Courses( "Industrial  Internship", 8));
             	   courseList.add(new Courses( "Graduation Project Internship", 5));
             	   courseList.add(new Courses( "Preparation and Defense of the graduation work", 12));
                }
    }
        if(courseList.isEmpty()) {
        if(language == Language.ENGLISH ) {
        	System.out.println("No available disciplines to register! ");
        }
        else if(language == Language.KAZAKH ) {
        	System.out.println("Registras`iyag`a mumkin bolatyn sabaq joq!");
        	
        }
        else {
        	System.out.println("Нет доступных дисциплин для регистрации !");
        }
        }
        else {
        	for (Courses element : courseList) {
                System.out.println(element);
        }
        }
//courseList.clear();
        	
 }

  /*@Override
   public boolean disciplineRegistration(Courses discipline) {
        if ( courseList.contains(discipline)) {
            System.out.println("Congratulations! You have successfully registered for discipline " + discipline + "!");
            registeredDisciplines.add(discipline); 
            return true;
        } else {
            System.out.println("Registration for discipline " + discipline + " is not allowed or not in the courses list!");
            return false;
        }
    }*/

    
    
    public boolean addDiscipline(Courses discipline) {
    	int totalECTS = 0;
        int disciplineECTS = Courses.getDisciplineCredits(discipline);

            if (totalECTS + disciplineECTS > 30) {
                System.out.println("Adding discipline " + discipline + " to your schedule has failed. Exceeds maximum credits.");
                return false;
            }

            switch (disciplineType) {
                case MAJOR:
                    totalECTS += disciplineECTS;
                    registeredDisciplines.add(discipline);
                    System.out.println("Discipline " + discipline + " added successfully. Congratulations!");
                    return true;
                case MINOR:
                    if (hasMinorDisciplineInSchedule(discipline)) {
                        System.out.println("Adding discipline " + discipline + " to your schedule has failed. You can have only one minor discipline in your schedule.");
                        return false;
                    } else {
                        totalECTS += disciplineECTS;
                        registeredDisciplines.add(discipline);
                        System.out.println("Discipline " + discipline + " added successfully. Congratulations!");
                        return true;
                    }
                case FREE:
                    totalECTS += disciplineECTS;
                    registeredDisciplines.add(discipline);
                    System.out.println("Discipline " + discipline + " added successfully. Congratulations!");
                    return true;
                default:
                    System.out.println("Adding discipline " + discipline + " to your schedule has failed. Unsupported discipline type, please check the instructions again!");
                    return false;
            }
        }
  
    public boolean dropDiscipline(Courses discipline) {
        if (disciplineType != DisciplineType.MAJOR) {
            System.out.println("Discipline " + discipline + " dropped successfully.");
            return true;
        } else {
            System.out.println("Dropping major discipline " + discipline + " is not allowed.");
            return false;
        }
    }

    private static boolean checkMajorDisciplineCompatibility(Courses discipline) {
        return disciplineType == DisciplineType.MAJOR && Course.checkMajorDisciplineCompatibility(discipline);
    }

    private boolean hasMinorDisciplineInSchedule(Courses discipline) {
        return disciplineType == DisciplineType.MINOR; 
    }
}
