package administradorUsers.controllers;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import administradorUsers.consta.ErrorConstantes;
import administradorUsers.entitys.RolesUsuario;
import administradorUsers.entitys.Usuario;
import administradorUsers.services.UserService;
import administradorUsers.services.imp.RolesUsuarioServiceImpl;
import administradorUsers.utils.BCryptPasswordEncoder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@RestController
public class LoginController {

	
	@Value("${jwt.key}")
	private String secretKey;
	
	@Value("${jwt.expiration}")
	private long timeExpiration;
	
	@Autowired
	UserService usuarioRepository;
	
	@Autowired
	RolesUsuarioServiceImpl rolesUsuarioServiceImpl;
	

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Usuario userIn)  {    	
    		  	
    	Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(userIn.getEmail());   	
    	
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    		
    	if(usuarioOpt.isPresent()) {   
    		
    		Usuario usuario = usuarioOpt.get();
    		// ** verificar password *** 
    		boolean isPasswordMatch = passwordEncoder.matches(userIn.getPassword(), usuario.getPassword());  		
        	if ( ! isPasswordMatch) {
				return ResponseEntity.status(422)
						.body(ErrorConstantes.NO_EXISTE_EL_USUARIO_O_CREDECIALES_INVALIDAS.toString());
        	}
    		// ***********
    		
    		//buscamos los roles del usuarios x sistema
    		List<RolesUsuario> roles = rolesUsuarioServiceImpl.findByUsuario(usuarioOpt.get());		
    		if( roles == null || roles.size() == 0) {
				return ResponseEntity.status(422)
						.body(ErrorConstantes.NO_EXISTE_ROLES_USUARIOS.toString());
    		}
    		
    		
    		String rolesIn = "" ;
		
			  for( RolesUsuario rol : roles) { 
				  rolesIn = rolesIn + rol.getRolesSistema().getId().getNombreRol() +",";
						  }
			  
			  rolesIn = rolesIn.substring(0, rolesIn.length()-1);
			
    		

      
        	String token = getJWTToken(usuario.getEmail(), rolesIn);        	
        	usuario.setToken(token);
        	usuario.setPassword(null);
    		//usuario.get().builderDto()
    		return ResponseEntity.ok(usuario);
    	}else {
    		return ResponseEntity.status(202).build();
    	}

    }
    
    
   
    
	private String getJWTToken(String username , String roles) {
		
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(roles);
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + timeExpiration))
				.signWith(SignatureAlgorithm.HS512,
						this.secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

	
}