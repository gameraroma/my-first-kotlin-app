package codium.firstkotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import android.text.TextWatcher
import android.text.Editable
import android.widget.TextView



open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // bind seekBar to text
        seekbar_top.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val number = progress.toString()
                number_bar_show.text = number
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Just an empty method
            }
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Another empty method
            }
        })

        // bind textEdit to text
        number_bar_edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {   //Convert the Text to String
                val inputText = number_bar_edit.text.toString()
                number_bar_show.text = inputText
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Just an empty method
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // Another empty method
            }
        })

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
