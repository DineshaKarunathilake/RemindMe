package dhk.remind.me.ui.navigation

import dagger.Binds
import dagger.Module

@Module
abstract class SideNavActivityModule {

    @Binds
    abstract fun sideNavPresenter (sideNavPresenter: SideNavPresenter): SideNavContract.Presenter
}