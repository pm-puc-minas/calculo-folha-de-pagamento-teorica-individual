package com.folha;

import com.folha.domain.entity.Funcionario;
import com.folha.domain.entity.Usuario;
import com.folha.domain.enums.GrauInsalubridade;
import com.folha.repository.FuncionarioRepository;
import com.folha.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(FuncionarioRepository funcRepo,
                                      UsuarioRepository usuarioRepo,
                                      PasswordEncoder encoder) {
        return args -> {
            if (usuarioRepo.findByUsername("admin").isEmpty()) {
                Usuario u = new Usuario("admin", encoder.encode("admin"));
                usuarioRepo.save(u);
            }

            if (funcRepo.count() == 0) {
                Funcionario f = new Funcionario();
                f.setNome("Funcionário Exemplo");
                f.setCpf("00000000000");
                f.setSalarioBase(BigDecimal.valueOf(3000.00));
                f.setHorasDia(8);
                f.setDiasMes(22);
                f.setRecebePericulosidade(true);
                f.setRecebeInsalubridade(true);
                f.setGrauInsalubridade(GrauInsalubridade.MEDIO);
                f.setUsaValeTransporte(true);
                f.setValorVT(BigDecimal.valueOf(200));
                f.setUsaValeAlimentacao(true);
                f.setValorVA(BigDecimal.valueOf(500));

                funcRepo.save(f);
            }
        };
    }
}
