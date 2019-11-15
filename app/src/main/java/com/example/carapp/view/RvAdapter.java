package com.example.carapp.view;

import android.view.View;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class RvAdapter<T, E extends RvViewHolder<T>> extends RecyclerView.Adapter<E> {
    private OnRvItemClickListener<T> onRvItemClickListener;
    protected List<T> items;

    public RvAdapter() {

    }

    public RvAdapter(List<T> items) {
        this.items = items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(@NonNull E holder, int position) {
        holder.bind(items.get(position));

        if (onRvItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRvItemClickListener.onItemClick(items.get(position), position);
                }
            });
        }
    }

    public void setOnRvItemClickListener(OnRvItemClickListener<T> onRvItemClickListener) {
        this.onRvItemClickListener = onRvItemClickListener;
    }

    public void removeItem(T item) {
        int index = items.indexOf(item);
        if (index > RecyclerView.NO_POSITION) {
            items.remove(index);
            notifyItemRemoved(index);
        }
    }
}
