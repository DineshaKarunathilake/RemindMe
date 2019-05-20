package dhk.remind.me.di



import dagger.Module
import dagger.android.ContributesAndroidInjector
import dhk.remind.me.ui.home.HomeActivity
import dhk.remind.me.ui.home.HomeActivityModule
import dhk.remind.me.ui.login.LoginActivity
import dhk.remind.me.ui.login.LoginActivityModule

@Module
interface ActivityBindingModule {

    @ContributesAndroidInjector(modules = arrayOf(LoginActivityModule::class))
    fun loginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = arrayOf(HomeActivityModule::class))
    fun homeActivity(): HomeActivity

}