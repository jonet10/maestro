package g4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import b2.t1;
import com.google.android.gms.internal.measurement.i5;
import com.uptodown.core.activities.FileExplorerActivity;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5274a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f5275b;

    /* renamed from: l, reason: collision with root package name */
    public final Object f5276l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f5277m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f5278n;

    /* renamed from: o, reason: collision with root package name */
    public final Object f5279o;

    /* renamed from: p, reason: collision with root package name */
    public Object f5280p;

    public v(String str, Set set, String str2) {
        this.f5274a = 1;
        Set unmodifiableSet = set == null ? Collections.EMPTY_SET : DesugarCollections.unmodifiableSet(set);
        this.f5275b = unmodifiableSet;
        Map map = Collections.EMPTY_MAP;
        this.f5277m = str;
        this.f5278n = str2;
        this.f5279o = g1.a.f5105a;
        HashSet hashSet = new HashSet(unmodifiableSet);
        Iterator it = map.values().iterator();
        if (!it.hasNext()) {
            this.f5276l = DesugarCollections.unmodifiableSet(hashSet);
        } else {
            it.next().getClass();
            com.google.gson.internal.a.o();
            throw null;
        }
    }

    public static v a(View view) {
        int i = 2131362706;
        if (((LinearLayout) ViewBindings.findChildViewById(view, 2131362706)) != null) {
            i = 2131362998;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, 2131362998);
            if (progressBar != null) {
                i = 2131363003;
                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, 2131363003);
                if (progressBar2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    i = 2131364091;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, 2131364091);
                    if (textView != null) {
                        i = 2131364095;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, 2131364095);
                        if (textView2 != null) {
                            i = 2131364096;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, 2131364096);
                            if (textView3 != null) {
                                return new v(relativeLayout, progressBar, progressBar2, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static v e(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(2131558524, (ViewGroup) null, false);
        int i = 2131362326;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362326);
        if (imageView != null) {
            i = 2131363696;
            TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363696);
            if (textView != null) {
                i = 2131363789;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363789);
                if (textView2 != null) {
                    i = 2131364115;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364115);
                    if (textView3 != null) {
                        i = 2131364387;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131364387);
                        if (textView4 != null) {
                            return new v((RelativeLayout) inflate, imageView, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
        return null;
    }

    public static v f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(2131558568, viewGroup, false);
        int i = 2131362369;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362369);
        if (imageView != null) {
            i = 2131362425;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362425);
            if (imageView2 != null) {
                i = 2131362716;
                if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362716)) != null) {
                    i = 2131363014;
                    if (((ProgressBar) ViewBindings.findChildViewById(inflate, 2131363014)) != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) inflate;
                        i = 2131363224;
                        if (((RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363224)) != null) {
                            i = 2131363772;
                            TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363772);
                            if (textView != null) {
                                i = 2131363773;
                                if (((TextView) ViewBindings.findChildViewById(inflate, 2131363773)) != null) {
                                    i = 2131364046;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364046);
                                    if (textView2 != null) {
                                        i = 2131364047;
                                        if (((TextView) ViewBindings.findChildViewById(inflate, 2131364047)) != null) {
                                            i = 2131364195;
                                            if (((TextView) ViewBindings.findChildViewById(inflate, 2131364195)) != null) {
                                                i = 2131364336;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364336);
                                                if (textView3 != null) {
                                                    i = 2131364552;
                                                    if (((TextView) ViewBindings.findChildViewById(inflate, 2131364552)) != null) {
                                                        return new v(relativeLayout, imageView, imageView2, textView, textView2, textView3, 4);
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
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
        return null;
    }

    public static v g(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(2131558528, (ViewGroup) null, false);
        int i = 2131363688;
        TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363688);
        if (textView != null) {
            i = 2131363997;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363997);
            if (textView2 != null) {
                i = 2131364010;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364010);
                if (textView3 != null) {
                    i = 2131364110;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131364110);
                    if (textView4 != null) {
                        i = 2131364363;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(inflate, 2131364363);
                        if (textView5 != null) {
                            return new v((LinearLayout) inflate, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
        return null;
    }

    public void b(int i) {
        TextView textView = (TextView) this.f5275b;
        FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) this.f5278n;
        textView.setText(fileExplorerActivity.getString(2131951857, String.valueOf(i)));
        ProgressBar progressBar = (ProgressBar) this.f5280p;
        progressBar.setIndeterminate(false);
        progressBar.setProgress(100);
        ((TextView) this.f5277m).setText(fileExplorerActivity.getString(2131951793));
    }

    public void c() {
        ProgressBar progressBar = (ProgressBar) this.f5280p;
        TextView textView = (TextView) this.f5275b;
        FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) this.f5278n;
        textView.setText(fileExplorerActivity.getString(2131951859));
        ((RadioGroup) ((View) this.f5279o).findViewById(2131363092)).setVisibility(8);
        TextView textView2 = fileExplorerActivity.L;
        if (textView2 == null) {
            kotlin.jvm.internal.l.i("tvSelectedPath");
            throw null;
        }
        textView2.setVisibility(8);
        progressBar.setVisibility(0);
        progressBar.setIndeterminate(true);
        ((TextView) this.f5276l).setVisibility(8);
    }

    public j1.p d(j1.p pVar) {
        return pVar.d(new androidx.arch.core.executor.a(2), new s1.o(this, 29));
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        switch (this.f5274a) {
        }
        return (RelativeLayout) this.f5278n;
    }

    public void h() {
        TextView textView = (TextView) this.f5275b;
        FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) this.f5278n;
        textView.setText(fileExplorerActivity.getString(2131951860));
        ProgressBar progressBar = (ProgressBar) this.f5280p;
        progressBar.setIndeterminate(false);
        progressBar.setProgress(0);
        ((TextView) this.f5277m).setText(fileExplorerActivity.getString(2131951793));
    }

    public void i(long j) {
        TextView textView = (TextView) this.f5275b;
        FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) this.f5278n;
        textView.setText(fileExplorerActivity.getString(2131951859) + " " + i5.H(fileExplorerActivity, j));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00f1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j(java.lang.String r2, java.lang.String r3, android.os.Bundle r4) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.v.j(java.lang.String, java.lang.String, android.os.Bundle):void");
    }

    public j1.p k(String str, String str2, Bundle bundle) {
        int i;
        try {
            j(str, str2, bundle);
            g0.b bVar = (g0.b) this.f5277m;
            g0.h hVar = g0.h.f5081l;
            g0.o oVar = bVar.f5070c;
            if (oVar.a() < 12000000) {
                return oVar.b() != 0 ? bVar.a(bundle).e(hVar, new android.support.v4.media.g(11, bVar, bundle)) : t1.w(new IOException("MISSING_INSTANCEID_SERVICE"));
            }
            g0.n a8 = g0.n.a(bVar.f5069b);
            synchronized (a8) {
                i = a8.f5101d;
                a8.f5101d = i + 1;
            }
            return a8.b(new g0.l(i, 1, bundle, 1)).d(hVar, g0.d.f5074b);
        } catch (InterruptedException | ExecutionException e10) {
            return t1.w(e10);
        }
    }

    public /* synthetic */ v(RelativeLayout relativeLayout, Object obj, View view, TextView textView, TextView textView2, TextView textView3, int i) {
        this.f5274a = i;
        this.f5278n = relativeLayout;
        this.f5279o = obj;
        this.f5280p = view;
        this.f5275b = textView;
        this.f5276l = textView2;
        this.f5277m = textView3;
    }

    public v(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f5274a = 3;
        this.f5278n = linearLayout;
        this.f5275b = textView;
        this.f5276l = textView2;
        this.f5277m = textView3;
        this.f5279o = textView4;
        this.f5280p = textView5;
    }

    public v(RelativeLayout relativeLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f5274a = 2;
        this.f5278n = relativeLayout;
        this.f5279o = imageView;
        this.f5275b = textView;
        this.f5276l = textView2;
        this.f5277m = textView3;
        this.f5280p = textView4;
    }

    public v(RelativeLayout relativeLayout, ProgressBar progressBar, ProgressBar progressBar2, TextView textView, TextView textView2, TextView textView3) {
        this.f5274a = 7;
        this.f5278n = relativeLayout;
        this.f5280p = progressBar;
        this.f5279o = progressBar2;
        this.f5275b = textView;
        this.f5276l = textView2;
        this.f5277m = textView3;
    }

    public v(n1.f fVar, s4.s sVar, s2.b bVar, s2.b bVar2, t2.d dVar) {
        this.f5274a = 8;
        fVar.a();
        g0.b bVar3 = new g0.b(fVar.f7908a);
        this.f5275b = fVar;
        this.f5276l = sVar;
        this.f5277m = bVar3;
        this.f5278n = bVar;
        this.f5279o = bVar2;
        this.f5280p = dVar;
    }

    public v(TextView textView, FileExplorerActivity fileExplorerActivity, View view, ProgressBar progressBar, TextView textView2, TextView textView3) {
        this.f5274a = 0;
        this.f5275b = textView;
        this.f5278n = fileExplorerActivity;
        this.f5279o = view;
        this.f5280p = progressBar;
        this.f5276l = textView2;
        this.f5277m = textView3;
    }
}
