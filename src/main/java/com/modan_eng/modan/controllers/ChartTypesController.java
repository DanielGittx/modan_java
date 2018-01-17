package com.modan_eng.modan.controllers;


import com.modan_eng.modan.services.CctvService;
import com.modan_eng.modan.services.CreateBucket;
import com.modan_eng.modan.services.NeuralNetworkStockPredictor;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/chart-types", method = RequestMethod.GET)
public class ChartTypesController {
    
        	@RequestMapping(value = "/cctv_data_mgt", method = RequestMethod.GET)   //Name of JSP to GET
	public ModelAndView Cctv_data_mgt() throws IOException {
                ModelAndView mav = new ModelAndView("ChartTypes/cctv_data_mgt"); //Name of associated JSP
		mav.addObject("title", "CCTV Data");
                CctvService cs = new CctvService();
                //CreateBucket Cbucket = new CreateBucket();
                //NeuralNetworkStockPredictor.results();
                //mav.addObject("filesize",cs.getFileSize("C:/Users/danial/Downloads/credentials"));
                mav.addObject("filesize",cs.getFileSize("H:/HIGH LEVEL/Projects/Retail Analytics/File_system_video/faithful_.mp3")); //NB:-The objects need to be added through JstlView Class
                //cs.UploadObjectMPULowLevelAPI();   //TODO:- Uploading to AWS
                //Cbucket.CreateBucketAWS();
                cs.webcam_service();
                mav.addObject("number_of_files_in_folder",cs.getNumberOfFilesInFolder());    //TODO:- Evaluate need to display names of all items in content folder. 
                mav.addObject("content_folder_capacity",cs.getCapacityOfContentFolder());
                return mav;
	}
    
    	@RequestMapping(value = "/realtime", method = RequestMethod.GET)
	public ModelAndView Realtime() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/realtime");
		modelAndView.addObject("title", "Real Time");
		return modelAndView;
	}
        
            
    	@RequestMapping(value = "/overview", method = RequestMethod.GET)
	public ModelAndView Overview() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/overview");
		modelAndView.addObject("title", "Overview");
		return modelAndView;
	}
	
	@RequestMapping(value = "/area", method = RequestMethod.GET)
	public ModelAndView Area() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/Area");
		modelAndView.addObject("title", "Area Chart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/column", method = RequestMethod.GET)
	public ModelAndView Column() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/Column");
		modelAndView.addObject("title", "Column Chart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/bar", method = RequestMethod.GET)
	public ModelAndView Bar() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/Bar");
		modelAndView.addObject("title", "Bar Chart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/bubble", method = RequestMethod.GET)
	public ModelAndView Bubble() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/Bubble");
		modelAndView.addObject("title", "Bubble Chart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/doughnut", method = RequestMethod.GET)
	public ModelAndView Doughnut() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/Doughnut");
		modelAndView.addObject("title", "Doughnut Chart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/line", method = RequestMethod.GET)
	public ModelAndView Line() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/Line");
		modelAndView.addObject("title", "Line Chart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/pie", method = RequestMethod.GET)
	public ModelAndView Pie() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/Pie");
		modelAndView.addObject("title", "Pie Chart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/scatter", method = RequestMethod.GET)
	public ModelAndView Scatter() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/Scatter");
		modelAndView.addObject("title", "Scatter Chart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/spline", method = RequestMethod.GET)
	public ModelAndView Spline() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/Spline");
		modelAndView.addObject("title", "Spline Chart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/spline-area", method = RequestMethod.GET)
	public ModelAndView SplineArea() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/SplineArea");
		modelAndView.addObject("title", "Spline Area Chart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/stacked-area", method = RequestMethod.GET)
	public ModelAndView StackedArea() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/StackedArea");
		modelAndView.addObject("title", "Stacked Area Chart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/stacked-area100", method = RequestMethod.GET)
	public ModelAndView StackedArea100() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/StackedArea100");
		modelAndView.addObject("title", "Stacked Area 100% Chart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/stacked-bar", method = RequestMethod.GET)
	public ModelAndView StackedBar() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/StackedBar");
		modelAndView.addObject("title", "Stacked Bar Chart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/stacked-bar100", method = RequestMethod.GET)
	public ModelAndView StackedBar100() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/StackedBar100");
		modelAndView.addObject("title", "Stacked Bar 100% Chart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/stacked-column", method = RequestMethod.GET)
	public ModelAndView StackedColumn() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/StackedColumn");
		modelAndView.addObject("title", "Stacked Column  Chart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/stacked-column100", method = RequestMethod.GET)
	public ModelAndView StackedColumn100() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/StackedColumn100");
		modelAndView.addObject("title", "Stacked Column 100% Chart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/step-area", method = RequestMethod.GET)
	public ModelAndView StepArea() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/StepArea");
		modelAndView.addObject("title", "Step Area Chart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/step-line", method = RequestMethod.GET)
	public ModelAndView StepLine() {
		ModelAndView modelAndView = new ModelAndView("ChartTypes/StepLine");
		modelAndView.addObject("title", "Step Line Chart");
		return modelAndView;
	}

}