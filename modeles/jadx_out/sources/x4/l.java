package x4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class l implements d7.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11272a;

    @Override // d7.l
    public final Object invoke(Object obj) {
        int i = this.f11272a;
        l7.i iVar = (l7.i) obj;
        iVar.getClass();
        switch (i) {
            case 0:
                int i6 = iVar.b().f5695a;
                String str = (String) ((l7.h) iVar.a()).get(0);
                String str2 = (String) ((l7.h) iVar.a()).get(1);
                String group = iVar.f7172a.group();
                group.getClass();
                return new o(str, str2, group, i6);
            case 1:
                return (CharSequence) ((l7.h) iVar.a()).get(1);
            case 2:
                return (CharSequence) ((l7.h) iVar.a()).get(3);
            default:
                return (CharSequence) ((l7.h) iVar.a()).get(2);
        }
    }
}
