package com.example.sit305_assessmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class imageCapture extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 111;
    private Button buttonCapture, buttonSave, buttonBack;

    Uri imageToUploadUri;
    File f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagecapture);

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        buttonBack = findViewById(R.id.backButton);
        buttonCapture = findViewById(R.id.captureImageButton);
        buttonSave = findViewById(R.id.saveImage);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(imageCapture.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Button Capture Runs Take Picture Function
        buttonCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    takePicture();
            }
        });
        //Button Save Runs Save To Gallery Function
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToGallery();
                toastMessage("Image Saved To Gallery");
            }
        });
    }
    //Runs Camera Intent and Saves It To Internal Storage
    private void takePicture() {
            Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePicture.resolveActivity(getPackageManager()) != null) {
                f = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis()+"_image.jpg");
                takePicture.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                imageToUploadUri = Uri.fromFile(f);
                startActivityForResult(takePicture, REQUEST_IMAGE_CAPTURE);
            }
    }
    //Saves File To Gallery
    private void saveToGallery() {
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(f));
        sendBroadcast(intent);
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
