package c4;

import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.SearchActivity;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;
import com.uptodown.workers.PreRegisterWorker;
import java.io.Serializable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1844a;

    /* renamed from: b, reason: collision with root package name */
    public int f1845b;

    /* renamed from: l, reason: collision with root package name */
    public int f1846l;

    /* renamed from: m, reason: collision with root package name */
    public Object f1847m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f1848n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(Object obj, Serializable serializable, int i, int i6, t6.c cVar, int i10) {
        super(2, cVar);
        this.f1844a = i10;
        this.f1847m = obj;
        this.f1848n = serializable;
        this.f1845b = i;
        this.f1846l = i6;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1844a) {
            case 0:
                return new m((AppInstalledDetailsActivity) this.f1847m, this.f1846l, (String) this.f1848n, cVar);
            case 1:
                return new m((MainActivity) this.f1847m, (kotlin.jvm.internal.x) this.f1848n, this.f1845b, this.f1846l, cVar, 1);
            case 2:
                return new m((MyDownloads) this.f1848n, this.f1846l, cVar);
            case 3:
                return new m((RecommendedActivity) this.f1847m, (x4.a3) this.f1848n, this.f1846l, cVar, 3);
            case 4:
                return new m(this.f1846l, (SearchActivity) this.f1847m, (String) this.f1848n, cVar);
            case 5:
                return new m((WishlistActivity) this.f1847m, (x4.a3) this.f1848n, this.f1846l, cVar, 5);
            case 6:
                return new m((TvOldVersionsFragment) this.f1848n, cVar);
            case 7:
                return new m((PreRegisterWorker) this.f1847m, (x4.x1) this.f1848n, this.f1846l, cVar, 7);
            default:
                return new m((e1.v4) this.f1847m, (String) this.f1848n, this.f1845b, this.f1846l, cVar, 8);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1844a) {
        }
        return ((m) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0164  */
    /* JADX WARN: Type inference failed for: r1v32, types: [m8.q] */
    /* JADX WARN: Type inference failed for: r6v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v17, types: [int] */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 1000
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.m.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(AppInstalledDetailsActivity appInstalledDetailsActivity, int i, String str, t6.c cVar) {
        super(2, cVar);
        this.f1844a = 0;
        this.f1847m = appInstalledDetailsActivity;
        this.f1846l = i;
        this.f1848n = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(MyDownloads myDownloads, int i, t6.c cVar) {
        super(2, cVar);
        this.f1844a = 2;
        this.f1848n = myDownloads;
        this.f1846l = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(TvOldVersionsFragment tvOldVersionsFragment, t6.c cVar) {
        super(2, cVar);
        this.f1844a = 6;
        this.f1848n = tvOldVersionsFragment;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(int i, SearchActivity searchActivity, String str, t6.c cVar) {
        super(2, cVar);
        this.f1844a = 4;
        this.f1846l = i;
        this.f1847m = searchActivity;
        this.f1848n = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(Object obj, Object obj2, int i, t6.c cVar, int i6) {
        super(2, cVar);
        this.f1844a = i6;
        this.f1847m = obj;
        this.f1848n = obj2;
        this.f1846l = i;
    }
}
