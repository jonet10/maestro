package j4;

import androidx.documentfile.provider.DocumentFile;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6614a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DocumentFile f6615b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ o f6616l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(DocumentFile documentFile, o oVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f6614a = i;
        this.f6615b = documentFile;
        this.f6616l = oVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f6614a) {
            case 0:
                return new i(this.f6615b, this.f6616l, cVar, 0);
            case 1:
                return new i(this.f6615b, this.f6616l, cVar, 1);
            case 2:
                return new i(this.f6616l, this.f6615b, cVar, 2);
            default:
                return new i(this.f6616l, this.f6615b, cVar, 3);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f6614a) {
            case 0:
                i iVar = (i) create(a0Var, cVar);
                x xVar = x.f8463a;
                iVar.invokeSuspend(xVar);
                break;
            case 1:
                i iVar2 = (i) create(a0Var, cVar);
                x xVar2 = x.f8463a;
                iVar2.invokeSuspend(xVar2);
                break;
        }
        return ((i) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        k4.a aVar;
        k4.a aVar2;
        switch (this.f6614a) {
            case 0:
                p6.a.e(obj);
                DocumentFile documentFile = this.f6615b;
                if (documentFile != null && (aVar = this.f6616l.f6652c) != null) {
                    aVar.x(documentFile);
                }
                break;
            case 1:
                p6.a.e(obj);
                DocumentFile documentFile2 = this.f6615b;
                if (documentFile2 != null && (aVar2 = this.f6616l.f6652c) != null) {
                    aVar2.x(documentFile2);
                }
                break;
            case 2:
                p6.a.e(obj);
                k4.a aVar3 = this.f6616l.f6652c;
                if (aVar3 != null) {
                    aVar3.n(this.f6615b);
                    break;
                }
                break;
            default:
                p6.a.e(obj);
                k4.a aVar4 = this.f6616l.f6652c;
                if (aVar4 != null) {
                    aVar4.f(this.f6615b);
                    break;
                }
                break;
        }
        return x.f8463a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(o oVar, DocumentFile documentFile, t6.c cVar, int i) {
        super(2, cVar);
        this.f6614a = i;
        this.f6616l = oVar;
        this.f6615b = documentFile;
    }
}
