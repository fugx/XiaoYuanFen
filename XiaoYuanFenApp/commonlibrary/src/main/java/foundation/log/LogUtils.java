package foundation.log;

import android.util.Log;

import java.io.File;

import static foundation.log.Constant.A;
import static foundation.log.Constant.D;
import static foundation.log.Constant.E;
import static foundation.log.Constant.I;
import static foundation.log.Constant.JSON;
import static foundation.log.Constant.NULL_TIPS;
import static foundation.log.Constant.V;
import static foundation.log.Constant.W;

/**
 * Log统一管理类
 *
 * @author
 */
public class LogUtils {
    private static final String TAG = "LogUtils";
    private static boolean IS_SHOW_LOG = true;

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (IS_SHOW_LOG)
            Log.i(TAG, msg);
    }

    public static void d(String msg) {
        if (IS_SHOW_LOG)
            Log.d(TAG, msg);
    }

    public static void e(String msg) {
        if (IS_SHOW_LOG)
            Log.e(TAG, msg);
    }

    public static void v(String msg) {
        if (IS_SHOW_LOG)
            Log.v(TAG, msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (IS_SHOW_LOG)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (IS_SHOW_LOG)
            Log.i(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (IS_SHOW_LOG)
            Log.i(tag, msg);
    }

    //当log大于1024*4的字数时导致打印不全，分段打印
    public static void eMax(String tag, String msg) {
        if (IS_SHOW_LOG) {
            while (msg.length() > 4000) {
                Log.e(tag, msg.substring(0, 4000));
                msg = msg.substring(4000);
            }
            Log.e(tag, msg);
        }

    }

    public static void v(String tag, String msg) {
        if (IS_SHOW_LOG)
            Log.i(tag, msg);
    }

    public static void init(boolean isShowLog) {
        IS_SHOW_LOG = isShowLog;
    }

    public static void v(Object msg) {
        printLog(V, null, msg);
    }


    public static void d(Object msg) {
        printLog(D, null, msg);
    }

    public static void d(String tag, Object msg) {
        printLog(D, tag, msg);
    }

    public static void log(String tag, Object msg) {
        printLog(D, tag, msg);
    }

    public static void log(String tag, String format, Object... args) {

        if (format == null)
            return;

        String message = String.format(format, args);
        if (IS_SHOW_LOG) {
            Log.d(tag, message);
        }
    }

    public static void i(Object msg) {
        printLog(I, null, msg);
    }

    public static void i(String tag, Object msg) {
        printLog(I, tag, msg);
    }

    public static void w(Object msg) {
        printLog(W, null, msg);
    }

    public static void w(String tag, Object msg) {
        printLog(W, tag, msg);
    }

    public static void e(Object msg) {
        printLog(E, null, msg);
    }

    public static void e(String tag, Object msg) {
        printLog(E, tag, msg);
    }

    public static void a(Object msg) {
        printLog(A, null, msg);
    }

    public static void a(String tag, Object msg) {
        printLog(A, tag, msg);
    }

    public static void json(String jsonFormat) {
        printLog(JSON, null, jsonFormat);
    }

    public static void json(String tag, String jsonFormat) {
        printLog(JSON, tag, jsonFormat);
    }

    public static void file(File targetDirectory, Object msg) {
        printFile(null, targetDirectory, null, msg);
    }

    public static void file(String tag, File targetDirectory, Object msg) {
        printFile(tag, targetDirectory, null, msg);
    }

    public static void file(String tag, File targetDirectory, String fileName, Object msg) {
        printFile(tag, targetDirectory, fileName, msg);
    }

    private static void printLog(int type, String tagStr, Object objectMsg) {

        if (!IS_SHOW_LOG) {
            return;
        }

        String[] contents = wrapperContent(tagStr, objectMsg);
        String tag = contents[0];
        String msg = contents[1];
        String headString = contents[2];

        switch (type) {
            case V:
            case D:
            case I:
            case W:
            case E:
            case A:
                BaseLog.printDefault(type, tag, headString + msg);
                break;
            case JSON:
                JsonLog.printJson(tag, msg, headString);
                break;
        }
    }


    private static void printFile(String tagStr, File targetDirectory, String fileName, Object objectMsg) {

        if (!IS_SHOW_LOG) {
            return;
        }

        String[] contents = wrapperContent(tagStr, objectMsg);
        String tag = contents[0];
        String msg = contents[1];
        String headString = contents[2];

        FileLog.printFile(tag, targetDirectory, fileName, headString, msg);
    }

    private static String[] wrapperContent(String tagStr, Object objectMsg) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int index = 5;
        String className = stackTrace[index].getFileName();
        String methodName = stackTrace[index].getMethodName();
        int lineNumber = stackTrace[index].getLineNumber();
        String methodNameShort = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ (").append(className).append(":").append(lineNumber).append(")#").append(methodNameShort).append(" ] ");

        String tag = (tagStr == null ? className : tagStr);
        String msg = (objectMsg == null) ? NULL_TIPS : objectMsg.toString();
        String headString = stringBuilder.toString();

        return new String[]{tag, msg, headString};
    }
}