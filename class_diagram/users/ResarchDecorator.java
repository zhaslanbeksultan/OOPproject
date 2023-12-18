package users;

import communication.ResearchProject;
import userCapabilities.Researcher;

public class ResarchDecorator extends User implements Researcher {
    
    private int hindex;
    private Researcher researcher;
    private Professor professor;
    private StudentResearcher studentResearcher;
    private TeacherResearcher teacherResearcher;
    private EmployeeResearcher employeeResearcher;
    
    
    public int getHindex() {
        return this.hindex;
    }

    public void setHindex(Integer hindex) {
        this.hindex = hindex;
    }

    public Researcher getResearcher() {
        return this.researcher;
    }

    public void setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }
    
    public StudentResearcher getStudentResearcher() {
        return this.studentResearcher;
    }

    public void setStudentResearcher(StudentResearcher studentResearcher) {
        this.studentResearcher = studentResearcher;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public TeacherResearcher getTeacherResearcher() {
        return this.teacherResearcher;
    }

    public void setTeacherResearcher(TeacherResearcher teacherResearcher) {
        this.teacherResearcher = teacherResearcher;
    }

    public EmployeeResearcher getEmployeeResearcher() {
        return this.employeeResearcher;
    }

    public void setEmployeeResearcher(EmployeeResearcher employeeResearcher) {
        this.employeeResearcher = employeeResearcher;
    }

	@Override
	public void writeNewResearch(ResearchProject research) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double findGIndex(String researcherId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void conductResearch(String researchTopic) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void addRequest() {
		// TODO Auto-generated method stub
		
	}
    
    
    
}
