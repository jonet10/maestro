package c4;

import android.app.Application;
import android.content.BroadcastReceiver;
import com.inmobi.cmp.data.model.ChoiceStyle;
import com.uptodown.activities.AppFilesActivity;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.Updates;
import com.uptodown.activities.UserAvatarActivity;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;
import com.uptodown.workers.MyAppUpdatedWorker;
import com.uptodown.workers.PreRegisterWorker;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1614a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1615b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(ChoiceStyle choiceStyle, t6.c cVar) {
        super(2, cVar);
        this.f1614a = 13;
        Application application = m9.c.f7857a;
        this.f1615b = choiceStyle;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        int i = 2;
        switch (this.f1614a) {
            case 0:
                return new g((AppFilesActivity) this.f1615b, cVar, 0);
            case 1:
                return new g((FreeUpSpaceActivity) this.f1615b, cVar, 1);
            case 2:
                return new g((t2) this.f1615b, cVar, i);
            case 3:
                return new g((j5.g) this.f1615b, cVar, 3);
            case 4:
                return new g((MyDownloads) this.f1615b, cVar, 4);
            case 5:
                return new g((z6) this.f1615b, cVar, 5);
            case 6:
                return new g((t4.w0) this.f1615b, cVar, 6);
            case 7:
                return new g((Updates) this.f1615b, cVar, 7);
            case 8:
                return new g((UserAvatarActivity) this.f1615b, cVar, 8);
            case 9:
                g gVar = new g(i, cVar);
                gVar.f1615b = obj;
                return gVar;
            case 10:
                return new g((f3.g) this.f1615b, cVar, 10);
            case 11:
                return new g((InstallerActivity) this.f1615b, cVar, 11);
            case 12:
                return new g((TvOldVersionsFragment) this.f1615b, cVar, 12);
            case 13:
                Application application = m9.c.f7857a;
                return new g((ChoiceStyle) this.f1615b, cVar);
            case 14:
                return new g((g4.u) this.f1615b, cVar, 14);
            case 15:
                return new g((MyAppUpdatedWorker) this.f1615b, cVar, 15);
            case 16:
                return new g((PreRegisterWorker) this.f1615b, cVar, 16);
            case 17:
                return new g((r.k) this.f1615b, cVar, 17);
            case 18:
                return new g((s4.e) this.f1615b, cVar, 18);
            case 19:
                return new g((s4.g) this.f1615b, cVar, 19);
            case 20:
                return new g((s4.s) this.f1615b, cVar, 20);
            case 21:
                return new g((e1.s0) this.f1615b, cVar, 21);
            case 22:
                return new g((e1.v4) this.f1615b, cVar, 22);
            case 23:
                return new g((r.k) this.f1615b, cVar, 23);
            case 24:
                return new g((b5.m) this.f1615b, cVar, 24);
            case 25:
                return new g((e1.v4) this.f1615b, cVar, 25);
            default:
                return new g((BroadcastReceiver.PendingResult) this.f1615b, cVar, 26);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f1614a;
        p6.x xVar = p6.x.f8463a;
        switch (i) {
            case 0:
                ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
            case 1:
                ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
            case 2:
                ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
            case 3:
                return ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
            case 4:
                ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
            case 5:
                ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
            case 6:
                ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
            case 7:
                ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
            case 8:
                ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
            case 9:
                ((g) create((String) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
            case 10:
                return ((g) create((f3.g) obj, (t6.c) obj2)).invokeSuspend(xVar);
            case 11:
                ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
            case 12:
                ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
            case 13:
                Application application = m9.c.f7857a;
                new g((ChoiceStyle) this.f1615b, (t6.c) obj2).invokeSuspend(xVar);
                return xVar;
            case 14:
                ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
            case 15:
                ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
            case 16:
                ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
            case 17:
                return ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
            case 18:
                return ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
            case 19:
                return ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
            case 20:
                ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
            case 21:
                return ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
            case 22:
                ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
            case 23:
                ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
            case 24:
                ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
            case 25:
                return ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
            default:
                ((g) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(xVar);
                return xVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:147:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0502  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0743  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x078e A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v120, types: [x4.g] */
    /* JADX WARN: Type inference failed for: r0v143 */
    /* JADX WARN: Type inference failed for: r0v144, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v145, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v17, types: [o7.b0, t6.h] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v20 */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            Method dump skipped, instructions count: 2718
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.g.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(int i, t6.c cVar) {
        super(i, cVar);
        this.f1614a = 9;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(Object obj, t6.c cVar, int i) {
        super(2, cVar);
        this.f1614a = i;
        this.f1615b = obj;
    }
}
