package codium.firstkotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import org.jetbrains.anko.*

class AnotherActivity : MainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        relativeLayout {
            editText {
                id = Ids.editText
                hint = "another"
            }.lparams(width = wrapContent, height = wrapContent) {
                alignParentLeft()
                alignParentTop()
                alignParentRight()
                alignParentStart()
                alignParentEnd()
            }
            button("Finish") {
                id = Ids.button_finish
                onClick {
                    toast("Get Back")
                    finish()
                }
            }.lparams(width = wrapContent, height = wrapContent) {
                alignParentBottom()
            }
        }
    }

    private object Ids {
        val editText = 1
        val button_finish = 1
    }

}