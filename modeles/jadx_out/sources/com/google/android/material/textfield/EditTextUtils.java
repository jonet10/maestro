package com.google.android.material.textfield;

import android.widget.EditText;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
class EditTextUtils {
    private EditTextUtils() {
    }

    public static boolean isEditable(@NonNull EditText editText) {
        return editText.getInputType() != 0;
    }
}
