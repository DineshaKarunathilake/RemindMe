package dhk.remind.me.ui.todaytasks

import dagger.Binds
import dagger.Module

@Module
abstract class TodayTasksModule {

    @Binds
    abstract fun todayTasksPresenter (presenter: TodayTasksPresenter): TodayTasksContract.Presenter
}