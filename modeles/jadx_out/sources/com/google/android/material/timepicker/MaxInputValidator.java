package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
class MaxInputValidator implements InputFilter {
    private int max;

    public MaxInputValidator(int i) {
        this.max = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i6, Spanned spanned, int i10, int i11) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i10, i11, charSequence.subSequence(i, i6).toString());
            if (Integer.parseInt(sb.toString()) <= this.max) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int i) {
        this.max = i;
    }
}
