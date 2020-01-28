/**
 * 
 */
package com.georgit.fmi.st;

/**
 * @author GeorgiT
 *
 */
public class Task {

	static final String NEW_STATUS = "Нова";
	static final String WIP_STATUS = "В процес на работа";
	static final String COMPLETED_STATUS = "Завършена";
	static final String REJECTED_STATUS = "Отказана";
	static final String NOT_ASSIGNED = "Липсва отговорник";
	static final String INVALID_STATUS = "Невалиден статус";
	static final String INVALID_COMMENT = "Невалиден коментар";
	
	
	private String title;
	private String assignee;
	private String status = NEW_STATUS;

	public Task() {
		//Empty constructor for testing.
	}
	
	public String updateStatus(final String status, final String comment) {
		if(isCommentValid(comment)) {
			if(isStatusValid(status)) {
				if(hasAssignee()) {
					setStatus(status);
					return getStatus();
				} else {
					return NOT_ASSIGNED;
				}				
			} else {
				return INVALID_STATUS;
			}
		} else {
			return INVALID_COMMENT;
		}
	}
	
	/**
	 * 
	 * @param status
	 * @return TRUE if the status is valid and FALSE if not.
	 */
	private boolean isStatusValid(final String status) {
		if(NEW_STATUS.equals(status)) {
			return true;
		} else if (WIP_STATUS.equals(status)){
			return true;
		} else if (COMPLETED_STATUS.equals(status)) {
			return true;
		} else {
			return REJECTED_STATUS.equals(status);
		}
	}
	
	/**
	 * 
	 * @param comment
	 * @return TRUE if the comment is valid and FALSE if not
	 */
	private boolean isCommentValid(final String comment) {
		if(null == comment) {
			return false;
		} else {
			return !comment.isEmpty();
		}
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(final String status) {
		if(!getStatus().equals(COMPLETED_STATUS)) {
			if(status.equals(WIP_STATUS)) {
				this.status = WIP_STATUS;
			} else if(status.equals(COMPLETED_STATUS)) {
				this.status = COMPLETED_STATUS;
			} else if(status.equals(REJECTED_STATUS)) {
				this.status = REJECTED_STATUS;
			} else {
				this.status = NEW_STATUS;
			}		
		} else {
			this.status = COMPLETED_STATUS;
		}	
	}
	
	public String getAssignee() {
		return assignee;
	}


	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	
	private boolean hasAssignee() {
		return "User".equals(assignee);
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
}
