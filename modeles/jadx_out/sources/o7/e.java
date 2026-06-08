package o7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f8255b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final f0[] f8256a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    public e(f0[] f0VarArr) {
        this.f8256a = f0VarArr;
        this.notCompletedCount$volatile = f0VarArr.length;
    }
}
