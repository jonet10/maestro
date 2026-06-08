package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public interface DateSelector<S> extends Parcelable {
    @StyleRes
    int getDefaultThemeResId(Context context);

    @StringRes
    int getDefaultTitleResId();

    @Nullable
    String getError();

    @NonNull
    Collection<Long> getSelectedDays();

    @NonNull
    Collection<Pair<Long, Long>> getSelectedRanges();

    @Nullable
    S getSelection();

    @NonNull
    String getSelectionContentDescription(@NonNull Context context);

    @NonNull
    String getSelectionDisplayString(Context context);

    boolean isSelectionComplete();

    @NonNull
    View onCreateTextInputView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, @NonNull CalendarConstraints calendarConstraints, @NonNull OnSelectionChangedListener<S> onSelectionChangedListener);

    void select(long j);

    void setSelection(@NonNull S s6);

    void setTextInputFormat(@Nullable SimpleDateFormat simpleDateFormat);
}
