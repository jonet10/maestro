package androidx.browser.trusted;

import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface TokenStore {
    @Nullable
    @BinderThread
    Token load();

    @WorkerThread
    void store(@Nullable Token token);
}
