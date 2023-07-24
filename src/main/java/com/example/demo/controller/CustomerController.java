package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.form.InputForm;

@RequestMapping("/customer")
@Controller
public class CustomerController {
	
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
	
}
