package androidx.datastore.core;

import androidx.datastore.core.Message;
import d7.p;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.m;
import o7.q;
import o7.r;
import o7.u;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreImpl$writeActor$2 extends m implements p {
    public static final DataStoreImpl$writeActor$2 INSTANCE = new DataStoreImpl$writeActor$2();

    public DataStoreImpl$writeActor$2() {
        super(2);
    }

    public final void invoke(Message.Update<T> update, Throwable th) {
        update.getClass();
        q ack = update.getAck();
        if (th == null) {
            th = new CancellationException("DataStore scope was cancelled before updateData could complete");
        }
        r rVar = (r) ack;
        rVar.getClass();
        rVar.Q(new u(false, th));
    }

    @Override // d7.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Message.Update) obj, (Throwable) obj2);
        return x.f8463a;
    }
}
