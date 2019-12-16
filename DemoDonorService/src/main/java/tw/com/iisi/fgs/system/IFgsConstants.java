/** ===========================================================================
 * IISI Confidential
 *
 * Title: 道場捐款系統常數定義
 * 
 * (C) Copyright IISI Corp. 2006.
 * ===========================================================================
 */

package tw.com.iisi.fgs.system;

/**
 * @author JacksonLee
 *
 * version 1.0, 2007/7/6
 */
public interface IFgsConstants {
	
	/**
	 * 在頁面上傳遞資料時，用來分隔多筆字串的分隔符號
	 * 例:
	 * 	  abcd|efgh|ijkl
	 *    表示有一個array包含'abcd', 'efgh', 'ijkl'等共三個字串
	 */
	public static final String COMMON_SPLIT_STRING = "|";
	
    /**
     * CSV檔案預設的分隔符號
     */
    public static final String DEFAULT_CSV_DELIMITER = "\t";
    
    /**
     * 檔案匯出時所帶的ENTER碼
     */
    public static final String DEFAULT_EXPORT_ENTER_CODE = "\r\n";
    
    /**
     * 檔案匯出時，用來取代換行符號(\n)的字元
     */
    public static final String DEFAULT_EXPORT_ENTER_CODE_REPLACE_CHAR = " ";    
    
    /**
     * 捐款關帳匯出檔副檔名 - 產生給銀行的匯出檔副檔名
     */
    public static final String DONATION_CLOSE_BANK_EXPORT_FILE_EXTENSION = ".don";
    
    /**
     * 異動匯出檔副檔名 - 產生給銀行的異動匯出檔副檔名
     */
    public static final String DATA_VARIATION_EXPORT_FILE_EXTENSION = ".var";
    
    /**
     * 申請補印正式收據副檔名 - 產生給銀行的申請補印正式收據副檔名
     */
    public static final String RECEIPT_REAPPLY_EXPORT_FILE_NAME = ".app";
    
    /**
     * 託收票據檔檔名 - 產生給銀行的託收票據檔檔名
     */
    public static final String BILL_COLLECTION_EXPORT_FILE_NAME = "BIBFILE";
    
    
    /**
     * 託收票據檔副檔名 - 產生給銀行的託收票據檔副檔名
     */
    public static final String BILL_COLLECTION_EXPORT_FILE_EXTENSION = ".DAT";

    /** 
     * 華南銀行契約代號，全方位帳號頭五碼: 98217 
     */
    public static final String HNCB_CONSTRACT_CODE = "98217";
    
    /**
     * 華南銀行託收帳號，固定值: 103100598002
     */
    public static final String HNCB_CHECK_COLLECTION_ACCOUNT ="103100598002";
    


}
