package com.xzc.androiddemo.utils;

import android.content.Context;
import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * 
 * Title: RegexUtils<br>
 * Description: TODO 正则表达示<br>
 * Depend : TODO
 * 
 * @author xuzhuchao
 * @Version
 * @Revision
 * @ModifiedDate
 * @since JDK 1.7
 */
public class RegexUtils {


	public static boolean regexIsLogin(String uid, Context context){

		if (TextUtils.isEmpty(uid)) {

			ShowUtil.showToast("请您先登录!");
			return false;
		}else {
			return true;
		}
	}

	/** 密码 */
	public static boolean pwdRegex(String pwd) {
		// 验证通过返回true否则返回false
		return Pattern.matches("^(?![^a-zA-Z]+$)(?!\\D+$).{6,12}$", pwd);
	}

	/** 手机号 */
	public static boolean etPhoneRegex(String etPhone) {
		// 验证通过返回true否则返回false
		return Pattern.matches("^[1][3-8]+\\d{9}$", etPhone);
	}

	/** 身份证号 */
	public static boolean identity_card(String identity_card) {
		// 验证通过返回true否则返回false
		return Pattern.matches("^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))+$", identity_card);
	}

	/** 名字 */
	public static boolean etName(String name) {
		// 验证通过返回true否则返回false
		return Pattern.matches("^[a-zA-Z0-9\u4e00-\u9fa5]{2,10}+$", name);
	}
	/** 邮箱正则 */
	public static boolean etEmail(String email) {
		// 验证通过返回true否则返回false
		return Pattern.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$", email);
	}

	// 验证金额
	public static boolean isNumber(String str) {
		Pattern pattern = Pattern.compile("^(0(?:[.](?:[1-9]\\d?|0[1-9]))|[1-9]\\d*(?:[.]\\d{1,2}|$))$"); // 判断小数点后一位的数字的正则表达式
		java.util.regex.Matcher match = pattern.matcher(str);
		if (match.matches() == false) {
			return false;
		} else {
			return true;
		}
	}

}