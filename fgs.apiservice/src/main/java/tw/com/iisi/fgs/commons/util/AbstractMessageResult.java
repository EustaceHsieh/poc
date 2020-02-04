package tw.com.iisi.fgs.commons.util;

import java.util.Date;

public abstract class AbstractMessageResult implements IMessage, IHeader, ITraceLog {

    private String status;

    private String errorCode;

    private String errorMessage;

    private Date endTime;

    private Date startTime;

    public Date getStartTime() {
		return startTime;
	}

	public String getStatus() {
		return status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Date getEndTime() {
		return endTime;
	}


    @Override
    public void setStatus(String status) {
        // TODO Auto-generated method stub
        this.status = status;
    }

    @Override
    public void setErrorCode(String errorCode) {
        // TODO Auto-generated method stub
        this.errorCode = errorCode;
    }

    @Override
    public void setErrorMessage(String errorMessage) {
        // TODO Auto-generated method stub
        this.errorMessage = errorMessage;
    }

    @Override
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
