package com.orcamento.cerca.config;

import com.orcamento.cerca.model.Cliente;
import com.orcamento.cerca.model.ItemOrcamento;
import com.orcamento.cerca.model.Orcamento;
import com.orcamento.cerca.repository.ClienteRepository;
import com.orcamento.cerca.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private OrcamentoRepository orcamentoRepository;


    public void run(String... args) throws Exception {

     /*   Cliente c1 = new Cliente(null, "Maria Silva", "maria@gmail.com");
        Cliente c2 = new Cliente(null, "João Souza", "joaozinho@gmail.com");

        clienteRepository.saveAll(Arrays.asList(c1, c2));


        Orcamento o1 = new Orcamento();
        o1.setCliente(c1);
        o1.setDataCadastro(LocalDateTime.now());


        ItemOrcamento i1 = new ItemOrcamento();
        i1.setTamanhoPainel("6x6");
        i1.setCor("Branco");
        i1.setMaterialEscolhido("PVC");

        i1.setTotalLinear(new BigDecimal("100"));
        i1.setPortaoIncluso(true);
        i1.setPortaoQuantidade(1);

        i1.setValorTotal(new BigDecimal("1200.00"));


        o1.addItem(i1);


        o1.setValorTotal(i1.getValorTotal());

        orcamentoRepository.save(o1);

    }
*/}


}
