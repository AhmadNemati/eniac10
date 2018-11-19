package library.android.eniac.singleton

import android.annotation.SuppressLint
import android.content.Context

/**
 * Created by RezaNejati on 7/2/2018.
 */
class SingletonContext private constructor() {
    var context: Context? = null


    companion object {
        @SuppressLint("StaticFieldLeak")
        val instance = SingletonContext()
    }


}
