/**
 * 
 */
package com.georgit.fmi.st;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author GeorgiT
 *
 */
public class TaskTest {

	private Project project;
	private Task task;
	
	@Before
	public void setup() {
		task = new Task();
		task.setTitle("Test");
	}
	
	/**
	 * 
	 */
	@Test
	public void testChangeStatusWithNULLStatus() {
		task.setAssignee("User");
		final String result = task.updateStatus(null, "Start");
		assertTrue(result.equals(Task.INVALID_STATUS));
	}
	
	/**
	 * 
	 */
	@Test
	public void testChangeStatusWithInvalidStatus() {
		task.setAssignee("User");
		final String result = task.updateStatus(Task.INVALID_STATUS, "Start");
		assertTrue(result.equals(Task.INVALID_STATUS));
	}
	
	/**
	 * 
	 */
	@Test
	public void testChangeStatusWithValidWIPStatus() {
		task.setAssignee("User");
		final String result = task.updateStatus(Task.WIP_STATUS, "Start");
		assertTrue(result.equals(Task.WIP_STATUS));
	}
	
	/**
	 * 
	 */
	@Test
	public void testChangeStatusWithValidNewStatus() {
		task.setAssignee("User");
		final String result = task.updateStatus(Task.NEW_STATUS, "Start");
		assertTrue(result.equals(Task.NEW_STATUS));
	}
	
	/**
	 * 
	 */
	@Test
	public void testChangeStatusWithValidRejectedStatus() {
		task.setAssignee("User");
		final String result = task.updateStatus(Task.REJECTED_STATUS, "Start");
		assertTrue(result.equals(Task.REJECTED_STATUS));
	}
	
	
	/**
	 * 
	 */
	@Test
	public void testChangeTaskStatusToWIPWithEmptyComment() {
		task.setAssignee("User");
		final String result = task.updateStatus(Task.WIP_STATUS, "");
		assertTrue(result.equals(Task.INVALID_COMMENT));
	}
	
	/**
	 * 
	 */
	@Test
	public void testChangeTaskStatusToWIPWithNULLComment() {
		task.setAssignee("User");
		final String result = task.updateStatus(Task.WIP_STATUS, null);
		assertTrue(result.equals(Task.INVALID_COMMENT));
	}
	
	/**
	 * 
	 */
	@Test
	public void testChangeTaskStatusToWIPWithoutAssignee() {
		task.setAssignee(null);
		final String result = task.updateStatus(Task.WIP_STATUS, "Start");
		assertTrue(result.equals(Task.NOT_ASSIGNED));
	}
}
