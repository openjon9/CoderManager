package com.coder.codermanager.SingleFragment;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.coder.codermanager.SingleFragment.MainActivity;


import java.util.List;

/**
 * Created by Rey on 2018/9/17.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private MainActivity context;
    private List<Fragment> fragmentList;
    private List<String> titleList;
    private List<Integer> imgList;
    private CenterImageSpan imageSpan;

    public MyFragmentPagerAdapter(MainActivity context, FragmentManager fm, List<Fragment> fragmentList, List<String> titleList, List<Integer> imgList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
        this.imgList = imgList;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       // return titleList.get(position);
        return setImageSpan(titleList.get(position), imgList.get(position));
    }

    private SpannableString setImageSpan(String string, int drawableId) { //Tab+圖
        SpannableString ss = new SpannableString("  " + string);
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        //ImageSpan imageSpan = new ImageSpan(drawable);
        imageSpan = new CenterImageSpan(drawable);
        ss.setSpan(imageSpan, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return ss;
    }



    public class CenterImageSpan extends ImageSpan { //圖文對齊

        public CenterImageSpan(Drawable drawable) {
            super(drawable);
        }

        public CenterImageSpan(Bitmap b) {
            super(b);
        }

        @Override
        public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom,
                         @NonNull Paint paint) {

            Drawable b = getDrawable();
            Paint.FontMetricsInt fm = paint.getFontMetricsInt();
            int transY = (y + fm.descent + y + fm.ascent) / 2 - b.getBounds().bottom / 2;//计算y方向的位移
            canvas.save();
            canvas.translate(x, transY);//绘制图片位移一段距离
            b.draw(canvas);
            canvas.restore();
        }
    }



}
