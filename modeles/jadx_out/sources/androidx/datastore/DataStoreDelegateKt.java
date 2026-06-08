package androidx.datastore;

import androidx.datastore.core.Serializer;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import d7.l;
import f7.a;
import o7.a0;
import o7.c0;
import o7.m0;
import v7.d;
import v7.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreDelegateKt {
    public static final <T> a dataStore(String str, Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, l lVar, a0 a0Var) {
        str.getClass();
        serializer.getClass();
        lVar.getClass();
        a0Var.getClass();
        return new DataStoreSingletonDelegate(str, new OkioSerializerWrapper(serializer), replaceFileCorruptionHandler, lVar, a0Var);
    }

    public static a dataStore$default(String str, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, l lVar, a0 a0Var, int i, Object obj) {
        if ((i & 4) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i & 8) != 0) {
            lVar = DataStoreDelegateKt$dataStore$1.INSTANCE;
        }
        if ((i & 16) != 0) {
            e eVar = m0.f8288a;
            a0Var = c0.b(d.f10884a.plus(c0.d()));
        }
        return dataStore(str, serializer, replaceFileCorruptionHandler, lVar, a0Var);
    }
}
