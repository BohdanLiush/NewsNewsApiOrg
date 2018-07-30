package com.example.bohdan.newsnewsapiorg;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    public final String URL = "https://newsapi.org/v2/";

    public Thread loadObjectThread;
    public Call<Model> idsCall;
    public Model model;

    public String s = "";

    public void loadStringFromMain(String string) throws InterruptedException {
        s = string;
        getIDSFromWeb();
    }

    public void getIDSFromWeb() throws InterruptedException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ModelApi idsApi = retrofit.create(ModelApi.class);

        idsCall = idsApi.idsInfo(s);

        /*idsCall.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                model = response.body();
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });*/

        loadObjectThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    model = idsCall.execute().body();
                    System.out.println("Look: ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        loadObjectThread.start();
        loadObjectThread.join();
    }

}
