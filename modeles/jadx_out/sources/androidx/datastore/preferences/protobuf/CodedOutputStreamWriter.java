package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import androidx.privacysandbox.ads.adservices.customaudience.a;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@CheckReturnValue
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class CodedOutputStreamWriter implements Writer {
    private final CodedOutputStream output;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: androidx.datastore.preferences.protobuf.CodedOutputStreamWriter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.checkNotNull(codedOutputStream, "output");
        this.output = codedOutputStream2;
        codedOutputStream2.wrapper = this;
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.wrapper;
        return codedOutputStreamWriter != null ? codedOutputStreamWriter : new CodedOutputStreamWriter(codedOutputStream);
    }

    private void writeBoolListInternal(int i, List<Boolean> list, boolean z9) throws IOException {
        int i6 = 0;
        if (!z9) {
            while (i6 < list.size()) {
                this.output.writeBool(i, list.get(i6).booleanValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            i10 += CodedOutputStream.computeBoolSizeNoTag(list.get(i11).booleanValue());
        }
        this.output.writeUInt32NoTag(i10);
        while (i6 < list.size()) {
            this.output.writeBoolNoTag(list.get(i6).booleanValue());
            i6++;
        }
    }

    private <V> void writeDeterministicBooleanMapEntry(int i, boolean z9, V v, MapEntryLite.Metadata<Boolean, V> metadata) throws IOException {
        this.output.writeTag(i, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Boolean.valueOf(z9), v));
        MapEntryLite.writeTo(this.output, metadata, Boolean.valueOf(z9), v);
    }

    private <V> void writeDeterministicIntegerMap(int i, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) throws IOException {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            iArr[i6] = it.next().intValue();
            i6++;
        }
        Arrays.sort(iArr);
        for (int i10 = 0; i10 < size; i10++) {
            int i11 = iArr[i10];
            V v = map.get(Integer.valueOf(i11));
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Integer.valueOf(i11), v));
            MapEntryLite.writeTo(this.output, metadata, Integer.valueOf(i11), v);
        }
    }

    private <V> void writeDeterministicLongMap(int i, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) throws IOException {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator<Long> it = map.keySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            jArr[i6] = it.next().longValue();
            i6++;
        }
        Arrays.sort(jArr);
        for (int i10 = 0; i10 < size; i10++) {
            long j = jArr[i10];
            V v = map.get(Long.valueOf(j));
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Long.valueOf(j), v));
            MapEntryLite.writeTo(this.output, metadata, Long.valueOf(j), v);
        }
    }

    private <K, V> void writeDeterministicMap(int i, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[metadata.keyType.ordinal()]) {
            case 1:
                V v = map.get(Boolean.FALSE);
                if (v != null) {
                    writeDeterministicBooleanMapEntry(i, false, v, metadata);
                }
                V v9 = map.get(Boolean.TRUE);
                if (v9 != null) {
                    writeDeterministicBooleanMapEntry(i, true, v9, metadata);
                    break;
                }
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                writeDeterministicIntegerMap(i, metadata, map);
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                writeDeterministicLongMap(i, metadata, map);
                break;
            case 12:
                writeDeterministicStringMap(i, metadata, map);
                break;
            default:
                a.r(metadata.keyType, "does not support key type: ");
                break;
        }
    }

    private <V> void writeDeterministicStringMap(int i, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) throws IOException {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator<String> it = map.keySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            strArr[i6] = it.next();
            i6++;
        }
        Arrays.sort(strArr);
        for (int i10 = 0; i10 < size; i10++) {
            String str = strArr[i10];
            V v = map.get(str);
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, str, v));
            MapEntryLite.writeTo(this.output, metadata, str, v);
        }
    }

    private void writeDoubleListInternal(int i, List<Double> list, boolean z9) throws IOException {
        int i6 = 0;
        if (!z9) {
            while (i6 < list.size()) {
                this.output.writeDouble(i, list.get(i6).doubleValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            i10 += CodedOutputStream.computeDoubleSizeNoTag(list.get(i11).doubleValue());
        }
        this.output.writeUInt32NoTag(i10);
        while (i6 < list.size()) {
            this.output.writeDoubleNoTag(list.get(i6).doubleValue());
            i6++;
        }
    }

    private void writeEnumListInternal(int i, List<Integer> list, boolean z9) throws IOException {
        int i6 = 0;
        if (!z9) {
            while (i6 < list.size()) {
                this.output.writeEnum(i, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            i10 += CodedOutputStream.computeEnumSizeNoTag(list.get(i11).intValue());
        }
        this.output.writeUInt32NoTag(i10);
        while (i6 < list.size()) {
            this.output.writeEnumNoTag(list.get(i6).intValue());
            i6++;
        }
    }

    private void writeFixed32ListInternal(int i, List<Integer> list, boolean z9) throws IOException {
        int i6 = 0;
        if (!z9) {
            while (i6 < list.size()) {
                this.output.writeFixed32(i, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            i10 += CodedOutputStream.computeFixed32SizeNoTag(list.get(i11).intValue());
        }
        this.output.writeUInt32NoTag(i10);
        while (i6 < list.size()) {
            this.output.writeFixed32NoTag(list.get(i6).intValue());
            i6++;
        }
    }

    private void writeFixed64ListInternal(int i, List<Long> list, boolean z9) throws IOException {
        int i6 = 0;
        if (!z9) {
            while (i6 < list.size()) {
                this.output.writeFixed64(i, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            i10 += CodedOutputStream.computeFixed64SizeNoTag(list.get(i11).longValue());
        }
        this.output.writeUInt32NoTag(i10);
        while (i6 < list.size()) {
            this.output.writeFixed64NoTag(list.get(i6).longValue());
            i6++;
        }
    }

    private void writeFloatListInternal(int i, List<Float> list, boolean z9) throws IOException {
        int i6 = 0;
        if (!z9) {
            while (i6 < list.size()) {
                this.output.writeFloat(i, list.get(i6).floatValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            i10 += CodedOutputStream.computeFloatSizeNoTag(list.get(i11).floatValue());
        }
        this.output.writeUInt32NoTag(i10);
        while (i6 < list.size()) {
            this.output.writeFloatNoTag(list.get(i6).floatValue());
            i6++;
        }
    }

    private void writeInt32ListInternal(int i, List<Integer> list, boolean z9) throws IOException {
        int i6 = 0;
        if (!z9) {
            while (i6 < list.size()) {
                this.output.writeInt32(i, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            i10 += CodedOutputStream.computeInt32SizeNoTag(list.get(i11).intValue());
        }
        this.output.writeUInt32NoTag(i10);
        while (i6 < list.size()) {
            this.output.writeInt32NoTag(list.get(i6).intValue());
            i6++;
        }
    }

    private void writeInt64ListInternal(int i, List<Long> list, boolean z9) throws IOException {
        int i6 = 0;
        if (!z9) {
            while (i6 < list.size()) {
                this.output.writeInt64(i, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            i10 += CodedOutputStream.computeInt64SizeNoTag(list.get(i11).longValue());
        }
        this.output.writeUInt32NoTag(i10);
        while (i6 < list.size()) {
            this.output.writeInt64NoTag(list.get(i6).longValue());
            i6++;
        }
    }

    private void writeLazyString(int i, Object obj) throws IOException {
        boolean z9 = obj instanceof String;
        CodedOutputStream codedOutputStream = this.output;
        if (z9) {
            codedOutputStream.writeString(i, (String) obj);
        } else {
            codedOutputStream.writeBytes(i, (ByteString) obj);
        }
    }

    private void writeSFixed32ListInternal(int i, List<Integer> list, boolean z9) throws IOException {
        int i6 = 0;
        if (!z9) {
            while (i6 < list.size()) {
                this.output.writeSFixed32(i, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            i10 += CodedOutputStream.computeSFixed32SizeNoTag(list.get(i11).intValue());
        }
        this.output.writeUInt32NoTag(i10);
        while (i6 < list.size()) {
            this.output.writeSFixed32NoTag(list.get(i6).intValue());
            i6++;
        }
    }

    private void writeSFixed64ListInternal(int i, List<Long> list, boolean z9) throws IOException {
        int i6 = 0;
        if (!z9) {
            while (i6 < list.size()) {
                this.output.writeSFixed64(i, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            i10 += CodedOutputStream.computeSFixed64SizeNoTag(list.get(i11).longValue());
        }
        this.output.writeUInt32NoTag(i10);
        while (i6 < list.size()) {
            this.output.writeSFixed64NoTag(list.get(i6).longValue());
            i6++;
        }
    }

    private void writeSInt64ListInternal(int i, List<Long> list, boolean z9) throws IOException {
        int i6 = 0;
        if (!z9) {
            while (i6 < list.size()) {
                this.output.writeSInt64(i, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            i10 += CodedOutputStream.computeSInt64SizeNoTag(list.get(i11).longValue());
        }
        this.output.writeUInt32NoTag(i10);
        while (i6 < list.size()) {
            this.output.writeSInt64NoTag(list.get(i6).longValue());
            i6++;
        }
    }

    private void writeUInt64ListInternal(int i, List<Long> list, boolean z9) throws IOException {
        int i6 = 0;
        if (!z9) {
            while (i6 < list.size()) {
                this.output.writeUInt64(i, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            i10 += CodedOutputStream.computeUInt64SizeNoTag(list.get(i11).longValue());
        }
        this.output.writeUInt32NoTag(i10);
        while (i6 < list.size()) {
            this.output.writeUInt64NoTag(list.get(i6).longValue());
            i6++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.output.getTotalBytesWritten();
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeBool(int i, boolean z9) throws IOException {
        this.output.writeBool(i, z9);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeBoolList(int i, List<Boolean> list, boolean z9) throws IOException {
        if (list instanceof BooleanArrayList) {
            writeBoolListInternal(i, (BooleanArrayList) list, z9);
        } else {
            writeBoolListInternal(i, list, z9);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeBytes(int i, ByteString byteString) throws IOException {
        this.output.writeBytes(i, byteString);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeBytesList(int i, List<ByteString> list) throws IOException {
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.output.writeBytes(i, list.get(i6));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeDouble(int i, double d10) throws IOException {
        this.output.writeDouble(i, d10);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeDoubleList(int i, List<Double> list, boolean z9) throws IOException {
        if (list instanceof DoubleArrayList) {
            writeDoubleListInternal(i, (DoubleArrayList) list, z9);
        } else {
            writeDoubleListInternal(i, list, z9);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    @Deprecated
    public void writeEndGroup(int i) throws IOException {
        this.output.writeTag(i, 4);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeEnum(int i, int i6) throws IOException {
        this.output.writeEnum(i, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeEnumList(int i, List<Integer> list, boolean z9) throws IOException {
        if (list instanceof IntArrayList) {
            writeEnumListInternal(i, (IntArrayList) list, z9);
        } else {
            writeEnumListInternal(i, list, z9);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed32(int i, int i6) throws IOException {
        this.output.writeFixed32(i, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed32List(int i, List<Integer> list, boolean z9) throws IOException {
        if (list instanceof IntArrayList) {
            writeFixed32ListInternal(i, (IntArrayList) list, z9);
        } else {
            writeFixed32ListInternal(i, list, z9);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed64(int i, long j) throws IOException {
        this.output.writeFixed64(i, j);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed64List(int i, List<Long> list, boolean z9) throws IOException {
        if (list instanceof LongArrayList) {
            writeFixed64ListInternal(i, (LongArrayList) list, z9);
        } else {
            writeFixed64ListInternal(i, list, z9);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFloat(int i, float f) throws IOException {
        this.output.writeFloat(i, f);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFloatList(int i, List<Float> list, boolean z9) throws IOException {
        if (list instanceof FloatArrayList) {
            writeFloatListInternal(i, (FloatArrayList) list, z9);
        } else {
            writeFloatListInternal(i, list, z9);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    @Deprecated
    public void writeGroup(int i, Object obj) throws IOException {
        this.output.writeGroup(i, (MessageLite) obj);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    @Deprecated
    public void writeGroupList(int i, List<?> list) throws IOException {
        for (int i6 = 0; i6 < list.size(); i6++) {
            writeGroup(i, list.get(i6));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt32(int i, int i6) throws IOException {
        this.output.writeInt32(i, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt32List(int i, List<Integer> list, boolean z9) throws IOException {
        if (list instanceof IntArrayList) {
            writeInt32ListInternal(i, (IntArrayList) list, z9);
        } else {
            writeInt32ListInternal(i, list, z9);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt64(int i, long j) throws IOException {
        this.output.writeInt64(i, j);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt64List(int i, List<Long> list, boolean z9) throws IOException {
        if (list instanceof LongArrayList) {
            writeInt64ListInternal(i, (LongArrayList) list, z9);
        } else {
            writeInt64ListInternal(i, list, z9);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public <K, V> void writeMap(int i, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        if (this.output.isSerializationDeterministic()) {
            writeDeterministicMap(i, metadata, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.writeTo(this.output, metadata, entry.getKey(), entry.getValue());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeMessage(int i, Object obj) throws IOException {
        this.output.writeMessage(i, (MessageLite) obj);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeMessageList(int i, List<?> list) throws IOException {
        for (int i6 = 0; i6 < list.size(); i6++) {
            writeMessage(i, list.get(i6));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeMessageSetItem(int i, Object obj) throws IOException {
        boolean z9 = obj instanceof ByteString;
        CodedOutputStream codedOutputStream = this.output;
        if (z9) {
            codedOutputStream.writeRawMessageSetExtension(i, (ByteString) obj);
        } else {
            codedOutputStream.writeMessageSetExtension(i, (MessageLite) obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed32(int i, int i6) throws IOException {
        this.output.writeSFixed32(i, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed32List(int i, List<Integer> list, boolean z9) throws IOException {
        if (list instanceof IntArrayList) {
            writeSFixed32ListInternal(i, (IntArrayList) list, z9);
        } else {
            writeSFixed32ListInternal(i, list, z9);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed64(int i, long j) throws IOException {
        this.output.writeSFixed64(i, j);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed64List(int i, List<Long> list, boolean z9) throws IOException {
        if (list instanceof LongArrayList) {
            writeSFixed64ListInternal(i, (LongArrayList) list, z9);
        } else {
            writeSFixed64ListInternal(i, list, z9);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt32(int i, int i6) throws IOException {
        this.output.writeSInt32(i, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt32List(int i, List<Integer> list, boolean z9) throws IOException {
        if (list instanceof IntArrayList) {
            writeSInt32ListInternal(i, (IntArrayList) list, z9);
        } else {
            writeSInt32ListInternal(i, list, z9);
        }
    }

    public void writeSInt32ListInternal(int i, List<Integer> list, boolean z9) throws IOException {
        int i6 = 0;
        if (!z9) {
            while (i6 < list.size()) {
                this.output.writeSInt32(i, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            i10 += CodedOutputStream.computeSInt32SizeNoTag(list.get(i11).intValue());
        }
        this.output.writeUInt32NoTag(i10);
        while (i6 < list.size()) {
            this.output.writeSInt32NoTag(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt64(int i, long j) throws IOException {
        this.output.writeSInt64(i, j);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt64List(int i, List<Long> list, boolean z9) throws IOException {
        if (list instanceof LongArrayList) {
            writeSInt64ListInternal(i, (LongArrayList) list, z9);
        } else {
            writeSInt64ListInternal(i, list, z9);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    @Deprecated
    public void writeStartGroup(int i) throws IOException {
        this.output.writeTag(i, 3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeString(int i, String str) throws IOException {
        this.output.writeString(i, str);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeStringList(int i, List<String> list) throws IOException {
        int i6 = 0;
        if (!(list instanceof LazyStringList)) {
            while (i6 < list.size()) {
                this.output.writeString(i, list.get(i6));
                i6++;
            }
        } else {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i6 < list.size()) {
                writeLazyString(i, lazyStringList.getRaw(i6));
                i6++;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt32(int i, int i6) throws IOException {
        this.output.writeUInt32(i, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt32List(int i, List<Integer> list, boolean z9) throws IOException {
        if (list instanceof IntArrayList) {
            writeUInt32ListInternal(i, (IntArrayList) list, z9);
        } else {
            writeUInt32ListInternal(i, list, z9);
        }
    }

    public void writeUInt32ListInternal(int i, List<Integer> list, boolean z9) throws IOException {
        int i6 = 0;
        if (!z9) {
            while (i6 < list.size()) {
                this.output.writeUInt32(i, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            i10 += CodedOutputStream.computeUInt32SizeNoTag(list.get(i11).intValue());
        }
        this.output.writeUInt32NoTag(i10);
        while (i6 < list.size()) {
            this.output.writeUInt32NoTag(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt64(int i, long j) throws IOException {
        this.output.writeUInt64(i, j);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt64List(int i, List<Long> list, boolean z9) throws IOException {
        if (list instanceof LongArrayList) {
            writeUInt64ListInternal(i, (LongArrayList) list, z9);
        } else {
            writeUInt64ListInternal(i, list, z9);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeGroup(int i, Object obj, Schema schema) throws IOException {
        this.output.writeGroup(i, (MessageLite) obj, schema);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeMessage(int i, Object obj, Schema schema) throws IOException {
        this.output.writeMessage(i, (MessageLite) obj, schema);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeGroupList(int i, List<?> list, Schema schema) throws IOException {
        for (int i6 = 0; i6 < list.size(); i6++) {
            writeGroup(i, list.get(i6), schema);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeMessageList(int i, List<?> list, Schema schema) throws IOException {
        for (int i6 = 0; i6 < list.size(); i6++) {
            writeMessage(i, list.get(i6), schema);
        }
    }

    private void writeBoolListInternal(int i, BooleanArrayList booleanArrayList, boolean z9) throws IOException {
        int i6 = 0;
        if (z9) {
            this.output.writeTag(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < booleanArrayList.size(); i11++) {
                i10 += CodedOutputStream.computeBoolSizeNoTag(booleanArrayList.getBoolean(i11));
            }
            this.output.writeUInt32NoTag(i10);
            while (i6 < booleanArrayList.size()) {
                this.output.writeBoolNoTag(booleanArrayList.getBoolean(i6));
                i6++;
            }
            return;
        }
        while (i6 < booleanArrayList.size()) {
            this.output.writeBool(i, booleanArrayList.getBoolean(i6));
            i6++;
        }
    }

    private void writeDoubleListInternal(int i, DoubleArrayList doubleArrayList, boolean z9) throws IOException {
        int i6 = 0;
        if (z9) {
            this.output.writeTag(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < doubleArrayList.size(); i11++) {
                i10 += CodedOutputStream.computeDoubleSizeNoTag(doubleArrayList.getDouble(i11));
            }
            this.output.writeUInt32NoTag(i10);
            while (i6 < doubleArrayList.size()) {
                this.output.writeDoubleNoTag(doubleArrayList.getDouble(i6));
                i6++;
            }
            return;
        }
        while (i6 < doubleArrayList.size()) {
            this.output.writeDouble(i, doubleArrayList.getDouble(i6));
            i6++;
        }
    }

    private void writeEnumListInternal(int i, IntArrayList intArrayList, boolean z9) throws IOException {
        int i6 = 0;
        if (z9) {
            this.output.writeTag(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < intArrayList.size(); i11++) {
                i10 += CodedOutputStream.computeEnumSizeNoTag(intArrayList.getInt(i11));
            }
            this.output.writeUInt32NoTag(i10);
            while (i6 < intArrayList.size()) {
                this.output.writeEnumNoTag(intArrayList.getInt(i6));
                i6++;
            }
            return;
        }
        while (i6 < intArrayList.size()) {
            this.output.writeEnum(i, intArrayList.getInt(i6));
            i6++;
        }
    }

    private void writeFixed32ListInternal(int i, IntArrayList intArrayList, boolean z9) throws IOException {
        int i6 = 0;
        if (z9) {
            this.output.writeTag(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < intArrayList.size(); i11++) {
                i10 += CodedOutputStream.computeFixed32SizeNoTag(intArrayList.getInt(i11));
            }
            this.output.writeUInt32NoTag(i10);
            while (i6 < intArrayList.size()) {
                this.output.writeFixed32NoTag(intArrayList.getInt(i6));
                i6++;
            }
            return;
        }
        while (i6 < intArrayList.size()) {
            this.output.writeFixed32(i, intArrayList.getInt(i6));
            i6++;
        }
    }

    private void writeFixed64ListInternal(int i, LongArrayList longArrayList, boolean z9) throws IOException {
        int i6 = 0;
        if (z9) {
            this.output.writeTag(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < longArrayList.size(); i11++) {
                i10 += CodedOutputStream.computeFixed64SizeNoTag(longArrayList.getLong(i11));
            }
            this.output.writeUInt32NoTag(i10);
            while (i6 < longArrayList.size()) {
                this.output.writeFixed64NoTag(longArrayList.getLong(i6));
                i6++;
            }
            return;
        }
        while (i6 < longArrayList.size()) {
            this.output.writeFixed64(i, longArrayList.getLong(i6));
            i6++;
        }
    }

    private void writeFloatListInternal(int i, FloatArrayList floatArrayList, boolean z9) throws IOException {
        int i6 = 0;
        if (z9) {
            this.output.writeTag(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < floatArrayList.size(); i11++) {
                i10 += CodedOutputStream.computeFloatSizeNoTag(floatArrayList.getFloat(i11));
            }
            this.output.writeUInt32NoTag(i10);
            while (i6 < floatArrayList.size()) {
                this.output.writeFloatNoTag(floatArrayList.getFloat(i6));
                i6++;
            }
            return;
        }
        while (i6 < floatArrayList.size()) {
            this.output.writeFloat(i, floatArrayList.getFloat(i6));
            i6++;
        }
    }

    private void writeInt32ListInternal(int i, IntArrayList intArrayList, boolean z9) throws IOException {
        int i6 = 0;
        if (z9) {
            this.output.writeTag(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < intArrayList.size(); i11++) {
                i10 += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(i11));
            }
            this.output.writeUInt32NoTag(i10);
            while (i6 < intArrayList.size()) {
                this.output.writeInt32NoTag(intArrayList.getInt(i6));
                i6++;
            }
            return;
        }
        while (i6 < intArrayList.size()) {
            this.output.writeInt32(i, intArrayList.getInt(i6));
            i6++;
        }
    }

    private void writeInt64ListInternal(int i, LongArrayList longArrayList, boolean z9) throws IOException {
        int i6 = 0;
        if (z9) {
            this.output.writeTag(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < longArrayList.size(); i11++) {
                i10 += CodedOutputStream.computeInt64SizeNoTag(longArrayList.getLong(i11));
            }
            this.output.writeUInt32NoTag(i10);
            while (i6 < longArrayList.size()) {
                this.output.writeInt64NoTag(longArrayList.getLong(i6));
                i6++;
            }
            return;
        }
        while (i6 < longArrayList.size()) {
            this.output.writeInt64(i, longArrayList.getLong(i6));
            i6++;
        }
    }

    private void writeSFixed32ListInternal(int i, IntArrayList intArrayList, boolean z9) throws IOException {
        int i6 = 0;
        if (z9) {
            this.output.writeTag(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < intArrayList.size(); i11++) {
                i10 += CodedOutputStream.computeSFixed32SizeNoTag(intArrayList.getInt(i11));
            }
            this.output.writeUInt32NoTag(i10);
            while (i6 < intArrayList.size()) {
                this.output.writeSFixed32NoTag(intArrayList.getInt(i6));
                i6++;
            }
            return;
        }
        while (i6 < intArrayList.size()) {
            this.output.writeSFixed32(i, intArrayList.getInt(i6));
            i6++;
        }
    }

    private void writeSFixed64ListInternal(int i, LongArrayList longArrayList, boolean z9) throws IOException {
        int i6 = 0;
        if (z9) {
            this.output.writeTag(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < longArrayList.size(); i11++) {
                i10 += CodedOutputStream.computeSFixed64SizeNoTag(longArrayList.getLong(i11));
            }
            this.output.writeUInt32NoTag(i10);
            while (i6 < longArrayList.size()) {
                this.output.writeSFixed64NoTag(longArrayList.getLong(i6));
                i6++;
            }
            return;
        }
        while (i6 < longArrayList.size()) {
            this.output.writeSFixed64(i, longArrayList.getLong(i6));
            i6++;
        }
    }

    private void writeSInt32ListInternal(int i, IntArrayList intArrayList, boolean z9) throws IOException {
        int i6 = 0;
        if (z9) {
            this.output.writeTag(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < intArrayList.size(); i11++) {
                i10 += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.getInt(i11));
            }
            this.output.writeUInt32NoTag(i10);
            while (i6 < intArrayList.size()) {
                this.output.writeSInt32NoTag(intArrayList.getInt(i6));
                i6++;
            }
            return;
        }
        while (i6 < intArrayList.size()) {
            this.output.writeSInt32(i, intArrayList.getInt(i6));
            i6++;
        }
    }

    private void writeSInt64ListInternal(int i, LongArrayList longArrayList, boolean z9) throws IOException {
        int i6 = 0;
        if (z9) {
            this.output.writeTag(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < longArrayList.size(); i11++) {
                i10 += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.getLong(i11));
            }
            this.output.writeUInt32NoTag(i10);
            while (i6 < longArrayList.size()) {
                this.output.writeSInt64NoTag(longArrayList.getLong(i6));
                i6++;
            }
            return;
        }
        while (i6 < longArrayList.size()) {
            this.output.writeSInt64(i, longArrayList.getLong(i6));
            i6++;
        }
    }

    private void writeUInt32ListInternal(int i, IntArrayList intArrayList, boolean z9) throws IOException {
        int i6 = 0;
        if (z9) {
            this.output.writeTag(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < intArrayList.size(); i11++) {
                i10 += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.getInt(i11));
            }
            this.output.writeUInt32NoTag(i10);
            while (i6 < intArrayList.size()) {
                this.output.writeUInt32NoTag(intArrayList.getInt(i6));
                i6++;
            }
            return;
        }
        while (i6 < intArrayList.size()) {
            this.output.writeUInt32(i, intArrayList.getInt(i6));
            i6++;
        }
    }

    private void writeUInt64ListInternal(int i, LongArrayList longArrayList, boolean z9) throws IOException {
        int i6 = 0;
        if (z9) {
            this.output.writeTag(i, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < longArrayList.size(); i11++) {
                i10 += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(i11));
            }
            this.output.writeUInt32NoTag(i10);
            while (i6 < longArrayList.size()) {
                this.output.writeUInt64NoTag(longArrayList.getLong(i6));
                i6++;
            }
            return;
        }
        while (i6 < longArrayList.size()) {
            this.output.writeUInt64(i, longArrayList.getLong(i6));
            i6++;
        }
    }
}
