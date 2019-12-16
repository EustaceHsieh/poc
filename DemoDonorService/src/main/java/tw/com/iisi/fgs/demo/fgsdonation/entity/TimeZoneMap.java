package tw.com.iisi.fgs.demo.fgsdonation.entity;

import tw.com.iisi.fgs.util.StringUtils;
import tw.com.iisi.fgs.demo.fgsdonation.entity.base.BaseTimeZoneMap;

public class TimeZoneMap extends BaseTimeZoneMap {

    /** 預設系統時區ID： Asia/Taipei */
    public static final String DEFAULT_TIME_ZONE_ID = "Asia/Taipei";

    private static final long serialVersionUID = 1L;

    /**
     * 時區顯示式(時)與(分)的分隔符號
     */
    public static final String TIMEZONE_EXP_SPLIT_CHAR = ":";
    public static final String TIMEZONE_EXP_SPLIT_SIGN_PLUS = "+";
    public static final String TIMEZONE_EXP_SPLIT_SIGN_MINUS = "-";
    public static final String[] TIMEZONE_EXP_SIGN = { "+", "-" };
    public static final String[] TIMEZONE_EXP_HOURS = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
            "10", "11", "12" };
    public static final String[] TIMEZONE_EXP_MINUTES = { "00", "30" };
    public static final String FGUNIT_NULL_TIMEZONEDESC = "[同捐款歸戶]";
    public static final String TRUSTACCOUNT_NULL_TIMEZONEDESC = "---請選擇---";
    public static final String DEFAULT_TIMEZONE_EXP = "+08:00";
    /* [CONSTRUCTOR SignER BEGIN] */
    public TimeZoneMap() {
        super();
    }

    /* [CONSTRUCTOR SignER END] */

    /**
     * 取得時區顯示描述值
     * 
     * @return String 格式:顯示(標準時間說明-代表國家或城市 )
     */
    public String getTimeZoneCodeDesc() {

        StringBuffer sbDesc = new StringBuffer();

        if (StringUtils.isNotBlank(getTimeZoneExp())) {

            if ((!getTimeZoneExp().equals(TRUSTACCOUNT_NULL_TIMEZONEDESC))
                    && (!getTimeZoneExp().equals(FGUNIT_NULL_TIMEZONEDESC))) {

                sbDesc.append("UTC");
            }

            sbDesc.append(StringUtils.trimToEmpty(getTimeZoneExp()) + " ");
        }
        if (StringUtils.isNotBlank(getTimeZoneDescription())) {
            sbDesc.append("(" + StringUtils.trimToEmpty(getTimeZoneDescription()));
        }
        if (StringUtils.isNotBlank(getTimeZoneCity())) {
            sbDesc.append("-" + StringUtils.trimToEmpty(getTimeZoneCity()));
        }

        if (StringUtils.isNotBlank(getTimeZoneDescription())) {
            sbDesc.append(")");
        }

        return sbDesc.toString();

    }

    /**
     * 取得時區顯示式Sign +,- 格式:UTC+08:00取+
     * 
     * @return String
     */
    public String getTimeZoneExpSign() {

        if (StringUtils.isNotBlank(super.getTimeZoneExp())) {

            String tmp = super.getTimeZoneExp();

            if (tmp.indexOf(TIMEZONE_EXP_SPLIT_SIGN_PLUS) != -1) {

                return TIMEZONE_EXP_SPLIT_SIGN_PLUS;

            } else {

                return TIMEZONE_EXP_SPLIT_SIGN_MINUS;

            }
        }
        return null;

    }

    /**
     * 取得時區顯示式(時) 格式:UTC+08:00取08
     * 
     * @return String
     */

    public String getTimeZoneExpHours() {

        if (StringUtils.isNotBlank(super.getTimeZoneExp())) {

            String[] tmp1 = (super.getTimeZoneExp()).split(TIMEZONE_EXP_SPLIT_CHAR);

            if (tmp1[0].indexOf(TIMEZONE_EXP_SPLIT_SIGN_PLUS) != -1) {

                String[] tmp2 = tmp1[0].split("\\" + TIMEZONE_EXP_SPLIT_SIGN_PLUS);

                return tmp2[1];
            } else {
                String[] tmp2 = tmp1[0].split(TIMEZONE_EXP_SPLIT_SIGN_MINUS);
                return tmp2[1];
            }
        }
        return "";
    }

    /**
     * 取得時區顯示式(分) 格式:UTC+08:00取00
     * 
     * @return String
     */
    public String getTimeZoneExpMinutes() {

        if (StringUtils.isNotBlank(super.getTimeZoneExp())) {

            String[] tmp1 = super.getTimeZoneExp().split(TIMEZONE_EXP_SPLIT_CHAR);

            return tmp1[1];

        }
        return "";

    }

}