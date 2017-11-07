package edu.umbc.dmutlu1.chocolatecafedem;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LinkHandler
{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ImageView infoButton;
    private static ArrayList<Dessert> data;
    private String[] URLs;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycleView);
        infoButton = findViewById(R.id.infoButton);

        URLs = getResources().getStringArray(R.array.URLs);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        data = new ArrayList<>();
        for (int i = 0; i < DessertData.desserts.length; i++) {
            data.add(new Dessert(
                    DessertData.desserts[i],
                    DessertData.specials[i],
                    DessertData.drawableArray[i],
                    URLs[i]
            ));
        }

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(data, this);
        mRecyclerView.setAdapter(mAdapter);

        infoButton.setOnClickListener(view -> openLink(R.string.homepage_URL));
    }

    @Override
    public void openLink(int URL)
    {
        Intent openURL = new Intent();
        openURL.setAction(Intent.ACTION_VIEW);
        openURL.setData(Uri.parse(getResources().getString(URL)));
        startActivity(openURL);
    }

    @Override
    public void openLink(String URL)
    {
        Intent openURL = new Intent();
        openURL.setAction(Intent.ACTION_VIEW);
        openURL.setData(Uri.parse(URL));
        startActivity(openURL);
    }
}