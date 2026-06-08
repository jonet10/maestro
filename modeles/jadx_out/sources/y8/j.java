package y8;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j extends d9.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11845a;

    /* renamed from: b, reason: collision with root package name */
    public final b9.a f11846b;

    /* renamed from: c, reason: collision with root package name */
    public final Serializable f11847c;

    public j() {
        this.f11845a = 1;
        this.f11846b = new b9.l();
        this.f11847c = new ArrayList();
    }

    @Override // d9.a
    public void a(CharSequence charSequence) {
        switch (this.f11845a) {
            case 1:
                ((ArrayList) this.f11847c).add(charSequence);
                break;
        }
    }

    @Override // d9.a
    public void c() {
        int i;
        switch (this.f11845a) {
            case 1:
                ArrayList arrayList = (ArrayList) this.f11847c;
                int size = arrayList.size() - 1;
                while (true) {
                    if (size >= 0) {
                        CharSequence charSequence = (CharSequence) arrayList.get(size);
                        int length = charSequence.length();
                        int i6 = 0;
                        while (true) {
                            if (i6 < length) {
                                char charAt = charSequence.charAt(i6);
                                if (charAt != ' ') {
                                    switch (charAt) {
                                    }
                                }
                                i6++;
                            } else {
                                i6 = -1;
                            }
                        }
                        if (i6 == -1) {
                            size--;
                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (i = 0; i < size + 1; i++) {
                    sb.append((CharSequence) arrayList.get(i));
                    sb.append('\n');
                }
                ((b9.l) this.f11846b).f = sb.toString();
                break;
        }
    }

    @Override // d9.a
    public final b9.a d() {
        switch (this.f11845a) {
            case 0:
                return (b9.h) this.f11846b;
            default:
                return (b9.l) this.f11846b;
        }
    }

    @Override // d9.a
    public void f(m mVar) {
        switch (this.f11845a) {
            case 0:
                mVar.f((String) this.f11847c, (b9.h) this.f11846b);
                break;
        }
    }

    @Override // d9.a
    public final a g(h hVar) {
        switch (this.f11845a) {
            case 0:
                return null;
            default:
                if (hVar.g >= 4) {
                    return new a(-1, hVar.f11834c + 4, false);
                }
                if (hVar.h) {
                    return a.a(hVar.f11836e);
                }
                return null;
        }
    }

    public j(int i, String str) {
        this.f11845a = 0;
        b9.h hVar = new b9.h();
        this.f11846b = hVar;
        hVar.f = i;
        this.f11847c = str;
    }
}
