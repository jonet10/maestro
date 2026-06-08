package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.g;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import h0.b;
import i0.i;
import i0.l;
import java.util.Arrays;
import k0.y;
import l0.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class Status extends a implements i, ReflectedParcelable {

    /* renamed from: a, reason: collision with root package name */
    public final int f2474a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2475b;

    /* renamed from: l, reason: collision with root package name */
    public final PendingIntent f2476l;

    /* renamed from: m, reason: collision with root package name */
    public final b f2477m;

    /* renamed from: n, reason: collision with root package name */
    public static final Status f2469n = new Status(0, null, null, null);

    /* renamed from: o, reason: collision with root package name */
    public static final Status f2470o = new Status(14, null, null, null);

    /* renamed from: p, reason: collision with root package name */
    public static final Status f2471p = new Status(8, null, null, null);

    /* renamed from: q, reason: collision with root package name */
    public static final Status f2472q = new Status(15, null, null, null);

    /* renamed from: r, reason: collision with root package name */
    public static final Status f2473r = new Status(16, null, null, null);

    @NonNull
    public static final Parcelable.Creator<Status> CREATOR = new l(0);

    public Status(int i, String str, PendingIntent pendingIntent, b bVar) {
        this.f2474a = i;
        this.f2475b = str;
        this.f2476l = pendingIntent;
        this.f2477m = bVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f2474a == status.f2474a && y.j(this.f2475b, status.f2475b) && y.j(this.f2476l, status.f2476l) && y.j(this.f2477m, status.f2477m);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2474a), this.f2475b, this.f2476l, this.f2477m});
    }

    public final String toString() {
        g gVar = new g(this);
        String str = this.f2475b;
        if (str == null) {
            int i = this.f2474a;
            switch (i) {
                case -1:
                    str = "SUCCESS_CACHE";
                    break;
                case 0:
                    str = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
                    sb.append("unknown status code: ");
                    sb.append(i);
                    str = sb.toString();
                    break;
                case 2:
                    str = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    str = "SERVICE_DISABLED";
                    break;
                case 4:
                    str = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    str = "INVALID_ACCOUNT";
                    break;
                case 6:
                    str = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    str = "NETWORK_ERROR";
                    break;
                case 8:
                    str = "INTERNAL_ERROR";
                    break;
                case 10:
                    str = "DEVELOPER_ERROR";
                    break;
                case 13:
                    str = "ERROR";
                    break;
                case 14:
                    str = "INTERRUPTED";
                    break;
                case 15:
                    str = "TIMEOUT";
                    break;
                case 16:
                    str = "CANCELED";
                    break;
                case 17:
                    str = "API_NOT_CONNECTED";
                    break;
                case 18:
                    str = "DEAD_CLIENT";
                    break;
                case 19:
                    str = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    str = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    str = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    str = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        gVar.p(str, "statusCode");
        gVar.p(this.f2476l, "resolution");
        return gVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.X(parcel, 1, 4);
        parcel.writeInt(this.f2474a);
        a.a.T(parcel, 2, this.f2475b);
        a.a.S(parcel, 3, this.f2476l, i);
        a.a.S(parcel, 4, this.f2477m, i);
        a.a.a0(parcel, Y);
    }

    @Override // i0.i
    public final Status b() {
        return this;
    }
}
