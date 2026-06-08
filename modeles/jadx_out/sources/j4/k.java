package j4;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.v;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f6626a;

    /* renamed from: b, reason: collision with root package name */
    public v f6627b;

    /* renamed from: l, reason: collision with root package name */
    public int f6628l;

    /* renamed from: m, reason: collision with root package name */
    public long f6629m;

    /* renamed from: n, reason: collision with root package name */
    public long f6630n;

    /* renamed from: o, reason: collision with root package name */
    public int f6631o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ o f6632p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ InputStream f6633q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ OutputStream f6634r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ String f6635s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(o oVar, InputStream inputStream, OutputStream outputStream, String str, t6.c cVar) {
        super(2, cVar);
        this.f6632p = oVar;
        this.f6633q = inputStream;
        this.f6634r = outputStream;
        this.f6635s = str;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new k(this.f6632p, this.f6633q, this.f6634r, this.f6635s, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((k) create((a0) obj, (t6.c) obj2)).invokeSuspend(x.f8463a);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004f A[Catch: all -> 0x0027, TRY_LEAVE, TryCatch #2 {all -> 0x0027, blocks: (B:6:0x0019, B:10:0x0047, B:12:0x004f, B:74:0x0038), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0099 A[Catch: all -> 0x008d, TRY_ENTER, TryCatch #4 {all -> 0x008d, blocks: (B:15:0x005d, B:17:0x0066, B:21:0x0075, B:23:0x0079, B:28:0x008f, B:31:0x0099, B:33:0x00a2), top: B:14:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cc A[SYNTHETIC] */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.k.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
