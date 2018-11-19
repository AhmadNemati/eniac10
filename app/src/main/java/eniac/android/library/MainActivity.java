package eniac.android.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import library.android.eniac.ActivityType;
import library.android.eniac.StartEniacActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StartEniacActivity eniacActivity = new StartEniacActivity("0037250100293610","1397",ActivityType.FLIGHT);

        eniacActivity.start();


        try {
            if (isTimeBetweenTwoTime("14:00:00","20:00:00","17:00:00")){
                Log.e("test", "true " );
            }else{
                Log.e("test", "false " );

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    public static final boolean isBetweenValidTime(Date startTime, Date endTime, Date validateTime)
    {
        boolean validTimeFlag = false;

        if(endTime.compareTo(startTime) <= 0)
        {
            if(validateTime.compareTo(endTime) < 0 || validateTime.compareTo(startTime) >= 0)
            {
                validTimeFlag = true;
            }
        }
        else if(validateTime.compareTo(endTime) < 0 && validateTime.compareTo(startTime) >= 0)
        {
            validTimeFlag = true;
        }

        return validTimeFlag;
    }

    public static boolean isTimeBetweenTwoTime(Date startTime, Date stopTime, Date currentTime) {
        //Start Time
        Calendar StartTime = Calendar.getInstance();
        StartTime.setTime(startTime);
        //Current Time
        Calendar CurrentTime = Calendar.getInstance();
        CurrentTime.setTime(currentTime);
        //Stop Time
        Calendar StopTime = Calendar.getInstance();
        StopTime.setTime(stopTime);

        if (stopTime.compareTo(startTime) < 0) {
            if (CurrentTime.compareTo(StopTime) < 0) {
                CurrentTime.add(Calendar.DATE, 1);
            }
            StopTime.add(Calendar.DATE, 1);
        }
        return CurrentTime.compareTo(StartTime) >= 0 && CurrentTime.compareTo(StopTime) < 0;
    }

    public static boolean isTimeBetweenTwoTime(String argStartTime,
                                               String argEndTime, String argCurrentTime) throws ParseException {
        String reg = "^([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
        //
        if (argStartTime.matches(reg) && argEndTime.matches(reg)
                && argCurrentTime.matches(reg)) {
            boolean valid = false;
            // Start Time
            java.util.Date startTime = new SimpleDateFormat("HH:mm:ss")
                    .parse(argStartTime);
            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(startTime);

            // Current Time
            java.util.Date currentTime = new SimpleDateFormat("HH:mm:ss")
                    .parse(argCurrentTime);
            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.setTime(currentTime);

            // End Time
            java.util.Date endTime = new SimpleDateFormat("HH:mm:ss")
                    .parse(argEndTime);
            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(endTime);

            //
            if (currentTime.compareTo(endTime) < 0) {

                currentCalendar.add(Calendar.DATE, 1);
                currentTime = currentCalendar.getTime();

            }

            if (startTime.compareTo(endTime) < 0) {

                startCalendar.add(Calendar.DATE, 1);
                startTime = startCalendar.getTime();

            }
            //
            if (currentTime.before(startTime)) {

                System.out.println(" Time is Lesser ");

                valid = false;
            } else {

                if (currentTime.after(endTime)) {
                    endCalendar.add(Calendar.DATE, 1);
                    endTime = endCalendar.getTime();

                }

                System.out.println("Comparing , Start Time /n " + startTime);
                System.out.println("Comparing , End Time /n " + endTime);
                System.out
                        .println("Comparing , Current Time /n " + currentTime);

                if (currentTime.before(endTime)) {
                    System.out.println("RESULT, Time lies b/w");
                    valid = true;
                } else {
                    valid = false;
                    System.out.println("RESULT, Time does not lies b/w");
                }

            }
            return valid;

        } else {
            throw new IllegalArgumentException(
                    "Not a valid time, expecting HH:MM:SS format");
        }

    }
}
