package n4;

import android.content.Context;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import java.io.File;
import java.io.Serializable;
import java.util.zip.ZipInputStream;
import o7.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8023a = 1;

    /* renamed from: b, reason: collision with root package name */
    public ZipInputStream f8024b;

    /* renamed from: l, reason: collision with root package name */
    public kotlin.jvm.internal.v f8025l;

    /* renamed from: m, reason: collision with root package name */
    public kotlin.jvm.internal.w f8026m;

    /* renamed from: n, reason: collision with root package name */
    public kotlin.jvm.internal.v f8027n;

    /* renamed from: o, reason: collision with root package name */
    public long f8028o;

    /* renamed from: p, reason: collision with root package name */
    public int f8029p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ g4.v f8030q;

    /* renamed from: r, reason: collision with root package name */
    public Serializable f8031r;

    /* renamed from: s, reason: collision with root package name */
    public Object f8032s;

    /* renamed from: t, reason: collision with root package name */
    public Cloneable f8033t;

    /* renamed from: u, reason: collision with root package name */
    public Object f8034u;
    public final /* synthetic */ Object v;

    /* renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f8035w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Context context, DocumentFile documentFile, Uri uri, g4.v vVar, t6.c cVar) {
        super(2, cVar);
        this.f8034u = context;
        this.v = documentFile;
        this.f8035w = uri;
        this.f8030q = vVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f8023a) {
            case 0:
                return new w((String) this.v, (File) this.f8032s, (a2.n) this.f8035w, this.f8030q, cVar);
            default:
                return new w((Context) this.f8034u, (DocumentFile) this.v, (Uri) this.f8035w, this.f8030q, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f8023a) {
        }
        return ((w) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x0365, code lost:
    
        if (o7.c0.C(r3, r0, r26) == r8) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x00a2, code lost:
    
        if (o7.c0.C(r4, r3, r26) == r8) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x04df, code lost:
    
        if (o7.c0.C(r5, r0, r26) == r8) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0331, code lost:
    
        r2 = r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0465 A[Catch: all -> 0x0387, IOException -> 0x04ee, EOFException -> 0x04f2, TryCatch #5 {all -> 0x0387, blocks: (B:155:0x0382, B:196:0x04ee, B:194:0x04f2, B:166:0x04a9, B:167:0x045d, B:169:0x0465, B:171:0x047a, B:178:0x04b0, B:179:0x04b5, B:181:0x0421, B:183:0x0438, B:184:0x043f, B:186:0x0445, B:188:0x044b, B:189:0x044e, B:190:0x04bf, B:205:0x041a), top: B:146:0x0375 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04b0 A[Catch: all -> 0x0387, IOException -> 0x04ee, EOFException -> 0x04f2, TryCatch #5 {all -> 0x0387, blocks: (B:155:0x0382, B:196:0x04ee, B:194:0x04f2, B:166:0x04a9, B:167:0x045d, B:169:0x0465, B:171:0x047a, B:178:0x04b0, B:179:0x04b5, B:181:0x0421, B:183:0x0438, B:184:0x043f, B:186:0x0445, B:188:0x044b, B:189:0x044e, B:190:0x04bf, B:205:0x041a), top: B:146:0x0375 }] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0421 A[Catch: all -> 0x0387, IOException -> 0x04ee, EOFException -> 0x04f2, TryCatch #5 {all -> 0x0387, blocks: (B:155:0x0382, B:196:0x04ee, B:194:0x04f2, B:166:0x04a9, B:167:0x045d, B:169:0x0465, B:171:0x047a, B:178:0x04b0, B:179:0x04b5, B:181:0x0421, B:183:0x0438, B:184:0x043f, B:186:0x0445, B:188:0x044b, B:189:0x044e, B:190:0x04bf, B:205:0x041a), top: B:146:0x0375 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x04bf A[Catch: all -> 0x0387, IOException -> 0x04ee, EOFException -> 0x04f2, TRY_LEAVE, TryCatch #5 {all -> 0x0387, blocks: (B:155:0x0382, B:196:0x04ee, B:194:0x04f2, B:166:0x04a9, B:167:0x045d, B:169:0x0465, B:171:0x047a, B:178:0x04b0, B:179:0x04b5, B:181:0x0421, B:183:0x0438, B:184:0x043f, B:186:0x0445, B:188:0x044b, B:189:0x044e, B:190:0x04bf, B:205:0x041a), top: B:146:0x0375 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02bf  */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v22, types: [byte[], java.lang.Cloneable] */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r7v23, types: [java.io.InputStream, java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:158:0x04a3 -> B:148:0x04a4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:159:0x04a6 -> B:149:0x04a9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:165:0x0438 -> B:161:0x04b5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:171:0x044e -> B:150:0x045d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0317 -> B:16:0x0319). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x031c -> B:17:0x031f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x02bf -> B:18:0x02d0). Please report as a decompilation issue!!! */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) {
        /*
            Method dump skipped, instructions count: 1284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.w.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(String str, File file, a2.n nVar, g4.v vVar, t6.c cVar) {
        super(2, cVar);
        this.v = str;
        this.f8032s = file;
        this.f8035w = nVar;
        this.f8030q = vVar;
    }
}
