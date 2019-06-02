package dhk.remind.me.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dhk.remind.me.ui.addtask.AddTaskFragment
import dhk.remind.me.ui.addtask.AddTaskFragmentModule

@Module
interface FragmentBindingModule {

    @ContributesAndroidInjector(modules = arrayOf(AddTaskFragmentModule::class))
    fun addTaskFragment(): AddTaskFragment
}