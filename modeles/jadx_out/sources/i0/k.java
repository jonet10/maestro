package i0;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k extends BasePendingResult {

    /* renamed from: k, reason: collision with root package name */
    public final Status f5621k;

    public k(Status status) {
        super(null);
        this.f5621k = status;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final i b(Status status) {
        return this.f5621k;
    }
}
