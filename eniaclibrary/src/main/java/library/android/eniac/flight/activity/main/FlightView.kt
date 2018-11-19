package library.android.eniac.flight.activity.main

import library.android.eniac.mvp.BaseView

/**
 * Created by RezaNejati on 10/23/2018.
 */
interface FlightView : BaseView<FlightView>{

    fun onSerach()
    fun onGoDate()
    fun onBackDate()
    fun onRoundTrip()
    fun onOnWay()
    fun onMulti()
    fun onDetination()
    fun onOrigin()
    fun onClass()
    fun onPassenger()


}
