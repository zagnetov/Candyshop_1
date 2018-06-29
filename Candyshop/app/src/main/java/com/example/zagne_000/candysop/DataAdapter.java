package com.example.zagne_000.candysop;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<Candy> candies;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        final ImageView imageView;
        final TextView nameView, categoryView, priceView;
        private ItemClickListener itemClickListener;
        ViewHolder(View view){
            super(view);
            imageView = (ImageView)view.findViewById(R.id.image_id);
            nameView = (TextView) view.findViewById(R.id.name_id);
            categoryView = (TextView) view.findViewById(R.id.category_id);
            priceView = (TextView) view.findViewById(R.id.price_id);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.OnClick(v, getAdapterPosition(), true);
        }
    }

    DataAdapter(Context context, List<Candy> candies) {
        this.context = context;
        this.candies = candies;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.component_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        final Candy candy = candies.get(position);
        holder.imageView.setImageResource(candy.getImage());
        holder.nameView.setText(candy.getName());
        holder.categoryView.setText(candy.getCategory());
        holder.priceView.setText(candy.getPrice());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnClick(View view, int position, boolean isClicked) {
                if(isClicked){
                    Fragment newFragment = new ItemFragment();
                    if(newFragment != null){
                        switchFragment(newFragment, candies.get(position));
                    }
                }
            }
        });
    }
    private void switchFragment(Fragment newFragment, Candy candy){
        if(context == null){
            return;
        }
        if(context instanceof MainActivity){
            MainActivity feeds = (MainActivity) context;
            feeds.replaceSecondFragment(candy);
        }
    }
    @Override
    public int getItemCount() {
        return candies.size();
    }


}
