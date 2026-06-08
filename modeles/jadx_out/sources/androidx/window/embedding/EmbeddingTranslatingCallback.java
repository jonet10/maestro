package androidx.window.embedding;

import android.annotation.SuppressLint;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.embedding.EmbeddingInterfaceCompat;
import j$.util.function.Consumer$CC;
import java.util.List;
import java.util.function.Consumer;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@ExperimentalWindowApi
@SuppressLint({"NewApi"})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class EmbeddingTranslatingCallback implements Consumer<List<? extends androidx.window.extensions.embedding.SplitInfo>> {
    private final EmbeddingAdapter adapter;
    private final EmbeddingInterfaceCompat.EmbeddingCallbackInterface callback;

    public EmbeddingTranslatingCallback(EmbeddingInterfaceCompat.EmbeddingCallbackInterface embeddingCallbackInterface, EmbeddingAdapter embeddingAdapter) {
        embeddingCallbackInterface.getClass();
        embeddingAdapter.getClass();
        this.callback = embeddingCallbackInterface;
        this.adapter = embeddingAdapter;
    }

    @Override // java.util.function.Consumer
    public void accept(List<? extends androidx.window.extensions.embedding.SplitInfo> list) {
        list.getClass();
        this.callback.onSplitInfoChanged(this.adapter.translate(list));
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }
}
