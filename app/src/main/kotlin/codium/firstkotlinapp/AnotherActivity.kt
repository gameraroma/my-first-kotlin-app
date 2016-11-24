package codium.firstkotlinapp

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_camera.*
import org.jetbrains.anko.*

class AnotherActivity : MainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)

        button_finish.setOnClickListener {
            toast("Get Back")
            finish()
        }
    }

}