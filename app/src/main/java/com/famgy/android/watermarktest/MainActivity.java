package com.famgy.android.watermarktest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView mWartermarkImage;
    private Button bt_pdf_viewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //静态方法启动该页面，type=0为显示水印，其他值为不显示水印
        bt_pdf_viewer = (Button)findViewById(R.id.bt_pdf_viewer);
        bt_pdf_viewer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PdfViewerActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("fileFullName", "/data/local/tmp/pdf_view_mark.pdf");
                intent.putExtra("fileType",0);
                intent.putExtra("userName","famgy");
                startActivity(intent);
            }
        });

        mWartermarkImage = (ImageView) findViewById(R.id.wartermark_pic);
        Bitmap sourBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.desk);
        mWartermarkImage.setImageBitmap(sourBitmap);

        Button bt_image = (Button)findViewById(R.id.bt_image);
        bt_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initImageView();
            }
        });

        Button bt_text = (Button)findViewById(R.id.bt_text);
        bt_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initTextView();
            }
        });
    }

    private void initImageView(){
        mWartermarkImage = (ImageView) findViewById(R.id.wartermark_pic);


        Bitmap sourBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.desk);
        Bitmap waterBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.suninfo);

        Bitmap watermarkBitmap = ImageUtil.createWaterMaskCenter(sourBitmap, waterBitmap);
//        watermarkBitmap = ImageUtil.createWaterMaskLeftBottom(this, watermarkBitmap, waterBitmap, 0, 0);
//        watermarkBitmap = ImageUtil.createWaterMaskRightBottom(this, watermarkBitmap, waterBitmap, 0, 0);
//        watermarkBitmap = ImageUtil.createWaterMaskLeftTop(this, watermarkBitmap, waterBitmap, 0, 0);
//        watermarkBitmap = ImageUtil.createWaterMaskRightTop(this, watermarkBitmap, waterBitmap, 0, 0);

//        Bitmap textBitmap = ImageUtil.drawTextToLeftTop(this, watermarkBitmap, "左上角", 16, Color.argb(50, 255, 255, 255), 0, 0);
//        textBitmap = ImageUtil.drawTextToRightBottom(this, textBitmap, "右下角", 16, Color.RED, 0, 0);
//        textBitmap = ImageUtil.drawTextToRightTop(this, textBitmap, "右上角", 16, Color.RED, 0, 0);
//        textBitmap = ImageUtil.drawTextToLeftBottom(this, textBitmap, "左下角", 16, Color.RED, 0, 0);
//        textBitmap = ImageUtil.drawTextToCenter(this, textBitmap, "中间", 16, Color.RED);

//        mWartermarkImage.setImageBitmap(watermarkBitmap);
        mWartermarkImage.setImageBitmap(watermarkBitmap);
    }

    private void initTextView(){
        mWartermarkImage = (ImageView) findViewById(R.id.wartermark_pic);

        Bitmap sourBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.desk);
        Bitmap destBmp = TextUtil.drawCenterLable(this, sourBitmap, "某某公司专用");

        mWartermarkImage.setImageBitmap(destBmp);
    }
}
