package codium.firstkotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_new_activity.setOnClickListener {
            toAnotherActivity()
            toast("Hello, New Activity!")
        }

        button_camera.setOnClickListener {
            toCameraActivity()
            toast("Camera!")
        }

    }

    private fun toAnotherActivity(){
        val intent = Intent(this, AnotherActivity::class.java)
        startActivity(intent)
    }

    private fun toCameraActivity(){
        val intent = Intent(this, CameraActivity::class.java)
        startActivity(intent)
    }

}
