package com.wise.csv.cron;

import com.thoughtworks.xstream.converters.SingleValueConverter;

/**
 * Project : demo
 * Package : com.wise.test
 * FileName : converter
 * Date : 16. 12. 26
 * XmlElement : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
class Converter implements SingleValueConverter {

    public String toString(Object obj) {
        return ((XmlElement) obj).getName();
    }

    public Object fromString(String name) {
        return new XmlElement(name);
    }

    public boolean canConvert(Class type) {
        return type.equals(XmlElement.class);
    }

}