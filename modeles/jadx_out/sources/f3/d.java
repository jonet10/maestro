package f3;

import android.net.Uri;
import java.net.URL;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final c3.b f4843a;

    /* renamed from: b, reason: collision with root package name */
    public final t6.h f4844b;

    public d(c3.b bVar, t6.h hVar) {
        bVar.getClass();
        hVar.getClass();
        this.f4843a = bVar;
        this.f4844b = hVar;
    }

    public static final URL a(d dVar) {
        dVar.getClass();
        Uri.Builder appendPath = new Uri.Builder().scheme("https").authority("firebase-settings.crashlytics.com").appendPath("spi").appendPath("v2").appendPath("platforms").appendPath("android").appendPath("gmp");
        c3.b bVar = dVar.f4843a;
        Uri.Builder appendPath2 = appendPath.appendPath(bVar.f1193a).appendPath("settings");
        c3.a aVar = bVar.f1194b;
        return new URL(appendPath2.appendQueryParameter("build_version", aVar.f1187c).appendQueryParameter("display_version", aVar.f1186b).build().toString());
    }
}
