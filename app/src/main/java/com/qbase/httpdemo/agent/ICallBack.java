package com.qbase.httpdemo.agent;

/**
 * Create by qay on 2018/11/20
 */
public interface ICallBack {
    void onSuccess(String result);
    void onFailure(String e);
}
