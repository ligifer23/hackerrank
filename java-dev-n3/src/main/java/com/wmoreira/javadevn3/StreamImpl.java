package com.wmoreira.javadevn3;

/**
 * @author wellington.362@gmail.com
 */

public class StreamImpl implements Stream {

    private String str = "";
    private int pos = 0;

    public StreamImpl(String str) {
        this.str = str;
    }

    @Override
    public char getNext() {
        if (pos > str.length() - 1) {
            throw new IllegalStateException("Stream is closed");
        }
        return str.charAt(pos++);
    }

    @Override
    public boolean hasNext() {
        return pos <= str.length() - 1;
    }
}
