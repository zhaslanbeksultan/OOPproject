package users;

import communication.ResearchProject;
import userCapabilities.Researcher;

/**
* @generated
*/
public class StudentResearcher extends Student implements Researcher {
    
    /**
    * @generated
    */
    private int hindex;
    
    
    /**
    * @generated
    */
    private ResarchDecorator resarchDecorator;
    
    

    /**
    * @generated
    */
    public int getHindex() {
        return this.hindex;
    }
    
    /**
    * @generated
    */
    public void setHindex(Integer hindex) {
        this.hindex = hindex;
    }
    
    
    
    /**
    * @generated
    */
    public ResarchDecorator getResarchDecorator() {
        return this.resarchDecorator;
    }
    
    /**
    * @generated
    */
    public void setResarchDecorator(ResarchDecorator resarchDecorator) {
        this.resarchDecorator = resarchDecorator;
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
