package g0;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends l0.a {

    @NonNull
    public static final Parcelable.Creator<a> CREATOR = new c(0);

    /* renamed from: a, reason: collision with root package name */
    public final Intent f5067a;

    public a(Intent intent) {
        this.f5067a = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.S(parcel, 1, this.f5067a, i);
        a.a.a0(parcel, Y);
    }
}
