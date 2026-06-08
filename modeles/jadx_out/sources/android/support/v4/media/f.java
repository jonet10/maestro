package android.support.v4.media;

import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaDescription;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.common.api.Scope;
import e1.c5;
import e1.j4;
import e1.m4;
import e1.n4;
import e1.o4;
import e1.t;
import e1.u;
import e1.x4;
import h0.q;
import java.util.ArrayList;
import k0.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class f implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f245a;

    public /* synthetic */ f(int i) {
        this.f245a = i;
    }

    public static void a(u uVar, Parcel parcel, int i) {
        String str = uVar.f4289a;
        int Y = a.a.Y(parcel, 20293);
        a.a.T(parcel, 2, str);
        a.a.S(parcel, 3, uVar.f4290b, i);
        a.a.T(parcel, 4, uVar.f4291l);
        long j = uVar.f4292m;
        a.a.X(parcel, 5, 8);
        parcel.writeLong(j);
        a.a.a0(parcel, Y);
    }

    public static void b(x4 x4Var, Parcel parcel) {
        int i = x4Var.f4401a;
        int Y = a.a.Y(parcel, 20293);
        a.a.X(parcel, 1, 4);
        parcel.writeInt(i);
        a.a.T(parcel, 2, x4Var.f4402b);
        long j = x4Var.f4403l;
        a.a.X(parcel, 3, 8);
        parcel.writeLong(j);
        Long l10 = x4Var.f4404m;
        if (l10 != null) {
            a.a.X(parcel, 4, 8);
            parcel.writeLong(l10.longValue());
        }
        a.a.T(parcel, 6, x4Var.f4405n);
        a.a.T(parcel, 7, x4Var.f4406o);
        Double d10 = x4Var.f4407p;
        if (d10 != null) {
            a.a.X(parcel, 8, 8);
            parcel.writeDouble(d10.doubleValue());
        }
        a.a.a0(parcel, Y);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        e.b bVar = null;
        String str = null;
        h0.b bVar2 = null;
        Intent intent = null;
        String str2 = null;
        Bundle bundle = null;
        ArrayList arrayList = null;
        String str3 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        switch (this.f245a) {
            case 0:
                return new MediaBrowserCompat$MediaItem(parcel);
            case 1:
                return MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
            case 2:
                return new MediaMetadataCompat(parcel);
            case 3:
                return new RatingCompat(parcel.readInt(), parcel.readFloat());
            case 4:
                return new MediaSessionCompat$QueueItem(parcel);
            case 5:
                MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper = new MediaSessionCompat$ResultReceiverWrapper();
                mediaSessionCompat$ResultReceiverWrapper.f256a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                return mediaSessionCompat$ResultReceiverWrapper;
            case 6:
                return new MediaSessionCompat$Token(parcel.readParcelable(null), null);
            case 7:
                ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo();
                parcelableVolumeInfo.f259a = parcel.readInt();
                parcelableVolumeInfo.f261l = parcel.readInt();
                parcelableVolumeInfo.f262m = parcel.readInt();
                parcelableVolumeInfo.f263n = parcel.readInt();
                parcelableVolumeInfo.f260b = parcel.readInt();
                return parcelableVolumeInfo;
            case 8:
                return new PlaybackStateCompat(parcel);
            case 9:
                e.d dVar = new e.d();
                IBinder readStrongBinder = parcel.readStrongBinder();
                int i6 = e.c.j;
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface(e.b.h);
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof e.b)) {
                        e.a aVar = new e.a();
                        aVar.i = readStrongBinder;
                        bVar = aVar;
                    } else {
                        bVar = (e.b) queryLocalInterface;
                    }
                }
                dVar.f3727a = bVar;
                return dVar;
            case 10:
                int L = t0.f.L(parcel);
                long j6 = 0;
                long j10 = 0;
                int i10 = 0;
                while (parcel.dataPosition() < L) {
                    int readInt = parcel.readInt();
                    char c9 = (char) readInt;
                    if (c9 == 1) {
                        j6 = t0.f.F(parcel, readInt);
                    } else if (c9 == 2) {
                        i10 = t0.f.E(parcel, readInt);
                    } else if (c9 != 3) {
                        t0.f.H(parcel, readInt);
                    } else {
                        j10 = t0.f.F(parcel, readInt);
                    }
                }
                t0.f.t(parcel, L);
                return new e1.d(i10, j6, j10);
            case 11:
                int L2 = t0.f.L(parcel);
                long j11 = 0;
                long j12 = 0;
                long j13 = 0;
                boolean z9 = false;
                String str4 = null;
                String str5 = null;
                x4 x4Var = null;
                String str6 = null;
                u uVar = null;
                u uVar2 = null;
                u uVar3 = null;
                while (parcel.dataPosition() < L2) {
                    int readInt2 = parcel.readInt();
                    switch ((char) readInt2) {
                        case 2:
                            str4 = t0.f.p(parcel, readInt2);
                            break;
                        case 3:
                            str5 = t0.f.p(parcel, readInt2);
                            break;
                        case 4:
                            x4Var = (x4) t0.f.o(parcel, readInt2, x4.CREATOR);
                            break;
                        case 5:
                            j11 = t0.f.F(parcel, readInt2);
                            break;
                        case 6:
                            z9 = t0.f.C(parcel, readInt2);
                            break;
                        case 7:
                            str6 = t0.f.p(parcel, readInt2);
                            break;
                        case '\b':
                            uVar = (u) t0.f.o(parcel, readInt2, u.CREATOR);
                            break;
                        case '\t':
                            j12 = t0.f.F(parcel, readInt2);
                            break;
                        case '\n':
                            uVar2 = (u) t0.f.o(parcel, readInt2, u.CREATOR);
                            break;
                        case 11:
                            j13 = t0.f.F(parcel, readInt2);
                            break;
                        case '\f':
                            uVar3 = (u) t0.f.o(parcel, readInt2, u.CREATOR);
                            break;
                        default:
                            t0.f.H(parcel, readInt2);
                            break;
                    }
                }
                t0.f.t(parcel, L2);
                return new e1.e(str4, str5, x4Var, j11, z9, str6, uVar, j12, uVar2, j13, uVar3);
            case 12:
                int L3 = t0.f.L(parcel);
                while (parcel.dataPosition() < L3) {
                    int readInt3 = parcel.readInt();
                    if (((char) readInt3) != 1) {
                        t0.f.H(parcel, readInt3);
                    } else {
                        bundle3 = t0.f.n(parcel, readInt3);
                    }
                }
                t0.f.t(parcel, L3);
                return new e1.i(bundle3);
            case 13:
                int L4 = t0.f.L(parcel);
                while (parcel.dataPosition() < L4) {
                    int readInt4 = parcel.readInt();
                    if (((char) readInt4) != 2) {
                        t0.f.H(parcel, readInt4);
                    } else {
                        bundle2 = t0.f.n(parcel, readInt4);
                    }
                }
                t0.f.t(parcel, L4);
                return new t(bundle2);
            case 14:
                int L5 = t0.f.L(parcel);
                long j14 = 0;
                String str7 = null;
                t tVar = null;
                String str8 = null;
                while (parcel.dataPosition() < L5) {
                    int readInt5 = parcel.readInt();
                    char c10 = (char) readInt5;
                    if (c10 == 2) {
                        str7 = t0.f.p(parcel, readInt5);
                    } else if (c10 == 3) {
                        tVar = (t) t0.f.o(parcel, readInt5, t.CREATOR);
                    } else if (c10 == 4) {
                        str8 = t0.f.p(parcel, readInt5);
                    } else if (c10 != 5) {
                        t0.f.H(parcel, readInt5);
                    } else {
                        j14 = t0.f.F(parcel, readInt5);
                    }
                }
                t0.f.t(parcel, L5);
                return new u(str7, tVar, str8, j14);
            case 15:
                int L6 = t0.f.L(parcel);
                while (parcel.dataPosition() < L6) {
                    int readInt6 = parcel.readInt();
                    char c11 = (char) readInt6;
                    if (c11 == 1) {
                        str3 = t0.f.p(parcel, readInt6);
                    } else if (c11 == 2) {
                        j = t0.f.F(parcel, readInt6);
                    } else if (c11 != 3) {
                        t0.f.H(parcel, readInt6);
                    } else {
                        i = t0.f.E(parcel, readInt6);
                    }
                }
                t0.f.t(parcel, L6);
                return new j4(str3, i, j);
            case 16:
                int L7 = t0.f.L(parcel);
                long j15 = 0;
                long j16 = 0;
                int i11 = 0;
                byte[] bArr = null;
                String str9 = null;
                Bundle bundle4 = null;
                String str10 = null;
                while (parcel.dataPosition() < L7) {
                    int readInt7 = parcel.readInt();
                    switch ((char) readInt7) {
                        case 1:
                            j15 = t0.f.F(parcel, readInt7);
                            break;
                        case 2:
                            int G = t0.f.G(parcel, readInt7);
                            int dataPosition = parcel.dataPosition();
                            if (G == 0) {
                                bArr = null;
                                break;
                            } else {
                                byte[] createByteArray = parcel.createByteArray();
                                parcel.setDataPosition(dataPosition + G);
                                bArr = createByteArray;
                                break;
                            }
                        case 3:
                            str9 = t0.f.p(parcel, readInt7);
                            break;
                        case 4:
                            bundle4 = t0.f.n(parcel, readInt7);
                            break;
                        case 5:
                            i11 = t0.f.E(parcel, readInt7);
                            break;
                        case 6:
                            j16 = t0.f.F(parcel, readInt7);
                            break;
                        case 7:
                            str10 = t0.f.p(parcel, readInt7);
                            break;
                        default:
                            t0.f.H(parcel, readInt7);
                            break;
                    }
                }
                t0.f.t(parcel, L7);
                return new m4(j15, bArr, str9, bundle4, i11, j16, str10);
            case 17:
                int L8 = t0.f.L(parcel);
                while (true) {
                    ArrayList arrayList2 = null;
                    while (parcel.dataPosition() < L8) {
                        int readInt8 = parcel.readInt();
                        if (((char) readInt8) != 1) {
                            t0.f.H(parcel, readInt8);
                        } else {
                            int G2 = t0.f.G(parcel, readInt8);
                            int dataPosition2 = parcel.dataPosition();
                            if (G2 == 0) {
                                break;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            int readInt9 = parcel.readInt();
                            for (int i12 = 0; i12 < readInt9; i12++) {
                                arrayList3.add(Integer.valueOf(parcel.readInt()));
                            }
                            parcel.setDataPosition(dataPosition2 + G2);
                            arrayList2 = arrayList3;
                        }
                    }
                    t0.f.t(parcel, L8);
                    return new n4(arrayList2);
                    break;
                }
            case 18:
                int L9 = t0.f.L(parcel);
                while (parcel.dataPosition() < L9) {
                    int readInt10 = parcel.readInt();
                    if (((char) readInt10) != 1) {
                        t0.f.H(parcel, readInt10);
                    } else {
                        arrayList = t0.f.r(parcel, readInt10, m4.CREATOR);
                    }
                }
                t0.f.t(parcel, L9);
                return new o4(arrayList);
            case 19:
                int L10 = t0.f.L(parcel);
                long j17 = 0;
                int i13 = 0;
                String str11 = null;
                Long l10 = null;
                Float f = null;
                String str12 = null;
                String str13 = null;
                Double d10 = null;
                while (parcel.dataPosition() < L10) {
                    int readInt11 = parcel.readInt();
                    switch ((char) readInt11) {
                        case 1:
                            i13 = t0.f.E(parcel, readInt11);
                            break;
                        case 2:
                            str11 = t0.f.p(parcel, readInt11);
                            break;
                        case 3:
                            j17 = t0.f.F(parcel, readInt11);
                            break;
                        case 4:
                            int G3 = t0.f.G(parcel, readInt11);
                            if (G3 == 0) {
                                l10 = null;
                                break;
                            } else {
                                t0.f.R(parcel, G3, 8);
                                l10 = Long.valueOf(parcel.readLong());
                                break;
                            }
                        case 5:
                            int G4 = t0.f.G(parcel, readInt11);
                            if (G4 == 0) {
                                f = null;
                                break;
                            } else {
                                t0.f.R(parcel, G4, 4);
                                f = Float.valueOf(parcel.readFloat());
                                break;
                            }
                        case 6:
                            str12 = t0.f.p(parcel, readInt11);
                            break;
                        case 7:
                            str13 = t0.f.p(parcel, readInt11);
                            break;
                        case '\b':
                            int G5 = t0.f.G(parcel, readInt11);
                            if (G5 == 0) {
                                d10 = null;
                                break;
                            } else {
                                t0.f.R(parcel, G5, 8);
                                d10 = Double.valueOf(parcel.readDouble());
                                break;
                            }
                        default:
                            t0.f.H(parcel, readInt11);
                            break;
                    }
                }
                t0.f.t(parcel, L10);
                return new x4(i13, str11, j17, l10, f, str12, str13, d10);
            case 20:
                int L11 = t0.f.L(parcel);
                String str14 = "";
                String str15 = str14;
                String str16 = str15;
                String str17 = str16;
                int i14 = 100;
                long j18 = 0;
                long j19 = 0;
                long j20 = 0;
                long j21 = 0;
                long j22 = 0;
                long j23 = 0;
                long j24 = 0;
                long j25 = -2147483648L;
                boolean z10 = true;
                boolean z11 = true;
                boolean z12 = false;
                int i15 = 0;
                boolean z13 = false;
                boolean z14 = false;
                int i16 = 0;
                int i17 = 0;
                String str18 = null;
                String str19 = null;
                String str20 = null;
                String str21 = null;
                String str22 = null;
                String str23 = null;
                Boolean bool = null;
                ArrayList<String> arrayList4 = null;
                String str24 = null;
                String str25 = null;
                while (parcel.dataPosition() < L11) {
                    int readInt12 = parcel.readInt();
                    switch ((char) readInt12) {
                        case 2:
                            str18 = t0.f.p(parcel, readInt12);
                            break;
                        case 3:
                            str19 = t0.f.p(parcel, readInt12);
                            break;
                        case 4:
                            str20 = t0.f.p(parcel, readInt12);
                            break;
                        case 5:
                            str21 = t0.f.p(parcel, readInt12);
                            break;
                        case 6:
                            j18 = t0.f.F(parcel, readInt12);
                            break;
                        case 7:
                            j19 = t0.f.F(parcel, readInt12);
                            break;
                        case '\b':
                            str22 = t0.f.p(parcel, readInt12);
                            break;
                        case '\t':
                            z10 = t0.f.C(parcel, readInt12);
                            break;
                        case '\n':
                            z12 = t0.f.C(parcel, readInt12);
                            break;
                        case 11:
                            j25 = t0.f.F(parcel, readInt12);
                            break;
                        case '\f':
                            str23 = t0.f.p(parcel, readInt12);
                            break;
                        case '\r':
                        case 17:
                        case 19:
                        case 20:
                        case 24:
                        case '!':
                        default:
                            t0.f.H(parcel, readInt12);
                            break;
                        case 14:
                            j20 = t0.f.F(parcel, readInt12);
                            break;
                        case 15:
                            i15 = t0.f.E(parcel, readInt12);
                            break;
                        case 16:
                            z11 = t0.f.C(parcel, readInt12);
                            break;
                        case 18:
                            z13 = t0.f.C(parcel, readInt12);
                            break;
                        case 21:
                            int G6 = t0.f.G(parcel, readInt12);
                            if (G6 == 0) {
                                bool = null;
                                break;
                            } else {
                                t0.f.R(parcel, G6, 4);
                                bool = Boolean.valueOf(parcel.readInt() != 0);
                                break;
                            }
                        case 22:
                            j21 = t0.f.F(parcel, readInt12);
                            break;
                        case 23:
                            int G7 = t0.f.G(parcel, readInt12);
                            int dataPosition3 = parcel.dataPosition();
                            if (G7 == 0) {
                                arrayList4 = null;
                                break;
                            } else {
                                ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                                parcel.setDataPosition(dataPosition3 + G7);
                                arrayList4 = createStringArrayList;
                                break;
                            }
                        case 25:
                            str14 = t0.f.p(parcel, readInt12);
                            break;
                        case 26:
                            str15 = t0.f.p(parcel, readInt12);
                            break;
                        case 27:
                            str24 = t0.f.p(parcel, readInt12);
                            break;
                        case 28:
                            z14 = t0.f.C(parcel, readInt12);
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                            j22 = t0.f.F(parcel, readInt12);
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                            i14 = t0.f.E(parcel, readInt12);
                            break;
                        case 31:
                            str16 = t0.f.p(parcel, readInt12);
                            break;
                        case ' ':
                            i16 = t0.f.E(parcel, readInt12);
                            break;
                        case '\"':
                            j23 = t0.f.F(parcel, readInt12);
                            break;
                        case '#':
                            str25 = t0.f.p(parcel, readInt12);
                            break;
                        case '$':
                            str17 = t0.f.p(parcel, readInt12);
                            break;
                        case '%':
                            j24 = t0.f.F(parcel, readInt12);
                            break;
                        case '&':
                            i17 = t0.f.E(parcel, readInt12);
                            break;
                    }
                }
                t0.f.t(parcel, L11);
                return new c5(str18, str19, str20, str21, j18, j19, str22, z10, z12, j25, str23, j20, i15, z11, z13, bool, j21, arrayList4, str14, str15, str24, z14, j22, i14, str16, i16, j23, str25, str17, j24, i17);
            case 21:
                int L12 = t0.f.L(parcel);
                int i18 = 0;
                while (parcel.dataPosition() < L12) {
                    int readInt13 = parcel.readInt();
                    char c12 = (char) readInt13;
                    if (c12 == 1) {
                        i = t0.f.E(parcel, readInt13);
                    } else if (c12 == 2) {
                        i18 = t0.f.E(parcel, readInt13);
                    } else if (c12 != 3) {
                        t0.f.H(parcel, readInt13);
                    } else {
                        bundle = t0.f.n(parcel, readInt13);
                    }
                }
                t0.f.t(parcel, L12);
                return new f0.a(i, i18, bundle);
            case 22:
                int L13 = t0.f.L(parcel);
                GoogleSignInOptions googleSignInOptions = null;
                while (parcel.dataPosition() < L13) {
                    int readInt14 = parcel.readInt();
                    char c13 = (char) readInt14;
                    if (c13 == 2) {
                        str2 = t0.f.p(parcel, readInt14);
                    } else if (c13 != 5) {
                        t0.f.H(parcel, readInt14);
                    } else {
                        googleSignInOptions = (GoogleSignInOptions) t0.f.o(parcel, readInt14, GoogleSignInOptions.CREATOR);
                    }
                }
                t0.f.t(parcel, L13);
                return new SignInConfiguration(str2, googleSignInOptions);
            case 23:
                int L14 = t0.f.L(parcel);
                int i19 = 0;
                int i20 = 0;
                PendingIntent pendingIntent = null;
                String str26 = null;
                Integer num = null;
                while (parcel.dataPosition() < L14) {
                    int readInt15 = parcel.readInt();
                    char c14 = (char) readInt15;
                    if (c14 == 1) {
                        i19 = t0.f.E(parcel, readInt15);
                    } else if (c14 == 2) {
                        i20 = t0.f.E(parcel, readInt15);
                    } else if (c14 == 3) {
                        pendingIntent = (PendingIntent) t0.f.o(parcel, readInt15, PendingIntent.CREATOR);
                    } else if (c14 == 4) {
                        str26 = t0.f.p(parcel, readInt15);
                    } else if (c14 != 5) {
                        t0.f.H(parcel, readInt15);
                    } else {
                        int G8 = t0.f.G(parcel, readInt15);
                        if (G8 == 0) {
                            num = null;
                        } else {
                            t0.f.R(parcel, G8, 4);
                            num = Integer.valueOf(parcel.readInt());
                        }
                    }
                }
                t0.f.t(parcel, L14);
                return new h0.b(i19, i20, pendingIntent, str26, num);
            case 24:
                int L15 = t0.f.L(parcel);
                long j26 = -1;
                int i21 = 0;
                boolean z15 = false;
                String str27 = null;
                while (parcel.dataPosition() < L15) {
                    int readInt16 = parcel.readInt();
                    char c15 = (char) readInt16;
                    if (c15 == 1) {
                        str27 = t0.f.p(parcel, readInt16);
                    } else if (c15 == 2) {
                        i21 = t0.f.E(parcel, readInt16);
                    } else if (c15 == 3) {
                        j26 = t0.f.F(parcel, readInt16);
                    } else if (c15 != 4) {
                        t0.f.H(parcel, readInt16);
                    } else {
                        z15 = t0.f.C(parcel, readInt16);
                    }
                }
                t0.f.t(parcel, L15);
                return new h0.d(str27, i21, j26, z15);
            case 25:
                int L16 = t0.f.L(parcel);
                long j27 = -1;
                boolean z16 = false;
                int i22 = 0;
                int i23 = 0;
                String str28 = null;
                while (parcel.dataPosition() < L16) {
                    int readInt17 = parcel.readInt();
                    char c16 = (char) readInt17;
                    if (c16 == 1) {
                        z16 = t0.f.C(parcel, readInt17);
                    } else if (c16 == 2) {
                        str28 = t0.f.p(parcel, readInt17);
                    } else if (c16 == 3) {
                        i22 = t0.f.E(parcel, readInt17);
                    } else if (c16 == 4) {
                        i23 = t0.f.E(parcel, readInt17);
                    } else if (c16 != 5) {
                        t0.f.H(parcel, readInt17);
                    } else {
                        j27 = t0.f.F(parcel, readInt17);
                    }
                }
                t0.f.t(parcel, L16);
                return new q(z16, str28, i22, i23, j27);
            case 26:
                int L17 = t0.f.L(parcel);
                int i24 = 0;
                while (parcel.dataPosition() < L17) {
                    int readInt18 = parcel.readInt();
                    char c17 = (char) readInt18;
                    if (c17 == 1) {
                        i = t0.f.E(parcel, readInt18);
                    } else if (c17 == 2) {
                        i24 = t0.f.E(parcel, readInt18);
                    } else if (c17 != 3) {
                        t0.f.H(parcel, readInt18);
                    } else {
                        intent = (Intent) t0.f.o(parcel, readInt18, Intent.CREATOR);
                    }
                }
                t0.f.t(parcel, L17);
                return new h1.b(i, i24, intent);
            case 27:
                int L18 = t0.f.L(parcel);
                ArrayList<String> arrayList5 = null;
                String str29 = null;
                while (parcel.dataPosition() < L18) {
                    int readInt19 = parcel.readInt();
                    char c18 = (char) readInt19;
                    if (c18 == 1) {
                        int G9 = t0.f.G(parcel, readInt19);
                        int dataPosition4 = parcel.dataPosition();
                        if (G9 == 0) {
                            arrayList5 = null;
                        } else {
                            ArrayList<String> createStringArrayList2 = parcel.createStringArrayList();
                            parcel.setDataPosition(dataPosition4 + G9);
                            arrayList5 = createStringArrayList2;
                        }
                    } else if (c18 != 2) {
                        t0.f.H(parcel, readInt19);
                    } else {
                        str29 = t0.f.p(parcel, readInt19);
                    }
                }
                t0.f.t(parcel, L18);
                return new h1.d(str29, arrayList5);
            case 28:
                int L19 = t0.f.L(parcel);
                s sVar = null;
                while (parcel.dataPosition() < L19) {
                    int readInt20 = parcel.readInt();
                    char c19 = (char) readInt20;
                    if (c19 == 1) {
                        i = t0.f.E(parcel, readInt20);
                    } else if (c19 == 2) {
                        bVar2 = (h0.b) t0.f.o(parcel, readInt20, h0.b.CREATOR);
                    } else if (c19 != 3) {
                        t0.f.H(parcel, readInt20);
                    } else {
                        sVar = (s) t0.f.o(parcel, readInt20, s.CREATOR);
                    }
                }
                t0.f.t(parcel, L19);
                return new h1.e(i, bVar2, sVar);
            default:
                int L20 = t0.f.L(parcel);
                while (parcel.dataPosition() < L20) {
                    int readInt21 = parcel.readInt();
                    char c20 = (char) readInt21;
                    if (c20 == 1) {
                        i = t0.f.E(parcel, readInt21);
                    } else if (c20 != 2) {
                        t0.f.H(parcel, readInt21);
                    } else {
                        str = t0.f.p(parcel, readInt21);
                    }
                }
                t0.f.t(parcel, L20);
                return new Scope(i, str);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f245a) {
            case 0:
                return new MediaBrowserCompat$MediaItem[i];
            case 1:
                return new MediaDescriptionCompat[i];
            case 2:
                return new MediaMetadataCompat[i];
            case 3:
                return new RatingCompat[i];
            case 4:
                return new MediaSessionCompat$QueueItem[i];
            case 5:
                return new MediaSessionCompat$ResultReceiverWrapper[i];
            case 6:
                return new MediaSessionCompat$Token[i];
            case 7:
                return new ParcelableVolumeInfo[i];
            case 8:
                return new PlaybackStateCompat[i];
            case 9:
                return new e.d[i];
            case 10:
                return new e1.d[i];
            case 11:
                return new e1.e[i];
            case 12:
                return new e1.i[i];
            case 13:
                return new t[i];
            case 14:
                return new u[i];
            case 15:
                return new j4[i];
            case 16:
                return new m4[i];
            case 17:
                return new n4[i];
            case 18:
                return new o4[i];
            case 19:
                return new x4[i];
            case 20:
                return new c5[i];
            case 21:
                return new f0.a[i];
            case 22:
                return new SignInConfiguration[i];
            case 23:
                return new h0.b[i];
            case 24:
                return new h0.d[i];
            case 25:
                return new q[i];
            case 26:
                return new h1.b[i];
            case 27:
                return new h1.d[i];
            case 28:
                return new h1.e[i];
            default:
                return new Scope[i];
        }
    }
}
