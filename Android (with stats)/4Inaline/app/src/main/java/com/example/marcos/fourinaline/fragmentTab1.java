package com.example.marcos.fourinaline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by marcos on 06/03/16.
 */
public class fragmentTab1 extends StatsActivity.PlaceholderFragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_stats1, container,false);
    }
}
