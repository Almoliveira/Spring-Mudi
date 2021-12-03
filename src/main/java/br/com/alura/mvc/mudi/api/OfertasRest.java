package br.com.alura.mvc.mudi.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

	@Autowired
	private PedidoRepository pedidoRpeository;
	
	
	
	@PostMapping
	public Oferta criaOferta(RequisicaoNovaOferta requisicao) {
		Optional<Pedido> pedidoBuscado = pedidoRpeository.findById(requisicao.getPedidoID());
		if(pedidoBuscado.isPresent()) {
			return null;
		}
		Pedido pedido = pedidoBuscado.get();
		Oferta nova = requisicao.toOferta();
		
		nova.setPedido(pedido);
		pedido.getOfertas().add(nova);
		pedidoRpeository.save(pedido);
		
		return nova;
	}
}
