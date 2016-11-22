package codium.firstkotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast
import org.jetbrains.anko.*

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        relativeLayout {
            editText {
                id = Ids.editText
            }.lparams(width = wrapContent, height = wrapContent) {
                alignParentLeft()
                alignParentTop()
                alignParentRight()
                alignParentStart()
                alignParentEnd()
            }
            button("New Button") {
                id = Ids.button
            }.lparams(width = wrapContent, height = wrapContent) {
                below(Ids.editText)
                alignParentRight()
                alignParentEnd()
            }
            editText {
                id = Ids.editText2
            }.lparams(width = wrapContent, height = wrapContent) {
                sameTop(Ids.button)
                alignParentLeft()
                alignParentStart()

            }
            button("New Activity") {
                id = 4
                onClick {
                    toAnotherActivity()
                    toast("Hello, New Activity!")
                }
            }.lparams(width = wrapContent, height = wrapContent) {
                alignParentBottom()
            }
        }



    }

    private fun toAnotherActivity(){
        val intent = Intent(this, AnotherActivity::class.java)
        startActivity(intent)
    }

    private object Ids {
        val button = 1
        val editText = 2
        val editText2 = 3
    }

}
