package dhk.remind.me.ui.addtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import dhk.remind.me.R

class AddTaskFragment: DaggerFragment(), AddTaskContract.View {

    companion object {
        fun newInstance(): AddTaskFragment {
            val args = Bundle()
            val fragment = AddTaskFragment()
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_task, container, false)
    }

}
