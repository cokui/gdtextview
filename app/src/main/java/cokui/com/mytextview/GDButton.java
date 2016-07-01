package cokui.com.mytextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Button;

/**
 */
public class GDButton extends Button {
    private String mTypeFace = GDTypeFace.TIMES_NEW_ROMAN_REGULAR.getName();
    private Context mContext;


    public GDButton(Context context) {
        super(context);
    }

    public GDButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initStyle(context, attrs);
    }

    public GDButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initStyle(context, attrs);
    }

    private void initStyle(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.GDTextView);
        final int type = array.getInt(R.styleable.GDTextView_text_typeface, GDTypeFace.TIMES_NEW_ROMAN_REGULAR.getType());
        mTypeFace = GDTypefactUtils.getTypefaceName(context, type);
        Typeface face = GDTypefactUtils.getTypeface(context, mTypeFace);
        setTypeface(face);
        init(context);
    }

    public void setTypeFace(String typeFace) {
        mTypeFace = typeFace;
    }


    private void init(Context ctx) {
        mContext = ctx;
    }

    public void setSpannableString(SpannableString sp) {
        super.setText(sp);
    }

    public void setGDText(CharSequence text) {
        setGDText(text.toString());
    }


    public void setGDText(String text) {
        super.setText(text);
    }

    public void setGDText(String text, String typeface) {
        if (!TextUtils.isEmpty(text) && typeface != mTypeFace) {
            mTypeFace = typeface;
            Typeface tf = GDTypefactUtils.getTypeface(mContext, typeface);
            if (tf != null)
                setTypeface(tf);
            setTypeface(tf);
        }
        super.setText(text);
    }


}
