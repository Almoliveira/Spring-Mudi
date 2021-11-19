package br.com.alura.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeController {
	
	
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Xiaomi Redmi Note 10");
		pedido.setUrlProduto("https://www.amazon.com.br/Xiaomi-Redmi-Note-Vers%C3%A3o-global/dp/B08YFLGZB4/ref=sr_1_5?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2TCUHBB916L7S&keywords=xiaomi+redmi+note+10&qid=1637274706&sprefix=xiamoi+red%2Caps%2C317&sr=8-5&ufe=app_do%3Aamzn1.fos.25548f35-0de7-44b3-b28e-0f56f3f96147");
		pedido.setUrlImagem("https://m.media-amazon.com/images/I/61bD+2ZxGyS._AC_SL1500_.jpg");
		pedido.setDescricao("Uma descrição qualquer para esse pedido");
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos",pedidos);
		
		return "home";
	}
}
