package com.prolificinteractive.materialcalendarview;

import android.content.Context;

public class DefaultDayViewProvider extends DayViewProvider {
    public DefaultDayViewProvider(Context context) {
        super(context);
    }

    @Override
    public DayView getDayView(CalendarDay day) {
        return new DefaultDayView(getContext(), day);
    }
}
