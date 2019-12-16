package tw.com.iisi.fgs.demo.fgsdonation.bean;

import tw.com.iisi.fgs.demo.fgsdonation.entity.FgsUnit;
import tw.com.iisi.fgs.system.IFgsConstants;
import tw.com.iisi.fgs.util.StringUtils;

public class FgsUnitBean extends FgsUnit implements Comparable<FgsUnitBean> {
	private static final long serialVersionUID = 1L;
	public static final int PROP_FGS_UNIT_ID_LENGTH = 6;

	public static final boolean IS_COLLECTION_BY_ACC = true;
	public static final boolean IS_NOT_COLLECTION_BY_ACC = false;

	/** 主要的道場代碼，用來當做道場活動資料預設的道場 */
	public static final String PRIMARY_DOJO_ID = "111111";
	/** 道場ID： A00000 (宗委會) */
	public static final String FGS_UNIT_ID_A00000 = "A00000";

	/** 虛擬道場代碼的HEADER - 以此字串打頭的均為虛擬道場 */
	public static final String VIRTUAL_FGSUNIT_ID_HEADER = "V9";

	/* [CONSTRUCTOR MARKER BEGIN] */
	public FgsUnitBean() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FgsUnitBean(java.lang.Integer id) {
		super(id);
	}

	public FgsUnitBean(String fgsUnitID, String fgsUnitName) {
		super();
		setFgsUnitID(fgsUnitID);
		setFgsUnitName(fgsUnitName);
	}

	/**
	 * Constructor for required fields
	 */
	public FgsUnitBean(java.lang.Integer id, java.lang.String fgsUnitID, java.lang.String fgsUnitName, boolean exist,
			boolean active, boolean collectible, boolean trustAccount, Boolean isDonGenerated,
			Boolean isCollectionByAcc) {

		super(id, fgsUnitID, fgsUnitName, exist, active, collectible, trustAccount, isDonGenerated, isCollectionByAcc);
	}

	/* [CONSTRUCTOR MARKER END] */

	/**
	 * 是否為虛擬道場
	 * 
	 * @return boolean
	 */
	public boolean isVirtualFgsUnit() {
		return getFgsUnitID().startsWith(VIRTUAL_FGSUNIT_ID_HEADER);
	}

	/**
	 * 比較單伅資料時，以單位名稱來排序
	 */
	@Override
    public int compareTo(FgsUnitBean targetObj) {

		if (null == targetObj || null == targetObj.getFgsUnitName()) {
			return 0;
		}

		return getFgsUnitName().compareTo(targetObj.getFgsUnitName());
	}

	/**
	 * 取得檔案匯出時的備註欄
	 * 
	 * @return String 備註欄: 將\n取代為預設檔案匯出時所帶的ENTER碼
	 */
	public String getNotesForExport() {
		if (StringUtils.isBlank(this.getNotes())) {
			return "";
		}

		return this.getNotes().replaceAll("\n", IFgsConstants.DEFAULT_EXPORT_ENTER_CODE_REPLACE_CHAR)
				.replaceAll("\r", "").replaceAll("\t", " ");

	}

	/**
	 * 取得訊息內容 描述值
	 * 
	 * @return String 訊息內容 : 將\n取代為<br/>
	 */
	public String getActivityMessageDesc() {

		if (StringUtils.isBlank(this.getActivityMessage())) {
			return "";
		}

		return this.getActivityMessage().replaceAll("\n", "<br/>");

	}

	// 取得活動細目描述值
	public String getTypeLevel3Desc() {
		String desc = "";
		if (null != getTypeLevel3() && getTypeLevel3() == true) {
			desc = "是";
		} else {
			desc = "否";
		}

		return desc;
	}

	// 取得代收是否可開立收據
	public String getColGeneratedDesc() {
		String desc = "";
		if (null != getColGenerated() && getColGenerated() == true) {
			desc = "是";
		} else {
			desc = "否";
		}

		return desc;
	}

	/**
	 * @return the activeDesc
	 */
	public String getActiveDesc() {
		if (true == this.isActive()) {
			return "是";
		}

		return "否";
	}
/*
	public String getCurrencyName() {
		return CurrencyTypeUtils.getInstance().getCurrencyName(getCurrencyCode());
	}
*/
	public void setCurrencyName(String currencyName) {
	}
/*
	public String getNationalityName() {
		return CurrencyTypeUtils.getInstance().getNationalityName(getNationalityCode());
	}
*/
	public void setNationalityName(String nationalityName) {
	}
    public String getFgsUnitNameDesc() 
    {
        if (StringUtils.isEmpty(getFgsUnitID())){
            return getFgsUnitName();
        }
        else if(StringUtils.equals("111111", getFgsUnitID())){
            return getFgsUnitName();
        }
        else{ 
            return getFgsUnitID() + " " + getFgsUnitName();
        }
    }

	
    /**
     * @return the language
     */
/*    public Language getLanguage() {
        
        if (StringUtils.isBlank(getLangCode())) {
            return null;
        }
        
        return new TrustAccountUtils(getLangCode(), getTimeZoneCode()).getLanguage();
    }*/

    /**
     * @return the timeZoneMap
     */
/*    public TimeZoneMap getTimeZoneMap() {
        
        if (StringUtils.isBlank(getTimeZoneCode())) {
            return null;
        }
        
        return new TrustAccountUtils(getLangCode(), getTimeZoneCode()).getTimeZoneMap();
    }
  */  
}