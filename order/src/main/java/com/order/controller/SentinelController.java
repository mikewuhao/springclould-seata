package com.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SentinelController {

	@RequestMapping("/testSentinel")
	@SentinelResource(value = "limit",blockHandler ="exceptionHanlder" )
	//服务熔断
	@HystrixCommand(fallbackMethod = "fallback_zs2",commandProperties = {
			//设置这个线程的超时时间是3s，3s内是正常的业务逻辑，超过3s调用fallbackMethod指定的方法进行处理
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
	})
	public String sentinel() throws InterruptedException {
		//Thread.sleep(4000);
		return "hello sentinel";
	}


	public String exceptionHanlder()
	{
		return "exception hanlder";
	}

	public String fallback_zs2()
	{
		return "fallback_zs2";
	}

	@PostConstruct
	public void initRule(){
		List<DegradeRule> rules = new ArrayList<>();
		DegradeRule rule = new DegradeRule();
		rule.setResource("sentinel_rule");
		rule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
		rule.setCount(0.000001);
		rule.setTimeWindow(10);
		rules.add(rule);
		DegradeRuleManager.loadRules(rules);

		List<FlowRule> ruleList = new ArrayList<>();
		FlowRule flowRule = new FlowRule();
		flowRule.setResource("limit");
		flowRule.setGrade(1);
		flowRule.setCount(1);
		ruleList.add(flowRule);
		FlowRuleManager.loadRules(ruleList);
	}
}
