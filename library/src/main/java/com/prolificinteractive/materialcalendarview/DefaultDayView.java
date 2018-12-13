package com.prolificinteractive.materialcalendarview;

import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.widget.TextView;

public class DefaultDayView extends DayView {
    private TextView mDayOfMonth;

    public DefaultDayView(Context context, CalendarDay day) {
        super(context, day);
        mDayOfMonth = new TextView(context);
        mDayOfMonth.setGravity(Gravity.CENTER);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            setTextAlignment(TEXT_ALIGNMENT_CENTER);
        }

        addView(mDayOfMonth);
    }

    @Override
    public TextView getDayOfMonthTextView() {
        return mDayOfMonth;
    }
}
