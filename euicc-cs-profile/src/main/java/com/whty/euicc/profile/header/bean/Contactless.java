package com.whty.euicc.profile.header.bean;
import com.whty.euicc.profile.parent.JavaBean;
/**
 * header子元素
 * 结构类型：简单类型
 * @author Administrator
 *
 */
public class Contactless extends JavaBean{
	public String tag = "80";
	public String length = "00";
	public String value;
	
	public Contactless() {
		
	}
	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Contactless [length=" + length + ", tag=" + tag + ", value="
				+ value + ", number=" + number + "]";
	}
	
	
}
