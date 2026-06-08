package androidx.browser.customtabs;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface PostMessageBackend {
    void onDisconnectChannel(@NonNull Context context);

    boolean onNotifyMessageChannelReady(@Nullable Bundle bundle);

    boolean onPostMessage(@NonNull String str, @Nullable Bundle bundle);
}
