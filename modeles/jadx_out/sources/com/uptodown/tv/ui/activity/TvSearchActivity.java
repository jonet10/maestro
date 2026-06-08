package com.uptodown.tv.ui.activity;

import android.os.Bundle;
import android.speech.SpeechRecognizer;
import f5.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class TvSearchActivity extends a {

    /* renamed from: l, reason: collision with root package name */
    public SpeechRecognizer f3412l;

    @Override // f5.a, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558852);
        if (SpeechRecognizer.isRecognitionAvailable(this)) {
            this.f3412l = SpeechRecognizer.createSpeechRecognizer(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        if (this.f3412l != null && SpeechRecognizer.isRecognitionAvailable(this)) {
            SpeechRecognizer speechRecognizer = this.f3412l;
            speechRecognizer.getClass();
            speechRecognizer.stopListening();
            SpeechRecognizer speechRecognizer2 = this.f3412l;
            speechRecognizer2.getClass();
            speechRecognizer2.cancel();
            SpeechRecognizer speechRecognizer3 = this.f3412l;
            speechRecognizer3.getClass();
            speechRecognizer3.destroy();
        }
        this.f3412l = null;
        super.onPause();
    }
}
