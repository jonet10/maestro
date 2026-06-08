package s7;

import androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public q7.i f9356a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f9357b;

    /* renamed from: l, reason: collision with root package name */
    public int f9358l;

    /* renamed from: m, reason: collision with root package name */
    public int f9359m;

    /* renamed from: n, reason: collision with root package name */
    public int f9360n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f9361o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ r7.h[] f9362p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ WorkConstraintsTracker$track$$inlined$combine$1.AnonymousClass2 f9363q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ WorkConstraintsTracker$track$$inlined$combine$1.AnonymousClass3 f9364r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ r7.i f9365s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(r7.h[] hVarArr, WorkConstraintsTracker$track$$inlined$combine$1.AnonymousClass2 anonymousClass2, WorkConstraintsTracker$track$$inlined$combine$1.AnonymousClass3 anonymousClass3, r7.i iVar, t6.c cVar) {
        super(2, cVar);
        this.f9362p = hVarArr;
        this.f9363q = anonymousClass2;
        this.f9364r = anonymousClass3;
        this.f9365s = iVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        g gVar = new g(this.f9362p, this.f9363q, this.f9364r, this.f9365s, cVar);
        gVar.f9361o = obj;
        return gVar;
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((g) create((a0) obj, (t6.c) obj2)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0099, code lost:
    
        r19 = r11;
        r11 = r9;
        r9 = r19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c0 A[LOOP:0: B:20:0x00c0->B:41:?, LOOP_START, PHI: r8 r12
  0x00c0: PHI (r8v3 int) = (r8v2 int), (r8v4 int) binds: [B:16:0x00bb, B:41:?] A[DONT_GENERATE, DONT_INLINE]
  0x00c0: PHI (r12v4 q6.w) = (r12v3 q6.w), (r12v14 q6.w) binds: [B:16:0x00bb, B:41:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r10v10, types: [q7.i] */
    /* JADX WARN: Type inference failed for: r10v6, types: [q7.i] */
    /* JADX WARN: Type inference failed for: r10v8, types: [q7.i] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0127 -> B:7:0x012c). Please report as a decompilation issue!!! */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.g.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
