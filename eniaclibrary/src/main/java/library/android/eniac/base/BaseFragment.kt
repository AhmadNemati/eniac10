package library.android.eniac.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

/**
 * Created by RezaNejati on 7/8/2018.
 */
@SuppressLint("ValidFragment")
class BaseFragment<T>(internal var t: T) : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    fun mainView(): T {
        return t
    }

    fun setMainView(t: T) {
        this.t = t
    }
}

