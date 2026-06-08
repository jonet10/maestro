package v7;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends Thread {

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10858r = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final l f10859a;

    /* renamed from: b, reason: collision with root package name */
    public final x f10860b;
    private volatile int indexInArray;

    /* renamed from: l, reason: collision with root package name */
    public b f10861l;

    /* renamed from: m, reason: collision with root package name */
    public long f10862m;

    /* renamed from: n, reason: collision with root package name */
    public long f10863n;
    private volatile Object nextParkedWorker;

    /* renamed from: o, reason: collision with root package name */
    public int f10864o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10865p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ c f10866q;
    private volatile /* synthetic */ int workerCtl$volatile;

    public a(c cVar, int i) {
        this.f10866q = cVar;
        setDaemon(true);
        setContextClassLoader(c.class.getClassLoader());
        this.f10859a = new l();
        this.f10860b = new x();
        this.f10861l = b.f10870m;
        this.nextParkedWorker = c.f10876t;
        int nanoTime = (int) System.nanoTime();
        this.f10864o = nanoTime == 0 ? 42 : nanoTime;
        f(i);
    }

    public final h a(boolean z9) {
        h e10;
        h e11;
        long j;
        b bVar = this.f10861l;
        c cVar = this.f10866q;
        h hVar = null;
        l lVar = this.f10859a;
        b bVar2 = b.f10867a;
        if (bVar != bVar2) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = c.f10874r;
            do {
                j = atomicLongFieldUpdater.get(cVar);
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    lVar.getClass();
                    loop1: while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l.f10898b;
                        h hVar2 = (h) atomicReferenceFieldUpdater.get(lVar);
                        if (hVar2 != null && hVar2.f10890b) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(lVar, hVar2, null)) {
                                if (atomicReferenceFieldUpdater.get(lVar) != hVar2) {
                                    break;
                                }
                            }
                            hVar = hVar2;
                            break loop1;
                        }
                    }
                    int i = l.f10900d.get(lVar);
                    int i6 = l.f10899c.get(lVar);
                    while (true) {
                        if (i == i6 || l.f10901e.get(lVar) == 0) {
                            break;
                        }
                        i6--;
                        h c9 = lVar.c(i6, true);
                        if (c9 != null) {
                            hVar = c9;
                            break;
                        }
                    }
                    if (hVar != null) {
                        return hVar;
                    }
                    h hVar3 = (h) cVar.f10882o.d();
                    return hVar3 == null ? i(1) : hVar3;
                }
            } while (!c.f10874r.compareAndSet(cVar, j, j - 4398046511104L));
            this.f10861l = bVar2;
        }
        if (z9) {
            boolean z10 = d(cVar.f10877a * 2) == 0;
            if (z10 && (e11 = e()) != null) {
                return e11;
            }
            lVar.getClass();
            h hVar4 = (h) l.f10898b.getAndSet(lVar, null);
            if (hVar4 == null) {
                hVar4 = lVar.b();
            }
            if (hVar4 != null) {
                return hVar4;
            }
            if (!z10 && (e10 = e()) != null) {
                return e10;
            }
        } else {
            h e12 = e();
            if (e12 != null) {
                return e12;
            }
        }
        return i(3);
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i) {
        int i6 = this.f10864o;
        int i10 = i6 ^ (i6 << 13);
        int i11 = i10 ^ (i10 >> 17);
        int i12 = i11 ^ (i11 << 5);
        this.f10864o = i12;
        int i13 = i - 1;
        return (i13 & i) == 0 ? i12 & i13 : (i12 & Integer.MAX_VALUE) % i;
    }

    public final h e() {
        int d10 = d(2);
        c cVar = this.f10866q;
        f fVar = cVar.f10882o;
        f fVar2 = cVar.f10881n;
        if (d10 == 0) {
            h hVar = (h) fVar2.d();
            return hVar != null ? hVar : (h) fVar.d();
        }
        h hVar2 = (h) fVar.d();
        return hVar2 != null ? hVar2 : (h) fVar2.d();
    }

    public final void f(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f10866q.f10880m);
        sb.append("-worker-");
        sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
        setName(sb.toString());
        this.indexInArray = i;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(b bVar) {
        b bVar2 = this.f10861l;
        boolean z9 = bVar2 == b.f10867a;
        if (z9) {
            c.f10874r.addAndGet(this.f10866q, 4398046511104L);
        }
        if (bVar2 != bVar) {
            this.f10861l = bVar;
        }
        return z9;
    }

    public final h i(int i) {
        long j;
        h hVar;
        long j6;
        long j10;
        h hVar2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = c.f10874r;
        c cVar = this.f10866q;
        int i6 = (int) (atomicLongFieldUpdater.get(cVar) & 2097151);
        h hVar3 = null;
        if (i6 < 2) {
            return null;
        }
        int d10 = d(i6);
        int i10 = 0;
        long j11 = LocationRequestCompat.PASSIVE_INTERVAL;
        while (i10 < i6) {
            d10++;
            if (d10 > i6) {
                d10 = 1;
            }
            a aVar = (a) cVar.f10883p.b(d10);
            if (aVar != null && aVar != this) {
                l lVar = aVar.f10859a;
                if (i == 3) {
                    hVar = lVar.b();
                    j = 0;
                } else {
                    lVar.getClass();
                    int i11 = l.f10900d.get(lVar);
                    int i12 = l.f10899c.get(lVar);
                    boolean z9 = i == 1;
                    while (true) {
                        if (i11 == i12) {
                            j = 0;
                            break;
                        }
                        j = 0;
                        if (!z9 || l.f10901e.get(lVar) != 0) {
                            int i13 = i11 + 1;
                            hVar = lVar.c(i11, z9);
                            if (hVar != null) {
                                break;
                            }
                            i11 = i13;
                        } else {
                            break;
                        }
                    }
                    hVar = hVar3;
                }
                x xVar = this.f10860b;
                if (hVar != null) {
                    xVar.f7024a = hVar;
                    hVar2 = hVar3;
                    j10 = -1;
                    j6 = -1;
                } else {
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l.f10898b;
                        h hVar4 = (h) atomicReferenceFieldUpdater.get(lVar);
                        if (hVar4 == null) {
                            j6 = -1;
                            break;
                        }
                        j6 = -1;
                        if (((hVar4.f10890b ? 1 : 2) & i) == 0) {
                            break;
                        }
                        j.f.getClass();
                        l lVar2 = lVar;
                        long nanoTime = System.nanoTime() - hVar4.f10889a;
                        long j12 = j.f10893b;
                        if (nanoTime < j12) {
                            j10 = j12 - nanoTime;
                            hVar2 = null;
                            break;
                        }
                        do {
                            hVar2 = null;
                            if (atomicReferenceFieldUpdater.compareAndSet(lVar2, hVar4, null)) {
                                xVar.f7024a = hVar4;
                                j10 = -1;
                                break;
                            }
                        } while (atomicReferenceFieldUpdater.get(lVar2) == hVar4);
                        lVar = lVar2;
                        hVar3 = null;
                    }
                    j10 = -2;
                    hVar2 = hVar3;
                }
                if (j10 == j6) {
                    h hVar5 = (h) xVar.f7024a;
                    xVar.f7024a = hVar2;
                    return hVar5;
                }
                if (j10 > j) {
                    j11 = Math.min(j11, j10);
                }
            }
            i10++;
            hVar3 = null;
        }
        if (j11 == LocationRequestCompat.PASSIVE_INTERVAL) {
            j11 = 0;
        }
        this.f10863n = j11;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0004, code lost:
    
        continue;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v7.a.run():void");
    }
}
