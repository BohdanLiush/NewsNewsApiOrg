package com.example.bohdan.newsnewsapiorg;

public class CallbackClass {

    interface Callback {

        Model callingBack(String string) throws InterruptedException;


    }

    public Callback callback;

    public void registerCallBack(Callback callback){
        this.callback = callback;
    }

    Model loadObject(String string) throws InterruptedException {
        return callback.callingBack(string);
    }
}
