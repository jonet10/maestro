package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u0 extends l0.a {
    public static final Parcelable.Creator<u0> CREATOR = new v0(0);

    /* renamed from: a, reason: collision with root package name */
    public final long f2814a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2815b;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f2816l;

    /* renamed from: m, reason: collision with root package name */
    public final Bundle f2817m;

    /* renamed from: n, reason: collision with root package name */
    public final String f2818n;

    public u0(long j, long j6, boolean z9, Bundle bundle, String str) {
        this.f2814a = j;
        this.f2815b = j6;
        this.f2816l = z9;
        this.f2817m = bundle;
        this.f2818n = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.X(parcel, 1, 8);
        parcel.writeLong(this.f2814a);
        a.a.X(parcel, 2, 8);
        parcel.writeLong(this.f2815b);
        a.a.X(parcel, 3, 4);
        parcel.writeInt(this.f2816l ? 1 : 0);
        a.a.Q(7, this.f2817m, parcel);
        a.a.T(parcel, 8, this.f2818n);
        a.a.a0(parcel, Y);
    }
}
