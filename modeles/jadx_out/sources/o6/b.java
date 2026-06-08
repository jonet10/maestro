package o6;

import android.app.Application;
import d7.p;
import l8.f;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8215a;

    /* renamed from: b, reason: collision with root package name */
    public int f8216b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Application f8217l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ l8.e f8218m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Application application, l8.e eVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f8215a = i;
        this.f8217l = application;
        this.f8218m = eVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f8215a) {
            case 0:
                return new b(this.f8217l, this.f8218m, cVar, 0);
            case 1:
                return new b(this.f8217l, this.f8218m, cVar, 1);
            case 2:
                return new b(this.f8217l, this.f8218m, cVar, 2);
            default:
                return new b(this.f8217l, this.f8218m, cVar, 3);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        t6.c cVar = (t6.c) obj2;
        switch (this.f8215a) {
            case 0:
                return new b(this.f8217l, this.f8218m, cVar, 0).invokeSuspend(x.f8463a);
            case 1:
                return new b(this.f8217l, this.f8218m, cVar, 1).invokeSuspend(x.f8463a);
            case 2:
                return new b(this.f8217l, this.f8218m, cVar, 2).invokeSuspend(x.f8463a);
            default:
                return new b(this.f8217l, this.f8218m, cVar, 3).invokeSuspend(x.f8463a);
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f8215a) {
            case 0:
                int i = this.f8216b;
                if (i != 0) {
                    if (i == 1) {
                        p6.a.e(obj);
                        return obj;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                f fVar = this.f8218m.f7187a;
                String str = fVar == null ? null : fVar.f7192b;
                String str2 = fVar != null ? fVar.f7191a : null;
                this.f8216b = 1;
                Object b7 = e.b(this.f8217l, str, str2, this);
                u6.a aVar = u6.a.f10762a;
                return b7 == aVar ? aVar : b7;
            case 1:
                int i6 = this.f8216b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        p6.a.e(obj);
                        return obj;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                f fVar2 = this.f8218m.f7188b;
                String str3 = fVar2 == null ? null : fVar2.f7192b;
                String str4 = fVar2 != null ? fVar2.f7191a : null;
                this.f8216b = 1;
                Object b10 = e.b(this.f8217l, str3, str4, this);
                u6.a aVar2 = u6.a.f10762a;
                return b10 == aVar2 ? aVar2 : b10;
            case 2:
                int i10 = this.f8216b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        p6.a.e(obj);
                        return obj;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                f fVar3 = this.f8218m.f7189c;
                String str5 = fVar3 == null ? null : fVar3.f7192b;
                String str6 = fVar3 != null ? fVar3.f7191a : null;
                this.f8216b = 1;
                Object b11 = e.b(this.f8217l, str5, str6, this);
                u6.a aVar3 = u6.a.f10762a;
                return b11 == aVar3 ? aVar3 : b11;
            default:
                int i11 = this.f8216b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        p6.a.e(obj);
                        return obj;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                f fVar4 = this.f8218m.f7190d;
                String str7 = fVar4 == null ? null : fVar4.f7192b;
                String str8 = fVar4 != null ? fVar4.f7191a : null;
                this.f8216b = 1;
                Object b12 = e.b(this.f8217l, str7, str8, this);
                u6.a aVar4 = u6.a.f10762a;
                return b12 == aVar4 ? aVar4 : b12;
        }
    }
}
