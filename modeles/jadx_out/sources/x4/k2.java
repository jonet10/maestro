package x4;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spanned;
import j$.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k2 implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public long f11258a;

    /* renamed from: b, reason: collision with root package name */
    public String f11259b;

    /* renamed from: l, reason: collision with root package name */
    public String f11260l;

    /* renamed from: m, reason: collision with root package name */
    public String f11261m;

    /* renamed from: n, reason: collision with root package name */
    public long f11262n;

    /* renamed from: o, reason: collision with root package name */
    public String f11263o;

    /* renamed from: p, reason: collision with root package name */
    public int f11264p;

    /* renamed from: q, reason: collision with root package name */
    public int f11265q;

    /* renamed from: r, reason: collision with root package name */
    public String f11266r;

    /* renamed from: s, reason: collision with root package name */
    public int f11267s;

    /* renamed from: t, reason: collision with root package name */
    public int f11268t;

    /* renamed from: u, reason: collision with root package name */
    public String f11269u;
    public int v;

    /* renamed from: w, reason: collision with root package name */
    public String f11270w;

    /* renamed from: x, reason: collision with root package name */
    public int f11271x;

    /* renamed from: y, reason: collision with root package name */
    public static final q1.a f11257y = new q1.a(16);
    public static Parcelable.Creator<k2> CREATOR = new i0.l(19);

    public final Spanned a() {
        String str = this.f11263o;
        if (str == null) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = j5.t.f6708a;
        return j5.t.a(l7.u.o0(str, "\n", "<br />", false));
    }

    public final boolean b() {
        return this.v == 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeLong(this.f11258a);
        parcel.writeLong(this.f11262n);
        parcel.writeString(this.f11260l);
        parcel.writeString(this.f11259b);
        parcel.writeString(this.f11261m);
        parcel.writeString(this.f11263o);
        parcel.writeInt(this.f11264p);
        parcel.writeInt(this.f11265q);
        parcel.writeString(this.f11266r);
        parcel.writeInt(this.f11267s);
        parcel.writeInt(this.f11268t);
        parcel.writeString(this.f11269u);
        parcel.writeInt(this.v);
        parcel.writeString(this.f11270w);
        parcel.writeInt(this.f11271x);
    }
}
