package codium.firstkotlinapp

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.*
import android.content.Intent
import android.provider.MediaStore
import android.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_camera.*


class CameraActivity() : MainActivity(){
    val REQUEST_IMAGE = 1

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE)
        }
    }

    private fun dispatchGetPictureIntent() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, REQUEST_IMAGE)
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

        button_gallery.setOnClickListener {
            dispatchGetPictureIntent()
        }

        button_upload.setOnClickListener {
            val popup = PopupMenu(this, button_upload)
            popup.setOnMenuItemClickListener { item ->
                toast("You Clicked : " + item.title)
                true
            }
            popup.menuInflater.inflate(R.layout.select_image_from, popup.menu)
            popup.show()
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImage = data.data
            preview_image.setImageURI(selectedImage)
        }
    }
}
