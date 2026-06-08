package l3;

import androidx.lifecycle.l;
import j$.util.Collection;
import j$.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import r3.d;
import s3.b;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f7091a;

    /* renamed from: b, reason: collision with root package name */
    public String f7092b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7093c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7094d;

    public static HashMap a(String str) {
        int i = 0;
        int i6 = 1;
        if (str != null && !str.isEmpty() && !str.startsWith("DB")) {
            if (!str.startsWith("C")) {
                throw new q3.a(l.w("Unable to decode '", str, "'"));
            }
            HashMap hashMap = new HashMap();
            s3.a aVar = new s3.a(str);
            hashMap.put("tcfeuv2", aVar);
            s3.a aVar2 = new s3.a(i);
            List list = d.f8860a;
            aVar2.g("SectionIds", Arrays.asList(2));
            hashMap.put("header", aVar);
            return hashMap;
        }
        HashMap hashMap2 = new HashMap();
        if (str != null && !str.isEmpty()) {
            String[] split = str.split("~");
            String str2 = split[0];
            s3.a aVar3 = new s3.a(i);
            aVar3.a(str2);
            hashMap2.put("header", aVar3);
            List list2 = (List) aVar3.d("SectionIds");
            while (i < list2.size()) {
                if (((Integer) list2.get(i)).equals(2)) {
                    hashMap2.put("tcfeuv2", new s3.a(split[i + 1]));
                } else {
                    int i10 = 5;
                    if (((Integer) list2.get(i)).equals(5)) {
                        String str3 = split[i + 1];
                        s3.a aVar4 = new s3.a(i6);
                        aVar4.a(str3);
                        hashMap2.put("tcfcav1", aVar4);
                    } else {
                        int i11 = 6;
                        int i12 = 20;
                        if (((Integer) list2.get(i)).equals(6)) {
                            String str4 = split[i + 1];
                            s3.a aVar5 = new s3.a(i12);
                            aVar5.a(str4);
                            hashMap2.put("uspv1", aVar5);
                        } else {
                            int i13 = 8;
                            if (((Integer) list2.get(i)).equals(8)) {
                                String str5 = split[i + 1];
                                s3.a aVar6 = new s3.a(3);
                                aVar6.a(str5);
                                hashMap2.put("usca", aVar6);
                            } else {
                                int i14 = 7;
                                int i15 = 11;
                                if (((Integer) list2.get(i)).equals(7)) {
                                    String str6 = split[i + 1];
                                    s3.a aVar7 = new s3.a(i15);
                                    aVar7.a(str6);
                                    hashMap2.put("usnat", aVar7);
                                } else {
                                    int i16 = 9;
                                    int i17 = 19;
                                    if (((Integer) list2.get(i)).equals(9)) {
                                        String str7 = split[i + 1];
                                        s3.a aVar8 = new s3.a(i17);
                                        aVar8.a(str7);
                                        hashMap2.put("usva", aVar8);
                                    } else {
                                        int i18 = 10;
                                        if (((Integer) list2.get(i)).equals(10)) {
                                            String str8 = split[i + 1];
                                            s3.a aVar9 = new s3.a(4);
                                            aVar9.a(str8);
                                            hashMap2.put("usco", aVar9);
                                        } else {
                                            int i19 = 18;
                                            if (((Integer) list2.get(i)).equals(11)) {
                                                String str9 = split[i + 1];
                                                s3.a aVar10 = new s3.a(i19);
                                                aVar10.a(str9);
                                                hashMap2.put("usut", aVar10);
                                            } else {
                                                int i20 = 12;
                                                if (((Integer) list2.get(i)).equals(12)) {
                                                    String str10 = split[i + 1];
                                                    s3.a aVar11 = new s3.a(i10);
                                                    aVar11.a(str10);
                                                    hashMap2.put("usct", aVar11);
                                                } else {
                                                    int i21 = 13;
                                                    if (((Integer) list2.get(i)).equals(13)) {
                                                        String str11 = split[i + 1];
                                                        s3.a aVar12 = new s3.a(i14);
                                                        aVar12.a(str11);
                                                        hashMap2.put("usfl", aVar12);
                                                    } else {
                                                        int i22 = 14;
                                                        if (((Integer) list2.get(i)).equals(14)) {
                                                            String str12 = split[i + 1];
                                                            s3.a aVar13 = new s3.a(i18);
                                                            aVar13.a(str12);
                                                            hashMap2.put("usmt", aVar13);
                                                        } else {
                                                            int i23 = 15;
                                                            if (((Integer) list2.get(i)).equals(15)) {
                                                                String str13 = split[i + 1];
                                                                s3.a aVar14 = new s3.a(i23);
                                                                aVar14.a(str13);
                                                                hashMap2.put("usor", aVar14);
                                                            } else {
                                                                int i24 = 16;
                                                                int i25 = 17;
                                                                if (((Integer) list2.get(i)).equals(16)) {
                                                                    String str14 = split[i + 1];
                                                                    s3.a aVar15 = new s3.a(i25);
                                                                    aVar15.a(str14);
                                                                    hashMap2.put("ustx", aVar15);
                                                                } else if (((Integer) list2.get(i)).equals(17)) {
                                                                    String str15 = split[i + 1];
                                                                    s3.a aVar16 = new s3.a(i11);
                                                                    aVar16.a(str15);
                                                                    hashMap2.put("usde", aVar16);
                                                                } else if (((Integer) list2.get(i)).equals(18)) {
                                                                    String str16 = split[i + 1];
                                                                    s3.a aVar17 = new s3.a(i13);
                                                                    aVar17.a(str16);
                                                                    hashMap2.put("usia", aVar17);
                                                                } else if (((Integer) list2.get(i)).equals(19)) {
                                                                    String str17 = split[i + 1];
                                                                    s3.a aVar18 = new s3.a(i20);
                                                                    aVar18.a(str17);
                                                                    hashMap2.put("usne", aVar18);
                                                                } else if (((Integer) list2.get(i)).equals(20)) {
                                                                    String str18 = split[i + 1];
                                                                    s3.a aVar19 = new s3.a(i21);
                                                                    aVar19.a(str18);
                                                                    hashMap2.put("usnh", aVar19);
                                                                } else if (((Integer) list2.get(i)).equals(21)) {
                                                                    String str19 = split[i + 1];
                                                                    s3.a aVar20 = new s3.a(i22);
                                                                    aVar20.a(str19);
                                                                    hashMap2.put("usnj", aVar20);
                                                                } else if (((Integer) list2.get(i)).equals(22)) {
                                                                    String str20 = split[i + 1];
                                                                    s3.a aVar21 = new s3.a(i24);
                                                                    aVar21.a(str20);
                                                                    hashMap2.put("ustn", aVar21);
                                                                } else if (((Integer) list2.get(i)).equals(23)) {
                                                                    String str21 = split[i + 1];
                                                                    s3.a aVar22 = new s3.a(i16);
                                                                    aVar22.a(str21);
                                                                    hashMap2.put("usmn", aVar22);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                i++;
                i6 = 1;
            }
        }
        return hashMap2;
    }

    public final void b(int i) {
        String str = (String) b.f9158b.get(Integer.valueOf(i));
        if (!this.f7094d) {
            this.f7091a = a(this.f7092b);
            this.f7093c = false;
            this.f7094d = true;
        }
        if (this.f7091a.containsKey(str)) {
            this.f7091a.remove(str);
            this.f7093c = true;
        }
    }

    public final String c() {
        String str = this.f7092b;
        if (str == null || str.isEmpty() || this.f7093c) {
            HashMap hashMap = this.f7091a;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            while (true) {
                List list = b.f9157a;
                if (i >= list.size()) {
                    break;
                }
                String str2 = (String) list.get(i);
                if (hashMap.containsKey(str2)) {
                    s3.a aVar = (s3.a) hashMap.get(str2);
                    arrayList.add(aVar.c());
                    arrayList2.add(Integer.valueOf(aVar.e()));
                }
                i++;
            }
            s3.a aVar2 = new s3.a(0);
            try {
                aVar2.g("SectionIds", f());
                arrayList.add(0, aVar2.c());
                this.f7092b = (String) Collection.EL.stream(arrayList).collect(Collectors.joining("~"));
                this.f7093c = false;
                this.f7094d = true;
            } catch (q3.b e10) {
                throw new a1.b(e10);
            }
        }
        return this.f7092b;
    }

    public final void d() {
        if (!this.f7094d) {
            this.f7091a = a(this.f7092b);
            this.f7093c = false;
            this.f7094d = true;
        }
        try {
            new s3.a(0).g("SectionIds", f());
        } catch (q3.b unused) {
        }
    }

    public final s3.a e(String str) {
        if (!this.f7094d) {
            this.f7091a = a(this.f7092b);
            this.f7093c = false;
            this.f7094d = true;
        }
        if (this.f7091a.containsKey(str)) {
            return (s3.a) this.f7091a.get(str);
        }
        return null;
    }

    public final ArrayList f() {
        int i = 0;
        if (!this.f7094d) {
            this.f7091a = a(this.f7092b);
            this.f7093c = false;
            this.f7094d = true;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            List list = b.f9157a;
            if (i >= list.size()) {
                return arrayList;
            }
            String str = (String) list.get(i);
            if (this.f7091a.containsKey(str)) {
                arrayList.add(Integer.valueOf(((s3.a) this.f7091a.get(str)).e()));
            }
            i++;
        }
    }

    public final boolean g() {
        String str = (String) b.f9158b.get(2);
        if (!this.f7094d) {
            this.f7091a = a(this.f7092b);
            this.f7093c = false;
            this.f7094d = true;
        }
        return this.f7091a.containsKey(str);
    }

    public final void h(String str, String str2, Object obj) {
        s3.a aVar;
        if (!this.f7094d) {
            this.f7091a = a(this.f7092b);
            this.f7093c = false;
            this.f7094d = true;
        }
        if (this.f7091a.containsKey(str)) {
            aVar = (s3.a) this.f7091a.get(str);
        } else if (str.equals("tcfcav1")) {
            aVar = new s3.a(1);
            this.f7091a.put("tcfcav1", aVar);
        } else if (str.equals("tcfeuv2")) {
            aVar = new s3.a(2);
            this.f7091a.put("tcfeuv2", aVar);
        } else if (str.equals("uspv1")) {
            aVar = new s3.a(20);
            this.f7091a.put("uspv1", aVar);
        } else if (str.equals("usnat")) {
            aVar = new s3.a(11);
            this.f7091a.put("usnat", aVar);
        } else if (str.equals("usca")) {
            aVar = new s3.a(3);
            this.f7091a.put("usca", aVar);
        } else if (str.equals("usva")) {
            aVar = new s3.a(19);
            this.f7091a.put("usva", aVar);
        } else if (str.equals("usco")) {
            aVar = new s3.a(4);
            this.f7091a.put("usco", aVar);
        } else if (str.equals("usut")) {
            aVar = new s3.a(18);
            this.f7091a.put("usut", aVar);
        } else if (str.equals("usct")) {
            aVar = new s3.a(5);
            this.f7091a.put("usct", aVar);
        } else if (str.equals("usfl")) {
            aVar = new s3.a(7);
            this.f7091a.put("usfl", aVar);
        } else if (str.equals("usmt")) {
            aVar = new s3.a(10);
            this.f7091a.put("usmt", aVar);
        } else if (str.equals("usor")) {
            aVar = new s3.a(15);
            this.f7091a.put("usor", aVar);
        } else if (str.equals("ustx")) {
            aVar = new s3.a(17);
            this.f7091a.put("ustx", aVar);
        } else if (str.equals("usde")) {
            aVar = new s3.a(6);
            this.f7091a.put("usde", aVar);
        } else if (str.equals("usia")) {
            aVar = new s3.a(8);
            this.f7091a.put("usia", aVar);
        } else if (str.equals("usne")) {
            aVar = new s3.a(12);
            this.f7091a.put("usne", aVar);
        } else if (str.equals("usnh")) {
            aVar = new s3.a(13);
            this.f7091a.put("usnh", aVar);
        } else if (str.equals("usnj")) {
            aVar = new s3.a(14);
            this.f7091a.put("usnj", aVar);
        } else if (str.equals("ustn")) {
            aVar = new s3.a(16);
            this.f7091a.put("ustn", aVar);
        } else if (str.equals("usmn")) {
            aVar = new s3.a(9);
            this.f7091a.put("usmn", aVar);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.g(str2, obj);
            this.f7093c = true;
            return;
        }
        throw new q3.b(str + "." + str2 + " not found");
    }
}
