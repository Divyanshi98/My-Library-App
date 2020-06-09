package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.ArrayList;

public class PdfView extends AppCompatActivity {

    PDFView mypdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        mypdf = findViewById(R.id.pdftest1);

        
        mypdf.fromAsset("toc.pdf").load(); //for 1st pdf (in similar way we can do for other pdfs)





    }
}