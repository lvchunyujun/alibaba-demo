package com.hexiaofei.nacosdemo.utils;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author hexiaofei
 * @date 2022-05-20 22:31
 * @since
 */
public class MainUtils {

    public static void main(String[] args) {
//        System.out.println(IPSeeker.getInstance().getAddress("39.144.96.137"));
//        System.out.println(IPSeeker.getInstance().getArea("39.144.96.137"));
//        System.out.println(IPSeeker.getInstance().getIPEntries("深圳"));


        List<String[]> list = new ArrayList();

        String[] ss = {"zhangsan","787788"};

        list.add(ss);

        System.out.println(JSONObject.toJSONString(list));


        String pattern = "^(888|588|688|468|568|668|768|868|968)[0-9]{9}$|^(11|22)[0-9]{10}$|^(STO)[0-9]{10}$|^(37|33|11|22|44|55|66|77|88|99)[0-9]{11,13}$|^(4)[0-9]{11}$";

        String content = "7770790420944";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }
}
