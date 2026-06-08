package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.savedstate.serialization.SavedStateConfiguration;
import androidx.savedstate.serialization.serializers.MutableStateFlowSerializer;
import androidx.savedstate.serialization.serializers.SavedStateSerializer;
import g8.d;
import g8.f;
import g8.g;
import g8.i;
import java.util.List;
import kotlin.jvm.internal.y;
import q6.l;
import r7.c0;
import z7.b;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateConfigurationKt {
    private static final f DEFAULT_SERIALIZERS_MODULE;

    static {
        g gVar = new g();
        gVar.d(y.a(Bundle.class), SavedStateSerializer.INSTANCE);
        gVar.b(y.a(c0.class), new androidx.room.f(3));
        d c9 = gVar.c();
        f defaultSerializersModuleOnPlatform = SavedStateConfiguration_androidKt.getDefaultSerializersModuleOnPlatform();
        d dVar = i.f5387a;
        defaultSerializersModuleOnPlatform.getClass();
        g gVar2 = new g();
        c9.a(gVar2);
        defaultSerializersModuleOnPlatform.a(gVar2);
        DEFAULT_SERIALIZERS_MODULE = gVar2.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b DEFAULT_SERIALIZERS_MODULE$lambda$1$lambda$0(List list) {
        list.getClass();
        return new MutableStateFlowSerializer((b) l.q0(list));
    }

    public static final SavedStateConfiguration SavedStateConfiguration(SavedStateConfiguration savedStateConfiguration, d7.l lVar) {
        savedStateConfiguration.getClass();
        lVar.getClass();
        SavedStateConfiguration.Builder builder = new SavedStateConfiguration.Builder(savedStateConfiguration);
        lVar.invoke(builder);
        return builder.build$savedstate();
    }

    public static /* synthetic */ SavedStateConfiguration SavedStateConfiguration$default(SavedStateConfiguration savedStateConfiguration, d7.l lVar, int i, Object obj) {
        if ((i & 1) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return SavedStateConfiguration(savedStateConfiguration, lVar);
    }

    public static final SavedStateConfiguration SavedStateConfiguration(d7.l lVar) {
        lVar.getClass();
        return SavedStateConfiguration$default(null, lVar, 1, null);
    }
}
