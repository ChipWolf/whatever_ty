package com.whty.euicc.profile.nonStandard.bean;

import com.whty.euicc.profile.parent.JavaBean;

/**
 * NonStandard子元素
 * 结构类型：简单类型
 * @author Administrator
 *
 */
public class Content extends JavaBean{
	private String tag ="82";
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "Mandated [length=" + length + ", tag=" + tag + ", number="
				+ number + ", value=" + value + "]";
	}
}
