package com.zzty.Scan;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zzty.filter.Authentication;
import com.zzty.services.UserService;
import com.zzty.services.UserServiceImpl;

@Component
public class TokenScan extends Authentication {

	private UserService userService;

	@PostConstruct
	public void postConstruct() {// 在构造函数之后去调用的一种方法
		ScheduledExecutorService es = Executors.newScheduledThreadPool(1);
		  Date a = new Date();
	         Calendar cal = Calendar.getInstance();
	         cal.add(Calendar.MINUTE,15);
	         a.setValidateTime(cal.getTime()); 
			
		es.scheduleAtFixedRate(new Runnable() {
       
			@Override
			public void run() {
				
				for (String token :  UserServiceImpl.tokenMap.hashCode()) {
					if (UserServiceImpl.tokenMap.get(token).getTime()  >= a) {
						UserServiceImpl.tokenMap.remove(token);
						
					} 
				}
			}}, 0, 1, TimeUnit.MINUTES);

	}
	}




