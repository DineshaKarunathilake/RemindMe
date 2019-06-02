package dhk.remind.me.ui.navigation

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dagger.android.support.DaggerAppCompatActivity
import dhk.remind.me.R
import dhk.remind.me.ui.addtask.AddTaskFragment
import kotlinx.android.synthetic.main.activity_side_nav.*
import kotlinx.android.synthetic.main.app_bar_side_nav.*
import kotlinx.android.synthetic.main.nav_header_side_nav.*

class SideNavActivity : DaggerAppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    companion object {
        const val TAG = "SideNavActivity"
        var name: String? = null
        var email: String? = null
        var photoUrl: String? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_side_nav)



        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        name = intent.getStringExtra("NAME")
        email = intent.getStringExtra("EMAIL")
        photoUrl = intent.getStringExtra("PROFILE_IMG")

        val nameTextView = findViewById<TextView>(R.id.loggedInName)
        val emailTextView = findViewById<TextView>(R.id.emailAddress)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val headerView = navigationView.getHeaderView(0)
        headerView.findViewById<TextView>(R.id.loggedInName).setText(name)
        headerView.findViewById<TextView>(R.id.emailAddress).setText(email)

        if (!photoUrl.isNullOrEmpty()) {
            Glide.with(this)
                    .load(photoUrl)
                    .apply(RequestOptions.circleCropTransform())
                    .apply(RequestOptions().override(250, 250))
                    .into(headerView.findViewById(R.id.profileImage))
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.side_nav, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_all_tasks -> {
                // Handle the camera action
            }

            R.id.nav_today -> {
                val bundle=Bundle()
                val addTaskFragment = AddTaskFragment()
                addTaskFragment.arguments = bundle
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, addTaskFragment)
                transaction.commit()
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
