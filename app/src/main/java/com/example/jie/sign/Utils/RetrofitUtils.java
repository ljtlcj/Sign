package com.example.jie.sign.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/**
 * =====作者=====
 * lcj yx
 * =====时间=====
 * 2018/4/14.
 */
public class RetrofitUtils {

    private static final String ObjectUrl = "http://120.77.211.48/sign/index.php/Sign/";
    private static Retrofit retrofit = null;
    private static IRetrofitServer iServer;

    public static IRetrofitServer getInstance() {
        if (retrofit == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(ObjectUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    iServer = retrofit.create(IRetrofitServer.class);
                }
            }
        }
        return iServer;
    }

    public static List<MultipartBody.Part> filesToMultipartBodyParts(String key, List<String> filePaths) {
        List<MultipartBody.Part> parts = new ArrayList<>(filePaths.size());
        for (String filePath : filePaths) {
            File file = new File(filePath);
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
            MultipartBody.Part part = MultipartBody.Part.createFormData(key, file.getName(), requestBody);
            parts.add(part);
        }
        return parts;
    }

    public static RequestBody convertToRequestBody(String param) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), param);
        return requestBody;
    }

    public interface IRetrofitServer {
        //展示会议信息
        @Multipart
        @POST("Conference/membermeeting2")
        Call<ResponseBody> membermeeting2(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        @Multipart
        @POST("Conference/all_member2")
        Call<ResponseBody> all_member2(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        @Multipart
        @POST("Conference/arrival_member2")
        Call<ResponseBody> arrival_member2(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        @Multipart
        @POST("Conference/non_arrival_member2")
        Call<ResponseBody> non_arrival_member2(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //添加会议-人员选择
        @Multipart
        @POST("Conference/member_and_group2")
        Call<ResponseBody> member_and_group2(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        @Multipart
        @POST("Conference/meeting_add2")
        Call<ResponseBody> meeting_add2(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //会场管理-会议室使用
        @Multipart
        @POST("Roommain/memberview2")
        Call<ResponseBody> memberview2(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //会场管理-会场管理主页面
        @Multipart
        @POST("Roommain/memberdel2")
        Call<ResponseBody> memberdel2(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);
    }
}
