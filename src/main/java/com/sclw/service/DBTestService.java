package com.sclw.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sclw.model.Estado;
import com.sclw.model.Pessoa;
import com.sclw.enums.Perfil;
import com.sclw.repository.EstadoRepository;
import com.sclw.repository.PessoaRepository;

@Service
public class DBTestService {

	@Autowired 
	BCryptPasswordEncoder bCrypt;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;
		
	public void instantiateTestDatabase() throws ParseException {
		
		//Estado
		Estado est1 = new Estado(1, "Rio de Janeiro", "RJ");
		Estado est2 = new Estado(101, "Acre", "AC");
		Estado est3 = new Estado(102, "Alagoas", "AL");
		Estado est4 = new Estado(103, "Amapá", "AP");
		Estado est5 = new Estado(104, "Amazonas", "AM");
		Estado est6 = new Estado(105, "Bahia", "BA");
		Estado est7 = new Estado(106, "Ceará", "CE");
		Estado est8 = new Estado(107, "Distrito Federal", "DF");
		Estado est9 = new Estado(108, "Espírito Santo", "ES");
		Estado est10 = new Estado(109, "Goiás", "GO");
		Estado est11 = new Estado(110, "Maranhão", "MA");
		Estado est12 = new Estado(111, "Mato Grosso", "MT");
		Estado est13 = new Estado(112, "Mato Grosso do Sul", "MS");
		Estado est14 = new Estado(113, "Minas Gerais", "MG");
		Estado est15 = new Estado(114, "Pará", "PA");
		Estado est16 = new Estado(115, "Paraíba", "PB");
		Estado est17 = new Estado(116, "Paraná", "PR");
		Estado est18 = new Estado(117, "Pernambuco", "PE");
		Estado est19 = new Estado(118, "Piauí", "PI");
		Estado est20 = new Estado(119, "Rio Grande do Norte", "RN");
		Estado est21 = new Estado(120, "Rio Grande do Sul", "RS");
		Estado est22 = new Estado(121, "Rondônia", "RO");
		Estado est23 = new Estado(122, "Roraima", "RR");
		Estado est24 = new Estado(123, "Santa Catarina", "SC");
		Estado est25 = new Estado(124, "São Paulo", "SP");
		Estado est26 = new Estado(125, "Sergipe", "SE");
		Estado est27 = new Estado(126, "Tocantins", "TO");			
		estadoRepository.saveAll(Arrays.asList(est1,est2,est3,est4,est5,est6,est7,est8,est9,est10,est11,est12,est13,est14,est15,est16,est17,est18,est19,est20,est21,est22,est23,est24,est25,est26,est27));
		
		//Pessoa - Pessoas que se logam para exercer atividades especificas
		Pessoa pes1 = new Pessoa(1, null, "Alex Cunha", "lekcunha@gmail.com", "acunha", bCrypt.encode("123"), null, 1, null, Perfil.ADMIN);		
		Pessoa pes2 = new Pessoa(2, null, "Felipe", "fmesy@outlook.com", "fmes", bCrypt.encode("123"), null, 1, null, Perfil.ADMIN);
		Pessoa pes3 = new Pessoa(3, null, "Admin", null, "admin", bCrypt.encode("123"), null, 1, null, Perfil.ADMIN);
		Pessoa pes4 = new Pessoa(4, null, "Gestor", null, "gestor", bCrypt.encode("123"), null, 1, null, Perfil.GESTOR);
		Pessoa pes5 = new Pessoa(5, null, "Atendente", null, "atend", bCrypt.encode("123"), null, 1, null, Perfil.ATENDENTE);
		
		//Save Pessoa
		pessoaRepository.saveAll(Arrays.asList(pes1,pes2,pes3,pes4,pes5)); 
	}	
}
