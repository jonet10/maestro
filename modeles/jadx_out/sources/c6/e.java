package c6;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import j$.util.DesugarCollections;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e implements Appendable, CharSequence {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f2424b = new ArrayDeque(8);

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f2423a = new StringBuilder((CharSequence) "");

    public e() {
        b(0, "");
    }

    public static void c(e eVar, Object obj, int i, int i6) {
        if (obj != null) {
            if (!obj.getClass().isArray()) {
                eVar.f2424b.push(new c(obj, i, i6, 33));
                return;
            }
            for (Object obj2 : (Object[]) obj) {
                c(eVar, obj2, i, i6);
            }
        }
    }

    public final void a(char c9) {
        this.f2423a.append(c9);
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i6) {
        CharSequence subSequence = charSequence.subSequence(i, i6);
        StringBuilder sb = this.f2423a;
        b(sb.length(), subSequence);
        sb.append(subSequence);
        return this;
    }

    public final void b(int i, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            boolean z9 = spanned instanceof d;
            Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
            int length = spans != null ? spans.length : 0;
            if (length > 0) {
                ArrayDeque arrayDeque = this.f2424b;
                if (!z9) {
                    for (int i6 = 0; i6 < length; i6++) {
                        Object obj = spans[i6];
                        arrayDeque.push(new c(obj, spanned.getSpanStart(obj) + i, spanned.getSpanEnd(obj) + i, spanned.getSpanFlags(obj)));
                    }
                    return;
                }
                for (int i10 = length - 1; i10 >= 0; i10--) {
                    Object obj2 = spans[i10];
                    arrayDeque.push(new c(obj2, spanned.getSpanStart(obj2) + i, spanned.getSpanEnd(obj2) + i, spanned.getSpanFlags(obj2)));
                }
            }
        }
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.f2423a.charAt(i);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f2423a.length();
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i6) {
        List<c> list;
        int i10;
        StringBuilder sb = this.f2423a;
        int length = sb.length();
        if (i6 <= i || i < 0 || i6 > length) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayDeque arrayDeque = this.f2424b;
            if (i == 0 && length == i6) {
                ArrayList arrayList = new ArrayList(arrayDeque);
                Collections.reverse(arrayList);
                list = DesugarCollections.unmodifiableList(arrayList);
            } else {
                ArrayList arrayList2 = new ArrayList(0);
                Iterator descendingIterator = arrayDeque.descendingIterator();
                while (descendingIterator.hasNext()) {
                    c cVar = (c) descendingIterator.next();
                    int i11 = cVar.f2420b;
                    if ((i11 >= i && i11 < i6) || (((i10 = cVar.f2421c) <= i6 && i10 > i) || (i11 < i && i10 > i6))) {
                        arrayList2.add(cVar);
                    }
                }
                list = DesugarCollections.unmodifiableList(arrayList2);
            }
        }
        if (list.isEmpty()) {
            return sb.subSequence(i, i6);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb.subSequence(i, i6));
        int length2 = spannableStringBuilder.length();
        for (c cVar2 : list) {
            int max = Math.max(0, cVar2.f2420b - i);
            spannableStringBuilder.setSpan(cVar2.f2419a, max, Math.min(length2, (cVar2.f2421c - cVar2.f2420b) + max), cVar2.f2422d);
        }
        return spannableStringBuilder;
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f2423a.toString();
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c9) {
        this.f2423a.append(c9);
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        StringBuilder sb = this.f2423a;
        b(sb.length(), charSequence);
        sb.append(charSequence);
        return this;
    }
}
