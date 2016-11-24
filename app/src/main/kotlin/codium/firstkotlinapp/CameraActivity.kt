package codium.firstkotlinapp

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.*
import android.content.Intent
import android.provider.MediaStore
import android.graphics.Bitmap
import kotlinx.android.synthetic.main.activity_camera.*


class CameraActivity() : MainActivity(){
    val REQUEST_IMAGE_CAPTURE = 1

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        button_finish.setOnClickListener {
            toast("Get Back")
            finish()
        }

        button_take_picture.setOnClickListener {
            dispatchTakePictureIntent()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val extras = data!!.extras
            val imageBitmap = extras.get("data") as Bitmap
            preview_image.setImageBitmap(imageBitmap)
        }
    }
}
