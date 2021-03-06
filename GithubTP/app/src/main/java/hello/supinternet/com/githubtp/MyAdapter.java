package hello.supinternet.com.githubtp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import hello.supinternet.com.githubtp.model.Repository;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Repository> mDataset = new ArrayList<>();
    private OnViewClickedListener clickListener;
    private LayoutInflater layoutInflater;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView)v.findViewById(R.id.textContent);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(OnViewClickedListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setDataset(List<Repository> newDataset){
        this.mDataset = newDataset;
        this.notifyDataSetChanged();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        if (this.layoutInflater == null){
            this.layoutInflater = LayoutInflater.from(parent.getContext());
        }
        // create a new view
        View v = this.layoutInflater
                .inflate(R.layout.my_text_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position).getName());

        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                clickListener.handle(view, mDataset.get(position).getFullName());
            }
        });

//        int resId = R.anim.item_animation_fall_down;
//        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), resId);
//        holder.itemView.setAnimation(animation);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface OnViewClickedListener{
        public void handle(View view, String clickedElemData);
    }
    //créer interface
}
