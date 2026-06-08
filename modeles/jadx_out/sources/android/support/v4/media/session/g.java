package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class g extends Binder implements a {
    public final WeakReference i;

    public g(f fVar) {
        attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        this.i = new WeakReference(fVar);
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) {
        if (i == 1598968902) {
            parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return true;
        }
        switch (i) {
            case 1:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                String readString = parcel.readString();
                Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                f fVar = (f) this.i.get();
                if (fVar != null) {
                    fVar.postToHandler(1, readString, bundle);
                }
                return true;
            case 2:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                throw new AssertionError();
            case 3:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                PlaybackStateCompat createFromParcel = parcel.readInt() != 0 ? PlaybackStateCompat.CREATOR.createFromParcel(parcel) : null;
                f fVar2 = (f) this.i.get();
                if (fVar2 != null) {
                    fVar2.postToHandler(2, createFromParcel, null);
                }
                return true;
            case 4:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                if (parcel.readInt() != 0) {
                    MediaMetadataCompat.CREATOR.createFromParcel(parcel);
                }
                throw new AssertionError();
            case 5:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                parcel.createTypedArrayList(MediaSessionCompat$QueueItem.CREATOR);
                throw new AssertionError();
            case 6:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                if (parcel.readInt() != 0) {
                }
                throw new AssertionError();
            case 7:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                if (parcel.readInt() != 0) {
                }
                throw new AssertionError();
            case 8:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                if (parcel.readInt() != 0) {
                    ParcelableVolumeInfo.CREATOR.createFromParcel(parcel);
                }
                throw new AssertionError();
            case 9:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                int readInt = parcel.readInt();
                f fVar3 = (f) this.i.get();
                if (fVar3 != null) {
                    fVar3.postToHandler(9, Integer.valueOf(readInt), null);
                }
                return true;
            case 10:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                parcel.readInt();
                return true;
            case 11:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                boolean z9 = parcel.readInt() != 0;
                f fVar4 = (f) this.i.get();
                if (fVar4 != null) {
                    fVar4.postToHandler(11, Boolean.valueOf(z9), null);
                }
                return true;
            case 12:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                int readInt2 = parcel.readInt();
                f fVar5 = (f) this.i.get();
                if (fVar5 != null) {
                    fVar5.postToHandler(12, Integer.valueOf(readInt2), null);
                }
                return true;
            case 13:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                f fVar6 = (f) this.i.get();
                if (fVar6 != null) {
                    fVar6.postToHandler(13, null, null);
                }
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i6);
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
