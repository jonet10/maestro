package androidx.datastore.core.handlers;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.CorruptionHandler;
import d7.l;
import java.io.IOException;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ReplaceFileCorruptionHandler<T> implements CorruptionHandler<T> {
    private final l produceNewData;

    public ReplaceFileCorruptionHandler(l lVar) {
        lVar.getClass();
        this.produceNewData = lVar;
    }

    @Override // androidx.datastore.core.CorruptionHandler
    public Object handleCorruption(CorruptionException corruptionException, c cVar) throws IOException {
        return this.produceNewData.invoke(corruptionException);
    }
}
