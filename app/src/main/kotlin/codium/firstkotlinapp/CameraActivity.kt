package codium.firstkotlinapp

import android.os.Bundle
import org.jetbrains.anko.*
import android.content.Intent
import android.graphics.Paint
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.provider.MediaStore



class CameraActivity : MainActivity(){
    val REQUEST_IMAGE_CAPTURE = 1

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
            button("Take Picture") {
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
    }
}
