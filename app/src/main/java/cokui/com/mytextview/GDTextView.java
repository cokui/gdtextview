package cokui.com.mytextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * 信息显示， 支持字体设置
 */
public class GDTextView extends TextView implements View.OnClickListener {

    /** 支持显示包含中文和英文的array，使用GDTextView时，可以设置全局使用的是否显示array中中文
     * array下标为0代表中文，下标为1代表英文
     * @Link setGDText(int stringArrayId)
     */
    public static boolean isChineseLang = true;

    private OnClickListener mClickListener;
    private String mTypeFace;
    private Context mContext;


    public GDTextView(Context context) {
        this(context, null);
    }

    public GDTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GDTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.GDTextView);
        final int type = array.getInt(R.styleable.GDTextView_text_typeface, 0);
        if (type > 0) {
            mTypeFace = GDTypefactUtils.getTypefaceName(context, type);
            Typeface face = GDTypefactUtils.getTypeface(context, mTypeFace);
            setTypeface(face);
        }
        array.recycle();
        init(context);
    }

    public void setTypeFace(String typeFace) {
        mTypeFace = typeFace;
        setTypeface(GDTypefactUtils.getTypeface(getContext(), typeFace));
    }


    private void init(Context ctx) {
        mContext = ctx;
    }

    public void setSpannableString(SpannableString sp) {
        super.setText(sp);
    }

    public void setGDText(CharSequence text) {
        if (text == null) {
            return;
        }
        setGDText(text.toString());
    }


    public void setGDText(String text) {
        if (text == null) {
            return;
        }
        super.setText(text);
    }

    /**
     * 传入中英文显示样式Array数组
     * @param stringArrayId
     */
    public void setLangsArray(int stringArrayId){
        if(stringArrayId<=0){
            return;
        }
        String[] textLangs = mContext.getResources().getStringArray(stringArrayId);
        String text = "";
        if (textLangs != null && textLangs.length == 2) {
            if (isChineseLang) {
                text = textLangs[0];
            } else {
                text = textLangs[1];
            }
        }
        super.setText(text);

    }

    public void setGDText(String text, String typeface) {
        if (text == null) {
            return;
        }
        if (!TextUtils.isEmpty(text)) {
            mTypeFace = typeface;
            Typeface tf = GDTypefactUtils.getTypeface(mContext, typeface);
            if (tf != null)
                setTypeface(tf);
        }
        super.setText(text);
    }

    @Override
    public void setOnClickListener(OnClickListener listener) {
        mClickListener = listener;
        super.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
     if (mClickListener != null) {
            mClickListener.onClick(v);
        }
    }

}