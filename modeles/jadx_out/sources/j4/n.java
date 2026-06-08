package j4;

import androidx.documentfile.provider.DocumentFile;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public DocumentFile f6644a;

    /* renamed from: b, reason: collision with root package name */
    public Iterator f6645b;

    /* renamed from: l, reason: collision with root package name */
    public long f6646l;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f6647m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ o f6648n;

    /* renamed from: o, reason: collision with root package name */
    public int f6649o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(o oVar, v6.c cVar) {
        super(cVar);
        this.f6648n = oVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f6647m = obj;
        this.f6649o |= Integer.MIN_VALUE;
        return this.f6648n.c(null, null, this);
    }
}
