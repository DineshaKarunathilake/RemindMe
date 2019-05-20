package dhk.remind.me.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import dhk.remind.me.R
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.common.api.GoogleApiClient
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.google.android.gms.common.SignInButton
import dagger.android.support.DaggerAppCompatActivity
import dhk.remind.me.home.HomeActivity


class LoginActivity : DaggerAppCompatActivity(), LoginContract.View {

    lateinit var mGoogleSignInClient: GoogleSignInClient
    var idToken: String? = ""
    var name: String? = ""
    var email: String? = ""
    var photoUri: Uri? = null
    var photo: String? = ""
    val TAG = "LoginActivity"
    private lateinit var auth: FirebaseAuth



    val RC_SIGN_IN = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        getSupportActionBar()?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        val signInButton =  findViewById<SignInButton>(R.id.login_with_google_btn)
        signInButton.setSize(SignInButton.SIZE_STANDARD)

        signInButton.setOnClickListener {
            signIn()
        }
    }

    override fun onStart() {
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(this)
        updateUI(account)
    }

    private fun signIn() {
        Log.i(TAG, "Sign in called")
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }


    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)

            Log.i(TAG, "User email [${account?.email}]" )
            Log.i(TAG, "User name [${account?.displayName}]" )
            Log.i(TAG, "User picture url [${account?.photoUrl}]" )

            // Signed in successfully, show authenticated UI.
            updateUI(account)
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.statusCode)
            updateUI(null)
        }

    }

    override fun updateUI(account: GoogleSignInAccount?) {
        //TODO: Show login button according to sign in status

        if (account != null) {
            Log.i(TAG, "Authentication exists. Directing to home activity")
            showHomePageView()
        } else {
            Log.i(TAG, "Needs authentication")
        }


    }

    override fun showHomePageView() {
        Log.i(TAG, "Starting home activity")
        val homeIntent = Intent(this, HomeActivity::class.java)
        startActivity(homeIntent)
        finish()
    }
}
