package f8;

import android.util.Log;
import com.google.android.gms.internal.measurement.i5;
import java.io.Serializable;
import java.net.ProtocolException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4959a;

    /* renamed from: b, reason: collision with root package name */
    public Serializable f4960b;

    /* renamed from: c, reason: collision with root package name */
    public int f4961c;

    /* renamed from: d, reason: collision with root package name */
    public Object f4962d;

    public o(String str, String[] strArr) {
        String sb;
        int i = 2;
        this.f4959a = 2;
        if (strArr.length == 0) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (String str2 : strArr) {
                if (sb2.length() > 1) {
                    sb2.append(",");
                }
                sb2.append(str2);
            }
            sb2.append("] ");
            sb = sb2.toString();
        }
        this.f4962d = sb;
        this.f4960b = str;
        Object[] objArr = {str, 23};
        if (!(str.length() <= 23)) {
            throw new IllegalArgumentException(String.format("tag \"%s\" is longer than the %d character maximum", objArr));
        }
        while (i <= 7 && !Log.isLoggable((String) this.f4960b, i)) {
            i++;
        }
        this.f4961c = i;
    }

    public static o d(String str) {
        int i;
        String str2;
        boolean startsWith = str.startsWith("HTTP/1.");
        m8.y yVar = m8.y.HTTP_1_0;
        if (startsWith) {
            i = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            int charAt = str.charAt(7) - '0';
            if (charAt != 0) {
                if (charAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                yVar = m8.y.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            i = 4;
        }
        int i6 = i + 3;
        if (str.length() < i6) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        try {
            int parseInt = Integer.parseInt(str.substring(i, i6));
            if (str.length() <= i6) {
                str2 = "";
            } else {
                if (str.charAt(i6) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                str2 = str.substring(i + 4);
            }
            return new o(yVar, parseInt, str2);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
    }

    public l1.n a() {
        l1.e eVar = (l1.e) this.f4962d;
        if (eVar != null) {
            throw eVar.a();
        }
        l1.n a8 = l1.n.a(this.f4961c, (Object[]) this.f4960b, this);
        l1.e eVar2 = (l1.e) this.f4962d;
        if (eVar2 == null) {
            return a8;
        }
        throw eVar2.a();
    }

    public void b(String str, Object... objArr) {
        if (this.f4961c <= 3) {
            String str2 = (String) this.f4960b;
            if (objArr.length > 0) {
                str = String.format(Locale.US, str, objArr);
            }
            Log.d(str2, ((String) this.f4962d).concat(str));
        }
    }

    public String c() {
        StringBuilder sb = new StringBuilder("$");
        int i = this.f4961c + 1;
        for (int i6 = 0; i6 < i; i6++) {
            Object obj = ((Object[]) this.f4960b)[i6];
            if (obj instanceof b8.e) {
                b8.e eVar = (b8.e) obj;
                boolean a8 = kotlin.jvm.internal.l.a(eVar.getKind(), b8.i.i);
                int[] iArr = (int[]) this.f4962d;
                if (!a8) {
                    int i10 = iArr[i6];
                    if (i10 >= 0) {
                        sb.append(".");
                        sb.append(eVar.f(i10));
                    }
                } else if (iArr[i6] != -1) {
                    sb.append("[");
                    sb.append(((int[]) this.f4962d)[i6]);
                    sb.append("]");
                }
            } else if (obj != n.f4958a) {
                sb.append("['");
                sb.append(obj);
                sb.append("']");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.Serializable, java.lang.Object[]] */
    public void e(Object obj, Object obj2) {
        int i = (this.f4961c + 1) * 2;
        Object[] objArr = (Object[]) this.f4960b;
        if (i > objArr.length) {
            this.f4960b = Arrays.copyOf(objArr, i5.q(objArr.length, i));
        }
        if (obj == null) {
            String valueOf = String.valueOf(obj2);
            StringBuilder sb = new StringBuilder(valueOf.length() + 24);
            sb.append("null key in entry: null=");
            sb.append(valueOf);
            throw new NullPointerException(sb.toString());
        }
        if (obj2 == null) {
            String valueOf2 = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 26);
            sb2.append("null value in entry: ");
            sb2.append(valueOf2);
            sb2.append("=null");
            throw new NullPointerException(sb2.toString());
        }
        Object[] objArr2 = (Object[]) this.f4960b;
        int i6 = this.f4961c;
        int i10 = i6 * 2;
        objArr2[i10] = obj;
        objArr2[i10 + 1] = obj2;
        this.f4961c = i6 + 1;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.Serializable, java.lang.Object[]] */
    public void f(Collection collection) {
        if (collection instanceof Collection) {
            int size = (collection.size() + this.f4961c) * 2;
            Object[] objArr = (Object[]) this.f4960b;
            if (size > objArr.length) {
                this.f4960b = Arrays.copyOf(objArr, i5.q(objArr.length, size));
            }
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            e(entry.getKey(), entry.getValue());
        }
    }

    public String toString() {
        switch (this.f4959a) {
            case 0:
                return c();
            case 3:
                String str = (String) this.f4962d;
                StringBuilder sb = new StringBuilder();
                sb.append(((m8.y) this.f4960b) == m8.y.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
                sb.append(' ');
                sb.append(this.f4961c);
                sb.append(' ');
                sb.append(str);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ o() {
        this.f4959a = 0;
    }

    public o(m8.y yVar, int i, String str) {
        this.f4959a = 3;
        this.f4960b = yVar;
        this.f4961c = i;
        this.f4962d = str;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Serializable, java.lang.Object[]] */
    public o(int i) {
        this.f4959a = 1;
        this.f4960b = new Object[i * 2];
        this.f4961c = 0;
    }
}
