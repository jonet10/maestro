package y8;

import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k extends d9.a {

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern[][] f11848e = {new Pattern[]{null, null}, new Pattern[]{Pattern.compile("^<(?:script|pre|style)(?:\\s|>|$)", 2), Pattern.compile("</(?:script|pre|style)>", 2)}, new Pattern[]{Pattern.compile("^<!--"), Pattern.compile("-->")}, new Pattern[]{Pattern.compile("^<[?]"), Pattern.compile("\\?>")}, new Pattern[]{Pattern.compile("^<![A-Z]"), Pattern.compile(">")}, new Pattern[]{Pattern.compile("^<!\\[CDATA\\["), Pattern.compile("\\]\\]>")}, new Pattern[]{Pattern.compile("^</?(?:address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|nav|noframes|ol|optgroup|option|p|param|section|source|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul)(?:\\s|[/]?[>]|$)", 2), null}, new Pattern[]{Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>])\\s*$", 2), null}};

    /* renamed from: b, reason: collision with root package name */
    public final Pattern f11850b;

    /* renamed from: a, reason: collision with root package name */
    public final b9.i f11849a = new b9.i(0);

    /* renamed from: c, reason: collision with root package name */
    public boolean f11851c = false;

    /* renamed from: d, reason: collision with root package name */
    public f8.q f11852d = new f8.q(4);

    public k(Pattern pattern) {
        this.f11850b = pattern;
    }

    @Override // d9.a
    public final void a(CharSequence charSequence) {
        f8.q qVar = this.f11852d;
        StringBuilder sb = (StringBuilder) qVar.f4965c;
        if (qVar.f4964b != 0) {
            sb.append('\n');
        }
        sb.append(charSequence);
        qVar.f4964b++;
        Pattern pattern = this.f11850b;
        if (pattern == null || !pattern.matcher(charSequence).find()) {
            return;
        }
        this.f11851c = true;
    }

    @Override // d9.a
    public final void c() {
        Object obj = this.f11852d.f4965c;
        this.f11852d = null;
    }

    @Override // d9.a
    public final b9.a d() {
        return this.f11849a;
    }

    @Override // d9.a
    public final a g(h hVar) {
        if (this.f11851c) {
            return null;
        }
        if (hVar.h && this.f11850b == null) {
            return null;
        }
        return a.a(hVar.f11833b);
    }
}
