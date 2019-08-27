package foundation.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.graphics.Palette;
import android.util.Log;

/**
 * Created by alden on 2018/4/21.
 */

public class ColorUtils {

    public static int getPaletteColor(Bitmap bitmap) {
        int color = 0;//rgb格式
        Palette palette = Palette.generate(bitmap);//这里使用同步加载，建议使用异步
        Palette.Swatch vibrant = palette.getVibrantSwatch();
        Palette.Swatch vibrantdark = palette.getDarkVibrantSwatch();
        Palette.Swatch vibrantlight = palette.getLightVibrantSwatch();
        Palette.Swatch Muted = palette.getMutedSwatch();
        Palette.Swatch Muteddark = palette.getDarkMutedSwatch();
        Palette.Swatch Mutedlight = palette.getLightMutedSwatch();

        if (vibrant != null) {
            color = vibrant.getRgb();
        } else if (Muteddark != null) {
            color = Muteddark.getRgb();
        } else if (vibrantdark != null) {
            color = vibrantdark.getRgb();
        } else if (vibrantlight != null) {
            color = vibrantlight.getRgb();
        } else if (Mutedlight != null) {
            color = Mutedlight.getRgb();
        } else if (Muted != null) {
            color = Muted.getRgb();
        }
        return color;
    }

    public static boolean isDiaryMainColor(Bitmap bitmap){
        int rgbValues = getPaletteColor(bitmap);
        return isDiaryMainColor(rgbValues);
    }

    public static boolean isDiaryMainColor(int rgbColor){
        int[] colors = new int[3];
        colors[0] = Color.red(rgbColor);
        colors[1] = Color.green(rgbColor);
        colors[2] = Color.blue(rgbColor);
        //rgb转换为yuv,可以判断图片明暗
        int grayLevel = (int) (colors[0] * 0.299 + colors[1] * 0.587 + colors[2] * 0.114);
        Log.i("grayLevel", grayLevel + "");
        //return grayLevel <= 70;
        if(grayLevel>=192){
            return false;
        }
        return true;
    }

}
