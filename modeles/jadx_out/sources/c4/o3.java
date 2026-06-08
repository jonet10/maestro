package c4;

import android.os.Bundle;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import com.uptodown.workers.DownloadApkWorker;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o3 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public int f1936a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f1937b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f1938l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f1939m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ long f1940n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f1941o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ boolean f1942p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o3(MainActivity mainActivity, long j, long j6, long j10, String str, boolean z9, t6.c cVar) {
        super(2, cVar);
        this.f1937b = mainActivity;
        this.f1938l = j;
        this.f1939m = j6;
        this.f1940n = j10;
        this.f1941o = str;
        this.f1942p = z9;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new o3(this.f1937b, this.f1938l, this.f1939m, this.f1940n, this.f1941o, this.f1942p, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((o3) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        int i = this.f1936a;
        MainActivity mainActivity = this.f1937b;
        if (i == 0) {
            p6.a.e(obj);
            e1.s0 s0Var = new e1.s0(mainActivity, this.f1938l);
            this.f1936a = 1;
            Object a8 = s0Var.a(this);
            Object obj3 = u6.a.f10762a;
            obj2 = a8;
            if (a8 == obj3) {
                return obj3;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
            obj2 = ((p6.k) obj).f8444a;
        }
        if (!(obj2 instanceof p6.j)) {
            x4.g gVar = (x4.g) obj2;
            if (gVar.k() && gVar.j()) {
                x4.r rVar = new x4.r();
                rVar.f11361q = gVar.f11158a;
                rVar.f11366w = gVar.f11159b;
                long j = this.f1939m;
                gVar.J = j;
                rVar.f11358n = this.f1940n;
                String str = this.f1941o;
                gVar.P = str;
                rVar.f11355b = gVar.F;
                rVar.v = gVar.f11187u;
                x4.j0 j0Var = new x4.j0();
                j0Var.f11235l = j;
                j0Var.f11239p = str;
                j0Var.f11237n = 0L;
                rVar.F.add(j0Var);
                int r9 = rVar.r(mainActivity);
                if (this.f1942p) {
                    x4.k kVar = new x4.k();
                    kVar.f11250d = r9;
                    kVar.f11249c = gVar.F;
                    UptodownApp.f3293g0 = kVar;
                    Bundle f = k0.k.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "detected", "source", "captured_url");
                    f.putString("appId", String.valueOf(gVar.f11158a));
                    f.putString("fileId", String.valueOf(gVar.J));
                    new android.support.v4.media.g(mainActivity, 20).E(f, "deeplink");
                }
                float f10 = UptodownApp.I;
                if (!b4.d.p(mainActivity, "downloadApkWorker")) {
                    WorkManager.Companion.getInstance(mainActivity).enqueue(((OneTimeWorkRequest.Builder) androidx.lifecycle.l.t(DownloadApkWorker.class, "downloadApkWorker")).setInputData(new Data.Builder().putInt("downloadId", r9).build()).build());
                }
            } else {
                String string = mainActivity.getString(2131951692);
                string.getClass();
                mainActivity.A(string);
            }
            mainActivity.x0(gVar);
            mainActivity.f3320s0 = -1L;
        }
        Throwable a10 = p6.k.a(obj2);
        if (a10 != null) {
            mainActivity.f3320s0 = -1L;
            int i6 = s4.y0.f9323l;
            if (d0.b.J(a10)) {
                mainActivity.J();
            } else {
                String string2 = mainActivity.getString(2131951692);
                string2.getClass();
                mainActivity.A(string2);
            }
        }
        return p6.x.f8463a;
    }
}
