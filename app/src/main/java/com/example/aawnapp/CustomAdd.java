package com.example.aawnapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
//import android.support.annotation.NonNull;
// import android.support.v4.app.ActivityCompat;
// import android.support.v4.content.ContextCompat;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class CustomAdd extends AppCompatActivity implements View.OnClickListener, SingleUploadBroadcastReceiver.Delegate {
    private final SingleUploadBroadcastReceiver uploadReceiver =
            new SingleUploadBroadcastReceiver();
    //Declaring views
    private Button buttonChoose;
    private Button buttonUpload;
    private ImageView imageView;
    private EditText editText;

    //Image request code
    private int PICK_IMAGE_REQUEST = 1;

    //storage permission code
    private static final int STORAGE_PERMISSION_CODE = 123;

    //Bitmap to get image from gallery
    private Bitmap bitmap;

    //Uri to store the image uri
    private Uri filePath;
    private ConstraintLayout albumadd;
    private int child_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_add);
        Intent intent=getIntent();
        child_id=intent.getIntExtra("child_id",0);
        albumadd=findViewById(R.id.albumadd);
        //Requesting storage permission
        requestStoragePermission();

        //Initializing views
        buttonChoose = (Button) findViewById(R.id.buttonChoose);
        buttonUpload = (Button) findViewById(R.id.buttonUpload);
        imageView = (ImageView) findViewById(R.id.imageView);
        editText = (EditText) findViewById(R.id.editTextName);

        //Setting ClickListener
        buttonChoose.setOnClickListener(this);
        buttonUpload.setOnClickListener(this);
    }


    /*
     * This is the method responsible for image upload
     * We need the full image path and the name for the image in this method
     * */
    public void uploadMultipart() {
        //getting name for the image
        String name = editText.getText().toString().trim();
        String path="";
        //getting the actual path of the image
        try {
        if(name.isEmpty()){
            Snackbar.make(albumadd, "please enter name", Snackbar.LENGTH_LONG).show();
        }else{
        //Uploading code
            path = getPath(filePath);
            String uploadId = UUID.randomUUID().toString();
            uploadReceiver.setDelegate(this);
            uploadReceiver.setUploadID(uploadId);
            //Creating a multi part request
            new MultipartUploadRequest(this, uploadId, Constants.UPLOAD_URL)
                    .addFileToUpload(path, "image") //Adding file
                    .addParameter("name", name) //Adding text parameter to the request
                    .addParameter("child_id", String.valueOf(child_id))
                    .setMaxRetries(2)
                    .startUpload(); //Starting the upload
        }}catch (NullPointerException e){
            Snackbar.make(albumadd, "please choose file", Snackbar.LENGTH_LONG).show();
        }
        catch (Exception exc) {
            Snackbar.make(albumadd, exc.getMessage(), Snackbar.LENGTH_LONG).show();
        }
        }


    //method to show file chooser
    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    //handling the image chooser activity result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                Snackbar.make(albumadd, "please choose file", Snackbar.LENGTH_LONG).show();
            }
        }
    }

    //method to get the file path from uri
    public String getPath(Uri uri){
        String[] filePathColumn = { MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":")+1);
        cursor.close();
        Uri Collection;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            Collection = MediaStore.Images.Media
                    .getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY);
        } else {
            Collection = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }
        cursor = getContentResolver().query(
                Collection,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        int index = cursor.getColumnIndex(filePathColumn[0]);
        String path = cursor.getString(index);
        cursor.close();

        return path;
    }


    //Requesting permission
    private void requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return;

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }
        //And finally ask for the permission
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
    }


    //This method will be called when the user will tap on allow or deny
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //Checking the request code of our request
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {

            //If permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Displaying a toast
                Toast.makeText(this, "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
            } else {
                //Displaying another toast if permission is not granted
                Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    public void onClick(View v) {
        if (v == buttonChoose) {
            showFileChooser();
        }
        if (v == buttonUpload) {
            uploadMultipart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        uploadReceiver.register(this);
    }
    @Override
    protected void onPause() {
        super.onPause();
        uploadReceiver.unregister(this);
    }

    @Override
    public void onProgress(int progress) {

    }

    @Override
    public void onProgress(long uploadedBytes, long totalBytes) {
        Snackbar.make(albumadd, "on Progress...", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onError(Exception exception) {

    }

    @Override
    public void onCompleted(int serverResponseCode, byte[] serverResponseBody) {
        try {
            JSONObject response = new JSONObject(new String(serverResponseBody, "UTF-8"));
            if(response.getBoolean("error")){
                Snackbar.make(albumadd, response.getString("message"), Snackbar.LENGTH_LONG).show();
            }else{
                Intent i=new Intent(getApplicationContext(),AlbumsActivity.class);
                i.putExtra("msg","succ. add album "+response.getString("album_name"));
                i.putExtra("child_id",child_id);
                startActivity(i);
                finish();
            }

        } catch (JSONException e) {
            Snackbar.make(albumadd, e.getMessage(), Snackbar.LENGTH_LONG).show();
        } catch (UnsupportedEncodingException e) {
            Snackbar.make(albumadd, e.getMessage(), Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void onCancelled() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(getApplicationContext(),AlbumsActivity.class);
        i.putExtra("child_id",child_id);
        startActivity(i);
        finish();
    }
}