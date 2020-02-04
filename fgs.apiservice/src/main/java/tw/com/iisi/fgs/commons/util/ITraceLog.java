package tw.com.iisi.fgs.commons.util;

import java.util.Date;

public interface ITraceLog extends IMessage {

    public void setStartTime(Date date);

    public void setEndTime(Date date);
}
