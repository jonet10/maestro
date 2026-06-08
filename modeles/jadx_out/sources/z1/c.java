package z1;

import android.os.Looper;
import kotlin.jvm.internal.k;
import l7.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class c extends k implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11906a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i, Object obj, Class cls, String str, String str2, int i6, int i10) {
        super(i, obj, cls, str, str2, i6);
        this.f11906a = i10;
    }

    @Override // d7.a
    public final Object invoke() {
        switch (this.f11906a) {
            case 0:
                ((d) this.receiver).getClass();
                String name = Thread.currentThread().getName();
                name.getClass();
                return Boolean.valueOf(m.q0(name, "Firebase Background Thread #", false));
            case 1:
                ((d) this.receiver).getClass();
                String name2 = Thread.currentThread().getName();
                name2.getClass();
                return Boolean.valueOf(m.q0(name2, "Firebase Blocking Thread #", false));
            default:
                ((d) this.receiver).getClass();
                return Boolean.valueOf(!Looper.getMainLooper().isCurrentThread());
        }
    }
}
