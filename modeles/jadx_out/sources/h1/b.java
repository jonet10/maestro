package h1;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.f;
import com.google.android.gms.common.api.Status;
import i0.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends l0.a implements i {
    public static final Parcelable.Creator<b> CREATOR = new f(26);

    /* renamed from: a, reason: collision with root package name */
    public final int f5448a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5449b;

    /* renamed from: l, reason: collision with root package name */
    public final Intent f5450l;

    public b(int i, int i6, Intent intent) {
        this.f5448a = i;
        this.f5449b = i6;
        this.f5450l = intent;
    }

    @Override // i0.i
    public final Status b() {
        return this.f5449b == 0 ? Status.f2469n : Status.f2473r;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.X(parcel, 1, 4);
        parcel.writeInt(this.f5448a);
        a.a.X(parcel, 2, 4);
        parcel.writeInt(this.f5449b);
        a.a.S(parcel, 3, this.f5450l, i);
        a.a.a0(parcel, Y);
    }
}
