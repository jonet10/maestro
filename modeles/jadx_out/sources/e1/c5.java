package e1;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c5 extends l0.a {
    public static final Parcelable.Creator<c5> CREATOR = new android.support.v4.media.f(20);
    public final List A;
    public final String B;
    public final String C;
    public final String D;
    public final boolean E;
    public final long F;
    public final int G;
    public final String H;
    public final int I;
    public final long J;
    public final String K;
    public final String L;
    public final long M;
    public final int N;

    /* renamed from: a, reason: collision with root package name */
    public final String f3850a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3851b;

    /* renamed from: l, reason: collision with root package name */
    public final String f3852l;

    /* renamed from: m, reason: collision with root package name */
    public final String f3853m;

    /* renamed from: n, reason: collision with root package name */
    public final long f3854n;

    /* renamed from: o, reason: collision with root package name */
    public final long f3855o;

    /* renamed from: p, reason: collision with root package name */
    public final String f3856p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f3857q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f3858r;

    /* renamed from: s, reason: collision with root package name */
    public final long f3859s;

    /* renamed from: t, reason: collision with root package name */
    public final String f3860t;

    /* renamed from: u, reason: collision with root package name */
    public final long f3861u;
    public final int v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f3862w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f3863x;

    /* renamed from: y, reason: collision with root package name */
    public final Boolean f3864y;

    /* renamed from: z, reason: collision with root package name */
    public final long f3865z;

    public c5(String str, String str2, String str3, long j, String str4, long j6, long j10, String str5, boolean z9, boolean z10, String str6, long j11, int i, boolean z11, boolean z12, Boolean bool, long j12, List list, String str7, String str8, String str9, boolean z13, long j13, int i6, String str10, int i10, long j14, String str11, String str12, long j15, int i11) {
        k0.y.d(str);
        this.f3850a = str;
        this.f3851b = true == TextUtils.isEmpty(str2) ? null : str2;
        this.f3852l = str3;
        this.f3859s = j;
        this.f3853m = str4;
        this.f3854n = j6;
        this.f3855o = j10;
        this.f3856p = str5;
        this.f3857q = z9;
        this.f3858r = z10;
        this.f3860t = str6;
        this.f3861u = j11;
        this.v = i;
        this.f3862w = z11;
        this.f3863x = z12;
        this.f3864y = bool;
        this.f3865z = j12;
        this.A = list;
        this.B = str7;
        this.C = str8;
        this.D = str9;
        this.E = z13;
        this.F = j13;
        this.G = i6;
        this.H = str10;
        this.I = i10;
        this.J = j14;
        this.K = str11;
        this.L = str12;
        this.M = j15;
        this.N = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.T(parcel, 2, this.f3850a);
        a.a.T(parcel, 3, this.f3851b);
        a.a.T(parcel, 4, this.f3852l);
        a.a.T(parcel, 5, this.f3853m);
        a.a.X(parcel, 6, 8);
        parcel.writeLong(this.f3854n);
        a.a.X(parcel, 7, 8);
        parcel.writeLong(this.f3855o);
        a.a.T(parcel, 8, this.f3856p);
        a.a.X(parcel, 9, 4);
        parcel.writeInt(this.f3857q ? 1 : 0);
        a.a.X(parcel, 10, 4);
        parcel.writeInt(this.f3858r ? 1 : 0);
        a.a.X(parcel, 11, 8);
        parcel.writeLong(this.f3859s);
        a.a.T(parcel, 12, this.f3860t);
        a.a.X(parcel, 14, 8);
        parcel.writeLong(this.f3861u);
        a.a.X(parcel, 15, 4);
        parcel.writeInt(this.v);
        a.a.X(parcel, 16, 4);
        parcel.writeInt(this.f3862w ? 1 : 0);
        a.a.X(parcel, 18, 4);
        parcel.writeInt(this.f3863x ? 1 : 0);
        Boolean bool = this.f3864y;
        if (bool != null) {
            a.a.X(parcel, 21, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        a.a.X(parcel, 22, 8);
        parcel.writeLong(this.f3865z);
        List<String> list = this.A;
        if (list != null) {
            int Y2 = a.a.Y(parcel, 23);
            parcel.writeStringList(list);
            a.a.a0(parcel, Y2);
        }
        a.a.T(parcel, 25, this.B);
        a.a.T(parcel, 26, this.C);
        a.a.T(parcel, 27, this.D);
        a.a.X(parcel, 28, 4);
        parcel.writeInt(this.E ? 1 : 0);
        a.a.X(parcel, 29, 8);
        parcel.writeLong(this.F);
        a.a.X(parcel, 30, 4);
        parcel.writeInt(this.G);
        a.a.T(parcel, 31, this.H);
        a.a.X(parcel, 32, 4);
        parcel.writeInt(this.I);
        a.a.X(parcel, 34, 8);
        parcel.writeLong(this.J);
        a.a.T(parcel, 35, this.K);
        a.a.T(parcel, 36, this.L);
        a.a.X(parcel, 37, 8);
        parcel.writeLong(this.M);
        a.a.X(parcel, 38, 4);
        parcel.writeInt(this.N);
        a.a.a0(parcel, Y);
    }

    public c5(String str, String str2, String str3, String str4, long j, long j6, String str5, boolean z9, boolean z10, long j10, String str6, long j11, int i, boolean z11, boolean z12, Boolean bool, long j12, ArrayList arrayList, String str7, String str8, String str9, boolean z13, long j13, int i6, String str10, int i10, long j14, String str11, String str12, long j15, int i11) {
        this.f3850a = str;
        this.f3851b = str2;
        this.f3852l = str3;
        this.f3859s = j10;
        this.f3853m = str4;
        this.f3854n = j;
        this.f3855o = j6;
        this.f3856p = str5;
        this.f3857q = z9;
        this.f3858r = z10;
        this.f3860t = str6;
        this.f3861u = j11;
        this.v = i;
        this.f3862w = z11;
        this.f3863x = z12;
        this.f3864y = bool;
        this.f3865z = j12;
        this.A = arrayList;
        this.B = str7;
        this.C = str8;
        this.D = str9;
        this.E = z13;
        this.F = j13;
        this.G = i6;
        this.H = str10;
        this.I = i10;
        this.J = j14;
        this.K = str11;
        this.L = str12;
        this.M = j15;
        this.N = i11;
    }
}
