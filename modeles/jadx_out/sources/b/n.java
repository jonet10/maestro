package b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import c3.d1;
import c3.i0;
import c3.w0;
import c4.i7;
import c4.k0;
import c4.q9;
import com.inmobi.cmp.data.model.ChoiceStyle;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.AppFilesActivity;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.FollowListActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.NotificationsRegistryActivity;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.activities.ReviewsActivity;
import com.uptodown.activities.SearchActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.VirusTotalReport;
import e1.s0;
import e1.v4;
import java.io.File;
import java.util.ArrayList;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.w;
import l7.u;
import p6.x;
import r7.o0;
import s4.f0;
import s4.y0;
import x4.e1;
import x4.f2;
import x4.k2;
import x4.r1;
import x4.t1;
import x4.u0;
import x4.w2;
import x4.x1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class n extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f696a;

    /* renamed from: b, reason: collision with root package name */
    public int f697b;

    /* renamed from: l, reason: collision with root package name */
    public Object f698l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f699m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(int i, MainActivity mainActivity, x4.r rVar, t6.c cVar) {
        super(2, cVar);
        this.f696a = 18;
        this.f697b = i;
        this.f698l = mainActivity;
        this.f699m = rVar;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:202|(2:203|204)|(2:206|(6:210|211|212|(2:214|(4:216|(2:218|(2:220|(2:222|(2:224|225)(1:227))(1:230))(1:231))(1:232)|228|229))|234|(0)))|237|(1:208)|210|211|212|(0)|234|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0222, code lost:
    
        if (r0 == r4) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0224, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x016f, code lost:
    
        if (r0 == r4) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x0158, code lost:
    
        if (r0 != r4) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:140:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x00b2 A[Catch: Exception -> 0x00b7, TRY_LEAVE, TryCatch #3 {Exception -> 0x00b7, blocks: (B:212:0x00a8, B:214:0x00b2), top: B:211:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0632  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0643  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object a(java.lang.Object r33) {
        /*
            Method dump skipped, instructions count: 1682
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.n.a(java.lang.Object):java.lang.Object");
    }

    private final Object b(Object obj) {
        int i;
        x4.r rVar = (x4.r) this.f699m;
        p6.a.e(obj);
        MyDownloads myDownloads = (MyDownloads) this.f698l;
        e4.b bVar = myDownloads.Q;
        if (bVar != null) {
            int i6 = this.f697b;
            if (i6 == 202 || i6 == 203) {
                myDownloads.C0(false);
            } else if (i6 != 207) {
                if (rVar != null) {
                    String str = rVar.f11355b;
                    if (str != null && str.length() != 0) {
                        e4.b bVar2 = myDownloads.Q;
                        bVar2.getClass();
                        ArrayList arrayList = bVar2.f4485b;
                        int size = arrayList.size();
                        i = 0;
                        while (i < size) {
                            Object obj2 = arrayList.get(i);
                            obj2.getClass();
                            if (u.m0(((x4.r) obj2).f11355b, str, true)) {
                                break;
                            }
                            i++;
                        }
                    }
                    i = -1;
                    if (i > -1) {
                        e4.b bVar3 = myDownloads.Q;
                        bVar3.getClass();
                        bVar3.f4485b.set(i, rVar);
                        e4.b bVar4 = myDownloads.Q;
                        bVar4.getClass();
                        bVar4.notifyItemChanged(i);
                    } else {
                        myDownloads.C0(false);
                    }
                }
            } else if (q6.l.o0(bVar.f4485b, rVar)) {
                e4.b bVar5 = myDownloads.Q;
                bVar5.getClass();
                e4.b bVar6 = myDownloads.Q;
                bVar6.getClass();
                bVar5.notifyItemRemoved(q6.l.u0(bVar6.f4485b, rVar));
                e4.b bVar7 = myDownloads.Q;
                bVar7.getClass();
                ArrayList arrayList2 = bVar7.f4485b;
                a0.a(arrayList2);
                arrayList2.remove(rVar);
                e4.b bVar8 = myDownloads.Q;
                bVar8.getClass();
                if (bVar8.f4485b.isEmpty()) {
                    myDownloads.A0().f10244q.setVisibility(0);
                }
            }
        }
        return x.f8463a;
    }

    private final Object c(Object obj) {
        Object obj2;
        t1 t1Var = (t1) this.f699m;
        OldVersionsActivity oldVersionsActivity = (OldVersionsActivity) this.f698l;
        int i = this.f697b;
        Object obj3 = null;
        if (i == 0) {
            p6.a.e(obj);
            b5.m mVar = new b5.m(oldVersionsActivity, t1Var.f11402p, obj3, 22);
            this.f697b = 1;
            Object D = mVar.D(this);
            Object obj4 = u6.a.f10762a;
            obj2 = D;
            if (D == obj4) {
                return obj4;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
            obj2 = ((p6.k) obj).f8444a;
        }
        if (!(obj2 instanceof p6.j)) {
            Intent intent = new Intent(oldVersionsActivity, (Class<?>) VirusTotalReport.class);
            int i6 = OldVersionsActivity.S;
            intent.putExtra("appInfo", (Parcelable) oldVersionsActivity.A0().f1681d.getValue());
            intent.putExtra("appReportVT", (f2) obj2);
            intent.putExtra("old_version_name", t1Var.f11396a);
            float f = UptodownApp.I;
            oldVersionsActivity.startActivity(intent, b4.d.a(oldVersionsActivity));
        }
        if (p6.k.a(obj2) != null) {
            int i10 = OldVersionsActivity.S;
            if (oldVersionsActivity.A0().f1681d.getValue() != null) {
                Intent intent2 = new Intent(oldVersionsActivity, (Class<?>) VirusTotalReport.class);
                intent2.putExtra("appInfo", (Parcelable) oldVersionsActivity.A0().f1681d.getValue());
                intent2.putExtra("isVirusTotalReportAvaialable", false);
                float f10 = UptodownApp.I;
                oldVersionsActivity.startActivity(intent2, b4.d.a(oldVersionsActivity));
            }
        }
        return x.f8463a;
    }

    private final Object d(Object obj) {
        Object e10;
        i7 i7Var = (i7) this.f698l;
        o0 o0Var = i7Var.f1720a;
        int i = this.f697b;
        if (i == 0) {
            p6.a.e(obj);
            i7Var.f1724e = true;
            o0Var.getClass();
            o0Var.g(null, j5.p.f6705a);
            v4 v4Var = new v4((Context) this.f699m, 3, false);
            String str = (String) i7Var.f1722c.getValue();
            int i6 = i7Var.f;
            this.f697b = 1;
            e10 = v4Var.e(str, 30, i6, this);
            u6.a aVar = u6.a.f10762a;
            if (e10 == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
            e10 = ((p6.k) obj).f8444a;
        }
        boolean z9 = e10 instanceof p6.j;
        j5.q qVar = j5.q.f6706a;
        if (!z9) {
            ArrayList arrayList = ((f0) e10).f9198a;
            boolean isEmpty = arrayList.isEmpty();
            int i10 = i7Var.f;
            if (!isEmpty) {
                i7Var.f = arrayList.size() + i10;
                j5.r rVar = new j5.r(arrayList);
                o0Var.getClass();
                o0Var.g(null, rVar);
            } else if (i10 == 0) {
                j5.r rVar2 = new j5.r(new ArrayList());
                o0Var.getClass();
                o0Var.g(null, rVar2);
            } else {
                i7Var.f1723d = true;
                o0Var.getClass();
                o0Var.g(null, qVar);
            }
            i7Var.f1724e = false;
        }
        if (p6.k.a(e10) != null) {
            o0Var.getClass();
            o0Var.g(null, qVar);
            i7Var.f1724e = false;
        }
        return x.f8463a;
    }

    private final Object e(Object obj) {
        Object a8;
        PublicProfileActivity publicProfileActivity = (PublicProfileActivity) this.f698l;
        int i = this.f697b;
        if (i == 0) {
            p6.a.e(obj);
            s4.x xVar = new s4.x(publicProfileActivity);
            String valueOf = String.valueOf(((w2) this.f699m).f11431a);
            this.f697b = 1;
            a8 = xVar.a(valueOf, this);
            u6.a aVar = u6.a.f10762a;
            if (a8 == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
            a8 = ((p6.k) obj).f8444a;
        }
        if (!(a8 instanceof p6.j)) {
            int i6 = PublicProfileActivity.R;
            publicProfileActivity.B0((w2) a8);
        }
        return x.f8463a;
    }

    private final Object f(Object obj) {
        Object obj2;
        RepliesActivity repliesActivity = (RepliesActivity) this.f698l;
        int i = this.f697b;
        if (i == 0) {
            p6.a.e(obj);
            s4.x xVar = new s4.x(repliesActivity);
            String str = (String) this.f699m;
            this.f697b = 1;
            Object a8 = xVar.a(str, this);
            Object obj3 = u6.a.f10762a;
            obj2 = a8;
            if (a8 == obj3) {
                return obj3;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
            obj2 = ((p6.k) obj).f8444a;
        }
        if (!(obj2 instanceof p6.j)) {
            new android.support.v4.media.g(repliesActivity, 20).E(k0.k.e("source", "replies"), "profile-open");
            Intent intent = new Intent(repliesActivity, (Class<?>) PublicProfileActivity.class);
            intent.putExtra("user", (w2) obj2);
            float f = UptodownApp.I;
            repliesActivity.startActivity(intent, b4.d.a(repliesActivity));
        }
        if (p6.k.a(obj2) != null) {
            String string = repliesActivity.getString(2131951998);
            string.getClass();
            repliesActivity.A(string);
        }
        return x.f8463a;
    }

    private final Object h(Object obj) {
        Object obj2;
        ReviewsActivity reviewsActivity = (ReviewsActivity) this.f698l;
        int i = this.f697b;
        if (i == 0) {
            p6.a.e(obj);
            s4.x xVar = new s4.x(reviewsActivity);
            String str = ((k2) this.f699m).f11259b;
            str.getClass();
            this.f697b = 1;
            Object a8 = xVar.a(str, this);
            Object obj3 = u6.a.f10762a;
            obj2 = a8;
            if (a8 == obj3) {
                return obj3;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
            obj2 = ((p6.k) obj).f8444a;
        }
        if (!(obj2 instanceof p6.j)) {
            new android.support.v4.media.g(reviewsActivity, 20).E(k0.k.e("source", "reviews"), "profile-open");
            Intent intent = new Intent(reviewsActivity, (Class<?>) PublicProfileActivity.class);
            intent.putExtra("user", (w2) obj2);
            float f = UptodownApp.I;
            reviewsActivity.startActivity(intent, b4.d.a(reviewsActivity));
        }
        if (p6.k.a(obj2) != null) {
            String string = reviewsActivity.getString(2131951998);
            string.getClass();
            reviewsActivity.A(string);
        }
        return x.f8463a;
    }

    private final Object j(Object obj) {
        Object a8;
        SearchActivity searchActivity = (SearchActivity) this.f698l;
        int i = this.f697b;
        if (i == 0) {
            p6.a.e(obj);
            s0 s0Var = new s0(searchActivity, ((x4.g) this.f699m).f11158a);
            this.f697b = 1;
            a8 = s0Var.a(this);
            u6.a aVar = u6.a.f10762a;
            if (a8 == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
            a8 = ((p6.k) obj).f8444a;
        }
        if (!(a8 instanceof p6.j)) {
            x4.g gVar = (x4.g) a8;
            String str = gVar.F;
            if (str != null) {
                a5.e.b(str, "buscador");
            }
            d0.b.j(searchActivity, searchActivity, new q9(searchActivity), gVar, true);
        }
        Throwable a10 = p6.k.a(a8);
        if (a10 != null) {
            int i6 = y0.f9323l;
            if (d0.b.J(a10)) {
                searchActivity.J();
            } else if (searchActivity.T()) {
                String string = searchActivity.getString(2131951992);
                string.getClass();
                searchActivity.A(string);
            }
        }
        return x.f8463a;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f696a) {
            case 0:
                n nVar = new n((ChoiceStyle) this.f699m, cVar, 0);
                nVar.f698l = obj;
                return nVar;
            case 1:
                return new n((Context) this.f698l, (h) this.f699m, cVar, 1);
            case 2:
                return new n((UptodownApp) this.f698l, (String) this.f699m, cVar, 2);
            case 3:
                return new n((UptodownApp) this.f698l, (b4.g) this.f699m, cVar, 3);
            case 4:
                return new n((Bitmap) this.f698l, (b6.f) this.f699m, cVar, 4);
            case 5:
                return new n((c3.o) this.f698l, (w0) this.f699m, cVar, 5);
            case 6:
                return new n((d1) this.f698l, (i0) this.f699m, cVar, 6);
            case 7:
                return new n((x4.r) this.f698l, (AppDetailActivity) this.f699m, this.f697b, cVar, 7);
            case 8:
                return new n((AppFilesActivity) this.f698l, (e1) this.f699m, cVar, 8);
            case 9:
                return new n((AppInstalledDetailsActivity) this.f698l, (u0) this.f699m, cVar, 9);
            case 10:
                return new n((k0) this.f698l, (File) this.f699m, cVar, 10);
            case 11:
                return new n((k0) this.f698l, (x1) this.f699m, cVar, 11);
            case 12:
                return new n((FollowListActivity) this.f698l, (String) this.f699m, cVar, 12);
            case 13:
                return new n((MainActivity) this.f698l, (ArrayList) this.f699m, cVar, 13);
            case 14:
                return new n((MainActivity) this.f698l, (w) this.f699m, cVar, 14);
            case 15:
                return new n((MainActivity) this.f698l, (r1) this.f699m, cVar, 15);
            case 16:
                return new n((MainActivity) this.f698l, (a3.d) this.f699m, cVar, 16);
            case 17:
                return new n((MainActivity) this.f699m, cVar, 17);
            case 18:
                return new n(this.f697b, (MainActivity) this.f698l, (x4.r) this.f699m, cVar);
            case 19:
                return new n((MyApps) this.f698l, (String) this.f699m, this.f697b, cVar, 19);
            case 20:
                return new n((MyDownloads) this.f699m, cVar, 20);
            case 21:
                return new n((MyDownloads) this.f698l, this.f697b, (x4.r) this.f699m, cVar);
            case 22:
                return new n((NotificationsRegistryActivity) this.f698l, (String) this.f699m, cVar, 22);
            case 23:
                return new n((OldVersionsActivity) this.f698l, (t1) this.f699m, cVar, 23);
            case 24:
                return new n((i7) this.f698l, (Context) this.f699m, cVar, 24);
            case 25:
                return new n((PublicProfileActivity) this.f698l, (w2) this.f699m, cVar, 25);
            case 26:
                return new n((RepliesActivity) this.f698l, (String) this.f699m, cVar, 26);
            case 27:
                return new n((ReviewsActivity) this.f698l, (k2) this.f699m, cVar, 27);
            case 28:
                return new n((SearchActivity) this.f698l, (x4.g) this.f699m, cVar, 28);
            default:
                return new n((SecurityActivity) this.f698l, (t4.w0) this.f699m, cVar, 29);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f696a) {
            case 0:
                n nVar = new n((ChoiceStyle) this.f699m, cVar, 0);
                nVar.f698l = a0Var;
                break;
            case 7:
                n nVar2 = (n) create(a0Var, cVar);
                x xVar = x.f8463a;
                nVar2.invokeSuspend(xVar);
                break;
            case 10:
                ((n) create(a0Var, cVar)).invokeSuspend(x.f8463a);
                break;
            case 18:
                n nVar3 = (n) create(a0Var, cVar);
                x xVar2 = x.f8463a;
                nVar3.invokeSuspend(xVar2);
                break;
            case 19:
                n nVar4 = (n) create(a0Var, cVar);
                x xVar3 = x.f8463a;
                nVar4.invokeSuspend(xVar3);
                break;
            case 21:
                n nVar5 = (n) create(a0Var, cVar);
                x xVar4 = x.f8463a;
                nVar5.invokeSuspend(xVar4);
                break;
        }
        return ((n) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:192:0x027a, code lost:
    
        if (((u4.f0) r0).B().f11158a != r6.f11361q) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x07d7, code lost:
    
        if (r0 == r15) goto L363;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:143:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x064a  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0634 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0609 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:476:0x0997  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x09aa  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x09b4  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x099c  */
    /* JADX WARN: Removed duplicated region for block: B:572:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:576:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:580:0x0b0b  */
    /* JADX WARN: Type inference failed for: r2v117, types: [java.lang.String] */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) {
        /*
            Method dump skipped, instructions count: 3022
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.n.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(MyDownloads myDownloads, int i, x4.r rVar, t6.c cVar) {
        super(2, cVar);
        this.f696a = 21;
        this.f698l = myDownloads;
        this.f697b = i;
        this.f699m = rVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(Object obj, Object obj2, int i, t6.c cVar, int i6) {
        super(2, cVar);
        this.f696a = i6;
        this.f698l = obj;
        this.f699m = obj2;
        this.f697b = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(Object obj, Object obj2, t6.c cVar, int i) {
        super(2, cVar);
        this.f696a = i;
        this.f698l = obj;
        this.f699m = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(Object obj, t6.c cVar, int i) {
        super(2, cVar);
        this.f696a = i;
        this.f699m = obj;
    }
}
