package in.ineuron.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.ineuron.service.StockService;

@Controller
public class StockUIController {

	@Autowired
	private StockService service;
	
	/* Since UI is default page so "/" */
	@GetMapping("/")
	public String loadPage() {
		System.out.println("StockUIController loadPage()");
		return "index";
	}

	@GetMapping("/getTotalCost")
	public String getTotalCost(HttpServletRequest request, Model model) {
		System.out.println("StockUIController.getTotalCost()");

		String companyName = request.getParameter("companyName");
		String quantity = request.getParameter("quantity");

		String response = service.getTotalStockPrice(companyName, Integer.parseInt(quantity));
		model.addAttribute("msg", response);
		return "index";
	}

}
