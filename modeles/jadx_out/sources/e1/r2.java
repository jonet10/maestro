package e1;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4232a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4233b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f4234l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f4235m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f4236n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f4237o;

    public r2(b3 b3Var, AtomicReference atomicReference, String str, String str2, boolean z9) {
        this.f4236n = atomicReference;
        this.f4233b = str;
        this.f4234l = str2;
        this.f4235m = z9;
        Objects.requireNonNull(b3Var);
        this.f4237o = b3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0105 A[Catch: RuntimeException -> 0x00df, TRY_ENTER, TryCatch #2 {RuntimeException -> 0x00df, blocks: (B:34:0x0105, B:36:0x0110, B:39:0x011d, B:41:0x0123, B:42:0x013d, B:43:0x0146, B:47:0x014e, B:50:0x0167, B:51:0x0176, B:53:0x016e, B:54:0x0189, B:56:0x018f, B:58:0x0195, B:60:0x019b, B:62:0x01a1, B:64:0x01a9, B:66:0x01b1, B:68:0x01b7, B:71:0x01c9, B:76:0x0090, B:78:0x0096, B:80:0x00a0, B:82:0x00a6, B:84:0x00ac, B:86:0x00b2, B:88:0x00ba, B:90:0x00c2, B:92:0x00ca, B:94:0x00d2, B:95:0x00e6, B:97:0x00f4), top: B:75:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x014e A[Catch: RuntimeException -> 0x00df, TryCatch #2 {RuntimeException -> 0x00df, blocks: (B:34:0x0105, B:36:0x0110, B:39:0x011d, B:41:0x0123, B:42:0x013d, B:43:0x0146, B:47:0x014e, B:50:0x0167, B:51:0x0176, B:53:0x016e, B:54:0x0189, B:56:0x018f, B:58:0x0195, B:60:0x019b, B:62:0x01a1, B:64:0x01a9, B:66:0x01b1, B:68:0x01b7, B:71:0x01c9, B:76:0x0090, B:78:0x0096, B:80:0x00a0, B:82:0x00a6, B:84:0x00ac, B:86:0x00b2, B:88:0x00ba, B:90:0x00c2, B:92:0x00ca, B:94:0x00d2, B:95:0x00e6, B:97:0x00f4), top: B:75:0x0090 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 598
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.r2.run():void");
    }

    public r2(x2 x2Var, boolean z9, Uri uri, String str, String str2) {
        this.f4235m = z9;
        this.f4236n = uri;
        this.f4233b = str;
        this.f4234l = str2;
        this.f4237o = x2Var;
    }

    public r2(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.m0 m0Var, String str, String str2, boolean z9) {
        this.f4236n = m0Var;
        this.f4233b = str;
        this.f4234l = str2;
        this.f4235m = z9;
        this.f4237o = appMeasurementDynamiteService;
    }

    public r2(w3 w3Var, c5 c5Var, boolean z9, t tVar, Bundle bundle) {
        this.f4236n = c5Var;
        this.f4235m = z9;
        this.f4233b = tVar;
        this.f4234l = bundle;
        Objects.requireNonNull(w3Var);
        this.f4237o = w3Var;
    }
}
