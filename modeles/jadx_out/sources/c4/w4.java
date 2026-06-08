package c4;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.nsd.NsdServiceInfo;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.uptodown.UptodownApp;
import com.uptodown.workers.GenerateQueueWorker;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class w4 extends k0 {
    public static final /* synthetic */ int Y = 0;
    public ProgressBar O;
    public TextView P;
    public TextView Q;
    public boolean R;
    public o7.s1 S;
    public ArrayList T = new ArrayList();
    public boolean U;
    public t4.a0 V;
    public File W;
    public boolean X;

    public static void C0(Toolbar toolbar, boolean z9) {
        if (toolbar.getMenu() != null) {
            Menu menu = toolbar.getMenu();
            menu.getClass();
            menu.findItem(2131361895).setEnabled(z9);
        }
    }

    public static void D0(x4.e eVar) {
        eVar.getClass();
        float f = UptodownApp.I;
        String str = eVar.f11123l;
        str.getClass();
        if (b4.d.m(str)) {
            return;
        }
        b4.d.c(eVar);
    }

    public static final void y0(w4 w4Var, String str, String str2) {
        AlertDialog alertDialog = w4Var.F;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        int i = 0;
        View inflate = w4Var.getLayoutInflater().inflate(2131558492, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(2131364381)).setTypeface(f4.c.f4882w);
        TextView textView = (TextView) inflate.findViewById(2131364013);
        textView.setTypeface(f4.c.f4883x);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(2131364112);
        textView2.setTypeface(f4.c.f4882w);
        textView2.setOnClickListener(new q4(w4Var, 3));
        TextView textView3 = (TextView) inflate.findViewById(2131363686);
        textView3.setTypeface(f4.c.f4882w);
        textView3.setOnClickListener(new q4(w4Var, 4));
        if (str2 != null && str2.length() != 0) {
            TextView textView4 = (TextView) inflate.findViewById(2131364283);
            textView4.setTypeface(f4.c.f4882w);
            textView4.setOnClickListener(new r4(w4Var, str2, i));
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(w4Var);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        w4Var.F = create;
        create.getClass();
        Window window = create.getWindow();
        if (window != null) {
            a4.x.y(window, 0);
        }
        AlertDialog alertDialog2 = w4Var.F;
        alertDialog2.getClass();
        alertDialog2.show();
    }

    public void A0(String str, ArrayList arrayList) {
        str.getClass();
        String string = getString(2131952292);
        string.getClass();
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(lifecycleScope, t7.n.f10348a, null, new w(this, str, string, arrayList, null, 3), 2);
    }

    public final void B0(x4.e eVar, int i) {
        long j;
        Window window;
        Socket socket;
        NsdServiceInfo nsdServiceInfo;
        String str;
        x4.e eVar2 = eVar;
        if (isFinishing()) {
            return;
        }
        int i6 = 0;
        View inflate = getLayoutInflater().inflate(2131558741, (ViewGroup) null, false);
        int i10 = 2131362373;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362373);
        if (imageView != null) {
            i10 = 2131363174;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363174);
            if (relativeLayout != null) {
                i10 = 2131363185;
                if (((RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363185)) != null) {
                    i10 = 2131363376;
                    SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(inflate, 2131363376);
                    if (switchCompat != null) {
                        i10 = 2131363636;
                        TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363636);
                        if (textView != null) {
                            i10 = 2131363637;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363637);
                            if (textView2 != null) {
                                i10 = 2131363673;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131363673);
                                if (textView3 != null) {
                                    i10 = 2131363715;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131363715);
                                    if (textView4 != null) {
                                        i10 = 2131363858;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(inflate, 2131363858);
                                        if (textView5 != null) {
                                            i10 = 2131363900;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(inflate, 2131363900);
                                            if (textView6 != null) {
                                                i10 = 2131364104;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(inflate, 2131364104);
                                                if (textView7 != null) {
                                                    i10 = 2131364116;
                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(inflate, 2131364116);
                                                    if (textView8 != null) {
                                                        i10 = 2131364118;
                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(inflate, 2131364118);
                                                        if (textView9 != null) {
                                                            i10 = 2131364261;
                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(inflate, 2131364261);
                                                            if (textView10 != null) {
                                                                i10 = 2131364281;
                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(inflate, 2131364281);
                                                                if (textView11 != null) {
                                                                    i10 = 2131364366;
                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(inflate, 2131364366);
                                                                    if (textView12 != null) {
                                                                        i10 = 2131364403;
                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(inflate, 2131364403);
                                                                        if (textView13 != null) {
                                                                            i10 = 2131364414;
                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(inflate, 2131364414);
                                                                            if (textView14 != null) {
                                                                                i10 = 2131364424;
                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(inflate, 2131364424);
                                                                                if (textView15 != null) {
                                                                                    i10 = 2131364486;
                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(inflate, 2131364486);
                                                                                    if (textView16 != null) {
                                                                                        i10 = 2131364492;
                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(inflate, 2131364492);
                                                                                        if (textView17 != null) {
                                                                                            i10 = 2131364561;
                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(inflate, 2131364561);
                                                                                            if (textView18 != null) {
                                                                                                i10 = 2131364562;
                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(inflate, 2131364562);
                                                                                                if (textView19 != null) {
                                                                                                    i10 = 2131364586;
                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(inflate, 2131364586);
                                                                                                    if (textView20 != null) {
                                                                                                        i10 = 2131364634;
                                                                                                        View findChildViewById = ViewBindings.findChildViewById(inflate, 2131364634);
                                                                                                        if (findChildViewById != null) {
                                                                                                            i10 = 2131364639;
                                                                                                            View findChildViewById2 = ViewBindings.findChildViewById(inflate, 2131364639);
                                                                                                            if (findChildViewById2 != null) {
                                                                                                                i10 = 2131364645;
                                                                                                                View findChildViewById3 = ViewBindings.findChildViewById(inflate, 2131364645);
                                                                                                                if (findChildViewById3 != null) {
                                                                                                                    this.V = new t4.a0((RelativeLayout) inflate, imageView, relativeLayout, switchCompat, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, findChildViewById, findChildViewById2, findChildViewById3);
                                                                                                                    textView2.setTypeface(f4.c.f4882w);
                                                                                                                    t4.a0 a0Var = this.V;
                                                                                                                    if (a0Var == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    a0Var.f9576o.setText(eVar2.f11122b);
                                                                                                                    t4.a0 a0Var2 = this.V;
                                                                                                                    if (a0Var2 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    a0Var2.B.setTypeface(f4.c.f4882w);
                                                                                                                    t4.a0 a0Var3 = this.V;
                                                                                                                    if (a0Var3 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    a0Var3.A.setTypeface(f4.c.f4882w);
                                                                                                                    t4.a0 a0Var4 = this.V;
                                                                                                                    if (a0Var4 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    a0Var4.f9586z.setTypeface(f4.c.f4882w);
                                                                                                                    t4.a0 a0Var5 = this.V;
                                                                                                                    if (a0Var5 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    a0Var5.f9585y.setTypeface(f4.c.f4882w);
                                                                                                                    ConcurrentHashMap concurrentHashMap = j5.t.f6708a;
                                                                                                                    Drawable b7 = j5.t.b(this, eVar2.f11123l);
                                                                                                                    t4.a0 a0Var6 = this.V;
                                                                                                                    if (a0Var6 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    a0Var6.f9572b.setImageDrawable(b7);
                                                                                                                    e1.c0 c0Var = j5.g.D;
                                                                                                                    Context applicationContext = getApplicationContext();
                                                                                                                    applicationContext.getClass();
                                                                                                                    j5.g l10 = c0Var.l(applicationContext);
                                                                                                                    l10.b();
                                                                                                                    String str2 = eVar2.f11123l;
                                                                                                                    str2.getClass();
                                                                                                                    x4.q2 Y2 = l10.Y(str2);
                                                                                                                    l10.c();
                                                                                                                    int i11 = 6;
                                                                                                                    int i12 = 1;
                                                                                                                    int i13 = 8;
                                                                                                                    if (com.google.android.gms.internal.measurement.z3.f2928c) {
                                                                                                                        String str3 = eVar2.f11123l;
                                                                                                                        if (str3 == null || str3.length() == 0 || (str = eVar2.f11132u) == null || str.length() == 0 || eVar2.F == 0) {
                                                                                                                            t4.a0 a0Var7 = this.V;
                                                                                                                            if (a0Var7 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var7.f9583w.setVisibility(8);
                                                                                                                        } else {
                                                                                                                            t4.a0 a0Var8 = this.V;
                                                                                                                            if (a0Var8 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var8.f9583w.setTypeface(f4.c.f4883x);
                                                                                                                            t4.a0 a0Var9 = this.V;
                                                                                                                            if (a0Var9 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var9.f9583w.setOnClickListener(new o4(this, eVar2, i6));
                                                                                                                        }
                                                                                                                        x4.r rVar = Y2 != null ? Y2.f11352s : null;
                                                                                                                        t4.a0 a0Var10 = this.V;
                                                                                                                        if (Y2 != null) {
                                                                                                                            if (a0Var10 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var10.D.setTypeface(f4.c.f4883x);
                                                                                                                            float f = UptodownApp.I;
                                                                                                                            if (b4.d.l(Y2)) {
                                                                                                                                t4.a0 a0Var11 = this.V;
                                                                                                                                if (a0Var11 == null) {
                                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                    throw null;
                                                                                                                                }
                                                                                                                                a0Var11.D.setText(getString(2131951652));
                                                                                                                            } else if (rVar != null && rVar.c()) {
                                                                                                                                t4.a0 a0Var12 = this.V;
                                                                                                                                if (a0Var12 == null) {
                                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                    throw null;
                                                                                                                                }
                                                                                                                                a0Var12.D.setText(getString(2131952403));
                                                                                                                            } else if (rVar == null || rVar.i() <= 0) {
                                                                                                                                t4.a0 a0Var13 = this.V;
                                                                                                                                if (a0Var13 == null) {
                                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                    throw null;
                                                                                                                                }
                                                                                                                                a0Var13.D.setText(getString(2131951657));
                                                                                                                            } else {
                                                                                                                                t4.a0 a0Var14 = this.V;
                                                                                                                                if (a0Var14 == null) {
                                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                    throw null;
                                                                                                                                }
                                                                                                                                a0Var14.D.setText(getString(2131952713));
                                                                                                                            }
                                                                                                                            t4.a0 a0Var15 = this.V;
                                                                                                                            if (a0Var15 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var15.D.setOnClickListener(new o4(this, eVar2, 9));
                                                                                                                        } else {
                                                                                                                            if (a0Var10 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var10.D.setVisibility(8);
                                                                                                                        }
                                                                                                                        t4.a0 a0Var16 = this.V;
                                                                                                                        if (a0Var16 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var16.f9581t.setTypeface(f4.c.f4883x);
                                                                                                                        t4.a0 a0Var17 = this.V;
                                                                                                                        if (a0Var17 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var17.f9581t.setOnClickListener(new o4(this, eVar2, i12));
                                                                                                                        m4.b bVar = f4.c.f4885z;
                                                                                                                        int i14 = 2;
                                                                                                                        if (bVar == null || (socket = bVar.f7283d) == null || socket.isClosed()) {
                                                                                                                            j = 0;
                                                                                                                        } else {
                                                                                                                            m4.g gVar = f4.c.f4884y;
                                                                                                                            String serviceName = (gVar == null || (nsdServiceInfo = gVar.f) == null) ? null : nsdServiceInfo.getServiceName();
                                                                                                                            t4.a0 a0Var18 = this.V;
                                                                                                                            if (serviceName == null) {
                                                                                                                                j = 0;
                                                                                                                                if (a0Var18 == null) {
                                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                    throw null;
                                                                                                                                }
                                                                                                                                a0Var18.f9581t.setVisibility(8);
                                                                                                                            } else {
                                                                                                                                if (a0Var18 == null) {
                                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                    throw null;
                                                                                                                                }
                                                                                                                                j = 0;
                                                                                                                                a0Var18.f9581t.setText(String.format("%s%s", Arrays.copyOf(new Object[]{getString(2131952413), serviceName.substring(0, l7.m.y0(serviceName, "_d:_", 0, false, 6))}, 2)));
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (eVar2.G != 1 || eVar2.F == j) {
                                                                                                                            t4.a0 a0Var19 = this.V;
                                                                                                                            if (a0Var19 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var19.f9582u.setVisibility(8);
                                                                                                                        } else {
                                                                                                                            t4.a0 a0Var20 = this.V;
                                                                                                                            if (a0Var20 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var20.f9582u.setTypeface(f4.c.f4883x);
                                                                                                                            t4.a0 a0Var21 = this.V;
                                                                                                                            if (a0Var21 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var21.f9582u.setOnClickListener(new o4(this, eVar2, i14));
                                                                                                                        }
                                                                                                                        int i15 = 3;
                                                                                                                        if (eVar2.B == null || eVar2.F <= j) {
                                                                                                                            t4.a0 a0Var22 = this.V;
                                                                                                                            if (a0Var22 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var22.G.setVisibility(8);
                                                                                                                        } else {
                                                                                                                            t4.a0 a0Var23 = this.V;
                                                                                                                            if (a0Var23 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var23.G.setVisibility(0);
                                                                                                                            t4.a0 a0Var24 = this.V;
                                                                                                                            if (a0Var24 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var24.G.setTypeface(f4.c.f4883x);
                                                                                                                            t4.a0 a0Var25 = this.V;
                                                                                                                            if (a0Var25 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var25.G.setOnClickListener(new o4(this, eVar2, i15));
                                                                                                                        }
                                                                                                                        if (Y2 == null || eVar2.f11127p != x4.d.f11087a || eVar2.v != 0 || eVar2.F <= j) {
                                                                                                                            t4.a0 a0Var26 = this.V;
                                                                                                                            if (a0Var26 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var26.f9578q.setVisibility(8);
                                                                                                                            t4.a0 a0Var27 = this.V;
                                                                                                                            if (a0Var27 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var27.F.setVisibility(8);
                                                                                                                            t4.a0 a0Var28 = this.V;
                                                                                                                            if (a0Var28 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var28.E.setVisibility(8);
                                                                                                                        } else {
                                                                                                                            t4.a0 a0Var29 = this.V;
                                                                                                                            if (a0Var29 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var29.f9578q.setTypeface(f4.c.f4883x);
                                                                                                                            t4.a0 a0Var30 = this.V;
                                                                                                                            if (a0Var30 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var30.f9578q.setOnClickListener(new p4(Y2, this));
                                                                                                                            t4.a0 a0Var31 = this.V;
                                                                                                                            if (a0Var31 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var31.F.setTypeface(f4.c.f4883x);
                                                                                                                            t4.a0 a0Var32 = this.V;
                                                                                                                            if (a0Var32 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var32.F.setOnClickListener(new t(this, eVar2, Y2, i15));
                                                                                                                            String str4 = Y2.f11350q;
                                                                                                                            if (str4 == null || str4.length() == 0) {
                                                                                                                                t4.a0 a0Var33 = this.V;
                                                                                                                                if (a0Var33 == null) {
                                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                    throw null;
                                                                                                                                }
                                                                                                                                a0Var33.E.setVisibility(8);
                                                                                                                            } else {
                                                                                                                                t4.a0 a0Var34 = this.V;
                                                                                                                                if (a0Var34 == null) {
                                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                    throw null;
                                                                                                                                }
                                                                                                                                a0Var34.E.setTypeface(f4.c.f4883x);
                                                                                                                                t4.a0 a0Var35 = this.V;
                                                                                                                                if (a0Var35 == null) {
                                                                                                                                    kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                    throw null;
                                                                                                                                }
                                                                                                                                a0Var35.E.setOnClickListener(new p4(this, Y2));
                                                                                                                            }
                                                                                                                        }
                                                                                                                        long j6 = eVar2.F;
                                                                                                                        t4.a0 a0Var36 = this.V;
                                                                                                                        if (j6 > j) {
                                                                                                                            if (a0Var36 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var36.f9584x.setTypeface(f4.c.f4883x);
                                                                                                                            t4.a0 a0Var37 = this.V;
                                                                                                                            if (a0Var37 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var37.f9584x.setOnClickListener(new o4(this, eVar2, 4));
                                                                                                                        } else {
                                                                                                                            if (a0Var36 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var36.f9584x.setVisibility(8);
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        j = 0;
                                                                                                                        t4.a0 a0Var38 = this.V;
                                                                                                                        if (a0Var38 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var38.f9583w.setVisibility(8);
                                                                                                                        t4.a0 a0Var39 = this.V;
                                                                                                                        if (a0Var39 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var39.D.setVisibility(8);
                                                                                                                        t4.a0 a0Var40 = this.V;
                                                                                                                        if (a0Var40 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var40.f9581t.setVisibility(8);
                                                                                                                        t4.a0 a0Var41 = this.V;
                                                                                                                        if (a0Var41 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var41.f9582u.setVisibility(8);
                                                                                                                        t4.a0 a0Var42 = this.V;
                                                                                                                        if (a0Var42 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var42.G.setVisibility(8);
                                                                                                                        t4.a0 a0Var43 = this.V;
                                                                                                                        if (a0Var43 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var43.f9578q.setVisibility(8);
                                                                                                                        t4.a0 a0Var44 = this.V;
                                                                                                                        if (a0Var44 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var44.F.setVisibility(8);
                                                                                                                        t4.a0 a0Var45 = this.V;
                                                                                                                        if (a0Var45 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var45.E.setVisibility(8);
                                                                                                                        t4.a0 a0Var46 = this.V;
                                                                                                                        if (a0Var46 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var46.f9584x.setVisibility(8);
                                                                                                                    }
                                                                                                                    boolean m02 = l7.u.m0(getPackageName(), eVar2.f11123l, true);
                                                                                                                    t4.a0 a0Var47 = this.V;
                                                                                                                    if (m02) {
                                                                                                                        if (a0Var47 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var47.v.setVisibility(8);
                                                                                                                        t4.a0 a0Var48 = this.V;
                                                                                                                        if (a0Var48 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var48.C.setVisibility(8);
                                                                                                                    } else {
                                                                                                                        if (a0Var47 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var47.v.setTypeface(f4.c.f4883x);
                                                                                                                        t4.a0 a0Var49 = this.V;
                                                                                                                        if (a0Var49 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var49.v.setOnClickListener(new o4(eVar2, this, 5));
                                                                                                                        t4.a0 a0Var50 = this.V;
                                                                                                                        if (a0Var50 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var50.C.setTypeface(f4.c.f4883x);
                                                                                                                        t4.a0 a0Var51 = this.V;
                                                                                                                        if (a0Var51 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var51.C.setOnClickListener(new o4(eVar2, this, i11));
                                                                                                                    }
                                                                                                                    float f10 = UptodownApp.I;
                                                                                                                    t4.a0 a0Var52 = this.V;
                                                                                                                    if (a0Var52 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    if (a0Var52.f9584x.getVisibility() == 8) {
                                                                                                                        t4.a0 a0Var53 = this.V;
                                                                                                                        if (a0Var53 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        if (a0Var53.f9581t.getVisibility() == 8) {
                                                                                                                            t4.a0 a0Var54 = this.V;
                                                                                                                            if (a0Var54 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var54.f9586z.setVisibility(8);
                                                                                                                            t4.a0 a0Var55 = this.V;
                                                                                                                            if (a0Var55 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var55.I.setVisibility(8);
                                                                                                                        }
                                                                                                                    }
                                                                                                                    long j10 = eVar2.F;
                                                                                                                    t4.a0 a0Var56 = this.V;
                                                                                                                    if (j10 <= j) {
                                                                                                                        if (a0Var56 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var56.B.setVisibility(8);
                                                                                                                        t4.a0 a0Var57 = this.V;
                                                                                                                        if (a0Var57 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var57.f9573l.setVisibility(8);
                                                                                                                        t4.a0 a0Var58 = this.V;
                                                                                                                        if (a0Var58 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var58.f9578q.setVisibility(8);
                                                                                                                        t4.a0 a0Var59 = this.V;
                                                                                                                        if (a0Var59 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var59.E.setVisibility(8);
                                                                                                                        t4.a0 a0Var60 = this.V;
                                                                                                                        if (a0Var60 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var60.f9580s.setVisibility(8);
                                                                                                                        t4.a0 a0Var61 = this.V;
                                                                                                                        if (a0Var61 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var61.J.setVisibility(8);
                                                                                                                    } else {
                                                                                                                        if (a0Var56 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var56.f9579r.setTypeface(f4.c.f4883x);
                                                                                                                        t4.a0 a0Var62 = this.V;
                                                                                                                        if (a0Var62 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var62.f9574m.setChecked(eVar2.v == 0);
                                                                                                                        t4.a0 a0Var63 = this.V;
                                                                                                                        if (a0Var63 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var63.f9573l.setOnClickListener(new s4(this, l10, eVar2, i, 0));
                                                                                                                        t4.a0 a0Var64 = this.V;
                                                                                                                        if (a0Var64 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        eVar2 = eVar;
                                                                                                                        a0Var64.f9574m.setOnClickListener(new s4(this, l10, eVar2, i, 1));
                                                                                                                    }
                                                                                                                    t4.a0 a0Var65 = this.V;
                                                                                                                    if (Y2 != null) {
                                                                                                                        if (a0Var65 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var65.f9580s.setVisibility(0);
                                                                                                                        t4.a0 a0Var66 = this.V;
                                                                                                                        if (a0Var66 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var66.f9580s.setTypeface(f4.c.f4883x);
                                                                                                                        boolean c9 = Y2.c();
                                                                                                                        t4.a0 a0Var67 = this.V;
                                                                                                                        if (c9) {
                                                                                                                            if (a0Var67 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var67.f9580s.setText(2131952509);
                                                                                                                        } else {
                                                                                                                            if (a0Var67 == null) {
                                                                                                                                kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            a0Var67.f9580s.setText(2131952608);
                                                                                                                        }
                                                                                                                        t4.a0 a0Var68 = this.V;
                                                                                                                        if (a0Var68 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var68.f9580s.setOnClickListener(new t(this, Y2, l10, i));
                                                                                                                    } else {
                                                                                                                        if (a0Var65 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var65.f9580s.setVisibility(8);
                                                                                                                    }
                                                                                                                    if (eVar2.f11123l != null) {
                                                                                                                        t4.a0 a0Var69 = this.V;
                                                                                                                        if (a0Var69 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var69.f9577p.setVisibility(0);
                                                                                                                        t4.a0 a0Var70 = this.V;
                                                                                                                        if (a0Var70 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var70.f9577p.setTypeface(f4.c.f4883x);
                                                                                                                        t4.a0 a0Var71 = this.V;
                                                                                                                        if (a0Var71 == null) {
                                                                                                                            kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        a0Var71.f9577p.setOnClickListener(new o4(this, eVar2, 7));
                                                                                                                    }
                                                                                                                    t4.a0 a0Var72 = this.V;
                                                                                                                    if (a0Var72 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    a0Var72.f9575n.setTypeface(f4.c.f4883x);
                                                                                                                    t4.a0 a0Var73 = this.V;
                                                                                                                    if (a0Var73 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    a0Var73.f9575n.setOnClickListener(new o4(this, eVar2, i13));
                                                                                                                    t4.a0 a0Var74 = this.V;
                                                                                                                    if (a0Var74 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    a0Var74.H.setOnClickListener(new q4(this, i11));
                                                                                                                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                                                                                                                    t4.a0 a0Var75 = this.V;
                                                                                                                    if (a0Var75 == null) {
                                                                                                                        kotlin.jvm.internal.l.i("dialogBinding");
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    builder.setView(a0Var75.f9571a);
                                                                                                                    AlertDialog create = builder.create();
                                                                                                                    this.F = create;
                                                                                                                    if (create != null) {
                                                                                                                        create.setOnCancelListener(new u(this, 1));
                                                                                                                    }
                                                                                                                    if (isFinishing()) {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    AlertDialog alertDialog = this.F;
                                                                                                                    if (alertDialog != null && (window = alertDialog.getWindow()) != null) {
                                                                                                                        a4.x.y(window, 0);
                                                                                                                    }
                                                                                                                    AlertDialog alertDialog2 = this.F;
                                                                                                                    if (alertDialog2 != null) {
                                                                                                                        alertDialog2.show();
                                                                                                                    }
                                                                                                                    this.U = true;
                                                                                                                    return;
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public final void E0(j5.g gVar, x4.e eVar, int i) {
        float f = UptodownApp.I;
        if (b4.d.t()) {
            AlertDialog alertDialog = this.F;
            alertDialog.getClass();
            alertDialog.dismiss();
            this.U = false;
            gVar.b();
            if (eVar.v == 0) {
                eVar.v = 1;
                eVar.f11127p = x4.d.f11088b;
                Context applicationContext = getApplicationContext();
                applicationContext.getClass();
                a.a.r(applicationContext);
            } else {
                eVar.v = 0;
                eVar.f11127p = x4.d.f11087a;
            }
            gVar.m0(eVar);
            gVar.c();
            J0();
        }
    }

    @Override // g4.s0
    public final void F() {
        File file;
        m4.g gVar = f4.c.f4884y;
        gVar.getClass();
        if (gVar.f == null || (file = this.W) == null || file.isDirectory()) {
            return;
        }
        new UptodownApp();
        File file2 = this.W;
        file2.getClass();
        f4.c.c(file2);
    }

    public abstract String F0();

    public final void G0(x4.e eVar) {
        String str = eVar.f11123l;
        if (str == null || str.length() == 0) {
            return;
        }
        j5.g l10 = j5.g.D.l(this);
        l10.b();
        String str2 = eVar.f11123l;
        str2.getClass();
        x4.q2 Y2 = l10.Y(str2);
        if (Y2 != null) {
            float f = UptodownApp.I;
            if (b4.d.l(Y2)) {
                a5.c.d();
                b4.d.u(Y2);
            } else if (b4.d.m(Y2.f11344b)) {
                b4.d.v(Y2);
            }
        }
        l10.c();
    }

    public final void I0(x4.e eVar) {
        if (!com.google.android.gms.internal.measurement.z3.f2928c) {
            String string = getString(2131952001);
            string.getClass();
            N(string);
            return;
        }
        if ((eVar != null ? eVar.f11123l : null) != null) {
            e1.c0 c0Var = j5.g.D;
            Context applicationContext = getApplicationContext();
            applicationContext.getClass();
            j5.g l10 = c0Var.l(applicationContext);
            l10.b();
            String str = eVar.f11123l;
            str.getClass();
            x4.q2 Y2 = l10.Y(str);
            if (Y2 != null) {
                float f = UptodownApp.I;
                if (!b4.d.l(Y2)) {
                    x4.r rVar = Y2.f11352s;
                    if (rVar != null) {
                        if (rVar.c()) {
                            x4.r rVar2 = Y2.f11352s;
                            rVar2.getClass();
                            boolean m02 = l7.u.m0(rVar2.f11355b, getApplicationContext().getPackageName(), true);
                            x4.r rVar3 = Y2.f11352s;
                            if (m02) {
                                rVar3.getClass();
                                File g = rVar3.g();
                                if (g == null || !g.exists()) {
                                    x4.r rVar4 = Y2.f11352s;
                                    rVar4.getClass();
                                    Context applicationContext2 = getApplicationContext();
                                    applicationContext2.getClass();
                                    rVar4.t(applicationContext2);
                                    String string2 = getString(2131952085);
                                    string2.getClass();
                                    N(string2);
                                } else {
                                    M(g);
                                }
                            } else {
                                rVar3.getClass();
                                File g3 = rVar3.g();
                                if (g3 == null || !g3.exists()) {
                                    x4.r rVar5 = Y2.f11352s;
                                    rVar5.getClass();
                                    Context applicationContext3 = getApplicationContext();
                                    applicationContext3.getClass();
                                    rVar5.t(applicationContext3);
                                    String string3 = getString(2131952085);
                                    string3.getClass();
                                    N(string3);
                                } else {
                                    x4.r rVar6 = Y2.f11352s;
                                    rVar6.getClass();
                                    String str2 = rVar6.f11355b;
                                    if (str2 != null) {
                                        LinkedHashMap linkedHashMap = a5.e.f205a;
                                        a5.e.b(str2, F0());
                                    }
                                    if (Y2.f11349p == 1) {
                                        S(Y2, g3);
                                    } else {
                                        W(g3, Y2.f11350q);
                                    }
                                }
                            }
                        } else {
                            boolean p10 = b4.d.p(this, "DownloadUpdatesWorker");
                            String str3 = eVar.f11123l;
                            if (p10) {
                                str3.getClass();
                                if (b4.d.m(str3)) {
                                    b4.d.v(Y2);
                                } else {
                                    D0(eVar);
                                }
                            } else {
                                z0(str3);
                            }
                        }
                    } else if (b4.d.p(this, "DownloadUpdatesWorker")) {
                        D0(eVar);
                    } else {
                        z0(eVar.f11123l);
                    }
                } else if (a5.c.f197a.getValue() instanceof x4.y0) {
                    a5.c.f();
                } else if (b4.d.p(this, "DownloadUpdatesWorker")) {
                    a5.c.d();
                } else {
                    z0(eVar.f11123l);
                }
            }
            l10.c();
        }
    }

    public final void L0(d7.a aVar) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(lifecycleScope, t7.n.f10348a, null, new b6.a(this, aVar, null, 14), 2);
    }

    public final void M0(String str) {
        float f = UptodownApp.I;
        if (b4.d.p(this, "GenerateQueueWorker") || b4.d.p(this, "downloadApkWorker") || b4.d.p(this, "DownloadUpdatesWorker")) {
            if (b4.d.p(this, "downloadApkWorker")) {
                String string = getString(2131951994);
                string.getClass();
                N(string);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            LinkedHashMap linkedHashMap = a5.e.f205a;
            a5.e.b(str, F0());
        }
        if (!arrayList.isEmpty()) {
            str.getClass();
            A0(str, arrayList);
            return;
        }
        this.R = true;
        if (b4.d.p(this, "GenerateQueueWorker")) {
            return;
        }
        WorkManager.Companion.getInstance(this).enqueue(((OneTimeWorkRequest.Builder) androidx.lifecycle.l.t(GenerateQueueWorker.class, "GenerateQueueWorker")).setInputData(new Data.Builder().putBoolean("downloadAnyway", true).putString("packagename", str).build()).build());
    }

    public final void z0(String str) {
        if (com.google.android.gms.internal.measurement.z3.f || com.google.android.gms.internal.measurement.z3.h(this)) {
            M0(str);
        } else {
            L0(new androidx.work.impl.utils.c(4, this, str));
        }
    }

    public void H0() {
    }

    public void J0() {
    }

    public void K0() {
    }
}
