package com.qbase.httpdemo.agent;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Create by qay on 2018/11/20
 */
public abstract class HttpCallBack<Result> implements ICallBack{

    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        Class<?> clazz = analysisClassInfo(this);
        Result objectResult = (Result)gson.fromJson(result,clazz);
        onSuccess(objectResult);
    }

    public abstract void onSuccess(Result result);

    public static Class<?> analysisClassInfo(Object object) {
        Type type = object.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType)type).getActualTypeArguments();
        return (Class<?>) params[0];
    }

}
