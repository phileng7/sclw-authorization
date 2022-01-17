package com.sclw.service;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sclw.dto.LoginDTO;
import com.sclw.dto.TokenDTO;
import com.sclw.exception.AuthorizationException;
import com.sclw.exception.ObjectNotFoundException;
import com.sclw.model.Pessoa;
import com.sclw.repository.PessoaRepository;
import com.sclw.util.JwtUtil;

@Service
public class LoginService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired 
	BCryptPasswordEncoder bCrypt;
	
	public TokenDTO validateLogin(LoginDTO userLogin) {
		
		if (userLogin.getUsername()==null || userLogin.getSenha()==null)
			throw new ObjectNotFoundException("Authorization-login/senha com valor nulo");
		
		Decoder decoder = Base64.getDecoder();
		byte[] decodedByteUsername = decoder.decode(userLogin.getUsername());
		String decodedStringUsername = new String(decodedByteUsername);

		byte[] decodedByteSenha = decoder.decode(userLogin.getSenha());
		String decodedStringSenha = new String(decodedByteSenha);
		
		Pessoa pessoa = pessoaRepository.findByUsuario(decodedStringUsername);
		if (pessoa==null)
			throw new ObjectNotFoundException("Authorization-Usuario nao encontrado");
		
		if (!bCrypt.matches(decodedStringSenha, pessoa.getSenha())) {
			throw new AuthorizationException("Authorization-Login/Senha invalido");
		}
		
		//Set<Perfil> perfis = perf.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
		//sem Brackets [  e ]
		String perfil = pessoa.getPerfis().stream().map(s -> s.toString()).collect(Collectors.joining(","));
		
		TokenDTO tokenDTO = new TokenDTO(pessoa.getUsuario(),jwtUtil.generateToken(decodedStringUsername), perfil, pessoa.getId());
		
		return tokenDTO;
	}
}
