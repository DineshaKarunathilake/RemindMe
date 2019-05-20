package dhk.remind.me.ui.home

import android.os.Bundle
import android.view.Window
import dagger.android.support.DaggerAppCompatActivity
import dhk.remind.me.R

class HomeActivity : DaggerAppCompatActivity(), HomeContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        this.title = "Today"

    }
}
