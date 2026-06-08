package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.PendingIntentCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class PendingIntentActivityWrapper {
    private final Context mContext;
    private final int mFlags;

    @NonNull
    private final Intent mIntent;
    private final boolean mIsMutable;

    @Nullable
    private final Bundle mOptions;

    @Nullable
    private final PendingIntent mPendingIntent;
    private final int mRequestCode;

    public PendingIntentActivityWrapper(@NonNull Context context, int i, @NonNull Intent intent, int i6, @Nullable Bundle bundle, boolean z9) {
        this.mContext = context;
        this.mRequestCode = i;
        this.mIntent = intent;
        this.mFlags = i6;
        this.mOptions = bundle;
        this.mIsMutable = z9;
        this.mPendingIntent = createPendingIntent();
    }

    @Nullable
    private PendingIntent createPendingIntent() {
        Bundle bundle = this.mOptions;
        Context context = this.mContext;
        return bundle == null ? PendingIntentCompat.getActivity(context, this.mRequestCode, this.mIntent, this.mFlags, this.mIsMutable) : PendingIntentCompat.getActivity(context, this.mRequestCode, this.mIntent, this.mFlags, bundle, this.mIsMutable);
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    public int getFlags() {
        return this.mFlags;
    }

    @NonNull
    public Intent getIntent() {
        return this.mIntent;
    }

    @NonNull
    public Bundle getOptions() {
        return this.mOptions;
    }

    @Nullable
    public PendingIntent getPendingIntent() {
        return this.mPendingIntent;
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public boolean isMutable() {
        return this.mIsMutable;
    }

    public PendingIntentActivityWrapper(@NonNull Context context, int i, @NonNull Intent intent, int i6, boolean z9) {
        this(context, i, intent, i6, null, z9);
    }
}
