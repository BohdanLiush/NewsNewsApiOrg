package com.example.bohdan.newsnewsapiorg;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable, CallbackClass.Callback{


    NetworkManager networkManager = new NetworkManager();
    FirstFragment firstFragment = new FirstFragment();
    public String s = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment();
    }

    public void loadFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, firstFragment);
        fragmentTransaction.commit();
    }


    @Override
    public Model callingBack(String string) throws InterruptedException {
        networkManager.loadStringFromMain(string);
        return networkManager.model;
    }
}
