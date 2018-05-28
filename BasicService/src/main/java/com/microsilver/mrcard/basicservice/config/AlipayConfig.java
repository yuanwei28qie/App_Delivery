package com.microsilver.mrcard.basicservice.config;

public class AlipayConfig {
	// 1.商户appid
	public static String APPID = "2018050860119126";

	// 2.支付宝公钥
	public static String ALIPAY_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnuw1rHyFT4T3kfl1I7C4REIbm1fS/Vui3fV4flthlXjBUhPAZ9gFNM66AqC7HYWAbjlKH28Pnu0Pez2iMy56F3EsSaE/VlqGVqHtqwyGRHUE+fi0hyIQtDk3UXsx46MffuvABoUKDc7YPEG4ExnE1aYnYGf2+Tb/5OAbkCbJKedp7vvxK/4uuD6op77g94SnrpcvQjmWq30W1dU8CK3Lfu0Wmy0QB4tQTvOJ7W3dS3oSz2WoW7c01yo1pIse/hOE9sO35vwVt7NLU4j28NC2uGYyOoD+nKLV9FI9vLmIUfPQSnuSKa9rl/i0DKWJL9fmhfc+FJOjFzpfNJD/ZLaZ0wIDAQAB";
	// 3. 支付宝应用私钥
	public static String ALIPAY_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDp80RmmzC6L+/I2Ak/hmQYT6XlbAnl6w0HHwdmf+BbQ3bmyhUTweYOhecd3b/+Huj2gP2jprylfX6+Gh89WiXDDXhEbZj4Nt0JektmvpxganyZFzq+2/NG5EHuwUPEwypIOfWD+4FuhfPnL1OnGLsIVZXlIxR9TyFukASs6bxElQF0bVrxy+dQz106s/Uj3e3SuwiprFj3zKG/Epcfy3sdv4VHgzJLmKQpiNciwOm6VzFmWxIEXfjZ+XlMQUsX29r8RYT0yKiimy+17y5ljiTcskAsix5yNSZB/rYTkKNptX2Gp1AyWHJHiUn5v2iAtgIx/EmV5X8xNTk5amYExXw9AgMBAAECggEAVn+aT7Gbb4ufxYuSx8kBozd3p/6tHjQs6fAgBVbMdhHYmXYoGtj7HW2GyTUe8m8tRU7l+KcCYtGmldUEreNxyM9nIy2+fC+UxBdSX5ekK8XTcar0DnM2XISyl/se+lYKgQ/k5bqM3XdreZO3AzYSmP9D36d7wOUMAFwBTolREa2tEUT8eInh+2xhvWVVvtsOM0O8GQs7UbjkO0ImUAylLkUNlUfcc4tT8bty50YfirymSUZafQNfGitz/FiI48jJV63EkysBUWPsWAi+H4LsfE11c3jQt97Nh8gPwvTWTN4/SVrd2froBDkPhZ2g1oKcJu78V1+6G4Vj7GvGbZxC5QKBgQD4oVjJQoQe/wGd7baZkggHrF1tDXfhyOJfgkMfNKgJlPI5+GoInchJTgw8cQySD1Nj8rSEPm+EpXZqCUO7tRniDIyKekDIphExfEwJJFO5uysfoyVoP1LkvOxhj9SETFCmNpPAB20exBR7hOCmEgycWxej9I1bZC+FbfyMSBDBQwKBgQDw4oaZgf7DLoX8+z9l26JPRJ0nAcCFiqNTckEvD3CufsX2sMcDKlMR+sFCZR5f4OTrvgrcNtn3m0ryhu2oRgOJjjTnJ+15JI5/HktRM9IcSDpan6pcZlcfGn8UjdQiDhRYSKBhrvEYQM/DWHhLqMkV865nSwcXPz7dXq0oULw0fwKBgEP/vMyuiHwBumt7DCnMKq4Oki61NEhoLKF6eukZ+atFNUptinJ41MJXujj9ojaAQopfYseYW9+ncU9m4UOBMGcGj5l//h/ia2lhWVpWuR9e9VhdwmlUiFNO6Ed2kuTsClKrMpWeclWrwv5VRSumXBSXRUvuIosQR37yqdOkEhEJAoGAf5m/azmtVn8iguwknTRHOm5CQRNwhEz4T4/Kb79iFU0aWJ80DL0y2+dU0HL4MBnVqfs1jYmQ1NTyUp6e7fCIlyk5ZOmFphJzWWsWwqEMv+aS4saJXADqTZOflae7o36J0GpIavZcyFgstnH65zk1q+c1j4ny66GZD3LDjwOVbskCgYEAs0CnuiazU+Wo4DrnSFHn9YMB19HyYYkBL1AVu7dWanuRf2Ooxpt0CRnYdOwRQQMbGO7xi/FC6ht6lqL5b7z/rgd5U2a9RT8ZwDo9tvAcOBXqm+Y60C0XBonMZZmpAbXxhX5oF0jnbQ6bSLvzGZW7kuC4NR2vWrkODhwOJ+TwJCM=";
	// 4.服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//public static String notify_url = "http://www.xxx.com/alipay/notify_url.do";
	public static String notify_url = "http://211.149.164.182:8081/api/pay/notify";

	// 5.页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	public static String return_url = "http://211.149.164.182:8081/api/pay/notify";

	// 6.请求网关地址
	public static String URL = "https://openapi.alipay.com/gateway.do";

	// 7.编码
	public static String CHARSET = "UTF-8";

	// 8.返回格式
	public static String FORMAT = "json";

	// 9.加密类型
	public static String SIGNTYPE = "RSA2";
}
