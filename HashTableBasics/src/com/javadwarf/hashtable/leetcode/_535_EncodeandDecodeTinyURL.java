package com.javadwarf.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _535_EncodeandDecodeTinyURL {

	Map<String,String> encode = null;
    Map<String,String> decode = null;
    
    public _535_EncodeandDecodeTinyURL(){
        encode = new HashMap<>();
        decode = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String tinyUrl = "";
        if(encode.containsKey(longUrl)){
            return encode.get(longUrl);
        }
        else{
            String temp = Integer.valueOf(longUrl.hashCode()).toString();
            tinyUrl = "http://tinyurl.com/"+temp;
            encode.put(longUrl,tinyUrl);
            decode.put(tinyUrl,longUrl);
        }
        return tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decode.getOrDefault(shortUrl,"");
    }
}
