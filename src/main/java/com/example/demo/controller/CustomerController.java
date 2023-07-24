package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.DeliveryInfo;
import com.example.demo.form.InputForm;
import com.example.demo.service.DeliveryInfoService;

@RequestMapping("/customer")
@Controller
@SessionAttributes(value = "inputForm")
public class CustomerController {
	
	DeliveryInfoService di;
	
	public CustomerController(DeliveryInfoService di) {
		this.di = di;
	}
	
	@ModelAttribute("inputForm")
	public InputForm setUpinputForm() {
		return new InputForm();
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
	public ModelAndView deliveryRequestConfirm(@ModelAttribute("inputForm") InputForm inputF, @Validated InputForm inputForm, BindingResult bindingResult, ModelAndView mav) {
		if (bindingResult.hasErrors()) {
			mav.setViewName("customer/sender-form");
			return mav;
		}
		mav.addObject(inputForm);
		mav.setViewName("customer/confirm");
		
		inputF.setSenderName(inputForm.getSenderName());
		inputF.setSenderKanaName(inputForm.getSenderKanaName());
		inputF.setSenderBirth(inputForm.getSenderBirth());
		inputF.setSenderPostCode(inputForm.getSenderPostCode());
		inputF.setSenderAddress(inputForm.getSenderAddress());
		inputF.setPickUpAt(inputForm.getPickUpAt());
		inputF.setReceiverName(inputForm.getReceiverName());
		inputF.setReceiverKanaName(inputForm.getReceiverKanaName());
		inputF.setReceiverPostCode(inputForm.getReceiverPostCode());
		inputF.setReceiverAddress(inputForm.getReceiverAddress());
		inputF.setArriveAt(inputForm.getArriveAt());
		inputF.setQuantity(inputForm.getQuantity());
		
		return mav;
	}
	
	@PostMapping("/deliveryr-request-execute")
	public ModelAndView deliveryRequestExecute(@ModelAttribute("inputForm") InputForm inputF, BindingResult bindingResult, ModelAndView mav) {
		
		InputForm inputForm = inputF;
		
		DeliveryInfo deliveryInfo = new DeliveryInfo();
		
		System.out.println(inputForm.getSenderName());
		System.out.println(inputForm.getSenderPostCode());
		
		deliveryInfo.setSenderName(inputForm.getSenderName());
		deliveryInfo.setSenderKanaName(inputForm.getSenderKanaName());
		deliveryInfo.setSenderBirth(inputForm.getSenderBirth());
		deliveryInfo.setSenderPostCode(inputForm.getSenderPostCode());
		deliveryInfo.setSenderAddress(inputForm.getSenderAddress());
		deliveryInfo.setPickUpAt(inputForm.getPickUpAt());
		deliveryInfo.setReceiverName(inputForm.getReceiverName());
		deliveryInfo.setReceiverKanaName(inputForm.getReceiverKanaName());
		deliveryInfo.setReceiverPostCode(inputForm.getReceiverPostCode());
		deliveryInfo.setReceiverAddress(inputForm.getReceiverAddress());
		deliveryInfo.setArriveAt(inputForm.getArriveAt());
		
		di.insertDelilveryInfo(deliveryInfo);
		
		mav.addObject(inputForm);
		mav.setViewName("customer/complete");
		
		return mav;
	}
	
}
