package com.example.listawear;

import android.app.Activity;
import android.os.Bundle;

import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private List<ItemsList> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WearableRecyclerView recyclerView = (WearableRecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setEdgeItemsCenteringEnabled(true);

        WearableLinearLayoutManager layoutManager = new WearableLinearLayoutManager(this);
        layoutManager.setOrientation(WearableLinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        items.add(new ItemsList(R.mipmap.ic_launcher,"Flutter"));
        items.add(new ItemsList(R.mipmap.ic_launcher,"PHP"));
        items.add(new ItemsList(R.mipmap.ic_launcher,"JavaScript"));


        ListAdapter listAdapter = new ListAdapter(items);

        recyclerView.setAdapter(listAdapter);

    }
}