package com.global.commtech.test.anagramfinder.util;

public enum Alphabet {
    a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,x,y,z;

    public static int getAlphabeticalSum(final char[] chars) {
        int wordValue = 0;
        for (final char aChar : chars) {
            wordValue += aChar;
        }
        return wordValue;
    }
}
