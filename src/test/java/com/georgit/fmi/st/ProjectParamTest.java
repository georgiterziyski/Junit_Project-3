/**
 * 
 */
package com.georgit.fmi.st;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author GeorgiT
 *
 */
@RunWith(Parameterized.class)
public class ProjectParamTest {


	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] { //
			{null, 	 Arrays.asList("dev1", "dev2"), Project.NULL_LEAD}, //
			{"", 	 Arrays.asList("dev1", "dev2"), Project.INVALID_LEAD}, //
			{"Lead", Arrays.asList("dev1", "dev2"), Project.UPDATE_SUCCESSFUL}, //
			{"Lead", Arrays.asList(""),   			Project.INVALID_DEVS}, //
			{"Lead", null, 							Project.NULL_DEVS}}); //
	}
	
	@Parameter(0)
	public String teamLead;
	@Parameter(1)
	public List<String> developers;
	@Parameter(2)
	public String expectedResults;
	
	@Test
	public void testUpdateProject() {
		final Project project = new Project();
		project.setTitle("Project");
		assertEquals(expectedResults, project.updateProject(teamLead, developers));
	}
}
