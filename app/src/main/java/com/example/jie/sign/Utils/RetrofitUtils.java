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

    private static final String ObjectUrl = "http://120.77.211.48/WooLock.php/Home/";
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
        //登录接口
        @Multipart
        @POST("User/login")
        Call<ResponseBody> login(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //验证手机号是否存在接口
        @Multipart
        @POST("User/isexist")
        Call<ResponseBody> isexist(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //获取账号所拥有的所有门锁接口
        @Multipart
        @POST("lock/ReadAllLock")
        Call<ResponseBody> ReadAllLock(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //修改相对应门锁的地址
        @Multipart
        @POST("Lock/SetLockAddress")
        Call<ResponseBody> SetLockAddress(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //修改相对应门锁的名称
        @Multipart
        @POST("lock/changeLockName")
        Call<ResponseBody> changeLockName(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //发送密码
        @Multipart
        @POST("Lock/GetLockPassword")
        Call<ResponseBody> GetLockPassword(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //发送权限的接口
        @Multipart
        @POST("lock/GiveLock")
        Call<ResponseBody> GiveLock(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //获得授权信息的接口
        @Multipart
        @POST("lock/ReadGive")
        Call<ResponseBody> ReadGive(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //删除授权的接口
        @Multipart
        @POST("lock/cancelGive")
        Call<ResponseBody> cancelGive(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //查看开锁记录
        @Multipart
        @POST("Lock/GetOpenLog")
        Call<ResponseBody> GetOpenLog(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //获取验证码
        @Multipart
        @POST("user/GetVerifyCode")
        Call<ResponseBody> GetVerifyCode(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //验证验证码
        @Multipart
        @POST("user/VerifyCode")
        Call<ResponseBody> VerifyCode(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //注册账号接口
        @Multipart
        @POST("User/signUp")
        Call<ResponseBody> signUp(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //修改密码接口
        @Multipart
        @POST("user/forgetPassword")
        Call<ResponseBody> forgetPassword(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //上传开锁记录
        @Multipart
        @POST("lock/OpenLock")
        Call<ResponseBody> OpenLock(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //上传电量
        @Multipart
        @POST("lock/UpdateLockPower")
        Call<ResponseBody> UpdateLockPower(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //激活门锁
        @Multipart
        @POST("Lock/activeLock")
        Call<ResponseBody> activeLock(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //添加门锁
        @Multipart
        @POST("Lock/addLock")
        Call<ResponseBody> addLock(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //上传恢复出厂密码成功
        @Multipart
        @POST("Lock/SetRestore")
        Call<ResponseBody> SetRestore(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //删除门锁
        @Multipart
        @POST("lock/deleteLock")
        Call<ResponseBody> deleteLock(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //获取电量
        @Multipart
        @POST("Lock/GetLockBattery")
        Call<ResponseBody> GetLockBattery(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

        //获取版本号
        @Multipart
        @POST("Lock/getApkVersion")
        Call<ResponseBody> getApkVersion(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

    }
}
