package n8;

import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final String f8111a;

    public a(String str, Object... objArr) {
        byte[] bArr = c.f8114a;
        this.f8111a = String.format(Locale.US, str, objArr);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f8111a);
        try {
            a();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
