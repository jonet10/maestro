package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import i7.d;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SpannableStringKt {
    public static final void clearSpans(Spannable spannable) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(Spannable spannable, d dVar, Object obj) {
        spannable.setSpan(obj, dVar.f5695a, dVar.f5696b, 17);
    }

    public static final Spannable toSpannable(CharSequence charSequence) {
        return SpannableString.valueOf(charSequence);
    }

    public static final void set(Spannable spannable, int i, int i6, Object obj) {
        spannable.setSpan(obj, i, i6, 17);
    }
}
