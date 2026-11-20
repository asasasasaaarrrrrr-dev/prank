package com.prank.wallpaper;

import android.app.Activity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wallpaper_img);

            if (bitmap != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_SYSTEM);
                    wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_LOCK);
                } else {
                    wallpaperManager.setBitmap(bitmap);
                }
                Toast.makeText(this, "Готово!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            finish();
        }
    }
}
