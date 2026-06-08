package c4;

import com.uptodown.UptodownApp;
import com.uptodown.activities.MyApps;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e4 implements w4.b, w4.n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1551a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MyApps f1552b;

    public /* synthetic */ e4(MyApps myApps, int i) {
        this.f1551a = i;
        this.f1552b = myApps;
    }

    @Override // w4.n
    public void a(int i) {
        MyApps myApps = this.f1552b;
        if (MyApps.N0(myApps, i)) {
            e4.p pVar = myApps.f3330c0;
            pVar.getClass();
            Object obj = pVar.f4654d.get(i);
            obj.getClass();
            ((x4.e) obj).E = true;
            e4.p pVar2 = myApps.f3330c0;
            pVar2.getClass();
            pVar2.notifyItemChanged(i);
            return;
        }
        if (MyApps.O0(myApps, i)) {
            e4.p pVar3 = myApps.f3330c0;
            pVar3.getClass();
            Object obj2 = pVar3.f4654d.get(i);
            obj2.getClass();
            ((e4.v0) obj2).f4708a.E = true;
            e4.p pVar4 = myApps.f3330c0;
            pVar4.getClass();
            pVar4.notifyItemChanged(i);
        }
    }

    @Override // w4.b
    public final void b(int i) {
        int i6 = this.f1551a;
        MyApps myApps = this.f1552b;
        switch (i6) {
            case 0:
                float f = UptodownApp.I;
                if (b4.d.t()) {
                    if (!MyApps.N0(myApps, i)) {
                        if (MyApps.O0(myApps, i)) {
                            e4.p pVar = myApps.f3330c0;
                            pVar.getClass();
                            Object obj = pVar.f4654d.get(i);
                            obj.getClass();
                            myApps.B0(((e4.v0) obj).f4708a, i);
                            break;
                        }
                    } else {
                        e4.p pVar2 = myApps.f3330c0;
                        pVar2.getClass();
                        Object obj2 = pVar2.f4654d.get(i);
                        obj2.getClass();
                        myApps.B0((x4.e) obj2, i);
                        break;
                    }
                }
                break;
            default:
                float f10 = UptodownApp.I;
                if (b4.d.t()) {
                    if (!MyApps.N0(myApps, i)) {
                        if (MyApps.O0(myApps, i)) {
                            e4.p pVar3 = myApps.f3330c0;
                            pVar3.getClass();
                            Object obj3 = pVar3.f4654d.get(i);
                            obj3.getClass();
                            myApps.B0(((e4.v0) obj3).f4708a, i);
                            break;
                        }
                    } else {
                        e4.p pVar4 = myApps.f3330c0;
                        pVar4.getClass();
                        Object obj4 = pVar4.f4654d.get(i);
                        obj4.getClass();
                        myApps.B0((x4.e) obj4, i);
                        break;
                    }
                }
                break;
        }
    }

    @Override // w4.n
    public void c(int i) {
        float f = UptodownApp.I;
        if (b4.d.t()) {
            MyApps myApps = this.f1552b;
            if (!MyApps.N0(myApps, i)) {
                if (MyApps.O0(myApps, i)) {
                    e4.p pVar = myApps.f3330c0;
                    pVar.getClass();
                    Object obj = pVar.f4654d.get(i);
                    obj.getClass();
                    myApps.I0(((e4.v0) obj).f4708a);
                    return;
                }
                return;
            }
            e4.p pVar2 = myApps.f3330c0;
            pVar2.getClass();
            Object obj2 = pVar2.f4654d.get(i);
            obj2.getClass();
            x4.e eVar = (x4.e) obj2;
            if (eVar.f11127p == x4.d.f11087a) {
                myApps.I0(eVar);
            }
        }
    }

    @Override // w4.n
    public void d(int i) {
        float f = UptodownApp.I;
        if (b4.d.t()) {
            MyApps myApps = this.f1552b;
            if (MyApps.N0(myApps, i)) {
                e4.p pVar = myApps.f3330c0;
                pVar.getClass();
                Object obj = pVar.f4654d.get(i);
                obj.getClass();
                myApps.G0((x4.e) obj);
            } else if (MyApps.O0(myApps, i)) {
                e4.p pVar2 = myApps.f3330c0;
                pVar2.getClass();
                Object obj2 = pVar2.f4654d.get(i);
                obj2.getClass();
                myApps.G0(((e4.v0) obj2).f4708a);
            }
            e4.p pVar3 = myApps.f3330c0;
            if (pVar3 != null) {
                pVar3.notifyItemChanged(i);
            }
        }
    }

    @Override // w4.n
    public void e(int i) {
        MyApps myApps = this.f1552b;
        if (MyApps.N0(myApps, i)) {
            e4.p pVar = myApps.f3330c0;
            pVar.getClass();
            Object obj = pVar.f4654d.get(i);
            obj.getClass();
            ((x4.e) obj).E = false;
            e4.p pVar2 = myApps.f3330c0;
            pVar2.getClass();
            pVar2.notifyItemChanged(i);
            return;
        }
        if (MyApps.O0(myApps, i)) {
            e4.p pVar3 = myApps.f3330c0;
            pVar3.getClass();
            Object obj2 = pVar3.f4654d.get(i);
            obj2.getClass();
            ((e4.v0) obj2).f4708a.E = false;
            e4.p pVar4 = myApps.f3330c0;
            pVar4.getClass();
            pVar4.notifyItemChanged(i);
        }
    }
}
