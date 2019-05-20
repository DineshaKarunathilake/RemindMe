package dhk.remind.me.di



import dagger.Module
import dagger.android.ContributesAndroidInjector
import dhk.remind.me.home.HomeActivity
import dhk.remind.me.home.HomeActivityModule
import dhk.remind.me.login.LoginActivity
import dhk.remind.me.login.LoginActivityModule

@Module
interface ActivityBindingModule {

    @ContributesAndroidInjector(modules = arrayOf(LoginActivityModule::class))
    fun loginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = arrayOf(HomeActivityModule::class))
    fun homeActivity(): HomeActivity

}