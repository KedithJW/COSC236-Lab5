package lab5;

public class BorrowingBookResult {
	private boolean isSuccess;
	private String borrowingMessage;
	
	public BorrowingBookResult(boolean isSuccess, String borrowingMessage) { 
		this.isSuccess = isSuccess;
		this.borrowingMessage = borrowingMessage;
	}
	
	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public boolean getIsSuccess() {
		return isSuccess;
	}
	public void setMessage(String message) {
		this.borrowingMessage = message;
	}
	public String getMessage() {
		return borrowingMessage;
	}
}
