package cokui.com.mytextview;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class GDTypefactUtils {

    private static Map<String,Typeface> sTypefaceMap = new HashMap<>();

    public static Typeface getTypeface(Context context,String name){

        GDTypeFace  tFace = GDTypeFace.TIMES_NEW_ROMAN_REGULAR;
        if(name.equals(GDTypeFace.TIMES_NEW_ROMAN_REGULAR.getName())){
            tFace = GDTypeFace.TIMES_NEW_ROMAN_REGULAR;
        }else if(name.equals(GDTypeFace.TIMES_NEW_ROMAN_ITALIC.getName())){
            tFace = GDTypeFace.TIMES_NEW_ROMAN_ITALIC;
        }else if(name.equals(GDTypeFace.SONGTI.getName())){
            tFace = GDTypeFace.SONGTI;
        }
        if(sTypefaceMap.containsKey(tFace.getName())){
            return sTypefaceMap.get(tFace.getName());
        }else {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(),tFace.getPath());
            sTypefaceMap.put(tFace.getName(),typeface);
            return typeface;
        }
    }


    public static Typeface getTypeface(Context context,int type){

        GDTypeFace  tFace = GDTypeFace.TIMES_NEW_ROMAN_REGULAR;
        if(type == GDTypeFace.TIMES_NEW_ROMAN_REGULAR.getType()){
            tFace = GDTypeFace.TIMES_NEW_ROMAN_REGULAR;
        }else if(type == GDTypeFace.TIMES_NEW_ROMAN_ITALIC.getType()){
            tFace = GDTypeFace.TIMES_NEW_ROMAN_ITALIC;
        }else if(type == GDTypeFace.SONGTI.getType()){
            tFace = GDTypeFace.SONGTI;
        }
        if(sTypefaceMap.containsKey(tFace.getName())){
            return sTypefaceMap.get(tFace.getName());
        }else {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(),tFace.getPath());
            sTypefaceMap.put(tFace.getName(),typeface);
            return typeface;
        }
    }

    public static String getTypefaceName(Context context,int type){

        GDTypeFace  tFace = GDTypeFace.TIMES_NEW_ROMAN_REGULAR;
        if(type == GDTypeFace.TIMES_NEW_ROMAN_REGULAR.getType()){
            tFace = GDTypeFace.TIMES_NEW_ROMAN_REGULAR;
        }else if(type == GDTypeFace.TIMES_NEW_ROMAN_ITALIC.getType()){
            tFace = GDTypeFace.TIMES_NEW_ROMAN_ITALIC;
        }else if(type == GDTypeFace.SONGTI.getType()){
            tFace = GDTypeFace.SONGTI;
        }

        return tFace.getName();
    }
}
