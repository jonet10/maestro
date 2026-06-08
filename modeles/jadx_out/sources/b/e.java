package b;

import c4.k0;
import com.uptodown.activities.NotificationsRegistryActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.core.activities.InstallerActivity;
import e1.v4;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class e extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f656a;

    /* renamed from: b, reason: collision with root package name */
    public int f657b;

    /* renamed from: l, reason: collision with root package name */
    public int f658l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f659m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Object obj, int i, int i6, t6.c cVar, int i10) {
        super(2, cVar);
        this.f656a = i10;
        this.f659m = obj;
        this.f657b = i;
        this.f658l = i6;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f656a) {
            case 0:
                return new e((h) this.f659m, cVar, 0);
            case 1:
                return new e((NotificationsRegistryActivity) this.f659m, this.f658l, cVar, 1);
            case 2:
                return new e((PublicListActivity) this.f659m, this.f658l, cVar, 2);
            case 3:
                return new e((RecommendedActivity) this.f659m, this.f658l, cVar, 3);
            case 4:
                return new e((WishlistActivity) this.f659m, this.f658l, cVar, 4);
            case 5:
                return new e((InstallerActivity) this.f659m, cVar, 5);
            case 6:
                return new e((v4) this.f659m, this.f657b, this.f658l, cVar, 6);
            default:
                return new e((v4) this.f659m, this.f657b, this.f658l, cVar, 7);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f656a) {
        }
        return ((e) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:210:0x050b, code lost:
    
        if (r8.length() > 0) goto L230;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:248:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0194 A[Catch: Exception -> 0x015e, LOOP:2: B:51:0x0190->B:53:0x0194, LOOP_END, TryCatch #0 {Exception -> 0x015e, blocks: (B:48:0x015a, B:49:0x01c4, B:50:0x0174, B:51:0x0190, B:53:0x0194, B:55:0x01ac, B:64:0x0168), top: B:44:0x0154 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01ac A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x01c3 -> B:47:0x01c4). Please report as a decompilation issue!!! */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            Method dump skipped, instructions count: 1540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.e.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(k0 k0Var, int i, t6.c cVar, int i6) {
        super(2, cVar);
        this.f656a = i6;
        this.f659m = k0Var;
        this.f658l = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Object obj, t6.c cVar, int i) {
        super(2, cVar);
        this.f656a = i;
        this.f659m = obj;
    }
}
