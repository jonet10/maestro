package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import d7.l;
import d7.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    final /* synthetic */ l $afterTextChanged;
    final /* synthetic */ r $beforeTextChanged;
    final /* synthetic */ r $onTextChanged;

    public TextViewKt$addTextChangedListener$textWatcher$1(l lVar, r rVar, r rVar2) {
        this.$afterTextChanged = lVar;
        this.$beforeTextChanged = rVar;
        this.$onTextChanged = rVar2;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.$afterTextChanged.invoke(editable);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i6, int i10) {
        this.$beforeTextChanged.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i6), Integer.valueOf(i10));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i6, int i10) {
        this.$onTextChanged.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i6), Integer.valueOf(i10));
    }
}
