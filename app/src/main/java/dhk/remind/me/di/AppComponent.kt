package dhk.remind.me.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import dhk.remind.me.RemindMeApp
import dhk.remind.me.ui.login.LoginActivityModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ActivityBindingModule::class,
    FragmentBindingModule::class,
    AndroidSupportInjectionModule::class,
    AppModule::class,
    LoginActivityModule::class
])
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: RemindMeApp)

    override fun inject(dagger: DaggerApplication)
}