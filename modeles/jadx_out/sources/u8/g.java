package u8;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10780a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10781b;

    /* renamed from: c, reason: collision with root package name */
    public String f10782c;

    public g(ArrayList arrayList) {
        this.f10780a = arrayList;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        if (objArr == null) {
            objArr = n8.c.f8115b;
        }
        if (name.equals("supports") && Boolean.TYPE == returnType) {
            return Boolean.TRUE;
        }
        if (name.equals("unsupported") && Void.TYPE == returnType) {
            this.f10781b = true;
            return null;
        }
        boolean equals = name.equals("protocols");
        ArrayList arrayList = this.f10780a;
        if (equals && objArr.length == 0) {
            return arrayList;
        }
        if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
            Object obj2 = objArr[0];
            if (obj2 instanceof List) {
                List list = (List) obj2;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (arrayList.contains(list.get(i))) {
                        String str = (String) list.get(i);
                        this.f10782c = str;
                        return str;
                    }
                }
                String str2 = (String) arrayList.get(0);
                this.f10782c = str2;
                return str2;
            }
        }
        if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
            return method.invoke(this, objArr);
        }
        this.f10782c = (String) objArr[0];
        return null;
    }
}
