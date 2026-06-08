package t1;

import java.util.concurrent.ExecutorService;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9520a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f9521b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Runnable f9522l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ g5.g f9523m;

    public /* synthetic */ e(f fVar, Runnable runnable, g5.g gVar, int i) {
        this.f9520a = i;
        this.f9521b = fVar;
        this.f9522l = runnable;
        this.f9523m = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9520a) {
            case 0:
                ExecutorService executorService = this.f9521b.f9524a;
                final int i = 0;
                final Runnable runnable = this.f9522l;
                final g5.g gVar = this.f9523m;
                executorService.execute(new Runnable() { // from class: t1.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i) {
                            case 0:
                                try {
                                    runnable.run();
                                    return;
                                } catch (Exception e10) {
                                    ((h) gVar.f5315b).setException(e10);
                                    throw e10;
                                }
                            case 1:
                                try {
                                    runnable.run();
                                    return;
                                } catch (Exception e11) {
                                    ((h) gVar.f5315b).setException(e11);
                                    return;
                                }
                            default:
                                Runnable runnable2 = runnable;
                                h hVar = (h) gVar.f5315b;
                                try {
                                    runnable2.run();
                                    hVar.set(null);
                                    return;
                                } catch (Exception e12) {
                                    hVar.setException(e12);
                                    return;
                                }
                        }
                    }
                });
                break;
            case 1:
                ExecutorService executorService2 = this.f9521b.f9524a;
                final int i6 = 2;
                final Runnable runnable2 = this.f9522l;
                final g5.g gVar2 = this.f9523m;
                executorService2.execute(new Runnable() { // from class: t1.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i6) {
                            case 0:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e10) {
                                    ((h) gVar2.f5315b).setException(e10);
                                    throw e10;
                                }
                            case 1:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e11) {
                                    ((h) gVar2.f5315b).setException(e11);
                                    return;
                                }
                            default:
                                Runnable runnable22 = runnable2;
                                h hVar = (h) gVar2.f5315b;
                                try {
                                    runnable22.run();
                                    hVar.set(null);
                                    return;
                                } catch (Exception e12) {
                                    hVar.setException(e12);
                                    return;
                                }
                        }
                    }
                });
                break;
            default:
                ExecutorService executorService3 = this.f9521b.f9524a;
                final int i10 = 1;
                final Runnable runnable3 = this.f9522l;
                final g5.g gVar3 = this.f9523m;
                executorService3.execute(new Runnable() { // from class: t1.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i10) {
                            case 0:
                                try {
                                    runnable3.run();
                                    return;
                                } catch (Exception e10) {
                                    ((h) gVar3.f5315b).setException(e10);
                                    throw e10;
                                }
                            case 1:
                                try {
                                    runnable3.run();
                                    return;
                                } catch (Exception e11) {
                                    ((h) gVar3.f5315b).setException(e11);
                                    return;
                                }
                            default:
                                Runnable runnable22 = runnable3;
                                h hVar = (h) gVar3.f5315b;
                                try {
                                    runnable22.run();
                                    hVar.set(null);
                                    return;
                                } catch (Exception e12) {
                                    hVar.setException(e12);
                                    return;
                                }
                        }
                    }
                });
                break;
        }
    }
}
