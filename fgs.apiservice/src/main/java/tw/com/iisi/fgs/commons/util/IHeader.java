package tw.com.iisi.fgs.commons.util;

public interface IHeader extends IMessage {

    void setStatus(String status);

    void setErrorCode(String errorCode);

    void setErrorMessage(String errorMessage);
}
