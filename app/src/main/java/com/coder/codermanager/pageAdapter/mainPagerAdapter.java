package com.coder.codermanager.pageAdapter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.coder.codermanager.Activity.Client.clientClientActivity;
import com.coder.codermanager.Activity.Client.clientContactPersonActivity;
import com.coder.codermanager.Activity.Home.homeHomeActivity;
import com.coder.codermanager.Activity.Home.homePMActivity;
import com.coder.codermanager.Activity.Home.homePendingTestActivity;
import com.coder.codermanager.Activity.Home.homeTodoActivity;
import com.coder.codermanager.SingleFragment.MainActivity;
import com.coder.codermanager.Activity.Pro.proProjectActivity;
import com.coder.codermanager.Activity.Pro.proTodoActivity;
import com.coder.codermanager.Activity.Pro.proWorkActivity;
import com.coder.codermanager.R;

import java.util.List;

/**
 * Created by Rey on 2018/9/17.
 */

public class mainPagerAdapter extends PagerAdapter {

    private MainActivity context;
    private List<View> mListViews;
    private Button btn_bome, btn_todo, btn_PM, btn_tested;
    private Button btn_Customer, btn_Contact;
    private Button btn_Project, btn_Todomanagment, btn_worklog;
    String[] tabs = {"首頁", "客戶管理", "專案管理"};
    int[] imgs = {R.drawable.ic_home, R.drawable.ic_tag_faces, R.drawable.ic_folder_black};
    private CenterImageSpan imageSpan;

    public mainPagerAdapter(List<View> mListViews, MainActivity context) {
        this.mListViews = mListViews;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mListViews.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return setImageSpan(tabs[position], imgs[position]);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mListViews.get(position));

        switch (position) {
            case 0:
                btn_bome = (Button) mListViews.get(position).findViewById(R.id.btn_bome);
                btn_todo = (Button) mListViews.get(position).findViewById(R.id.btn_todo);
                btn_PM = (Button) mListViews.get(position).findViewById(R.id.btn_PM);
                btn_tested = (Button) mListViews.get(position).findViewById(R.id.btn_tested);

                btn_bome.setOnClickListener(new MyOnClickListener());
                btn_todo.setOnClickListener(new MyOnClickListener());
                btn_PM.setOnClickListener(new MyOnClickListener());
                btn_tested.setOnClickListener(new MyOnClickListener());

                break;
            case 1:
                btn_Customer = (Button) mListViews.get(position).findViewById(R.id.btn_Customer);
                btn_Contact = (Button) mListViews.get(position).findViewById(R.id.btn_Contact);

                btn_Customer.setOnClickListener(new MyOnClickListener());
                btn_Contact.setOnClickListener(new MyOnClickListener());
                break;
            case 2:
                btn_Project = (Button) mListViews.get(position).findViewById(R.id.btn_Project);
                btn_Todomanagment = (Button) mListViews.get(position).findViewById(R.id.btn_Todomanagment);
                btn_worklog = (Button) mListViews.get(position).findViewById(R.id.btn_worklog);

                btn_Project.setOnClickListener(new MyOnClickListener());
                btn_Todomanagment.setOnClickListener(new MyOnClickListener());
                btn_worklog.setOnClickListener(new MyOnClickListener());
                break;

        }

        return mListViews.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object == view;
    }

    private class MyOnClickListener implements View.OnClickListener {

        Intent intent;

        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.btn_bome: //首頁資訊
                    intent = new Intent(context, homeHomeActivity.class);
                    context.startActivity(intent);
                    break;
                case R.id.btn_todo: //代辦事項
                    intent = new Intent(context, homeTodoActivity.class);
                    context.startActivity(intent);
                    break;
                case R.id.btn_PM://PM管理事項
                    intent = new Intent(context, homePMActivity.class);
                    context.startActivity(intent);
                    break;
                case R.id.btn_tested: //待測試事項
                    intent = new Intent(context, homePendingTestActivity.class);
                    context.startActivity(intent);
                    break;
                case R.id.btn_Customer: //客戶管理
                    intent = new Intent(context, clientClientActivity.class);
                    context.startActivity(intent);
                    break;
                case R.id.btn_Contact: //聯絡人管理
                    intent = new Intent(context, clientContactPersonActivity.class);
                    context.startActivity(intent);
                    break;
                case R.id.btn_Project:    //專案管理
                    intent = new Intent(context, proProjectActivity.class);
                    context.startActivity(intent);
                    break;
                case R.id.btn_Todomanagment:    //代辦事項管理
                    intent = new Intent(context, proTodoActivity.class);
                    context.startActivity(intent);
                    break;
                case R.id.btn_worklog:  //工作日誌
                    intent = new Intent(context, proWorkActivity.class);
                    context.startActivity(intent);
                    break;
            }

        }
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
