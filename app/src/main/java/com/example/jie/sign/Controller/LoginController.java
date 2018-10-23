package com.example.jie.sign.Controller;

import android.content.Context;
import android.util.Log;

import com.example.jie.sign.Manager.InterfaceManger;
import com.example.jie.sign.R;
import com.example.jie.sign.Utils.RetrofitUtils;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jie on 2018/9/7.
 */

public class LoginController {

    private static Context context;

    public LoginController(Context context) {
        this.context = context;
    }

    public static void membermeeting2(Map<String, RequestBody> map, List<MultipartBody.Part> parts, final InterfaceManger.OnRequestListener listener) {
        Call<ResponseBody> call = RetrofitUtils.getInstance().membermeeting2(map, parts);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (listener == null) {
                    return;
                }
                if (!response.isSuccessful() || response == null) {
                    listener.onError(String.valueOf(response.code()));
                    return;
                }
                try {
                    String body = response.body().string();
                    Object object = body;
                    if (!body.contains("error")) {
                        listener.onSuccess(object);
                    } else {
                        listener.onError("");
                    }
                } catch (Exception e) {
                    listener.onError(e.toString());
                    e.printStackTrace();
                }
                listener.onComplete();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (listener == null) {
                    return;
                }
                Log.e("onFailure", t.toString());
                if (t.toString().contains("ConnectException")) {
                    listener.onError("网络异常");
                } else {
                    listener.onError("网络异常");
                }
                listener.onComplete();
            }
        });
    }
}
