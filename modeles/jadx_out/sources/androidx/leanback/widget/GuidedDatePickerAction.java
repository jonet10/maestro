package androidx.leanback.widget;

import android.content.Context;
import android.os.Bundle;
import androidx.core.location.LocationRequestCompat;
import androidx.leanback.widget.GuidedAction;
import java.util.Calendar;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class GuidedDatePickerAction extends GuidedAction {
    long mDate;
    String mDatePickerFormat;
    long mMinDate = Long.MIN_VALUE;
    long mMaxDate = LocationRequestCompat.PASSIVE_INTERVAL;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Builder extends BuilderBase<Builder> {
        public Builder(Context context) {
            super(context);
        }

        public GuidedDatePickerAction build() {
            GuidedDatePickerAction guidedDatePickerAction = new GuidedDatePickerAction();
            applyDatePickerValues(guidedDatePickerAction);
            return guidedDatePickerAction;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class BuilderBase<B extends BuilderBase> extends GuidedAction.BuilderBase<B> {
        private long mDate;
        private String mDatePickerFormat;
        private long mMaxDate;
        private long mMinDate;

        public BuilderBase(Context context) {
            super(context);
            this.mMinDate = Long.MIN_VALUE;
            this.mMaxDate = LocationRequestCompat.PASSIVE_INTERVAL;
            this.mDate = Calendar.getInstance().getTimeInMillis();
            hasEditableActivatorView(true);
        }

        public final void applyDatePickerValues(GuidedDatePickerAction guidedDatePickerAction) {
            applyValues(guidedDatePickerAction);
            guidedDatePickerAction.mDatePickerFormat = this.mDatePickerFormat;
            guidedDatePickerAction.mDate = this.mDate;
            long j = this.mMinDate;
            long j6 = this.mMaxDate;
            if (j > j6) {
                com.google.gson.internal.a.p("MinDate cannot be larger than MaxDate");
            } else {
                guidedDatePickerAction.mMinDate = j;
                guidedDatePickerAction.mMaxDate = j6;
            }
        }

        public B date(long j) {
            this.mDate = j;
            return this;
        }

        public B datePickerFormat(String str) {
            this.mDatePickerFormat = str;
            return this;
        }

        public B maxDate(long j) {
            this.mMaxDate = j;
            return this;
        }

        public B minDate(long j) {
            this.mMinDate = j;
            return this;
        }
    }

    public long getDate() {
        return this.mDate;
    }

    public String getDatePickerFormat() {
        return this.mDatePickerFormat;
    }

    public long getMaxDate() {
        return this.mMaxDate;
    }

    public long getMinDate() {
        return this.mMinDate;
    }

    @Override // androidx.leanback.widget.GuidedAction
    public void onRestoreInstanceState(Bundle bundle, String str) {
        setDate(bundle.getLong(str, getDate()));
    }

    @Override // androidx.leanback.widget.GuidedAction
    public void onSaveInstanceState(Bundle bundle, String str) {
        bundle.putLong(str, getDate());
    }

    public void setDate(long j) {
        this.mDate = j;
    }
}
