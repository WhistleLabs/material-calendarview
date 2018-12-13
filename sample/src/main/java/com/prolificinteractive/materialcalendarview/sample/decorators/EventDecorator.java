package com.prolificinteractive.materialcalendarview.sample.decorators;

import android.text.SpannableString;
import android.text.Spanned;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayView;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.util.Collection;
import java.util.HashSet;

/**
 * Decorate several days with a dot
 */
public class EventDecorator implements DayViewDecorator {

    private int color;
    private HashSet<CalendarDay> dates;

    public EventDecorator(int color, Collection<CalendarDay> dates) {
        this.color = color;
        this.dates = new HashSet<>(dates);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayView view) {
        SpannableString formattedLabel = new SpannableString(view.getLabel());
        formattedLabel.setSpan(new DotSpan(5, color), 0, view.getLabel().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        view.getDayOfMonthTextView().setText(formattedLabel);
    }
}
