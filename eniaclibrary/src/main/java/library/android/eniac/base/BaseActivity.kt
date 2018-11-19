package library.android.eniac.base

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.View
import android.widget.Toast

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

/**
 * Created by RezaNejati on 7/2/2018.
 */
@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {
    //private SuperActivityToast superActivityToast;
    internal var context: Context? = null

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {

        return super.onCreateView(name, context, attrs)

    }


    override fun onStart() {
        super.onStart()

    }

    override fun onStop() {
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()

    }


    override fun onPause() {
        super.onPause()

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context))
    }

    fun showToast(message: String, color: Int) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
