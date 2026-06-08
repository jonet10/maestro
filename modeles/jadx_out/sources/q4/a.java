package q4;

import com.google.android.gms.internal.measurement.i5;
import java.io.IOException;
import k0.k;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8677a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f8678b;

    public /* synthetic */ a(c cVar, int i) {
        this.f8677a = i;
        this.f8678b = cVar;
    }

    private final void a() {
        c cVar;
        c cVar2;
        while (true) {
            try {
                try {
                    synchronized (this.f8678b.i) {
                        while (true) {
                            try {
                                c cVar3 = this.f8678b;
                                if (cVar3.j || cVar3.f8691o < cVar3.i.size()) {
                                    break;
                                }
                                c cVar4 = this.f8678b;
                                cVar4.f8687k = false;
                                cVar4.i.wait();
                            } finally {
                            }
                        }
                    }
                    c cVar5 = this.f8678b;
                    if (cVar5.f8691o >= cVar5.f8689m) {
                        while (true) {
                            cVar2 = this.f8678b;
                            if (cVar2.f8690n == cVar2.f8691o) {
                                break;
                            } else {
                                i5.C("Waiting for read and write to catch up before cleanup.");
                            }
                        }
                        c.a(cVar2);
                    }
                    c cVar6 = this.f8678b;
                    int i = cVar6.f8691o;
                    int size = cVar6.i.size();
                    cVar = this.f8678b;
                    if (i < size) {
                        cVar.f8687k = true;
                        o4.a aVar = (o4.a) cVar.i.get(cVar.f8691o);
                        aVar.e();
                        i5.C("Executing: " + aVar.b() + " with context: " + k.n(this.f8678b.f8684c));
                        this.f8678b.h.write(aVar.b());
                        this.f8678b.h.flush();
                        this.f8678b.h.write("\necho F*D^W@#FGF " + this.f8678b.f8692p + " $?\n");
                        this.f8678b.h.flush();
                        c cVar7 = this.f8678b;
                        cVar7.f8691o = cVar7.f8691o + 1;
                        cVar7.f8692p = cVar7.f8692p + 1;
                    } else if (cVar.j) {
                        break;
                    }
                } finally {
                    c cVar8 = this.f8678b;
                    cVar8.f8691o = 0;
                    c.b(cVar8.h);
                }
            } catch (IOException e10) {
                e = e10;
                i5.C(e.getMessage());
                c cVar9 = this.f8678b;
                cVar9.f8691o = 0;
                c.b(cVar9.h);
            } catch (InterruptedException e11) {
                e = e11;
                i5.C(e.getMessage());
                c cVar92 = this.f8678b;
                cVar92.f8691o = 0;
                c.b(cVar92.h);
            }
        }
        cVar.f8687k = false;
        cVar.h.write("\nexit 0\n");
        this.f8678b.h.flush();
        i5.C("Closing shell");
        c cVar922 = this.f8678b;
        cVar922.f8691o = 0;
        c.b(cVar922.h);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
    
        r9.f8678b.f8686e.waitFor();
        r9.f8678b.f8686e.destroy();
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.a.run():void");
    }
}
