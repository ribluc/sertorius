package com.sertorius.commons.datetime;

/**
 * TODO comment<br>
 * 
 * @author caesar
 */
public enum DateTimeFormat {

    DDMMYYYY {
        @Override
        public String getFormat() {
            return "dd/MM/yyyy";
        }
    },
    DDMMYYYYHHMMSS {
        @Override
        public String getFormat() {
            return "dd/MM/yyyy HH:mm:ss";
        }
    },
    MMDDYYYY {
        @Override
        public String getFormat() {
            return "MM/dd/yyyy";
        }
    },
    YYYYMMDD {
        @Override
        public String getFormat() {
            return "yyyyMMdd";
        }
    },
    YYYYMMDDHHMMSS {
        @Override
        public String getFormat() {
            return "yyyy-MM-dd HH:mm:ss";
        }
    };

    
    
    /**
     * TODO comment<br>
     * 
     * @return
     */
    public abstract String getFormat();
}
