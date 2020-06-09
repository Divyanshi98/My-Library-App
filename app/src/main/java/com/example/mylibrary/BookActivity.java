package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {

    private static final String BOOK_KEY ="Book" ;
    private TextView txtName, txtAuthor;
    private ImageView ImgBook;
    private Button btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

        Intent intent = getIntent();
        if(null!= intent){
            final Book book = intent.getParcelableExtra(BOOK_KEY);
            if(null!= intent){
                txtName.setText(book.getName());
                txtAuthor.setText(book.getAuthor());
                Glide.with(this)
                        .asBitmap()
                        .load(book.getImageUrl())
                        .into(ImgBook);
            }

        }
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookActivity.this, PdfView.class);
                startActivity(intent);
            }
        });

    }

    private void setData(Book book1) {
    }


    private void initViews() {
        btnRead = findViewById(R.id.btnRead);

        txtAuthor = findViewById(R.id.txtAuthor);
        txtName = findViewById(R.id.txtName);

        ImgBook = findViewById(R.id.ImgBook);
    }
}
