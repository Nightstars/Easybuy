package com.teamone.easybuy.util;

import com.google.gson.Gson;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String namesJson = "['xiaoqiang','chenrenxiang','hahaha']";
        Gson gson = new Gson();
        String[] nameArray = gson.fromJson(namesJson, String[].class);
        System.out.println(nameArray[1]);
        String[] str={"aa","bb","cc"};
        String jsonstr=gson.toJson(str);
        System.out.println(jsonstr);
    }
}
