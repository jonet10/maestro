package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import androidx.core.widget.TextViewCompat;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class StreamingTextView extends EditText {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.leanback.widget.StreamingTextView";
    static final boolean ANIMATE_DOTS_FOR_PENDING = true;
    private static final boolean DEBUG = false;
    private static final boolean DOTS_FOR_PENDING = true;
    private static final boolean DOTS_FOR_STABLE = false;
    private static final Pattern SPLIT_PATTERN = Pattern.compile("\\S+");
    private static final Property<StreamingTextView, Integer> STREAM_POSITION_PROPERTY = new Property<StreamingTextView, Integer>(Integer.class, "streamPosition") { // from class: androidx.leanback.widget.StreamingTextView.1
        @Override // android.util.Property
        public Integer get(StreamingTextView streamingTextView) {
            return Integer.valueOf(streamingTextView.getStreamPosition());
        }

        @Override // android.util.Property
        public void set(StreamingTextView streamingTextView, Integer num) {
            streamingTextView.setStreamPosition(num.intValue());
        }
    };
    private static final long STREAM_UPDATE_DELAY_MILLIS = 50;
    private static final String TAG = "StreamingTextView";
    private static final float TEXT_DOT_SCALE = 1.3f;
    Bitmap mOneDot;
    final Random mRandom;
    int mStreamPosition;
    private ObjectAnimator mStreamingAnimation;
    Bitmap mTwoDot;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public class DottySpan extends ReplacementSpan {
        private final int mPosition;
        private final int mSeed;

        public DottySpan(int i, int i6) {
            this.mSeed = i;
            this.mPosition = i6;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i6, float f, int i10, int i11, int i12, Paint paint) {
            int measureText = (int) paint.measureText(charSequence, i, i6);
            int width = StreamingTextView.this.mOneDot.getWidth();
            int i13 = width * 2;
            int i14 = measureText / i13;
            int i15 = (measureText % i13) / 2;
            boolean isLayoutRtl = StreamingTextView.isLayoutRtl(StreamingTextView.this);
            StreamingTextView.this.mRandom.setSeed(this.mSeed);
            int alpha = paint.getAlpha();
            for (int i16 = 0; i16 < i14; i16++) {
                int i17 = this.mPosition + i16;
                StreamingTextView streamingTextView = StreamingTextView.this;
                if (i17 >= streamingTextView.mStreamPosition) {
                    break;
                }
                float f10 = (width / 2) + (i16 * i13) + i15;
                float f11 = isLayoutRtl ? ((measureText + f) - f10) - width : f + f10;
                paint.setAlpha((streamingTextView.mRandom.nextInt(4) + 1) * 63);
                boolean nextBoolean = StreamingTextView.this.mRandom.nextBoolean();
                StreamingTextView streamingTextView2 = StreamingTextView.this;
                if (nextBoolean) {
                    canvas.drawBitmap(streamingTextView2.mTwoDot, f11, i11 - r3.getHeight(), paint);
                } else {
                    canvas.drawBitmap(streamingTextView2.mOneDot, f11, i11 - r3.getHeight(), paint);
                }
            }
            paint.setAlpha(alpha);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i6, Paint.FontMetricsInt fontMetricsInt) {
            return (int) paint.measureText(charSequence, i, i6);
        }
    }

    public StreamingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRandom = new Random();
    }

    private void addColorSpan(SpannableStringBuilder spannableStringBuilder, int i, String str, int i6) {
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i), i6, str.length() + i6, 33);
    }

    private void addDottySpans(SpannableStringBuilder spannableStringBuilder, String str, int i) {
        Matcher matcher = SPLIT_PATTERN.matcher(str);
        while (matcher.find()) {
            int start = matcher.start() + i;
            spannableStringBuilder.setSpan(new DottySpan(str.charAt(matcher.start()), start), start, matcher.end() + i, 33);
        }
    }

    private void cancelStreamAnimation() {
        ObjectAnimator objectAnimator = this.mStreamingAnimation;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private Bitmap getScaledBitmap(int i, float f) {
        return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), i), (int) (r3.getWidth() * f), (int) (r3.getHeight() * f), false);
    }

    public static boolean isLayoutRtl(View view) {
        return 1 == view.getLayoutDirection();
    }

    private void startStreamAnimation() {
        cancelStreamAnimation();
        int streamPosition = getStreamPosition();
        int length = length();
        int i = length - streamPosition;
        if (i > 0) {
            if (this.mStreamingAnimation == null) {
                ObjectAnimator objectAnimator = new ObjectAnimator();
                this.mStreamingAnimation = objectAnimator;
                objectAnimator.setTarget(this);
                this.mStreamingAnimation.setProperty(STREAM_POSITION_PROPERTY);
            }
            this.mStreamingAnimation.setIntValues(streamPosition, length);
            this.mStreamingAnimation.setDuration(i * STREAM_UPDATE_DELAY_MILLIS);
            this.mStreamingAnimation.start();
        }
    }

    private void updateText(CharSequence charSequence) {
        setText(charSequence);
        bringPointIntoView(length());
    }

    public int getStreamPosition() {
        return this.mStreamPosition;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mOneDot = getScaledBitmap(androidx.leanback.R.drawable.lb_text_dot_one, TEXT_DOT_SCALE);
        this.mTwoDot = getScaledBitmap(androidx.leanback.R.drawable.lb_text_dot_two, TEXT_DOT_SCALE);
        reset();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    public void reset() {
        this.mStreamPosition = -1;
        cancelStreamAnimation();
        setText("");
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setFinalRecognizedText(CharSequence charSequence) {
        updateText(charSequence);
    }

    public void setStreamPosition(int i) {
        this.mStreamPosition = i;
        invalidate();
    }

    public void updateRecognizedText(String str, String str2) {
        if (str == null) {
            str = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (str2 != null) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str2);
            addDottySpans(spannableStringBuilder, str2, length);
        }
        this.mStreamPosition = Math.max(str.length(), this.mStreamPosition);
        updateText(new SpannedString(spannableStringBuilder));
        startStreamAnimation();
    }

    public StreamingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRandom = new Random();
    }

    public void updateRecognizedText(String str, List<Float> list) {
    }
}
