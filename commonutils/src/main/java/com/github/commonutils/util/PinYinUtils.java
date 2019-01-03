package com.github.commonutils.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 汉字转拼音
 *
 * @author wuyun
 * @date 2019/1/3 19:39
 */
public class PinYinUtils {

    /**
     * 将汉字转换为全拼
     * @param src
     * @return
     */
    public static String getPinYin(String src){
        char[] hz = src.trim().toCharArray();
        //该数组用来存储
        String[] py;
        //设置汉字拼音输出的格式
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        // 输出拼音全部小写
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        // 不带声调
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);

        //存放拼音字符串
        String pys = "";
        int len = hz.length;

        try {
            for (int i = 0; i < len ; i++ ){
                //先判断是否为汉字字符
                if(Character.toString(hz[i]).matches("[\\u4E00-\\u9FA5]+")){
                    //取出该汉字全拼的第一种读音，并存放到字符串pys后
                    pys += PinyinHelper.toHanyuPinyinStringArray(hz[i],format)[0];
                }else{
                    //如果不是汉字字符，间接取出字符并连接到 pys 后
                    pys += hz[i];
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e){
            e.printStackTrace();
        }
        return pys;
    }

    /**
     * 提取每个汉字的首字母
     * @param str
     * @return
     */
    public static String getPinYinHeadChar(String str){
        String convert = "";
        for (int i = 0; i < str.length(); i++) {
            char word = str.charAt(i);
            //提取汉字的首字母
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null){
                convert += pinyinArray[0].charAt(0);
            }else{
                convert += word;
            }
        }
        return convert.toUpperCase();
    }


    /**
     * 测试
     */
    public static void main(String[] args) {
        String str = "中国梦ChainDream2018";
        System.out.println(getPinYin(str));
        System.out.println(getPinYinHeadChar(str));
    }
}

