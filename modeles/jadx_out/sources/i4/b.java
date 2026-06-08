package i4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.documentfile.provider.DocumentFile;
import androidx.lifecycle.l;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.internal.measurement.i5;
import d4.d;
import f0.i;
import g4.b0;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import l7.u;
import n4.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final i f5655a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f5656b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5657c;

    /* renamed from: d, reason: collision with root package name */
    public boolean[] f5658d;

    public b(i iVar) {
        iVar.getClass();
        this.f5655a = iVar;
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        if (this.f5656b != null) {
            boolean[] zArr = this.f5658d;
            zArr.getClass();
            int length = zArr.length;
            for (int i = 0; i < length; i++) {
                if (zArr[i]) {
                    ArrayList arrayList2 = this.f5656b;
                    arrayList2.getClass();
                    arrayList.add(arrayList2.get(i));
                }
            }
        }
        return arrayList;
    }

    public final void b(int i) {
        boolean[] zArr = this.f5658d;
        zArr.getClass();
        this.f5658d.getClass();
        zArr[i] = !r1[i];
        notifyItemChanged(i);
    }

    public final void c(boolean z9) {
        this.f5657c = z9;
        if (!z9) {
            ArrayList arrayList = this.f5656b;
            if (arrayList != null) {
                this.f5658d = new boolean[arrayList.size()];
            } else {
                this.f5658d = new boolean[0];
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList arrayList = this.f5656b;
        if (arrayList == null) {
            return 0;
        }
        arrayList.getClass();
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        String str;
        long j;
        boolean z9;
        String str2;
        Drawable drawable;
        int length;
        r4.b bVar = (r4.b) viewHolder;
        bVar.getClass();
        ArrayList arrayList = this.f5656b;
        if (arrayList != null) {
            Object obj = arrayList.get(i);
            obj.getClass();
            boolean z10 = this.f5657c;
            boolean[] zArr = this.f5658d;
            zArr.getClass();
            boolean z11 = zArr[i];
            CheckBox checkBox = bVar.f8906o;
            TextView textView = bVar.f8905n;
            bVar.itemView.setOnClickListener(new b0(28, bVar, obj));
            bVar.itemView.setOnLongClickListener(new d(11, bVar, obj));
            boolean z12 = obj instanceof File;
            if (z12) {
                File file = (File) obj;
                str = file.getName();
                long lastModified = file.lastModified();
                Calendar calendar = Calendar.getInstance(Locale.FRANCE);
                calendar.setTimeInMillis(lastModified);
                str2 = DateFormat.format("dd MMM yyyy hh:mm", calendar).toString();
                z9 = file.isDirectory();
                j = file.length();
            } else if (obj instanceof DocumentFile) {
                DocumentFile documentFile = (DocumentFile) obj;
                str = documentFile.getName();
                long lastModified2 = documentFile.lastModified();
                Calendar calendar2 = Calendar.getInstance(Locale.FRANCE);
                calendar2.setTimeInMillis(lastModified2);
                str2 = DateFormat.format("dd MMM yyyy hh:mm", calendar2).toString();
                z9 = documentFile.isDirectory();
                j = documentFile.length();
            } else {
                str = null;
                j = 0;
                z9 = false;
                str2 = null;
            }
            if (str != null) {
                bVar.f8903l.setText(str);
                View view = bVar.itemView;
                if (z9) {
                    Context context = view.getContext();
                    if (z12) {
                        File[] listFiles = ((File) obj).listFiles();
                        if (listFiles != null) {
                            length = listFiles.length;
                            textView.setText(context.getString(2131951865, String.valueOf(length)));
                            drawable = AppCompatResources.getDrawable(bVar.itemView.getContext(), 2131230940);
                        }
                        length = 0;
                        textView.setText(context.getString(2131951865, String.valueOf(length)));
                        drawable = AppCompatResources.getDrawable(bVar.itemView.getContext(), 2131230940);
                    } else {
                        if (obj instanceof DocumentFile) {
                            length = ((DocumentFile) obj).listFiles().length;
                            textView.setText(context.getString(2131951865, String.valueOf(length)));
                            drawable = AppCompatResources.getDrawable(bVar.itemView.getContext(), 2131230940);
                        }
                        length = 0;
                        textView.setText(context.getString(2131951865, String.valueOf(length)));
                        drawable = AppCompatResources.getDrawable(bVar.itemView.getContext(), 2131230940);
                    }
                } else {
                    Context context2 = view.getContext();
                    context2.getClass();
                    textView.setText(i5.H(context2, j));
                    if (u.k0(str, ".apk", false)) {
                        HashMap hashMap = m.f7985a;
                        drawable = hashMap.get(str) != null ? (Drawable) hashMap.get(str) : AppCompatResources.getDrawable(bVar.itemView.getContext(), 2131230918);
                    } else if (u.k0(str, ".xapk", false) || u.k0(str, ".apks", false)) {
                        drawable = AppCompatResources.getDrawable(bVar.itemView.getContext(), 2131230965);
                    } else {
                        boolean k02 = u.k0(str, ".zip", false);
                        View view2 = bVar.itemView;
                        drawable = k02 ? AppCompatResources.getDrawable(view2.getContext(), 2131230966) : AppCompatResources.getDrawable(view2.getContext(), 2131230936);
                    }
                }
                bVar.f8902b.setImageDrawable(drawable);
            }
            if (str2 != null) {
                bVar.f8904m.setText(str2);
            }
            if (!z10) {
                checkBox.setVisibility(8);
                textView.setVisibility(0);
            } else {
                checkBox.setVisibility(0);
                textView.setVisibility(4);
                checkBox.setChecked(z11);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        return new r4.b(l.E(viewGroup, 2131558554, viewGroup, false), this.f5655a);
    }
}
