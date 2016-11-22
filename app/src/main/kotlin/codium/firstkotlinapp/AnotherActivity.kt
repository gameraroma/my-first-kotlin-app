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
        }
    }

    private object Ids {
        val editText = 1
    }

}