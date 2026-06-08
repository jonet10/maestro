package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.f;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import k0.y;
import l0.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class Scope extends a implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<Scope> CREATOR = new f(29);

    /* renamed from: a, reason: collision with root package name */
    public final int f2467a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2468b;

    public Scope(int i, String str) {
        y.e(str, "scopeUri must not be null or empty");
        this.f2467a = i;
        this.f2468b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f2468b.equals(((Scope) obj).f2468b);
    }

    public final int hashCode() {
        return this.f2468b.hashCode();
    }

    public final String toString() {
        return this.f2468b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.X(parcel, 1, 4);
        parcel.writeInt(this.f2467a);
        a.a.T(parcel, 2, this.f2468b);
        a.a.a0(parcel, Y);
    }
}
