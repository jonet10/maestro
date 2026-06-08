package d3;

import a4.x;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f3556a;

    public e(String str) {
        str.getClass();
        this.f3556a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && l.a(this.f3556a, ((e) obj).f3556a);
    }

    public final int hashCode() {
        return this.f3556a.hashCode();
    }

    public final String toString() {
        return x.m(new StringBuilder("SessionDetails(sessionId="), this.f3556a, ')');
    }
}
