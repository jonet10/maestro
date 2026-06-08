package t4;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.uptodown.util.views.MaxHeightRecyclerView;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.zip.Adler32;
import javax.net.ssl.SSLSocket;
import x4.b3;
import x4.q2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n0 implements ViewBinding, k4.a, w4.o, t.b, w1.b, w1.a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f10013a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f10014b;

    /* renamed from: l, reason: collision with root package name */
    public Object f10015l;

    public n0(g5.f fVar) {
        this.f10014b = new Object();
        this.f10013a = fVar;
    }

    @Override // w4.o
    public void a(int i) {
        ArrayList arrayList = (ArrayList) this.f10014b;
        ArrayList arrayList2 = (ArrayList) this.f10013a;
        if (((b3) arrayList2.get(i)).f11067l != 0) {
            ((kotlin.jvm.internal.u) this.f10015l).f7021a = !r4.f7021a;
        } else if (arrayList.contains(arrayList2.get(i))) {
            arrayList.remove(arrayList2.get(i));
        } else {
            arrayList.add(arrayList2.get(i));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        if ((r4.getModifiers() & 1) == 0) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.reflect.Method b(java.lang.Class r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f10014b
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r3.f10015l
            java.lang.Class[] r1 = (java.lang.Class[]) r1
            r2 = 0
            java.lang.reflect.Method r4 = r4.getMethod(r0, r1)     // Catch: java.lang.NoSuchMethodException -> L15
            int r0 = r4.getModifiers()     // Catch: java.lang.NoSuchMethodException -> L16
            r0 = r0 & 1
            if (r0 != 0) goto L16
        L15:
            r4 = r2
        L16:
            if (r4 == 0) goto L29
            java.lang.Object r0 = r3.f10013a
            java.lang.Class r0 = (java.lang.Class) r0
            if (r0 == 0) goto L29
            java.lang.Class r1 = r4.getReturnType()
            boolean r0 = r0.isAssignableFrom(r1)
            if (r0 != 0) goto L29
            goto L2a
        L29:
            r2 = r4
        L2a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.n0.b(java.lang.Class):java.lang.reflect.Method");
    }

    public Object c(SSLSocket sSLSocket, Object... objArr) {
        Method b7 = b(sSLSocket.getClass());
        if (b7 == null) {
            throw new AssertionError("Method " + ((String) this.f10014b) + " not supported for object " + sSLSocket);
        }
        try {
            return b7.invoke(sSLSocket, objArr);
        } catch (IllegalAccessException e10) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + b7);
            assertionError.initCause(e10);
            throw assertionError;
        }
    }

    public void d(SSLSocket sSLSocket, Object... objArr) {
        try {
            Method b7 = b(sSLSocket.getClass());
            if (b7 == null) {
                return;
            }
            try {
                b7.invoke(sSLSocket, objArr);
            } catch (IllegalAccessException unused) {
            }
        } catch (InvocationTargetException e10) {
            Throwable targetException = e10.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public void e(r.p pVar, int i, boolean z9) {
        char c9;
        x.a aVar = (x.a) this.f10015l;
        Context context = (Context) this.f10013a;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        r.j jVar = (r.j) pVar;
        adler32.update(jVar.f8831a.getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(b0.a.a(jVar.f8833c)).array());
        byte[] bArr = jVar.f8832b;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z9) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int i6 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i6 >= i) {
                        a.a.u("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", pVar);
                        return;
                    }
                }
            }
        }
        SQLiteDatabase b7 = ((y.h) ((y.d) this.f10014b)).b();
        String str = jVar.f8831a;
        o.d dVar = jVar.f8833c;
        Cursor rawQuery = b7.rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str, String.valueOf(b0.a.a(dVar))});
        try {
            Long valueOf = rawQuery.moveToNext() ? Long.valueOf(rawQuery.getLong(0)) : 0L;
            rawQuery.close();
            long longValue = valueOf.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            builder.setMinimumLatency(aVar.a(dVar, longValue, i));
            Set set = ((x.b) aVar.f11010b.get(dVar)).f11013c;
            if (set.contains(x.c.f11014a)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(x.c.f11016l)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(x.c.f11015b)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i);
            persistableBundle.putString("backendName", str);
            persistableBundle.putInt("priority", b0.a.a(dVar));
            byte[] bArr2 = jVar.f8832b;
            if (bArr2 != null) {
                c9 = 0;
                persistableBundle.putString("extras", Base64.encodeToString(bArr2, 0));
            } else {
                c9 = 0;
            }
            builder.setExtras(persistableBundle);
            Integer valueOf2 = Integer.valueOf(value);
            Long valueOf3 = Long.valueOf(aVar.a(dVar, longValue, i));
            Integer valueOf4 = Integer.valueOf(i);
            Object[] objArr = new Object[5];
            objArr[c9] = pVar;
            objArr[1] = valueOf2;
            objArr[2] = valueOf3;
            objArr[3] = valueOf;
            objArr[4] = valueOf4;
            String D = a.a.D("JobInfoScheduler");
            if (Log.isLoggable(D, 3)) {
                Log.d(D, String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr));
            }
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    @Override // w1.b
    public void g(Bundle bundle, String str) {
        CountDownLatch countDownLatch = (CountDownLatch) this.f10015l;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }

    @Override // m6.a
    public Object get() {
        return new n0((Context) ((m6.a) this.f10013a).get(), (y.d) ((m6.a) this.f10014b).get(), (x.a) ((q1.a) this.f10015l).get());
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return (RelativeLayout) this.f10013a;
    }

    @Override // w1.a
    public void i(Bundle bundle) {
        synchronized (this.f10014b) {
            try {
                v1.c cVar = v1.c.f10791a;
                cVar.c("Logging event _ae to Firebase Analytics with params " + bundle);
                this.f10015l = new CountDownLatch(1);
                ((g5.f) this.f10013a).i(bundle);
                cVar.c("Awaiting app exception callback from Analytics...");
                try {
                    if (((CountDownLatch) this.f10015l).await(500, TimeUnit.MILLISECONDS)) {
                        cVar.c("App exception callback received from Analytics listener.");
                    } else {
                        cVar.d("Timeout exceeded while awaiting app exception callback from Analytics listener.", null);
                    }
                } catch (InterruptedException unused) {
                    Log.e("FirebaseCrashlytics", "Interrupted while awaiting app exception callback from Analytics listener.", null);
                }
                this.f10015l = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // k4.a
    public void k(Object obj, int i, int i6, long j) {
        obj.getClass();
    }

    @Override // k4.a
    public void m(File file) {
        file.getClass();
    }

    @Override // k4.a
    public void o(int i, String str, long j, long j6) {
        str.getClass();
    }

    @Override // k4.a
    public void r(File file) {
        file.getClass();
    }

    @Override // k4.a
    public void x(Object obj) {
        obj.getClass();
    }

    @Override // k4.a
    public void y() {
        u4.f0 f0Var = (u4.f0) this.f10013a;
        if (f0Var.getActivity() == null || !(f0Var.getActivity() instanceof c4.k0)) {
            return;
        }
        FragmentActivity activity = f0Var.getActivity();
        activity.getClass();
        File file = (File) this.f10014b;
        file.getClass();
        ((c4.k0) activity).W(file, ((q2) this.f10015l).f11350q);
    }

    public /* synthetic */ n0(Object obj, Object obj2, Object obj3) {
        this.f10013a = obj;
        this.f10014b = obj2;
        this.f10015l = obj3;
    }

    public n0(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, MaxHeightRecyclerView maxHeightRecyclerView, TextView textView, TextView textView2, View view) {
        this.f10013a = relativeLayout;
        this.f10014b = relativeLayout2;
        this.f10015l = view;
    }

    @Override // k4.a
    public void f(DocumentFile documentFile) {
    }

    @Override // k4.a
    public void n(DocumentFile documentFile) {
    }
}
