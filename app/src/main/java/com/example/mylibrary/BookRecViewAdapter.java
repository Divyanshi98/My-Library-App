package com.example.mylibrary;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.ViewHolder> {
    private  static final String TAG = "BookRecViewAdapter";
    private static final String BOOK_KEY = "Book";


    private ArrayList<Book> books = new ArrayList<>();
    private Context mContext;

    public BookRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View View = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_all_books, parent, false);
        ViewHolder holder = new ViewHolder(View);
        return new ViewHolder(View);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "OnBindViewHolder: Called");
        holder.txtName.setText(books.get(position).getName());
        Glide.with(mContext).asBitmap().load(books.get(position).getImageUrl()).into(holder.imgBook);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(mContext,BookActivity.class);
                intent.putExtra(BOOK_KEY, books.get(position));
                mContext.startActivity(intent);

            }
        });

        holder.txtAuthor.setText(books.get(position).getAuthor());

        if(books.get(position).isExpanded()){
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expanded.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);
        }
        else{
            holder.expanded.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView imgBook;
        private TextView txtName;
        private ImageView downArrow, upArrow;
        private RelativeLayout expanded;
        private TextView txtAuthor, txtDescription;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgBook = itemView.findViewById(R.id.imgBook);
            txtName = itemView.findViewById(R.id.txtName);

            downArrow = itemView.findViewById(R.id.btnDownArrow);
            upArrow = itemView.findViewById(R.id.btnUpArrow);
            expanded = itemView.findViewById(R.id.expanded);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
           txtDescription = itemView.findViewById(R.id.txtShortDesc);

           downArrow.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Book book = books.get(getAdapterPosition());
                   book.setExpanded(!book.isExpanded());
                   notifyItemChanged(getAdapterPosition());

               }
           });

           upArrow.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Book book = books.get(getAdapterPosition());
                   book.setExpanded(!book.isExpanded());
                   notifyItemChanged(getAdapterPosition());
               }
           });{

            }
        }
    }
}
