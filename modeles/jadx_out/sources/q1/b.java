package q1;

import b2.t1;
import com.google.android.gms.internal.measurement.i5;
import e1.k2;
import java.util.Arrays;
import l1.d;
import l1.g;
import l1.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final g f8636a;

    /* renamed from: b, reason: collision with root package name */
    public static final i f8637b;

    /* renamed from: c, reason: collision with root package name */
    public static final i f8638c;

    /* renamed from: d, reason: collision with root package name */
    public static final i f8639d;

    static {
        int i = g.f7060l;
        Object[] objArr = new Object[15];
        objArr[0] = "_in";
        objArr[1] = "_xa";
        objArr[2] = "_xu";
        objArr[3] = "_aq";
        objArr[4] = "_aa";
        objArr[5] = "_ai";
        System.arraycopy(new String[]{"_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"}, 0, objArr, 6, 9);
        f8636a = g.k(15, objArr);
        l1.b bVar = d.f7053b;
        Object[] objArr2 = {"_e", "_f", "_iap", "_s", "_au", "_ui", "_cd"};
        d0.b.u(7, objArr2);
        f8637b = d.g(7, objArr2);
        Object[] objArr3 = {"auto", "app", "am"};
        d0.b.u(3, objArr3);
        f8638c = d.g(3, objArr3);
        Object[] objArr4 = {"_r", "_dbg"};
        d0.b.u(2, objArr4);
        f8639d = d.g(2, objArr4);
        t1.r(4, "initialCapacity");
        String[] strArr = k2.i;
        d0.b.u(15, strArr);
        Object[] copyOf = Arrays.copyOf(new Object[4], i5.q(4, 15));
        System.arraycopy(strArr, 0, copyOf, 0, 15);
        String[] strArr2 = k2.j;
        d0.b.u(15, strArr2);
        if (copyOf.length < 30) {
            copyOf = Arrays.copyOf(copyOf, i5.q(copyOf.length, 30));
        }
        System.arraycopy(strArr2, 0, copyOf, 15, 15);
        d.g(30, copyOf);
        Object[] objArr5 = {"^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$"};
        d0.b.u(2, objArr5);
        d.g(2, objArr5);
    }
}
