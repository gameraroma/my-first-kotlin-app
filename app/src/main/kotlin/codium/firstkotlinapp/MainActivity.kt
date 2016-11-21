package codium.firstkotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

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
        }
    }

    private object Ids {
        val button = 1
        val editText = 2
        val editText2 = 3
    }

}
