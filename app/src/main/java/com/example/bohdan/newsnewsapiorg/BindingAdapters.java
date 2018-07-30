package com.example.bohdan.newsnewsapiorg;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BindingAdapters {



    @BindingAdapter("android:src")
    public static void loadImage(ImageView view, String string) {
        Picasso.get()
                .load(string)
                .into(view);
    }

    @BindingAdapter("bind:items")
    public static void listBindGridview (RecyclerView view, List<Article> articles){

        AdapterNew adapterNew = new AdapterNew(articles);
        view.setAdapter(adapterNew);
    }

}
