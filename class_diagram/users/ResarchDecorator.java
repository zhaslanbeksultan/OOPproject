package users;

import communication.ResearchProject;
import userCapabilities.Researcher;

/**
* @generated
*/
public class ResarchDecorator implements Researcher {
    
    /**
    * @generated
    */
    private int hindex;
    
    /**
    * @generated
    */
    private Researcher researcher;
    
    
    /**
    * @generated
    */
    private Professor professor;
    
    /**
    * @generated
    */
    private StudentResearcher studentResearcher;
    
    /**
    * @generated
    */
    private TeacherResearcher teacherResearcher;
    
    /**
    * @generated
    */
    private EmployeeResearcher employeeResearcher;
    
    

    /**
    * @generated
    */
    public int getHindex() {
        return this.hindex;
    }
    
    /**
    * @generated
    */
    public int setHindex(Integer hindex) {
        this.hindex = hindex;
    }
    
    
    /**
    * @generated
    */
    public Researcher getResearcher() {
        return this.researcher;
    }
    
    /**
    * @generated
    */
    public Researcher setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }
    
    
    
    /**
    * @generated
    */
    public StudentResearcher getStudentResearcher() {
        return this.studentResearcher;
    }
    
    /**
    * @generated
    */
    public StudentResearcher setStudentResearcher(StudentResearcher studentResearcher) {
        this.studentResearcher = studentResearcher;
    }
    
    
    /**
    * @generated
    */
    public Professor getProfessor() {
        return this.professor;
    }
    
    /**
    * @generated
    */
    public Professor setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    
    /**
    * @generated
    */
    public TeacherResearcher getTeacherResearcher() {
        return this.teacherResearcher;
    }
    
    /**
    * @generated
    */
    public TeacherResearcher setTeacherResearcher(TeacherResearcher teacherResearcher) {
        this.teacherResearcher = teacherResearcher;
    }
    
    
    /**
    * @generated
    */
    public EmployeeResearcher getEmployeeResearcher() {
        return this.employeeResearcher;
    }
    
    /**
    * @generated
    */
    public EmployeeResearcher setEmployeeResearcher(EmployeeResearcher employeeResearcher) {
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
    
    
    
}
