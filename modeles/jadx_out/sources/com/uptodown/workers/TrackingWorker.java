package com.uptodown.workers;

import android.app.Activity;
import android.content.Context;
import android.support.v4.media.g;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import f4.c;
import l7.u;
import t0.f;
import x4.g2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class TrackingWorker extends CoroutineWorker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3490a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3491b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3492c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3493d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3494e;
    public final g f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f3490a = context;
        this.f3491b = workerParameters.getInputData().getBoolean("isCompressed", true);
        this.f = new g(context, 20);
        Activity activity = c.f4875o;
        this.f3490a = f.e(context);
        for (String str : getTags()) {
            if (str.equals("TrackingWorkerPeriodic") || str.equals("TrackingWorkerSingle")) {
                this.f3494e = str;
            }
        }
    }

    public static String c(String str) {
        return u.m0(str, "TrackingWorkerPeriodic", true) ? "periodic" : "oneTime";
    }

    public final void b(g2 g2Var) {
        int i = g2Var.f11204b;
        if (i == 401) {
            this.f3492c = true;
        } else if (i == 0) {
            this.f3492c = true;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|(2:3|(9:5|6|7|(2:9|(2:11|(2:13|(2:15|(2:17|(2:19|20)(2:22|23))(6:24|25|26|27|(1:29)(1:32)|(1:31)(1:20)))(8:33|34|35|36|(2:38|(2:40|31))|27|(0)(0)|(0)(0)))(5:41|42|43|44|(5:46|(4:48|(2:50|(2:52|31))|36|(0))|27|(0)(0)|(0)(0))(2:53|54)))(3:55|56|57))(3:143|144|(5:146|(1:148)(2:175|(2:183|(3:185|(1:187)|188)(2:189|190))(3:179|(1:181)|182))|(6:150|(1:152)(1:171)|153|(3:160|(2:162|(1:164))|20)|169|170)(2:172|(1:174))|165|(2:167|31)(1:168))(2:191|192))|58|(4:61|(3:66|67|68)|69|59)|72|73|(2:75|(4:77|(3:84|(9:86|(2:88|(12:90|(1:92)(1:128)|(2:116|(2:122|(2:124|125)(2:126|127))(1:120))|96|97|98|99|100|(3:102|(3:104|(1:106)(1:110)|(2:108|31)(2:109|44))|(0)(0))|112|(0)|(0)(0)))|129|(0)(0)|(1:94)|116|(1:118)|122|(0)(0))|20)|130|(8:132|129|(0)(0)|(0)|116|(0)|122|(0)(0))(2:133|134))(2:135|136))(2:137|(2:139|140)(2:141|142))))|195|6|7|(0)(0)|58|(1:59)|72|73|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02cb, code lost:
    
        if (new org.json.JSONObject(r3).optInt("success") == 0) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x005e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0434, code lost:
    
        r0.printStackTrace();
        new android.support.v4.media.g(r15, 20).F("trackingWorker", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02e8 A[Catch: Exception -> 0x005e, TRY_ENTER, TryCatch #0 {Exception -> 0x005e, blocks: (B:19:0x0059, B:25:0x006b, B:27:0x03b5, B:34:0x007c, B:36:0x0383, B:38:0x039b, B:42:0x0086, B:46:0x031d, B:48:0x0363, B:50:0x036b, B:53:0x03de, B:54:0x03e3, B:56:0x0093, B:58:0x01e4, B:59:0x01f4, B:61:0x01fa, B:64:0x0207, B:67:0x020b, B:73:0x020f, B:75:0x0218, B:77:0x0247, B:79:0x0254, B:81:0x0258, B:84:0x025f, B:86:0x0270, B:88:0x0278, B:90:0x0280, B:92:0x0290, B:94:0x0298, B:104:0x02e8, B:116:0x029e, B:118:0x02b9, B:120:0x02bd, B:122:0x03e4, B:124:0x03ea, B:126:0x03f6, B:130:0x0287, B:133:0x03fa, B:135:0x03fe, B:136:0x0403, B:137:0x0404, B:139:0x041c, B:141:0x0425, B:142:0x0429, B:144:0x00a9, B:146:0x00b8, B:150:0x0159, B:152:0x0177, B:153:0x0183, B:155:0x0193, B:157:0x0197, B:160:0x019e, B:162:0x01af, B:164:0x01b9, B:165:0x01ce, B:169:0x01c3, B:171:0x017c, B:174:0x01cb, B:175:0x00ff, B:177:0x0121, B:179:0x0127, B:181:0x012e, B:182:0x0138, B:183:0x0146, B:185:0x014c, B:187:0x0153, B:189:0x042a, B:191:0x042e, B:192:0x0433), top: B:7:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02b9 A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:19:0x0059, B:25:0x006b, B:27:0x03b5, B:34:0x007c, B:36:0x0383, B:38:0x039b, B:42:0x0086, B:46:0x031d, B:48:0x0363, B:50:0x036b, B:53:0x03de, B:54:0x03e3, B:56:0x0093, B:58:0x01e4, B:59:0x01f4, B:61:0x01fa, B:64:0x0207, B:67:0x020b, B:73:0x020f, B:75:0x0218, B:77:0x0247, B:79:0x0254, B:81:0x0258, B:84:0x025f, B:86:0x0270, B:88:0x0278, B:90:0x0280, B:92:0x0290, B:94:0x0298, B:104:0x02e8, B:116:0x029e, B:118:0x02b9, B:120:0x02bd, B:122:0x03e4, B:124:0x03ea, B:126:0x03f6, B:130:0x0287, B:133:0x03fa, B:135:0x03fe, B:136:0x0403, B:137:0x0404, B:139:0x041c, B:141:0x0425, B:142:0x0429, B:144:0x00a9, B:146:0x00b8, B:150:0x0159, B:152:0x0177, B:153:0x0183, B:155:0x0193, B:157:0x0197, B:160:0x019e, B:162:0x01af, B:164:0x01b9, B:165:0x01ce, B:169:0x01c3, B:171:0x017c, B:174:0x01cb, B:175:0x00ff, B:177:0x0121, B:179:0x0127, B:181:0x012e, B:182:0x0138, B:183:0x0146, B:185:0x014c, B:187:0x0153, B:189:0x042a, B:191:0x042e, B:192:0x0433), top: B:7:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03ea A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:19:0x0059, B:25:0x006b, B:27:0x03b5, B:34:0x007c, B:36:0x0383, B:38:0x039b, B:42:0x0086, B:46:0x031d, B:48:0x0363, B:50:0x036b, B:53:0x03de, B:54:0x03e3, B:56:0x0093, B:58:0x01e4, B:59:0x01f4, B:61:0x01fa, B:64:0x0207, B:67:0x020b, B:73:0x020f, B:75:0x0218, B:77:0x0247, B:79:0x0254, B:81:0x0258, B:84:0x025f, B:86:0x0270, B:88:0x0278, B:90:0x0280, B:92:0x0290, B:94:0x0298, B:104:0x02e8, B:116:0x029e, B:118:0x02b9, B:120:0x02bd, B:122:0x03e4, B:124:0x03ea, B:126:0x03f6, B:130:0x0287, B:133:0x03fa, B:135:0x03fe, B:136:0x0403, B:137:0x0404, B:139:0x041c, B:141:0x0425, B:142:0x0429, B:144:0x00a9, B:146:0x00b8, B:150:0x0159, B:152:0x0177, B:153:0x0183, B:155:0x0193, B:157:0x0197, B:160:0x019e, B:162:0x01af, B:164:0x01b9, B:165:0x01ce, B:169:0x01c3, B:171:0x017c, B:174:0x01cb, B:175:0x00ff, B:177:0x0121, B:179:0x0127, B:181:0x012e, B:182:0x0138, B:183:0x0146, B:185:0x014c, B:187:0x0153, B:189:0x042a, B:191:0x042e, B:192:0x0433), top: B:7:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03f6 A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:19:0x0059, B:25:0x006b, B:27:0x03b5, B:34:0x007c, B:36:0x0383, B:38:0x039b, B:42:0x0086, B:46:0x031d, B:48:0x0363, B:50:0x036b, B:53:0x03de, B:54:0x03e3, B:56:0x0093, B:58:0x01e4, B:59:0x01f4, B:61:0x01fa, B:64:0x0207, B:67:0x020b, B:73:0x020f, B:75:0x0218, B:77:0x0247, B:79:0x0254, B:81:0x0258, B:84:0x025f, B:86:0x0270, B:88:0x0278, B:90:0x0280, B:92:0x0290, B:94:0x0298, B:104:0x02e8, B:116:0x029e, B:118:0x02b9, B:120:0x02bd, B:122:0x03e4, B:124:0x03ea, B:126:0x03f6, B:130:0x0287, B:133:0x03fa, B:135:0x03fe, B:136:0x0403, B:137:0x0404, B:139:0x041c, B:141:0x0425, B:142:0x0429, B:144:0x00a9, B:146:0x00b8, B:150:0x0159, B:152:0x0177, B:153:0x0183, B:155:0x0193, B:157:0x0197, B:160:0x019e, B:162:0x01af, B:164:0x01b9, B:165:0x01ce, B:169:0x01c3, B:171:0x017c, B:174:0x01cb, B:175:0x00ff, B:177:0x0121, B:179:0x0127, B:181:0x012e, B:182:0x0138, B:183:0x0146, B:185:0x014c, B:187:0x0153, B:189:0x042a, B:191:0x042e, B:192:0x0433), top: B:7:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0404 A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:19:0x0059, B:25:0x006b, B:27:0x03b5, B:34:0x007c, B:36:0x0383, B:38:0x039b, B:42:0x0086, B:46:0x031d, B:48:0x0363, B:50:0x036b, B:53:0x03de, B:54:0x03e3, B:56:0x0093, B:58:0x01e4, B:59:0x01f4, B:61:0x01fa, B:64:0x0207, B:67:0x020b, B:73:0x020f, B:75:0x0218, B:77:0x0247, B:79:0x0254, B:81:0x0258, B:84:0x025f, B:86:0x0270, B:88:0x0278, B:90:0x0280, B:92:0x0290, B:94:0x0298, B:104:0x02e8, B:116:0x029e, B:118:0x02b9, B:120:0x02bd, B:122:0x03e4, B:124:0x03ea, B:126:0x03f6, B:130:0x0287, B:133:0x03fa, B:135:0x03fe, B:136:0x0403, B:137:0x0404, B:139:0x041c, B:141:0x0425, B:142:0x0429, B:144:0x00a9, B:146:0x00b8, B:150:0x0159, B:152:0x0177, B:153:0x0183, B:155:0x0193, B:157:0x0197, B:160:0x019e, B:162:0x01af, B:164:0x01b9, B:165:0x01ce, B:169:0x01c3, B:171:0x017c, B:174:0x01cb, B:175:0x00ff, B:177:0x0121, B:179:0x0127, B:181:0x012e, B:182:0x0138, B:183:0x0146, B:185:0x014c, B:187:0x0153, B:189:0x042a, B:191:0x042e, B:192:0x0433), top: B:7:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0443 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x03dd A[PHI: r4
  0x03dd: PHI (r4v28 u6.a) = (r4v10 u6.a), (r4v21 u6.a), (r4v25 u6.a), (r4v27 u6.a), (r4v29 u6.a) binds: [B:167:0x01e1, B:108:0x0315, B:52:0x0382, B:40:0x03b4, B:30:0x03db] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x039b A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:19:0x0059, B:25:0x006b, B:27:0x03b5, B:34:0x007c, B:36:0x0383, B:38:0x039b, B:42:0x0086, B:46:0x031d, B:48:0x0363, B:50:0x036b, B:53:0x03de, B:54:0x03e3, B:56:0x0093, B:58:0x01e4, B:59:0x01f4, B:61:0x01fa, B:64:0x0207, B:67:0x020b, B:73:0x020f, B:75:0x0218, B:77:0x0247, B:79:0x0254, B:81:0x0258, B:84:0x025f, B:86:0x0270, B:88:0x0278, B:90:0x0280, B:92:0x0290, B:94:0x0298, B:104:0x02e8, B:116:0x029e, B:118:0x02b9, B:120:0x02bd, B:122:0x03e4, B:124:0x03ea, B:126:0x03f6, B:130:0x0287, B:133:0x03fa, B:135:0x03fe, B:136:0x0403, B:137:0x0404, B:139:0x041c, B:141:0x0425, B:142:0x0429, B:144:0x00a9, B:146:0x00b8, B:150:0x0159, B:152:0x0177, B:153:0x0183, B:155:0x0193, B:157:0x0197, B:160:0x019e, B:162:0x01af, B:164:0x01b9, B:165:0x01ce, B:169:0x01c3, B:171:0x017c, B:174:0x01cb, B:175:0x00ff, B:177:0x0121, B:179:0x0127, B:181:0x012e, B:182:0x0138, B:183:0x0146, B:185:0x014c, B:187:0x0153, B:189:0x042a, B:191:0x042e, B:192:0x0433), top: B:7:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x031d A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:19:0x0059, B:25:0x006b, B:27:0x03b5, B:34:0x007c, B:36:0x0383, B:38:0x039b, B:42:0x0086, B:46:0x031d, B:48:0x0363, B:50:0x036b, B:53:0x03de, B:54:0x03e3, B:56:0x0093, B:58:0x01e4, B:59:0x01f4, B:61:0x01fa, B:64:0x0207, B:67:0x020b, B:73:0x020f, B:75:0x0218, B:77:0x0247, B:79:0x0254, B:81:0x0258, B:84:0x025f, B:86:0x0270, B:88:0x0278, B:90:0x0280, B:92:0x0290, B:94:0x0298, B:104:0x02e8, B:116:0x029e, B:118:0x02b9, B:120:0x02bd, B:122:0x03e4, B:124:0x03ea, B:126:0x03f6, B:130:0x0287, B:133:0x03fa, B:135:0x03fe, B:136:0x0403, B:137:0x0404, B:139:0x041c, B:141:0x0425, B:142:0x0429, B:144:0x00a9, B:146:0x00b8, B:150:0x0159, B:152:0x0177, B:153:0x0183, B:155:0x0193, B:157:0x0197, B:160:0x019e, B:162:0x01af, B:164:0x01b9, B:165:0x01ce, B:169:0x01c3, B:171:0x017c, B:174:0x01cb, B:175:0x00ff, B:177:0x0121, B:179:0x0127, B:181:0x012e, B:182:0x0138, B:183:0x0146, B:185:0x014c, B:187:0x0153, B:189:0x042a, B:191:0x042e, B:192:0x0433), top: B:7:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x03de A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:19:0x0059, B:25:0x006b, B:27:0x03b5, B:34:0x007c, B:36:0x0383, B:38:0x039b, B:42:0x0086, B:46:0x031d, B:48:0x0363, B:50:0x036b, B:53:0x03de, B:54:0x03e3, B:56:0x0093, B:58:0x01e4, B:59:0x01f4, B:61:0x01fa, B:64:0x0207, B:67:0x020b, B:73:0x020f, B:75:0x0218, B:77:0x0247, B:79:0x0254, B:81:0x0258, B:84:0x025f, B:86:0x0270, B:88:0x0278, B:90:0x0280, B:92:0x0290, B:94:0x0298, B:104:0x02e8, B:116:0x029e, B:118:0x02b9, B:120:0x02bd, B:122:0x03e4, B:124:0x03ea, B:126:0x03f6, B:130:0x0287, B:133:0x03fa, B:135:0x03fe, B:136:0x0403, B:137:0x0404, B:139:0x041c, B:141:0x0425, B:142:0x0429, B:144:0x00a9, B:146:0x00b8, B:150:0x0159, B:152:0x0177, B:153:0x0183, B:155:0x0193, B:157:0x0197, B:160:0x019e, B:162:0x01af, B:164:0x01b9, B:165:0x01ce, B:169:0x01c3, B:171:0x017c, B:174:0x01cb, B:175:0x00ff, B:177:0x0121, B:179:0x0127, B:181:0x012e, B:182:0x0138, B:183:0x0146, B:185:0x014c, B:187:0x0153, B:189:0x042a, B:191:0x042e, B:192:0x0433), top: B:7:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01fa A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:19:0x0059, B:25:0x006b, B:27:0x03b5, B:34:0x007c, B:36:0x0383, B:38:0x039b, B:42:0x0086, B:46:0x031d, B:48:0x0363, B:50:0x036b, B:53:0x03de, B:54:0x03e3, B:56:0x0093, B:58:0x01e4, B:59:0x01f4, B:61:0x01fa, B:64:0x0207, B:67:0x020b, B:73:0x020f, B:75:0x0218, B:77:0x0247, B:79:0x0254, B:81:0x0258, B:84:0x025f, B:86:0x0270, B:88:0x0278, B:90:0x0280, B:92:0x0290, B:94:0x0298, B:104:0x02e8, B:116:0x029e, B:118:0x02b9, B:120:0x02bd, B:122:0x03e4, B:124:0x03ea, B:126:0x03f6, B:130:0x0287, B:133:0x03fa, B:135:0x03fe, B:136:0x0403, B:137:0x0404, B:139:0x041c, B:141:0x0425, B:142:0x0429, B:144:0x00a9, B:146:0x00b8, B:150:0x0159, B:152:0x0177, B:153:0x0183, B:155:0x0193, B:157:0x0197, B:160:0x019e, B:162:0x01af, B:164:0x01b9, B:165:0x01ce, B:169:0x01c3, B:171:0x017c, B:174:0x01cb, B:175:0x00ff, B:177:0x0121, B:179:0x0127, B:181:0x012e, B:182:0x0138, B:183:0x0146, B:185:0x014c, B:187:0x0153, B:189:0x042a, B:191:0x042e, B:192:0x0433), top: B:7:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0218 A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:19:0x0059, B:25:0x006b, B:27:0x03b5, B:34:0x007c, B:36:0x0383, B:38:0x039b, B:42:0x0086, B:46:0x031d, B:48:0x0363, B:50:0x036b, B:53:0x03de, B:54:0x03e3, B:56:0x0093, B:58:0x01e4, B:59:0x01f4, B:61:0x01fa, B:64:0x0207, B:67:0x020b, B:73:0x020f, B:75:0x0218, B:77:0x0247, B:79:0x0254, B:81:0x0258, B:84:0x025f, B:86:0x0270, B:88:0x0278, B:90:0x0280, B:92:0x0290, B:94:0x0298, B:104:0x02e8, B:116:0x029e, B:118:0x02b9, B:120:0x02bd, B:122:0x03e4, B:124:0x03ea, B:126:0x03f6, B:130:0x0287, B:133:0x03fa, B:135:0x03fe, B:136:0x0403, B:137:0x0404, B:139:0x041c, B:141:0x0425, B:142:0x0429, B:144:0x00a9, B:146:0x00b8, B:150:0x0159, B:152:0x0177, B:153:0x0183, B:155:0x0193, B:157:0x0197, B:160:0x019e, B:162:0x01af, B:164:0x01b9, B:165:0x01ce, B:169:0x01c3, B:171:0x017c, B:174:0x01cb, B:175:0x00ff, B:177:0x0121, B:179:0x0127, B:181:0x012e, B:182:0x0138, B:183:0x0146, B:185:0x014c, B:187:0x0153, B:189:0x042a, B:191:0x042e, B:192:0x0433), top: B:7:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0290 A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:19:0x0059, B:25:0x006b, B:27:0x03b5, B:34:0x007c, B:36:0x0383, B:38:0x039b, B:42:0x0086, B:46:0x031d, B:48:0x0363, B:50:0x036b, B:53:0x03de, B:54:0x03e3, B:56:0x0093, B:58:0x01e4, B:59:0x01f4, B:61:0x01fa, B:64:0x0207, B:67:0x020b, B:73:0x020f, B:75:0x0218, B:77:0x0247, B:79:0x0254, B:81:0x0258, B:84:0x025f, B:86:0x0270, B:88:0x0278, B:90:0x0280, B:92:0x0290, B:94:0x0298, B:104:0x02e8, B:116:0x029e, B:118:0x02b9, B:120:0x02bd, B:122:0x03e4, B:124:0x03ea, B:126:0x03f6, B:130:0x0287, B:133:0x03fa, B:135:0x03fe, B:136:0x0403, B:137:0x0404, B:139:0x041c, B:141:0x0425, B:142:0x0429, B:144:0x00a9, B:146:0x00b8, B:150:0x0159, B:152:0x0177, B:153:0x0183, B:155:0x0193, B:157:0x0197, B:160:0x019e, B:162:0x01af, B:164:0x01b9, B:165:0x01ce, B:169:0x01c3, B:171:0x017c, B:174:0x01cb, B:175:0x00ff, B:177:0x0121, B:179:0x0127, B:181:0x012e, B:182:0x0138, B:183:0x0146, B:185:0x014c, B:187:0x0153, B:189:0x042a, B:191:0x042e, B:192:0x0433), top: B:7:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0298 A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:19:0x0059, B:25:0x006b, B:27:0x03b5, B:34:0x007c, B:36:0x0383, B:38:0x039b, B:42:0x0086, B:46:0x031d, B:48:0x0363, B:50:0x036b, B:53:0x03de, B:54:0x03e3, B:56:0x0093, B:58:0x01e4, B:59:0x01f4, B:61:0x01fa, B:64:0x0207, B:67:0x020b, B:73:0x020f, B:75:0x0218, B:77:0x0247, B:79:0x0254, B:81:0x0258, B:84:0x025f, B:86:0x0270, B:88:0x0278, B:90:0x0280, B:92:0x0290, B:94:0x0298, B:104:0x02e8, B:116:0x029e, B:118:0x02b9, B:120:0x02bd, B:122:0x03e4, B:124:0x03ea, B:126:0x03f6, B:130:0x0287, B:133:0x03fa, B:135:0x03fe, B:136:0x0403, B:137:0x0404, B:139:0x041c, B:141:0x0425, B:142:0x0429, B:144:0x00a9, B:146:0x00b8, B:150:0x0159, B:152:0x0177, B:153:0x0183, B:155:0x0193, B:157:0x0197, B:160:0x019e, B:162:0x01af, B:164:0x01b9, B:165:0x01ce, B:169:0x01c3, B:171:0x017c, B:174:0x01cb, B:175:0x00ff, B:177:0x0121, B:179:0x0127, B:181:0x012e, B:182:0x0138, B:183:0x0146, B:185:0x014c, B:187:0x0153, B:189:0x042a, B:191:0x042e, B:192:0x0433), top: B:7:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(v6.c r32) {
        /*
            Method dump skipped, instructions count: 1092
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.TrackingWorker.d(v6.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:44|(16:46|(5:48|49|50|(2:52|53)|55)(5:83|84|85|(2:87|88)|90)|60|61|62|(2:64|65)|68|69|70|(6:72|(2:75|(1:77))|15|(1:17)|18|19)|79|(2:75|(0))|15|(0)|18|19)|93|60|61|62|(0)|68|69|70|(0)|79|(0)|15|(0)|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0109, code lost:
    
        if (r10.equalsIgnoreCase("reduced") != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0135, code lost:
    
        if ((java.lang.System.currentTimeMillis() - com.google.android.gms.internal.measurement.z3.t(0, r7, "last_tracking_timestamp")) <= 86400000) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0138, code lost:
    
        r15 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0153, code lost:
    
        if (java.lang.System.currentTimeMillis() < r10.getLong("maintenance_time", 0)) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0124, code lost:
    
        if (r10.equalsIgnoreCase("reduced") != false) goto L72;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0149 A[Catch: Exception -> 0x0156, TRY_LEAVE, TryCatch #2 {Exception -> 0x0156, blocks: (B:62:0x013d, B:64:0x0149), top: B:61:0x013d }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0162 A[Catch: Exception -> 0x0167, TRY_LEAVE, TryCatch #1 {Exception -> 0x0167, blocks: (B:70:0x0158, B:72:0x0162), top: B:69:0x0158 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x016a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0176 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doWork(t6.c r15) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.TrackingWorker.doWork(t6.c):java.lang.Object");
    }
}
