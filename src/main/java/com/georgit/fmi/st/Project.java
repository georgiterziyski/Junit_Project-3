/**
 * 
 */
package com.georgit.fmi.st;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author GeorgiT
 *
 */
public class Project {

	static final String NULL_LEAD = "NULL Lead";
	static final String NULL_DEVS = "NULL Devs";
	static final String INVALID_LEAD = "INVALID Lead";
	static final String INVALID_DEVS = "INVALID Devs";
	static final String UPDATE_SUCCESSFUL = "Success";
	
	private String title;
	private String teamLead;
	private String developers;
	private Set<Task> subTasks = new HashSet<Task>();
	private Set<Project> subProjects = new HashSet<Project>();
	private Project parent;
	
	public Project() {
		//Empty constructor for testing.
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(String teamLead) {
		this.teamLead = teamLead;
	}

	public String getDevelopers() {
		return developers;
	}

	public void setDevelopers(String developers) {
		this.developers = developers;
	}

	public Set<Task> getSubTasks() {
		return subTasks;
	}

	public void setSubTasks(Set<Task> subTasks) {
		this.subTasks = subTasks;
	}

	public Set<Project> getSubProjects() {
		return subProjects;
	}

	public void setSubProjects(Set<Project> subProjects) {
		this.subProjects = subProjects;
	}

	public Project getParent() {
		return parent;
	}

	public void setParent(Project parent) {
		this.parent = parent;
	}
	
	/**
	 * 
	 * @param teamLead, developers
	 * @return Response depending on the validity of the input parameters.
	 */
	public String updateProject(String teamLead, List<String> developers) {
		if(null ==  teamLead) {
			return NULL_LEAD;
		} else if(null == developers) {
			return NULL_DEVS;
		} else if(teamLead == "") {
			return INVALID_LEAD;
		} else if (!isDevelopersValid(developers)) {
			return INVALID_DEVS;
		} else {
			return UPDATE_SUCCESSFUL;
		}
	}

	/**
	 * 
	 * @param developers
	 * @return TRUE if the developers are valid or FALSE if they are not.
	 */
	private boolean isDevelopersValid(List<String> developers) {
		for (String dev : developers) {
			if(dev.equals("")) {
				return false;
			}
	    }
		return true;
	}
	
}
