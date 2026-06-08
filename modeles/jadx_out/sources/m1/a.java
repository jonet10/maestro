package m1;

import a4.f;
import android.app.Service;
import android.app.job.JobParameters;
import android.content.ComponentName;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.v4.media.g;
import android.util.Log;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.google.android.gms.internal.measurement.c0;
import com.google.android.gms.internal.measurement.m0;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import e1.b3;
import e1.f0;
import e1.g1;
import e1.h1;
import e1.i0;
import e1.j2;
import e1.j3;
import e1.o;
import e1.r3;
import e1.t1;
import e1.u3;
import e1.u4;
import e1.v3;
import e1.w0;
import e1.w3;
import e1.z3;
import f0.i;
import g0.k;
import g0.l;
import g0.m;
import j$.util.Objects;
import j0.e;
import j0.t;
import j1.c;
import j1.d;
import j1.h;
import j1.j;
import j1.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import k0.l0;
import k0.s;
import k0.y;
import x4.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7268a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f7269b;

    /* renamed from: l, reason: collision with root package name */
    public final Object f7270l;

    public a(w3 w3Var, j3 j3Var) {
        this.f7268a = 12;
        this.f7269b = j3Var;
        Objects.requireNonNull(w3Var);
        this.f7270l = w3Var;
    }

    private final void a() {
        b3 b3Var = (b3) this.f7270l;
        t1 t1Var = b3Var.f3875a;
        g1 g1Var = t1Var.f4263n;
        w0 w0Var = t1Var.f4264o;
        t1.k(g1Var);
        g1Var.g();
        g1Var.g();
        o b7 = o.b(g1Var.k().getString("dma_consent_settings", null));
        o oVar = (o) this.f7269b;
        int i = oVar.f4167a;
        if (!j2.l(i, b7.f4167a)) {
            t1.m(w0Var);
            w0Var.f4345u.c(Integer.valueOf(i), "Lower precedence consent source ignored, proposed source");
            return;
        }
        SharedPreferences.Editor edit = g1Var.k().edit();
        edit.putString("dma_consent_settings", oVar.f4168b);
        edit.apply();
        t1.m(w0Var);
        w0Var.f4346w.c(oVar, "Setting DMA consent(FE)");
        t1 t1Var2 = b3Var.f3875a;
        if (t1Var2.p().q()) {
            w3 p10 = t1Var2.p();
            p10.g();
            p10.h();
            p10.u(new u3(p10, 1));
            return;
        }
        w3 p11 = t1Var2.p();
        p11.g();
        p11.h();
        if (p11.p()) {
            p11.u(new r3(p11, p11.w(false)));
        }
    }

    private final void b() {
        b3 b3Var = ((AppMeasurementDynamiteService) this.f7270l).i.v;
        t1.l(b3Var);
        g gVar = (g) this.f7269b;
        b3Var.g();
        b3Var.h();
        g gVar2 = b3Var.f3810m;
        if (gVar != gVar2) {
            y.i(gVar2 == null, "EventInterceptor already set.");
        }
        b3Var.f3810m = gVar;
    }

    private final void c() {
        w3 w3Var = (w3) this.f7270l;
        i0 i0Var = w3Var.f4359m;
        t1 t1Var = w3Var.f3875a;
        if (i0Var == null) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.b("Failed to send current screen to service");
            return;
        }
        try {
            j3 j3Var = (j3) this.f7269b;
            if (j3Var == null) {
                i0Var.j(0L, null, null, t1Var.f4259a.getPackageName());
            } else {
                i0Var.j(j3Var.f4059c, j3Var.f4057a, j3Var.f4058b, t1Var.f4259a.getPackageName());
            }
            w3Var.t();
        } catch (RemoteException e10) {
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4339o.c(e10, "Failed to send current screen to the service");
        }
    }

    private final void d() {
        ((v3) this.f7270l).f4330l.r((ComponentName) this.f7269b);
    }

    private final void e() {
        w3 w3Var = ((v3) this.f7270l).f4330l;
        w3Var.f4359m = null;
        if (((h0.b) this.f7269b).f5395b != 7777) {
            w3Var.v();
            return;
        }
        if (w3Var.f4362p == null) {
            w3Var.f4362p = Executors.newScheduledThreadPool(1);
        }
        w3Var.f4362p.schedule(new f(this, 6), ((Long) f0.a0.a(null)).longValue(), TimeUnit.MILLISECONDS);
    }

    private final void f() {
        u4 u4Var = (u4) this.f7269b;
        u4Var.B();
        Runnable runnable = (Runnable) this.f7270l;
        u4Var.b().g();
        if (u4Var.f4319y == null) {
            u4Var.f4319y = new ArrayList();
        }
        u4Var.f4319y.add(runnable);
        u4Var.q();
    }

    private final /* synthetic */ void g() {
        i iVar = (i) this.f7269b;
        JobParameters jobParameters = (JobParameters) this.f7270l;
        Log.v("FA", "[sgtm] AppMeasurementJobService processed last Scion upload request.");
        ((z3) ((Service) iVar.f4811b)).c(jobParameters);
    }

    private final void h() {
        f5.a aVar = (f5.a) this.f7270l;
        List<Fragment> fragments = aVar.getSupportFragmentManager().getFragments();
        fragments.getClass();
        if (fragments.isEmpty()) {
            return;
        }
        Fragment fragment = fragments.get(0);
        String string = aVar.getString(2131952683, ((r) this.f7269b).f11366w);
        string.getClass();
        Toast.makeText(fragment.getContext(), string, 1).show();
    }

    private final void i() {
        k kVar = (k) this.f7269b;
        IBinder iBinder = (IBinder) this.f7270l;
        synchronized (kVar) {
            if (iBinder == null) {
                kVar.a("Null service connection");
                return;
            }
            try {
                kVar.f5088l = new g(iBinder);
                kVar.f5086a = 2;
                kVar.f5091o.f5099b.execute(new g0.i(kVar, 0));
            } catch (RemoteException e10) {
                kVar.a(e10.getMessage());
            }
        }
    }

    private final void j() {
        k kVar = (k) this.f7269b;
        int i = ((l) this.f7270l).f5092a;
        synchronized (kVar) {
            l lVar = (l) kVar.f5090n.get(i);
            if (lVar != null) {
                Log.w("MessengerIpcClient", "Timing out request: " + i);
                kVar.f5090n.remove(i);
                lVar.b(new m("Timed out waiting for response", null));
                kVar.c();
            }
        }
    }

    private final void k() {
        k0.i iVar;
        h0.b bVar = (h0.b) this.f7269b;
        g8.g gVar = (g8.g) this.f7270l;
        i0.b bVar2 = (i0.b) gVar.f5382b;
        j0.m mVar = (j0.m) ((e) gVar.f5386o).f6499s.get((j0.a) gVar.f5383l);
        if (mVar == null) {
            return;
        }
        if (bVar.f5395b != 0) {
            mVar.o(bVar, null);
            return;
        }
        gVar.f5381a = true;
        if (bVar2.l()) {
            if (!gVar.f5381a || (iVar = (k0.i) gVar.f5384m) == null) {
                return;
            }
            bVar2.h(iVar, (Set) gVar.f5385n);
            return;
        }
        try {
            bVar2.h(null, bVar2.a());
        } catch (SecurityException e10) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e10);
            bVar2.b("Failed to get service from broker.");
            mVar.o(new h0.b(null, null, 10), null);
        }
    }

    private final void l() {
        k0.i l0Var;
        t tVar = (t) this.f7270l;
        h1.e eVar = (h1.e) this.f7269b;
        h0.b bVar = eVar.f5454b;
        if (bVar.f5395b == 0) {
            s sVar = eVar.f5455l;
            y.g(sVar);
            h0.b bVar2 = sVar.f6928l;
            if (bVar2.f5395b != 0) {
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(bVar2)), new Exception());
                tVar.f6532p.l(bVar2);
                tVar.f6531o.o();
                return;
            }
            g8.g gVar = tVar.f6532p;
            IBinder iBinder = sVar.f6927b;
            if (iBinder == null) {
                l0Var = null;
            } else {
                int i = k0.a.j;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                l0Var = queryLocalInterface instanceof k0.i ? (k0.i) queryLocalInterface : new l0(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 3);
            }
            Set set = tVar.f6529m;
            gVar.getClass();
            if (l0Var == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                gVar.l(new h0.b(null, null, 4));
            } else {
                gVar.f5384m = l0Var;
                gVar.f5385n = set;
                if (gVar.f5381a) {
                    ((i0.b) gVar.f5382b).h(l0Var, set);
                }
            }
        } else {
            tVar.f6532p.l(bVar);
        }
        tVar.f6531o.o();
    }

    private final void m() {
        p pVar = (p) this.f7269b;
        boolean z9 = pVar.f6563d;
        j1.l lVar = (j1.l) this.f7270l;
        if (z9) {
            lVar.f6553m.n();
            return;
        }
        try {
            ((j1.l) this.f7270l).f6553m.k(lVar.f6552l.g(pVar));
        } catch (j1.g e10) {
            boolean z10 = e10.getCause() instanceof Exception;
            j1.l lVar2 = (j1.l) this.f7270l;
            if (!z10) {
                lVar2.f6553m.m(e10);
            } else {
                lVar2.f6553m.m((Exception) e10.getCause());
            }
        } catch (Exception e11) {
            ((j1.l) this.f7270l).f6553m.m(e11);
        }
    }

    private final void n() {
        j1.l lVar = (j1.l) this.f7270l;
        try {
            p pVar = (p) lVar.f6552l.g((p) this.f7269b);
            if (pVar == null) {
                lVar.i(new NullPointerException("Continuation returned null"));
                return;
            }
            j1.o oVar = j.f6541b;
            pVar.c(oVar, lVar);
            pVar.b(oVar, lVar);
            pVar.f6561b.e(new j1.m((Executor) oVar, (c) lVar));
            pVar.p();
        } catch (j1.g e10) {
            if (!(e10.getCause() instanceof Exception)) {
                lVar.f6553m.m(e10);
            } else {
                lVar.f6553m.m((Exception) e10.getCause());
            }
        } catch (Exception e11) {
            lVar.f6553m.m(e11);
        }
    }

    private final void o() {
        j1.m mVar = (j1.m) this.f7270l;
        synchronized (mVar.f6556l) {
            ((d) mVar.f6557m).s((p) this.f7269b);
        }
    }

    private final void p() {
        j1.m mVar = (j1.m) this.f7270l;
        synchronized (mVar.f6556l) {
            try {
                j1.e eVar = (j1.e) mVar.f6557m;
                if (eVar != null) {
                    Exception f = ((p) this.f7269b).f();
                    y.g(f);
                    eVar.i(f);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void q() {
        j1.m mVar = (j1.m) this.f7270l;
        synchronized (mVar.f6556l) {
            try {
                j1.f fVar = (j1.f) mVar.f6557m;
                if (fVar != null) {
                    fVar.c(((p) this.f7269b).g());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void r() {
        j1.m mVar = (j1.m) this.f7270l;
        try {
            p q9 = ((h) mVar.f6556l).q(((p) this.f7269b).g());
            j1.o oVar = j.f6541b;
            q9.c(oVar, mVar);
            q9.b(oVar, mVar);
            q9.f6561b.e(new j1.m((Executor) oVar, (c) mVar));
            q9.p();
        } catch (j1.g e10) {
            if (e10.getCause() instanceof Exception) {
                mVar.i((Exception) e10.getCause());
            } else {
                ((p) mVar.f6557m).m(e10);
            }
        } catch (CancellationException unused) {
            mVar.f();
        } catch (Exception e11) {
            ((p) mVar.f6557m).m(e11);
        }
    }

    private final void s() {
        p pVar = (p) this.f7269b;
        try {
            pVar.k(((Callable) this.f7270l).call());
        } catch (Exception e10) {
            pVar.m(e10);
        } catch (Throwable th) {
            pVar.m(new RuntimeException(th));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:159|(1:161)(9:408|409|410|411|(1:413)(2:434|(4:436|415|416|(27:418|(1:420)(1:432)|421|422|424|425|426|163|164|(2:166|(2:168|(2:170|(2:172|(2:174|(2:176|(1:178)(1:401))(1:402))(1:403))(1:404))(1:405))(1:406))(1:407)|179|180|181|(1:183)(1:398)|184|(1:186)|188|189|(1:191)(2:395|(8:397|(3:388|389|(6:391|(5:196|(1:198)(3:379|(3:382|(1:384)(1:385)|380)|386)|(1:200)(1:378)|201|(9:203|(1:205)(1:375)|206|(1:208)|209|(1:211)(1:374)|212|(1:214)|(33:372|216|(1:218)|219|220|(3:367|368|(18:370|(1:236)(1:366)|237|(1:239)|240|(2:344|(2:350|(2:357|(2:358|(1:365)(2:360|(2:362|363)(1:364)))))(1:349))(1:244)|245|(3:340|(1:342)|343)|249|(1:251)(1:339)|252|(1:256)|257|(3:259|(7:261|(1:263)(1:295)|264|(1:266)|267|(4:271|(1:273)|274|(1:276))|277)(1:296)|278)(10:297|(4:299|(2:302|(6:304|(1:306)(1:336)|307|(1:309)|310|311))|337|311)(1:338)|312|(1:314)|315|316|317|318|319|(5:321|(1:323)(1:331)|(1:327)|(1:329)|330))|279|(3:281|(1:283)(1:292)|(5:285|(1:287)|288|(1:290)|291))|293|294))(1:223)|224|(1:233)|234|(0)(0)|237|(0)|240|(1:242)|344|(1:347)|350|(4:353|355|357|(3:358|(0)(0)|364))|245|(1:247)|340|(0)|343|249|(0)(0)|252|(2:254|256)|257|(0)(0)|279|(0)|293|294)(34:373|219|220|(0)|367|368|(0)|224|(1:233)|234|(0)(0)|237|(0)|240|(0)|344|(0)|350|(0)|245|(0)|340|(0)|343|249|(0)(0)|252|(0)|257|(0)(0)|279|(0)|293|294))(2:376|377))|387|(0)(0)|201|(0)(0)))|194|(0)|387|(0)(0)|201|(0)(0)))|192|(0)|194|(0)|387|(0)(0)|201|(0)(0))))|414|415|416|(0))|162|163|164|(0)(0)|179|180|181|(0)(0)|184|(0)|188|189|(0)(0)|192|(0)|194|(0)|387|(0)(0)|201|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:408|(2:409|410)|411|(1:413)(2:434|(4:436|415|416|(27:418|(1:420)(1:432)|421|422|424|425|426|163|164|(2:166|(2:168|(2:170|(2:172|(2:174|(2:176|(1:178)(1:401))(1:402))(1:403))(1:404))(1:405))(1:406))(1:407)|179|180|181|(1:183)(1:398)|184|(1:186)|188|189|(1:191)(2:395|(8:397|(3:388|389|(6:391|(5:196|(1:198)(3:379|(3:382|(1:384)(1:385)|380)|386)|(1:200)(1:378)|201|(9:203|(1:205)(1:375)|206|(1:208)|209|(1:211)(1:374)|212|(1:214)|(33:372|216|(1:218)|219|220|(3:367|368|(18:370|(1:236)(1:366)|237|(1:239)|240|(2:344|(2:350|(2:357|(2:358|(1:365)(2:360|(2:362|363)(1:364)))))(1:349))(1:244)|245|(3:340|(1:342)|343)|249|(1:251)(1:339)|252|(1:256)|257|(3:259|(7:261|(1:263)(1:295)|264|(1:266)|267|(4:271|(1:273)|274|(1:276))|277)(1:296)|278)(10:297|(4:299|(2:302|(6:304|(1:306)(1:336)|307|(1:309)|310|311))|337|311)(1:338)|312|(1:314)|315|316|317|318|319|(5:321|(1:323)(1:331)|(1:327)|(1:329)|330))|279|(3:281|(1:283)(1:292)|(5:285|(1:287)|288|(1:290)|291))|293|294))(1:223)|224|(1:233)|234|(0)(0)|237|(0)|240|(1:242)|344|(1:347)|350|(4:353|355|357|(3:358|(0)(0)|364))|245|(1:247)|340|(0)|343|249|(0)(0)|252|(2:254|256)|257|(0)(0)|279|(0)|293|294)(34:373|219|220|(0)|367|368|(0)|224|(1:233)|234|(0)(0)|237|(0)|240|(0)|344|(0)|350|(0)|245|(0)|340|(0)|343|249|(0)(0)|252|(0)|257|(0)(0)|279|(0)|293|294))(2:376|377))|387|(0)(0)|201|(0)(0)))|194|(0)|387|(0)(0)|201|(0)(0)))|192|(0)|194|(0)|387|(0)(0)|201|(0)(0))))|414|415|416|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0612, code lost:
    
        if (r14.C() == 1) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x0493, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x0494, code lost:
    
        e1.t1.m(r11);
        r11.f4339o.d(e1.w0.o(r12), "Fetching Google App Id failed with exception. appId", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x03cf, code lost:
    
        r7 = "Unknown";
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0483 A[Catch: IllegalStateException -> 0x0493, TRY_LEAVE, TryCatch #3 {IllegalStateException -> 0x0493, blocks: (B:181:0x0471, B:184:0x047f, B:186:0x0483), top: B:180:0x0471 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x06ef  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x071f  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x07b9  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x080c  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x082b  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0844  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0a20  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x08b2  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x081e  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x07dd  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x075c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0780 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:360:0x07a2  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x07b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x06f8  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x06ac  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0a8b  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x04d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:395:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x03b2 A[Catch: NameNotFoundException -> 0x03cf, TryCatch #10 {NameNotFoundException -> 0x03cf, blocks: (B:416:0x03a7, B:418:0x03b2, B:420:0x03be), top: B:415:0x03a7 }] */
    /* JADX WARN: Type inference failed for: r0v74, types: [e1.a3] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 3108
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.a.run():void");
    }

    public String toString() {
        switch (this.f7268a) {
            case 0:
                b5.m mVar = new b5.m(a.class.getSimpleName());
                g gVar = (g) this.f7270l;
                g gVar2 = new g(26, false);
                ((g) mVar.f1063m).f248l = gVar2;
                mVar.f1063m = gVar2;
                gVar2.f247b = gVar;
                return mVar.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ a(Object obj, Object obj2, int i, boolean z9) {
        this.f7268a = i;
        this.f7270l = obj;
        this.f7269b = obj2;
    }

    public a(h1 h1Var, c0 c0Var, h1 h1Var2) {
        this.f7268a = 4;
        this.f7269b = c0Var;
        this.f7270l = h1Var;
    }

    public a(b3 b3Var, m0 m0Var) {
        this.f7268a = 7;
        this.f7269b = m0Var;
        Objects.requireNonNull(b3Var);
        this.f7270l = b3Var;
    }

    public /* synthetic */ a(int i, Object obj, Object obj2) {
        this.f7268a = i;
        this.f7269b = obj;
        this.f7270l = obj2;
    }

    public a(i iVar, u4 u4Var, Runnable runnable) {
        this.f7268a = 15;
        this.f7269b = u4Var;
        this.f7270l = runnable;
    }
}
