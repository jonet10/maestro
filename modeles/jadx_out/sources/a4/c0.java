package a4;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class c0 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f78a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(Looper looper, int i) {
        super(looper);
        this.f78a = i;
        switch (i) {
            case 4:
                super(looper);
                Looper.getMainLooper();
                break;
            case 5:
            default:
                Looper.getMainLooper();
                break;
            case 6:
                super(looper);
                Looper.getMainLooper();
                break;
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (this.f78a) {
            case 0:
                int i = message.what;
                if (i == 3) {
                    b bVar = (b) message.obj;
                    bVar.f68a.a(bVar.d());
                    return;
                }
                if (i != 8) {
                    if (i != 13) {
                        throw new AssertionError("Unknown handler message received: " + message.what);
                    }
                    List list = (List) message.obj;
                    int size = list.size();
                    for (int i6 = 0; i6 < size; i6++) {
                        b bVar2 = (b) list.get(i6);
                        g0 g0Var = bVar2.f68a;
                        Bitmap g = g0Var.g(bVar2.f71d);
                        if (g != null) {
                            g0Var.b(g, 1, bVar2, null);
                        } else {
                            g0Var.c(bVar2);
                        }
                    }
                    return;
                }
                List list2 = (List) message.obj;
                int size2 = list2.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    h hVar = (h) list2.get(i10);
                    g0 g0Var2 = hVar.f101b;
                    g0Var2.getClass();
                    b bVar3 = hVar.f109s;
                    ArrayList arrayList = hVar.f110t;
                    boolean z9 = (arrayList == null || arrayList.isEmpty()) ? false : true;
                    if (bVar3 != null || z9) {
                        Object obj = hVar.f106p.f127b;
                        Exception exc = hVar.f113x;
                        Bitmap bitmap = hVar.f111u;
                        int i11 = hVar.f112w;
                        if (bVar3 != null) {
                            g0Var2.b(bitmap, i11, bVar3, exc);
                        }
                        if (z9) {
                            int size3 = arrayList.size();
                            for (int i12 = 0; i12 < size3; i12++) {
                                g0Var2.b(bitmap, i11, (b) arrayList.get(i12), exc);
                            }
                        }
                    }
                }
                return;
            case 1:
                sendMessageDelayed(obtainMessage(), 1000L);
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c0(Looper looper, Handler.Callback callback, int i) {
        super(looper, callback);
        this.f78a = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c0(Looper looper, int i, boolean z9) {
        super(looper);
        this.f78a = i;
    }
}
