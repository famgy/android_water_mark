package com.famgy.android.watermarktest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

/**
 * Created by famgy on 11/3/17.
 */


public class PdfViewerActivity extends AppCompatActivity {
    private String display;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        PDFView pdfView=(PDFView)findViewById(R.id.pdf_view);
        String fileFullName=getIntent().getStringExtra("fileFullName");
        File file=new File(fileFullName);
        try {
            // 加载文件
            pdfView.fromFile(file).load();
        } catch (Exception ex) {
            Toast.makeText(PdfViewerActivity.this,"文件不存在或已损坏",Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        String userName = "机密文件，拷贝必究";
        Fragment fragment = new ContentFragment();
        Bundle args = new Bundle();

        args.putString("key", userName);
        fragment.setArguments(args);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fram, fragment)
                .commit();
    }
}