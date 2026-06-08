package x4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f2 implements Parcelable {
    public static final e2 CREATOR = new e2();

    /* renamed from: a, reason: collision with root package name */
    public String f11151a;

    /* renamed from: b, reason: collision with root package name */
    public String f11152b;

    /* renamed from: l, reason: collision with root package name */
    public int f11153l;

    /* renamed from: m, reason: collision with root package name */
    public int f11154m;

    /* renamed from: n, reason: collision with root package name */
    public String f11155n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f11156o;

    /* renamed from: p, reason: collision with root package name */
    public String f11157p;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.f11151a);
        parcel.writeInt(this.f11153l);
        parcel.writeInt(this.f11154m);
        parcel.writeString(this.f11155n);
        parcel.writeList(this.f11156o);
        parcel.writeString(this.f11152b);
        parcel.writeString(this.f11157p);
    }
}
