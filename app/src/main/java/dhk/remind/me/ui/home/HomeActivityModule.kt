package dhk.remind.me.ui.home

import dagger.Binds
import dagger.Module

@Module
abstract class HomeActivityModule {

    @Binds
    abstract fun homePresenter(presenter: HomePresenter): HomeContract.Presenter
}