package com.test.hplus.convertors;

import com.test.hplus.beans.Gender;
import org.springframework.core.convert.converter.Converter;


public class StringToEnumConvertor implements Converter<String, Gender> {
    /*convert String to other datatype ---- GENDER type*/

    @Override
    public com.test.hplus.beans.Gender convert(String s) {
        if(s.equals("Male")){
            return Gender.MALE; }
        else if(s.equals("Female")){
            return Gender.FEMALE;
        }
        else return Gender.OTHER;
    }
}
