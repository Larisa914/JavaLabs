package com.company.dla.trainings.topic3.maps.json;

class JsonBinaryData extends Json {
    private byte bytesArray[];

    JsonBinaryData(byte[] bytesArray) {
        this.bytesArray = bytesArray;
    }

    public byte[] getBytesArray() {
        return bytesArray;
    }

    @Override
    public byte[] get() {
        return bytesArray;
    }

    @Override
    public String toString() {
        String s = "/***";
        for (byte b : bytesArray) {
            s += Integer.toBinaryString(b);
        }
        return s + "***/";
    }

    @Override
    public String getType() {
        return "binaryData";
    }
}
