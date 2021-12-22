package com.app.mytoolbox.utils.helpers;


import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Field;


/**
 * A TextView that only click to expand to show full text and click to show shorten text,
 * The ellipsis can be configured too.
 *
 * @author Wat Chun Pang Gilbert
 */
@SuppressLint("AppCompatCustomView")
public class ExpandableTextView extends TextView {

    private static final String TAG = ExpandableTextView.class.getSimpleName();
    private static final String sMaximumVarName = "mMaximum";
    private String mEllipsis = "\u2026\u25BC";
    private Boolean mIsExpanded;
    private Integer mMaxLine;
    private CharSequence mOriginalText;



    public ExpandableTextView(Context context) {
        super(context);
        init();
    }


    public ExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public ExpandableTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        expand();
        collapse();
        super.setOnClickListener(v -> {
            final ExpandableTextView etv = (ExpandableTextView) v;
            //toggle(etv);
        });
    }

    /**
     * @return is expanded or not
     */
    public Boolean isExpanded() {
        return mIsExpanded;
    }


    @Override
    public void setOnClickListener(OnClickListener l) {
        Log.e(TAG, "operation is not supported!");
    }

    /**
     * Toggle if it is expanded or not
     */
    public final void toggle() {
        toggle(this);
    }


    private void toggle(ExpandableTextView etv) {
        if (etv.isExpanded()) {
            Log.w(TAG, TAG + " is collapsed.");
            etv.collapse();
        } else {
            Log.w(TAG, TAG + " is expanded.");
            etv.expand();
        }
    }

    private void collapse() {
        mIsExpanded = false;
        setMaxLines(mMaxLine);
        postInvalidate();
        //The actual change is in onMeasure
    }

    private void expand() {
        mIsExpanded = true;
        if (mMaxLine == null) {
            storeMaxLine();
        }

        setEllipsize(null);
        setMaxLines(Integer.MAX_VALUE);
        // setText(mOriginalText);
        postInvalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (!mIsExpanded && null != mOriginalText) {
            final String sTruncatedText = TextUtils.ellipsize(mOriginalText.toString().replace('\n', ' ').replace('\t', ' '), getPaint(),
                    (getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight() - getPaint().measureText(mEllipsis)) * mMaxLine,
                    TextUtils.TruncateAt.END).toString();
            if (sTruncatedText.length() > 2 && !sTruncatedText.equals(mOriginalText.toString())) {
                SpannableStringBuilder ssb = new SpannableStringBuilder(sTruncatedText.trim(), 0, sTruncatedText.length() - 2);

                ssb.append(mEllipsis);
                setText(ssb.toString());
            }
        }
    }

    /**
     * Extract private maxLine from super class
     */
    private void storeMaxLine() {
        Field f;
        try {
            f = getClass().getSuperclass().getDeclaredField(sMaximumVarName);
            f.setAccessible(true);
            mMaxLine = f.getInt(this);

            f.setAccessible(false);
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
            //impossible
            Log.e(TAG, e.getMessage());
        }
    }


    public void resetText(CharSequence text) {
        mOriginalText = null;
        setText(text);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        if (mOriginalText == null) {
            mOriginalText = text;
        }
    }

    /**
     * @return the ellipsis
     */
    public String getEllipsis() {
        return this.mEllipsis;
    }


    public void setEllipsis(final String ellipsis) {
        this.mEllipsis = ellipsis;
    }

}