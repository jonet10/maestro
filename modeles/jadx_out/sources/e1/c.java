package e1;

import androidx.collection.ArrayMap;
import java.util.HashSet;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends p4 {

    /* renamed from: m, reason: collision with root package name */
    public String f3828m;

    /* renamed from: n, reason: collision with root package name */
    public HashSet f3829n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayMap f3830o;

    /* renamed from: p, reason: collision with root package name */
    public Long f3831p;

    /* renamed from: q, reason: collision with root package name */
    public Long f3832q;

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:96)
        */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final java.util.ArrayList k(java.lang.String r41, java.util.List r42, java.util.List r43, java.lang.Long r44, java.lang.Long r45, boolean r46) {
        /*
            Method dump skipped, instructions count: 2782
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.c.k(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long, boolean):java.util.ArrayList");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final d5 l(Integer num) {
        if (this.f3830o.containsKey(num)) {
            return (d5) this.f3830o.get(num);
        }
        d5 d5Var = new d5(this, this.f3828m);
        this.f3830o.put(num, d5Var);
        return d5Var;
    }

    @Override // e1.p4
    public final void j() {
    }
}
