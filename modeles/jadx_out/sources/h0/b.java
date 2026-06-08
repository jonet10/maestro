package h0;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Arrays;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends l0.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f5394a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5395b;

    /* renamed from: l, reason: collision with root package name */
    public final PendingIntent f5396l;

    /* renamed from: m, reason: collision with root package name */
    public final String f5397m;

    /* renamed from: n, reason: collision with root package name */
    public final Integer f5398n;

    /* renamed from: o, reason: collision with root package name */
    public static final b f5393o = new b(null, null, 0);

    @NonNull
    public static final Parcelable.Creator<b> CREATOR = new android.support.v4.media.f(23);

    public b(int i, int i6, PendingIntent pendingIntent, String str, Integer num) {
        this.f5394a = i;
        this.f5395b = i6;
        this.f5396l = pendingIntent;
        this.f5397m = str;
        this.f5398n = num;
    }

    public static String c(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    case 25:
                        return "API_INSTALL_REQUIRED";
                    default:
                        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 20);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f5395b == bVar.f5395b && y.j(this.f5396l, bVar.f5396l) && y.j(this.f5397m, bVar.f5397m) && y.j(this.f5398n, bVar.f5398n);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5395b), this.f5396l, this.f5397m, this.f5398n});
    }

    public final String toString() {
        android.support.v4.media.g gVar = new android.support.v4.media.g(this);
        gVar.p(c(this.f5395b), "statusCode");
        gVar.p(this.f5396l, "resolution");
        gVar.p(this.f5397m, "message");
        gVar.p(this.f5398n, "clientMethodKey");
        return gVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.X(parcel, 1, 4);
        parcel.writeInt(this.f5394a);
        a.a.X(parcel, 2, 4);
        parcel.writeInt(this.f5395b);
        a.a.S(parcel, 3, this.f5396l, i);
        a.a.T(parcel, 4, this.f5397m);
        Integer num = this.f5398n;
        if (num != null) {
            a.a.X(parcel, 5, 4);
            parcel.writeInt(num.intValue());
        }
        a.a.a0(parcel, Y);
    }

    public b(String str, PendingIntent pendingIntent, int i) {
        this(1, i, pendingIntent, str, null);
    }
}
