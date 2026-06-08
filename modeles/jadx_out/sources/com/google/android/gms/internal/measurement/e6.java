package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class e6 {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f2560a;

    static {
        char[] cArr = new char[80];
        f2560a = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static void a(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                a(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        c(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i6 = 1; i6 < str.length(); i6++) {
                char charAt = str.charAt(i6);
                if (Character.isUpperCase(charAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(charAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            a5 a5Var = a5.f2490l;
            sb.append(t0.f.N(new a5(((String) obj).getBytes(r5.f2778a))));
            sb.append('\"');
            return;
        }
        if (obj instanceof a5) {
            sb.append(": \"");
            sb.append(t0.f.N((a5) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof l5) {
            sb.append(" {");
            b((l5) obj, sb, i + 2);
            sb.append("\n");
            c(i, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i10 = i + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        a(sb, i10, "key", entry.getKey());
        a(sb, i10, "value", entry.getValue());
        sb.append("\n");
        c(i, sb);
        sb.append("}");
    }

    public static void b(l5 l5Var, StringBuilder sb, int i) {
        int i6;
        int i10;
        boolean equals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = l5Var.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i11 = 0;
        while (true) {
            i6 = 3;
            if (i11 >= length) {
                break;
            }
            Method method3 = declaredMethods[i11];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i11++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i6);
            if (!substring.endsWith("List") || substring.endsWith("OrBuilderList") || substring.equals("List") || (method2 = (Method) entry.getValue()) == null) {
                i10 = i6;
            } else {
                i10 = i6;
                if (method2.getReturnType().equals(List.class)) {
                    a(sb, i, substring.substring(0, substring.length() - 4), l5.m(method2, l5Var, new Object[0]));
                    i6 = i10;
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                a(sb, i, substring.substring(0, substring.length() - 3), l5.m(method, l5Var, new Object[0]));
            } else if (hashSet.contains("set".concat(substring)) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(substring.substring(0, substring.length() - 5))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object m10 = l5.m(method4, l5Var, new Object[0]);
                    if (method5 != null) {
                        if (!((Boolean) l5.m(method5, l5Var, new Object[0])).booleanValue()) {
                        }
                        a(sb, i, substring, m10);
                    } else if (m10 instanceof Boolean) {
                        if (!((Boolean) m10).booleanValue()) {
                        }
                        a(sb, i, substring, m10);
                    } else if (m10 instanceof Integer) {
                        if (((Integer) m10).intValue() == 0) {
                        }
                        a(sb, i, substring, m10);
                    } else if (m10 instanceof Float) {
                        if (Float.floatToRawIntBits(((Float) m10).floatValue()) == 0) {
                        }
                        a(sb, i, substring, m10);
                    } else if (m10 instanceof Double) {
                        if (Double.doubleToRawLongBits(((Double) m10).doubleValue()) == 0) {
                        }
                        a(sb, i, substring, m10);
                    } else {
                        if (m10 instanceof String) {
                            equals = m10.equals("");
                        } else if (m10 instanceof a5) {
                            equals = m10.equals(a5.f2490l);
                        } else if (m10 instanceof s4) {
                            if (m10 == ((l5) ((l5) ((s4) m10)).n(6))) {
                            }
                            a(sb, i, substring, m10);
                        } else {
                            if ((m10 instanceof Enum) && ((Enum) m10).ordinal() == 0) {
                            }
                            a(sb, i, substring, m10);
                        }
                        if (equals) {
                        }
                        a(sb, i, substring, m10);
                    }
                }
            }
            i6 = i10;
        }
        r6 r6Var = l5Var.zzc;
        if (r6Var != null) {
            for (int i12 = 0; i12 < r6Var.f2780a; i12++) {
                a(sb, i, String.valueOf(r6Var.f2781b[i12] >>> 3), r6Var.f2782c[i12]);
            }
        }
    }

    public static void c(int i, StringBuilder sb) {
        while (i > 0) {
            int i6 = 80;
            if (i <= 80) {
                i6 = i;
            }
            sb.append(f2560a, 0, i6);
            i -= i6;
        }
    }
}
