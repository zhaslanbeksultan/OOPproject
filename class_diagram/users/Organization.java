package users;

import java.io.Serializable;
import java.util.Vector;

public class Organization implements Serializable{

	private static final long serialVersionUID = 1L;
	private String organizationName;
    private Vector<String> members;
    private String orgaizationInfo;
    private String head;

    public Organization(String organizationName, String orgaizationInfo, String head) {
		this.organizationName = organizationName;
		this.orgaizationInfo = orgaizationInfo;
		this.head = head;
		this.members = new Vector<>();
	}

	public String getOrganizationName() {
        return this.organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Vector<String> getMembers() {
        return this.members;
    }

    public void setMembers(String member) {
        this.members.add(member);
    }
    public void removeMembers(String member) {
        this.members.remove(member);
    }

    public String getHead() {
        return this.head;
    }

    public void setHead(String head) {
        this.head = head;
    }

	public String getOrgaizationInfo() {
		return orgaizationInfo;
	}

	public void setOrgaizationInfo(String orgaizationInfo) {
		this.orgaizationInfo = orgaizationInfo;
	}

	@Override
	public String toString() {
		return "Organization Name = " + organizationName + ", Orgaization Info = " + orgaizationInfo + ", Head = " + head;
	}
    
    
}
