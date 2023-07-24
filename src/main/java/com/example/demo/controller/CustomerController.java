package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.DeliveryInfo;
import com.example.demo.form.InputForm;
import com.example.demo.service.DeliveryInfoService;

@RequestMapping("/customer")
@Controller
public class CustomerController {
	
	DeliveryInfoService di;
	
	public CustomerController(DeliveryInfoService di) {
		this.di = di;
	}
	
	/**
	 * 配送元情報入力画面を表示するメソッド
	 */
	@GetMapping("/sender-form")
	public ModelAndView deliveryRequestSenderForm(ModelAndView mav) {
		mav.addObject("inputForm", new InputForm());
		mav.setViewName("customer/sender-form");
		return mav;
	}
	
	/**
	 * 配送依頼情報の確認画面を表示するメソッド
	 */
	@PostMapping("/request-confirm")
	public ModelAndView deliveryRequestConfirm(@Validated InputForm inputForm, BindingResult bindingResult, ModelAndView mav) {
		if (bindingResult.hasErrors()) {
			mav.setViewName("customer/sender-form");
			return mav;
		}
		mav.addObject(inputForm);
		mav.setViewName("customer/confirm");
		
		return mav;
	}
	
	@PostMapping("/deliveryr-request-execute")
	public ModelAndView deliveryRequestExecute(@Validated InputForm inputForm, BindingResult bindingResult, ModelAndView mav) {
		DeliveryInfo deliveryInfo = new DeliveryInfo();
		
		System.out.println(inputForm.getSenderBirth());
		deliveryInfo.setSenderName(inputForm.getSenderName());
		deliveryInfo.setSenderKanaName(inputForm.getSenderKanaName());
		deliveryInfo.setSenderBirth(inputForm.getSenderBirth());
		deliveryInfo.setSenderPostCord(inputForm.getSenderPostCord());
		deliveryInfo.setSenderAddress(inputForm.getSenderAddress());
		deliveryInfo.setPickUpAt(inputForm.getPickUpAt());
		deliveryInfo.setReceiverName(inputForm.getReceiverName());
		deliveryInfo.setReceiverKanaName(inputForm.getReceiverKanaName());
		deliveryInfo.setReceiverPostCord(inputForm.getReceiverPostCord());
		deliveryInfo.setReceiverAddress(inputForm.getReceiverAddress());
		deliveryInfo.setArriveAt(inputForm.getArriveAt());
		
		di.insertDelilveryInfo(deliveryInfo);
		
		mav.addObject(inputForm);
		mav.setViewName("customer/complete");
		
		return mav;
	}
	
}
