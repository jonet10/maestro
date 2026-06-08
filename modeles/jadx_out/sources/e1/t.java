package e1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t extends l0.a implements Iterable {
    public static final Parcelable.Creator<t> CREATOR = new android.support.v4.media.f(13);

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f4251a;

    public t(Bundle bundle) {
        this.f4251a = bundle;
    }

    public final Object c(String str) {
        return this.f4251a.get(str);
    }

    public final Double d() {
        return Double.valueOf(this.f4251a.getDouble("value"));
    }

    public final String e() {
        return this.f4251a.getString("currency");
    }

    public final Bundle g() {
        return new Bundle(this.f4251a);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new s(this);
    }

    public final String toString() {
        return this.f4251a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.Q(2, g(), parcel);
        a.a.a0(parcel, Y);
    }
}
