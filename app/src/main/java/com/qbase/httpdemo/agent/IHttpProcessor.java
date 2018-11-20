package com.qbase.httpdemo.agent;

import java.util.Map;

/**
 * Create by qay on 2018/11/20
 */
public interface IHttpProcessor {

    //网络访问  post,get,del,update,


    void post(String url, Map<String,Object> params,ICallBack callBack);


    void get(String url,Map<String,Object> params,ICallBack callBack);


}
