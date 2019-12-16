package tw.com.iisi.fgs.demo.fgsdonation.entity;

import tw.com.iisi.fgs.util.StringUtils;
import tw.com.iisi.fgs.demo.fgsdonation.entity.base.BaseLanguage;

public class Language extends BaseLanguage {
    private static final long serialVersionUID = 1L;
    public static final String FGUNIT_NULL_LANGDESC = "[同捐款歸戶]";
    public static final String TRUSTACCOUNT_NULL_LANGDESC = "---請選擇---";

    /* [CONSTRUCTOR MARKER BEGIN] */
    public Language() {
        super();
    }

    /* [CONSTRUCTOR MARKER END] */

    /**
     * 取得語言狀態描述值
     * 
     * @return String true:啟用/false:停用
     */
    public String getUsedDesc() {
        String str = "";
        if (getUsed()) {
            str = "啟用";
        } else {
            str = "停用";
        }
        return str;
    }

    /**
     * 取得語言代碼描述值
     * 
     * @return String 格式:語言代碼 中文顯示說明
     */
    public String getLangCodeDesc() {

        StringBuffer sbDesc = new StringBuffer();

        if (StringUtils.isNotBlank(getLangCode())) {
            sbDesc.append(StringUtils.trimToEmpty(getLangCode()) + " ");
        }
        if (StringUtils.isNotBlank(getDescription())) {
            sbDesc.append(StringUtils.trimToEmpty(getDescription()));
        }

        return sbDesc.toString();

    }

}