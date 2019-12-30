package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    private static String TAG = Emojifier.class.getSimpleName();

    public static void detectFaces(Context context, Bitmap bmp){

        //Creates a face detector which is optimized for tracking a single, relatively large face
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        // Build the frame
        Frame frame = new Frame.Builder().setBitmap(bmp).build();

        // Detect the faces
        SparseArray<Face> faces = detector.detect(frame);

        Log.d(TAG, "number of faces: " + faces.size());
        if(faces.size() == 0){
            Toast.makeText(context, "there no any faces were detected", Toast.LENGTH_SHORT);
        }

        detector.release();
    }
}
