package p;

import java.net.URL;
import java.util.regex.Pattern;
import t2.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public long f8395a;

    /* renamed from: b, reason: collision with root package name */
    public int f8396b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f8397c;

    public b() {
        if (q1.a.f8634l == null) {
            Pattern pattern = j.f9554b;
            q1.a.f8634l = new q1.a(12);
        }
        q1.a aVar = q1.a.f8634l;
        if (j.f9555c == null) {
            j.f9555c = new j(aVar);
        }
        this.f8397c = j.f9555c;
    }

    public synchronized long a(int i) {
        if (!(i == 429 || (i >= 500 && i < 600))) {
            return 86400000L;
        }
        double pow = Math.pow(2.0d, this.f8396b);
        ((j) this.f8397c).getClass();
        return (long) Math.min(pow + ((long) (Math.random() * 1000.0d)), 1800000L);
    }

    public synchronized boolean b() {
        boolean z9;
        if (this.f8396b != 0) {
            ((j) this.f8397c).f9556a.getClass();
            z9 = System.currentTimeMillis() > this.f8395a;
        }
        return z9;
    }

    public synchronized void c() {
        this.f8396b = 0;
    }

    public synchronized void d(int i) {
        if ((i >= 200 && i < 300) || i == 401 || i == 404) {
            c();
            return;
        }
        this.f8396b++;
        long a8 = a(i);
        ((j) this.f8397c).f9556a.getClass();
        this.f8395a = System.currentTimeMillis() + a8;
    }

    public b(int i, URL url, long j) {
        this.f8396b = i;
        this.f8397c = url;
        this.f8395a = j;
    }
}
