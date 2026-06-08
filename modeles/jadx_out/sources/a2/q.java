package a2;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f43a;

    /* renamed from: b, reason: collision with root package name */
    public int f44b;

    public q() {
        this.f43a = new ArrayList();
        this.f44b = 128;
    }

    public synchronized List a() {
        return DesugarCollections.unmodifiableList(new ArrayList(this.f43a));
    }

    public q(ArrayList arrayList) {
        this.f44b = 0;
        this.f43a = arrayList;
    }
}
