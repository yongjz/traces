package com.waterwood.common;

public class Global {

	/**
	 * 当前对象实例
	 */
	private static Global global = new Global();

	/**
	 * 判断该二维码是否被开启过，初始是未开启
	 */
	public static boolean qrcodeStatus = false;

	/**
	 * 物流信息页面
	 */
	public static final String URL_LOGISTICS = "pages/qrdemo/logistics.html";
	/**
	 * 验证信息页面
	 */
	public static final String URL_VALIDATE = "pages/qrdemo/validate.html";

	/**
	 * 获取当前对象实例
	 */
	public static Global getInstance() {
		return global;
	}
}
