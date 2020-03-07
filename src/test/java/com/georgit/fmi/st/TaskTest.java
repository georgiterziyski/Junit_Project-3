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

	private Task task;
	private Task subTask;
	private Task parent;
	
	@Before
	public void setup() {
		task = new Task();
		task.setTitle("Test");
		subTask = new Task();
		subTask.setTitle("subTest");
		parent = new Task();
		parent.setTitle("Parent");
	}
	
	/**
	 * test {@link task#updateSubTask(String)} with subTask name. Expected
	 * existing subtask updated status.
	 */
	@Test
	public void testGetValidSubTask() {
		task.addSubTask(subTask);
		final String result = task.updateSubTask("subTest");
		assertTrue(result.equals(Task.SUBTASK_PASS));
	}
	
	/**
	 * test {@link task#updateSubTask(String)} with NULL subTask name. Expected
	 * non existing subtask.
	 */
	@Test
	public void testGetNULLSubTask() {
		final String result = task.updateSubTask(null);
		assertTrue(result.equals(Task.SUBTASK_NULL));
	}
	
	/**
	 * test {@link task#updateSubTask(String)} with empty subTask name. Expected
	 * unsuccessful subTask update.
	 */
	@Test
	public void testGetEmptyStringSubTask() {
		final String result = task.updateSubTask("");
		assertTrue(result.equals(Task.SUBTASK_FAIL));
	}
	
	/**
	 * test {@link task#updateSubTask(String)} with invalid subTask name. Expected
	 * unsuccessful subTask update.
	 */
	@Test
	public void testGetInvalidSubTask() {
		final String result = task.updateSubTask("subTest2");
		assertTrue(result.equals(Task.SUBTASK_FAIL));
	}
	
	/**
	 * test {@link task#updateStatus(String1, String2)} with WIP status and comment.
	 * Expected Unsuccessfully update status after task is completed.
	 */
	@Test
	public void testChangeStatusAfterCompleted() {
		task.setAssignee("User");
		final String result = task.updateStatus(Task.COMPLETED_STATUS, "Start");
		assertTrue(result.equals(Task.COMPLETED_STATUS));
		task.updateStatus(Task.WIP_STATUS, "Start");
		assertTrue(result.equals(Task.COMPLETED_STATUS));
	}
	
	/**
	 *test {@link task#updateStatus(String1, String2)} with NULL status and comment.
	 * Expected Invalid Status response.
	 */
	@Test
	public void testChangeStatusWithNULLStatus() {
		task.setAssignee("User");
		final String result = task.updateStatus(null, "Start");
		assertTrue(result.equals(Task.INVALID_STATUS));
	}
	
	/**
	 * test {@link task#updateStatus(String1, String2)} with Invalid status and comment.
	 * Expected Invalid status response.
	 */
	@Test
	public void testChangeStatusWithInvalidStatus() {
		task.setAssignee("User");
		final String result = task.updateStatus(Task.INVALID_STATUS, "Start");
		assertTrue(result.equals(Task.INVALID_STATUS));
	}
	
	/**
	 * test {@link task#updateStatus(String1, String2)} with WIP status and comment.
	 * Expected successful task status update to WIP.
	 */
	@Test
	public void testChangeStatusWithValidWIPStatus() {
		task.setAssignee("User");
		final String result = task.updateStatus(Task.WIP_STATUS, "Start");
		assertTrue(result.equals(Task.WIP_STATUS));
	}
	
	/**
	 * test {@link task#updateStatus(String1, String2)} with NEW status and comment.
	 * Expected successful task status update to NEW.
	 */
	@Test
	public void testChangeStatusWithValidNewStatus() {
		task.setAssignee("User");
		final String result = task.updateStatus(Task.NEW_STATUS, "Start");
		assertTrue(result.equals(Task.NEW_STATUS));
	}
	
	/**
	 * test {@link task#updateStatus(String1, String2)} with REJECTED status and comment.
	 * Expected successful task status update to REJECTED.
	 */
	@Test
	public void testChangeStatusWithValidRejectedStatus() {
		task.setAssignee("User");
		final String result = task.updateStatus(Task.REJECTED_STATUS, "Start");
		assertTrue(result.equals(Task.REJECTED_STATUS));
	}
	
	
	/**
	 * test {@link task#updateStatus(String1, String2)} with WIP status and NULL comment.
	 * Expected invalid comment response.
	 */
	@Test
	public void testChangeTaskStatusToWIPWithEmptyComment() {
		task.setAssignee("User");
		final String result = task.updateStatus(Task.WIP_STATUS, "");
		assertTrue(result.equals(Task.INVALID_COMMENT));
	}
	
	/**
	 * test {@link task#updateStatus(String1, String2)} with WIP status and NULL comment.
	 * Expected invalid comment response.
	 */
	@Test
	public void testChangeTaskStatusToWIPWithNULLComment() {
		task.setAssignee("User");
		final String result = task.updateStatus(Task.WIP_STATUS, null);
		assertTrue(result.equals(Task.INVALID_COMMENT));
	}
	
	/**
	 * test {@link task#updateStatus(String1, String2)} with WIP status and comment.
	 * Expected NOT_ASSIGNED response.
	 */
	@Test
	public void testChangeTaskStatusToWIPWithoutAssignee() {
		task.setAssignee(null);
		final String result = task.updateStatus(Task.WIP_STATUS, "Start");
		assertTrue(result.equals(Task.NOT_ASSIGNED));
	}
}
