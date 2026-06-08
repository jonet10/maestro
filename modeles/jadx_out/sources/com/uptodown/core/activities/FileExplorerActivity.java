package com.uptodown.core.activities;

import a3.d;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.UriPermission;
import android.net.Uri;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.recyclerview.widget.RecyclerView;
import c.e;
import c4.ib;
import c4.y2;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.material.tabs.TabLayout;
import f0.i;
import f4.c;
import g4.g;
import g4.j;
import g4.o;
import g4.s0;
import g4.v;
import g4.x;
import i4.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.l;
import l7.m;
import o7.c0;
import o7.m0;
import y2.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class FileExplorerActivity extends s0 {

    /* renamed from: q0, reason: collision with root package name */
    public static final /* synthetic */ int f3379q0 = 0;
    public TextView E;
    public RecyclerView F;
    public RelativeLayout G;
    public LinearLayout H;
    public LinearLayout I;
    public HorizontalScrollView J;
    public TextView K;
    public TextView L;
    public TextView M;
    public SearchView N;
    public RelativeLayout O;
    public RadioButton P;
    public RadioButton Q;
    public RadioButton R;
    public AlertDialog S;
    public Toolbar T;
    public TextView U;
    public b V;
    public ArrayList W;
    public ArrayList X;
    public DocumentFile Y;
    public ArrayList Z;
    public ArrayList a0;

    /* renamed from: b0, reason: collision with root package name */
    public ArrayList f3380b0;

    /* renamed from: c0, reason: collision with root package name */
    public File f3381c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f3382d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f3383e0;

    /* renamed from: f0, reason: collision with root package name */
    public ArrayList f3384f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f3385g0;

    /* renamed from: h0, reason: collision with root package name */
    public TabLayout f3386h0;

    /* renamed from: i0, reason: collision with root package name */
    public TextView f3387i0;

    /* renamed from: j0, reason: collision with root package name */
    public Uri f3388j0;

    /* renamed from: k0, reason: collision with root package name */
    public String f3389k0;

    /* renamed from: l0, reason: collision with root package name */
    public final i f3390l0 = new i(this, 27);

    /* renamed from: m0, reason: collision with root package name */
    public final d f3391m0 = new d(this, 29);
    public final x n0 = new x(this);

    /* renamed from: o0, reason: collision with root package name */
    public final c4.b f3392o0 = new c4.b(this, 8);

    /* renamed from: p0, reason: collision with root package name */
    public final ActivityResultLauncher f3393p0;

    public FileExplorerActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new j(this));
        registerForActivityResult.getClass();
        this.f3393p0 = registerForActivityResult;
    }

    public static final void H(FileExplorerActivity fileExplorerActivity) {
        AlertDialog alertDialog = fileExplorerActivity.S;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        View inflate = fileExplorerActivity.getLayoutInflater().inflate(2131558487, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(2131363814);
        textView.setTypeface(c.f4883x);
        textView.setText(textView.getContext().getString(2131951929));
        TextView textView2 = (TextView) inflate.findViewById(2131363606);
        textView2.setText(fileExplorerActivity.getString(2131952418));
        textView2.setTypeface(c.f4882w);
        textView2.setOnClickListener(new g(fileExplorerActivity, 8));
        TextView textView3 = (TextView) inflate.findViewById(2131363700);
        textView3.setText(fileExplorerActivity.getString(2131952425));
        textView3.setTypeface(c.f4882w);
        textView3.setOnClickListener(new g(fileExplorerActivity, 9));
        AlertDialog.Builder builder = new AlertDialog.Builder(fileExplorerActivity);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        fileExplorerActivity.S = create;
        create.getClass();
        Window window = create.getWindow();
        if (window != null) {
            a4.x.y(window, 0);
        }
        AlertDialog alertDialog2 = fileExplorerActivity.S;
        alertDialog2.getClass();
        alertDialog2.show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
    
        if (o7.c0.C(r1, r7, r0) != r5) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
    
        if (o7.c0.C(r1, r7, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object I(com.uptodown.core.activities.FileExplorerActivity r6, v6.c r7) {
        /*
            boolean r0 = r7 instanceof g4.p
            if (r0 == 0) goto L13
            r0 = r7
            g4.p r0 = (g4.p) r0
            int r1 = r0.f5240l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5240l = r1
            goto L18
        L13:
            g4.p r0 = new g4.p
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f5238a
            int r1 = r0.f5240l
            r2 = 0
            r3 = 2
            r4 = 1
            u6.a r5 = u6.a.f10762a
            if (r1 == 0) goto L35
            if (r1 == r4) goto L31
            if (r1 != r3) goto L2b
            p6.a.e(r7)
            goto L5d
        L2b:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            return r2
        L31:
            p6.a.e(r7)
            goto L4a
        L35:
            p6.a.e(r7)
            v7.e r7 = o7.m0.f8288a
            v7.d r7 = v7.d.f10884a
            g4.n r1 = new g4.n
            r1.<init>(r6, r2, r3)
            r0.f5240l = r4
            java.lang.Object r7 = o7.c0.C(r1, r7, r0)
            if (r7 != r5) goto L4a
            goto L5c
        L4a:
            v7.e r7 = o7.m0.f8288a
            p7.c r7 = t7.n.f10348a
            g4.n r1 = new g4.n
            r4 = 3
            r1.<init>(r6, r2, r4)
            r0.f5240l = r3
            java.lang.Object r6 = o7.c0.C(r1, r7, r0)
            if (r6 != r5) goto L5d
        L5c:
            return r5
        L5d:
            p6.x r6 = p6.x.f8463a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.I(com.uptodown.core.activities.FileExplorerActivity, v6.c):java.lang.Object");
    }

    public static final void J(FileExplorerActivity fileExplorerActivity, String str, int i, int i6, long j) {
        AlertDialog alertDialog = fileExplorerActivity.f5176a;
        if (alertDialog != null) {
            TextView textView = (TextView) alertDialog.findViewById(2131364382);
            if (textView != null) {
                textView.setText(fileExplorerActivity.getString(2131951836, fileExplorerActivity.getString(2131952607, String.valueOf(i), String.valueOf(i6))));
            }
            AlertDialog alertDialog2 = fileExplorerActivity.f5176a;
            alertDialog2.getClass();
            TextView textView2 = (TextView) alertDialog2.findViewById(2131363877);
            if (textView2 != null) {
                textView2.setTypeface(c.f4883x);
                textView2.setText(str);
                return;
            }
            return;
        }
        View inflate = fileExplorerActivity.getLayoutInflater().inflate(2131558500, (ViewGroup) null, false);
        TextView textView3 = (TextView) inflate.findViewById(2131364382);
        textView3.setTypeface(c.f4882w);
        textView3.setText(fileExplorerActivity.getString(2131951836, fileExplorerActivity.getString(2131952607, String.valueOf(i), String.valueOf(i6))));
        TextView textView4 = (TextView) inflate.findViewById(2131364300);
        textView4.setTypeface(c.f4883x);
        textView4.setText(fileExplorerActivity.getString(2131952607, fileExplorerActivity.getString(2131952232, fileExplorerActivity.getString(2131952829)), i5.G(j)));
        ((ProgressBar) inflate.findViewById(2131362994)).setProgress(0);
        TextView textView5 = (TextView) inflate.findViewById(2131363877);
        textView5.setTypeface(c.f4883x);
        textView5.setText(str);
        TextView textView6 = (TextView) inflate.findViewById(2131364159);
        textView6.setTypeface(c.f4883x);
        textView6.setText(fileExplorerActivity.getString(2131952829) + fileExplorerActivity.getString(2131952468));
        AlertDialog.Builder builder = new AlertDialog.Builder(fileExplorerActivity);
        builder.setView(inflate);
        builder.setCancelable(false);
        if (fileExplorerActivity.isFinishing()) {
            return;
        }
        AlertDialog create = builder.create();
        fileExplorerActivity.f5176a = create;
        create.getClass();
        Window window = create.getWindow();
        if (window != null) {
            a4.x.y(window, 0);
        }
        AlertDialog alertDialog3 = fileExplorerActivity.f5176a;
        alertDialog3.getClass();
        alertDialog3.show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        if (o7.c0.C(r1, r8, r0) != r5) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005d, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
    
        if (o7.c0.C(r1, r8, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object K(com.uptodown.core.activities.FileExplorerActivity r7, v6.c r8) {
        /*
            boolean r0 = r8 instanceof g4.r
            if (r0 == 0) goto L13
            r0 = r8
            g4.r r0 = (g4.r) r0
            int r1 = r0.f5249l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5249l = r1
            goto L18
        L13:
            g4.r r0 = new g4.r
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f5247a
            int r1 = r0.f5249l
            r2 = 0
            r3 = 2
            r4 = 1
            u6.a r5 = u6.a.f10762a
            if (r1 == 0) goto L35
            if (r1 == r4) goto L31
            if (r1 != r3) goto L2b
            p6.a.e(r8)
            goto L5e
        L2b:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r7)
            return r2
        L31:
            p6.a.e(r8)
            goto L4b
        L35:
            p6.a.e(r8)
            v7.e r8 = o7.m0.f8288a
            v7.d r8 = v7.d.f10884a
            g4.n r1 = new g4.n
            r6 = 5
            r1.<init>(r7, r2, r6)
            r0.f5249l = r4
            java.lang.Object r8 = o7.c0.C(r1, r8, r0)
            if (r8 != r5) goto L4b
            goto L5d
        L4b:
            v7.e r8 = o7.m0.f8288a
            p7.c r8 = t7.n.f10348a
            g4.n r1 = new g4.n
            r4 = 6
            r1.<init>(r7, r2, r4)
            r0.f5249l = r3
            java.lang.Object r7 = o7.c0.C(r1, r8, r0)
            if (r7 != r5) goto L5e
        L5d:
            return r5
        L5e:
            p6.x r7 = p6.x.f8463a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.K(com.uptodown.core.activities.FileExplorerActivity, v6.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0086, code lost:
    
        if (o7.c0.C(r3, r10, r0) == r6) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0070, code lost:
    
        if (o7.c0.C(r4, r10, r0) != r6) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object L(com.uptodown.core.activities.FileExplorerActivity r9, v6.c r10) {
        /*
            boolean r0 = r10 instanceof g4.s
            if (r0 == 0) goto L13
            r0 = r10
            g4.s r0 = (g4.s) r0
            int r1 = r0.f5256m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5256m = r1
            goto L18
        L13:
            g4.s r0 = new g4.s
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f5254b
            int r1 = r0.f5256m
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            u6.a r6 = u6.a.f10762a
            if (r1 == 0) goto L40
            if (r1 == r4) goto L3a
            if (r1 == r3) goto L34
            if (r1 != r2) goto L2e
            p6.a.e(r10)
            goto L89
        L2e:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r9)
            return r5
        L34:
            kotlin.jvm.internal.v r1 = r0.f5253a
            p6.a.e(r10)
            goto L73
        L3a:
            kotlin.jvm.internal.v r1 = r0.f5253a
            p6.a.e(r10)
            goto L5f
        L40:
            p6.a.e(r10)
            kotlin.jvm.internal.v r10 = new kotlin.jvm.internal.v
            r10.<init>()
            v7.e r1 = o7.m0.f8288a
            p7.c r1 = t7.n.f10348a
            g4.n r7 = new g4.n
            r8 = 11
            r7.<init>(r9, r5, r8)
            r0.f5253a = r10
            r0.f5256m = r4
            java.lang.Object r1 = o7.c0.C(r7, r1, r0)
            if (r1 != r6) goto L5e
            goto L88
        L5e:
            r1 = r10
        L5f:
            v7.e r10 = o7.m0.f8288a
            v7.d r10 = v7.d.f10884a
            g4.t r4 = new g4.t
            r4.<init>(r9, r1, r5)
            r0.f5253a = r1
            r0.f5256m = r3
            java.lang.Object r10 = o7.c0.C(r4, r10, r0)
            if (r10 != r6) goto L73
            goto L88
        L73:
            v7.e r10 = o7.m0.f8288a
            p7.c r10 = t7.n.f10348a
            c4.sc r3 = new c4.sc
            r4 = 8
            r3.<init>(r9, r1, r5, r4)
            r0.f5253a = r5
            r0.f5256m = r2
            java.lang.Object r9 = o7.c0.C(r3, r10, r0)
            if (r9 != r6) goto L89
        L88:
            return r6
        L89:
            p6.x r9 = p6.x.f8463a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.L(com.uptodown.core.activities.FileExplorerActivity, v6.c):java.lang.Object");
    }

    public static final void M(FileExplorerActivity fileExplorerActivity, Object obj) {
        String str;
        AlertDialog alertDialog;
        if (fileExplorerActivity.isFinishing()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(fileExplorerActivity);
        LayoutInflater layoutInflater = fileExplorerActivity.getLayoutInflater();
        layoutInflater.getClass();
        View inflate = layoutInflater.inflate(2131558503, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(2131363820)).setTypeface(c.f4882w);
        TextView textView = (TextView) inflate.findViewById(2131363812);
        textView.setTypeface(c.f4883x);
        RadioButton radioButton = (RadioButton) inflate.findViewById(2131363059);
        radioButton.setTypeface(c.f4883x);
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(2131363060);
        radioButton2.setTypeface(c.f4883x);
        View findViewById = inflate.findViewById(2131363809);
        findViewById.getClass();
        TextView textView2 = (TextView) findViewById;
        fileExplorerActivity.L = textView2;
        textView2.setTypeface(c.f4883x);
        kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
        if (obj instanceof File) {
            xVar.f7024a = ((File) obj).getParent();
        } else if (obj instanceof DocumentFile) {
            DocumentFile documentFile = fileExplorerActivity.Y;
            documentFile.getClass();
            String lastPathSegment = documentFile.getUri().getLastPathSegment();
            if (lastPathSegment != null) {
                DocumentFile documentFile2 = fileExplorerActivity.Y;
                documentFile2.getClass();
                String lastPathSegment2 = documentFile2.getUri().getLastPathSegment();
                lastPathSegment2.getClass();
                str = lastPathSegment.substring(m.A0(":", lastPathSegment2, 6) + 1);
            } else {
                str = null;
            }
            xVar.f7024a = a4.x.k(fileExplorerActivity.getString(2131952558), "/", str);
        }
        TextView textView3 = fileExplorerActivity.L;
        if (textView3 == null) {
            l.i("tvSelectedPath");
            throw null;
        }
        textView3.setText((CharSequence) xVar.f7024a);
        fileExplorerActivity.f3389k0 = (String) xVar.f7024a;
        TextView textView4 = (TextView) inflate.findViewById(2131363607);
        textView4.setTypeface(c.f4882w);
        TextView textView5 = (TextView) inflate.findViewById(2131363703);
        textView5.setTypeface(c.f4882w);
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(2131362995);
        TextView textView6 = fileExplorerActivity.L;
        if (textView6 == null) {
            l.i("tvSelectedPath");
            throw null;
        }
        textView6.setOnClickListener(new g(fileExplorerActivity, 13));
        radioButton.setOnCheckedChangeListener(new ib(fileExplorerActivity, xVar));
        radioButton2.setOnCheckedChangeListener(new g4.i(fileExplorerActivity, 3));
        kotlin.jvm.internal.x xVar2 = new kotlin.jvm.internal.x();
        textView4.setOnClickListener(new y2(obj, fileExplorerActivity, xVar2, new v(textView, fileExplorerActivity, inflate, progressBar, textView4, textView5), 3));
        textView5.setOnClickListener(new g4.l(xVar2, fileExplorerActivity, 1));
        builder.setView(inflate);
        fileExplorerActivity.S = builder.create();
        if (fileExplorerActivity.isFinishing() || (alertDialog = fileExplorerActivity.S) == null) {
            return;
        }
        Window window = alertDialog.getWindow();
        if (window != null) {
            a4.x.y(window, 0);
        }
        AlertDialog alertDialog2 = fileExplorerActivity.S;
        alertDialog2.getClass();
        alertDialog2.show();
    }

    public static final void N(FileExplorerActivity fileExplorerActivity, Object obj, String str) {
        AlertDialog alertDialog = fileExplorerActivity.S;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        View inflate = fileExplorerActivity.getLayoutInflater().inflate(2131558487, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(2131363814);
        textView.setTypeface(c.f4883x);
        textView.setText(textView.getContext().getString(2131952082, str));
        TextView textView2 = (TextView) inflate.findViewById(2131363606);
        textView2.setText(fileExplorerActivity.getString(2131952428));
        textView2.setTypeface(c.f4882w);
        textView2.setOnClickListener(new e(29, obj, fileExplorerActivity));
        TextView textView3 = (TextView) inflate.findViewById(2131363700);
        textView3.setText(fileExplorerActivity.getString(2131952425));
        textView3.setTypeface(c.f4882w);
        textView3.setOnClickListener(new g(fileExplorerActivity, 14));
        AlertDialog.Builder builder = new AlertDialog.Builder(fileExplorerActivity);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        fileExplorerActivity.S = create;
        create.getClass();
        Window window = create.getWindow();
        if (window != null) {
            a4.x.y(window, 0);
        }
        AlertDialog alertDialog2 = fileExplorerActivity.S;
        alertDialog2.getClass();
        alertDialog2.show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
    
        if (o7.c0.C(r1, r8, r0) != r5) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
    
        if (o7.c0.C(r1, r8, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object O(com.uptodown.core.activities.FileExplorerActivity r7, v6.c r8) {
        /*
            boolean r0 = r8 instanceof g4.y
            if (r0 == 0) goto L13
            r0 = r8
            g4.y r0 = (g4.y) r0
            int r1 = r0.f5285l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5285l = r1
            goto L18
        L13:
            g4.y r0 = new g4.y
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f5283a
            int r1 = r0.f5285l
            r2 = 0
            r3 = 2
            r4 = 1
            u6.a r5 = u6.a.f10762a
            if (r1 == 0) goto L35
            if (r1 == r4) goto L31
            if (r1 != r3) goto L2b
            p6.a.e(r8)
            goto L5f
        L2b:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r7)
            return r2
        L31:
            p6.a.e(r8)
            goto L4b
        L35:
            p6.a.e(r8)
            v7.e r8 = o7.m0.f8288a
            v7.d r8 = v7.d.f10884a
            c4.ya r1 = new c4.ya
            r6 = 5
            r1.<init>(r7, r2, r6)
            r0.f5285l = r4
            java.lang.Object r8 = o7.c0.C(r1, r8, r0)
            if (r8 != r5) goto L4b
            goto L5e
        L4b:
            v7.e r8 = o7.m0.f8288a
            p7.c r8 = t7.n.f10348a
            g4.n r1 = new g4.n
            r4 = 15
            r1.<init>(r7, r2, r4)
            r0.f5285l = r3
            java.lang.Object r7 = o7.c0.C(r1, r8, r0)
            if (r7 != r5) goto L5f
        L5e:
            return r5
        L5f:
            p6.x r7 = p6.x.f8463a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.O(com.uptodown.core.activities.FileExplorerActivity, v6.c):java.lang.Object");
    }

    public static final void P(FileExplorerActivity fileExplorerActivity) {
        LinearLayout linearLayout = fileExplorerActivity.I;
        if (linearLayout == null) {
            l.i("llBreadcrumb");
            throw null;
        }
        if (linearLayout.getChildCount() > 1) {
            LinearLayout linearLayout2 = fileExplorerActivity.I;
            if (linearLayout2 != null) {
                linearLayout2.removeViewAt(linearLayout2.getChildCount() - 1);
            } else {
                l.i("llBreadcrumb");
                throw null;
            }
        }
    }

    public static final void Q(FileExplorerActivity fileExplorerActivity) {
        int i;
        Menu menu;
        MenuItem findItem;
        Menu menu2;
        MenuItem findItem2;
        Menu menu3;
        MenuItem findItem3;
        Menu menu4;
        MenuItem findItem4;
        Toolbar toolbar;
        Menu menu5;
        MenuItem findItem5;
        Menu menu6;
        MenuItem findItem6;
        Menu menu7;
        MenuItem findItem7;
        Menu menu8;
        MenuItem findItem8;
        Menu menu9;
        MenuItem findItem9;
        boolean[] zArr;
        Menu menu10;
        MenuItem findItem10;
        Menu menu11;
        MenuItem findItem11;
        Menu menu12;
        MenuItem findItem12;
        Menu menu13;
        MenuItem findItem13;
        Menu menu14;
        MenuItem findItem14;
        Toolbar toolbar2 = fileExplorerActivity.T;
        if (toolbar2 != null && (menu14 = toolbar2.getMenu()) != null && (findItem14 = menu14.findItem(2131361872)) != null) {
            findItem14.setVisible(true);
        }
        Toolbar toolbar3 = fileExplorerActivity.T;
        if (toolbar3 != null && (menu13 = toolbar3.getMenu()) != null && (findItem13 = menu13.findItem(2131361869)) != null) {
            findItem13.setVisible(true);
        }
        Toolbar toolbar4 = fileExplorerActivity.T;
        if (toolbar4 != null && (menu12 = toolbar4.getMenu()) != null && (findItem12 = menu12.findItem(2131361868)) != null) {
            findItem12.setVisible(true);
        }
        Toolbar toolbar5 = fileExplorerActivity.T;
        if (toolbar5 != null && (menu11 = toolbar5.getMenu()) != null && (findItem11 = menu11.findItem(2131361865)) != null) {
            findItem11.setVisible(true);
        }
        Toolbar toolbar6 = fileExplorerActivity.T;
        if (toolbar6 != null && (menu10 = toolbar6.getMenu()) != null && (findItem10 = menu10.findItem(2131361870)) != null) {
            findItem10.setVisible(true);
        }
        b bVar = fileExplorerActivity.V;
        if (bVar == null || (zArr = bVar.f5658d) == null) {
            i = 0;
        } else {
            i = 0;
            for (boolean z9 : zArr) {
                if (z9) {
                    i++;
                }
            }
        }
        Toolbar toolbar7 = fileExplorerActivity.T;
        if (i > 0) {
            if (toolbar7 != null && (menu9 = toolbar7.getMenu()) != null && (findItem9 = menu9.findItem(2131361872)) != null) {
                findItem9.setEnabled(true);
            }
            Toolbar toolbar8 = fileExplorerActivity.T;
            if (toolbar8 != null && (menu8 = toolbar8.getMenu()) != null && (findItem8 = menu8.findItem(2131361868)) != null) {
                findItem8.setEnabled(true);
            }
            Toolbar toolbar9 = fileExplorerActivity.T;
            if (toolbar9 != null && (menu7 = toolbar9.getMenu()) != null && (findItem7 = menu7.findItem(2131361870)) != null) {
                findItem7.setEnabled(true);
            }
            Toolbar toolbar10 = fileExplorerActivity.T;
            if (toolbar10 != null && (menu6 = toolbar10.getMenu()) != null && (findItem6 = menu6.findItem(2131361865)) != null) {
                findItem6.setEnabled(true);
            }
        } else {
            if (toolbar7 != null && (menu4 = toolbar7.getMenu()) != null && (findItem4 = menu4.findItem(2131361872)) != null) {
                findItem4.setEnabled(false);
            }
            Toolbar toolbar11 = fileExplorerActivity.T;
            if (toolbar11 != null && (menu3 = toolbar11.getMenu()) != null && (findItem3 = menu3.findItem(2131361868)) != null) {
                findItem3.setEnabled(false);
            }
            Toolbar toolbar12 = fileExplorerActivity.T;
            if (toolbar12 != null && (menu2 = toolbar12.getMenu()) != null && (findItem2 = menu2.findItem(2131361870)) != null) {
                findItem2.setEnabled(false);
            }
            Toolbar toolbar13 = fileExplorerActivity.T;
            if (toolbar13 != null && (menu = toolbar13.getMenu()) != null && (findItem = menu.findItem(2131361865)) != null) {
                findItem.setEnabled(false);
            }
        }
        TextView textView = fileExplorerActivity.U;
        if (textView != null) {
            textView.setText(fileExplorerActivity.getString(2131951883, String.valueOf(i)));
        }
        ArrayList arrayList = fileExplorerActivity.f3384f0;
        if (arrayList == null || arrayList.isEmpty() || (toolbar = fileExplorerActivity.T) == null || (menu5 = toolbar.getMenu()) == null || (findItem5 = menu5.findItem(2131361888)) == null) {
            return;
        }
        findItem5.setVisible(true);
    }

    public static final void R(FileExplorerActivity fileExplorerActivity) {
        b bVar = fileExplorerActivity.V;
        bVar.getClass();
        bVar.c(false);
        fileExplorerActivity.U();
        fileExplorerActivity.V(null);
    }

    @Override // g4.s0
    public final void F() {
        c.f4884y.getClass();
    }

    public final void S(String str, String str2) {
        if (isFinishing()) {
            return;
        }
        RelativeLayout relativeLayout = this.G;
        t6.c cVar = null;
        if (relativeLayout == null) {
            l.i("rlLoading");
            throw null;
        }
        relativeLayout.setVisibility(0);
        v7.e eVar = m0.f8288a;
        c0.s(c0.b(v7.d.f10884a), null, null, new g4.m(this, str, str2, cVar, 1), 3);
    }

    public final void T(SearchView searchView) {
        searchView.setOnQueryTextListener(null);
        searchView.setQuery("", false);
        searchView.setOnQueryTextListener(this.n0);
        Object systemService = getSystemService("input_method");
        systemService.getClass();
        ((InputMethodManager) systemService).hideSoftInputFromWindow(searchView.getWindowToken(), 0);
    }

    public final void U() {
        Menu menu;
        MenuItem findItem;
        Menu menu2;
        MenuItem findItem2;
        Menu menu3;
        MenuItem findItem3;
        Menu menu4;
        MenuItem findItem4;
        Menu menu5;
        MenuItem findItem5;
        Menu menu6;
        MenuItem findItem6;
        TextView textView = this.U;
        if (textView != null) {
            textView.setText(getString(2131951654));
        }
        Toolbar toolbar = this.T;
        if (toolbar != null && (menu6 = toolbar.getMenu()) != null && (findItem6 = menu6.findItem(2131361869)) != null) {
            findItem6.setVisible(true);
        }
        Toolbar toolbar2 = this.T;
        if (toolbar2 != null && (menu5 = toolbar2.getMenu()) != null && (findItem5 = menu5.findItem(2131361872)) != null) {
            findItem5.setVisible(false);
        }
        Toolbar toolbar3 = this.T;
        if (toolbar3 != null && (menu4 = toolbar3.getMenu()) != null && (findItem4 = menu4.findItem(2131361868)) != null) {
            findItem4.setVisible(false);
        }
        Toolbar toolbar4 = this.T;
        if (toolbar4 != null && (menu3 = toolbar4.getMenu()) != null && (findItem3 = menu3.findItem(2131361865)) != null) {
            findItem3.setVisible(false);
        }
        Toolbar toolbar5 = this.T;
        if (toolbar5 != null && (menu2 = toolbar5.getMenu()) != null && (findItem2 = menu2.findItem(2131361870)) != null) {
            findItem2.setVisible(false);
        }
        Toolbar toolbar6 = this.T;
        if (toolbar6 == null || (menu = toolbar6.getMenu()) == null || (findItem = menu.findItem(2131361888)) == null) {
            return;
        }
        findItem.setVisible(false);
    }

    public final void V(String str) {
        File externalStorageDirectory;
        RelativeLayout relativeLayout = this.G;
        if (relativeLayout == null) {
            l.i("rlLoading");
            throw null;
        }
        relativeLayout.setVisibility(0);
        if (this.Y == null && this.f3381c0 == null && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.f3381c0 = externalStorageDirectory;
            this.Y = null;
        }
        new s(this.Y, this.f3381c0, this, new android.support.v4.media.g(13, this, str));
    }

    public final void W(boolean z9) {
        SearchView searchView;
        if (z9 && (searchView = this.N) != null) {
            T(searchView);
        }
        V(null);
    }

    public final void X() {
        v7.e eVar = m0.f8288a;
        c0.s(c0.b(v7.d.f10884a), null, null, new o(this, (t6.c) null, 4), 3);
    }

    public final void Y() {
        LinearLayout linearLayout = this.I;
        if (linearLayout == null) {
            l.i("llBreadcrumb");
            throw null;
        }
        linearLayout.removeAllViews();
        LayoutInflater layoutInflater = getLayoutInflater();
        LinearLayout linearLayout2 = this.I;
        if (linearLayout2 == null) {
            l.i("llBreadcrumb");
            throw null;
        }
        View inflate = layoutInflater.inflate(2131558447, (ViewGroup) linearLayout2, false);
        inflate.getClass();
        LinearLayout linearLayout3 = (LinearLayout) inflate;
        TextView textView = (TextView) linearLayout3.findViewById(2131363983);
        if (this.f3383e0) {
            textView.setText(getString(2131952558));
        } else {
            textView.setText(getString(2131952099));
        }
        textView.setTypeface(c.f4883x);
        LinearLayout linearLayout4 = this.I;
        if (linearLayout4 != null) {
            linearLayout4.addView(linearLayout3);
        } else {
            l.i("llBreadcrumb");
            throw null;
        }
    }

    public final void Z() {
        boolean z9 = this.f3382d0;
        RadioButton radioButton = this.P;
        if (z9) {
            radioButton.getClass();
            radioButton.setBackground(ContextCompat.getDrawable(this, 2131230956));
            RadioButton radioButton2 = this.Q;
            radioButton2.getClass();
            radioButton2.setBackground(ContextCompat.getDrawable(this, 2131230963));
            RadioButton radioButton3 = this.R;
            radioButton3.getClass();
            radioButton3.setBackground(ContextCompat.getDrawable(this, 2131230959));
            return;
        }
        radioButton.getClass();
        radioButton.setBackground(ContextCompat.getDrawable(this, 2131230954));
        RadioButton radioButton4 = this.Q;
        radioButton4.getClass();
        radioButton4.setBackground(ContextCompat.getDrawable(this, 2131230961));
        RadioButton radioButton5 = this.R;
        radioButton5.getClass();
        radioButton5.setBackground(ContextCompat.getDrawable(this, 2131230957));
    }

    public final void a0(boolean z9) {
        TextView textView = this.K;
        if (z9) {
            if (textView == null) {
                l.i("tvEmptyDirectory");
                throw null;
            }
            textView.setText(getString(2131951983));
        } else {
            if (textView == null) {
                l.i("tvEmptyDirectory");
                throw null;
            }
            textView.setText(getString(2131952386));
        }
        TextView textView2 = this.K;
        if (textView2 != null) {
            textView2.setVisibility(0);
        } else {
            l.i("tvEmptyDirectory");
            throw null;
        }
    }

    public final void b0(Uri uri) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(uri, getContentResolver().getType(uri));
        intent.addFlags(1);
        startActivity(Intent.createChooser(intent, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x030c  */
    @Override // g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r9) {
        /*
            Method dump skipped, instructions count: 1145
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.onCreate(android.os.Bundle):void");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        keyEvent.getClass();
        if (i != 82) {
            return super.onKeyDown(i, keyEvent);
        }
        Toolbar toolbar = this.T;
        toolbar.getClass();
        toolbar.showOverflowMenu();
        return true;
    }

    @Override // g4.h
    public final void p() {
        i(getString(2131952278));
    }

    @Override // g4.h
    public final void q() {
        Uri uri;
        boolean z9;
        List<UriPermission> persistedUriPermissions = getContentResolver().getPersistedUriPermissions();
        persistedUriPermissions.getClass();
        Iterator<UriPermission> it = persistedUriPermissions.iterator();
        while (true) {
            if (!it.hasNext()) {
                uri = null;
                break;
            }
            UriPermission next = it.next();
            Uri uri2 = next.getUri();
            uri2.getClass();
            String path = uri2.getPath();
            if (path != null) {
                Pattern compile = Pattern.compile(".*\\b[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]-[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]:.*");
                compile.getClass();
                z9 = compile.matcher(path).matches();
            } else {
                z9 = false;
            }
            if (z9) {
                uri = next.getUri();
                break;
            }
        }
        if (uri != null) {
            LinearLayout linearLayout = this.H;
            if (linearLayout == null) {
                l.i("llPermissionExplanation");
                throw null;
            }
            linearLayout.setVisibility(8);
            RecyclerView recyclerView = this.F;
            if (recyclerView == null) {
                l.i("rvFiles");
                throw null;
            }
            recyclerView.setVisibility(0);
            this.Y = DocumentFile.fromTreeUri(this, uri);
            this.f3381c0 = null;
            W(true);
        }
    }

    @Override // g4.h
    public final void r() {
        i(getString(2131951866));
    }

    @Override // g4.h
    public final void s() {
        i(getString(2131952278));
    }

    @Override // g4.h
    public final void u() {
        W(true);
        if (k()) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 645);
    }
}
