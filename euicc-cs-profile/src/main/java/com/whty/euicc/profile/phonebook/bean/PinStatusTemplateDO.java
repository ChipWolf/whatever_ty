package com.whty.euicc.profile.phonebook.bean;
import com.whty.euicc.profile.parent.JavaBean;
/**
 * Phonebook子元素
 * 结构类型：简单类型
 * @author Administrator
 *
 */
public class PinStatusTemplateDO extends JavaBean{
	private String tag ="C6";
	private String length;
	private String value;
	
	public PinStatusTemplateDO() {
		
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
		return "PinStatusTemplateDO [length=" + length + ", tag=" + tag
				+ ", value=" + value + ", number=" + number + "]";
	}
}
