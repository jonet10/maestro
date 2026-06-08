package o3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f8152d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8153e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(List list, int i) {
        super(true);
        this.f8152d = i;
        switch (i) {
            case 2:
                super(true);
                this.f8153e = list.size();
                setValue(list);
                break;
            default:
                this.f8153e = list.size();
                setValue(list);
                break;
        }
    }

    @Override // o3.a
    public final void a(String str) {
        switch (this.f8152d) {
            case 0:
                try {
                    this.f8150c = p3.d.a(str);
                    return;
                } catch (Exception e10) {
                    throw new q3.a(e10);
                }
            case 1:
                try {
                    this.f8150c = Integer.valueOf(p3.e.a(str));
                    return;
                } catch (Exception e11) {
                    throw new q3.a(e11);
                }
            default:
                try {
                    this.f8150c = p3.f.a(this.f8153e, str);
                    return;
                } catch (Exception e12) {
                    throw new q3.a(e12);
                }
        }
    }

    @Override // o3.a
    public final String b() {
        switch (this.f8152d) {
            case 0:
                try {
                    return p3.d.b(this.f8153e, (List) this.f8150c);
                } catch (Exception e10) {
                    throw new a1.b(e10);
                }
            case 1:
                try {
                    return p3.e.b(((Integer) this.f8150c).intValue(), this.f8153e);
                } catch (Exception e11) {
                    throw new a1.b(e11);
                }
            default:
                try {
                    return p3.f.b(this.f8153e, (List) this.f8150c);
                } catch (Exception e12) {
                    throw new a1.b(e12);
                }
        }
    }

    @Override // o3.a
    public final String c(int i, String str) {
        switch (this.f8152d) {
            case 0:
                try {
                    return str.substring(i, this.f8153e + i);
                } catch (Exception e10) {
                    throw new g(e10);
                }
            case 1:
                try {
                    return str.substring(i, this.f8153e + i);
                } catch (Exception e11) {
                    throw new g(e11);
                }
            default:
                try {
                    return str.substring(i, (2 * this.f8153e) + i);
                } catch (Exception e12) {
                    throw new g(e12);
                }
        }
    }

    @Override // o3.a, o3.b
    public Object getValue() {
        switch (this.f8152d) {
            case 0:
                return new ArrayList((Collection) this.f8150c);
            case 1:
            default:
                return super.getValue();
            case 2:
                return new ArrayList((Collection) this.f8150c);
        }
    }

    @Override // o3.a, o3.b
    public void setValue(Object obj) {
        switch (this.f8152d) {
            case 0:
                ArrayList arrayList = new ArrayList((List) obj);
                int size = arrayList.size();
                while (true) {
                    int i = this.f8153e;
                    if (size >= i) {
                        int size2 = arrayList.size();
                        List list = arrayList;
                        if (size2 > i) {
                            list = arrayList.subList(0, i);
                        }
                        super.setValue(list);
                        break;
                    } else {
                        arrayList.add(Boolean.FALSE);
                        size++;
                    }
                }
            case 1:
            default:
                super.setValue(obj);
                break;
            case 2:
                ArrayList arrayList2 = new ArrayList((List) obj);
                int size3 = arrayList2.size();
                while (true) {
                    int i6 = this.f8153e;
                    if (size3 >= i6) {
                        int size4 = arrayList2.size();
                        List list2 = arrayList2;
                        if (size4 > i6) {
                            list2 = arrayList2.subList(0, i6);
                        }
                        super.setValue(list2);
                        break;
                    } else {
                        arrayList2.add(0);
                        size3++;
                    }
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i, Integer num) {
        super(true);
        this.f8152d = 1;
        this.f8153e = i;
        setValue(num);
    }
}
