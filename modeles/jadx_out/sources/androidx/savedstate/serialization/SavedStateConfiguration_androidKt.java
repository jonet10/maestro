package androidx.savedstate.serialization;

import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.serialization.serializers.SizeFSerializer;
import androidx.savedstate.serialization.serializers.SizeSerializer;
import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import g8.f;
import g8.g;
import java.util.List;
import kotlin.jvm.internal.y;
import q6.l;
import z7.b;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateConfiguration_androidKt {
    public static final f getDefaultSerializersModuleOnPlatform() {
        g gVar = new g();
        gVar.d(y.a(Size.class), SizeSerializer.INSTANCE);
        gVar.d(y.a(SizeF.class), SizeFSerializer.INSTANCE);
        gVar.b(y.a(SparseArray.class), new androidx.room.f(4));
        return gVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b getDefaultSerializersModuleOnPlatform$lambda$1$lambda$0(List list) {
        list.getClass();
        return new SparseArraySerializer((b) l.q0(list));
    }
}
