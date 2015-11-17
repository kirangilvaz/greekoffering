package com.ibm.apiutility.util;

public class Header {
public String key;
public String value;
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
@Override
public String toString() {
	return "Header [key=" + key + ", value=" + value + "]";
}
}
