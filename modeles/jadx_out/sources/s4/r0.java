package s4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9281a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b5.m f9282b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f9283l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r0(b5.m mVar, kotlin.jvm.internal.x xVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f9281a = i;
        this.f9282b = mVar;
        this.f9283l = xVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f9281a) {
            case 0:
                return new r0(this.f9282b, this.f9283l, cVar, 0);
            default:
                return new r0(this.f9282b, this.f9283l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f9281a) {
            case 0:
                r0 r0Var = (r0) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                r0Var.invokeSuspend(xVar);
                return xVar;
            default:
                r0 r0Var2 = (r0) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                r0Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        int i = this.f9281a;
        p6.x xVar = p6.x.f8463a;
        b5.m mVar = this.f9282b;
        String str3 = null;
        kotlin.jvm.internal.x xVar2 = this.f9283l;
        switch (i) {
            case 0:
                p6.a.e(obj);
                Context context = (Context) mVar.f1061b;
                x4.g gVar = (x4.g) mVar.f1062l;
                x4.e eVar = (x4.e) mVar.f1063m;
                if (eVar == null) {
                    if (gVar == null) {
                        xVar2.f7024a = null;
                        break;
                    } else {
                        String str4 = gVar.f11174n;
                        if (str4 != null && str4.length() != 0) {
                            xVar2.f7024a = gVar.f11174n;
                            break;
                        } else {
                            String str5 = gVar.F;
                            str5.getClass();
                            String str6 = gVar.M;
                            str6.getClass();
                            xVar2.f7024a = b5.m.j(mVar, context, str5, str6);
                            break;
                        }
                    }
                } else {
                    String str7 = eVar.f11126o;
                    if (str7 != null && str7.length() != 0) {
                        xVar2.f7024a = eVar.f11126o;
                        break;
                    } else {
                        String str8 = eVar.f11123l;
                        str8.getClass();
                        String str9 = eVar.f11132u;
                        str9.getClass();
                        String j = b5.m.j(mVar, context, str8, str9);
                        eVar.f11126o = j;
                        j5.g l10 = j5.g.D.l(context);
                        l10.b();
                        l10.n0(eVar);
                        l10.c();
                        xVar2.f7024a = j;
                        break;
                    }
                }
                break;
            default:
                p6.a.e(obj);
                x4.g gVar2 = (x4.g) mVar.f1062l;
                Context context2 = (Context) mVar.f1061b;
                x4.e eVar2 = (x4.e) mVar.f1063m;
                if (eVar2 == null || (str = eVar2.f11122b) == null) {
                    str = gVar2 != null ? gVar2.f11159b : null;
                }
                if (eVar2 != null && (str2 = eVar2.f11123l) != null) {
                    str3 = str2;
                } else if (gVar2 != null) {
                    str3 = gVar2.F;
                }
                CharSequence charSequence = (CharSequence) xVar2.f7024a;
                if (charSequence != null && charSequence.length() != 0 && str != null && str.length() != 0 && str3 != null && str3.length() != 0) {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.addFlags(524288);
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.SUBJECT", context2.getString(2131952588, str));
                    intent.putExtra("android.intent.extra.TEXT", (String) xVar2.f7024a);
                    context2.startActivity(Intent.createChooser(intent, context2.getString(2131952430)));
                    Bundle bundle = new Bundle();
                    bundle.putString("packagename", str3);
                    new android.support.v4.media.g(context2, 20).E(bundle, "share_app");
                    break;
                }
                break;
        }
        return xVar;
    }
}
