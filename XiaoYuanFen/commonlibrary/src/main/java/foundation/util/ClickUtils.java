package foundation.util;

/**
 * Created by wfpb on 15/6/25.
 */
public class ClickUtils {

    private static long lastClickTime;
    /**
     * 判断是否是快速点击，默认间隔时间500ms
     * @return
     */
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    /**
     * 判断是否是快速点击
     * @param intervalTime 自定义间隔时间（ms）
     * @return
     */
    public static boolean isFastDoubleClick(int intervalTime) {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < intervalTime) {
            return true;
        }
        lastClickTime = time;
        return false;
    }


}
