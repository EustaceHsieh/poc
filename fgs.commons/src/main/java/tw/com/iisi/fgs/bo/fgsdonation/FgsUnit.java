package tw.com.iisi.fgs.bo.fgsdonation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * This is an object that contains data related to the FgsUnit table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class table="FgsUnit"
 */

@Entity
@Table(name = "FgsUnit")
public class FgsUnit implements Serializable {

	private static final long serialVersionUID = 5721049718744407078L;
	public static String REF = "FgsUnit";
    public static String PROP_TRUST_ACCOUNT = "TrustAccount";
    public static String PROP_FGS_UNIT_I_D = "FgsUnitID";
    public static String PROP_ACTIVE = "Active";
    public static String PROP_AREA_I_D = "AreaID";
    public static String PROP_COLLECTIBLE = "Collectible";
    public static String PROP_NOTES = "Notes";
    public static String PROP_FGS_UNIT_NAME = "FgsUnitName";
    public static String PROP_EXIST = "Exist";
    public static String PROP_ALIAS_UNIT_I_D = "AliasUnitID";
    public static String PROP_ACTIVITY_MESSAGE = "ActivityMessage";
    public static String PROP_ID = "Id";
    public static String PROP_TRUST_ACCOUNT_KEY = "TrustAccountKey";
    public static String PROP_ROLE_TRUST_ACCOUNT_KEYS = "RoleTrustAccountKeys";

    public static String PROP_DON_GENERATED = "DonGenerated";
    public static String PROP_COLLECTION_BY_ACC = "CollectionByAcc";
    public static String PROP_TYPE_LEVEL3 = "TypeLevel3";
    public static String PROP_COLGENERATED = "ColGenerated";
    public static String PROP_CURRENCY_CODE = "CurrencyCode";
    public static String PROP_NATIONALITY_CODE = "NationalityCode";
    public static String PROP_AUTO_BALANCE_CONFIRM = "autoBalanceConfirm";

    public static String PROP_LANG_CODE = "LangCode";
    public static String PROP_TIME_ZONE_CODE = "TimeZoneCode";
    public static String PROP_ACCRCPGENERATED = "AccRcpGenerated";

    public static String PROP_SENDER_NAME = "SenderName";
    public static String PROP_SENDER_ADDRESS = "SenderAddress";
    public static String PROP_TRUST_ACCOUNT_URL = "TrustAccountURL";
    public static String PROP_TEL_NO_OFFICE = "TelNoOffice";
    public static String PROP_FAX_NO = "FaxNo";
    public static String PROP_EMAIL = "Email";
    public static String PROP_SIGN_GIF = "SignGif";
    
    // constructors
    public FgsUnit() {
    }

    /**
     * Constructor for primary key
     */
    public FgsUnit(java.lang.Integer id) {
        this.setFgsUnitKey(id);
    }

    /**
     * Constructor for required fields
     */
    public FgsUnit(java.lang.Integer id, java.lang.String fgsUnitID, java.lang.String fgsUnitName, boolean exist,
            boolean active, boolean collectible, boolean trustAccount, Boolean isDonGenerated,
            Boolean isCollectionByAcc) {

        this.setFgsUnitKey(id);
        this.setFgsUnitID(fgsUnitID);
        this.setFgsUnitName(fgsUnitName);
        this.setExist(exist);
        this.setActive(active);
        this.setCollectible(collectible);
        this.setTrustAccount(trustAccount);
        this.setDonGenerated(isDonGenerated);
        this.setCollectionByAcc(isCollectionByAcc);
    }

    protected void initialize() {
    }

    @Transient
    private int hashCode = Integer.MIN_VALUE;

    @Id
    @Column(name = "FgsUnitKey")
    private java.lang.Integer fgsUnitKey;

    @Column(name = "FgsUnitID")
    private java.lang.String fgsUnitID;

    @Column(name = "FgsUnitName")
    private java.lang.String fgsUnitName;

    @Column(name = "ActivityMessage")
    private java.lang.String activityMessage;

    @Column(name = "AreaID")
    private java.lang.String areaID;

    @Column(name = "isExist")
    private boolean exist;

    @Column(name = "isActive")
    private boolean active;

    @Column(name = "isCollectible")
    private boolean collectible;

    @Column(name = "hasTrustAccount")
    private boolean trustAccount;
    
    @Column(name = "TrustAccountKey")
    private Integer trustAccountKey;

    @Column(name = "Notes")
    private java.lang.String notes;

    /**對應信託帳戶單位編號*/
    @Column(name = "AliasUnitID")
    private java.lang.String aliasUnitID;
    
    /** 收據由道場產生 */
    @Column(name = "isDonGenerated")
    private java.lang.Boolean donGenerated;
    
    /** 是否由本山代勸募轉入 */
    @Column(name = "isCollectionByAcc")
    private java.lang.Boolean collectionByAcc;

    /** 是否使用活動細目/代收項目細目 */
    @Column(name = "isTypeLevel3")
    private java.lang.Boolean typeLevel3;
    
    /** 代收可開立收據 */
    @Column(name = "isColGenerated")
    private java.lang.Boolean colGenerated;
    
    /** 單位預設幣別 (沒有TrustAccount時使用) */
    @Column(name = "CurrencyCode")
    private String currencyCode;
    
    /** 單位預設國家別 (沒有TrustAccount時使用) */
    @Column(name = "NationalityCode")
    private String nationalityCode;
    
    /** 自動結帳覆核 */
    @Column(name = "isAutoBalanceConfirm")
    private java.lang.Boolean autoBalanceConfirm;

    // 2017/11/21 新增 by Vic
    /** 語言，為了顯示功德項目及活動名稱，以及感謝函 */
    @Column(name = "LangCode")
    private String langCode;
    
    /** 時區代碼 */
    @Column(name = "TimeZoneCode")
    private String timeZoneCode;

    // 2017/12/07 新增 by wengin
    /** 寄件人 */
    @Column(name = "SenderName")
    private String senderName;

    /** 寄件人地址(海外收據使用) */
    @Column(name = "SenderAddress")
    private String senderAddress;
    
    /** URL(海外收據使用) */
    @Column(name = "TrustAccountURL")
    private String trustAccountURL;
    
    /** 辦公室電話(海外收據使用) */
    @Column(name = "TelNoOffice")
    private String telNoOffice;
    
    /** 傳真電話(海外收據使用) */
    @Column(name = "FaxNo")
    private String faxNo;
    
    /** 電子郵件(海外收據使用) */
    @Column(name = "Email")
    private String email;
    
    /** 簽名圖檔檔名(海外收據使用) */
    @Column(name = "SignGif")
    private String signGif;

    /** 開放獨立寺廟之道場可以列印本山收據，預設 false */
    @Column(name = "isAccRcpGenerated")
    private Boolean accRcpGenerated;
    
    //2019/09/26 新增 by renbin
    /** 是否受理勸募單位轉款 預設 false*/
    @Column(name = "isColMerged")
    private Boolean colMerged;
    

    /**
     * Return the unique identifier of this class
     * 
     * @hibernate.id generator-class="native" column="FgsUnitKey"
     */
    public java.lang.Integer getFgsUnitKey() {
        return fgsUnitKey;
    }

    /**
     * Set the unique identifier of this class
     * 
     * @param id
     *            the new ID
     */
    public void setFgsUnitKey(java.lang.Integer fgsUnitKey) {
        this.fgsUnitKey = fgsUnitKey;
        this.hashCode = Integer.MIN_VALUE;
    }

    /**
     * Return the value associated with the column: FgsUnitID
     */
    public java.lang.String getFgsUnitID() {
        return fgsUnitID;
    }

    /**
     * Set the value related to the column: FgsUnitID
     * 
     * @param fgsUnitID
     *            the FgsUnitID value
     */
    public void setFgsUnitID(java.lang.String fgsUnitID) {
        this.fgsUnitID = fgsUnitID;
    }

    /**
     * Return the value associated with the column: FgsUnitName
     */
    public java.lang.String getFgsUnitName() {
        return fgsUnitName;
    }

    /**
     * Set the value related to the column: FgsUnitName
     * 
     * @param fgsUnitName
     *            the FgsUnitName value
     */
    public void setFgsUnitName(java.lang.String fgsUnitName) {
        this.fgsUnitName = fgsUnitName;
    }

    /**
     * Return the value associated with the column: ActivityMessage
     */
    public java.lang.String getActivityMessage() {
        return activityMessage;
    }

    /**
     * Set the value related to the column: ActivityMessage
     * 
     * @param activityMessage
     *            the ActivityMessage value
     */
    public void setActivityMessage(java.lang.String activityMessage) {
        this.activityMessage = activityMessage;
    }

    /**
     * Return the value associated with the column: AreaID
     */
    public java.lang.String getAreaID() {
        return areaID;
    }

    /**
     * Set the value related to the column: AreaID
     * 
     * @param areaID
     *            the AreaID value
     */
    public void setAreaID(java.lang.String areaID) {
        this.areaID = areaID;
    }

    /**
     * Return the value associated with the column: isExist
     */
    public boolean isExist() {
        return exist;
    }

    /**
     * Set the value related to the column: isExist
     * 
     * @param exist
     *            the isExist value
     */
    public void setExist(boolean exist) {
        this.exist = exist;
    }

    /**
     * Return the value associated with the column: isActive
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Set the value related to the column: isActive
     * 
     * @param active
     *            the isActive value
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Return the value associated with the column: isCollectible
     */
    public boolean isCollectible() {
        return collectible;
    }

    /**
     * Set the value related to the column: isCollectible
     * 
     * @param collectible
     *            the isCollectible value
     */
    public void setCollectible(boolean collectible) {
        this.collectible = collectible;
    }

    /**
     * Return the value associated with the column: hasTrustAccount
     */
    public boolean isTrustAccount() {
        return trustAccount;
    }

    /**
     * Set the value related to the column: hasTrustAccount
     * 
     * @param trustAccount
     *            the hasTrustAccount value
     */
    public void setTrustAccount(boolean trustAccount) {
        this.trustAccount = trustAccount;
    }

    /**
     * Return the value associated with the column: Notes
     */
    public java.lang.String getNotes() {
        return notes;
    }

    /**
     * Set the value related to the column: Notes
     * 
     * @param notes
     *            the Notes value
     */
    public void setNotes(java.lang.String notes) {
        this.notes = notes;
    }


    /**對應信託帳戶單位編號
     * Return the value associated with the column: AliasUnitID
     */
    public java.lang.String getAliasUnitID() {
        return aliasUnitID;
    }


    /**對應信託帳戶單位編號
     * Set the value related to the column: AliasUnitID
     * 
     * @param aliasUnitID
     *            the AliasUnitID value
     */
    public void setAliasUnitID(java.lang.String aliasUnitID) {
        this.aliasUnitID = aliasUnitID;
    }

    @Override
    @Transient
    public int hashCode() {
        if (Integer.MIN_VALUE == this.hashCode) {
            if (null == this.getFgsUnitKey())
                return super.hashCode();
            else {
                String hashStr = this.getClass().getName() + ":" + this.getFgsUnitKey().hashCode();
                this.hashCode = hashStr.hashCode();
            }
        }
        return this.hashCode;
    }

    @Override
    @Transient
    public String toString() {
        return super.toString();
    }

    /**
     * 收據由道場產生
     * <p>
     * True:該道場之收據都由道場自行建立。預設為空白。也是False。
     * 
     * @return the donGenerated
     */
    public java.lang.Boolean getDonGenerated() {
        return donGenerated;
    }

    /**
     * 收據由道場產生
     * <p>
     * True:該道場之收據都由道場自行建立。預設為空白。也是False。
     * 
     * @param donGenerated
     */
    public void setDonGenerated(java.lang.Boolean donGenerated) {
        this.donGenerated = donGenerated;
    }

    /**
     * 是否由本山代勸募轉入
     * <p>
     * True:該道場之之代收可由本山直接轉入。預設為空白。也是False。
     * 
     * @return the collectionByAcc
     */
    public java.lang.Boolean getCollectionByAcc() {
        return collectionByAcc;
    }

    /**
     * 是否由本山代勸募轉入
     * <p>
     * True:該道場之之代收可由本山直接轉入。預設為空白。也是False。
     * 
     * @param collectionByAcc
     */
    public void setCollectionByAcc(java.lang.Boolean collectionByAcc) {
        this.collectionByAcc = collectionByAcc;
    }

    /**
     * 是否使用活動細目/代收項目細目
     * 
     * @return the typeLevel3
     */
    public java.lang.Boolean getTypeLevel3() {
        return typeLevel3;
    }

    /**
     * 是否使用活動細目/代收項目細目
     * 
     * @param typeLevel3
     *            the typeLevel3 to set
     */
    public void setTypeLevel3(java.lang.Boolean typeLevel3) {
        this.typeLevel3 = typeLevel3;
    }

    /**
     * 代收可開立收據
     * 
     * @return the colGenerated
     */
    public java.lang.Boolean getColGenerated() {
        return colGenerated;
    }

    /**
     * 代收可開立收據
     * 
     * @param colGenerated
     *            the colGenerated to set
     */
    public void setColGenerated(java.lang.Boolean colGenerated) {
        this.colGenerated = colGenerated;
    }

    /**
     * 單位預設幣別 (沒有TrustAccount時使用)
     * 
     * @return the currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * 單位預設幣別 (沒有TrustAccount時使用)
     * 
     * @param currencyCode
     *            the currencyCode to set
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * 單位預設國家別 (沒有TrustAccount時使用)
     * 
     * @return the nationalityCode
     */
    public String getNationalityCode() {
        return nationalityCode;
    }

    /**
     * 單位預設國家別 (沒有TrustAccount時使用)
     * 
     * @param nationalityCode
     *            the nationalityCode to set
     */
    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    /**
     * 是否自動結帳覆核
     * 
     * @return the autoBalanceConfirm
     */
    public java.lang.Boolean getAutoBalanceConfirm() {
        return autoBalanceConfirm;
    }

    /**
     * 是否自動結帳覆核
     * 
     * @param typeLevel3
     *            the typeLevel3 to set
     */
    public void setAutoBalanceConfirm(java.lang.Boolean autoBalanceConfirm) {
        this.autoBalanceConfirm = autoBalanceConfirm;
    }

    /**
     * @return the langCode
     */
    public String getLangCode() {
        return langCode;
    }

    /**
     * @param langCode
     *            the langCode to set
     */
    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    /**
     * @return the timeZoneCode
     */
    public String getTimeZoneCode() {
        return timeZoneCode;
    }

    /**
     * @param timeZoneCode
     *            the timeZoneCode to set
     */
    public void setTimeZoneCode(String timeZoneCode) {
        this.timeZoneCode = timeZoneCode;
    }

    /**
     * @return the senderName
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * @param senderName
     *            the senderName to set
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }


    /**寄件人地址(海外收據使用)
     * @return the senderAddress
     */
    public String getSenderAddress() {
        return senderAddress;
    }


    /**寄件人地址(海外收據使用)
     * @param senderAddress
     *            the senderAddress to set
     */
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }


    /** URL(海外收據使用)
     * @return the trustAccountURL
     */
    public String getTrustAccountURL() {
        return trustAccountURL;
    }


    /** URL(海外收據使用)
     * @param trustAccountURL
     *            the trustAccountURL to set
     */
    public void setTrustAccountURL(String trustAccountURL) {
        this.trustAccountURL = trustAccountURL;
    }


    /**辦公室電話 (海外收據使用)
     * @return the telNoOffice
     */
    public String getTelNoOffice() {
        return telNoOffice;
    }


    /**辦公室電話 (海外收據使用)
     * @param telNoOffice
     *            the telNoOffice to set
     */
    public void setTelNoOffice(String telNoOffice) {
        this.telNoOffice = telNoOffice;
    }


    /**傳真電話 (海外收據使用)
     * @return the faxNo
     */
    public String getFaxNo() {
        return faxNo;
    }


    /**傳真電話 (海外收據使用)
     * @param faxNo
     *            the faxNo to set
     */
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }


    /**電子郵件(海外收據使用)
     * @return the email
     */
    public String getEmail() {
        return email;
    }


    /**電子郵件(海外收據使用)
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**簽名圖檔檔名(海外收據使用)
     * @return
     */
    public String getSignGif() {
        return signGif;
    }


    /**簽名圖檔檔名(海外收據使用)
     * @param signGif
     */
    public void setSignGif(String signGif) {
        this.signGif = signGif;
    }


    /**是否自行開立弘法類捐款收據<br>
     * 開放獨立寺廟之道場可以列印本山收據，預設 false
     * @return the accRcpGenerated
     */
    public Boolean getAccRcpGenerated() {
        return accRcpGenerated;
    }


    /**是否自行開立弘法類捐款收據<br>
     * 開放獨立寺廟之道場可以列印本山收據，預設 false
     * @param accRcpGenerated
     *            the accRcpGenerated to set
     */
    public void setAccRcpGenerated(Boolean accRcpGenerated) {
        this.accRcpGenerated = accRcpGenerated;
    }

    /**
     * @return the colMerged
     */
	public Boolean getColMerged() {
		return colMerged;
	}
	 /**
     * @param colMerged
     *            the colMerged to set
     */
	public void setColMerged(Boolean colMerged) {
		this.colMerged = colMerged;
	}

}