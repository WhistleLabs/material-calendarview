package com.prolificinteractive.materialcalendarview.sample.decorators;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayView;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Date;

/**
 * Decorate a day by making the text big and bold
 */
public class OneDayDecorator implements DayViewDecorator {

    private CalendarDay date;

    public OneDayDecorator() {
        date = CalendarDay.today();
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return date != null && day.equals(date);
    }

    @Override
    public void decorate(DayView view) {
        SpannableString formattedLabel = new SpannableString(view.getLabel());
        formattedLabel.setSpan(new StyleSpan(Typeface.BOLD), 0, view.getLabel().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        formattedLabel.setSpan(new RelativeSizeSpan(1.4f), 0, view.getLabel().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        view.getDayOfMonthTextView().setText(formattedLabel);
    }

    /**
     * We're changing the internals, so make sure to call {@linkplain MaterialCalendarView#invalidateDecorators()}
     */
    public void setDate(Date date) {
        this.date = CalendarDay.from(date);
    }
}
