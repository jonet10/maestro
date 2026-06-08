package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v0 implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2836a;

    public /* synthetic */ v0(int i) {
        this.f2836a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f2836a) {
            case 0:
                int L = t0.f.L(parcel);
                Bundle bundle = null;
                String str = null;
                boolean z9 = false;
                long j = 0;
                long j6 = 0;
                while (parcel.dataPosition() < L) {
                    int readInt = parcel.readInt();
                    char c9 = (char) readInt;
                    if (c9 == 1) {
                        j = t0.f.F(parcel, readInt);
                    } else if (c9 == 2) {
                        j6 = t0.f.F(parcel, readInt);
                    } else if (c9 == 3) {
                        z9 = t0.f.C(parcel, readInt);
                    } else if (c9 == 7) {
                        bundle = t0.f.n(parcel, readInt);
                    } else if (c9 != '\b') {
                        t0.f.H(parcel, readInt);
                    } else {
                        str = t0.f.p(parcel, readInt);
                    }
                }
                t0.f.t(parcel, L);
                return new u0(j, j6, z9, bundle, str);
            default:
                int L2 = t0.f.L(parcel);
                String str2 = null;
                int i = 0;
                Intent intent = null;
                while (parcel.dataPosition() < L2) {
                    int readInt2 = parcel.readInt();
                    char c10 = (char) readInt2;
                    if (c10 == 1) {
                        i = t0.f.E(parcel, readInt2);
                    } else if (c10 == 2) {
                        str2 = t0.f.p(parcel, readInt2);
                    } else if (c10 != 3) {
                        t0.f.H(parcel, readInt2);
                    } else {
                        intent = (Intent) t0.f.o(parcel, readInt2, Intent.CREATOR);
                    }
                }
                t0.f.t(parcel, L2);
                return new w0(i, str2, intent);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.f2836a) {
            case 0:
                return new u0[i];
            default:
                return new w0[i];
        }
    }
}
