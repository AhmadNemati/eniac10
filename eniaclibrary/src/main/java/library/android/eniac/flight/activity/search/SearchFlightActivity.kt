package library.android.eniac.flight.activity.search

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v4.widget.NestedScrollView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.pixplicity.easyprefs.library.Prefs
import library.android.eniac.R
import library.android.eniac.base.BaseActivity
import library.android.eniac.flight.activity.passenger.PassengerActivity
import library.android.eniac.flight.adapter.FlightResultAdapter
import library.android.service.generator.SingletonService
import library.android.service.listener.OnServiceStatus
import library.android.service.model.flightSearch.request.FlightPreferences
import library.android.service.model.flightSearch.request.FlightSearchRequest
import library.android.service.model.flightSearch.request.FlightStep
import library.android.service.model.flightSearch.request.SearchedPassenger
import library.android.service.model.flightSearch.response.FlightOffer
import library.android.service.model.flightSearch.response.FlightSearchResponse

class SearchFlightActivity : BaseActivity(),OnServiceStatus<FlightSearchResponse>,FlightResultAdapter.OnChangeData,View.OnClickListener, FlightResultAdapter.BuyFlight {


    private var rlLoading: LinearLayout? =null
    private var rvFlightResult:RecyclerView ?=null
    private var resultFlight:ArrayList<FlightOffer> = arrayListOf()
    private var resultFlightPage:ArrayList<FlightOffer> = arrayListOf()
    private var tvCount:TextView?=null
    private var tvMenu:TextView?=null
    private var tvDetail:TextView?=null
    private var tvDete:TextView?=null
    private var i=0;
    private var nested:NestedScrollView?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_flight)
        initView()
        searchFligfhtRequest()
    }

    private fun initView() {
        rlLoading=findViewById(R.id.rlLoading)
        rvFlightResult=findViewById(R.id.rvFlightResult)
        tvCount=findViewById(R.id.tvCount)
        tvMenu=findViewById(R.id.tvMenu)
        nested=findViewById(R.id.nested)
        tvDetail=findViewById(R.id.tvDetail)
        tvDete=findViewById(R.id.tvDete)
        tvMenu!!.setOnClickListener(this)
        val layoutManager= LinearLayoutManager(context)
        rvFlightResult!!.layoutManager=layoutManager
        ViewCompat.setNestedScrollingEnabled(rvFlightResult!!, false)
        nested!!.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (v.getChildAt(v.childCount - 1) != null) {
                if (scrollY >= v.getChildAt(v.childCount - 1).measuredHeight - v.measuredHeight && scrollY > oldScrollY) {
                    //code to fetch more data for endless scrolling
                    nextPage()
                }
            }
        })

        tvDetail!!.text="از "+ getIntent().getStringExtra("originName") +" به "+getIntent().getStringExtra("destinationName")
        tvDete!!.text="تاریخ رفت: "+ getIntent().getStringExtra("goDate") +"    تاریخ برگشت: "+getIntent().getStringExtra("backDate")

    }
    fun searchFligfhtRequest(){
        rlLoading!!.visibility= View.VISIBLE
        val flightSearchRequest= FlightSearchRequest()
        flightSearchRequest.sessionId="7823939"
        flightSearchRequest.clientUniqueCode="NmE0ODcxYmMtYWQ5OS00ODdiLWIyZGEtNDlmNDE4YjM4NDc0"
        flightSearchRequest.currency="IRR"
        flightSearchRequest.tokenValue= Prefs.getString("token","")
        val searchedPassenger=SearchedPassenger()
        searchedPassenger.adt=getIntent().getIntExtra("adult",0)
        searchedPassenger.chd=getIntent().getIntExtra("child",0)
        searchedPassenger.inf=getIntent().getIntExtra("infant",0)
        searchedPassenger.ycd=0
        searchedPassenger.yth=0
        flightSearchRequest.searchedPassenger=searchedPassenger
        val flightPreferences=FlightPreferences()
        flightPreferences.flightClass=0
        flightPreferences.directFlight=false
        flightPreferences.preferredCompany=null
        flightPreferences.priceLimit=null
        flightSearchRequest.flightPreferences=flightPreferences

        val flightStepList: MutableList<FlightStep> = mutableListOf()
        val originList: MutableList<String> = mutableListOf()
        val destinationList: MutableList<String> = mutableListOf()

        val step=FlightStep()
        step.departureDate= getIntent().getStringExtra("goDate")

        originList.add(getIntent().getStringExtra("origin"))
        step.origin=originList

        destinationList.add(getIntent().getStringExtra("destination"))
        step.destination=destinationList



        val originList2: MutableList<String> = mutableListOf()
        val destinationList2: MutableList<String> = mutableListOf()

        val step2=FlightStep()
        step2.departureDate=getIntent().getStringExtra("backDate")

        originList2.add(getIntent().getStringExtra("destination"))
        step2.origin=originList2

        destinationList2.add(getIntent().getStringExtra("origin"))
        step2.destination=destinationList2

        flightStepList.add(step)
        flightStepList.add(step2)



        flightSearchRequest.flightSteps=flightStepList











        SingletonService.getInstance().flightSearchService().setFlightSearchService(this,flightSearchRequest)
    }




    override fun onReady(response: FlightSearchResponse?) {
        rlLoading!!.visibility= View.INVISIBLE

        try{
            resultFlight.addAll(response!!.flightOffers)

            tvCount!!.text=resultFlight.size.toString()+" مورد یافت شد."
            rvFlightResult!!.adapter= FlightResultAdapter(resultFlightPage,this,this,this)
            rvFlightResult!!.adapter.notifyDataSetChanged()

            nextPage();




        }catch (e:Exception){
            onError(e.message)
        }
    }

    override fun onError(message: String?) {
        rlLoading!!.visibility= View.INVISIBLE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }

    fun nextPage(){


        for (i in i..(i+10)-1){

            resultFlightPage.add(resultFlight.get(i))
        }
        rvFlightResult!!.adapter.notifyItemRangeInserted(i+1,resultFlightPage.size)

        i=i+10



    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.tvMenu->finish()



        }
    }






    override fun change(b: Boolean, position: Int) {
       /* android.os.Handler().postDelayed({
            rvFlightResult!!.adapter.notifyItemChanged(position)
        } as Runnable, 500)

*/
        //  runOnUiThread {  rvFlightResult!!.adapter.notifyItemChanged(position) }
        //  rvFlightResult!!.adapter.notifyItemChanged(position)
    }



    override fun onData(flightOffer: FlightOffer?, position: Int) {
        //Toast.makeText(this, position.toString(), Toast.LENGTH_SHORT).show()

        val offerId = flightOffer!!.offerId
        var referenceGo: String=""
        var referenceBack: String=""


        for (i in 0 until flightOffer.flightItinerary[0].options.size) {

            if (flightOffer.flightItinerary[0].options[i].isSelect) {
                referenceGo = flightOffer.flightItinerary[0].options[i].reference
            }
        }

            for (j in 0 until flightOffer.flightItinerary[1].options.size) {
                if (flightOffer.flightItinerary[1].options[j].isSelect) {
                    referenceBack = flightOffer.flightItinerary[1].options[j].reference




            }


        }


        startActivity(Intent(this, PassengerActivity::class.java)
                .putExtra("adult", getIntent().getIntExtra("adult",0))
                .putExtra("child", getIntent().getIntExtra("child",0))
                .putExtra("infant", getIntent().getIntExtra("infant",0))
                .putExtra("offerId",offerId)
                .putExtra("referenceGo",referenceGo)
                .putExtra("referenceBack",referenceBack)

        )


    }

}
