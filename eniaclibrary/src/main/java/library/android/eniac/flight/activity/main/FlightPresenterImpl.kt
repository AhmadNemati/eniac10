package library.android.eniac.flight.activity.main

import android.util.Log
import android.view.View
import library.android.eniac.R
import library.android.eniac.model.LocationDBModel
import library.android.service.generator.SingletonService
import library.android.service.listener.OnServiceStatus
import library.android.service.model.flightSearch.response.FlightSearchResponse
import library.android.service.model.getFlightLocations.request.GetFlightLocationsRequest
import library.android.service.model.getFlightLocations.response.GetFlightLocationsResponse

/**
 * Created by RezaNejati on 10/23/2018.
 */
class FlightPresenterImpl constructor(flightView: FlightView) : FlightPresenter, View.OnClickListener, OnServiceStatus<FlightSearchResponse> {


    private val flightView: FlightView

    init {
        this.flightView = flightView
        //getLocation()
    }

    override fun onResume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStart() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBack() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btnConfirm -> flightView.onSerach()
            R.id.llGoDate -> flightView.onGoDate()
            R.id.llBackDate -> flightView.onBackDate()
            R.id.tvRoundTrip -> flightView.onRoundTrip()
            R.id.tvOneWay -> flightView.onOnWay()
            R.id.tvMulti -> flightView.onMulti()
            R.id.llDestination -> flightView.onDetination()
            R.id.llOrigin -> flightView.onOrigin()
            R.id.llClass -> flightView.onClass()
            R.id.llPassenger -> flightView.onPassenger()
        }

    }


    override fun onError(message: String?) {

    }

    override fun onReady(response: FlightSearchResponse?) {


        try {
            if (response!!.generalCode == 200) {


            } else {

                flightView.onError(response.messageUser.toString())

            }

        } catch (e: Exception) {
            flightView.onError(e.message!!)
        }


    }


/*
    private fun getLocation(){
        val locationDBModels = LocationDBModel.listAll(LocationDBModel::class.java)

        if (locationDBModels.size!=0)
            return




        flightView.showProgress()
        val getFlightLocationsRequest= GetFlightLocationsRequest()
        getFlightLocationsRequest.type=3

            SingletonService.getInstance().flightLocationsService.GetFlightLocationsService(object : OnServiceStatus<List<GetFlightLocationsResponse>> {
                override fun onReady(t: List<GetFlightLocationsResponse>?) {
                    if (t != null) {
                    val thread = object : Thread() {
                        override fun run() {

                             var i=0;



                                for (response in t) {
                                    i++
                                    val locationDBModel= LocationDBModel()
                                    locationDBModel.fullTextSearch=response.fullTextSearch
                                    locationDBModel.iataCode=response.iataCode
                                    locationDBModel.lat=response.lat
                                    locationDBModel.lon=response.lon
                                    locationDBModel.name=response.name
                                    locationDBModel.parentId=response.parentId
                                    locationDBModel.parentName=response.parentName
                                    locationDBModel.persianName=response.persianName
                                    locationDBModel.rate=response.rate
                                    locationDBModel.type=response.type
                                    locationDBModel.save()

                                    if(i==t.size)
                                        flightView.hideProgress()

                                }

                        }
                    }

                    thread.start()

                    }else{
                        flightView.hideProgress()

                        flightView.onError("خطایی رخ داده است")
                    }





                }
                override fun onError(message: String) {
                    flightView.hideProgress()
                    flightView.onError(message)

                    Log.e("teeeestt",message)

                }
            }, getFlightLocationsRequest)


    }
*/
}
