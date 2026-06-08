package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w0 extends l0.a {
    public static final Parcelable.Creator<w0> CREATOR = new v0(1);

    /* renamed from: a, reason: collision with root package name */
    public final int f2882a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2883b;

    /* renamed from: l, reason: collision with root package name */
    public final Intent f2884l;

    public w0(int i, String str, Intent intent) {
        this.f2882a = i;
        this.f2883b = str;
        this.f2884l = intent;
    }

    public static w0 c(Activity activity) {
        return new w0(activity.hashCode(), activity.getClass().getCanonicalName(), activity.getIntent());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w0)) {
            return false;
        }
        w0 w0Var = (w0) obj;
        return this.f2882a == w0Var.f2882a && Objects.equals(this.f2883b, w0Var.f2883b) && Objects.equals(this.f2884l, w0Var.f2884l);
    }

    public final int hashCode() {
        return this.f2882a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.X(parcel, 1, 4);
        parcel.writeInt(this.f2882a);
        a.a.T(parcel, 2, this.f2883b);
        a.a.S(parcel, 3, this.f2884l, i);
        a.a.a0(parcel, Y);
    }
}
