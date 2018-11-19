package library.android.eniac.flight.activity.main

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton
import library.android.calendar.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog
import library.android.calendar.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar
import library.android.eniac.R
import library.android.eniac.base.BaseActivity
import library.android.eniac.flight.activity.search.SearchFlightActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.util.Log
import android.view.View
import com.airbnb.lottie.LottieAnimationView
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.pixplicity.easyprefs.library.Prefs
import library.android.eniac.flight.adapter.NumberPickerAdapter
import library.android.eniac.model.LocationDBModel
import library.android.eniac.ui.ClassDialog
import library.android.eniac.ui.GetCityDialog
import library.android.eniac.ui.PassengerDialog
import library.android.service.generator.SingletonService
import library.android.service.listener.OnServiceStatus
import library.android.service.model.getFlightLocations.request.GetFlightLocationsRequest
import library.android.service.model.getFlightLocations.response.GetFlightLocationsResponse
import saman.zamani.persiandate.PersianDate


class MainFlight : BaseActivity(), FlightView, DatePickerDialog.OnDateSetListener, PassengerDialog.PassengerListener, GetCityDialog.LocationDialog, ClassDialog.ClassDialogListener {



    private var rlLoading: LinearLayout? = null
    private var lottieView: LottieAnimationView? = null

    var flightPresenter: FlightPresenterImpl? = null
    var llBackDate: LinearLayout? = null
    var llGoDate: LinearLayout? = null
    var llDestination: LinearLayout? = null
    var llOrigin: LinearLayout? = null
    var llClass: LinearLayout? = null
    var llPassenger: LinearLayout? = null
    private var datePickerDialogToDate: DatePickerDialog? = null
    private var datePickerDialogFromDate: DatePickerDialog? = null
    private var tvGoDateDate: TextView? = null
    private var tvBackDate: TextView? = null
    private var tvTrip: TextView? = null
    private var tvClass: TextView? = null
    private var tvRoundTrip: TextView? = null
    private var tvOneWay: TextView? = null
    private var tvMulti: TextView? = null
    private var tvDestination: TextView? = null
    private var tvOrigin: TextView? = null
    private var tvAdult: TextView? = null
    private var tvChild: TextView? = null
    private var tvInfant: TextView? = null
    internal var year: Int = 0
    internal var month: Int = 0
    internal var day: Int = 0
    internal var year_today: Int = 0
    internal var month_today: Int = 0
    internal var day_today: Int = 0
    var rvAdult: RecyclerView? = null
    var rvChild: RecyclerView? = null
    var rvInfant: RecyclerView? = null
    var getCityDialog: GetCityDialog? = null
    internal var adult: Int = 1
    internal var child: Int = 0
    internal var infant: Int = 0
    internal var origin: String ? = null
    internal var destination: String ? = null
    internal var originName: String ? = null
    internal var destinationName: String ? = null

    private var btnConfirm: CircularProgressButton? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_flight)
        initView()
        initDate()


    }

    private fun initView() {
        rlLoading = findViewById(R.id.rlLoading)
        flightPresenter = FlightPresenterImpl(this)

        btnConfirm = findViewById(R.id.btnConfirm)
        lottieView = findViewById(R.id.lottieView)
        llBackDate = findViewById(R.id.llBackDate)
        llPassenger = findViewById(R.id.llPassenger)
        llClass = findViewById(R.id.llClass)
        llGoDate = findViewById(R.id.llGoDate)
        tvGoDateDate = findViewById(R.id.tvGoDateDate)
        tvBackDate = findViewById(R.id.tvBackDate)
        rvAdult = findViewById(R.id.rvAdult)
        rvChild = findViewById(R.id.rvChild)
        rvInfant = findViewById(R.id.rvInfant)
        tvRoundTrip = findViewById(R.id.tvRoundTrip)
        tvOneWay = findViewById(R.id.tvOneWay)
        tvMulti = findViewById(R.id.tvMulti)
        tvTrip = findViewById(R.id.tvTrip)
        tvClass = findViewById(R.id.tvClass)
        llDestination = findViewById(R.id.llDestination)
        llOrigin = findViewById(R.id.llOrigin)
        tvDestination = findViewById(R.id.tvDestination)
        tvOrigin = findViewById(R.id.tvOrigin)
        tvAdult = findViewById(R.id.tvAdult)
        tvChild = findViewById(R.id.tvChild)
        tvInfant = findViewById(R.id.tvInfant)
        btnConfirm!!.setText(R.string.search)
        btnConfirm!!.setOnClickListener(flightPresenter)
        llBackDate!!.setOnClickListener(flightPresenter)
        llGoDate!!.setOnClickListener(flightPresenter)
        tvRoundTrip!!.setOnClickListener(flightPresenter)
        tvOneWay!!.setOnClickListener(flightPresenter)
        tvMulti!!.setOnClickListener(flightPresenter)
        llDestination!!.setOnClickListener(flightPresenter)
        llOrigin!!.setOnClickListener(flightPresenter)
        llClass!!.setOnClickListener(flightPresenter)
        llPassenger!!.setOnClickListener(flightPresenter)

        getCityDialog = GetCityDialog(this, this)

        val layoutManager = FlexboxLayoutManager()
        layoutManager.setFlexWrap(FlexWrap.NOWRAP)

        val layoutManager2 = FlexboxLayoutManager()
        layoutManager2.setFlexWrap(FlexWrap.NOWRAP)

        val layoutManager3 = FlexboxLayoutManager()
        layoutManager3.setFlexWrap(FlexWrap.NOWRAP)


        rvAdult!!.layoutManager = layoutManager
        rvChild!!.layoutManager = layoutManager2
        rvInfant!!.layoutManager = layoutManager3
        rvAdult!!.adapter = NumberPickerAdapter(1)
        rvChild!!.adapter = NumberPickerAdapter(2)
        rvInfant!!.adapter = NumberPickerAdapter(3)


    }

    fun initDate() {

        val persianCalendar = PersianCalendar()
        val persianCalendar2 = PersianCalendar()
        persianCalendar2.set(persianCalendar.getPersianYear(), persianCalendar.getPersianMonth(), persianCalendar.getPersianDay() + 1)


        year_today = persianCalendar.getPersianYear()
        month_today = persianCalendar.getPersianMonth()
        day_today = persianCalendar.getPersianDay()
        datePickerDialogToDate = DatePickerDialog.newInstance(
                this,
                persianCalendar.getPersianYear(),
                persianCalendar.getPersianMonth(),
                persianCalendar.getPersianDay() + 1
        )
        datePickerDialogFromDate = DatePickerDialog.newInstance(
                this,
                persianCalendar.getPersianYear(),
                persianCalendar.getPersianMonth(),
                persianCalendar.getPersianDay()
        )


        year = persianCalendar.getPersianYear()
        month = persianCalendar.getPersianMonth()
        day = persianCalendar.getPersianDay()
        datePickerDialogFromDate!!.setMinDate(persianCalendar)
        datePickerDialogToDate!!.setMinDate(persianCalendar2)
    }


    override fun showProgress() {
        rlLoading!!.visibility = View.VISIBLE

    }

    override fun hideProgress() {
        runOnUiThread({ rlLoading!!.visibility = View.GONE })

    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


    }

    override fun onFinish(resultCode: Int) {
    }

    override fun onGoDate() {
        if (datePickerDialogFromDate!!.isAdded() || datePickerDialogToDate!!.isAdded())
            return

        datePickerDialogFromDate!!.setTitle("")
        datePickerDialogFromDate!!.show(supportFragmentManager, "FromDate")

    }

    override fun onBackDate() {
        if (datePickerDialogFromDate!!.isAdded() || datePickerDialogToDate!!.isAdded())
            return

        val calendar = PersianCalendar()
        calendar.set(year, month, day)
        datePickerDialogToDate!!.setPersianCalendar(calendar)

        datePickerDialogToDate!!.setTitle("")
        datePickerDialogToDate!!.setMinDate(calendar)
        datePickerDialogToDate!!.show(supportFragmentManager, "ToDate")


    }


    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int, endYear: Int, endMonth: Int, endDay: Int) {
        if (view!!.getTag().equals("ToDate")) {
            val calendar = PersianCalendar()


            tvBackDate!!.setText(year.toString() + "-" + (monthOfYear + 1) + "-" + dayOfMonth)
            tvBackDate!!.setTextSize(18F)
            tvBackDate!!.setTextColor(resources.getColor(R.color.textColor3))

            this.year_today = year
            this.month_today = monthOfYear
            this.day_today = dayOfMonth

            calendar.set(year_today, month_today, day_today)
            datePickerDialogToDate!!.setPersianCalendar(calendar)


            return
        }
        if (view.getTag().equals("FromDate")) {

            this.year = year
            this.month = monthOfYear
            this.day = dayOfMonth
            tvGoDateDate!!.setText(year.toString() + "-" + (monthOfYear + 1) + "-" + dayOfMonth)
            tvGoDateDate!!.setTextSize(18F)
            tvGoDateDate!!.setTextColor(resources.getColor(R.color.textColor3))


            val calendar = PersianCalendar()
            val calendar2 = PersianCalendar()
            calendar.set(year, monthOfYear, dayOfMonth)
            calendar2.set(year_today, month_today, day_today)

            datePickerDialogFromDate!!.setPersianCalendar(calendar)


            if (calendar.timeInMillis > calendar2.timeInMillis) {
                tvBackDate!!.setText(year.toString() + "-" + (monthOfYear + 1) + "-" + dayOfMonth)

            }


        }
    }

    override fun onSerach() {
        if (tvOrigin!!.text.toString().contains("انتخاب")) {
            onError("لطفا شهر مبداء را نتخاب نمایید")
            return
        }


        if (tvDestination!!.text.toString().contains("انتخاب")) {
            onError("لطفا شهر مقصد را نتخاب نمایید")
            return
        }
        if (tvGoDateDate!!.text.toString().contains("انتخاب")) {
            onError("لطفا تاریخ رفت را نتخاب نمایید")
            return
        }


        if (tvBackDate!!.text.toString().contains("انتخاب")) {
            onError("لطفا تاریخ برگشت را نتخاب نمایید")
            return
        }



        val date = tvGoDateDate!!.text.toString().split("-".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()

        val persianDate = PersianDate()
        persianDate.setShYear(Integer.valueOf(date[0]))
        persianDate.setShMonth(Integer.valueOf(date[1]))
        persianDate.setShDay(Integer.valueOf(date[2]))
        val goDate = persianDate.grgYear.toString() + "-" + persianDate.grgMonth + "-" + persianDate.grgDay


        val date2 = tvBackDate!!.text.toString().split("-".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
        val persianDate2 = PersianDate()
        persianDate2.setShYear(Integer.valueOf(date2[0]))
        persianDate2.setShMonth(Integer.valueOf(date2[1]))
        persianDate2.setShDay(Integer.valueOf(date2[2]))
        val backDate = persianDate2.grgYear.toString() + "-" + persianDate2.grgMonth + "-" + persianDate2.grgDay




        startActivity(Intent(this, SearchFlightActivity::class.java)
                .putExtra("goDate", goDate)
                .putExtra("backDate", backDate)
                .putExtra("adult", adult)
                .putExtra("child", child)
                .putExtra("infant", infant)
                .putExtra("origin",origin)
                .putExtra("destination",destination)
                .putExtra("originName",originName)
                .putExtra("destinationName",destinationName))
    }

    override fun onOnWay() {
        tvTrip!!.text = "یک طرفه"

        tvMulti!!.background = ContextCompat.getDrawable(this, R.drawable.background40)
        tvRoundTrip!!.background = ContextCompat.getDrawable(this, R.drawable.background40)
        tvOneWay!!.background = ContextCompat.getDrawable(this, R.drawable.background41)
    }

    override fun onMulti() {
        tvTrip!!.text = "چند مسیره"
        tvMulti!!.background = ContextCompat.getDrawable(this, R.drawable.background41)
        tvRoundTrip!!.background = ContextCompat.getDrawable(this, R.drawable.background40)
        tvOneWay!!.background = ContextCompat.getDrawable(this, R.drawable.background40)
    }

    override fun onRoundTrip() {
        tvTrip!!.text = "رفت و برگشت"
        tvMulti!!.background = ContextCompat.getDrawable(this, R.drawable.background40)
        tvRoundTrip!!.background = ContextCompat.getDrawable(this, R.drawable.background41)
        tvOneWay!!.background = ContextCompat.getDrawable(this, R.drawable.background40)


    }

    override fun onDetination() {
        getCityDialog!!.setDestination(true)

        getCityDialog!!.show(fragmentManager, "getCityDialog")


    }

    override fun onOrigin() {
        getCityDialog!!.setDestination(false)

        getCityDialog!!.show(fragmentManager, "getCityDialog")

    }

    override fun onClass() {
        var classDialog = ClassDialog(this,this)
        classDialog!!.show(fragmentManager, "classDialog")

    }

    override fun onPassenger() {
        var passengerDialog = PassengerDialog(this, this, adult, child, infant)
        passengerDialog!!.show(fragmentManager, "passengerDialog")
    }

    override fun setPassenger(adult: Int, child: Int, infant: Int) {
        this.adult = adult
        this.child = child
        this.infant = adult
        tvAdult!!.text = adult.toString()
        tvChild!!.text = child.toString()
        tvInfant!!.text = infant.toString()
    }

    override fun onSelectCity(name: String?,id:Int, isDestination: Boolean,iataCode: String?) {

        if (isDestination) {
            destinationName=name
            destination=iataCode
            tvDestination!!.text = name
            tvDestination!!.setTextSize(18F)
            tvDestination!!.setTextColor(resources.getColor(R.color.white))
            lottieView!!.playAnimation()

        } else {
            originName=name
            origin=iataCode
            tvOrigin!!.text = name
            tvOrigin!!.setTextSize(18F)
            tvOrigin!!.setTextColor(resources.getColor(R.color.white))

        }
    }
    override fun inSelectClass(name: String?) {
        tvClass!!.text = name

    }



}
