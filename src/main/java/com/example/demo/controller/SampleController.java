package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
@Controller
public class SampleController {
	@GetMapping("/")
	public ModelAndView index(ModelAndView mav) {	//　ModelAndView→モデルとviewをセットにして扱うためのクラス基本これをリターンする
		mav.setViewName("index");	//  .setViewName()メソッドで表示するhtmlのファイル名をセットする
		return mav;
	}
}
