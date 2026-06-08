package i9;

import android.content.ComponentCallbacks2;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import c4.k0;
import com.google.android.gms.internal.measurement.z3;
import d7.p;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.internal.l;
import o7.a0;
import o7.c0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h extends v6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5723a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5724b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f5725l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(String str, String str2, t6.c cVar, int i) {
        super(2, cVar);
        this.f5723a = i;
        this.f5724b = str;
        this.f5725l = str2;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f5723a) {
            case 0:
                return new h(this.f5724b, this.f5725l, cVar, 0);
            default:
                return new h(this.f5724b, this.f5725l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f5723a) {
            case 0:
                return new h(this.f5724b, this.f5725l, cVar, 0).invokeSuspend(x.f8463a);
            default:
                h hVar = (h) create(a0Var, cVar);
                x xVar = x.f8463a;
                hVar.invokeSuspend(xVar);
                return xVar;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f5723a) {
            case 0:
                p6.a.e(obj);
                URL url = new URL(this.f5724b);
                String str = this.f5725l;
                URLConnection openConnection = url.openConnection();
                if (openConnection != null) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    httpURLConnection.setDoOutput(true);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
                    try {
                        outputStreamWriter.write(str);
                        outputStreamWriter.flush();
                        outputStreamWriter.close();
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            httpURLConnection.disconnect();
                            return httpURLConnection;
                        }
                        com.google.gson.internal.a.n(l.g(new Integer(responseCode), "HTTP error code: "));
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            z3.k(outputStreamWriter, th);
                            throw th2;
                        }
                    }
                } else {
                    com.google.gson.internal.a.i("null cannot be cast to non-null type java.net.HttpURLConnection");
                }
                return null;
            default:
                p6.a.e(obj);
                ComponentCallbacks2 componentCallbacks2 = f4.c.f4875o;
                if (componentCallbacks2 != null && (componentCallbacks2 instanceof k0)) {
                    c0.s(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) componentCallbacks2), null, null, new b5.l(componentCallbacks2, this.f5724b, this.f5725l, (t6.c) null, 23), 3);
                }
                return x.f8463a;
        }
    }
}
