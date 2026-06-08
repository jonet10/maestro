package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SpannedStringKt {
    public static final <T> T[] getSpans(Spanned spanned, int i, int i6) {
        l.h();
        throw null;
    }

    public static Object[] getSpans$default(Spanned spanned, int i, int i6, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            spanned.length();
        }
        l.h();
        throw null;
    }

    public static final Spanned toSpanned(CharSequence charSequence) {
        return SpannedString.valueOf(charSequence);
    }
}
