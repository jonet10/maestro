package n4;

import e1.c0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import o7.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q extends v6.i implements d7.p {
    public long A;
    public long B;
    public int C;
    public final /* synthetic */ File D;
    public final /* synthetic */ c0 E;
    public final /* synthetic */ File F;
    public final /* synthetic */ k4.c G;

    /* renamed from: a, reason: collision with root package name */
    public kotlin.jvm.internal.u f7991a;

    /* renamed from: b, reason: collision with root package name */
    public kotlin.jvm.internal.u f7992b;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f7993l;

    /* renamed from: m, reason: collision with root package name */
    public ZipFile f7994m;

    /* renamed from: n, reason: collision with root package name */
    public InputStream f7995n;

    /* renamed from: o, reason: collision with root package name */
    public Enumeration f7996o;

    /* renamed from: p, reason: collision with root package name */
    public ZipEntry f7997p;

    /* renamed from: q, reason: collision with root package name */
    public String f7998q;

    /* renamed from: r, reason: collision with root package name */
    public kotlin.jvm.internal.x f7999r;

    /* renamed from: s, reason: collision with root package name */
    public FileOutputStream f8000s;

    /* renamed from: t, reason: collision with root package name */
    public kotlin.jvm.internal.v f8001t;

    /* renamed from: u, reason: collision with root package name */
    public byte[] f8002u;
    public int v;

    /* renamed from: w, reason: collision with root package name */
    public int f8003w;

    /* renamed from: x, reason: collision with root package name */
    public int f8004x;

    /* renamed from: y, reason: collision with root package name */
    public long f8005y;

    /* renamed from: z, reason: collision with root package name */
    public long f8006z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(File file, c0 c0Var, File file2, k4.c cVar, t6.c cVar2) {
        super(2, cVar2);
        this.D = file;
        this.E = c0Var;
        this.F = file2;
        this.G = cVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new q(this.D, this.E, this.F, this.G, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((q) create((a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:197|198|199|200|201|202|204|205|206|207|208|(11:210|211|212|213|214|215|216|217|218|219|(1:222)(1:221))(1:228)) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:344|(6:326|327|(4:330|331|332|328)|335|336|337)|(3:75|76|77)|(3:104|105|(12:107|108|109|110|111|112|113|114|(3:294|295|(7:297|298|74|75|76|77|(0)))|116|117|(5:119|120|121|122|(17:246|247|(5:249|250|251|252|253)(1:282)|254|255|256|257|258|259|260|262|263|264|265|(17:267|268|125|126|127|128|129|130|131|(8:132|133|134|135|136|137|138|(23:140|141|142|143|144|145|(2:147|(3:151|152|153)(2:154|155))(2:189|190)|156|157|158|(1:160)|161|162|163|164|165|166|167|168|169|170|171|(2:176|177)(4:173|174|175|153))(12:197|198|199|200|201|202|204|205|206|207|208|(11:210|211|212|213|214|215|216|217|218|219|(1:222)(1:221))(1:228)))|233|186|187|67|19|20|(2:22|(4:24|(1:26)|13|14)(6:27|(3:29|(2:32|30)|33)|34|(1:36)|10|11))(8:37|(2:(5:43|44|45|46|41)|51)|52|(3:54|(2:57|55)|58)|59|(1:61)|7|8))|94|95)(16:124|125|126|127|128|129|130|131|(9:132|133|134|135|136|137|138|(0)(0)|153)|233|186|187|67|19|20|(0)(0)))(9:287|288|289|290|74|75|76|77|(0))))|79|80|81|(3:101|20|(0)(0))(9:85|(1:87)|88|89|90|91|(4:93|19|20|(0)(0))|94|95)) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:197|199|200|201|204|205|207|208|(11:210|211|212|213|214|215|216|217|218|219|(1:222)(1:221))(1:228)) */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0203 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x04d6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0671  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x01db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x070c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x060b  */
    /* JADX WARN: Type inference failed for: r13v43 */
    /* JADX WARN: Type inference failed for: r13v53, types: [byte[], d2.a, java.io.FileOutputStream, java.io.InputStream, java.lang.String, java.util.ArrayList, java.util.Enumeration, java.util.zip.ZipEntry, java.util.zip.ZipFile, kotlin.jvm.internal.u, kotlin.jvm.internal.v, kotlin.jvm.internal.x, t6.c] */
    /* JADX WARN: Type inference failed for: r13v59 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:154:0x054b -> B:65:0x054f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:162:0x0579 -> B:66:0x055f). Please report as a decompilation issue!!! */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r45) {
        /*
            Method dump skipped, instructions count: 1944
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.q.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
