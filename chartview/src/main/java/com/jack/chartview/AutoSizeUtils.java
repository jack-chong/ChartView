package com.jack.chartview;

import java.lang.reflect.Field;

/**
 * 作者: jack(黄冲)
 * 邮箱: 907755845@qq.com
 * create on 2018/12/10 11:51
 */

public class AutoSizeUtils {

    /**
     * 适配小写c开头的Number类型字段
     * @param target
     */
    public static void autoSize(Object target){

        Field[] fields = target.getClass().getDeclaredFields();
        for (Field field : fields) {

            if (field.getName().charAt(0) != 'c'){
                continue;
            }

            field.setAccessible(true);
            Class<?> type = field.getType();
            try {
                if (type == int.class){
                    field.setInt(target, (int) (field.getInt(target) * DeviceInfo.sAutoScaleX));
                }
                if (type == float.class){
                    field.setFloat(target, field.getFloat(target) * DeviceInfo.sAutoScaleX);
                }
                if (type == double.class){
                    field.setDouble(target, field.getDouble(target) * DeviceInfo.sAutoScaleX);
                }
            }catch (Exception e){
                throw new IllegalStateException("适配出错: " + e.getLocalizedMessage());
            }

        }
    }
}
