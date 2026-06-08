package androidx.datastore.core;

import androidx.datastore.core.MulticastFileObserver;
import d7.l;
import o7.o0;
import o7.x1;
import p7.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements o0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f405a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f406b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f407l;

    public /* synthetic */ a(int i, Object obj, Object obj2) {
        this.f405a = i;
        this.f406b = obj;
        this.f407l = obj2;
    }

    @Override // o7.o0
    public final void dispose() {
        switch (this.f405a) {
            case 0:
                MulticastFileObserver.Companion.observe$lambda$4((String) this.f406b, (l) this.f407l);
                break;
            default:
                c cVar = (c) this.f406b;
                cVar.f8466a.removeCallbacks((x1) this.f407l);
                break;
        }
    }
}
