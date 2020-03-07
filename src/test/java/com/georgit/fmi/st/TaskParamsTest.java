/**
 * 
 */
package com.georgit.fmi.st;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

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
public class TaskParamsTest {
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] { //
			{null, 	 Task.WIP_STATUS, 		"Start", Task.NOT_ASSIGNED}, //
			{"", 	 Task.WIP_STATUS, 		"Start", Task.NOT_ASSIGNED}, //
			{"User", Task.WIP_STATUS, 		null, 	 Task.INVALID_COMMENT}, //
			{"User", Task.WIP_STATUS, 		"", 	 Task.INVALID_COMMENT}, //
			{"User", null, 					"Start", Task.INVALID_STATUS}, //
			{"User", "", 					"Start", Task.INVALID_STATUS}, //
			{"User", Task.NEW_STATUS, 		"Start", Task.NEW_STATUS}, //
			{"User", Task.WIP_STATUS, 		"Start", Task.WIP_STATUS}, //
			{"User", Task.REJECTED_STATUS,  "Start", Task.REJECTED_STATUS}, //
			{"User", Task.COMPLETED_STATUS, "Start", Task.COMPLETED_STATUS}}); //
	}
	
	@Parameter(0)
	public String assignee;
	@Parameter(1)
	public String status;
	@Parameter(2)
	public String comment;
	@Parameter(3)
	public String expectedResults;
	
	@Test
	public void testUpdateStatus() {
		final Task task = new Task();
		task.setTitle("Test");
		task.setAssignee(assignee);
		assertEquals(expectedResults, task.updateStatus(status, comment));
	}

}
