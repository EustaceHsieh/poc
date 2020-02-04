package tw.com.iisi.fgs.commons.util;

public class MessageResult<E> extends AbstractMessageResult implements IRequest, IResult<E> {

    private Object request;
    
    private E result;

    public Object getRequest() {
		return request;
	}

	public Object getResult() {
		return result;
	}


    @Override
    public void setResult(E result) {
        this.result = result;
    }

    @Override
    public void setRequest(Object request) {
        this.request = request;
    }

}
