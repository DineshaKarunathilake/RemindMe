package dhk.remind.me.ui.login

import dagger.Binds
import dagger.Module

@Module
abstract class LoginActivityModule {

    @Binds
    abstract fun loginPresenter(presenter: LoginPresenter): LoginContract.Presenter
}