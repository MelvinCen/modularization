package com.melvin.home.constant;

import java.util.ArrayList;
import java.util.List;

public class ListFuncData {
    private static final String L_RECYCLERVIEW = "l_recyclerview";
    //主页功能
    public static List<String> funcList(){
        List<String> datas = new ArrayList<>();
        datas.add(L_RECYCLERVIEW);
        return datas;
    }
}
