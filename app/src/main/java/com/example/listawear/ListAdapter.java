package com.example.listawear;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ItemsList> mItems = new ArrayList<>();

    public ListAdapter(List<ItemsList> _items){
        mItems = _items;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    } // class ViewHolder

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.main_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    } // ListAdapter.ViewHolder

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder viewHolder, int i){
        ItemsList itemsList = mItems.get(i);
        viewHolder.imageView.setImageResource(itemsList.getImageItem());
        viewHolder.textView.setText(itemsList.getNameItem());
    }

    @Override
    public int getItemCount(){
        return mItems.size();
    }

}

class ItemsList {
    private int imageItem;
    private String nameItem;

    public ItemsList(int _imageItem, String _nameItem){
        this.imageItem = _imageItem;
        this.nameItem = _nameItem;
    }

    public int getImageItem(){
        return imageItem;
    }

    public String getNameItem(){
        return nameItem;
    }
}
