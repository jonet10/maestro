package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f627a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f628b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f629l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f630m;

    public /* synthetic */ a(WorkDatabase workDatabase, String str, WorkManagerImpl workManagerImpl, int i) {
        this.f627a = i;
        this.f628b = workDatabase;
        this.f629l = str;
        this.f630m = workManagerImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f627a) {
            case 0:
                CancelWorkRunnable.forNameInline$lambda$5(this.f628b, this.f629l, this.f630m);
                break;
            default:
                CancelWorkRunnable.forTag$lambda$3$lambda$2(this.f628b, this.f629l, this.f630m);
                break;
        }
    }
}
