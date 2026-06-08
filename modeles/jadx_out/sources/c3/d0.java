package c3;

import android.content.Context;
import android.os.Process;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1217a;

    /* renamed from: b, reason: collision with root package name */
    public final p6.m f1218b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1219c;

    /* renamed from: d, reason: collision with root package name */
    public final p6.m f1220d;

    /* renamed from: e, reason: collision with root package name */
    public final p6.m f1221e;
    public boolean f;

    public d0(Context context, i1 i1Var) {
        context.getClass();
        i1Var.getClass();
        this.f1217a = context;
        final int i = 0;
        this.f1218b = new p6.m(new d7.a(this) { // from class: c3.c0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d0 f1206b;

            {
                this.f1206b = this;
            }

            @Override // d7.a
            public final Object invoke() {
                switch (i) {
                    case 0:
                        return ((e0) this.f1206b.f1221e.getValue()).f1232a;
                    default:
                        return f0.b(this.f1206b.f1217a);
                }
            }
        });
        this.f1219c = Process.myPid();
        this.f1220d = new p6.m(new androidx.room.g(i1Var, 8));
        final int i6 = 1;
        this.f1221e = new p6.m(new d7.a(this) { // from class: c3.c0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d0 f1206b;

            {
                this.f1206b = this;
            }

            @Override // d7.a
            public final Object invoke() {
                switch (i6) {
                    case 0:
                        return ((e0) this.f1206b.f1221e.getValue()).f1232a;
                    default:
                        return f0.b(this.f1206b.f1217a);
                }
            }
        });
    }

    public final String a() {
        return (String) this.f1218b.getValue();
    }

    public final Map b(Map map) {
        p6.m mVar = this.f1220d;
        if (map != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(map);
            linkedHashMap.put(a(), new b0(Process.myPid(), (String) mVar.getValue()));
            return q6.a0.l0(linkedHashMap);
        }
        Map singletonMap = Collections.singletonMap(a(), new b0(Process.myPid(), (String) mVar.getValue()));
        singletonMap.getClass();
        return singletonMap;
    }
}
