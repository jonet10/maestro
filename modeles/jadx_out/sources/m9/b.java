package m9;

import android.net.ConnectivityManager;
import com.inmobi.cmp.ChoiceCmp;
import g5.f;
import g5.g;
import i9.i;
import j9.e;
import j9.h;
import j9.j;
import j9.l;
import j9.n;
import j9.s;
import j9.x;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends m implements d7.a {

    /* renamed from: b, reason: collision with root package name */
    public static final b f7843b;

    /* renamed from: l, reason: collision with root package name */
    public static final b f7844l;

    /* renamed from: m, reason: collision with root package name */
    public static final b f7845m;

    /* renamed from: n, reason: collision with root package name */
    public static final b f7846n;

    /* renamed from: o, reason: collision with root package name */
    public static final b f7847o;

    /* renamed from: p, reason: collision with root package name */
    public static final b f7848p;

    /* renamed from: q, reason: collision with root package name */
    public static final b f7849q;

    /* renamed from: r, reason: collision with root package name */
    public static final b f7850r;

    /* renamed from: s, reason: collision with root package name */
    public static final b f7851s;

    /* renamed from: t, reason: collision with root package name */
    public static final b f7852t;

    /* renamed from: u, reason: collision with root package name */
    public static final b f7853u;
    public static final b v;

    /* renamed from: w, reason: collision with root package name */
    public static final b f7854w;

    /* renamed from: x, reason: collision with root package name */
    public static final b f7855x;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7856a;

    static {
        int i = 0;
        f7843b = new b(i, 0);
        f7844l = new b(i, 1);
        f7845m = new b(i, 2);
        f7846n = new b(i, 3);
        f7847o = new b(i, 4);
        f7848p = new b(i, 5);
        f7849q = new b(i, 6);
        f7850r = new b(i, 7);
        f7851s = new b(i, 8);
        f7852t = new b(i, 9);
        f7853u = new b(i, 10);
        v = new b(i, 11);
        f7854w = new b(i, 12);
        f7855x = new b(i, 13);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i, int i6) {
        super(i);
        this.f7856a = i6;
    }

    @Override // d7.a
    public final Object invoke() {
        switch (this.f7856a) {
            case 0:
                return new e((i9.b) c.f7873w.getValue(), (l9.a) c.v.getValue(), (i) c.f7874x.getValue(), new b5.m(c.b(), c.a()));
            case 1:
                return new h((l9.a) c.v.getValue(), c.f(), ChoiceCmp.INSTANCE.getCallback());
            case 2:
                return new k9.a();
            case 3:
                return new j9.i((i9.b) c.f7873w.getValue(), (i) c.f7874x.getValue(), new k9.b());
            case 4:
                return new j((l9.a) c.v.getValue(), ChoiceCmp.INSTANCE.getCallback());
            case 5:
                return new l(c.a(), (i9.b) c.f7873w.getValue(), (l9.a) c.v.getValue(), (i) c.f7874x.getValue(), new k9.c(0));
            case 6:
                return new n((i9.b) c.f7873w.getValue(), (l9.a) c.v.getValue(), (i) c.f7874x.getValue(), new f(5));
            case 7:
                return new s(c.b(), (i9.b) c.f7873w.getValue(), c.a(), (l9.a) c.v.getValue(), (i) c.f7874x.getValue(), new f(c.a(), 7));
            case 8:
                Object systemService = c.b().getSystemService("connectivity");
                if (systemService != null) {
                    return new i9.b((ConnectivityManager) systemService);
                }
                com.google.gson.internal.a.i("null cannot be cast to non-null type android.net.ConnectivityManager");
                return null;
            case 9:
                i9.b bVar = (i9.b) c.f7873w.getValue();
                l9.a aVar = (l9.a) c.v.getValue();
                i iVar = (i) c.f7874x.getValue();
                ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
                return new x(bVar, aVar, iVar, new f(choiceCmp.getCallback(), 6), choiceCmp.getAppPackageId(), choiceCmp.getPCode());
            case 10:
                return new i();
            case 11:
                return new l9.a(c.b());
            case 12:
                u5.m f = c.f();
                l8.n nVar = c.f;
                i9.b bVar2 = (i9.b) c.f7873w.getValue();
                i iVar2 = (i) c.f7874x.getValue();
                ChoiceCmp choiceCmp2 = ChoiceCmp.INSTANCE;
                return new f9.h(f, nVar, bVar2, iVar2, choiceCmp2.getCallback(), (l9.a) c.v.getValue(), choiceCmp2.getAppPackageId());
            default:
                return new j9.f(c.a(), (i9.b) c.f7873w.getValue(), (l9.a) c.v.getValue(), (i) c.f7874x.getValue(), new g((k9.a) c.j.getValue()));
        }
    }
}
