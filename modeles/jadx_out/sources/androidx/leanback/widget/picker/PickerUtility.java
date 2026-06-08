package androidx.leanback.widget.picker;

import android.content.res.Resources;
import com.google.android.material.timepicker.TimeModel;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class PickerUtility {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class DateConstant {
        public final String[] days;
        public final Locale locale;
        public final String[] months;

        public DateConstant(Locale locale, Resources resources) {
            this.locale = locale;
            this.months = DateFormatSymbols.getInstance(locale).getShortMonths();
            Calendar calendar = Calendar.getInstance(locale);
            this.days = PickerUtility.createStringIntArrays(calendar.getMinimum(5), calendar.getMaximum(5), TimeModel.ZERO_LEADING_NUMBER_FORMAT);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class TimeConstant {
        public final String[] ampm;
        public final String[] hours12;
        public final String[] hours24;
        public final Locale locale;
        public final String[] minutes;

        public TimeConstant(Locale locale, Resources resources) {
            this.locale = locale;
            DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
            this.hours12 = PickerUtility.createStringIntArrays(1, 12, TimeModel.ZERO_LEADING_NUMBER_FORMAT);
            this.hours24 = PickerUtility.createStringIntArrays(0, 23, TimeModel.ZERO_LEADING_NUMBER_FORMAT);
            this.minutes = PickerUtility.createStringIntArrays(0, 59, TimeModel.ZERO_LEADING_NUMBER_FORMAT);
            this.ampm = dateFormatSymbols.getAmPmStrings();
        }
    }

    private PickerUtility() {
    }

    public static String[] createStringIntArrays(int i, int i6, String str) {
        String[] strArr = new String[(i6 - i) + 1];
        for (int i10 = i; i10 <= i6; i10++) {
            if (str != null) {
                strArr[i10 - i] = String.format(str, Integer.valueOf(i10));
            } else {
                strArr[i10 - i] = String.valueOf(i10);
            }
        }
        return strArr;
    }

    public static Calendar getCalendarForLocale(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    public static DateConstant getDateConstantInstance(Locale locale, Resources resources) {
        return new DateConstant(locale, resources);
    }

    public static TimeConstant getTimeConstantInstance(Locale locale, Resources resources) {
        return new TimeConstant(locale, resources);
    }
}
