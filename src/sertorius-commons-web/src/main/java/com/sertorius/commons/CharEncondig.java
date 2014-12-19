package com.sertorius.commons;

import com.sertorius.commons.util.lang.Commons;

/**
 * TODO comment<br>
 * 
 * @author caesar
 */
public enum CharEncondig {
    
    UTF8("UTF-8"),
    ISO_8859_1("iso-8859-1");
    
    
    private final String encoding;
    
    
    CharEncondig(final String encoding) {
        this.encoding = encoding;
    }

    
    
    public String getStringValue() {
        return this.encoding;
    }
    
    
    
    /**
     * TODO comment<br>
     * 
     * @param role
     * @return
     */
    public static CharEncondig fromString(final String encoding) {
        if (Commons.isEmpty(encoding)) return null;
        
        for (CharEncondig e : values()) {
            if (e.getStringValue() == encoding) return e;
        }
        
        return null;
    }
}
