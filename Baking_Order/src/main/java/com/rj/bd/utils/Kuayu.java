package com.rj.bd.utils;

import javax.servlet.http.HttpServletResponse;

public class Kuayu {
	public static void setResponse(HttpServletResponse response) {
		// 指定允许其他域名访问
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 跨域 Header
		response.setHeader("Access-Control-Allow-Headers", "*");
		// 允许请求的类型 post get 这些
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setCharacterEncoding("utf-8");
		// 设置返回的文件类型
		response.setContentType("application/json;charset=UTF-8");
	}
}
