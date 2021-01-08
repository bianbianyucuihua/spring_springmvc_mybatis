package com.hongyi.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDate implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if(source!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date parse = sdf.parse(source);
                return parse;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
