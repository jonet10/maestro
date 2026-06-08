package a4;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.internal.measurement.i5;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e0 extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f86a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f87b;

    /* renamed from: l, reason: collision with root package name */
    public final Object f88l;

    public e0(ReferenceQueue referenceQueue, Handler handler) {
        this.f87b = referenceQueue;
        this.f88l = handler;
        setDaemon(true);
        setName("Picasso-refQueue");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        switch (this.f86a) {
            case 0:
                Handler handler = (Handler) this.f88l;
                Process.setThreadPriority(10);
                while (true) {
                    try {
                        a aVar = (a) ((ReferenceQueue) this.f87b).remove(1000L);
                        Message obtainMessage = handler.obtainMessage();
                        if (aVar != null) {
                            obtainMessage.what = 3;
                            obtainMessage.obj = aVar.f67a;
                            handler.sendMessage(obtainMessage);
                        } else {
                            obtainMessage.recycle();
                        }
                    } catch (InterruptedException unused) {
                        return;
                    } catch (Exception e10) {
                        handler.post(new f(e10, 1));
                        return;
                    }
                }
            default:
                o4.a aVar2 = (o4.a) this.f87b;
                aVar2.getClass();
                synchronized (aVar2) {
                    try {
                        ((o4.a) this.f87b).getClass();
                        ((o4.a) this.f87b).getClass();
                        i5.C("Command 158 is waiting for: 20000");
                        o4.a aVar3 = (o4.a) this.f87b;
                        aVar3.getClass();
                        aVar3.wait(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                    } catch (InterruptedException e11) {
                        i5.C("Exception: " + e11);
                    }
                    o4.a aVar4 = (o4.a) this.f87b;
                    if (!aVar4.g) {
                        aVar4.getClass();
                        i5.C("Timeout Exception has occurred for command: 158.");
                        o4.a aVar5 = (o4.a) this.f88l;
                        try {
                            i5.C("Request to close all shells!");
                            i5.C("Request to close normal shell!");
                            q4.c.d();
                            i5.C("Request to close custom shell!");
                            i5.C("Terminating all shells.");
                            aVar5.f("Timeout Exception");
                        } catch (IOException unused2) {
                        }
                    }
                }
                return;
        }
    }

    public e0(o4.a aVar, o4.a aVar2) {
        this.f88l = aVar;
        this.f87b = aVar2;
    }
}
