/** ===========================================================================
 * IISI Confidential
 *
 * Title: 字串常用功能
 * 
 * (C) Copyright IISI Corp. 2006.
 * ===========================================================================
 */

package tw.com.iisi.fgs.util;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.NumberUtils;

/**
 *
 * version 1.0, 2006/12/14
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {

	protected StringUtils() {
		// hide from public access
	}

	/**
	 * StringUtils.getTokens(null, *) = [] StringUtils.getTokens("", *) = []
	 * StringUtils.getTokens("abc def", -1) = [] StringUtils.getTokens("abc def"
	 * , 0) = [] StringUtils.getTokens("abc  def", 2) = ["ab", "c ", "de", "f"]
	 * 
	 * @param sData
	 *            原始字串
	 * @param iLength
	 *            切割的長度
	 * @return
	 */
	public static String[] getTokens(String sData, int iLength) {

		if (null == sData || iLength < 1) {
			return ArrayUtils.EMPTY_STRING_ARRAY;
		}

		List tokens = new ArrayList();

		int iLeft = 0;

		int iDataLen = sData.length();

		while (iLeft < iDataLen) {

			int iRight = (iLeft + iLength) > iDataLen ? iDataLen : iLeft + iLength;

			String sToken = sData.substring(iLeft, iRight);

			iLeft += iLength;

			tokens.add(sToken);
		}

		return (String[]) tokens.toArray(new String[tokens.size()]);
	}

	/**
	 * StringUtils.getTokens(null, *) = [] StringUtils.getTokens("", *) = []
	 * StringUtils.getTokens("abc def", null) = ["abc", "def"]
	 * StringUtils.getTokens("abc def", " ") = ["abc", "def"]
	 * StringUtils.getTokens("abc  def", " ") = ["abc", "def"]
	 * StringUtils.getTokens("ab:cd:ef", ":") = ["ab", "cd", "ef"]
	 * StringUtils.getTokens("ab:cd:ef:", ":") = ["ab", "cd", "ef", ""]
	 * 
	 * @param sData
	 * @param sDelim
	 * @return
	 */
	public static String[] getTokens(String sData, String sDelim) {

		if (null == sData) {
			return ArrayUtils.EMPTY_STRING_ARRAY;
		}

		List tokens = new ArrayList();

		int iDataLen = sData.length();
		int iDelimLen = sDelim.length();

		int iLeft = 0;
		int iRight = sData.indexOf(sDelim);

		while (iRight >= 0) {

			String sToken = sData.substring(iLeft, iRight).trim();
			tokens.add(sToken);
			iLeft = iRight + iDelimLen;
			iRight = sData.indexOf(sDelim, iLeft);
		}

		if (iLeft < iDataLen) {
			String sToken = sData.substring(iLeft, iDataLen);
			tokens.add(sToken);
		}

		// 取最後一個token，如果為delim則加入一個空白("")token
		if (iDataLen >= iDelimLen) {
			String sLastToken = sData.substring(iDataLen - iDelimLen, iDataLen);

			if (sLastToken.equals(sDelim)) {
				tokens.add("");
			}
		}
		return (String[]) tokens.toArray(new String[tokens.size()]);

	}

	/**
	 * 
	 * StringUtils.replaceDelim(null, null, null) = null
	 * StringUtils.replaceDelim("", null, null) = "" StringUtils.replaceDelim(
	 * "a*b*c*, "*", [])           = "a*b*c*" StringUtils.replaceDelim("a*b*c*",
	 * "*", null) = "a*b*c*" StringUtils.replaceDelim("a*b*c*", "*", [1]) =
	 * "a*b*c*" StringUtils.replaceDelim("a*b*c*", "*", [1, 2, 3]) = "a1b2c3"
	 * StringUtils.replaceDelim("a*b*c*", "&", [1, 2, 3]) = "a*b*c*"
	 * 
	 * @param sSource
	 *            string to seach and replace in, may be null
	 * @param sDelim
	 *            the string to search for, may be null
	 * @param with
	 *            the strings to replace with
	 * @return
	 */
	public static String replaceDelim(String sSource, String sDelim, String with[]) {

		if (sSource == null || sDelim == null || with == null || sDelim.length() == 0 || with.length == 0) {
			return sSource;
		}

		String[] tokens = StringUtils.getTokens(sSource, sDelim);

		// token number - 1 == with number
		if ((tokens.length - 1) != with.length) {
			return sSource;
		}

		StringBuffer sb = new StringBuffer("");

		for (int i = 0; i < with.length; i++) {

			sb.append(tokens[i]);

			sb.append(with[i]);
		}

		// last token
		sb.append(tokens[tokens.length - 1]);

		return sb.toString();

	}

	public static String replaceDelim(String sSource, String sDelim, List with) {

		String[] array = (String[]) with.toArray(new String[with.size()]);

		return replaceDelim(sSource, sDelim, array);

	}

	/**
	 * 
	 * @param sValue
	 * @return
	 */
	public static int str2Int(String sValue, int iDefaultValue) {
		int iValue = iDefaultValue;
		try {
			iValue = Integer.parseInt(sValue);
		} catch (Exception e) {
			iValue = iDefaultValue;
		}

		return iValue;
	}

	public static int str2Int(String sValue) {
		return StringUtils.str2Int(sValue, 0);
	}

	/**
	 * StringUtils.getMoneyStr(null) = "" StringUtils.getMoneyStr(" ") = ""
	 * StringUtils.getMoneyStr("1234567.89") = "1,234,567.89"
	 * StringUtils.getMoneyStr("1234567.00") = "1,234,567";
	 * StringUtils.getMoneyStr("1234567.0100") = "1,234,567.01";
	 * 
	 * @param sMoney
	 * @return
	 */
	public static String getMoneyStr(String sMoney) {

		if (isBlank(sMoney)) {
			return "";
		}

		sMoney = sMoney.trim();

		StringBuffer sb = new StringBuffer();
		int iLen = sMoney.length();

		if (sMoney.startsWith("+") || sMoney.startsWith("-")) {

			String sSign = substring(sMoney, 0, 1);
			// '-' 放回去, '+' 濾除
			sb.append(sSign.equals("-") ? sSign : "");
			sMoney = substring(sMoney, 1);
		}

		// 整數
		String sInt = "";

		// 小數
		String sDecimal = "";

		// 小數點
		String sDot = "";

		int index = sMoney.indexOf(".");

		if (index >= 0) {
			sDot = ".";
			sInt = sMoney.substring(0, index);
			if ((index + 1) < iLen) {
				sDecimal = sMoney.substring(index + 1, sMoney.length());
			}
		} else {
			sInt = sMoney;
		}

		// 整數
		sInt = getIntMoneyStr(sInt);

		// 小數
		sDecimal = trimRightZero(sDecimal);

		// 有整數部分
		if (sInt.length() > 0) {
			sb.append(sInt);

			if (sDecimal.length() > 0) {
				sb.append(sDot).append(sDecimal);
			}
		}
		// 沒有整數部分
		else {
			if (sDecimal.length() > 0) {
				sb.append("0.").append(sDecimal);
			} else {
				sb.append("0");
			}
		}

		return sb.toString();
	}

	/**
	 * StringUtils.getMoneyStr(null, 1) = "" StringUtils.getMoneyStr(" ", 2) =
	 * "" StringUtils.getMoneyStr("1234567.89", 2) = "1,234,567.89"
	 * StringUtils.getMoneyStr("1234567.00", 1) = "1,234,567.0";
	 * StringUtils.getMoneyStr("1234567.0100", 2) = "1,234,567.01";
	 * 
	 * @param sMoney
	 * @param iScale
	 * @return
	 */
	public static String getMoneyStr(String sMoney, int iScale) {

		if (isBlank(sMoney)) {
			return "";
		}

		sMoney = sMoney.trim();

		StringBuffer sb = new StringBuffer();
		int iLen = sMoney.length();

		if (sMoney.startsWith("+") || sMoney.startsWith("-")) {

			String sSign = substring(sMoney, 0, 1);
			// '-' 放回去, '+' 濾除
			sb.append(sSign.equals("-") ? sSign : "");
			sMoney = substring(sMoney, 1);
		}

		// 整數
		String sInt = "";

		// 小數
		String sDecimal = "";

		// 小數點
		String sDot = "";

		int index = sMoney.indexOf(".");

		if (index >= 0) {
			sDot = ".";
			sInt = sMoney.substring(0, index);
			if ((index + 1) < iLen) {
				sDecimal = sMoney.substring(index + 1, sMoney.length());
			}
		} else {
			sInt = sMoney;
		}

		// 整數
		sInt = getIntMoneyStr(sInt);

		// 小數
		sDecimal = substring(sDecimal, 0, iScale);

		// 有整數部分
		if (sInt.length() > 0) {
			sb.append(sInt);

			if (sDecimal.length() > 0) {
				sb.append(sDot).append(rightPad(sDecimal, iScale, "0"));
			} else {
				if (iScale > 0) {
					sb.append(".").append(rightPad(sDecimal, iScale, "0"));
				}
			}
		}
		// 沒有整數部分
		else {
			if (sDecimal.length() > 0) {
				sb.append("0.").append(rightPad(sDecimal, iScale, "0"));
			} else {
				if (iScale > 0) {
					sb.append("0.").append(rightPad(sDecimal, iScale, "0"));
				} else {
					sb.append("0");
				}
			}
		}

		return sb.toString();
	}

	/**
	 * StringUtils.getIntMoneyStr("001234567") = "1,234,567"
	 * 
	 * @param sInt
	 * @return
	 */
	public static String getIntMoneyStr(String sInt) {

		if (isBlank(sInt)) {
			return "";
		}

		sInt = sInt.trim();

		//
		// long lAmountInteger = Long.parseLong(sInt);
		//
		// String sPattern = "###,###";
		//
		// DecimalFormat df = new DecimalFormat(sPattern);
		//
		// return df.format(lAmountInteger);

		StringBuffer sb = new StringBuffer();

		sInt = trimLeftZero(sInt);
		int iLen = sInt.length();

		for (int i = 0; i < iLen; i++) {

			char ch = sInt.charAt(i);

			sb.append(ch);
			// 剩餘長度
			int iRemainLen = iLen - i - 1;

			if ((iRemainLen > 0) && (iRemainLen % 3 == 0)) {
				sb.append(",");
			}

		}
		return sb.toString();

	}

	/**
	 * 將數字字串依照指定的小數位數輸出成浮點數字串<br>
	 * parseFloat("12345678", 2) -> "123456.78"<br>
	 * parseFloat("12345678", 6) -> "12.345678"<br>
	 * parseFloat("12345678", 10) -> "0.0012345678"<br>
	 * parseFloat("12345678", 0) -> "12345678"<br>
	 * parseFloat("12345678", -1) -> "12345678"<br>
	 * parseFloat("a12s5w6dd", 3) -> ""<br>
	 * parseFloat("", 3) -> ""<br>
	 * parseFloat(null, 3) -> ""<br>
	 * 
	 * @param sSourceStr
	 *            原始字串
	 * @param iScale
	 *            小數位數
	 * @return
	 */
	public static String parseFloat(String sSourceStr, int iScale) {

		if (!NumberUtils.isDigits(sSourceStr)) {
			return "";
		}

		if (StringUtils.isBlank(sSourceStr) || iScale < 1) {
			return StringUtils.defaultString(sSourceStr);
		}

		String sInt = "";

		String sDecimal = "";

		int iLength = sSourceStr.length();

		if (iLength > iScale) {
			// 整數長度
			int iIntLength = iLength - iScale;

			sInt = sSourceStr.substring(0, iIntLength);

			sDecimal = sSourceStr.substring(iIntLength);
		} else {

			sInt = "0";

			sDecimal = StringUtils.leftPad(sSourceStr, iScale, "0");

		}

		return sInt + "." + sDecimal;
	}

	/**
	 * StringUtils.trimLeftZero("0012345600") = "12345600"
	 * 
	 * @param sSource
	 * @return
	 */
	public static String trimLeftZero(String sSource) {

		if (sSource == null) {
			return "";
		}

		int iLen = sSource.length();
		int index = -1;
		for (int i = 0; (i < iLen && index < 0); i++) {
			char ch = sSource.charAt(i);

			if (ch != '0') {
				index = i;
			}
		}
		String s = "";
		// 發現非0之數字
		if (index >= 0) {
			s = sSource.substring(index, iLen);
		}

		return s;

	}

	/**
	 * StringUtils.trimLeft("   345600") = "345600"<br>
	 * StringUtils.trimLeft("   345600  ") = "345600  "
	 * 
	 * @param sSource
	 * @return
	 */
	public static String trimLeft(String sSource) {

		if (sSource == null) {
			return "";
		}

		int iLen = sSource.length();
		int index = -1;
		for (int i = 0; (i < iLen && index < 0); i++) {
			char ch = sSource.charAt(i);

			if (ch != ' ') {
				index = i;
			}
		}
		String s = "";

		if (index >= 0) {
			s = sSource.substring(index, iLen);
		}

		return s;

	}

	/**
	 * StringUtils.trimRightZero("01234500") = "012345"
	 * 
	 * @param sSource
	 * @return
	 */
	public static String trimRightZero(String sSource) {

		if (sSource == null) {
			return "";
		}

		int iLen = sSource.length();
		int index = -1;
		// 由後至前
		for (int i = (iLen - 1); (i >= 0 && index < 0); i--) {
			char ch = sSource.charAt(i);
			if (ch != '0') {
				index = i;
			}
		}

		String s = "";
		if (index >= 0) {
			s = sSource.substring(0, index + 1);
		}

		return s;
	}

	/**
	 * StringUtils.trimRight("1234500  ") = "012345"<br>
	 * StringUtils.trimRight("  1234500  ") = "  012345"
	 * 
	 * @param sSource
	 * @return
	 */
	public static String trimRight(String sSource) {

		if (sSource == null) {
			return "";
		}

		int iLen = sSource.length();
		int index = -1;
		// 由後至前
		for (int i = (iLen - 1); (i >= 0 && index < 0); i--) {
			char ch = sSource.charAt(i);
			if (ch != ' ') {
				index = i;
			}
		}

		String s = "";
		if (index >= 0) {
			s = sSource.substring(0, index + 1);
		}

		return s;
	}

	public static String trimZero(String sRate) {

		if (sRate == null) {
			return "";
		}

		StringBuffer sb = new StringBuffer();
		int iLen = sRate.length();

		// 整數
		String sInt = "";

		// 小數
		String sDecimal = "";

		// 小數點
		String sDot = "";

		int index = sRate.indexOf(".");

		if (index >= 0) {
			sDot = ".";
			sInt = sRate.substring(0, index);
			if ((index + 1) < iLen) {
				sDecimal = sRate.substring(index + 1, sRate.length());
			}
		} else {
			sInt = sRate;
		}

		// 整數
		sInt = trimLeftZero(sInt);

		// 小數
		sDecimal = trimRightZero(sDecimal);

		// 有整數部分
		if (sInt.length() > 0) {
			sb.append(sInt);

			if (sDecimal.length() > 0) {
				sb.append(sDot).append(sDecimal);
			}
		}
		// 沒有整數部分
		else {
			if (sDecimal.length() > 0) {
				sb.append("0.").append(sDecimal);
			} else {
				sb.append("0.0");
			}
		}

		// sb.append("%");

		return sb.toString();
	}

	/**
	 * StringUtils.getRateStr("000122.00100") = "122.001"
	 * StringUtils.getRateStr("00.12") = "0.12" StringUtils.getRateStr("00.00")
	 * = "0.0"
	 * 
	 * @param sRate
	 * @return
	 */
	public static String getRateStr(String sRate) {
		return trimZero(sRate);
	}

	/**
	 * 取得整數部分
	 * 
	 * StringUtils.getRateStr("000122.00100") = "122"
	 * 
	 * @param sRate
	 * @return
	 */
	public static String getIntPart(String sRate) {

		if (sRate == null) {
			return "";
		}

		int iLen = sRate.length();

		// 整數
		String sInt = "";

		int index = sRate.indexOf(".");

		if (index >= 0) {
			sInt = sRate.substring(0, index);
		} else {
			sInt = sRate;
		}

		// 整數
		sInt = trimLeftZero(sInt);

		return sInt;
	}

	public static String leftPadByByteLenth(String sData, int iLength, String sPadStr) {

		if (sData == null) {
			return null;
		}

		if (sPadStr == null || sPadStr.length() == 0) {
			sPadStr = " ";
		}

		String sResult = sData;
		while (sResult.getBytes().length < iLength) {
			sResult = sPadStr + sResult;
		}

		return sResult;
	}

	public static String rightPadByByteLenth(String sData, int iLength, String sPadStr) {

		if (sData == null) {
			return null;
		}

		if (sPadStr == null || sPadStr.length() == 0) {
			sPadStr = " ";
		}
		String sResult = sData;

		while (sResult.getBytes().length < iLength) {
			sResult += sPadStr;
		}

		return sResult;
	}

	/**
	 * trim 全形空白<br>
	 * 
	 * @param sValue
	 * @return
	 */
	public static String trimRightBigSpace(String sValue) {
		String sResult = sValue;

		while (sResult.endsWith("　")) {
			sResult = sResult.substring(0, sResult.length() - 1);
		}

		return sResult;
	}

	/**
	 * 將參數加入原本的 QueryString中。
	 * 
	 * @param queryString
	 * @param params
	 * @return
	 */
	public static String queryStringAssembler(String queryString, Map<String, Object> params) {
		Iterator<String> it = params.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			Object obj = params.get(key);
			if (obj == null) {
				obj = "";
			}
			queryString = queryString.replaceAll(":" + key, "'" + (String) obj + "'");
		}
		return queryString;
	}

	/**
	 * 掉物件裡面欄位是如果是String，自動trim空白
	 * 
	 * @param object
	 * 
	 * @return
	 */
	public static Object trimObject(Object object) {

		if (object == null) {
			return null;
		}

		Class<? extends Object> c = object.getClass();
		try {

			// Introspector usage to pick the getters conveniently thereby
			// excluding the Object getters
			for (PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(c, Object.class)
					.getPropertyDescriptors()) {

				// read setMethod
				Method setter = propertyDescriptor.getWriteMethod();

				// read getMethod
				Method getter = propertyDescriptor.getReadMethod();

				if ((setter != null && getter != null) && (getter.getReturnType().equals(String.class))) {

					// 取值
					String value = (String) getter.invoke(object);

					if (value != null) {

						// 設定值
						setter.invoke(object, value.trim());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
	
	public static boolean equalsIgnoreSpace(String args0, String args1){
	    return equals(trimToEmpty(args0), trimToEmpty(args1));
	}
	
	/**
	 * 全形|半形資料轉換
	 * @param data 需要轉換的文字
	 * @param option (0:全形轉半形; 1:半形轉全形)
	 * @return
	 */
	public static String convertFullorHalf(String data, int option) {
        // 半形資料
        String[] halfTable = { " ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/",
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ":", ";", "<", "=", ">", "?", "@",
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y", "Z",
                "[", "\\", "]", "^", "_", "`",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
                "v", "w", "x", "y", "z",
                "{", "|", "}", "~" };

        // 全形資料
        String[] fullTable = { "　", "！", "”", "＃", "＄", "％", "＆", "’", "（", "）", "＊", "＋", "，", "－", "‧", "／",
                "０", "１", "２", "３", "４", "５", "６", "７", "８", "９", "：", "；", "＜", "＝", "＞", "？", "＠",
                "Ａ", "Ｂ", "Ｃ", "Ｄ", "Ｅ", "Ｆ", "Ｇ", "Ｈ", "Ｉ", "Ｊ", "Ｋ", "Ｌ", "Ｍ", "Ｎ", "Ｏ", "Ｐ", "Ｑ", "Ｒ", "Ｓ", "Ｔ", "Ｕ",
                "Ｖ", "Ｗ", "Ｘ", "Ｙ", "Ｚ",
                "〔", "＼", "〕", "︿", "＿", "｀",
                "ａ", "ｂ", "ｃ", "ｄ", "ｅ", "ｆ", "ｇ", "ｈ", "ｉ", "ｊ", "ｋ", "ｌ", "ｍ", "ｎ", "ｏ", "ｐ", "ｑ", "ｒ", "ｓ", "ｔ", "ｕ",
                "ｖ", "ｗ", "ｘ", "ｙ", "ｚ",
                "｛", "｜", "｝", "～" };

        if (halfTable.length == fullTable.length) {
            // 開始轉換
            if (data == null || "".equalsIgnoreCase(data)) {
                return "";
            }
            for (int i = 0; i < halfTable.length; i++) {
                // 開始轉換
                if (option == 0) {
                    // 全形 轉 半形
                    data = data.replace(fullTable[i], halfTable[i]);
                }
                if (option == 1) {
                    // 半形 轉 全形
                    data = data.replace(halfTable[i], fullTable[i]);
                }
            }
            return data;
        } else {
            return data;
        }
    }
}
