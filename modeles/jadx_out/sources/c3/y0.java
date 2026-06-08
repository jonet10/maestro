package c3;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import b2.t1;
import c4.gd;
import c4.j6;
import c4.k9;
import c4.l5;
import c4.m6;
import c4.r5;
import c4.y5;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import com.uptodown.activities.FeedActivity;
import com.uptodown.activities.FollowListActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.MyStatsActivity;
import com.uptodown.activities.NotificationsRegistryActivity;
import com.uptodown.activities.OrganizationActivity;
import com.uptodown.activities.PreregistrationActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RollbackActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.UserCommentsActivity;
import com.uptodown.activities.UsernameEditActivity;
import com.uptodown.activities.VirusTotalReport;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.activities.preferences.MobileDataUsageActivity;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.views.DonutChartView;
import com.uptodown.workers.AppInstalledWorker;
import com.uptodown.workers.AppUpdatedWorker;
import j$.util.concurrent.ConcurrentHashMap;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import x4.f2;
import x4.j2;
import x4.k1;
import x4.k2;
import x4.q2;
import x4.u1;
import x4.v2;
import x4.x2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y0 implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1352a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1353b;

    public /* synthetic */ y0(Object obj, int i) {
        this.f1352a = i;
        this.f1353b = obj;
    }

    private final Object b(Object obj, t6.c cVar) {
        j5.s sVar = (j5.s) obj;
        VirusTotalReport virusTotalReport = (VirusTotalReport) this.f1353b;
        if (sVar instanceof j5.p) {
            int i = VirusTotalReport.Q;
            virusTotalReport.y0().f9914n.setVisibility(0);
        } else if (sVar instanceof j5.r) {
            if (((j5.r) sVar).f6707a != null) {
                int i6 = VirusTotalReport.Q;
                Object value = virusTotalReport.z0().f1971e.getValue();
                value.getClass();
                ArrayList arrayList = ((f2) value).f11156o;
                if (arrayList == null || arrayList.isEmpty()) {
                    Object value2 = virusTotalReport.z0().f1971e.getValue();
                    value2.getClass();
                    virusTotalReport.D0((f2) value2);
                } else {
                    Object value3 = virusTotalReport.z0().f1971e.getValue();
                    value3.getClass();
                    virusTotalReport.E0((f2) value3);
                }
                virusTotalReport.A0();
            } else {
                int i10 = VirusTotalReport.Q;
                virusTotalReport.C0();
                virusTotalReport.B0();
            }
        } else if (!(sVar instanceof j5.q)) {
            com.google.gson.internal.a.b();
            return null;
        }
        return p6.x.f8463a;
    }

    private final Object c(Object obj, t6.c cVar) {
        j5.s sVar = (j5.s) obj;
        WishlistActivity wishlistActivity = (WishlistActivity) this.f1353b;
        if (sVar instanceof j5.p) {
            if (wishlistActivity.f3369c0 == null) {
                wishlistActivity.N0().f9949b.setVisibility(0);
            }
        } else if (sVar instanceof j5.r) {
            ArrayList arrayList = (ArrayList) ((j5.r) sVar).f6707a;
            if (arrayList.isEmpty() && wishlistActivity.f3369c0 == null) {
                wishlistActivity.N0().f9953o.setVisibility(0);
                wishlistActivity.N0().f9952n.setVisibility(0);
                wishlistActivity.N0().f9950l.setVisibility(8);
            } else {
                e4.e1 e1Var = wishlistActivity.f3369c0;
                if (e1Var == null) {
                    wishlistActivity.f3369c0 = new e4.e1(arrayList, wishlistActivity, wishlistActivity.f3370d0);
                    wishlistActivity.N0().f9950l.setAdapter(wishlistActivity.f3369c0);
                } else {
                    e1Var.f4519a.addAll(arrayList);
                    e1Var.notifyDataSetChanged();
                    e4.e1 e1Var2 = wishlistActivity.f3369c0;
                    if (e1Var2 != null) {
                        e1Var2.d(false);
                    }
                }
            }
            int i = WishlistActivity.f3367g0;
            wishlistActivity.N0().f9949b.setVisibility(8);
        } else {
            if (!(sVar instanceof j5.q)) {
                com.google.gson.internal.a.b();
                return null;
            }
            e4.e1 e1Var3 = wishlistActivity.f3369c0;
            if (e1Var3 != null) {
                e1Var3.d(false);
            }
        }
        return p6.x.f8463a;
    }

    private final Object d(Object obj, t6.c cVar) {
        j5.s sVar = (j5.s) obj;
        if (!(sVar instanceof j5.p)) {
            if (sVar instanceof j5.r) {
                MobileDataUsageActivity mobileDataUsageActivity = (MobileDataUsageActivity) this.f1353b;
                d4.i iVar = (d4.i) ((j5.r) sVar).f6707a;
                int i = MobileDataUsageActivity.Q;
                mobileDataUsageActivity.A0().f10149p.setText(mobileDataUsageActivity.getString(2131951746, String.valueOf(iVar.i)));
                TextView textView = mobileDataUsageActivity.A0().f10154u;
                long j = iVar.f3575e;
                textView.setText(mobileDataUsageActivity.getString(2131952072, i5.H(mobileDataUsageActivity, j)));
                TextView textView2 = mobileDataUsageActivity.A0().f10155w;
                long j6 = iVar.f;
                textView2.setText(mobileDataUsageActivity.getString(2131952242, i5.H(mobileDataUsageActivity, j6)));
                TextView textView3 = mobileDataUsageActivity.A0().f10151r;
                long j10 = iVar.g;
                textView3.setText(mobileDataUsageActivity.getString(2131951974, i5.H(mobileDataUsageActivity, j10)));
                TextView textView4 = mobileDataUsageActivity.A0().J;
                long j11 = iVar.h;
                textView4.setText(mobileDataUsageActivity.getString(2131952715, i5.H(mobileDataUsageActivity, j11)));
                if (iVar.f3571a.equals("notify")) {
                    mobileDataUsageActivity.y0(mobileDataUsageActivity.A0().K, mobileDataUsageActivity.A0().H);
                } else {
                    mobileDataUsageActivity.y0(mobileDataUsageActivity.A0().H, mobileDataUsageActivity.A0().K);
                }
                mobileDataUsageActivity.A0().f10146m.setChecked(iVar.f3572b);
                if (iVar.f3573c.equals("auto")) {
                    mobileDataUsageActivity.y0(mobileDataUsageActivity.A0().f10158z, mobileDataUsageActivity.A0().v);
                } else {
                    mobileDataUsageActivity.y0(mobileDataUsageActivity.A0().v, mobileDataUsageActivity.A0().f10158z);
                }
                if (iVar.f3574d.equals("auto")) {
                    mobileDataUsageActivity.y0(mobileDataUsageActivity.A0().B, mobileDataUsageActivity.A0().D);
                } else {
                    mobileDataUsageActivity.y0(mobileDataUsageActivity.A0().D, mobileDataUsageActivity.A0().B);
                }
                List d02 = q6.m.d0(new n5.e(j, ContextCompat.getColor(mobileDataUsageActivity, 2131099713)), new n5.e(j6, ContextCompat.getColor(mobileDataUsageActivity, 2131099673)), new n5.e(j10, ContextCompat.getColor(mobileDataUsageActivity, 2131100506)), new n5.e(j11, ContextCompat.getColor(mobileDataUsageActivity, 2131099890)));
                DonutChartView donutChartView = mobileDataUsageActivity.A0().f10144b;
                String H = i5.H(mobileDataUsageActivity, j + j6 + j10 + j11);
                donutChartView.f3462a = d02;
                donutChartView.f3463b = H;
                donutChartView.invalidate();
            } else if (!(sVar instanceof j5.q)) {
                com.google.gson.internal.a.b();
                return null;
            }
        }
        return p6.x.f8463a;
    }

    private final Object e(Object obj, t6.c cVar) {
        l4.m mVar = (l4.m) obj;
        InstallerActivity installerActivity = (InstallerActivity) this.f1353b;
        if (mVar instanceof l4.i) {
            installerActivity.runOnUiThread(new g4.e0(installerActivity, 0));
        } else if (mVar instanceof l4.e) {
            int i = InstallerActivity.f3394j0;
            installerActivity.D();
        } else if (mVar instanceof l4.g) {
            installerActivity.finish();
        } else if (mVar instanceof l4.f) {
            String str = ((l4.f) mVar).f7112b;
            if (str.length() != 0) {
                installerActivity.A(str);
            }
            installerActivity.D();
        } else if (mVar instanceof l4.h) {
            int i6 = InstallerActivity.f3394j0;
            installerActivity.D();
        }
        return p6.x.f8463a;
    }

    private final Object f(Object obj, t6.c cVar) {
        j5.s sVar = (j5.s) obj;
        u4.f1 f1Var = (u4.f1) this.f1353b;
        if ((f1Var.getActivity() instanceof MainActivity) && !kotlin.jvm.internal.l.a(sVar, j5.p.f6705a)) {
            if (sVar instanceof j5.r) {
                v2 v2Var = (v2) ((j5.r) sVar).f6707a;
                if (v2Var.f11423b == 1) {
                    FragmentActivity activity = f1Var.getActivity();
                    activity.getClass();
                    String string = f1Var.getString(2131952032);
                    string.getClass();
                    ((MainActivity) activity).A(string);
                } else {
                    int i = v2Var.f11424c;
                    if (i == 401) {
                        FragmentActivity requireActivity = f1Var.requireActivity();
                        requireActivity.getClass();
                        String string2 = f1Var.getString(2131952181);
                        string2.getClass();
                        String string3 = f1Var.getString(2131952180);
                        string3.getClass();
                        t1.v((MainActivity) requireActivity, string2, string3);
                    } else if (i == 409) {
                        FragmentActivity activity2 = f1Var.getActivity();
                        activity2.getClass();
                        String string4 = f1Var.getString(2131951675);
                        string4.getClass();
                        ((MainActivity) activity2).A(string4);
                    } else {
                        FragmentActivity activity3 = f1Var.getActivity();
                        activity3.getClass();
                        String string5 = f1Var.getString(2131951998);
                        string5.getClass();
                        ((MainActivity) activity3).A(string5);
                    }
                }
            } else if (!kotlin.jvm.internal.l.a(sVar, j5.q.f6706a)) {
                com.google.gson.internal.a.b();
                return null;
            }
        }
        return p6.x.f8463a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x011a, code lost:
    
        if (o7.c0.C(r4, r15, r10) == r5) goto L66;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(j5.s r14, t6.c r15) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.y0.a(j5.s, t6.c):java.lang.Object");
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        int i;
        int i6;
        String string;
        boolean z9;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z10;
        boolean z11;
        int i10 = 0;
        switch (this.f1352a) {
            case 0:
                i0 i0Var = (i0) obj;
                d1 d1Var = (d1) this.f1353b;
                i0Var.getClass();
                d1Var.h = i0Var;
                if (d1Var.j) {
                    d1Var.j = false;
                    d1Var.c();
                }
                Object a8 = d1.a(d1Var, i0Var.f1268a.f1290a, a1.f1190a, cVar);
                return a8 == u6.a.f10762a ? a8 : p6.x.f8463a;
            case 1:
                j5.s sVar = (j5.s) obj;
                FeedActivity feedActivity = (FeedActivity) this.f1353b;
                if (!kotlin.jvm.internal.l.a(sVar, j5.p.f6705a)) {
                    if (sVar instanceof j5.r) {
                        v2 v2Var = (v2) ((j5.r) sVar).f6707a;
                        if (v2Var.f11423b == 1) {
                            String string2 = feedActivity.getString(2131952032);
                            string2.getClass();
                            feedActivity.A(string2);
                        } else {
                            int i11 = v2Var.f11424c;
                            if (i11 == 401) {
                                String string3 = feedActivity.getString(2131952181);
                                string3.getClass();
                                String string4 = feedActivity.getString(2131952180);
                                string4.getClass();
                                t1.v(feedActivity, string3, string4);
                            } else if (i11 == 409) {
                                String string5 = feedActivity.getString(2131951675);
                                string5.getClass();
                                feedActivity.A(string5);
                            } else {
                                String string6 = feedActivity.getString(2131951998);
                                string6.getClass();
                                feedActivity.A(string6);
                            }
                        }
                    } else if (!kotlin.jvm.internal.l.a(sVar, j5.q.f6706a)) {
                        com.google.gson.internal.a.b();
                        return null;
                    }
                }
                return p6.x.f8463a;
            case 2:
                j5.s sVar2 = (j5.s) obj;
                FollowListActivity followListActivity = (FollowListActivity) this.f1353b;
                int i12 = FollowListActivity.S;
                if (followListActivity.z0().f1409e && !kotlin.jvm.internal.l.a(sVar2, j5.p.f6705a)) {
                    if (sVar2 instanceof j5.r) {
                        v2 v2Var2 = (v2) ((j5.r) sVar2).f6707a;
                        if (v2Var2.f11423b != 1) {
                            int i13 = v2Var2.f11424c;
                            if (i13 == 401) {
                                String string7 = followListActivity.getString(2131952181);
                                string7.getClass();
                                String string8 = followListActivity.getString(2131952180);
                                string8.getClass();
                                t1.v(followListActivity, string7, string8);
                            } else if (i13 == 409) {
                                String string9 = followListActivity.getString(2131951675);
                                string9.getClass();
                                followListActivity.A(string9);
                            } else {
                                String string10 = followListActivity.getString(2131951998);
                                string10.getClass();
                                followListActivity.A(string10);
                            }
                        } else if (v2Var2.f11425d == 1) {
                            String string11 = followListActivity.getString(2131952032);
                            string11.getClass();
                            followListActivity.A(string11);
                        } else {
                            String string12 = followListActivity.getString(2131952686);
                            string12.getClass();
                            followListActivity.A(string12);
                        }
                        followListActivity.z0().f1409e = false;
                    } else if (!kotlin.jvm.internal.l.a(sVar2, j5.q.f6706a)) {
                        com.google.gson.internal.a.b();
                        return null;
                    }
                }
                return p6.x.f8463a;
            case 3:
                return a((j5.s) obj, cVar);
            case 4:
                j5.s sVar3 = (j5.s) obj;
                MyDownloads myDownloads = (MyDownloads) this.f1353b;
                if (sVar3 instanceof j5.p) {
                    int i14 = MyDownloads.V;
                    myDownloads.A0().f10238b.setVisibility(0);
                } else if (sVar3 instanceof j5.r) {
                    int i15 = MyDownloads.V;
                    myDownloads.A0().f10238b.setVisibility(8);
                    ((RelativeLayout) myDownloads.A0().f10239l.f5278n).setVisibility(0);
                    l5 l5Var = (l5) ((j5.r) sVar3).f6707a;
                    ArrayList arrayList = l5Var.f1824a;
                    ArrayList arrayList2 = l5Var.f1825b;
                    if (!myDownloads.isFinishing()) {
                        if (myDownloads.Q == null) {
                            myDownloads.Q = new e4.b(myDownloads.U);
                            myDownloads.A0().f10241n.setAdapter(myDownloads.Q);
                        }
                        e4.b bVar = myDownloads.Q;
                        bVar.getClass();
                        bVar.f4485b = new ArrayList();
                        if (arrayList2 != null && !arrayList2.isEmpty()) {
                            bVar.f4485b.addAll(arrayList2);
                        }
                        if (!arrayList.isEmpty()) {
                            bVar.f4485b.addAll(arrayList);
                        }
                        bVar.f4487d = new boolean[bVar.f4485b.size()];
                        bVar.notifyDataSetChanged();
                    }
                    if (!myDownloads.isFinishing()) {
                        if (l5Var.f1824a.isEmpty() && arrayList2.isEmpty()) {
                            myDownloads.A0().f10244q.setVisibility(0);
                            i = 8;
                            myDownloads.A0().f10241n.setVisibility(8);
                        } else {
                            i = 8;
                            myDownloads.A0().f10244q.setVisibility(8);
                            myDownloads.A0().f10241n.setVisibility(0);
                        }
                        myDownloads.A0().f10238b.setVisibility(i);
                    }
                } else if (!(sVar3 instanceof j5.q)) {
                    com.google.gson.internal.a.b();
                    return null;
                }
                return p6.x.f8463a;
            case 5:
                j5.s sVar4 = (j5.s) obj;
                MyStatsActivity myStatsActivity = (MyStatsActivity) this.f1353b;
                if (!kotlin.jvm.internal.l.a(sVar4, j5.p.f6705a)) {
                    if (sVar4 instanceof j5.r) {
                        x2 x2Var = ((r5) ((j5.r) sVar4).f6707a).f2048a;
                        int i16 = MyStatsActivity.R;
                        String str5 = x2Var.f11453a;
                        String k5 = str5 != null ? a4.x.k(str5, UptodownApp.Q, ":webp") : null;
                        if (k5 != null && k5.length() != 0) {
                            a4.g0 d10 = a4.g0.d();
                            String str6 = x2Var.f11453a;
                            a4.l0 e10 = d10.e(str6 != null ? a4.x.k(str6, UptodownApp.K, ":webp") : null);
                            float f = UptodownApp.I;
                            e10.h(b4.d.y(myStatsActivity));
                            e10.e(myStatsActivity.y0().f10258b, null);
                            myStatsActivity.y0().f10258b.setBackground(ContextCompat.getDrawable(myStatsActivity, 2131231186));
                        }
                        if (x2Var.f11454b == 1) {
                            ImageView imageView = myStatsActivity.y0().f10258b;
                            int dimension = (int) imageView.getContext().getResources().getDimension(2131165270);
                            imageView.setForeground(ContextCompat.getDrawable(imageView.getContext(), 2131231273));
                            imageView.setPadding(dimension, dimension, dimension, dimension);
                        }
                        int s6 = z3.s(myStatsActivity, 0, "stats_downloads");
                        int s9 = z3.s(myStatsActivity, 0, "stats_installs");
                        int s10 = z3.s(myStatsActivity, 0, "stats_updates");
                        long t9 = z3.t(0L, myStatsActivity, "stats_time");
                        myStatsActivity.y0().G.setText(j5.c.c(s6 + x2Var.f11461r));
                        int color = ContextCompat.getColor(myStatsActivity, 2131100801);
                        int color2 = ContextCompat.getColor(myStatsActivity, 2131100500);
                        TextView textView = myStatsActivity.y0().G;
                        String obj2 = textView.getText().toString();
                        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, textView.getPaint().measureText(myStatsActivity.y0().G.getText().toString()), textView.getHeight(), new int[]{color, color2}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
                        SpannableString spannableString = new SpannableString(obj2);
                        spannableString.setSpan(new j5.b(linearGradient, myStatsActivity.getResources().getDimension(2131165354)), 0, myStatsActivity.y0().G.length(), 33);
                        textView.setText(spannableString);
                        myStatsActivity.y0().f10264q.setText(j5.c.c(s9 + x2Var.f11462s));
                        myStatsActivity.y0().I.setText(j5.c.c(s10 + x2Var.f11463t));
                        myStatsActivity.y0().C.setText(String.valueOf(x2Var.f11455l));
                        myStatsActivity.y0().f10268u.setText(String.valueOf(x2Var.f11456m));
                        myStatsActivity.y0().A.setText(String.valueOf(x2Var.f11457n));
                        myStatsActivity.y0().f10266s.setText(String.valueOf(x2Var.f11458o));
                        myStatsActivity.y0().f10271y.setText(String.valueOf(x2Var.f11459p));
                        myStatsActivity.y0().f10269w.setText(String.valueOf(x2Var.f11460q));
                        long j = t9 + x2Var.f11464u;
                        TextView textView2 = myStatsActivity.y0().D;
                        ConcurrentHashMap concurrentHashMap = j5.t.f6708a;
                        long j6 = 3600;
                        long j10 = (j % 86400) / j6;
                        long j11 = (j % j6) / 60;
                        if (j10 <= 0 || j11 <= 0) {
                            i6 = 0;
                            if (j10 > 0) {
                                string = myStatsActivity.getString(2131952645, Long.valueOf(j10));
                                string.getClass();
                            } else if (j11 > 0) {
                                string = myStatsActivity.getString(2131952646, Long.valueOf(j11));
                                string.getClass();
                            } else {
                                string = myStatsActivity.getString(2131952646, 0);
                                string.getClass();
                            }
                        } else {
                            i6 = 0;
                            string = myStatsActivity.getString(2131952644, Long.valueOf(j10), Long.valueOf(j11));
                            string.getClass();
                        }
                        textView2.setText(string);
                        myStatsActivity.y0().f10260m.setVisibility(i6);
                        myStatsActivity.y0().K.setBackground(ContextCompat.getDrawable(myStatsActivity, 2131231204));
                        myStatsActivity.y0().K.setVisibility(i6);
                        myStatsActivity.y0().f10259l.setVisibility(8);
                    } else if (!kotlin.jvm.internal.l.a(sVar4, j5.q.f6706a)) {
                        com.google.gson.internal.a.b();
                        return null;
                    }
                }
                return p6.x.f8463a;
            case 6:
                j5.s sVar5 = (j5.s) obj;
                NotificationsRegistryActivity notificationsRegistryActivity = (NotificationsRegistryActivity) this.f1353b;
                if (sVar5 instanceof j5.p) {
                    int i17 = NotificationsRegistryActivity.T;
                    notificationsRegistryActivity.A0().f9640b.setVisibility(0);
                } else if (sVar5 instanceof j5.r) {
                    ArrayList arrayList3 = ((y5) ((j5.r) sVar5).f6707a).f2346a;
                    int i18 = NotificationsRegistryActivity.T;
                    boolean isEmpty = arrayList3.isEmpty();
                    e4.q qVar = notificationsRegistryActivity.R;
                    if (isEmpty) {
                        if (qVar != null) {
                            qVar.f4657a = new ArrayList();
                        }
                        e4.q qVar2 = notificationsRegistryActivity.R;
                        if (qVar2 != null) {
                            qVar2.notifyDataSetChanged();
                        }
                        z9 = false;
                        notificationsRegistryActivity.A0().f9643n.setVisibility(0);
                    } else {
                        if (qVar == null) {
                            notificationsRegistryActivity.R = new e4.q(arrayList3, notificationsRegistryActivity, notificationsRegistryActivity.S);
                            notificationsRegistryActivity.A0().f9641l.setAdapter(notificationsRegistryActivity.R);
                        } else {
                            qVar.f4657a = arrayList3;
                            if (qVar != null) {
                                qVar.notifyDataSetChanged();
                            }
                        }
                        notificationsRegistryActivity.A0().f9643n.setVisibility(8);
                        z9 = false;
                    }
                    notificationsRegistryActivity.Q = z9;
                    notificationsRegistryActivity.A0().f9640b.setVisibility(8);
                } else if (!(sVar5 instanceof j5.q)) {
                    com.google.gson.internal.a.b();
                    return null;
                }
                return p6.x.f8463a;
            case 7:
                j5.s sVar6 = (j5.s) obj;
                OrganizationActivity organizationActivity = (OrganizationActivity) this.f1353b;
                if (kotlin.jvm.internal.l.a(sVar6, j5.p.f6705a)) {
                    if (organizationActivity.Q == null) {
                        organizationActivity.y0().f9692p.setVisibility(0);
                    }
                } else if (sVar6 instanceof j5.r) {
                    m6 m6Var = (m6) ((j5.r) sVar6).f6707a;
                    boolean z12 = m6Var.f1868b;
                    u1 u1Var = m6Var.f1867a;
                    if (z12) {
                        e4.b0 b0Var = organizationActivity.Q;
                        b0Var.getClass();
                        ArrayList arrayList4 = u1Var.f11418l;
                        if (arrayList4 != null && !arrayList4.isEmpty()) {
                            b0Var.f4491c.size();
                            Iterator it = arrayList4.iterator();
                            it.getClass();
                            while (it.hasNext()) {
                                Object next = it.next();
                                next.getClass();
                                e4.t tVar = new e4.t();
                                tVar.f4688a = (x4.g) next;
                                tVar.f4689b = 5;
                                b0Var.f4491c.add(tVar);
                                b0Var.notifyItemInserted(q6.m.c0(b0Var.f4491c));
                            }
                        }
                    } else {
                        int i19 = OrganizationActivity.R;
                        if (!organizationActivity.z0().h) {
                            t4.d0 y02 = organizationActivity.y0();
                            TextView textView3 = y02.f9699x;
                            TextView textView4 = y02.f9698w;
                            TextView textView5 = y02.f9697u;
                            ImageView imageView2 = y02.f9690n;
                            ImageView imageView3 = y02.f9688l;
                            ImageView imageView4 = y02.f9691o;
                            TextView textView6 = y02.f9700y;
                            TextView textView7 = y02.v;
                            textView3.setText(u1Var.f11412a);
                            String str7 = u1Var.f;
                            if (str7 == null || str7.length() == 0 || (str2 = u1Var.h) == null || str2.length() == 0 || (str3 = u1Var.g) == null || str3.length() == 0) {
                                organizationActivity.y0().f9693q.setVisibility(8);
                            } else {
                                String str8 = u1Var.f;
                                if (str8 != null && str8.length() != 0) {
                                    a4.g0 d11 = a4.g0.d();
                                    String str9 = u1Var.f;
                                    a4.l0 e11 = d11.e(str9 != null ? a4.x.k(str9, UptodownApp.L, ":webp") : null);
                                    float f10 = UptodownApp.I;
                                    e11.h(b4.d.w(organizationActivity));
                                    e11.e(y02.f9687b, null);
                                }
                                String str10 = u1Var.g;
                                if (str10 != null && str10.length() != 0) {
                                    a4.g0 d12 = a4.g0.d();
                                    String str11 = u1Var.g;
                                    a4.l0 e12 = d12.e(str11 != null ? a4.x.k(str11, UptodownApp.K, ":webp") : null);
                                    float f11 = UptodownApp.I;
                                    e12.h(b4.d.x(organizationActivity));
                                    e12.e(y02.f9689m, null);
                                }
                                textView7.setTypeface(f4.c.f4882w);
                                textView7.setText(u1Var.f11412a);
                                textView6.setTypeface(f4.c.f4882w);
                                textView6.setOnClickListener(new j6(u1Var, organizationActivity));
                                String str12 = u1Var.f11414c;
                                if (str12 != null && str12.length() != 0) {
                                    imageView4.setVisibility(0);
                                    imageView4.setOnClickListener(new j6(organizationActivity, u1Var, 1));
                                }
                                String str13 = u1Var.f11415d;
                                if (str13 != null && str13.length() != 0) {
                                    imageView3.setVisibility(0);
                                    imageView3.setOnClickListener(new j6(organizationActivity, u1Var, 2));
                                }
                                String str14 = u1Var.f11416e;
                                if (str14 != null && str14.length() != 0) {
                                    imageView2.setVisibility(0);
                                    imageView2.setOnClickListener(new j6(organizationActivity, u1Var, 3));
                                }
                                textView5.setTypeface(f4.c.f4883x);
                                textView5.setText(u1Var.h);
                                textView4.setTypeface(f4.c.f4882w);
                                textView4.setOnClickListener(new c.e(14, u1Var, y02));
                            }
                            organizationActivity.z0().h = true;
                        }
                        if (organizationActivity.Q == null && (str = u1Var.f11412a) != null && str.length() != 0) {
                            a3.d dVar = new a3.d(organizationActivity, 11);
                            String str15 = u1Var.f11412a;
                            str15.getClass();
                            e4.b0 b0Var2 = new e4.b0();
                            b0Var2.f4489a = dVar;
                            b0Var2.f4490b = str15;
                            b0Var2.f4491c = new ArrayList();
                            organizationActivity.Q = b0Var2;
                            organizationActivity.y0().f9694r.setAdapter(organizationActivity.Q);
                        }
                        e4.b0 b0Var3 = organizationActivity.Q;
                        if (b0Var3 != null) {
                            x4.g gVar = u1Var.i;
                            ArrayList arrayList5 = u1Var.j;
                            ArrayList arrayList6 = u1Var.f11417k;
                            ArrayList arrayList7 = u1Var.f11418l;
                            ArrayList arrayList8 = new ArrayList();
                            b0Var3.f4491c = arrayList8;
                            if (gVar != null) {
                                e4.t tVar2 = new e4.t();
                                tVar2.f4688a = gVar;
                                tVar2.f4689b = 1;
                                arrayList8.add(tVar2);
                            }
                            if (arrayList5 != null && !arrayList5.isEmpty()) {
                                e4.t tVar3 = new e4.t();
                                tVar3.f4688a = arrayList5;
                                tVar3.f4689b = 2;
                                b0Var3.f4491c.add(tVar3);
                            }
                            if (arrayList6 != null && !arrayList6.isEmpty()) {
                                e4.t tVar4 = new e4.t();
                                tVar4.f4688a = arrayList6;
                                tVar4.f4689b = 3;
                                b0Var3.f4491c.add(tVar4);
                            }
                            if (arrayList7 != null && !arrayList7.isEmpty()) {
                                e4.t tVar5 = new e4.t();
                                tVar5.f4688a = arrayList7;
                                tVar5.f4689b = 4;
                                b0Var3.f4491c.add(tVar5);
                                Iterator it2 = arrayList7.iterator();
                                it2.getClass();
                                while (it2.hasNext()) {
                                    Object next2 = it2.next();
                                    next2.getClass();
                                    e4.t tVar6 = new e4.t();
                                    tVar6.f4688a = (x4.g) next2;
                                    tVar6.f4689b = 5;
                                    b0Var3.f4491c.add(tVar6);
                                }
                            }
                        }
                    }
                    int i20 = OrganizationActivity.R;
                    organizationActivity.y0().f9692p.setVisibility(8);
                    organizationActivity.y0().f9695s.setVisibility(0);
                    e4.b0 b0Var4 = organizationActivity.Q;
                    if (b0Var4 != null) {
                        b0Var4.a(false);
                    }
                } else {
                    if (!kotlin.jvm.internal.l.a(sVar6, j5.q.f6706a)) {
                        com.google.gson.internal.a.b();
                        return null;
                    }
                    e4.b0 b0Var5 = organizationActivity.Q;
                    if (b0Var5 != null) {
                        b0Var5.a(false);
                    }
                }
                return p6.x.f8463a;
            case 8:
                return a((j5.s) obj, cVar);
            case 9:
                j5.s sVar7 = (j5.s) obj;
                PreregistrationActivity preregistrationActivity = (PreregistrationActivity) this.f1353b;
                if (sVar7 instanceof j5.p) {
                    if (preregistrationActivity.Q == null) {
                        preregistrationActivity.y0().f9904l.setVisibility(0);
                    }
                } else if (sVar7 instanceof j5.r) {
                    Object obj3 = ((j5.r) sVar7).f6707a;
                    if (((Collection) obj3).isEmpty()) {
                        int i21 = PreregistrationActivity.T;
                        preregistrationActivity.y0().f9908p.setVisibility(0);
                        preregistrationActivity.y0().f9905m.setVisibility(8);
                    } else {
                        ArrayList arrayList9 = (ArrayList) obj3;
                        e4.d0 d0Var = preregistrationActivity.Q;
                        if (d0Var == null) {
                            preregistrationActivity.Q = new e4.d0(arrayList9, preregistrationActivity, preregistrationActivity.R);
                            preregistrationActivity.y0().f9905m.setAdapter(preregistrationActivity.Q);
                        } else {
                            arrayList9.getClass();
                            d0Var.a(arrayList9);
                        }
                        preregistrationActivity.y0().f9905m.setVisibility(0);
                    }
                    int i22 = PreregistrationActivity.T;
                    preregistrationActivity.y0().f9907o.setVisibility(0);
                    preregistrationActivity.y0().f9904l.setVisibility(8);
                } else if (!(sVar7 instanceof j5.q)) {
                    com.google.gson.internal.a.b();
                    return null;
                }
                return p6.x.f8463a;
            case 10:
                j5.s sVar8 = (j5.s) obj;
                PublicListActivity publicListActivity = (PublicListActivity) this.f1353b;
                if (sVar8 instanceof j5.p) {
                    if (publicListActivity.f3336c0 == null) {
                        publicListActivity.N0().f9943b.setVisibility(0);
                    }
                } else if (sVar8 instanceof j5.r) {
                    ArrayList arrayList10 = (ArrayList) ((j5.r) sVar8).f6707a;
                    if (arrayList10.size() == 0) {
                        int i23 = PublicListActivity.f3334e0;
                        publicListActivity.N0().f9946n.setVisibility(0);
                    } else {
                        e4.e1 e1Var = publicListActivity.f3336c0;
                        if (e1Var == null) {
                            publicListActivity.f3336c0 = new e4.e1(arrayList10, publicListActivity, publicListActivity.f3337d0);
                            publicListActivity.N0().f9944l.setAdapter(publicListActivity.f3336c0);
                        } else {
                            e1Var.f4519a.addAll(arrayList10);
                            e1Var.notifyDataSetChanged();
                            e4.e1 e1Var2 = publicListActivity.f3336c0;
                            if (e1Var2 != null) {
                                e1Var2.d(false);
                            }
                        }
                    }
                    int i24 = PublicListActivity.f3334e0;
                    publicListActivity.N0().f9943b.setVisibility(8);
                } else {
                    if (!(sVar8 instanceof j5.q)) {
                        com.google.gson.internal.a.b();
                        return null;
                    }
                    int i25 = PublicListActivity.f3334e0;
                    publicListActivity.N0().f9943b.setVisibility(8);
                    e4.e1 e1Var3 = publicListActivity.f3336c0;
                    if (e1Var3 != null) {
                        e1Var3.d(false);
                        e4.e1 e1Var4 = publicListActivity.f3336c0;
                        e1Var4.getClass();
                        if (e1Var4.f4519a.isEmpty()) {
                            publicListActivity.N0().f9946n.setVisibility(0);
                        }
                    }
                }
                return p6.x.f8463a;
            case 11:
                j5.s sVar9 = (j5.s) obj;
                RollbackActivity rollbackActivity = (RollbackActivity) this.f1353b;
                if (sVar9 instanceof j5.p) {
                    int i26 = RollbackActivity.f3344f0;
                    rollbackActivity.N0().f10109b.setVisibility(0);
                } else if (sVar9 instanceof j5.r) {
                    ArrayList arrayList11 = ((k9) ((j5.r) sVar9).f6707a).f1797a;
                    e4.j0 j0Var = rollbackActivity.f3346c0;
                    if (j0Var == null) {
                        rollbackActivity.f3346c0 = new e4.j0(arrayList11, rollbackActivity, rollbackActivity.f3347d0);
                        rollbackActivity.N0().f10110l.setAdapter(rollbackActivity.f3346c0);
                    } else {
                        j0Var.f4570a = new ArrayList(arrayList11);
                        j0Var.notifyDataSetChanged();
                    }
                    rollbackActivity.N0().f10114p.setVisibility(0);
                    rollbackActivity.N0().f10109b.setVisibility(8);
                } else {
                    if (!(sVar9 instanceof j5.q)) {
                        com.google.gson.internal.a.b();
                        return null;
                    }
                    int i27 = RollbackActivity.f3344f0;
                    rollbackActivity.N0().f10109b.setVisibility(8);
                    rollbackActivity.N0().f10113o.setVisibility(0);
                    rollbackActivity.N0().f10113o.setText(rollbackActivity.getString(2131952389));
                }
                return p6.x.f8463a;
            case 12:
                j5.s sVar10 = (j5.s) obj;
                SecurityActivity securityActivity = (SecurityActivity) this.f1353b;
                if (sVar10 instanceof j5.p) {
                    int i28 = SecurityActivity.f3349g0;
                    securityActivity.N0().f10211b.setVisibility(0);
                } else if (sVar10 instanceof j5.r) {
                    ArrayList arrayList12 = (ArrayList) ((j5.r) sVar10).f6707a;
                    if (arrayList12.isEmpty()) {
                        int i29 = SecurityActivity.f3349g0;
                        securityActivity.N0().f10212l.setVisibility(0);
                        securityActivity.N0().f10213m.setVisibility(8);
                        TextView textView8 = securityActivity.N0().f10216p;
                        long t10 = z3.t(0L, securityActivity, "last_analysis_timestamp");
                        textView8.setText(securityActivity.getString(2131952721, String.valueOf(t10 > 0 ? new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault()).format(new Date(t10)) : null)));
                    } else {
                        int i30 = SecurityActivity.f3349g0;
                        securityActivity.N0().f10213m.setVisibility(0);
                        securityActivity.N0().f10212l.setVisibility(8);
                        e4.n0 n0Var = securityActivity.f3351c0;
                        if (n0Var == null) {
                            securityActivity.f3351c0 = new e4.n0(arrayList12, securityActivity, securityActivity.f3354f0, securityActivity.f3353e0);
                            securityActivity.N0().f10213m.setAdapter(securityActivity.f3351c0);
                        } else {
                            n0Var.f4644d = new ArrayList();
                            n0Var.a().add("uptodown_protect");
                            n0Var.a().addAll(arrayList12);
                            n0Var.notifyDataSetChanged();
                        }
                    }
                    securityActivity.N0().f10211b.setVisibility(8);
                } else if (!(sVar10 instanceof j5.q)) {
                    com.google.gson.internal.a.b();
                    return null;
                }
                return p6.x.f8463a;
            case 13:
                j5.s sVar11 = (j5.s) obj;
                UserCommentsActivity userCommentsActivity = (UserCommentsActivity) this.f1353b;
                if (sVar11 instanceof j5.r) {
                    j2 j2Var = (j2) ((j5.r) sVar11).f6707a;
                    if (j2Var.f11245b == 1) {
                        e4.b1 b1Var = userCommentsActivity.Q;
                        if (b1Var != null) {
                            k2 k2Var = j2Var.f11244a;
                            k2Var.getClass();
                            ArrayList arrayList13 = b1Var.f4493a;
                            Iterator it3 = arrayList13.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    int i31 = i10 + 1;
                                    if (((k2) it3.next()).f11258a != k2Var.f11258a) {
                                        i10 = i31;
                                    }
                                } else {
                                    i10 = -1;
                                }
                            }
                            arrayList13.set(i10, k2Var);
                            b1Var.notifyItemChanged(i10);
                        }
                    } else if (j2Var.f11246c == 401) {
                        String string13 = userCommentsActivity.getString(2131952183);
                        string13.getClass();
                        String string14 = userCommentsActivity.getString(2131952182);
                        string14.getClass();
                        t1.v(userCommentsActivity, string13, string14);
                    } else {
                        String string15 = userCommentsActivity.getString(2131951998);
                        string15.getClass();
                        userCommentsActivity.A(string15);
                    }
                }
                return p6.x.f8463a;
            case 14:
                j5.s sVar12 = (j5.s) obj;
                UsernameEditActivity usernameEditActivity = (UsernameEditActivity) this.f1353b;
                if (sVar12 instanceof j5.p) {
                    int i32 = UsernameEditActivity.R;
                    usernameEditActivity.y0().f9854s.setVisibility(0);
                } else if (sVar12 instanceof j5.r) {
                    gd gdVar = (gd) ((j5.r) sVar12).f6707a;
                    int i33 = gdVar.f1652a;
                    String str16 = gdVar.f1654c;
                    if (i33 != 0 && !gdVar.f1653b) {
                        String string16 = usernameEditActivity.getString(2131952750);
                        string16.getClass();
                        usernameEditActivity.A(string16);
                        usernameEditActivity.setResult(10);
                        usernameEditActivity.finish();
                    } else if (str16 == null || str16.length() == 0) {
                        String string17 = usernameEditActivity.getString(2131951998);
                        string17.getClass();
                        usernameEditActivity.A(string17);
                    } else {
                        usernameEditActivity.A(str16);
                    }
                    int i34 = UsernameEditActivity.R;
                    usernameEditActivity.y0().f9854s.setVisibility(8);
                } else if (!(sVar12 instanceof j5.q)) {
                    com.google.gson.internal.a.b();
                    return null;
                }
                return p6.x.f8463a;
            case 15:
                return b(obj, cVar);
            case 16:
                return c(obj, cVar);
            case 17:
                return d(obj, cVar);
            case 18:
                return e(obj, cVar);
            case 19:
                x4.i0 i0Var2 = (x4.i0) obj;
                if (i0Var2 instanceof x4.f0) {
                    ((u4.a1) this.f1353b).f10422e = ((x4.f0) i0Var2).f11150a;
                }
                return p6.x.f8463a;
            case 20:
                return f(obj, cVar);
            default:
                l4.m mVar = (l4.m) obj;
                Context context = (Context) this.f1353b;
                if (!(mVar instanceof l4.i)) {
                    if (mVar instanceof l4.g) {
                        l4.a aVar = ((l4.g) mVar).f7114a;
                        str4 = aVar != null ? aVar.f7095a : null;
                        Object systemService = context.getSystemService("notification");
                        systemService.getClass();
                        ((NotificationManager) systemService).cancel(255);
                        if (str4 != null) {
                            j5.g l10 = j5.g.D.l(context);
                            l10.b();
                            q2 Y = l10.Y(str4);
                            l10.c();
                            if (Y != null) {
                                WorkManager.Companion.getInstance(context).enqueue(new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) AppUpdatedWorker.class).setInputData(new Data.Builder().putString("packagename", str4).build()).addTag("AppUpdatedWorker").build());
                            } else {
                                WorkManager.Companion.getInstance(context).enqueue(new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) AppInstalledWorker.class).setInputData(new Data.Builder().putString("packagename", str4).build()).addTag("AppInstalledWorker").build());
                            }
                        } else {
                            new android.support.v4.media.g(context, 20).E(k0.k.e(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "success"), "install");
                            float f12 = UptodownApp.I;
                            b4.d.F(context);
                        }
                    } else if (mVar instanceof l4.f) {
                        l4.f fVar = (l4.f) mVar;
                        l4.a aVar2 = fVar.f7111a;
                        y4.a.a(context, aVar2 != null ? aVar2.f7095a : null, aVar2 != null ? aVar2.f7096b : -1L, aVar2 != null ? aVar2.f7099e : -1L, fVar.f7112b, new Integer(fVar.f7113c), 64);
                    } else if (mVar instanceof l4.e) {
                        l4.a aVar3 = ((l4.e) mVar).f7110a;
                        str4 = aVar3 != null ? aVar3.f7095a : null;
                        long j12 = aVar3 != null ? aVar3.f7096b : -1L;
                        Bundle e13 = k0.k.e(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "cancelled");
                        if (str4 != null) {
                            e13.putString("packagename", str4);
                            if (j12 > 0) {
                                j5.g l11 = j5.g.D.l(context);
                                l11.b();
                                x4.r L = l11.L(j12, str4);
                                if (L != null) {
                                    long j13 = L.f11361q;
                                    if (j13 > 0) {
                                        e13.putString("appId", String.valueOf(j13));
                                    }
                                    z11 = L.f11369z > 0;
                                    z10 = L.A == 1;
                                } else {
                                    z10 = false;
                                    z11 = false;
                                }
                                l11.c();
                            } else {
                                z10 = false;
                                z11 = false;
                            }
                            t1.i(context, str4, e13, z10);
                            if (z11) {
                                e13.putInt("update", 1);
                                e13.putString("updateOrigin", a5.e.a(str4));
                            } else {
                                e13.putInt("update", 0);
                            }
                            a5.e.f205a.remove(str4);
                        }
                        new android.support.v4.media.g(context, 20).E(e13, "install");
                        Object systemService2 = context.getSystemService("notification");
                        systemService2.getClass();
                        ((NotificationManager) systemService2).cancel(255);
                        a5.d.a(new k1(str4));
                    } else if (mVar instanceof l4.h) {
                        l4.a aVar4 = ((l4.h) mVar).f7115a;
                        y4.a.a(context, aVar4.f7095a, aVar4.f7096b, aVar4.f7099e, null, null, 48);
                    } else if (!(mVar instanceof l4.l) && !(mVar instanceof l4.j) && !(mVar instanceof l4.k)) {
                        com.google.gson.internal.a.b();
                        return null;
                    }
                }
                return p6.x.f8463a;
        }
    }
}
