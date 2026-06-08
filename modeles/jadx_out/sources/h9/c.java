package h9;

import android.graphics.Typeface;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Typeface f5493a;

    /* renamed from: b, reason: collision with root package name */
    public final Typeface f5494b;

    public c(Typeface typeface, Typeface typeface2) {
        this.f5493a = typeface;
        this.f5494b = typeface2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return kotlin.jvm.internal.l.a(this.f5493a, cVar.f5493a) && kotlin.jvm.internal.l.a(this.f5494b, cVar.f5494b);
    }

    public final int hashCode() {
        Typeface typeface = this.f5493a;
        int hashCode = (typeface == null ? 0 : typeface.hashCode()) * 31;
        Typeface typeface2 = this.f5494b;
        return hashCode + (typeface2 != null ? typeface2.hashCode() : 0);
    }

    public final String toString() {
        return "ChoiceFonts(bold=" + this.f5493a + ", regular=" + this.f5494b + ')';
    }
}
