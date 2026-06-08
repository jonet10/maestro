package s8;

import com.google.android.gms.internal.measurement.z3;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final w8.k f9381d;

    /* renamed from: e, reason: collision with root package name */
    public static final w8.k f9382e;
    public static final w8.k f;
    public static final w8.k g;
    public static final w8.k h;
    public static final w8.k i;

    /* renamed from: a, reason: collision with root package name */
    public final w8.k f9383a;

    /* renamed from: b, reason: collision with root package name */
    public final w8.k f9384b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9385c;

    static {
        w8.k kVar = w8.k.f10970m;
        f9381d = z3.m(":");
        f9382e = z3.m(":status");
        f = z3.m(":method");
        g = z3.m(":path");
        h = z3.m(":scheme");
        i = z3.m(":authority");
    }

    public b(w8.k kVar, w8.k kVar2) {
        this.f9383a = kVar;
        this.f9384b = kVar2;
        this.f9385c = kVar2.f() + kVar.f() + 32;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f9383a.equals(bVar.f9383a) && this.f9384b.equals(bVar.f9384b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f9384b.hashCode() + ((this.f9383a.hashCode() + 527) * 31);
    }

    public final String toString() {
        String t9 = this.f9383a.t();
        String t10 = this.f9384b.t();
        byte[] bArr = n8.c.f8114a;
        Locale locale = Locale.US;
        return a4.x.k(t9, ": ", t10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(w8.k kVar, String str) {
        this(kVar, z3.m(str));
        w8.k kVar2 = w8.k.f10970m;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(String str, String str2) {
        this(z3.m(str), z3.m(str2));
        w8.k kVar = w8.k.f10970m;
    }
}
