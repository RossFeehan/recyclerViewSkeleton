package com.ross.feehan.recyclerviewskeleton;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    private Context ctx;
    @Bind(R.id.teamRV) RecyclerView teamRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ctx = this;
        ButterKnife.bind(this);

        displayRecyclerView();
    }

    private void displayRecyclerView(){
        List<String> teamNames = Arrays.asList(getResources().getStringArray(R.array.premierLeagueTeams));
        TypedArray teamBadges = getResources().obtainTypedArray(R.array.teamBadges);

        //Creating the layout of the recycler view (linearlayout creates a list view like recycler view)
        LinearLayoutManager recyclerViewLayoutManager = new LinearLayoutManager(ctx);
        teamRV.setLayoutManager(recyclerViewLayoutManager);

        //Creating the adapter for the recycler view, with the comments
        TeamRecyclerViewAdapter commentsAdapter = new TeamRecyclerViewAdapter(ctx, teamNames, teamBadges);
        teamRV.setAdapter(commentsAdapter);
    }
}
