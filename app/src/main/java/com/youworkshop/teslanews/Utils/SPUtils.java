package com.youworkshop.teslanews.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Tony on 2017/12/8.
 */

public class SPUtils {
    //这个工具类主要是在data/data/下保存一个config 文件 存入 & 判断 是否要加载guide界面  get 和 save
    //如果是第一次要拿到是否要加载  加载时候 记得存成false 下次直接进入HomeActivity
    public static SharedPreferences sharedPreferences;

     public static boolean getGuideBoolean(Context context,String key,boolean keyBoolean){
         if (sharedPreferences == null){
             sharedPreferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
         }
         return  sharedPreferences.getBoolean(key,keyBoolean);
     }
     public static boolean saveGuideBoolean(Context context,String key,boolean value){
         if (sharedPreferences == null){
             sharedPreferences = context.getSharedPreferences("config",Context.MODE_PRIVATE);
         }
         return sharedPreferences.edit().putBoolean(key,value).commit();
     }
}

