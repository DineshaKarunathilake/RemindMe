package dhk.remind.me.ui.login

import com.google.android.gms.auth.api.signin.GoogleSignInAccount

interface LoginContract {

    interface View {

        fun showHomePageView(account: GoogleSignInAccount)
        fun updateUI(account: GoogleSignInAccount?)

    }

    interface Presenter {

    }
}