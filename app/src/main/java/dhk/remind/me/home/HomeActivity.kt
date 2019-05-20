package dhk.remind.me.home

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import dhk.remind.me.R

class HomeActivity : DaggerAppCompatActivity(), HomeContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_home)
        this.title = "Today"

    }
}
