package androidx.datastore;

import android.content.Context;
import d7.a;
import kotlin.jvm.internal.m;
import w8.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreSingletonDelegate$getValue$1$1 extends m implements a {
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ DataStoreSingletonDelegate<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreSingletonDelegate$getValue$1$1(Context context, DataStoreSingletonDelegate<T> dataStoreSingletonDelegate) {
        super(0);
        this.$applicationContext = context;
        this.this$0 = dataStoreSingletonDelegate;
    }

    @Override // d7.a
    public final y invoke() {
        String str;
        String str2 = y.f11004b;
        Context context = this.$applicationContext;
        context.getClass();
        str = ((DataStoreSingletonDelegate) this.this$0).fileName;
        String absolutePath = DataStoreFile.dataStoreFile(context, str).getAbsolutePath();
        absolutePath.getClass();
        return q1.a.j(absolutePath, false);
    }
}
