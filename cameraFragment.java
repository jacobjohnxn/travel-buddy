package com.microproject.travel_buddy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraSelector;
import androidx.fragment.app.Fragment;

public class cameraFragment extends Fragment {

    private static final int PIC_ID = 123;
    private Button cameraOpenButton;
    private ImageView clickImageView;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, container, false);

        context = view.getContext();
        cameraOpenButton = view.findViewById(R.id.camera_button);
        clickImageView = view.findViewById(R.id.click_image);

        cameraOpenButton.setOnClickListener(v -> openCamera());

        return view;
    }

    private void openCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra("android.intent.extras.CAMERA_FACING", android.hardware.Camera.CameraInfo.CAMERA_FACING_BACK);
        startActivityForResult(cameraIntent, PIC_ID);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PIC_ID && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            clickImageView.setImageBitmap(photo);
        }
    }
}
