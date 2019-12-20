package tw.com.iisi.fgs.demo.fgsdonation.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Donor")
public class Donor implements Serializable {

	private static final long serialVersionUID = 3882328573558818526L;

    /**
     * 匿名捐款人員代號
     */
    public static final String DEFAULT_ANONYMOUS_DONOR_SN = "PD99999999999999999";

    public static final String DEFAULT_ANONYMOUS_DONOR_NAME = "三寶弟子";

    /**
     * 電話與分機號碼之間的分隔符號
     */
    public static final String TEL_EXT_SPLIT_CHAR = "#";

    /* =========================常數定義============================== */

    /* DonorSSIDType */
    /** 身分證字號或統編種類: 身份證字號 */
    public static final short SSID_TYPE_SSID = 0;

    /** 身分證字號或統編種類: 統一編號 */
    public static final short SSID_TYPE_BUSINESSID = 1;

    /** 身分證字號或統編種類: 護照號碼 */
    public static final short SSID_TYPE_PASSPORTID = 2;

    /** 身分證字號或統編種類: 海外身分證 */
    public static final short SSID_TYPE_OTHER_COUNTRY_SSID = 3;

    /* Sex */
    /** 性別: 未註明 **/
    public static final short SEX_NO_EXPLAIN = 0;

    /** 性別: 男 **/
    public static final short SEX_MAIL = 1;

    /** 性別: 女 **/
    public static final short SEX_FEMAIL = 2;

    /* AddressType */
    /** 地址: 一般格式 **/
    public static final short ADDRESSTYPE_GENERAL = 0;

    /** 地址: 空白輸入 **/
    public static final short ADDRESSTYPE_SPACE = 1;

    /* 捐款人等級(DonorLevel) */
    /** 等級:少用 (初發心) **/
    public static final short LEVEL_RARE = 1;

    /** 等級:一般使用者 (精進) **/
    public static final short LEVEL_GENERAL = 10;

    public static final String LEVEL_RARE_DESC = "初發心";

    public static final String LEVEL_GENERAL_DESC = "精進";

    /* 郵寄地址欄位類別 */
    /** 郵寄地址：9 同住址 */
    public static final short MAIL_ADDRESS_TYPE_SAME = 9;
    /** 郵寄地址：0 一般格式 */
    public static final short MAIL_ADDRESS_TYPE_GENERAL = 0;
    /** 郵寄地址：1 空白輸入 */
    public static final short MAIL_ADDRESS_TYPE_SPACE = 1;

    /* 是否接收活動通起 */
    /** 是 */
    public static final int RECEIVE_NEWS_INFORMED = 1;
    /** 否 */
    public static final int NOT_RECEIVE_NEWS_INFORMED = 0;
    /** 提報狀態 - 預設 (尚未提報) */
    public static final short APPLIED_STATE_ID_DEFAULT = 0;
    /** 提報狀態 - 已提報 */
    public static final short APPLIED_STATE_ID_APPLIED = 1;
    /** 提報狀態 - 永久註記 */
    public static final short APPLIED_STATE_ID_APPLIED_PERMANENT = 2;

    /* [CONSTRUCTOR MARKER BEGIN] */
    public Donor() {
        super();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DonorKey")
    private java.lang.Integer donorKey;
    
    @Column(name = "Version")
    private java.lang.Integer version;

    @Column(name = "DonorSN")
    private java.lang.String donorSN;

    @Column(name = "DonorName")
    private java.lang.String donorName;

    @Column(name = "DonorSSIDType")
    private java.lang.Short donorSSIDType;

    @Column(name = "DonorSSID")
    private java.lang.String donorSSID;

    @Column(name = "Birthday")
    private java.util.Date birthday;

    @Column(name = "Sex")
    private java.lang.Short sex;

    @Column(name = "TelAreaNoHome")
    private java.lang.String telAreaNoHome;

    @Column(name = "TelNoHome")
    private java.lang.String telNoHome;

    @Column(name = "TelAreaNoOffice")
    private java.lang.String telAreaNoOffice;

    @Column(name = "TelNoOffice")
    private java.lang.String telNoOffice;

    @Column(name = "TelNoCell")
    private java.lang.String telNoCell;

    @Column(name = "EMail")
    private java.lang.String eMail;

    @Column(name = "ZipCode")
    private java.lang.String zipCode;

    @Column(name = "AddressType")
    private java.lang.Short addressType;

    @Column(name = "Address")
    private java.lang.String address;


	public java.lang.Integer getVersion() {
		return version;
	}

	public void setVersion(java.lang.Integer version) {
		this.version = version;
	}

	public java.lang.String getDonorSN() {
		return donorSN;
	}

	public void setDonorSN(java.lang.String donorSN) {
		this.donorSN = donorSN;
	}

	public java.lang.String getDonorName() {
		return donorName;
	}

	public void setDonorName(java.lang.String donorName) {
		this.donorName = donorName;
	}

	public java.lang.Short getDonorSSIDType() {
		return donorSSIDType;
	}

	public void setDonorSSIDType(java.lang.Short donorSSIDType) {
		this.donorSSIDType = donorSSIDType;
	}

	public java.lang.String getDonorSSID() {
		return donorSSID;
	}

	public void setDonorSSID(java.lang.String donorSSID) {
		this.donorSSID = donorSSID;
	}

	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public java.lang.Short getSex() {
		return sex;
	}

	public void setSex(java.lang.Short sex) {
		this.sex = sex;
	}

	public java.lang.String getTelAreaNoHome() {
		return telAreaNoHome;
	}

	public void setTelAreaNoHome(java.lang.String telAreaNoHome) {
		this.telAreaNoHome = telAreaNoHome;
	}

	public java.lang.String getTelNoHome() {
		return telNoHome;
	}

	public void setTelNoHome(java.lang.String telNoHome) {
		this.telNoHome = telNoHome;
	}

	public java.lang.String getTelAreaNoOffice() {
		return telAreaNoOffice;
	}

	public void setTelAreaNoOffice(java.lang.String telAreaNoOffice) {
		this.telAreaNoOffice = telAreaNoOffice;
	}

	public java.lang.String getTelNoOffice() {
		return telNoOffice;
	}

	public void setTelNoOffice(java.lang.String telNoOffice) {
		this.telNoOffice = telNoOffice;
	}

	public java.lang.String getTelNoCell() {
		return telNoCell;
	}

	public void setTelNoCell(java.lang.String telNoCell) {
		this.telNoCell = telNoCell;
	}

	public java.lang.String geteMail() {
		return eMail;
	}

	public void seteMail(java.lang.String eMail) {
		this.eMail = eMail;
	}

	public java.lang.String getZipCode() {
		return zipCode;
	}

	public void setZipCode(java.lang.String zipCode) {
		this.zipCode = zipCode;
	}

	public java.lang.Short getAddressType() {
		return addressType;
	}

	public void setAddressType(java.lang.Short addressType) {
		this.addressType = addressType;
	}

	public java.lang.String getAddress() {
		return address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	public java.lang.Integer getDonorKey() {
		return donorKey;
	}

	public void setDonorKey(java.lang.Integer donorKey) {
		this.donorKey = donorKey;
	}
   
}