package e1;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends l0.a {
    public static final Parcelable.Creator<e> CREATOR = new android.support.v4.media.f(11);

    /* renamed from: a, reason: collision with root package name */
    public String f3882a;

    /* renamed from: b, reason: collision with root package name */
    public String f3883b;

    /* renamed from: l, reason: collision with root package name */
    public x4 f3884l;

    /* renamed from: m, reason: collision with root package name */
    public long f3885m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3886n;

    /* renamed from: o, reason: collision with root package name */
    public String f3887o;

    /* renamed from: p, reason: collision with root package name */
    public final u f3888p;

    /* renamed from: q, reason: collision with root package name */
    public long f3889q;

    /* renamed from: r, reason: collision with root package name */
    public u f3890r;

    /* renamed from: s, reason: collision with root package name */
    public final long f3891s;

    /* renamed from: t, reason: collision with root package name */
    public final u f3892t;

    public e(e eVar) {
        k0.y.g(eVar);
        this.f3882a = eVar.f3882a;
        this.f3883b = eVar.f3883b;
        this.f3884l = eVar.f3884l;
        this.f3885m = eVar.f3885m;
        this.f3886n = eVar.f3886n;
        this.f3887o = eVar.f3887o;
        this.f3888p = eVar.f3888p;
        this.f3889q = eVar.f3889q;
        this.f3890r = eVar.f3890r;
        this.f3891s = eVar.f3891s;
        this.f3892t = eVar.f3892t;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.T(parcel, 2, this.f3882a);
        a.a.T(parcel, 3, this.f3883b);
        a.a.S(parcel, 4, this.f3884l, i);
        long j = this.f3885m;
        a.a.X(parcel, 5, 8);
        parcel.writeLong(j);
        boolean z9 = this.f3886n;
        a.a.X(parcel, 6, 4);
        parcel.writeInt(z9 ? 1 : 0);
        a.a.T(parcel, 7, this.f3887o);
        a.a.S(parcel, 8, this.f3888p, i);
        long j6 = this.f3889q;
        a.a.X(parcel, 9, 8);
        parcel.writeLong(j6);
        a.a.S(parcel, 10, this.f3890r, i);
        a.a.X(parcel, 11, 8);
        parcel.writeLong(this.f3891s);
        a.a.S(parcel, 12, this.f3892t, i);
        a.a.a0(parcel, Y);
    }

    public e(String str, String str2, x4 x4Var, long j, boolean z9, String str3, u uVar, long j6, u uVar2, long j10, u uVar3) {
        this.f3882a = str;
        this.f3883b = str2;
        this.f3884l = x4Var;
        this.f3885m = j;
        this.f3886n = z9;
        this.f3887o = str3;
        this.f3888p = uVar;
        this.f3889q = j6;
        this.f3890r = uVar2;
        this.f3891s = j10;
        this.f3892t = uVar3;
    }
}
