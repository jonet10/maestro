package androidx.transition;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.CancellationSignal;
import androidx.work.ListenableFutureKt;
import b2.t1;
import com.google.firebase.messaging.FirebaseMessaging;
import d7.p;
import g5.g;
import j1.h;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import o.d;
import o7.b0;
import r.i;
import r.j;
import x4.h2;
import y.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements CancellationSignal.OnCancelListener, CallbackToFutureAdapter.Resolver, z.b, f, h, j1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f517a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f518b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f519l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f520m;

    public /* synthetic */ a(Runnable runnable, Transition transition, Runnable runnable2) {
        this.f517a = 0;
        this.f518b = runnable;
        this.f520m = transition;
        this.f519l = runnable2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0081 A[SYNTHETIC] */
    @Override // y.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object apply(java.lang.Object r27) {
        /*
            Method dump skipped, instructions count: 1066
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.a.apply(java.lang.Object):java.lang.Object");
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        Object executeAsync$lambda$4;
        Object launchFuture$lambda$1;
        switch (this.f517a) {
            case 1:
                executeAsync$lambda$4 = ListenableFutureKt.executeAsync$lambda$4((Executor) this.f518b, (String) this.f519l, (d7.a) this.f520m, completer);
                return executeAsync$lambda$4;
            default:
                launchFuture$lambda$1 = ListenableFutureKt.launchFuture$lambda$1((t6.h) this.f518b, (b0) this.f519l, (p) this.f520m, completer);
                return launchFuture$lambda$1;
        }
    }

    @Override // z.b
    public Object execute() {
        w.a aVar = (w.a) this.f518b;
        j jVar = (j) this.f519l;
        i iVar = (i) this.f520m;
        y.h hVar = (y.h) aVar.f10908d;
        hVar.getClass();
        d dVar = jVar.f8833c;
        String str = iVar.f8826a;
        String str2 = jVar.f8831a;
        String D = a.a.D("SQLiteEventStore");
        if (Log.isLoggable(D, 3)) {
            Log.d(D, "Storing event with priority=" + dVar + ", name=" + str + " for destination " + str2);
        }
        ((Long) hVar.d(new a(hVar, iVar, jVar, 4))).longValue();
        aVar.f10905a.e(jVar, 1, false);
        return null;
    }

    @Override // j1.a
    public Object g(j1.p pVar) {
        j1.i iVar = (j1.i) this.f518b;
        AtomicBoolean atomicBoolean = (AtomicBoolean) this.f519l;
        g gVar = (g) this.f520m;
        if (pVar.i()) {
            iVar.c(pVar.g());
        } else if (pVar.f() != null) {
            iVar.b(pVar.f());
        } else if (atomicBoolean.getAndSet(true)) {
            ((j1.p) ((g5.f) gVar.f5315b).f5309b).l(null);
        }
        return t1.x(null);
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        FragmentTransitionSupport.lambda$setListenerForTransitionEnd$0((Runnable) this.f518b, (Transition) this.f520m, (Runnable) this.f519l);
    }

    @Override // j1.h
    public j1.p q(Object obj) {
        FirebaseMessaging firebaseMessaging = (FirebaseMessaging) this.f518b;
        String str = (String) this.f519l;
        h2 h2Var = (h2) this.f520m;
        String str2 = (String) obj;
        g c9 = FirebaseMessaging.c(firebaseMessaging.f3086b);
        n1.f fVar = firebaseMessaging.f3085a;
        fVar.a();
        String d10 = "[DEFAULT]".equals(fVar.f7909b) ? "" : fVar.d();
        String b7 = firebaseMessaging.h.b();
        synchronized (c9) {
            String b10 = h2.b(System.currentTimeMillis(), str2, b7);
            if (b10 != null) {
                SharedPreferences.Editor edit = ((SharedPreferences) c9.f5315b).edit();
                edit.putString(d10 + "|T|" + str + "|*", b10);
                edit.commit();
            }
        }
        if (h2Var == null || !str2.equals(h2Var.f11211a)) {
            n1.f fVar2 = firebaseMessaging.f3085a;
            fVar2.a();
            if ("[DEFAULT]".equals(fVar2.f7909b)) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    StringBuilder sb = new StringBuilder("Invoking onNewToken for app: ");
                    fVar2.a();
                    sb.append(fVar2.f7909b);
                    Log.d("FirebaseMessaging", sb.toString());
                }
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", str2);
                new y2.j(firebaseMessaging.f3086b).b(intent);
            }
        }
        return t1.x(str2);
    }

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, int i) {
        this.f517a = i;
        this.f518b = obj;
        this.f519l = obj2;
        this.f520m = obj3;
    }
}
