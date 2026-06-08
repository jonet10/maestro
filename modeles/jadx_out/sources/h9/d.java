package h9;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f5495a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f5496b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f5497c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f5498d;

    /* renamed from: e, reason: collision with root package name */
    public final Integer f5499e;
    public final Integer f;
    public final Integer g;
    public final Integer h;
    public final Integer i;
    public final Integer j;

    /* renamed from: k, reason: collision with root package name */
    public final Integer f5500k;

    /* renamed from: l, reason: collision with root package name */
    public final Integer f5501l;

    /* renamed from: m, reason: collision with root package name */
    public final Integer f5502m;

    /* renamed from: n, reason: collision with root package name */
    public final Integer f5503n;

    /* renamed from: o, reason: collision with root package name */
    public final Integer f5504o;

    /* renamed from: p, reason: collision with root package name */
    public final Integer f5505p;

    public d(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16) {
        this.f5495a = num;
        this.f5496b = num2;
        this.f5497c = num3;
        this.f5498d = num4;
        this.f5499e = num5;
        this.f = num6;
        this.g = num7;
        this.h = num8;
        this.i = num9;
        this.j = num10;
        this.f5500k = num11;
        this.f5501l = num12;
        this.f5502m = num13;
        this.f5503n = num14;
        this.f5504o = num15;
        this.f5505p = num16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return kotlin.jvm.internal.l.a(this.f5495a, dVar.f5495a) && kotlin.jvm.internal.l.a(this.f5496b, dVar.f5496b) && kotlin.jvm.internal.l.a(this.f5497c, dVar.f5497c) && kotlin.jvm.internal.l.a(this.f5498d, dVar.f5498d) && kotlin.jvm.internal.l.a(this.f5499e, dVar.f5499e) && kotlin.jvm.internal.l.a(this.f, dVar.f) && kotlin.jvm.internal.l.a(this.g, dVar.g) && kotlin.jvm.internal.l.a(this.h, dVar.h) && kotlin.jvm.internal.l.a(this.i, dVar.i) && kotlin.jvm.internal.l.a(this.j, dVar.j) && kotlin.jvm.internal.l.a(this.f5500k, dVar.f5500k) && kotlin.jvm.internal.l.a(this.f5501l, dVar.f5501l) && kotlin.jvm.internal.l.a(this.f5502m, dVar.f5502m) && kotlin.jvm.internal.l.a(this.f5503n, dVar.f5503n) && kotlin.jvm.internal.l.a(this.f5504o, dVar.f5504o) && kotlin.jvm.internal.l.a(this.f5505p, dVar.f5505p);
    }

    public final int hashCode() {
        Integer num = this.f5495a;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.f5496b;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.f5497c;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.f5498d;
        int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.f5499e;
        int hashCode5 = (hashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.f;
        int hashCode6 = (hashCode5 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.g;
        int hashCode7 = (hashCode6 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.h;
        int hashCode8 = (hashCode7 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.i;
        int hashCode9 = (hashCode8 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.j;
        int hashCode10 = (hashCode9 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.f5500k;
        int hashCode11 = (hashCode10 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Integer num12 = this.f5501l;
        int hashCode12 = (hashCode11 + (num12 == null ? 0 : num12.hashCode())) * 31;
        Integer num13 = this.f5502m;
        int hashCode13 = (hashCode12 + (num13 == null ? 0 : num13.hashCode())) * 31;
        Integer num14 = this.f5503n;
        int hashCode14 = (hashCode13 + (num14 == null ? 0 : num14.hashCode())) * 31;
        Integer num15 = this.f5504o;
        int hashCode15 = (hashCode14 + (num15 == null ? 0 : num15.hashCode())) * 31;
        Integer num16 = this.f5505p;
        return hashCode15 + (num16 != null ? num16.hashCode() : 0);
    }

    public final String toString() {
        return "ChoiceStyleSheet(dividerColor=" + this.f5495a + ", tabBackgroundColor=" + this.f5496b + ", searchBarBackgroundColor=" + this.f5497c + ", searchBarForegroundColor=" + this.f5498d + ", toggleActiveColor=" + this.f5499e + ", toggleInactiveColor=" + this.f + ", globalBackgroundColor=" + this.g + ", titleTextColor=" + this.h + ", bodyTextColor=" + this.i + ", tabTextColor=" + this.j + ", menuTextColor=" + this.f5500k + ", linkTextColor=" + this.f5501l + ", buttonTextColor=" + this.f5502m + ", buttonDisabledTextColor=" + this.f5503n + ", buttonBackgroundColor=" + this.f5504o + ", buttonDisabledBackgroundColor=" + this.f5505p + ')';
    }
}
