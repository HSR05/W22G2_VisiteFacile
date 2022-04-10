package com.example.visitefacile;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.zxing.WriterException;
import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidmads.library.qrgenearator.QRGSaver;

public class Ticket_QR extends AppCompatActivity {

    private ImageView qrCodeIV;
    private TextView dataEdt;
    private Button generateQrBtn;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_qr);

        // initializing all variables.
        qrCodeIV = findViewById(R.id.idIVQrcode);
        dataEdt = findViewById(R.id.idEdt);
        generateQrBtn = findViewById(R.id.idBtnGenerateQR);
        Bundle bundle = getIntent().getExtras();

        dataEdt.setText("    Click below to generate the QR code for your flight");
        

        // initializing onclick listener for button.
        generateQrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    // below line is for getting
                    // the windowmanager service.
                   // dataEdt.setText("Generate QR code for flight from: " + bundle.getString("from") + " to : " + bundle.getString("to") + " for price of - " + bundle.getDouble("price"));
                    WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);

                    // initializing a variable for default display.
                    Display display = manager.getDefaultDisplay();

                    // creating a variable for point which
                    // is to be displayed in QR Code.
                    Point point = new Point();
                    display.getSize(point);

                    // getting width and
                    // height of a point
                    int width = point.x;
                    int height = point.y;

                    // generating dimension from width and height.
                    int dimen = width < height ? width : height;
                    dimen = dimen * 3 / 4;

                    // setting this dimensions inside our qr code
                    // encoder to generate our qr code.

                    qrgEncoder = new QRGEncoder(bundle.getString("from") + bundle.getDouble("price") + "", null, QRGContents.Type.TEXT, dimen);
                    try {
                        // getting our qrcode in the form of bitmap.
                        bitmap = qrgEncoder.encodeAsBitmap();
                        // the bitmap is set inside our image
                        // view using .setimagebitmap method.
                        qrCodeIV.setImageBitmap(bitmap);

                        MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, bundle.getString("from") , "qrCode");

                        Toast.makeText(getApplicationContext(), "QR code has been stored to gallery for easy usage", Toast.LENGTH_SHORT).show();

//                        String savePath = Environment.getExternalStorageDirectory().getPath() + "/QRCode/";
//
//                        QRGSaver qrgSaver = new QRGSaver();
//                        try {
//
//                            boolean save = qrgSaver.save(savePath, bundle.getString("from"), bitmap, QRGContents.ImageType.IMAGE_JPEG);
//                            String result = save ? "Image Saved" : "Image Not Saved";
//                        } catch (WriterException e) {
//                            e.printStackTrace();
//                        }
////                        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
////                            try {
////                                boolean save = new QRGSaver().save(savePath, edtValue.getText().toString().trim(), bitmap, QRGContents.ImageType.IMAGE_JPEG);
////                                String result = save ? "Image Saved" : "Image Not Saved";
////
////                            } catch (Exception e) {
////                                e.printStackTrace();
////                            }
////                        } else {
////                            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
////                        }
                    } catch (WriterException e) {
                        // this method is called for
                        // exception handling.
                        Log.e("Tag", e.toString());
                    }

//                String savePath = Environment.getExternalStorageDirectory().getPath() + "/QRCode/";
//                QRGSaver qrgSaver = new QRGSaver();
//                try {
//                    qrgSaver.save(savePath, bundle.getString("from") + bundle.getDouble("price"), bitmap, QRGContents.ImageType.IMAGE_JPEG);
//                } catch (WriterException e) {
//                    e.printStackTrace();
//                }

            }

        });
    }
}