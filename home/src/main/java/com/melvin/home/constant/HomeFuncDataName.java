package com.melvin.home.constant;

import java.util.ArrayList;
import java.util.List;

public class HomeFuncDataName {

    public static final String LIST = "列表";
    public static final String KEY_BOARD_OBSERVER= "监听软键盘弹起";
    public static final String EDITTEXT_LIST= "列表中有多个输入框";
    //主页功能
    public static List<String> funcList(){
        List<String> datas = new ArrayList<>();
        datas.add(LIST);
        datas.add(KEY_BOARD_OBSERVER);
        datas.add(EDITTEXT_LIST);
        return datas;
    }

}
