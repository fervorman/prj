package skns.com.mobile.Common.Network;

import android.content.Context;
import android.util.Log;


import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import skns.com.mobile.Activity.BaseActivity;

/**
 * Created by jungbaepark on 2017. 4. 3..
 * 통신 , 파싱 관련 처리
 */


public class HttpManger {

    Context c;

    public HttpManger(Context c ) {
        this.c = c;
    }

    HttpInterface hInterface;

    public void requestAPI(String url, final BaseActivity b, RequestBody formBody, HttpInterface h) {
        b.showLoading();
        OkHttpClient client = new OkHttpClient();
        Request request;
        hInterface = h;

        if (formBody == null) {
            request = new Request.Builder()
                    .url(url)
                    .build();
        } else {
            request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();
        }


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final  IOException e) {
                b.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        b.goneLoading();
                        b.showErrorAPI(e.toString());

                    }
                });

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String body = response.body().string().toString();
                b.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (!response.isSuccessful()) {
                            b.showErrorAPI(body.toString());
                        } else {
                            if (hInterface != null) {
                                hInterface.onSuccess(body);
                            }
                        }
                        b.goneLoading();
                    }
                });
            }
        });

    }

}
