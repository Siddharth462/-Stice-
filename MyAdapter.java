package com.example.jobifyme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<String> mDataset;
    Context context;

    private FruitSelectionListener fruitSelectionListener;



    public MyAdapter(List<String> myDataset,Context context) {
        this.context =context;
        fruitSelectionListener = (TaskList) context;
        mDataset =myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                     int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_view_text, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        if (position>mDataset.size())
        {
            position = mDataset.size()-1;
        }
        String fruitName =  mDataset.get(position);
        holder.textView.setText(fruitName);

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDataset.get(holder.getAdapterPosition()) != null) {
                    fruitSelectionListener.onFruitSelected(mDataset.get(holder.getAdapterPosition()));
                }
                else
                {
                    fruitSelectionListener.onFruitSelected("Item1");
                }
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public MyViewHolder(@NonNull TextView v) {
            super(v);
            textView = v;
        }
    }
}