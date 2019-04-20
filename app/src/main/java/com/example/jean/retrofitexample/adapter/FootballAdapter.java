package com.example.jean.retrofitexample.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jean.retrofitexample.R;
import com.example.jean.retrofitexample.model.Player;
import com.example.jean.retrofitexample.model.PlayerData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class FootballAdapter extends RecyclerView.Adapter<FootballAdapter.FootBallViewHolder> {

    //4
    private ArrayList<PlayerData> playerDataList;
   // private Context mContext;
    private RecyclerItemClickListener recyclerItemClickListener;

    public FootballAdapter(ArrayList<PlayerData> playerDataList, RecyclerItemClickListener recyclerItemClickListener) {
        this.playerDataList = playerDataList;
        // this.mContext = mContext;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }
   //  @NonNull

    @Override
    public FootBallViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = LayoutInflater.inflate(R.layout.item_gambar, parent, false);
        return new FootBallViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FootBallAdapter.FootBallViewHolder holder, int position) {

        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFEDD3"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

        holder.txt_nama.setText(playerDataList.get(position).getNama());
        holder.txt_age.setText(playerDataList.get(position).getAge());
        final String marsPhotoURL = playerDataList.get(position).getImgSrc();
        Picasso.get()
                .load(marsPhotoURL)
                .into(holder.img_gambar);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
                  recyclerItemClickListener.onItemClick(gambarURL);
        });
    }

                /*@Override
                public void onClick(View view) {
                    recyclerItemClickListener.onItemClick(marsPhotoURL);
                }
            });
        }

      /*Glide.with(mContext)
                    .load(marsPhotoURL)
                    .into(holder.imageViewMarsPhoto);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerItemClickListener.onItemClick(marsPhotoURL);

        //11
       /* PlayerData data = playerDataList.get(position);

        Glide.with(mContext)
                .load(data.getGambar())
                .into(holder.img_gambar);

        holder.txt_nama.setText(data.getNama());
        holder.txt_age.setText(data.getAge());
    }*/

    @Override
    public int getItemCount() {
        if(playerDataList != null)
        return playerDataList.size();
    else
        return 0;
    }


  class FootBallViewHolder extends RecyclerView.ViewHolder{

      CardView cardview;
      TextView txt_nama;
      TextView txt_age;
      ImageView img_gambar;

      FootBallViewHolder (View itemView){
            super(itemView);

            //6
            cardview =  itemView.findViewById(R.id.cardView);
            txt_nama=  itemView.findViewById(R.id.nama);
            txt_age = itemView.findViewById(R.id.age);
            img_gambar = itemView.findViewById(R.id.img_gambar);
        }

   }
}

   /* @NonNull
    @Override
    public FootballAdapter.FootBallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FootballAdapter.FootBallViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    } */
