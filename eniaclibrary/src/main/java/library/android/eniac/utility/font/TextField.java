package library.android.eniac.utility.font;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import library.android.eniac.R;


/**
 * Created by RezaNejati on 7/2/2018.
 */

public class TextField extends TextView {

    public TextField(final Context context, final AttributeSet attrs) {
        super(context, attrs, R.attr.fontPathCalligraphyConfig);
    }

}
