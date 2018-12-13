package com.prolificinteractive.materialcalendarview;

import android.content.Context;

public abstract class DayViewProvider {
    private final Context mContext;

    public DayViewProvider(Context context) {
        mContext = context;
    }

    public abstract DayView getDayView(CalendarDay day);

    public Context getContext() {
        return mContext;
    }
}
