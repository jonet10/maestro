package l7;

import java.util.List;
import java.util.regex.Matcher;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Matcher f7172a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f7173b;

    /* renamed from: c, reason: collision with root package name */
    public h f7174c;

    public i(Matcher matcher, CharSequence charSequence) {
        charSequence.getClass();
        this.f7172a = matcher;
        this.f7173b = charSequence;
    }

    public final List a() {
        if (this.f7174c == null) {
            this.f7174c = new h(this);
        }
        h hVar = this.f7174c;
        hVar.getClass();
        return hVar;
    }

    public final i7.d b() {
        Matcher matcher = this.f7172a;
        return t0.f.K(matcher.start(), matcher.end());
    }

    public final i c() {
        Matcher matcher = this.f7172a;
        int end = matcher.end() + (matcher.end() == matcher.start() ? 1 : 0);
        CharSequence charSequence = this.f7173b;
        if (end > charSequence.length()) {
            return null;
        }
        Matcher matcher2 = matcher.pattern().matcher(charSequence);
        matcher2.getClass();
        if (matcher2.find(end)) {
            return new i(matcher2, charSequence);
        }
        return null;
    }
}
