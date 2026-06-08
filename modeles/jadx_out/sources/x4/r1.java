package x4;

import android.content.Context;
import com.google.android.gms.internal.measurement.z3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r1 {

    /* renamed from: a, reason: collision with root package name */
    public long f11371a;

    /* renamed from: b, reason: collision with root package name */
    public String f11372b;

    /* renamed from: c, reason: collision with root package name */
    public int f11373c;

    /* renamed from: d, reason: collision with root package name */
    public long f11374d;

    /* renamed from: e, reason: collision with root package name */
    public long f11375e;

    public final void a(Context context) {
        z3.Q(this.f11371a, context, "fcm_app_id");
        z3.R(context, "fcm_packagename", this.f11372b);
        z3.O(context, this.f11373c, "fcm_download_id");
        z3.Q(this.f11374d, context, "fcm_received_timestamp");
        z3.Q(this.f11375e, context, "fcm_shown_timestamp");
    }

    public final String toString() {
        return "NotificationFCM(appId=" + this.f11371a + ", packageName=" + this.f11372b + ", downloadId=" + this.f11373c + ")";
    }
}
