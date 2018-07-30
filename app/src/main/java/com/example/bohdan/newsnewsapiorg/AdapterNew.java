package com.example.bohdan.newsnewsapiorg;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bohdan.newsnewsapiorg.databinding.CustomBinding;

import java.util.List;

public class AdapterNew extends RecyclerView.Adapter<AdapterNew.ViewHolder> {


    public List<Article> articles;

    public AdapterNew(List<Article> articles)
    {
        this.articles = articles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CustomBinding customBinding = DataBindingUtil.inflate(LayoutInflater
                .from(parent.getContext()),R.layout.custom,parent,false);
        ViewHolder viewHolder = new ViewHolder(customBinding);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.customBinding.setModelFor(articles.get(position));


    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if (articles == null)
            return 0;
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public CustomBinding customBinding;

        public ViewHolder(CustomBinding customBinding) {
            super(customBinding.getRoot());
            this.customBinding = customBinding;
        }
    }

    }


