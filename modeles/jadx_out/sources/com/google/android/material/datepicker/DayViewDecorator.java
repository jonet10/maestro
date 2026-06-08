package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class DayViewDecorator implements Parcelable {
    @Nullable
    public ColorStateList getBackgroundColor(@NonNull Context context, int i, int i6, int i10, boolean z9, boolean z10) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableBottom(@NonNull Context context, int i, int i6, int i10, boolean z9, boolean z10) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableLeft(@NonNull Context context, int i, int i6, int i10, boolean z9, boolean z10) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableRight(@NonNull Context context, int i, int i6, int i10, boolean z9, boolean z10) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableTop(@NonNull Context context, int i, int i6, int i10, boolean z9, boolean z10) {
        return null;
    }

    @Nullable
    public ColorStateList getTextColor(@NonNull Context context, int i, int i6, int i10, boolean z9, boolean z10) {
        return null;
    }

    public void initialize(@NonNull Context context) {
    }

    @Nullable
    public CharSequence getContentDescription(@NonNull Context context, int i, int i6, int i10, boolean z9, boolean z10, @Nullable CharSequence charSequence) {
        return charSequence;
    }
}
