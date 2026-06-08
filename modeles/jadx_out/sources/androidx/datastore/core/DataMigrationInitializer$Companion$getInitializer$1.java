package androidx.datastore.core;

import androidx.datastore.core.DataMigrationInitializer;
import d7.p;
import java.util.List;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.DataMigrationInitializer$Companion$getInitializer$1", f = "DataMigrationInitializer.kt", l = {33}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataMigrationInitializer$Companion$getInitializer$1 extends i implements p {
    final /* synthetic */ List<DataMigration<T>> $migrations;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DataMigrationInitializer$Companion$getInitializer$1(List<? extends DataMigration<T>> list, c cVar) {
        super(2, cVar);
        this.$migrations = list;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        DataMigrationInitializer$Companion$getInitializer$1 dataMigrationInitializer$Companion$getInitializer$1 = new DataMigrationInitializer$Companion$getInitializer$1(this.$migrations, cVar);
        dataMigrationInitializer$Companion$getInitializer$1.L$0 = obj;
        return dataMigrationInitializer$Companion$getInitializer$1;
    }

    @Override // d7.p
    public final Object invoke(InitializerApi<T> initializerApi, c cVar) {
        return ((DataMigrationInitializer$Companion$getInitializer$1) create(initializerApi, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object runMigrations;
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            InitializerApi initializerApi = (InitializerApi) this.L$0;
            DataMigrationInitializer.Companion companion = DataMigrationInitializer.Companion;
            List<DataMigration<T>> list = this.$migrations;
            this.label = 1;
            runMigrations = companion.runMigrations(list, initializerApi, this);
            u6.a aVar = u6.a.f10762a;
            if (runMigrations == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return x.f8463a;
    }
}
