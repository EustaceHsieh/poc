package tw.com.iisi.fgs.demo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ImportDonation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7310560745986803168L;
	//====正式收據類別====
    /** 正式收據類別: 不索取*/
    public static final short RECEIPTTYPE_NO_RECEIPT = 0;
    /** 正式收據類別: 依年度索取*/
    public static final short RECEIPTTYPE_BY_YEAR = 1;
    /** 正式收據類別: 依月份索取*/
    public static final short RECEIPTTYPE_BY_MONTH = 2;
    /** 正式收據類別: 單筆收據 */
    public static final short RECEIPTTYPE_BY_DATE = 3;

    /** 匯入類別 Donation */
    public static final short IMPORT_TYPE_DONATION = 1;
    /** 匯入類別 Collection */
    public static final short IMPORT_TYPE_COLLECTION = 2;

    //====繳款方式常數====
    /** 繳款方式: 現金*/
    public static final short PAYMENT_TYPE_CASH = 0;

    /** 繳款方式: 匯款*/
    public static final short PAYMENT_TYPE_REMIT = 1;

    /** 繳款方式: 劃撥*/
    public static final short PAYMENT_TYPE_TRANSFER = 2;

    /** 繳款方式: 支票*/
    public static final short PAYMENT_TYPE_CHECK = 3;
    
    /** 繳款方式: 信用卡*/
    public static final short PAYMENT_TYPE_CREDIT_CARD = 4;
    
    /** 繳款方式: 行動支付*/
    public static final short PAYMENT_TYPE_MOBILE_PAY = 6;
    

    private int hashCode = Integer.MIN_VALUE;

    private java.lang.Integer id;

    /** 建立日期 */
    private Date createDate;
    
    /** 異動時間 */
    private Date updateTime;
    
    /** 狀態 */
    private Short stateID;
    
    /** 繳款單號 */
    private String fullCollectCode;
    
    /** 匯入捐款序號 */
    private Integer seqNo;
    
    /** 捐款流水號 */
    private String donationSN;
    
    /** 正式收據類別 */
    private Short receiptType;
    
    /** 幣別 */
    private String currencyCode;
    
    /** 捐款總金額 */
    private BigDecimal amount;
    
    /** 入帳幣別 */
    private String intoCurencyCode;
    
    /** 入帳金額 */
    private BigDecimal intoAmount;
    
    /** 信徒UID(捐款人) */
    private String personUID;
    
    /** 捐款人編號 */
    private String donorSN;
    
    /** 樂助功德(捐款分類) */
    private Short donationMainType;
    
    /** 道場活動代號 */
    private String donationTypeID;
    
    /** 活動名稱 */
    private String donationTypeName;
    
    /** 法會代號 */
    private String dharCode;
    
    /** 捐款備註欄 */
    private String notes;
    
    /** 是否為代收捐款 */
    private Short isCollection;
    
    /** 代收項目編碼 */
    private String collectionTypeSN;
    
    /** 是否為分期核銷捐款 */
    private Short isPreDonation;
    
    /** 分期功德登記表單號 */
    private String preFullCollectCode;

    private Integer version;

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Short getStateID() {
		return stateID;
	}

	public void setStateID(Short stateID) {
		this.stateID = stateID;
	}

	public String getFullCollectCode() {
		return fullCollectCode;
	}

	public void setFullCollectCode(String fullCollectCode) {
		this.fullCollectCode = fullCollectCode;
	}

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public String getDonationSN() {
		return donationSN;
	}

	public void setDonationSN(String donationSN) {
		this.donationSN = donationSN;
	}

	public Short getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(Short receiptType) {
		this.receiptType = receiptType;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getIntoCurencyCode() {
		return intoCurencyCode;
	}

	public void setIntoCurencyCode(String intoCurencyCode) {
		this.intoCurencyCode = intoCurencyCode;
	}

	public BigDecimal getIntoAmount() {
		return intoAmount;
	}

	public void setIntoAmount(BigDecimal intoAmount) {
		this.intoAmount = intoAmount;
	}

	public String getPersonUID() {
		return personUID;
	}

	public void setPersonUID(String personUID) {
		this.personUID = personUID;
	}

	public String getDonorSN() {
		return donorSN;
	}

	public void setDonorSN(String donorSN) {
		this.donorSN = donorSN;
	}

	public Short getDonationMainType() {
		return donationMainType;
	}

	public void setDonationMainType(Short donationMainType) {
		this.donationMainType = donationMainType;
	}

	public String getDonationTypeID() {
		return donationTypeID;
	}

	public void setDonationTypeID(String donationTypeID) {
		this.donationTypeID = donationTypeID;
	}

	public String getDonationTypeName() {
		return donationTypeName;
	}

	public void setDonationTypeName(String donationTypeName) {
		this.donationTypeName = donationTypeName;
	}

	public String getDharCode() {
		return dharCode;
	}

	public void setDharCode(String dharCode) {
		this.dharCode = dharCode;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Short getIsCollection() {
		return isCollection;
	}

	public void setIsCollection(Short isCollection) {
		this.isCollection = isCollection;
	}

	public String getCollectionTypeSN() {
		return collectionTypeSN;
	}

	public void setCollectionTypeSN(String collectionTypeSN) {
		this.collectionTypeSN = collectionTypeSN;
	}

	public Short getIsPreDonation() {
		return isPreDonation;
	}

	public void setIsPreDonation(Short isPreDonation) {
		this.isPreDonation = isPreDonation;
	}

	public String getPreFullCollectCode() {
		return preFullCollectCode;
	}

	public void setPreFullCollectCode(String preFullCollectCode) {
		this.preFullCollectCode = preFullCollectCode;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
