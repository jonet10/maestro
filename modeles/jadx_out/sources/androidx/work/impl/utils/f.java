package androidx.work.impl.utils;

import android.content.Context;
import android.webkit.WebSettings;
import androidx.work.ForegroundInfo;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;
import l7.u;
import p6.x;
import q6.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class f implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f642a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f643b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f644l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f645m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f646n;

    public /* synthetic */ f(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.f642a = i;
        this.f643b = obj;
        this.f644l = obj2;
        this.f645m = obj3;
        this.f646n = obj4;
    }

    @Override // d7.a
    public final Object invoke() {
        Void lambda$setForegroundAsync$0;
        String str;
        int i = this.f642a;
        Object obj = this.f646n;
        Object obj2 = this.f645m;
        Object obj3 = this.f644l;
        Object obj4 = this.f643b;
        switch (i) {
            case 0:
                lambda$setForegroundAsync$0 = ((WorkForegroundUpdater) obj4).lambda$setForegroundAsync$0((UUID) obj3, (ForegroundInfo) obj2, (Context) obj);
                return lambda$setForegroundAsync$0;
            default:
                k9.b bVar = (k9.b) obj3;
                String str2 = (String) obj2;
                z3.f fVar = ((z3.c) obj4).f11932a;
                androidx.room.b bVar2 = new androidx.room.b((w3.a) obj, 18);
                fVar.getClass();
                fVar.f11943m = bVar2;
                WebSettings settings = fVar.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setMediaPlaybackRequiresUserGesture(false);
                settings.setCacheMode(-1);
                fVar.addJavascriptInterface(fVar.f11945o, "YouTubePlayerBridge");
                fVar.addJavascriptInterface(fVar.f11941b, "YouTubePlayerCallbacks");
                InputStream openRawResource = fVar.getResources().openRawResource(2131886080);
                openRawResource.getClass();
                try {
                    try {
                        String x02 = l.x0(d0.b.N(new BufferedReader(new InputStreamReader(openRawResource, "utf-8"))), "\n", null, null, null, 62);
                        openRawResource.close();
                        if (str2 != null) {
                            str = "'" + str2 + '\'';
                        } else {
                            str = "undefined";
                        }
                        String o02 = u.o0(u.o0(x02, "<<injectedVideoId>>", str, false), "<<injectedPlayerVars>>", bVar.toString(), false);
                        String string = bVar.f7007b.getString("origin");
                        string.getClass();
                        fVar.loadDataWithBaseURL(string, o02, "text/html", "utf-8", null);
                        fVar.setWebChromeClient(new z3.e(fVar));
                        return x.f8463a;
                    } catch (Exception unused) {
                        throw new RuntimeException("Can't parse HTML file.");
                    }
                } finally {
                }
        }
    }
}
