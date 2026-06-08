package androidx.leanback.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import androidx.leanback.widget.SearchOrbView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class SpeechOrbView extends SearchOrbView {
    private int mCurrentLevel;
    private boolean mListening;
    private SearchOrbView.Colors mListeningOrbColors;
    private SearchOrbView.Colors mNotListeningOrbColors;
    private final float mSoundLevelMaxZoom;

    public SpeechOrbView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentLevel = 0;
        this.mListening = false;
        Resources resources = context.getResources();
        this.mSoundLevelMaxZoom = resources.getFraction(androidx.leanback.R.fraction.lb_search_bar_speech_orb_max_level_zoom, 1, 1);
        this.mNotListeningOrbColors = new SearchOrbView.Colors(resources.getColor(androidx.leanback.R.color.lb_speech_orb_not_recording), resources.getColor(androidx.leanback.R.color.lb_speech_orb_not_recording_pulsed), resources.getColor(androidx.leanback.R.color.lb_speech_orb_not_recording_icon));
        this.mListeningOrbColors = new SearchOrbView.Colors(resources.getColor(androidx.leanback.R.color.lb_speech_orb_recording), resources.getColor(androidx.leanback.R.color.lb_speech_orb_recording), 0);
        showNotListening();
    }

    @Override // androidx.leanback.widget.SearchOrbView
    public int getLayoutResourceId() {
        return androidx.leanback.R.layout.lb_speech_orb;
    }

    public void setListeningOrbColors(SearchOrbView.Colors colors) {
        this.mListeningOrbColors = colors;
    }

    public void setNotListeningOrbColors(SearchOrbView.Colors colors) {
        this.mNotListeningOrbColors = colors;
    }

    public void setSoundLevel(int i) {
        if (this.mListening) {
            int i6 = this.mCurrentLevel;
            if (i > i6) {
                this.mCurrentLevel = ((i - i6) / 2) + i6;
            } else {
                this.mCurrentLevel = (int) (i6 * 0.7f);
            }
            scaleOrbViewOnly((((this.mSoundLevelMaxZoom - getFocusedZoom()) * this.mCurrentLevel) / 100.0f) + 1.0f);
        }
    }

    public void showListening() {
        setOrbColors(this.mListeningOrbColors);
        setOrbIcon(getResources().getDrawable(androidx.leanback.R.drawable.lb_ic_search_mic));
        animateOnFocus(true);
        enableOrbColorAnimation(false);
        scaleOrbViewOnly(1.0f);
        this.mCurrentLevel = 0;
        this.mListening = true;
    }

    public void showNotListening() {
        setOrbColors(this.mNotListeningOrbColors);
        setOrbIcon(getResources().getDrawable(androidx.leanback.R.drawable.lb_ic_search_mic_out));
        animateOnFocus(hasFocus());
        scaleOrbViewOnly(1.0f);
        this.mListening = false;
    }

    public SpeechOrbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SpeechOrbView(Context context) {
        this(context, null);
    }
}
