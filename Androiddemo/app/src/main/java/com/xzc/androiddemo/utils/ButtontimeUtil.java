package com.xzc.androiddemo.utils;

/**
 * 
 * Title:  ButtontimeUtil<br>
 * Description: TODO  防止按钮连续点击工具类<br>
 * Depend : TODO 
 * @author xuzhuchao
 * @Version 
 * @Revision 
 * @ModifiedDate 
 * @since JDK 1.7
 */
public class ButtontimeUtil {
    private static long lastClickTime =0L;
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if ( 0 < timeD && timeD < 3000) {   
            return false;
        }   
        lastClickTime = time;   
        return true;
    }
}