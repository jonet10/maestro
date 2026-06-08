package androidx.work.impl;

import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class b implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f553a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f554b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f555c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f556d;

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, int i) {
        this.f553a = i;
        this.f554b = obj;
        this.f555c = obj2;
        this.f556d = obj3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        WorkSpec lambda$startWork$0;
        switch (this.f553a) {
            case 0:
                lambda$startWork$0 = ((Processor) this.f554b).lambda$startWork$0((ArrayList) this.f555c, (String) this.f556d);
                return lambda$startWork$0;
            default:
                return ((t1.f) this.f554b).f9524a.submit(new androidx.browser.trusted.c(23, (Callable) this.f555c, (g5.g) this.f556d));
        }
    }
}
