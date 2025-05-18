package springboot.grupoextra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import springboot.grupoextra.Service.PedidoService;
import springboot.grupoextra.model.PedidoModel;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/fazerPedido")
    public PedidoModel fazerPedido(@RequestBody PedidoModel pedido) {
        try {
            return pedidoService.criarPedido(pedido);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao criar pedido");
        }
    }

    @GetMapping("/buscarPedidoPor{emailCliente}")
    public PedidoModel buscarPedidoPorEmail(@RequestParam String emailCliente) {
        try {
            return pedidoService.buscarPedidoPorEmail(emailCliente);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao buscar pedido");
        }
    }

    









}