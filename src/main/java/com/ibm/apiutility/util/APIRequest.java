package com.ibm.apiutility.util;

import java.util.List;

public class APIRequest {
public String url;
public String type;
public String payload;
public List<Header> headers;
public List<Header> getHeaders() {
	return headers;
}
public void setHeaders(List<Header>headers) {
	this.headers = headers;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getPayload() {
	return payload;
}
public void setPayload(String payload) {
	this.payload = payload;
}
@Override
public String toString() {
	return "APIRequest [url=" + url + ", type=" + type + ", payload=" + payload
			+ ", headers=" + headers.toString() + "]";
}

}
