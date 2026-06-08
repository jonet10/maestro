package androidx.datastore.migrations;

import v6.c;
import v6.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.migrations.SharedPreferencesMigration", f = "SharedPreferencesMigration.android.kt", l = {151}, m = "shouldMigrate")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SharedPreferencesMigration$shouldMigrate$1 extends c {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SharedPreferencesMigration<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration$shouldMigrate$1(SharedPreferencesMigration<T> sharedPreferencesMigration, t6.c cVar) {
        super(cVar);
        this.this$0 = sharedPreferencesMigration;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.shouldMigrate(null, this);
    }
}
