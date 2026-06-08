package f0;

import android.os.Parcel;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends BasePendingResult {

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f4807k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(i0.g gVar, int i) {
        super(gVar);
        this.f4807k = i;
        y.h(gVar, "GoogleApiClient must not be null");
        y.h(d0.a.f3532a, "Api must not be null");
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ i0.i b(Status status) {
        int i = this.f4807k;
        return status;
    }

    public final void f(i0.b bVar) {
        switch (this.f4807k) {
            case 0:
                e eVar = (e) bVar;
                j jVar = (j) eVar.t();
                f fVar = new f(this, 0);
                GoogleSignInOptions googleSignInOptions = eVar.I;
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(jVar.f2893k);
                int i = w0.c.f10911a;
                obtain.writeStrongBinder(fVar);
                if (googleSignInOptions == null) {
                    obtain.writeInt(0);
                } else {
                    obtain.writeInt(1);
                    googleSignInOptions.writeToParcel(obtain, 0);
                }
                jVar.a(obtain, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY);
                break;
            default:
                e eVar2 = (e) bVar;
                j jVar2 = (j) eVar2.t();
                f fVar2 = new f(this, 1);
                GoogleSignInOptions googleSignInOptions2 = eVar2.I;
                Parcel obtain2 = Parcel.obtain();
                obtain2.writeInterfaceToken(jVar2.f2893k);
                int i6 = w0.c.f10911a;
                obtain2.writeStrongBinder(fVar2);
                if (googleSignInOptions2 == null) {
                    obtain2.writeInt(0);
                } else {
                    obtain2.writeInt(1);
                    googleSignInOptions2.writeToParcel(obtain2, 0);
                }
                jVar2.a(obtain2, 103);
                break;
        }
    }

    public final void g(Status status) {
        y.a("Failed result must not be success", !(status.f2474a <= 0));
        e(b(status));
    }
}
