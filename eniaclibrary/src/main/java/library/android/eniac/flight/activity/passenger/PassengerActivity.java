package library.android.eniac.flight.activity.passenger;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pixplicity.easyprefs.library.Prefs;

import java.util.ArrayList;
import java.util.List;

import library.android.calendar.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import library.android.calendar.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;
import library.android.eniac.R;
import library.android.eniac.base.BaseActivity;
import library.android.eniac.flight.adapter.PassengerAdapter;
import library.android.eniac.model.PassengerModel;
import library.android.service.generator.SingletonService;
import library.android.service.listener.OnServiceStatus;
import library.android.service.model.reservation.request.BookReservation;
import library.android.service.model.reservation.request.ContactInfo;
import library.android.service.model.reservation.request.Customer;
import library.android.service.model.reservation.request.Passport;
import library.android.service.model.reservation.request.PaymentformOption;
import library.android.service.model.reservation.request.PricedReference;
import library.android.service.model.reservation.request.ReservationRequest;
import library.android.service.model.reservation.request.Telephone;
import library.android.service.model.reservation.request.TicketingCombination;
import library.android.service.model.reservation.request.Traveler;
import library.android.service.model.reservation.response.ReservationResponse;
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;
import saman.zamani.persiandate.PersianDate;

public class PassengerActivity extends BaseActivity implements PassengerAdapter.AdapterHelper, DatePickerDialog.OnDateSetListener ,OnServiceStatus<ReservationResponse>{
    private RecyclerView rvList;
    private List<PassengerModel> passengerModels = new ArrayList<>();
    private ScrollingPagerIndicator indicator;
    private TextView tvTitle, btnConfirm;
    private LinearLayout rlLoading;

    private int adult;
    private int child;
    private int infant;
    private DatePickerDialog datePickerDialog;
    private int position;
    private PassengerAdapter passengerAdapter;
    private EditText editText;
    private String offerId, referenceGo, referenceBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST);
        setContentView(R.layout.activity_passenger);
        adult = getIntent().getIntExtra("adult", 0);
        child = getIntent().getIntExtra("child", 0);
        infant = getIntent().getIntExtra("infant", 0);
        offerId = getIntent().getStringExtra("offerId");
        referenceGo = getIntent().getStringExtra("referenceGo");
        referenceBack = getIntent().getStringExtra("referenceBack");


        initView();
        initDatePicker();

    }

    void initDatePicker() {
        PersianCalendar persianCalendar = new PersianCalendar();
        datePickerDialog = DatePickerDialog.newInstance(
                PassengerActivity.this,
                persianCalendar.getPersianYear(),
                persianCalendar.getPersianMonth(),
                persianCalendar.getPersianDay()
        );
        datePickerDialog.setMinDate(persianCalendar);


    }

    private void initView() {
        rvList = findViewById(R.id.rvList);
        btnConfirm = findViewById(R.id.btnConfirm);
        rlLoading = findViewById(R.id.rlLoading);
        indicator = findViewById(R.id.indicator);
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("اطلاعات مسافران");
        rvList.setLayoutManager(new LinearLayoutManager(this));
 /*       SnapHelper snapHelper = new GravitySnapHelper(Gravity.START);
        snapHelper.attachToRecyclerView(rvList);*/


        for (int i = 0; i < adult; i++) {
            PassengerModel passengerModel = new PassengerModel();
            passengerModel.setAdult(true);
            passengerModel.setChild(false);
            passengerModel.setInfant(false);
            passengerModel.setCount(adult);

            passengerModels.add(passengerModel);

        }

        for (int i = 0; i < child; i++) {
            PassengerModel passengerModel = new PassengerModel();
            passengerModel.setAdult(false);
            passengerModel.setChild(true);
            passengerModel.setInfant(false);
            passengerModel.setCount(child);

            passengerModels.add(passengerModel);
        }
        for (int i = 0; i < infant; i++) {
            PassengerModel passengerModel = new PassengerModel();
            passengerModel.setAdult(false);
            passengerModel.setChild(false);
            passengerModel.setInfant(true);
            passengerModel.setCount(infant);

            passengerModels.add(passengerModel);
        }
        passengerAdapter = new PassengerAdapter(passengerModels, this, this);
        rvList.setAdapter(passengerAdapter);
        // indicator.attachToRecyclerView(rvList);

        btnConfirm.setOnClickListener(view -> {
            boolean valid=true;
           /* Log.e("date", ((EditText) rvList.findViewHolderForItemId(0).itemView.findViewById(R.id.etBirthDay)).getText().toString());
            Log.e("date", ((EditText) rvList.findViewHolderForItemId(1).itemView.findViewById(R.id.etBirthDay)).getText().toString());
            Log.e("date", ((EditText) rvList.findViewHolderForItemId(2).itemView.findViewById(R.id.etBirthDay)).getText().toString());*/


            for (int i = 0; i < passengerModels.size(); i++) {
                PassengerAdapter.ViewHolder holder = passengerAdapter.getMyViewHolders().get(i);

                Traveler traveler = new Traveler();



                if (TextUtils.isEmpty(holder.etFirstName.getText())){
                    valid=false;
                    Toast.makeText(this, "لطفا نام مسافر " + (i+1) + " را وارد نمایید.", Toast.LENGTH_LONG).show();

                }
                else
                    traveler.setPersianGivenName(holder.etFirstName.getText().toString());




                if (TextUtils.isEmpty(holder.etLastName.getText())){
                    valid=false;
                    Toast.makeText(this, "لطفا نام خانوادگی مسافر " + (i+1) + " را وارد نمایید.", Toast.LENGTH_LONG).show();

                }
                else
                    traveler.setPersianSurname(holder.etLastName.getText().toString());




                if (TextUtils.isEmpty(holder.etFirstNameEn.getText())) {
                    valid=false;

                    Toast.makeText(this, "لطفا نام انگلیسی مسافر " + (i + 1) + " را وارد نمایید.", Toast.LENGTH_LONG).show();
                }
                else
                    traveler.setGivenName(holder.etFirstNameEn.getText().toString());






                if (TextUtils.isEmpty(holder.etLastNameEn.getText())) {
                    valid=false;

                    Toast.makeText(this, "لطفا نام خانوادگی انگلیسی مسافر " + (i + 1) + " را وارد نمایید.", Toast.LENGTH_LONG).show();
                }
                else
                    traveler.setSurname(holder.etLastNameEn.getText().toString());





                if (TextUtils.isEmpty(holder.etGender.getText())) {
                    valid=false;

                    Toast.makeText(this, "لطفا جنسیت مسافر " + (i + 1) + " را وارد نمایید.", Toast.LENGTH_LONG).show();
                }
                else{
                    if (holder.etGender.getText().toString().equals("مرد"))
                        traveler.setGender(0);
                    else
                        traveler.setGender(1);

                }





                if (TextUtils.isEmpty(holder.etNationalCode.getText())) {
                    valid=false;

                    Toast.makeText(this, "لطفا کد ملی مسافر " + (i + 1) + " را وارد نمایید.", Toast.LENGTH_LONG).show();
                }
                else
                    traveler.setDocNo(holder.etNationalCode.getText().toString());




                if (TextUtils.isEmpty(holder.etBirthDay.getText())){
                    valid=false;

                    Toast.makeText(this, "لطفا تاریخ تولد مسافر " + (i+1) + " را وارد نمایید.", Toast.LENGTH_LONG).show();}
                else{

                    String []date=holder.etBirthDay.getText().toString().split("-");
                    PersianDate persianDate = new PersianDate();
                    persianDate.setShYear(Integer.valueOf(date[0]));
                    persianDate.setShMonth(Integer.valueOf(date[1]));
                    persianDate.setShDay(Integer.valueOf(date[2]));

                    traveler.setBirthDate(persianDate.getGrgYear()+"-"+persianDate.getGrgMonth()+"-"+persianDate.getGrgDay());

                }





                if (TextUtils.isEmpty(holder.etExpireDate.getText())){
                    valid=false;

                    Toast.makeText(this, "لطفا تاریخ انقضا پاسپورت مسافر " + (i+1) + " را وارد نمایید.", Toast.LENGTH_LONG).show();}
                else{
                    String []date=holder.etBirthDay.getText().toString().split("-");
                    PersianDate persianDate = new PersianDate();
                    persianDate.setShYear(Integer.valueOf(date[0]));
                    persianDate.setShMonth(Integer.valueOf(date[1]));
                    persianDate.setShDay(Integer.valueOf(date[2]));


                    Passport passport = new Passport();
                    passport.setValidityDate(persianDate.getGrgYear()+"-"+persianDate.getGrgMonth()+"-"+persianDate.getGrgDay());
                    passport.setIssued("IR");
                    passport.setCitizenship("IR");
                    traveler.setPassport(passport);
                }
                traveler.setNamePrefix(0);
                traveler.setMobile("09301234567");
                traveler.setPassengerType(0);
                traveler.setDocType(0);

                passengerModels.get(i).setTraveler(traveler);



        }
        if (valid)
        reservation();


        });


    }

    @Override
    public void openCalendar(int position, EditText editText) {
        this.position = position;
        this.editText = editText;
        // datePickerDialog.setTitle("تاریخ تولد");
        datePickerDialog.show(getSupportFragmentManager(), "openCalendar");
    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int endYear, int endMonth, int endDay) {
        setCalendarData(year + "-" + monthOfYear + "-" + dayOfMonth, position, editText);


    }

    public void setCalendarData(String date, int position, EditText editText) {

        editText.setText(date);

    }


    // ((EditText) rvList.getLayoutManager().findViewByPosition(position).findViewById(R.id.etBirthDay)).setText(date);
    //  passengerAdapter.notifyItemChanged(position);



    public void reservation(){
        ReservationRequest request= new ReservationRequest();
        List<BookReservation> bookReservationArrayList= new ArrayList<>();
        BookReservation bookReservation = new BookReservation();
        bookReservation.setOfferId(offerId);
     bookReservation.setComment(null);
        bookReservation.setSystemId("10");
        bookReservation.setExternalReservationId("1395051609");


        Customer customer= new Customer();
       customer.setBillingInfo(null);
       customer.setShippingInfo(null);
        ContactInfo contactInfo= new ContactInfo();
        contactInfo.setContactName("eniac");
        contactInfo.setEmail("eniac@gmail.com");
        Telephone telephone= new Telephone();
        telephone.setPhoneNumber("9877296495");
        contactInfo.setTelephone(telephone);
        customer.setContactInfo(contactInfo);
        bookReservation.setCustomer(customer);


        PricedReference pricedReference = new PricedReference();
        pricedReference.setPrice("12798000");

        List<String> strings= new ArrayList<>();
        strings.add(referenceGo);
        strings.add(referenceBack);

        pricedReference.setReferences(strings);
        bookReservation.setPricedReference(pricedReference);

        List<Traveler>travelers= new ArrayList<>();


        for (int i = 0; i < passengerModels.size(); i++) {
            travelers.add(passengerModels.get(i).getTraveler());

        }

        bookReservation.setTravelers(travelers);


        bookReservationArrayList.add(bookReservation);






        request.setBookReservations(bookReservationArrayList);

        request.setCurrency("IRR");
        request.setTokenValue(Prefs.getString("token",""));
        request.setSessionId("7823939");
        request.setHappyPassword("1397");
        request.setHappyUsername("0037250100293610");


        List<TicketingCombination> ticketingCombinations= new ArrayList<>();

        TicketingCombination ticketingCombination= new TicketingCombination();
        PaymentformOption paymentformOption= new PaymentformOption();
        paymentformOption.setId("1736");
        paymentformOption.setPrice(0);
        paymentformOption.setRate("0");
        paymentformOption.setRatedFor("abs");
        ticketingCombination.setPaymentformOption(paymentformOption);
        ticketingCombinations.add(ticketingCombination);

        TicketingCombination ticketingCombination2= new TicketingCombination();
        PaymentformOption paymentformOption2= new PaymentformOption();
        paymentformOption2.setId("715");
        paymentformOption2.setPrice(0);
        paymentformOption2.setRate("0");
        paymentformOption2.setRatedFor("abs");
        ticketingCombination2.setPaymentformOption(paymentformOption2);
        ticketingCombinations.add(ticketingCombination2);


        request.setTicketingCombinations(ticketingCombinations);


        rlLoading.setVisibility(View.VISIBLE);

        SingletonService.getInstance().getReservationService().ReservationService(this,request);



    }


    @Override
    public void onReady(ReservationResponse reservationResponse) {
        rlLoading.setVisibility(View.GONE);

        try{
            Toast.makeText(this,reservationResponse.getOfferId(), Toast.LENGTH_SHORT).show();

        }catch (Exception e){

            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onError(String message) {
        rlLoading.setVisibility(View.GONE);

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}
