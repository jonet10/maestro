package b5;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.TextView;
import androidx.lifecycle.ViewModelKt;
import c4.cb;
import c4.g9;
import c4.h6;
import c4.m5;
import c4.nc;
import c4.o5;
import c4.ub;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.ReviewsActivity;
import com.uptodown.activities.UserDeviceDetailsActivity;
import d7.p;
import j5.v;
import java.io.File;
import java.util.ArrayList;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import o7.a0;
import o7.c0;
import o7.m0;
import r7.k0;
import s4.s;
import u4.p0;
import u4.q0;
import u4.v0;
import x4.q2;
import x4.r;
import x4.s1;
import x4.z2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l extends v6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1055a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1056b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f1057l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f1058m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(s sVar, x xVar, v vVar, t6.c cVar) {
        super(2, cVar);
        this.f1055a = 21;
        this.f1056b = sVar;
        this.f1058m = xVar;
        this.f1057l = vVar;
    }

    private final Object a(Object obj) {
        v0 v0Var = (v0) this.f1058m;
        p6.a.e(obj);
        Context context = (Context) this.f1056b;
        v vVar = new v(context);
        x4.g gVar = (x4.g) this.f1057l;
        long j = gVar.f11158a;
        boolean z9 = gVar.f11197z0 == 1;
        v0Var.E = k0.b(new Integer(gVar.B0));
        v0Var.F = k0.b(new Integer(gVar.C0));
        a0 viewModelScope = ViewModelKt.getViewModelScope(v0Var);
        v7.e eVar = m0.f8288a;
        v7.d dVar = v7.d.f10884a;
        t6.c cVar = null;
        int i = 1;
        c0.s(viewModelScope, dVar, null, new p0(vVar, j, v0Var, cVar, i), 2);
        c0.s(ViewModelKt.getViewModelScope(v0Var), dVar, null, new cb(z9, gVar, vVar, v0Var, cVar, i), 2);
        c0.s(ViewModelKt.getViewModelScope(v0Var), dVar, null, new p0(vVar, j, v0Var, cVar, 0), 2);
        c0.s(ViewModelKt.getViewModelScope(v0Var), dVar, null, new q0(context, vVar, j, v0Var, (t6.c) null), 2);
        if (gVar.k()) {
            c0.s(ViewModelKt.getViewModelScope(v0Var), dVar, null, new q0(v0Var, context, vVar, j, (t6.c) null), 2);
        }
        return p6.x.f8463a;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1055a) {
            case 0:
                return new l((ArrayList) this.f1056b, (v) this.f1057l, (m) this.f1058m, cVar, 0);
            case 1:
                return new l((AppInstalledDetailsActivity) this.f1056b, (q2) this.f1057l, (r) this.f1058m, cVar, 1);
            case 2:
                return new l((CharSequence) this.f1056b, (AppInstalledDetailsActivity) this.f1057l, (x4.g) this.f1058m, cVar, 2);
            case 3:
                return new l((c4.k0) this.f1056b, (x) this.f1057l, (r) this.f1058m, cVar, 3);
            case 4:
                return new l((FreeUpSpaceActivity) this.f1056b, (String) this.f1057l, (String) this.f1058m, cVar, 4);
            case 5:
                return new l((x) this.f1056b, (MainActivity) this.f1057l, (File) this.f1058m, cVar, 5);
            case 6:
                return new l((c4.k0) this.f1057l, (ArrayList) this.f1056b, this.f1058m, cVar, 6);
            case 7:
                return new l((MainActivity) this.f1056b, (q2) this.f1057l, (TextView) this.f1058m, cVar, 7);
            case 8:
                return new l((o5) this.f1056b, (String) this.f1057l, (m5) this.f1058m, cVar, 8);
            case 9:
                return new l((Context) this.f1056b, (s1) this.f1057l, (String) this.f1058m, cVar, 9);
            case 10:
                return new l((h6) this.f1056b, (String) this.f1057l, (Context) this.f1058m, cVar, 10);
            case 11:
                return new l((ReviewsActivity) this.f1056b, (String) this.f1057l, (g9) this.f1058m, cVar, 11);
            case 12:
                return new l((ub) this.f1056b, (Context) this.f1057l, (x4.i) this.f1058m, cVar, 12);
            case 13:
                return new l((UserDeviceDetailsActivity) this.f1056b, (z2) this.f1057l, (nc) this.f1058m, cVar, 13);
            case 14:
                return new l((c4.k0) this.f1057l, (ArrayList) this.f1056b, this.f1058m, cVar, 14);
            case 15:
                return new l(this.f1057l, this.f1058m, (ArrayList) this.f1056b, cVar, 15);
            case 16:
                return new l((x4.e) this.f1056b, (PackageManager) this.f1057l, (j5.g) this.f1058m, cVar, 16);
            case 17:
                return new l((Context) this.f1056b, (String) this.f1057l, (d7.a) this.f1058m, cVar, 17);
            case 18:
                return new l(this.f1057l, this.f1058m, (ArrayList) this.f1056b, cVar, 18);
            case 19:
                return new l((u) this.f1056b, (u) this.f1057l, (k4.c) this.f1058m, cVar, 19);
            case 20:
                l lVar = new l((Context) this.f1057l, (String) this.f1058m, cVar);
                lVar.f1056b = obj;
                return lVar;
            case 21:
                return new l((s) this.f1056b, (x) this.f1058m, (v) this.f1057l, cVar);
            case 22:
                return new l((Context) this.f1056b, (x4.g) this.f1057l, (v0) this.f1058m, cVar, 22);
            default:
                return new l((Activity) this.f1056b, (String) this.f1057l, (String) this.f1058m, cVar, 23);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1055a) {
            case 0:
                return ((l) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 1:
                l lVar = (l) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                lVar.invokeSuspend(xVar);
                return xVar;
            case 2:
                l lVar2 = (l) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                lVar2.invokeSuspend(xVar2);
                return xVar2;
            case 3:
                l lVar3 = (l) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                lVar3.invokeSuspend(xVar3);
                return xVar3;
            case 4:
                l lVar4 = (l) create(a0Var, cVar);
                p6.x xVar4 = p6.x.f8463a;
                lVar4.invokeSuspend(xVar4);
                return xVar4;
            case 5:
                l lVar5 = (l) create(a0Var, cVar);
                p6.x xVar5 = p6.x.f8463a;
                lVar5.invokeSuspend(xVar5);
                return xVar5;
            case 6:
                l lVar6 = (l) create(a0Var, cVar);
                p6.x xVar6 = p6.x.f8463a;
                lVar6.invokeSuspend(xVar6);
                return xVar6;
            case 7:
                l lVar7 = (l) create(a0Var, cVar);
                p6.x xVar7 = p6.x.f8463a;
                lVar7.invokeSuspend(xVar7);
                return xVar7;
            case 8:
                l lVar8 = (l) create(a0Var, cVar);
                p6.x xVar8 = p6.x.f8463a;
                lVar8.invokeSuspend(xVar8);
                return xVar8;
            case 9:
                l lVar9 = (l) create(a0Var, cVar);
                p6.x xVar9 = p6.x.f8463a;
                lVar9.invokeSuspend(xVar9);
                return xVar9;
            case 10:
                l lVar10 = (l) create(a0Var, cVar);
                p6.x xVar10 = p6.x.f8463a;
                lVar10.invokeSuspend(xVar10);
                return xVar10;
            case 11:
                l lVar11 = (l) create(a0Var, cVar);
                p6.x xVar11 = p6.x.f8463a;
                lVar11.invokeSuspend(xVar11);
                return xVar11;
            case 12:
                l lVar12 = (l) create(a0Var, cVar);
                p6.x xVar12 = p6.x.f8463a;
                lVar12.invokeSuspend(xVar12);
                return xVar12;
            case 13:
                l lVar13 = (l) create(a0Var, cVar);
                p6.x xVar13 = p6.x.f8463a;
                lVar13.invokeSuspend(xVar13);
                return xVar13;
            case 14:
                l lVar14 = (l) create(a0Var, cVar);
                p6.x xVar14 = p6.x.f8463a;
                lVar14.invokeSuspend(xVar14);
                return xVar14;
            case 15:
                l lVar15 = (l) create(a0Var, cVar);
                p6.x xVar15 = p6.x.f8463a;
                lVar15.invokeSuspend(xVar15);
                return xVar15;
            case 16:
                l lVar16 = (l) create(a0Var, cVar);
                p6.x xVar16 = p6.x.f8463a;
                lVar16.invokeSuspend(xVar16);
                return xVar16;
            case 17:
                l lVar17 = (l) create(a0Var, cVar);
                p6.x xVar17 = p6.x.f8463a;
                lVar17.invokeSuspend(xVar17);
                return xVar17;
            case 18:
                return ((l) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 19:
                l lVar18 = (l) create(a0Var, cVar);
                p6.x xVar18 = p6.x.f8463a;
                lVar18.invokeSuspend(xVar18);
                return xVar18;
            case 20:
                return ((l) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 21:
                return ((l) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 22:
                l lVar19 = (l) create(a0Var, cVar);
                p6.x xVar19 = p6.x.f8463a;
                lVar19.invokeSuspend(xVar19);
                return xVar19;
            default:
                l lVar20 = (l) create(a0Var, cVar);
                p6.x xVar20 = p6.x.f8463a;
                lVar20.invokeSuspend(xVar20);
                return xVar20;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00d6, code lost:
    
        if (kotlin.jvm.internal.l.a(new org.json.JSONObject(r2).optString("url"), r15) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:442:0x0a84, code lost:
    
        if (r15.equals("app_updated") != false) goto L395;
     */
    /* JADX WARN: Code restructure failed: missing block: B:443:0x0a90, code lost:
    
        r8 = (c4.m1) r9.P.getValue();
        r8.getClass();
        r0 = androidx.lifecycle.ViewModelKt.getViewModelScope(r8);
        r2 = o7.m0.f8288a;
        o7.c0.s(r0, v7.d.f10884a, null, new c4.l1(r7, r8, r9, r10, 0), 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:445:0x0a8d, code lost:
    
        if (r15.equals("app_installed") == false) goto L396;
     */
    /* JADX WARN: Removed duplicated region for block: B:403:0x09be  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0bf4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0198  */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            Method dump skipped, instructions count: 3176
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b5.l.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(c4.k0 k0Var, ArrayList arrayList, Object obj, t6.c cVar, int i) {
        super(2, cVar);
        this.f1055a = i;
        this.f1057l = k0Var;
        this.f1056b = arrayList;
        this.f1058m = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(Object obj, Object obj2, Object obj3, t6.c cVar, int i) {
        super(2, cVar);
        this.f1055a = i;
        this.f1056b = obj;
        this.f1057l = obj2;
        this.f1058m = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(Object obj, Object obj2, ArrayList arrayList, t6.c cVar, int i) {
        super(2, cVar);
        this.f1055a = i;
        this.f1057l = obj;
        this.f1058m = obj2;
        this.f1056b = arrayList;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, String str, t6.c cVar) {
        super(2, cVar);
        this.f1055a = 20;
        this.f1057l = context;
        this.f1058m = str;
    }
}
