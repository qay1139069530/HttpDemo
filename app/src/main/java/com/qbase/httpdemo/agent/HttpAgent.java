package com.qbase.httpdemo.agent;


import java.util.HashMap;
import java.util.Map;

/**
 * Create by qay on 2018/11/20
 * 代理实现
 */
public class HttpAgent implements IHttpProcessor{

    private static IHttpProcessor mIHttpProcessor = null;

    private Map<String, Object> mParmas;

    private static volatile HttpAgent instance;

    public static HttpAgent getInstance() {
        if (instance == null) {
            synchronized (HttpAgent.class) {
                if (instance == null) {
                    instance = new HttpAgent();
                }
            }
        }
        return instance;
    }

    public HttpAgent() {
        mParmas = new HashMap<>();
    }

    public static void init(IHttpProcessor httpProcessor) {
        mIHttpProcessor = httpProcessor;
    }


    @Override
    public void post(String url, Map<String, Object> params, ICallBack callBack) {

        final String finalUrl = appendParams(url,params);
        mIHttpProcessor.post(finalUrl,params,callBack);
    }



    @Override
    public void get(String url, Map<String, Object> params, ICallBack callBack) {
        final String finalUrl = appendParams(url,params);
        mIHttpProcessor.get(finalUrl,params,callBack);
    }

    /**返回拼接url*/
    private String appendParams(String url, Map<String, Object> params) {

        return url;
    }
    
}
