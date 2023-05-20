package com.example.aawnapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class AddItem extends AppCompatActivity implements View.OnClickListener, SingleUploadBroadcastReceiver.Delegate {
    //storage permission code
    private static final int STORAGE_PERMISSION_CODE = 123;
    private final SingleUploadBroadcastReceiver uploadReceiver =
            new SingleUploadBroadcastReceiver();
    //Declaring views
    private Button buttonChoose;
    private Button buttonUpload;
    private Button buttonChoose2;
    private ImageView imageView;
    private EditText editText;
    //Image request code
    private int PICK_IMAGE_REQUEST = 1;
    //Audio request code
    private int PICK_AUDIO_REQUEST = 2;
    //Bitmap to get image from gallery
    private Bitmap bitmap;

    //Uri to store the image uri
    private Uri filePath;

    //Uri to store the audio uri
    private Uri filePathAudio;
    private int album_id;
    private String album_name;
    private int child_id;
    private ConstraintLayout items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        //Requesting storage permission
        requestStoragePermission();

        Intent i = getIntent();
        album_id = i.getIntExtra("album_id", 0);
        album_name = i.getStringExtra("album_name");
        child_id=i.getIntExtra("child_id",0);
        //Initializing views
        buttonChoose = (Button) findViewById(R.id.buttonChoose);
        buttonUpload = (Button) findViewById(R.id.buttonUpload);
        buttonChoose2 = (Button) findViewById(R.id.buttonChoose2);
        imageView = (ImageView) findViewById(R.id.imageView);
        editText = (EditText) findViewById(R.id.editTextName);
        items=findViewById(R.id.items);

        //Setting ClickListener
        buttonChoose.setOnClickListener(this);
        buttonChoose2.setOnClickListener(this);
        buttonUpload.setOnClickListener(this);
    }


    /*
     * This is the method responsible for image upload
     * We need the full image path and the name for the image in this method
     * */
    public void uploadMultipart() {
        //getting name for the image
        String name = editText.getText().toString().trim();
        String path = "";
        String pathAudio = "";
        //getting the actual path of the image
        try {
            if (name.isEmpty()) {
                Snackbar.make(items, "please enter name", Snackbar.LENGTH_LONG).show();
            } else {
                //Uploading code
                path = getPath(filePath, "image");
                pathAudio = getPath(filePathAudio, "audio");
                String uploadId = UUID.randomUUID().toString();
                uploadReceiver.setDelegate(this);
                uploadReceiver.setUploadID(uploadId);
                //Creating a multi part request
                new MultipartUploadRequest(this, uploadId, Constants.UPLOAD_URL_ITEM)
                        .addFileToUpload(path, "image")
                        .addFileToUpload(pathAudio, "audio")
                        .addParameter("name", name)
                        .addParameter("child_id", String.valueOf(child_id))
                        .addParameter("album_id", String.valueOf(album_id))
                        .setMaxRetries(5)
                        .startUpload(); //Starting the upload
            }
        } catch (NullPointerException e) {
            Snackbar.make(items, "please choose file", Snackbar.LENGTH_LONG).show();
        } catch (Exception exc) {
            Snackbar.make(items, exc.getMessage(), Snackbar.LENGTH_LONG).show();
        }
    }


    //method to show file chooser
    private void showFileChooser(String type, String title, int requestID) {
        Intent intent = new Intent();
        intent.setType(type);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, title), requestID);
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
                Snackbar.make(items, "please choose file", Snackbar.LENGTH_LONG).show();
            }
        }
        if (requestCode == PICK_AUDIO_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePathAudio = data.getData();
        }
    }

    //method to get the file path from uri
    public String getPath(Uri uri, String type) {

        String[] filePathColumn = new String[1];
        if (type.equalsIgnoreCase("image")) {
            filePathColumn[0] = MediaStore.Images.Media.DATA;
        } else {
            filePathColumn[0] = MediaStore.Audio.Media.DATA;
        }
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();
        Uri Collection;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            Collection = type.equalsIgnoreCase("image")?MediaStore.Images.Media
                    .getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY):MediaStore.Audio.Media
                    .getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY);
        } else {
            Collection = type.equalsIgnoreCase("image")?MediaStore.Images.Media.EXTERNAL_CONTENT_URI:MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        }
        if (type.equalsIgnoreCase("image")) {
            cursor = getContentResolver().query(
                    Collection,
                    null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        } else {
            cursor = getContentResolver().query(
                    Collection,
                    null, MediaStore.Audio.Media._ID + " = ? ", new String[]{document_id}, null);
        }

        Log.e("Count",String.valueOf(cursor.getCount())+type);
        String path="";
        if( cursor != null && cursor.moveToFirst() ){
        int index = cursor.getColumnIndex(filePathColumn[0]);
        path = cursor.getString(index);
        }
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
            showFileChooser("image/*", "Select Picture", PICK_IMAGE_REQUEST);
        }
        if (v == buttonChoose2) {
            showFileChooser("audio/*", "Select Audio", PICK_AUDIO_REQUEST);
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
        Snackbar.make(items, "on Progress...", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onError(Exception exception) {

    }

    @Override
    public void onCompleted(int serverResponseCode, byte[] serverResponseBody) {
        try {
            JSONObject response = new JSONObject(new String(serverResponseBody, "UTF-8"));
            if (response.getBoolean("error")) {
                Snackbar.make(items, response.getString("message"), Snackbar.LENGTH_LONG).show();
            } else {
                Intent i=new Intent(getApplicationContext(),ShowItem.class);
                i.putExtra("album_id",album_id);
                i.putExtra("album_name",album_name);
                i.putExtra("child_id",child_id);
                i.putExtra("msg","succ. add item " + response.getString("item_name"));
                startActivity(i);
                finish();

            }

        } catch (JSONException e) {
            Snackbar.make(items, e.getMessage(), Snackbar.LENGTH_LONG).show();
        } catch (UnsupportedEncodingException e) {
            Snackbar.make(items, e.getMessage(), Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void onCancelled() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(getApplicationContext(),ShowItem.class);
        i.putExtra("album_id",album_id);
        i.putExtra("album_name",album_name);
        i.putExtra("child_id",child_id);
        startActivity(i);
        finish();
    }
}