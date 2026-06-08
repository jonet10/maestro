package o4;

import a4.e0;
import android.os.Looper;
import com.google.android.gms.internal.measurement.i5;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {
    public final String[] f;
    public final /* synthetic */ HashSet i;

    /* renamed from: a, reason: collision with root package name */
    public int f8162a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f8163b = 0;

    /* renamed from: c, reason: collision with root package name */
    public e0 f8164c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8165d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8166e = false;
    public boolean g = false;
    public boolean h = false;

    public a(String[] strArr, HashSet hashSet) {
        this.i = hashSet;
        this.f = strArr;
        Looper.myLooper();
        i5.C("CommandHandler not created");
    }

    public final void a() {
        if (this.h) {
            return;
        }
        synchronized (this) {
            i5.C("Command 158 finished.");
            this.f8166e = false;
            this.g = true;
            notifyAll();
        }
    }

    public final String b() {
        return this.f[0];
    }

    public final void c(String str) {
        this.f8162a++;
        this.i.addAll(Arrays.asList(str.split(" ")));
        i5.B("ID: 158, " + str);
        this.f8163b = this.f8163b + 1;
    }

    public final void d(int i) {
        synchronized (this) {
        }
    }

    public final void e() {
        this.f8165d = true;
        e0 e0Var = new e0(this, this);
        this.f8164c = e0Var;
        e0Var.setPriority(1);
        this.f8164c.start();
        this.f8166e = true;
    }

    public final void f(String str) {
        synchronized (this) {
            i5.C("Command 158 did not finish because it was terminated. Termination reason: ".concat(str));
            d(-1);
            this.h = true;
            this.f8166e = false;
            this.g = true;
            notifyAll();
        }
    }
}
