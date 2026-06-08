package n5;

import android.widget.PopupWindow;
import d7.p;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class k implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f8094a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PopupWindow f8095b;

    public /* synthetic */ k(o oVar, PopupWindow popupWindow) {
        this.f8094a = oVar;
        this.f8095b = popupWindow;
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        Integer num = (Integer) obj;
        num.getClass();
        String str = (String) obj2;
        str.getClass();
        this.f8094a.f8104d.invoke(num, str);
        this.f8095b.dismiss();
        return x.f8463a;
    }
}
