package e1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g1 extends e2 {
    public static final Pair I = new Pair("", 0L);
    public boolean A;
    public final d1 B;
    public final d1 C;
    public final e1 D;
    public final a2.t E;
    public final a2.t F;
    public final e1 G;
    public final y2.s H;

    /* renamed from: l, reason: collision with root package name */
    public SharedPreferences f3981l;

    /* renamed from: m, reason: collision with root package name */
    public SharedPreferences f3982m;

    /* renamed from: n, reason: collision with root package name */
    public f1 f3983n;

    /* renamed from: o, reason: collision with root package name */
    public final e1 f3984o;

    /* renamed from: p, reason: collision with root package name */
    public final a2.t f3985p;

    /* renamed from: q, reason: collision with root package name */
    public String f3986q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3987r;

    /* renamed from: s, reason: collision with root package name */
    public long f3988s;

    /* renamed from: t, reason: collision with root package name */
    public final e1 f3989t;

    /* renamed from: u, reason: collision with root package name */
    public final d1 f3990u;
    public final a2.t v;

    /* renamed from: w, reason: collision with root package name */
    public final y2.s f3991w;

    /* renamed from: x, reason: collision with root package name */
    public final d1 f3992x;

    /* renamed from: y, reason: collision with root package name */
    public final e1 f3993y;

    /* renamed from: z, reason: collision with root package name */
    public final e1 f3994z;

    public g1(t1 t1Var) {
        super(t1Var);
        this.f3989t = new e1(this, "session_timeout", 1800000L);
        this.f3990u = new d1(this, "start_new_session", true);
        this.f3993y = new e1(this, "last_pause_time", 0L);
        this.f3994z = new e1(this, "session_id", 0L);
        this.v = new a2.t(this, "non_personalized_ads");
        this.f3991w = new y2.s(this, "last_received_uri_timestamps_by_source");
        this.f3992x = new d1(this, "allow_remote_dynamite", false);
        this.f3984o = new e1(this, "first_open_time", 0L);
        k0.y.d("app_install_time");
        this.f3985p = new a2.t(this, "app_instance_id");
        this.B = new d1(this, "app_backgrounded", false);
        this.C = new d1(this, "deep_link_retrieval_complete", false);
        this.D = new e1(this, "deep_link_retrieval_attempts", 0L);
        this.E = new a2.t(this, "firebase_feature_rollouts");
        this.F = new a2.t(this, "deferred_attribution_cache");
        this.G = new e1(this, "deferred_attribution_cache_timestamp", 0L);
        this.H = new y2.s(this, "default_event_parameters");
    }

    @Override // e1.e2
    public final boolean h() {
        return true;
    }

    public final SharedPreferences k() {
        g();
        i();
        k0.y.g(this.f3981l);
        return this.f3981l;
    }

    public final SharedPreferences l() {
        g();
        i();
        if (this.f3982m == null) {
            t1 t1Var = this.f3875a;
            String valueOf = String.valueOf(t1Var.f4259a.getPackageName());
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            u0 u0Var = w0Var.f4346w;
            String concat = valueOf.concat("_preferences");
            u0Var.c(concat, "Default prefs file");
            this.f3982m = t1Var.f4259a.getSharedPreferences(concat, 0);
        }
        return this.f3982m;
    }

    public final SparseArray m() {
        Bundle G = this.f3991w.G();
        int[] intArray = G.getIntArray("uriSources");
        long[] longArray = G.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray();
        }
        if (intArray.length != longArray.length) {
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.b("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray();
        }
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < intArray.length; i++) {
            sparseArray.put(intArray[i], Long.valueOf(longArray[i]));
        }
        return sparseArray;
    }

    public final j2 n() {
        g();
        return j2.c(k().getInt("consent_source", 100), k().getString("consent_settings", "G1"));
    }

    public final boolean o(g4 g4Var) {
        g();
        String string = k().getString("stored_tcf_param", "");
        String a8 = g4Var.a();
        if (a8.equals(string)) {
            return false;
        }
        SharedPreferences.Editor edit = k().edit();
        edit.putString("stored_tcf_param", a8);
        edit.apply();
        return true;
    }

    public final void p(boolean z9) {
        g();
        w0 w0Var = this.f3875a.f4264o;
        t1.m(w0Var);
        w0Var.f4346w.c(Boolean.valueOf(z9), "App measurement setting deferred collection");
        SharedPreferences.Editor edit = k().edit();
        edit.putBoolean("deferred_analytics_collection", z9);
        edit.apply();
    }

    public final boolean q(long j) {
        return j - this.f3989t.a() > this.f3993y.a();
    }
}
