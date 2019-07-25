package com.misoca.tontonhome

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_OPEN_DOCUMENT
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_camera.setOnClickListener {
            startActivity(Intent(INTENT_ACTION_STILL_IMAGE_CAMERA))
        }
        button_picture.setOnClickListener {
            startActivity(Intent().also {
                    it.setClassName("com.cooliris.media", "com.cooliris.media.Gallery")
//                    it.setType("image/*")
            })
        }
    }

    override fun onResume() {
        super.onResume()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            window.decorView.setSystemUiVisibility(View.STATUS_BAR_HIDDEN)
        }
    }

    override fun onBackPressed() {
        //
    }
}
