package com.futurenavi.libbasic.utils;

import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.TextView;

import com.futurenavi.libbasic.R;

/**
 * Created by pf on 17/2/1.
 * TextView带展开收缩效果
 * 回头抽取为自定义工具类
 */

public class SlideTextTool {

    boolean isExpand;
    private final FragmentActivity mAct;

    public SlideTextTool(FragmentActivity act) {
        this.mAct = act;
    }

    /**
     * 初始化带展开效果的TextView
     */

    public void initTextView(final TextView tv, String eStr) {
        initTextView(tv, null, 1, "", eStr);
    }

    public void initTextView(final TextView tv, final ImageView iv, String eStr) {
        initTextView(tv, iv, 1, "", eStr);
    }

    public void initTextView(final TextView tv, final ImageView iv, final int line, String eStr) {
        initTextView(tv, iv, line, "", eStr);
    }

    public void initTextView(final TextView tv, final ImageView iv, final int line,
                             String sStr, String eStr) {
        setString(tv, sStr, eStr);

        tv.setHeight(tv.getLineHeight() * line);
        tv.post(new Runnable() {
            @Override
            public void run() {
                if (iv != null) {
                    iv.setVisibility(tv.getLineCount() > line ?
                            View.VISIBLE : View.GONE);
                }
            }
        });
    }


    /**
     * 字符串的拼接与变色
     * 限定：sStr为5个length
     */
    public void setString(TextView tv, String eStr) {
        tv.setText(eStr);
    }

    public void setString(TextView tv, String sStr, String eStr) {
        if (!TextUtils.isEmpty(sStr)) {
            String result = String.format(sStr, eStr);
            SpannableStringBuilder builder = new SpannableStringBuilder(result);
            ForegroundColorSpan redSpan = new ForegroundColorSpan(mAct.getResources()
                    .getColor(R.color.c464646));
            ForegroundColorSpan blueSpan = new ForegroundColorSpan(mAct.getResources()
                    .getColor(R.color.c888888));
            builder.setSpan(redSpan, 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            builder.setSpan(blueSpan, 5, builder.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            tv.setText(builder);
        } else {
            tv.setText(eStr);
        }
    }


    /**
     * 文字的展开收起效果
     */
    public void isSlide(final TextView tv, ImageView iv) {
        isSlide(tv, iv, 1);
    }

    public void isSlide(final TextView tv, ImageView iv, int line) {
        isExpand = !isExpand;
        tv.clearAnimation();
        final int deltaValue;
        final int startValue = tv.getHeight();
        int durationMillis = 350;
        if (isExpand) {
            deltaValue = tv.getLineHeight() * tv.getLineCount() - startValue;
            RotateAnimation animation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF,
                    0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            animation.setDuration(durationMillis);
            animation.setFillAfter(true);
            iv.startAnimation(animation);
        } else {
            deltaValue = tv.getLineHeight() * line - startValue;
            RotateAnimation animation = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF,
                    0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            animation.setDuration(durationMillis);
            animation.setFillAfter(true);
            iv.startAnimation(animation);
        }
        Animation animation = new Animation() {
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                tv.setHeight((int) (startValue + deltaValue * interpolatedTime));
            }

        };
        animation.setDuration(durationMillis);
        tv.startAnimation(animation);
    }

}
