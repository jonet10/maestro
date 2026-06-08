package n1;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f7918a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7919b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7920c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7921d;

    /* renamed from: e, reason: collision with root package name */
    public final String f7922e;
    public final String f;
    public final String g;

    public h(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i = p0.d.f8412a;
        y.i(true ^ (str == null || str.trim().isEmpty()), "ApplicationId must be set.");
        this.f7919b = str;
        this.f7918a = str2;
        this.f7920c = str3;
        this.f7921d = str4;
        this.f7922e = str5;
        this.f = str6;
        this.g = str7;
    }

    public static h a(Context context) {
        android.support.v4.media.g gVar = new android.support.v4.media.g(context, 24);
        String D = gVar.D("google_app_id");
        if (TextUtils.isEmpty(D)) {
            return null;
        }
        return new h(D, gVar.D("google_api_key"), gVar.D("firebase_database_url"), gVar.D("ga_trackingId"), gVar.D("gcm_defaultSenderId"), gVar.D("google_storage_bucket"), gVar.D("project_id"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return y.j(this.f7919b, hVar.f7919b) && y.j(this.f7918a, hVar.f7918a) && y.j(this.f7920c, hVar.f7920c) && y.j(this.f7921d, hVar.f7921d) && y.j(this.f7922e, hVar.f7922e) && y.j(this.f, hVar.f) && y.j(this.g, hVar.g);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7919b, this.f7918a, this.f7920c, this.f7921d, this.f7922e, this.f, this.g});
    }

    public final String toString() {
        android.support.v4.media.g gVar = new android.support.v4.media.g(this);
        gVar.p(this.f7919b, "applicationId");
        gVar.p(this.f7918a, "apiKey");
        gVar.p(this.f7920c, "databaseUrl");
        gVar.p(this.f7922e, "gcmSenderId");
        gVar.p(this.f, "storageBucket");
        gVar.p(this.g, "projectId");
        return gVar.toString();
    }
}
