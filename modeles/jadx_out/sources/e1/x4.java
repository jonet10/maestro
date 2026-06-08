package e1;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x4 extends l0.a {
    public static final Parcelable.Creator<x4> CREATOR = new android.support.v4.media.f(19);

    /* renamed from: a, reason: collision with root package name */
    public final int f4401a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4402b;

    /* renamed from: l, reason: collision with root package name */
    public final long f4403l;

    /* renamed from: m, reason: collision with root package name */
    public final Long f4404m;

    /* renamed from: n, reason: collision with root package name */
    public final String f4405n;

    /* renamed from: o, reason: collision with root package name */
    public final String f4406o;

    /* renamed from: p, reason: collision with root package name */
    public final Double f4407p;

    public x4(long j, Object obj, String str, String str2) {
        k0.y.d(str);
        this.f4401a = 2;
        this.f4402b = str;
        this.f4403l = j;
        this.f4406o = str2;
        if (obj == null) {
            this.f4404m = null;
            this.f4407p = null;
            this.f4405n = null;
            return;
        }
        if (obj instanceof Long) {
            this.f4404m = (Long) obj;
            this.f4407p = null;
            this.f4405n = null;
        } else if (obj instanceof String) {
            this.f4404m = null;
            this.f4407p = null;
            this.f4405n = (String) obj;
        } else {
            if (!(obj instanceof Double)) {
                com.google.gson.internal.a.p("User attribute given of un-supported type");
                throw null;
            }
            this.f4404m = null;
            this.f4407p = (Double) obj;
            this.f4405n = null;
        }
    }

    public final Object c() {
        Long l10 = this.f4404m;
        if (l10 != null) {
            return l10;
        }
        Double d10 = this.f4407p;
        if (d10 != null) {
            return d10;
        }
        String str = this.f4405n;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        android.support.v4.media.f.b(this, parcel);
    }

    public x4(int i, String str, long j, Long l10, Float f, String str2, String str3, Double d10) {
        this.f4401a = i;
        this.f4402b = str;
        this.f4403l = j;
        this.f4404m = l10;
        this.f4407p = i == 1 ? f != null ? Double.valueOf(f.doubleValue()) : null : d10;
        this.f4405n = str2;
        this.f4406o = str3;
    }

    public x4(y4 y4Var) {
        this(y4Var.f4428d, y4Var.f4429e, y4Var.f4427c, y4Var.f4426b);
    }
}
