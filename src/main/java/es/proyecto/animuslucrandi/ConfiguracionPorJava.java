package es.proyecto.animuslucrandi;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RepositorySearchesResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.proyecto.animuslucrandi.entidades.AsociacionConId;
import es.proyecto.animuslucrandi.rest.AsociacionController;



@Configuration
@ComponentScan("es.proyecto.animuslucrandi")
public class ConfiguracionPorJava {

  @Bean
  public ObjectMapper getObjectMapper() {

    ObjectMapper mapper = new ObjectMapper();

    return mapper;
  }      
 
  @Bean
  CorsFilter corsFilter() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    final CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(false);
    //config.setAllowCredentials(true);
    config.setAllowedOrigins(Collections.singletonList("*"));
    config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
    config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
    source.registerCorsConfiguration("/**", config);

    return new CorsFilter(source);
  }
  
  @Bean
  RepresentationModelProcessor<RepositorySearchesResource> addSearchLinks(RepositoryRestConfiguration config) {
      Map<Class<?>, Class<?>> controllersRegistrados = new HashMap<>();
      
      controllersRegistrados.put(AsociacionConId.class, AsociacionController.class);

      return new RepresentationModelProcessor<RepositorySearchesResource>() {

          @Override
          public RepositorySearchesResource process(RepositorySearchesResource searchResource) {
              if (controllersRegistrados.containsKey(searchResource.getDomainType())) {
                  Method[] metodos = controllersRegistrados.get(searchResource.getDomainType()).getDeclaredMethods();
                  for (Method m : metodos) {
                      if (!m.isAnnotationPresent(ResponseBody.class)) {
                          continue;
                      }
                      try {
                          URI uri = linkTo(m).toUri();
                          String path = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(),
                                  config.getBasePath() + uri.getPath(), null, null).toString();
                          path = URLDecoder.decode(path, "UTF-8");
                          String requestParams = Stream.of(m.getParameters())
                                  .filter(p -> p.isAnnotationPresent(RequestParam.class))
                                  .map(Parameter::getName)
                                  .collect(Collectors.joining(","));
                          searchResource.add(Link.of(path + "{?" + requestParams + "}", m.getName()));
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }
              }

              return searchResource;
          }

      };
  }

  
}
