package b;

import a2.t;
import c4.w4;
import com.inmobi.cmp.data.model.ChoiceStyle;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.AppFilesActivity;
import com.uptodown.activities.ContactUsActivity;
import com.uptodown.activities.LanguageSettingsActivity;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.MyStatsActivity;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.OrganizationActivity;
import com.uptodown.activities.PasswordEditActivity;
import com.uptodown.activities.PasswordRecoveryActivity;
import com.uptodown.activities.PreregistrationActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RollbackActivity;
import com.uptodown.activities.UserDevicesActivity;
import com.uptodown.activities.UsernameEditActivity;
import com.uptodown.activities.VirusTotalReport;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.activities.preferences.MobileDataUsageActivity;
import com.uptodown.tv.ui.fragment.TvMyDownloadsFragment;
import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;
import com.uptodown.workers.AppInstalledWorker;
import com.uptodown.workers.AppUpdatedWorker;
import com.uptodown.workers.TrackingWorker;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class s extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f706a;

    /* renamed from: b, reason: collision with root package name */
    public int f707b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f708l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(int i, k4.c cVar, t6.c cVar2) {
        super(2, cVar2);
        this.f706a = 26;
        this.f708l = cVar;
        this.f707b = i;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f706a) {
            case 0:
                return new s((ChoiceStyle) this.f708l, cVar, 0);
            case 1:
                return new s((b5.m) this.f708l, cVar, 1);
            case 2:
                return new s((AppDetailActivity) this.f708l, cVar, 2);
            case 3:
                return new s((AppFilesActivity) this.f708l, cVar, 3);
            case 4:
                return new s((ContactUsActivity) this.f708l, cVar, 4);
            case 5:
                return new s((LanguageSettingsActivity) this.f708l, cVar, 5);
            case 6:
                return new s(this.f707b, (w4) this.f708l, cVar);
            case 7:
                return new s((MyDownloads) this.f708l, cVar, 7);
            case 8:
                return new s((MyStatsActivity) this.f708l, cVar, 8);
            case 9:
                return new s((OldVersionsActivity) this.f708l, cVar, 9);
            case 10:
                return new s((OrganizationActivity) this.f708l, cVar, 10);
            case 11:
                return new s((PasswordEditActivity) this.f708l, cVar, 11);
            case 12:
                return new s((PasswordRecoveryActivity) this.f708l, cVar, 12);
            case 13:
                return new s((PreregistrationActivity) this.f708l, cVar, 13);
            case 14:
                return new s((PublicListActivity) this.f708l, cVar, 14);
            case 15:
                return new s((RollbackActivity) this.f708l, cVar, 15);
            case 16:
                return new s((UserDevicesActivity) this.f708l, cVar, 16);
            case 17:
                return new s((UsernameEditActivity) this.f708l, cVar, 17);
            case 18:
                return new s((VirusTotalReport) this.f708l, cVar, 18);
            case 19:
                return new s((WishlistActivity) this.f708l, cVar, 19);
            case 20:
                return new s((MobileDataUsageActivity) this.f708l, cVar, 20);
            case 21:
                return new s((TvMyDownloadsFragment) this.f708l, cVar, 21);
            case 22:
                return new s((TvOldVersionsFragment) this.f708l, cVar, 22);
            case 23:
                return new s((t) this.f708l, cVar, 23);
            case 24:
                return new s((n.e) this.f708l, cVar, 24);
            case 25:
                return new s((o7.q) this.f708l, cVar, 25);
            case 26:
                return new s(this.f707b, (k4.c) this.f708l, cVar);
            case 27:
                return new s((AppInstalledWorker) this.f708l, cVar, 27);
            case 28:
                return new s((AppUpdatedWorker) this.f708l, cVar, 28);
            default:
                return new s((TrackingWorker) this.f708l, cVar, 29);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f706a) {
            case 6:
                s sVar = (s) create(a0Var, cVar);
                x xVar = x.f8463a;
                sVar.invokeSuspend(xVar);
                break;
            case 7:
                ((s) create(a0Var, cVar)).invokeSuspend(x.f8463a);
                break;
            case 8:
                ((s) create(a0Var, cVar)).invokeSuspend(x.f8463a);
                break;
            case 9:
                ((s) create(a0Var, cVar)).invokeSuspend(x.f8463a);
                break;
            case 10:
                ((s) create(a0Var, cVar)).invokeSuspend(x.f8463a);
                break;
            case 11:
                ((s) create(a0Var, cVar)).invokeSuspend(x.f8463a);
                break;
            case 13:
                ((s) create(a0Var, cVar)).invokeSuspend(x.f8463a);
                break;
            case 14:
                ((s) create(a0Var, cVar)).invokeSuspend(x.f8463a);
                break;
            case 15:
                ((s) create(a0Var, cVar)).invokeSuspend(x.f8463a);
                break;
            case 16:
                ((s) create(a0Var, cVar)).invokeSuspend(x.f8463a);
                break;
            case 17:
                ((s) create(a0Var, cVar)).invokeSuspend(x.f8463a);
                break;
            case 18:
                ((s) create(a0Var, cVar)).invokeSuspend(x.f8463a);
                break;
            case 19:
                ((s) create(a0Var, cVar)).invokeSuspend(x.f8463a);
                break;
            case 20:
                ((s) create(a0Var, cVar)).invokeSuspend(x.f8463a);
                break;
        }
        return ((s) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0433 A[Catch: Exception -> 0x0438, TRY_LEAVE, TryCatch #3 {Exception -> 0x0438, blocks: (B:114:0x0427, B:116:0x0433), top: B:113:0x0427 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0233  */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r34) {
        /*
            Method dump skipped, instructions count: 2560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.s.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(int i, w4 w4Var, t6.c cVar) {
        super(2, cVar);
        this.f706a = 6;
        this.f707b = i;
        this.f708l = w4Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(Object obj, t6.c cVar, int i) {
        super(2, cVar);
        this.f706a = i;
        this.f708l = obj;
    }
}
