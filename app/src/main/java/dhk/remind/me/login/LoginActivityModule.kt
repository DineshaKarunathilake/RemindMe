package dhk.remind.me.login

import dagger.Binds
import dagger.Module

@Module
abstract class LoginActivityModule {

    @Binds
    abstract fun loginPresenter(presenter: LoginPresenter): LoginContract.Presenter
}