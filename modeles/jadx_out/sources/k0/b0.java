package k0;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b0 extends a4.c0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f6835b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(e eVar, Looper looper) {
        super(looper, 6);
        this.f6835b = eVar;
    }

    @Override // a4.c0, android.os.Handler
    public final void handleMessage(Message message) {
        Boolean bool;
        t tVar;
        e eVar = this.f6835b;
        int i = eVar.F.get();
        int i6 = message.arg1;
        int i10 = message.what;
        if (i != i6) {
            if ((i10 == 2 || i10 == 1 || i10 == 7) && (tVar = (t) message.obj) != null) {
                tVar.c();
                return;
            }
            return;
        }
        if ((i10 == 1 || i10 == 7 || i10 == 4 || i10 == 5) && !eVar.d()) {
            t tVar2 = (t) message.obj;
            if (tVar2 != null) {
                tVar2.c();
                return;
            }
            return;
        }
        int i11 = message.what;
        if (i11 == 4) {
            eVar.C = new h0.b(null, null, message.arg2);
            if (!eVar.D && !TextUtils.isEmpty(eVar.u()) && !TextUtils.isEmpty(null)) {
                try {
                    Class.forName(eVar.u());
                    if (!eVar.D) {
                        eVar.z(null, 3);
                        return;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            h0.b bVar = eVar.C;
            if (bVar == null) {
                bVar = new h0.b(null, null, 8);
            }
            eVar.f6848s.g(bVar);
            System.currentTimeMillis();
            return;
        }
        if (i11 == 5) {
            h0.b bVar2 = eVar.C;
            if (bVar2 == null) {
                bVar2 = new h0.b(null, null, 8);
            }
            eVar.f6848s.g(bVar2);
            System.currentTimeMillis();
            return;
        }
        if (i11 == 3) {
            Object obj = message.obj;
            eVar.f6848s.g(new h0.b(null, obj instanceof PendingIntent ? (PendingIntent) obj : null, message.arg2));
            System.currentTimeMillis();
            return;
        }
        if (i11 == 6) {
            eVar.z(null, 5);
            b bVar3 = eVar.f6852x;
            if (bVar3 != null) {
                bVar3.c(message.arg2);
            }
            System.currentTimeMillis();
            eVar.x(5, 1, null);
            return;
        }
        if (i11 == 2 && !eVar.g()) {
            t tVar3 = (t) message.obj;
            if (tVar3 != null) {
                tVar3.c();
                return;
            }
            return;
        }
        int i12 = message.what;
        if (i12 != 2 && i12 != 1 && i12 != 7) {
            StringBuilder sb = new StringBuilder(String.valueOf(i12).length() + 34);
            sb.append("Don't know how to handle message: ");
            sb.append(i12);
            Log.wtf("GmsClient", sb.toString(), new Exception());
            return;
        }
        t tVar4 = (t) message.obj;
        synchronized (tVar4) {
            try {
                bool = tVar4.f6931a;
                if (tVar4.f6932b) {
                    String obj2 = tVar4.toString();
                    StringBuilder sb2 = new StringBuilder(obj2.length() + 47);
                    sb2.append("Callback proxy ");
                    sb2.append(obj2);
                    sb2.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb2.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            e eVar2 = tVar4.f;
            int i13 = tVar4.f6934d;
            if (i13 != 0) {
                eVar2.z(null, 1);
                Bundle bundle = tVar4.f6935e;
                tVar4.b(new h0.b(null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null, i13));
            } else if (!tVar4.a()) {
                eVar2.z(null, 1);
                tVar4.b(new h0.b(null, null, 8));
            }
        }
        synchronized (tVar4) {
            tVar4.f6932b = true;
        }
        tVar4.c();
    }
}
