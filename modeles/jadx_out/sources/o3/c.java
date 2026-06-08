package o3;

import com.google.android.gms.internal.measurement.i5;
import j$.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Pattern;
import p3.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f8151d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ArrayList arrayList, int i) {
        super(false);
        this.f8151d = i;
        switch (i) {
            case 5:
                super(true);
                setValue(arrayList);
                break;
            default:
                setValue(arrayList);
                break;
        }
    }

    @Override // o3.a
    public final void a(String str) {
        switch (this.f8151d) {
            case 0:
                try {
                    ArrayList arrayList = new ArrayList();
                    int i = 12;
                    int a8 = p3.e.a(str.substring(0, 12));
                    for (int i6 = 0; i6 < a8; i6++) {
                        int i10 = i + 6;
                        int a10 = p3.e.a(str.substring(i, i10));
                        int i11 = i + 8;
                        int a11 = p3.e.a(str.substring(i10, i11));
                        int i12 = i + 20;
                        try {
                            int a12 = p3.e.a(str.substring(i11, i12));
                            for (int i13 = 0; i13 < a12; i13++) {
                                i12 = str.charAt(i12) == '1' ? i12 + 33 : i12 + 17;
                            }
                            String substring = str.substring(i11, i12);
                            ArrayList a13 = p3.g.a(substring);
                            i = substring.length() + i11;
                            arrayList.add(new f(a13, a10, a11));
                        } catch (Exception e10) {
                            throw new g(e10);
                        }
                    }
                    this.f8150c = arrayList;
                    return;
                } catch (Exception e11) {
                    throw new q3.a(e11);
                }
            case 1:
                try {
                    this.f8150c = Boolean.valueOf(i5.k(str));
                    return;
                } catch (Exception e12) {
                    throw new q3.a(e12);
                }
            case 2:
                try {
                    this.f8150c = p3.a.a(str);
                    return;
                } catch (Exception e13) {
                    throw new q3.a(e13);
                }
            case 3:
                try {
                    this.f8150c = p3.c.a(str);
                    return;
                } catch (Exception e14) {
                    throw new q3.a(e14);
                }
            case 4:
                try {
                    this.f8150c = p3.i.a(str);
                    return;
                } catch (Exception e15) {
                    throw new q3.a(e15);
                }
            default:
                try {
                    this.f8150c = j.a(str);
                    return;
                } catch (Exception e16) {
                    throw new q3.a(e16);
                }
        }
    }

    @Override // o3.a
    public final String b() {
        switch (this.f8151d) {
            case 0:
                try {
                    List<f> list = (List) this.f8150c;
                    StringBuilder sb = new StringBuilder();
                    sb.append(p3.e.b(list.size(), 12));
                    for (f fVar : list) {
                        sb.append(p3.e.b(fVar.f8155a, 6));
                        sb.append(p3.e.b(fVar.f8156b, 2));
                        sb.append(p3.g.b(fVar.f8157c));
                    }
                    return sb.toString();
                } catch (Exception e10) {
                    throw new a1.b(e10);
                }
            case 1:
                try {
                    return i5.p((Boolean) this.f8150c);
                } catch (Exception e11) {
                    throw new a1.b(e11);
                }
            case 2:
                try {
                    ZonedDateTime zonedDateTime = (ZonedDateTime) this.f8150c;
                    Pattern pattern = p3.a.f8419a;
                    return zonedDateTime != null ? p3.h.a(zonedDateTime.toInstant().toEpochMilli() / 100) : p3.h.a(0L);
                } catch (Exception e12) {
                    throw new a1.b(e12);
                }
            case 3:
                try {
                    return p3.c.b((List) this.f8150c);
                } catch (Exception e13) {
                    throw new a1.b(e13);
                }
            case 4:
                try {
                    return p3.i.b((String) this.f8150c);
                } catch (Exception e14) {
                    throw new a1.b(e14);
                }
            default:
                try {
                    return j.b((List) this.f8150c);
                } catch (Exception e15) {
                    throw new a1.b(e15);
                }
        }
    }

    @Override // o3.a
    public final String c(int i, String str) {
        switch (this.f8151d) {
            case 0:
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.substring(i, i + 12));
                    int a8 = p3.e.a(sb.toString());
                    int length = i + sb.length();
                    for (int i6 = 0; i6 < a8; i6++) {
                        String substring = str.substring(length, length + 6);
                        int length2 = length + substring.length();
                        sb.append(substring);
                        String substring2 = str.substring(length2, length2 + 2);
                        int length3 = length2 + substring2.length();
                        sb.append(substring2);
                        int i10 = length3 + 12;
                        try {
                            int a10 = p3.e.a(str.substring(length3, i10));
                            for (int i11 = 0; i11 < a10; i11++) {
                                i10 = str.charAt(i10) == '1' ? i10 + 33 : i10 + 17;
                            }
                            String substring3 = str.substring(length3, i10);
                            length = length3 + substring3.length();
                            sb.append(substring3);
                        } catch (Exception e10) {
                            throw new g(e10);
                        }
                    }
                    return sb.toString();
                } catch (Exception e11) {
                    throw new g(e11);
                }
            case 1:
                try {
                    return str.substring(i, i + 1);
                } catch (Exception e12) {
                    throw new g(e12);
                }
            case 2:
                try {
                    return str.substring(i, i + 36);
                } catch (Exception e13) {
                    throw new g(e13);
                }
            case 3:
                int i12 = i + 12;
                try {
                    int a11 = p3.e.a(str.substring(i, i12));
                    for (int i13 = 0; i13 < a11; i13++) {
                        i12 = (str.charAt(i12) == '1' ? str.indexOf("11", str.indexOf("11", i12 + 1) + 2) : str.indexOf("11", i12 + 1)) + 2;
                    }
                    return str.substring(i, i12);
                } catch (Exception e14) {
                    throw new g(e14);
                }
            case 4:
                try {
                    return str.substring(i, 12 + i);
                } catch (Exception e15) {
                    throw new g(e15);
                }
            default:
                int i14 = i + 16;
                try {
                    int a12 = p3.e.a(str.substring(i, i14));
                    if (str.charAt(i14) != '1') {
                        return str.substring(i, i + 17 + a12);
                    }
                    int i15 = i + 17;
                    String substring4 = str.substring(i, i15);
                    int i16 = i + 29;
                    try {
                        int a13 = p3.e.a(str.substring(i15, i16));
                        for (int i17 = 0; i17 < a13; i17++) {
                            i16 = str.charAt(i16) == '1' ? i16 + 33 : i16 + 17;
                        }
                        return substring4.concat(str.substring(i15, i16));
                    } catch (Exception e16) {
                        throw new g(e16);
                    }
                } catch (Exception e17) {
                    throw new g(e17);
                }
        }
    }

    @Override // o3.a, o3.b
    public Object getValue() {
        switch (this.f8151d) {
            case 3:
                return new ArrayList((Collection) this.f8150c);
            case 4:
            default:
                return super.getValue();
            case 5:
                return new ArrayList((Collection) this.f8150c);
        }
    }

    @Override // o3.a, o3.b
    public void setValue(Object obj) {
        switch (this.f8151d) {
            case 3:
                super.setValue(new ArrayList(new TreeSet((List) obj)));
                break;
            case 4:
            default:
                super.setValue(obj);
                break;
            case 5:
                super.setValue(new ArrayList(new TreeSet((List) obj)));
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Boolean bool) {
        super(true);
        this.f8151d = 1;
        setValue(bool);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ZonedDateTime zonedDateTime) {
        super(true);
        this.f8151d = 2;
        setValue(zonedDateTime);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str) {
        super(true);
        this.f8151d = 4;
        setValue(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(boolean z9) {
        super(z9);
        this.f8151d = 3;
    }
}
