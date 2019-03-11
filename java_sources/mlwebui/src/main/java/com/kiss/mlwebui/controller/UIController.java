package com.kiss.mlwebui.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.kiss.mlwebui.model.UIModel;
import com.kiss.mlwebui.prediction.*;
//import com.kiss.prediction.ml.*;

@Controller
public class UIController {
	String message;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showIndex(Model model) {

		model.addAttribute("command", new UIModel());
		return "index";
	}
	
    @RequestMapping("/result")
    public String showResult(@ModelAttribute("command") UIModel form, BindingResult result, Model model) { // (1)

    	
    	String myPrediction = "";
    	ArrayList<String> list = new ArrayList<String>();
   	
    	list.add(form.getParam01());
    	list.add(form.getParam02());
    	list.add(form.getParam03());
    	list.add(form.getParam04());
    	list.add(form.getParam05());
    	list.add(form.getParam06());
    	list.add(form.getParam07());
    	list.add(form.getParam08());
    	list.add(form.getParam09());
    	list.add(form.getParam10());
    	list.add(form.getParam11());
    	list.add(form.getParam12());
    	list.add(form.getParam13());
    	list.add(form.getParam14());
    	list.add(form.getParam15());
    	list.add(form.getParam16());
    	list.add(form.getParam17());
    	list.add(form.getParam18());
    	list.add(form.getParam19());
    	list.add(form.getParam20());
    	list.add(form.getParam21());
    	list.add(form.getParam22());
    	list.add(form.getParam23());
    	list.add(form.getParam24());
    	list.add(form.getParam25());
    	list.add(form.getParam26());
    	list.add(form.getParam27());
    	list.add(form.getParam28());
    	list.add(form.getParam29());
    	list.add(form.getParam30());
    	list.add(form.getParam31());
    	list.add(form.getParam32());
    	list.add(form.getParam33());
    	list.add(form.getParam34());
    	list.add(form.getParam35());
    	list.add(form.getParam36());
    	list.add(form.getParam37());
    	list.add(form.getParam38());
    	list.add(form.getParam39());
    	list.add(form.getParam40());
    	list.add(form.getParam41());
    	list.add(form.getParam42());
    	list.add(form.getParam43());
    	list.add(form.getParam44());
    	list.add(form.getParam45());
    	list.add(form.getParam46());
    	list.add(form.getParam47());
    	list.add(form.getParam48());
    	list.add(form.getParam49());
    	list.add(form.getParam50());
    	list.add(form.getParam51());
    	list.add(form.getParam52());
    	
    	System.out.println("Items:");
		for(String item:list) {
			
			System.out.println(item);
		}
    	
		myPrediction = Prediction.predict(list);
    		
    	form.setPrediction(myPrediction);
    	System.out.println(myPrediction);
    	
        model.addAttribute("prediction", form.getPrediction());
        return "result";
    }
}