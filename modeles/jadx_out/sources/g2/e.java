package g2;

import a4.x;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import c.j;
import e1.c0;
import f0.i;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
import y1.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5117a;

    /* renamed from: b, reason: collision with root package name */
    public Object f5118b;

    /* renamed from: l, reason: collision with root package name */
    public Object f5119l;

    /* renamed from: m, reason: collision with root package name */
    public Object f5120m;

    /* renamed from: n, reason: collision with root package name */
    public Object f5121n;

    /* renamed from: o, reason: collision with root package name */
    public Object f5122o;

    /* renamed from: p, reason: collision with root package name */
    public Object f5123p;

    /* renamed from: q, reason: collision with root package name */
    public Object f5124q;

    /* renamed from: r, reason: collision with root package name */
    public Object f5125r;

    /* renamed from: s, reason: collision with root package name */
    public Object f5126s;

    public e(Context context, f fVar, q1.a aVar, i iVar, i iVar2, a aVar2, t tVar) {
        this.f5117a = 0;
        AtomicReference atomicReference = new AtomicReference();
        this.f5125r = atomicReference;
        this.f5126s = new AtomicReference(new j1.i());
        this.f5118b = context;
        this.f5119l = fVar;
        this.f5121n = aVar;
        this.f5120m = iVar;
        this.f5122o = iVar2;
        this.f5123p = aVar2;
        this.f5124q = tVar;
        atomicReference.set(c0.j(aVar));
    }

    public static e c(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(2131558550, (ViewGroup) null, false);
        int i = 2131362377;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362377);
        if (imageView != null) {
            i = 2131362486;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362486);
            if (imageView2 != null) {
                i = 2131362492;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362492);
                if (imageView3 != null) {
                    i = 2131362498;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362498);
                    if (imageView4 != null) {
                        i = 2131362504;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362504);
                        if (imageView5 != null) {
                            i = 2131362510;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362510);
                            if (imageView6 != null) {
                                i = 2131362744;
                                if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362744)) != null) {
                                    i = 2131363642;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363642);
                                    if (textView != null) {
                                        i = 2131363681;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363681);
                                        if (textView2 != null) {
                                            return new e((RelativeLayout) inflate, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, textView, textView2, 3);
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

    public static void d(JSONObject jSONObject, String str) {
        StringBuilder t9 = x.t(str);
        t9.append(jSONObject.toString());
        String sb = t9.toString();
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", sb, null);
        }
    }

    public d a(int i) {
        d dVar = null;
        try {
            if (!j.a(2, i)) {
                JSONObject m10 = ((i) this.f5122o).m();
                if (m10 != null) {
                    d k5 = ((i) this.f5120m).k(m10);
                    d(m10, "Loaded cached settings: ");
                    ((q1.a) this.f5121n).getClass();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (j.a(3, i) || k5.f5114c >= currentTimeMillis) {
                        try {
                            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                                Log.v("FirebaseCrashlytics", "Returning cached settings.", null);
                            }
                            return k5;
                        } catch (Exception e10) {
                            e = e10;
                            dVar = k5;
                            Log.e("FirebaseCrashlytics", "Failed to get cached settings", e);
                            return dVar;
                        }
                    }
                    if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                        Log.v("FirebaseCrashlytics", "Cached settings have expired.", null);
                        return null;
                    }
                } else if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", "No cached settings data found.", null);
                }
            }
            return null;
        } catch (Exception e11) {
            e = e11;
        }
    }

    public d b() {
        return (d) ((AtomicReference) this.f5125r).get();
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        switch (this.f5117a) {
        }
        return (RelativeLayout) this.f5118b;
    }

    public /* synthetic */ e(RelativeLayout relativeLayout, View view, ImageView imageView, ImageView imageView2, View view2, View view3, View view4, TextView textView, TextView textView2, int i) {
        this.f5117a = i;
        this.f5118b = relativeLayout;
        this.f5119l = view;
        this.f5120m = imageView;
        this.f5121n = imageView2;
        this.f5122o = view2;
        this.f5123p = view3;
        this.f5124q = view4;
        this.f5125r = textView;
        this.f5126s = textView2;
    }
}
