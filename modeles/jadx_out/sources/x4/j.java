package x4;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j implements Parcelable {
    public static Parcelable.Creator<j> CREATOR = new i0.l(11);

    /* renamed from: a, reason: collision with root package name */
    public int f11224a;

    /* renamed from: b, reason: collision with root package name */
    public String f11225b;

    /* renamed from: l, reason: collision with root package name */
    public String f11226l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f11227m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f11228n;

    /* renamed from: o, reason: collision with root package name */
    public int f11229o;

    /* renamed from: p, reason: collision with root package name */
    public int f11230p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f11231q;

    /* renamed from: r, reason: collision with root package name */
    public ArrayList f11232r;

    public /* synthetic */ j(int i, String str, int i6) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? null : str, (String) null);
    }

    public final void a(JSONObject jSONObject, int i) {
        if (!jSONObject.isNull("name")) {
            this.f11225b = jSONObject.optString("name");
        }
        if (!jSONObject.isNull("id")) {
            this.f11224a = jSONObject.optInt("id");
        }
        this.f11229o = i;
    }

    public final void b(JSONObject jSONObject) {
        if (!jSONObject.isNull("id")) {
            this.f11224a = jSONObject.optInt("id");
        }
        if (!jSONObject.isNull("name")) {
            this.f11225b = jSONObject.optString("name");
        } else if (!jSONObject.isNull("value")) {
            this.f11225b = jSONObject.optString("value");
        }
        if (!jSONObject.isNull("description")) {
            this.f11226l = jSONObject.optString("description");
        }
        this.f11227m = true;
    }

    public final void c(Bundle bundle) {
        this.f11224a = bundle.getInt("id");
        this.f11225b = bundle.getString("name");
        this.f11226l = bundle.getString("description");
        this.f11227m = bundle.getBoolean("isFloating");
        this.f11229o = bundle.getInt("parentCategoryId");
        this.f11230p = bundle.getInt("isGame");
        this.f11228n = bundle.getBoolean("isLeaf");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(JSONObject jSONObject) {
        if (!jSONObject.isNull("id")) {
            this.f11224a = jSONObject.optInt("id");
        }
        if (!jSONObject.isNull("name")) {
            this.f11225b = jSONObject.optString("name");
        }
        if (!jSONObject.isNull("description")) {
            this.f11226l = jSONObject.optString("description");
        }
        if (!jSONObject.isNull("parentCategoryID")) {
            this.f11229o = jSONObject.optInt("parentCategoryID");
        }
        Object[] objArr = 0;
        if (!jSONObject.isNull("isFloating")) {
            this.f11227m = jSONObject.optInt("isFloating") == 1;
        }
        if (jSONObject.isNull("relatedCategories")) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("relatedCategories");
        if (optJSONArray != null) {
            this.f11232r = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                j jVar = new j((int) (objArr == true ? 1 : 0), (String) null, 7);
                optJSONObject.getClass();
                jVar.d(optJSONObject);
                ArrayList arrayList = this.f11232r;
                arrayList.getClass();
                arrayList.add(jVar);
            }
        }
        this.f11227m = jSONObject.optInt("isFloating") == 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeInt(this.f11224a);
        parcel.writeString(this.f11225b);
        parcel.writeString(this.f11226l);
        parcel.writeInt(this.f11227m ? 1 : 0);
        parcel.writeInt(this.f11228n ? 1 : 0);
        parcel.writeInt(this.f11229o);
        parcel.writeInt(this.f11230p);
        parcel.writeTypedList(this.f11231q);
    }

    public j(int i, String str, String str2) {
        this.f11224a = i;
        this.f11225b = str;
        this.f11226l = str2;
    }
}
