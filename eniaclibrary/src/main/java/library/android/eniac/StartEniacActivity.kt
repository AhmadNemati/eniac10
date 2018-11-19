package library.android.eniac

import android.content.Intent
import android.widget.Toast
import com.pixplicity.easyprefs.library.Prefs

import library.android.eniac.flight.activity.main.MainFlight
import library.android.eniac.singleton.SingletonContext
import library.android.service.generator.SingletonService
import library.android.service.listener.OnServiceStatus
import library.android.service.model.authenticateLogin.request.AuthenticateLoginRequest
import library.android.service.model.authenticateLogin.response.AuthenticateLoginResponse

/**
 * Created by RezaNejati on 10/13/2018.
 */
class StartEniacActivity constructor(user: String, pass: String, type: ActivityType) : OnServiceStatus<AuthenticateLoginResponse> {


    private var colorPrimary: Int = 0
        set
    private var colorPrimaryDark: Int = 0
        set
    private var colorAccent: Int = 0
        set

    var context = SingletonContext.instance.context
    var pass: String
    var user: String
    val type: ActivityType

    init {
        this.pass = pass
        this.user = user
        this.type = type

    }

    fun start() {
        val authenticateLoginRequest = AuthenticateLoginRequest()
        authenticateLoginRequest.username = user
        authenticateLoginRequest.password = pass

        SingletonService.getInstance().authenticateLoginService().setAuthenticateLoginRequest(this,authenticateLoginRequest)
        when (type) {
            ActivityType.FLIGHT -> context!!.startActivity(Intent(context, MainFlight::class.java))
            else -> {
            }
        }

    }


    override fun onReady(response: AuthenticateLoginResponse?) {
        try {
            if (response!!.generalCode == 200) {
                Prefs.putString("token",response.token)
            } else {
                onError(response.messageUser.toString())
            }
        } catch (e: Exception) {
            onError(e.message)

        }


    }
    override fun onError(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

    }
}
