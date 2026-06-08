package s8;

import java.io.IOException;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j extends n8.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9411b = 2;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f9412l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ q f9413m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(q qVar, Object[] objArr, int i, ArrayList arrayList) {
        super("OkHttp %s Push Request[%s]", objArr);
        this.f9413m = qVar;
        this.f9412l = i;
    }

    private final void b() {
        this.f9413m.f9436s.getClass();
        try {
            this.f9413m.A.i(this.f9412l, 6);
            synchronized (this.f9413m) {
                this.f9413m.C.remove(Integer.valueOf(this.f9412l));
            }
        } catch (IOException unused) {
        }
    }

    private final void c() {
        this.f9413m.f9436s.getClass();
        try {
            this.f9413m.A.i(this.f9412l, 6);
            synchronized (this.f9413m) {
                this.f9413m.C.remove(Integer.valueOf(this.f9412l));
            }
        } catch (IOException unused) {
        }
    }

    @Override // n8.a
    public final void a() {
        switch (this.f9411b) {
            case 0:
                b();
                return;
            case 1:
                c();
                return;
            default:
                this.f9413m.f9436s.getClass();
                synchronized (this.f9413m) {
                    this.f9413m.C.remove(Integer.valueOf(this.f9412l));
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(q qVar, Object[] objArr, int i, ArrayList arrayList, boolean z9) {
        super("OkHttp %s Push Headers[%s]", objArr);
        this.f9413m = qVar;
        this.f9412l = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(q qVar, Object[] objArr, int i, int i6) {
        super("OkHttp %s Push Reset[%s]", objArr);
        this.f9413m = qVar;
        this.f9412l = i;
    }
}
