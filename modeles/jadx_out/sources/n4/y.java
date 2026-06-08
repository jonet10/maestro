package n4;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import o7.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public File f8049a;

    /* renamed from: b, reason: collision with root package name */
    public ZipInputStream f8050b;

    /* renamed from: l, reason: collision with root package name */
    public ZipEntry f8051l;

    /* renamed from: m, reason: collision with root package name */
    public kotlin.jvm.internal.v f8052m;

    /* renamed from: n, reason: collision with root package name */
    public kotlin.jvm.internal.w f8053n;

    /* renamed from: o, reason: collision with root package name */
    public FileOutputStream f8054o;

    /* renamed from: p, reason: collision with root package name */
    public kotlin.jvm.internal.v f8055p;

    /* renamed from: q, reason: collision with root package name */
    public long f8056q;

    /* renamed from: r, reason: collision with root package name */
    public int f8057r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ String f8058s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ Context f8059t;

    /* renamed from: u, reason: collision with root package name */
    public final /* synthetic */ DocumentFile f8060u;
    public final /* synthetic */ a2.n v;

    /* renamed from: w, reason: collision with root package name */
    public final /* synthetic */ g4.v f8061w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(String str, Context context, DocumentFile documentFile, a2.n nVar, g4.v vVar, t6.c cVar) {
        super(2, cVar);
        this.f8058s = str;
        this.f8059t = context;
        this.f8060u = documentFile;
        this.v = nVar;
        this.f8061w = vVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new y(this.f8058s, this.f8059t, this.f8060u, this.v, this.f8061w, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((y) create((a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0138  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0113 -> B:13:0x0118). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0116 -> B:13:0x0118). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00a3 -> B:23:0x012a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00b8 -> B:14:0x00d0). Please report as a decompilation issue!!! */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.y.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
