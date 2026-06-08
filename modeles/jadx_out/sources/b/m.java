package b;

import android.net.Uri;
import android.widget.TextView;
import androidx.documentfile.provider.DocumentFile;
import androidx.lifecycle.LiveDataScope;
import c4.k0;
import c4.ya;
import com.inmobi.cmp.data.model.ChoiceStyle;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.workers.PreRegisterWorker;
import g4.u;
import g4.v;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.x;
import o7.a0;
import x4.q2;
import x4.x1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class m extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f690a;

    /* renamed from: b, reason: collision with root package name */
    public Object f691b;

    /* renamed from: l, reason: collision with root package name */
    public int f692l;

    /* renamed from: m, reason: collision with root package name */
    public Object f693m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f694n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f695o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(int i, PreRegisterWorker preRegisterWorker, String str, t6.c cVar, x4.g gVar, x1 x1Var) {
        super(2, cVar);
        this.f690a = 14;
        this.f691b = str;
        this.f693m = preRegisterWorker;
        this.f694n = gVar;
        this.f692l = i;
        this.f695o = x1Var;
    }

    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.Object, java.util.Map] */
    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f690a) {
            case 0:
                m mVar = new m((Boolean) this.f693m, (ChoiceStyle) this.f694n, (l8.n) this.f695o, cVar, 0);
                mVar.f691b = obj;
                return mVar;
            case 1:
                return new m((AppInstalledDetailsActivity) this.f693m, (x) this.f694n, (CharSequence) this.f695o, cVar, 1);
            case 2:
                return new m((x4.r) this.f693m, (k0) this.f694n, (File) this.f695o, cVar, 2);
            case 3:
                return new m((MainActivity) this.f693m, (q2) this.f694n, (TextView) this.f695o, cVar, 3);
            case 4:
                return new m((f3.d) this.f693m, (Map) this.f691b, (ya) this.f694n, (c4.g) this.f695o, cVar);
            case 5:
                m mVar2 = new m((String) this.f694n, (String) this.f695o, (Boolean) this.f693m, cVar);
                mVar2.f691b = obj;
                return mVar2;
            case 6:
                return new m((ArrayList) this.f691b, (DocumentFile) this.f693m, (u) this.f694n, (FileExplorerActivity) this.f695o, cVar, 6);
            case 7:
                return new m((ArrayList) this.f691b, (File) this.f693m, (u) this.f694n, (FileExplorerActivity) this.f695o, cVar, 7);
            case 8:
                return new m((FileExplorerActivity) this.f693m, (kotlin.jvm.internal.u) this.f694n, (String) this.f695o, cVar, 8);
            case 9:
                return new m((File) this.f691b, (String) this.f693m, (v) this.f694n, (FileExplorerActivity) this.f695o, cVar, 9);
            case 10:
                return new m((File) this.f691b, (Uri) this.f693m, (v) this.f694n, (FileExplorerActivity) this.f695o, cVar, 10);
            case 11:
                return new m((DocumentFile) this.f691b, (String) this.f693m, (v) this.f694n, (FileExplorerActivity) this.f695o, cVar, 11);
            case 12:
                return new m((DocumentFile) this.f691b, (Uri) this.f693m, (v) this.f694n, (FileExplorerActivity) this.f695o, cVar, 12);
            case 13:
                m mVar3 = new m((j9.i) this.f694n, (String) this.f695o, cVar, 13);
                mVar3.f691b = obj;
                return mVar3;
            case 14:
                String str = (String) this.f691b;
                return new m(this.f692l, (PreRegisterWorker) this.f693m, str, cVar, (x4.g) this.f694n, (x1) this.f695o);
            default:
                return new m((s4.s) this.f694n, (j5.v) this.f695o, cVar, 15);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f690a) {
            case 0:
                return ((m) create((a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 1:
                return ((m) create((a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 2:
                return ((m) create((a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 3:
                return ((m) create((a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 4:
                return ((m) create((a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 5:
                return ((m) create((LiveDataScope) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 6:
                return ((m) create((a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 7:
                return ((m) create((a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 8:
                return ((m) create((a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 9:
                return ((m) create((a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 10:
                return ((m) create((a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 11:
                return ((m) create((a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 12:
                return ((m) create((a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 13:
                return ((m) create((LiveDataScope) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 14:
                m mVar = (m) create((a0) obj, (t6.c) obj2);
                p6.x xVar = p6.x.f8463a;
                mVar.invokeSuspend(xVar);
                return xVar;
            default:
                return ((m) create((a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:57|58|(2:60|(2:62|(2:64|65)(1:67))(3:69|70|71))(3:84|85|(6:93|(1:95)(1:97)|96|75|(0)|65)(2:89|(1:91)))|72|73|74|75|(0)|65) */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01c0, code lost:
    
        r0 = com.inmobi.cmp.ChoiceCmp.INSTANCE.getCallback();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01c6, code lost:
    
        if (r0 == null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01ce, code lost:
    
        r2 = new h9.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01c9, code lost:
    
        r0.onCmpError(com.inmobi.cmp.model.ChoiceError.INVALID_JSON_FORMAT);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x07aa  */
    /* JADX WARN: Type inference failed for: r1v36, types: [java.lang.Object, java.util.Map] */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            Method dump skipped, instructions count: 2146
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.m.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(f3.d dVar, Map map, ya yaVar, c4.g gVar, t6.c cVar) {
        super(2, cVar);
        this.f690a = 4;
        this.f693m = dVar;
        this.f691b = map;
        this.f694n = yaVar;
        this.f695o = gVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(Object obj, Object obj2, Object obj3, FileExplorerActivity fileExplorerActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f690a = i;
        this.f691b = obj;
        this.f693m = obj2;
        this.f694n = obj3;
        this.f695o = fileExplorerActivity;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(Object obj, Object obj2, Object obj3, t6.c cVar, int i) {
        super(2, cVar);
        this.f690a = i;
        this.f693m = obj;
        this.f694n = obj2;
        this.f695o = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(Object obj, Object obj2, t6.c cVar, int i) {
        super(2, cVar);
        this.f690a = i;
        this.f694n = obj;
        this.f695o = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(String str, String str2, Boolean bool, t6.c cVar) {
        super(2, cVar);
        this.f690a = 5;
        this.f694n = str;
        this.f695o = str2;
        this.f693m = bool;
    }
}
