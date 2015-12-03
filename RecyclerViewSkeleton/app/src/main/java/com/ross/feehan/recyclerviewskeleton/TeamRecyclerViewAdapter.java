package com.ross.feehan.recyclerviewskeleton;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ross Feehan on 03/12/2015.
 * Copyright Ross Feehan
 */
public class TeamRecyclerViewAdapter extends RecyclerView.Adapter<TeamRecyclerViewAdapter.TeamViewHolder>{

    private static Context ctx;
    private static List<String> teamNames;
    private TypedArray teamBadges;

    //Constructor
    public TeamRecyclerViewAdapter(Context ctx, List<String> teamNames, TypedArray teamBadges){
        this.ctx = ctx;
        this.teamNames = teamNames;
        this.teamBadges = teamBadges;
    }

    public static void handleClick(int positionClicked){
        Toast.makeText(ctx, teamNames.get(positionClicked), Toast.LENGTH_SHORT).show();
    }

    /*Method that creates and returns an instance of TeamViewHolder and inflates the correct layout
     */
    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.team_card_layout, viewGroup, false);
        TeamViewHolder teamViewHolder = new TeamViewHolder(view, ctx);
        return teamViewHolder;
    }


    /*Method that populates the views with the correct information
     */
    @Override
    public void onBindViewHolder(TeamViewHolder teamViewHolder, int i) {

        teamViewHolder.teamNameTV.setText(teamNames.get(i));
        teamViewHolder.teamBadgeIV.setImageDrawable(teamBadges.getDrawable(i));
    }

    /*Method that returns the size of the items to be added to the recycler view
     */
    @Override
    public int getItemCount() {
        return teamNames.size();
    }

    /*Private class that holds the layout for the card view
     *Uses the view holder pattern
     */
    public static class TeamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Context ctx;
        @Bind(R.id.teamNameTV) protected TextView teamNameTV;
        @Bind(R.id.teamBadgeIV) protected ImageView teamBadgeIV;

        public TeamViewHolder(View itemView, Context ctx) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.ctx = ctx;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            handleClick(getAdapterPosition());
        }
    }
}
