package com.xxxx.controller;

import java.util.UUID;

public class Test001 {
    public static void main(String[] args) {
        //产生UUID
        String uuid = UUID.randomUUID().toString();
        //展示一下
        System.out.println(uuid.replace("-",""));
    }
}
