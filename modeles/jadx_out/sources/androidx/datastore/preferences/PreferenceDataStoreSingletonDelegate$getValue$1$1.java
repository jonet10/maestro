package androidx.datastore.preferences;

import android.content.Context;
import d7.a;
import java.io.File;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PreferenceDataStoreSingletonDelegate$getValue$1$1 extends m implements a {
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ PreferenceDataStoreSingletonDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreferenceDataStoreSingletonDelegate$getValue$1$1(Context context, PreferenceDataStoreSingletonDelegate preferenceDataStoreSingletonDelegate) {
        super(0);
        this.$applicationContext = context;
        this.this$0 = preferenceDataStoreSingletonDelegate;
    }

    @Override // d7.a
    public final File invoke() {
        String str;
        Context context = this.$applicationContext;
        context.getClass();
        str = this.this$0.name;
        return PreferenceDataStoreFile.preferencesDataStoreFile(context, str);
    }
}
