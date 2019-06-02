package dhk.remind.me.ui.addtask

import dagger.Binds
import dagger.Module

@Module
abstract class AddTaskFragmentModule {

    @Binds
    abstract fun addTaskFragmentPresenter (presenter: AddTaskPresenter): AddTaskContract.Presenter
}