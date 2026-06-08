package p9;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        String str;
        String str2;
        String str3;
        String str4;
        parcel.getClass();
        String readString = parcel.readString();
        if (readString == null) {
            readString = "";
        }
        String readString2 = parcel.readString();
        if (readString2 == null) {
            readString2 = "";
        }
        String readString3 = parcel.readString();
        if (readString3 == null) {
            readString3 = "";
        }
        String readString4 = parcel.readString();
        if (readString4 == null) {
            readString4 = "";
        }
        String readString5 = parcel.readString();
        if (readString5 == null) {
            String str5 = readString4;
            str4 = "";
            str = readString2;
            str2 = readString3;
            str3 = str5;
        } else {
            str = readString2;
            str2 = readString3;
            str3 = readString4;
            str4 = readString5;
        }
        return new g(readString, str, str2, str3, str4);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new g[i];
    }
}
