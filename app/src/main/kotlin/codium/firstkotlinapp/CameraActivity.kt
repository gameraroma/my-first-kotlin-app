package codium.firstkotlinapp

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.*
import android.content.Intent
import android.graphics.Paint
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.provider.MediaStore
import android.graphics.Bitmap
import android.widget.ImageView


class CameraActivity : MainActivity(){
    val REQUEST_IMAGE_CAPTURE = 1
    var preview_image: ImageView? = null

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        relativeLayout {
            button("Finish") {
                id = CameraActivity.Ids.button_finish
                onClick {
                    toast("Get Back")
                    finish()
                }
            }.lparams(width = wrapContent, height = wrapContent) {
                alignParentBottom()
            }
            preview_image = imageView {}.lparams(width = wrapContent, height = wrapContent) {
                above(id=2)
                centerHorizontally()
                alignParentEnd()
            }
            button("Take Picture") {
                id = CameraActivity.Ids.button_take_picture
                onClick {
                    dispatchTakePictureIntent()
                }
            }.lparams(width = wrapContent, height = wrapContent) {
                alignParentBottom()
                centerHorizontally()
            }
        }
    }

    private object Ids {
        val button_finish = 1
        val button_take_picture = 2
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val extras = data.extras
            val imageBitmap = extras.get("data") as Bitmap
            preview_image!!.setImageBitmap(imageBitmap)
        }
    }
}
