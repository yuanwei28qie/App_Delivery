package com.microsilver.mrcard.basicservice.mq;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import com.microsilver.mrcard.basicservice.utils.PropertiesUtil;

/**
 * 队列配置类
 */
@Configuration
public class AmqpConfig {
	// 链接工厂
	//private ConnectionFactory connectionFactory;

	// 生产端路由配置
	private Map<String, RouteConfig> routeConfig = new ConcurrentHashMap<>();

	private String configName = "rabbitmq.properties";

	// 配置文件
	private Properties prop;

	{
		this.initConfig();
	}

	public RouteConfig getRouteConfig(String business) {
		return this.routeConfig.get(business);
	}
	/*@Bean
	public RabbitAdmin rabbitAdmin(@Qualifier("connectionFactory")ConnectionFactory connectionFactory){
	    return new RabbitAdmin(connectionFactory);
	}*/

	// 这里最好每次都返回一个新的RabbitTemplate对象，这样如果发送消息后的回调才会有序
	// 现在回调还没有用上，我就直接使用单例了
	// 注意，如果要使用回调除了加上@Scope注解还需要 rabbitTemplate.setConfirmCallback(this);
	@Bean
	// @Scope(value = "prototype")
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		return template;
	}
	@Bean  
    public DirectExchange msgExchange() {  
        return new DirectExchange(prop.getProperty("rabbitmq.send1.exchange"));
    }  
	
	@Bean
	public Queue msgQueue() {
		return new Queue(prop.getProperty("rabbitmq.send1.queue"), true); // 队列持久
	}
	
	@Bean
	public Binding bindingMsg() {
		return BindingBuilder.bind(msgQueue()).to(msgExchange()).with(prop.getProperty("rabbitmq.send1.routingkey"));
	}
	
	public void initConfig() {
		Properties prop = PropertiesUtil.loadProperties(this.configName);
		this.refreshConfig(prop);
	}
	
	@Bean  
    public ConnectionFactory connectionFactory() {  
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();  
        connectionFactory.setAddresses(prop.getProperty("rabbitmq.host"));
        connectionFactory.setPort(Integer.parseInt(prop.getProperty("rabbitmq.port")));
        connectionFactory.setUsername(prop.getProperty("rabbitmq.username"));  
        connectionFactory.setPassword(prop.getProperty("rabbitmq.password"));  
        connectionFactory.setVirtualHost(prop.getProperty("rabbitmq.virtualHost"));  
        connectionFactory.setPublisherConfirms(false); //必须要设置  
        return connectionFactory;
        
        
    }  
	
	public void refreshConfig(Properties prop) {
		try {
			// 配置没有变更，不用更新
			if (this.prop != null && this.prop.equals(prop)) {
				return;
			}

			// 1、连接工厂
			/*String host = prop.getProperty("rabbitmq.host");
			String port = prop.getProperty("rabbitmq.port");
			String username = prop.getProperty("rabbitmq.username");
			String password = prop.getProperty("rabbitmq.password");
			String virtualHost = prop.getProperty("rabbitmq.virtualHost");
			String connectionFactoryKey = host + port + virtualHost + username + password;
			prop.setProperty("connectionFactoryKey", connectionFactoryKey);
			if (this.prop == null || !connectionFactoryKey.equals(this.prop.getProperty("connectionFactoryKey"))) {
				if (this.connectionFactory != null) {
					this.connectionFactory.clearConnectionListeners();
				}
				CachingConnectionFactory factory = new CachingConnectionFactory();
				factory.setAddresses(host + ":" + port);
				factory.setUsername(username);
				factory.setPassword(password);
				factory.setVirtualHost(virtualHost);
				this.connectionFactory = factory;
			}*/

			this.prop = prop;

			// 2、生产端
			if (!prop.containsKey("rabbitmq.send.business")) {
				// 有可能有多组路由映射
				for (int i = 1; i <= 10; i++) {
					RouteConfig routeConfig = this.createRouteMapping("" + i);
					if (routeConfig == null) {
						break;
					}
				}
			} else {
				// 默认没有序号只处理一个映射
				this.createRouteMapping("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 路由映射
	private RouteConfig createRouteMapping(String tag) {
		String business = prop.getProperty("rabbitmq.send" + tag + ".business");
		if (business == null) {
			return null;
		}
		Assert.hasLength(business, "业务名称不能为空且不能重复");
		String exchange = prop.getProperty("rabbitmq.send" + tag + ".exchange");
		Assert.hasLength(exchange, "exchange不能为空");
		String routingkey = prop.getProperty("rabbitmq.send" + tag + ".routingkey");
		Assert.hasLength(routingkey, "routingkey不能为空");

		RouteConfig routeConfig = new RouteConfig();
		routeConfig.exchange = exchange;
		routeConfig.routingkey = routingkey;
		this.routeConfig.put(business, routeConfig);

		return routeConfig;
	}

	class RouteConfig {

		String exchange;

		String routingkey;
	}
}
