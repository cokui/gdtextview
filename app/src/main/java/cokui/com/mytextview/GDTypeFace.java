package cokui.com.mytextview;

/**
 * 关联属性{@link } type需要和属性值对应，不可随意更改
 */
public enum GDTypeFace {
    TIMES_NEW_ROMAN_REGULAR(1, "times_new_roman_regular", "fonts/Times_New_Roman_Regular.ttf"),

    TIMES_NEW_ROMAN_ITALIC(2, "times_new_roman_italic", "fonts/Times_New_Roman_Italic.ttf"),


    SONGTI(3, "songti", "fonts/SongTi.ttf");

    private String mPath = "fonts/Times_New_Roman_Regular.ttf";
    private String mName = "times_new_roman_regular";
    private int mType = 1;

    private GDTypeFace(int type, String name, String path) {
        mType = type;
        mPath = path;
        mName = name;
    }

    public String getPath() {
        return this.mPath;
    }

    public String getName() {
        return mName;
    }

    public int getType() {
        return mType;
    }
}
