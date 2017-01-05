package com.weixingwang.threepomelo.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class OkHttpUtils {
    private Handler handler;
    private OkHttpClient okHttpClient;

    private OkHttpUtils() {
        handler = new Handler(Looper.getMainLooper());
        okHttpClient = new OkHttpClient.Builder()
                .build();
    }

    private static OkHttpUtils ok;

    public static OkHttpUtils getInstence() {
        if (ok == null) {
            synchronized (OkHttpUtils.class) {
                if (ok == null) {
                    ok = new OkHttpUtils();
                }
            }
        }
        return ok;
    }

    //异步get无参
    private void getP_A(String url, String token, Class<?> clazz, final CallBackUtils callBack) throws IOException {
        if (!TextUtils.isEmpty(token)) {
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Token", token)
                    .build();
            Call call = okHttpClient.newCall(request);
            requestCall(callBack, call, clazz);
        } else {
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Call call = okHttpClient.newCall(request);
            requestCall(callBack, call, clazz);
        }
    }

    //异步get有参
    private void getP_A_S(String url, String token, Class<?> clazz, final CallBackUtils callBack,HashMap<String,String> prams) throws IOException {
        FormBody.Builder builder = new FormBody.Builder();
        if (prams != null) {
            Set<Map.Entry<String, String>> entries = prams.entrySet();
            Iterator<Map.Entry<String, String>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                String key = entry.getKey();
                String value = entry.getValue();
                builder.add(key, value);
            }
        }
        if (!TextUtils.isEmpty(token)) {
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Token", token)
                    .build();
            Call call = okHttpClient.newCall(request);
            requestCall(callBack, call, clazz);
        } else {
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Call call = okHttpClient.newCall(request);
            requestCall(callBack, call, clazz);
        }


    }
    //异步post有参
    private void postP_A_D(String url, String token, Class<?> clazz, final CallBackUtils callback, HashMap<String, String> prams) throws IOException {
        FormBody.Builder builder = new FormBody.Builder();
        if (prams != null) {
            Set<Map.Entry<String, String>> entries = prams.entrySet();
            Iterator<Map.Entry<String, String>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                String key = entry.getKey();
                String value = entry.getValue();
                builder.add(key, value);
            }
        }
        if (TextUtils.isEmpty(token)) {
            Request request = new Request.Builder()
                    .url(url)
                    .post(builder.build())
                    .build();
            Call call = okHttpClient.newCall(request);
            requestCall(callback, call, clazz);
        } else {
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Token", token)
                    .post(builder.build())
                    .build();
            Call call = okHttpClient.newCall(request);
            requestCall(callback, call, clazz);
        }

    }

    //图片上传
    private void putImage(String url, String token, Class<?> clazz, HashMap<String,File> map, final CallBackUtils callBack, HashMap<String, String> prams) {
        MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (prams != null) {
            Set<Map.Entry<String, String>> entrySet = prams.entrySet();
            Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                builder.addFormDataPart(entry.getKey(), entry.getValue());
            }
        }
        if(map !=null){
            Set<Map.Entry<String, File>> entries = map.entrySet();
            Iterator<Map.Entry<String, File>> iterator = entries.iterator();
            while (iterator.hasNext()){
                Map.Entry<String, File> next = iterator.next();
                RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"),  next.getValue());
                String name = next.getKey();
                builder.addFormDataPart(name,name+".png", fileBody);
            }
        }
            if (TextUtils.isEmpty(token)) {
                Request request = new Request.Builder()
                        .url(url)
                        .post(builder.build())
                        .build();
                Call call = okHttpClient.newCall(request);
                requestCall(callBack, call, clazz);
            } else {
                Request request = new Request.Builder()
                        .url(url)
                        .addHeader("Token", token)
                        .post(builder.build())
                        .build();
                Call call = okHttpClient.newCall(request);
                requestCall(callBack, call, clazz);
            }


    }

    //上传数组
    private void putArray(String url, String token, Class<?> clazz, HashMap<String,String> map,
                          final CallBackUtils callBack, HashMap<String, String> prams) {

        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (prams != null) {
            Set<Map.Entry<String, String>> entrySet = prams.entrySet();
            Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                builder.addFormDataPart(entry.getKey(), entry.getValue());
            }
        }

        if(map !=null){
            Set<Map.Entry<String, String>> entries = map.entrySet();
            Iterator<Map.Entry<String, String>> iterator = entries.iterator();
            while (iterator.hasNext()){
                Map.Entry<String, String> next = iterator.next();
                String name = next.getKey();
                builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + name.replaceAll("\\[\\d+\\]", "") + "\""),
                        RequestBody.create(null, next.getValue()));
            }
        }
        if (TextUtils.isEmpty(token)) {
            Request request = new Request.Builder()
                    .url(url)
                    .post(builder.build())
                    .build();
            Call call = okHttpClient.newCall(request);
            requestCall(callBack, call, clazz);
        } else {
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Token", token)
                    .post(builder.build())
                    .build();
            Call call = okHttpClient.newCall(request);
            requestCall(callBack, call, clazz);
        }


    }


    //文件上传
//    private void putFile(String url,List<File> list,CallBackFile callBack){
//        MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
//        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
//        if(list.size()>0){
//            for (int i = 0; i <list.size() ; i++) {
//                RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream") , list.get(i));
//                String name = "file"+i+".txt";
//                builder.addFormDataPart("file",name,fileBody);
//                OkHttpClient ok = new OkHttpClient();
//                Request request = new Request.Builder()
//                        .url(url)
//                        .post(builder.build())
//                        .build();
//                Call call = okHttpClient.newCall(request);
//                putCall(callBack, call);
//            }
//        }
//    }
    //文件上传加参数
    private void putFile(String url, String token, Class<?> clazz, List<File> list, CallBackUtils callBack, HashMap<String, String> prams) {
        MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (prams != null) {
            Set<Map.Entry<String, String>> entrySet = prams.entrySet();
            Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                builder.addFormDataPart(entry.getKey(), entry.getValue());
            }
        }
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), list.get(i));
                String name = "file" + i + ".txt";
                builder.addFormDataPart("file", name, fileBody);

            }
            if (TextUtils.isEmpty(token)) {
                Request request = new Request.Builder()
                        .url(url)
                        .post(builder.build())
                        .build();
                Call call = okHttpClient.newCall(request);
                requestCall(callBack, call, clazz);
            } else {
                Request request = new Request.Builder()
                        .url(url)
                        .addHeader("Token", token)
                        .post(builder.build())
                        .build();
                Call call = okHttpClient.newCall(request);
                requestCall(callBack, call, clazz);
            }
        }
    }

//    private void putCall(final CallBackUtils callBack, Call call) {
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                final Exception ex = e;
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        callBack.error(ex);
//                    }
//                });
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        callBack.sucess("上传成功");
//                    }
//                });
//            }
//        });
//    }


    private void requestCall(final CallBackUtils callback, Call call, final Class<?> clazz) {
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                final IOException ex = e;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.error(ex);
                    }
                });

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                String string = response.body().string();
                Log.e("1", "stringJson=" + string);
                Gson gson = new Gson();
                final Object fromJson = gson.fromJson(string, clazz);
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        callback.sucess(fromJson);
                    }
                });

            }
        });
    }

    //get有参请求
    public static void get_Data(String url, String token, Class<?> clazz, CallBackUtils call,HashMap<String,String> prams) {
        try {
            getInstence().getP_A_S(url, token, clazz, call,prams);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //无参请求
    public static void get(String url, String token, Class<?> clazz, CallBackUtils call) {
        try {
            getInstence().getP_A(url, token, clazz, call);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //有参请求
    public static void get(String url, String token, Class<?> clazz, CallBackUtils call, HashMap<String, String> prams) {
        try {
            getInstence().postP_A_D(url, token, clazz, call, prams);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //图片无参上传
    public static void putImages(String url, String token, Class<?> clazz, HashMap<String,File> map, CallBackUtils call) {
        getInstence().putImage(url, token, clazz, map, call, null);
    }

    //图片有参上传
    public static void putImages(String url, String token, Class<?> clazz, HashMap<String,File> map, CallBackUtils call, HashMap<String, String> prams) {
        getInstence().putImage(url, token, clazz, map, call, prams);
    }

    //文件无参上传
    public static void putFiles(String url, String token, Class<?> clazz, List<File> list, CallBackUtils call) {
        getInstence().putFile(url, token, clazz, list, call, null);
    }

    //文件有参上传
    public static void putFiles(String url, String token, Class<?> clazz, List<File> list, CallBackUtils call, HashMap<String, String> prams) {
        getInstence().putFile(url, token, clazz, list, call, prams);
    }
    //上传数组
    public static void putStringArray(String url, String token, Class<?> clazz, HashMap<String,String> map, CallBackUtils call, HashMap<String, String> prams) {
        getInstence().putArray(url,token,clazz,map,call,prams);
    }


    public interface CallBackUtils {
        void sucess(Object obj);

        void error(Exception e);
    }

//    public interface CallBackFile {
//        void sucess(String obj);
//
//        void error(Exception e);
//    }

    public static void closeHttp(){
        getInstence().okHttpClient.dispatcher().cancelAll();
    }
}
